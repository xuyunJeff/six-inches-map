package com.six.map.modules.sys.controller;

import com.six.map.modules.sys.entity.LoginRequest;
import com.six.map.modules.sys.entity.SysUserEntity;
import com.six.map.modules.sys.service.SysUserService;
import com.six.map.common.entity.R;
import com.six.map.common.utils.JwtUtils;
import com.google.code.kaptcha.Constants;
import com.six.map.common.annotation.SysLog;
import com.six.map.common.support.properties.GlobalProperties;
import com.six.map.common.utils.MD5Utils;
import com.six.map.common.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;


/**
 * 用户controller
 *
 * @author zcl<yczclcn@163.com>
 */
@Controller
public class SysLoginController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private GlobalProperties globalProperties;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        if (ShiroUtils.isLogin() || ShiroUtils.getUserEntity() != null) {
            return redirect("/");
        }
        return html("/login");
    }

    /**
     * 登录
     */
    @SysLog("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model) {
        String username = getParam("username").trim();
        String password = getParam("password").trim();
        try {
            // 开启验证码
            if (globalProperties.isKaptchaEnable()) {
                String code = getParam("code").trim();
                if (StringUtils.isBlank(code)) {
                    model.addAttribute("errorMsg", "验证码不能为空");
                    return html("/login");
                }
                String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
                if (!code.equalsIgnoreCase(kaptcha)) {
                    model.addAttribute("errorMsg", "验证码错误");
                    return html("/login");
                }
            }
            // 用户名验证
            if (StringUtils.isBlank(username)) {
                model.addAttribute("errorMsg", "用户名不能为空");
                return html("/login");
            }
            // 密码验证
            if (StringUtils.isBlank(password)) {
                model.addAttribute("errorMsg", "密码不能为空");
                return html("/login");
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.encrypt(username, password));
            ShiroUtils.getSubject().login(token);
            SecurityUtils.getSubject().getSession().setAttribute("sessionFlag", true);
            return redirect("/");
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            model.addAttribute("errorMsg", e.getMessage());
        } catch (AuthenticationException e) {
            model.addAttribute("errorMsg", "登录服务异常");
        }
        return html("/login");
    }


    @SysLog("新用户注册")
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public R save(@ModelAttribute SysUserEntity user) {
        user.setOrgId(3L);
        user.setOrgName("rmi001");
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setRoleIdList(Collections.singletonList(7L));
        user.setStatus(1);
        // 0 : 自己创建
        user.setUserIdCreate(0L);
        try {
            return sysUserService.saveUser(user);
        }catch (DuplicateKeyException e){
            return R.error(user.getUsername() +" 用户已存在" );
        }

    }


    /**
     * 登录
     */
    @SysLog("登录")
    @RequestMapping(value = "/wap/login", method = {RequestMethod.POST})
    @ResponseBody
    public R wapLogin(@ModelAttribute LoginRequest loginRequest) {
        String username = loginRequest.getUsername().trim();
        String password = loginRequest.getPassword().trim();
        try {
            // 用户名验证
            if (StringUtils.isBlank(username)) {
                return R.error("用户名不能为空");
            }
            // 密码验证
            if (StringUtils.isBlank(password)) {
                return R.error("密码不能为空");
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.encrypt(username, password));
            ShiroUtils.getSubject().login(token);
            SecurityUtils.getSubject().getSession().setAttribute("sessionFlag", true);
            SysUserEntity user = getUser();
            user.setPassword(null);
            user.setRoleIdList(null);
            user.setRemark(null);
            user.setOrgName(null);
            user.setOrgId(null);
            user.setUserIdCreate(null);
            user.setStatus(null);
            user.setRoleNameList(null);
            user.setJSESSIONID(SecurityUtils.getSubject().getSession().getId().toString());
            return R.ok("登录成功").put("data",user);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return R.error( e.getMessage());
        } catch (AuthenticationException e) {
            return R.error( "登录服务异常");
        }
    }
    /**
     * 跳转后台控制台
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return html("/index");
    }

    /**
     * 退出
     */
    @SysLog("退出系统")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return html("/login");
    }

}
