package com.six.map.modules.sys.controller;


import com.six.map.common.utils.ResponseWebUtils;
import com.six.map.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.six.map.common.utils.ShiroUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller公共组件
 *
 * @author zcl<yczclcn@163.com>
 */
public abstract class AbstractController {

    /**
     * 日志
     */
    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 获取参数
     *
     * @param name 请求参数名称
     * @return 请求参数值
     */
    protected String getParam(String name) {
        return ResponseWebUtils.getRequest().getParameter(name);
    }

    /**
     * 设置属性
     *
     * @param key   属性名
     * @param value 属性值
     */
    protected void setAttr(String key, Object value) {
        ResponseWebUtils.getRequest().setAttribute(key, value);
    }

    /**
     * 获取httpServletRequest
     *
     * @return HttpServletRequest
     */
    protected HttpServletRequest getHttpServletRequest() {
        return ResponseWebUtils.getRequest();
    }

    /**
     * 获取httpServletResponse
     *
     * @return HttpServletResponse
     */
    protected HttpServletResponse getHttpServletResponse() {
        return ResponseWebUtils.getResponse();
    }

    /**
     * 获取session：如果当前请求没有session，则创建一个
     *
     * @return HttpSession
     */
    protected HttpSession getSession() {
        return ResponseWebUtils.getRequest().getSession();
    }

    /**
     * 获取session：如果当前请求没有session，true则创建一个，false则返回null
     *
     * @param create 是否创建，true：创建，false：不创建，返回null
     * @return HttpSession
     */
    protected HttpSession getSession(boolean create) {
        return ResponseWebUtils.getRequest().getSession(create);
    }

    /**
     * 获取当前用户entity
     *
     * @return SysUserEntity
     */
    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    /**
     * 获取当前用户id
     *
     * @return 用户id
     */
    protected Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * 重定向
     *
     * @param page
     * @return 重定向全路径
     */
    protected String redirect(String page) {
        return "redirect:".concat(page);
    }

    /**
     * beetl视图
     *
     * @param page
     * @return html全路径
     */
    protected String html(String page) {
        return page.concat(".html");
    }

}
