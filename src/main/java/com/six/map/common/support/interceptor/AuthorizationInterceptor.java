package com.six.map.common.support.interceptor;

import com.six.map.modules.sys.entity.SysUserEntity;
import com.six.map.modules.sys.service.SysUserService;
import com.six.map.common.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthorizationInterceptor  extends HandlerInterceptorAdapter {

    @Autowired
    SysUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("AuthorizationInterceptor");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SysUserEntity user =  userService.getByUserName(username);
        if(!SystemConstant.RoleEnum.BullOutMerchantServer.getCode().equals(user.getRoleId())){
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
