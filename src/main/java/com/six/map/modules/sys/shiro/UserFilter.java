package com.six.map.modules.sys.shiro;

import com.six.map.common.entity.R;
import com.six.map.common.utils.JSONUtils;
import com.six.map.common.utils.ResponseWebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理ajax请求session过期
 *
 * @author zcl<yczclcn@163.com>
 */
public class UserFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = getSubject(request, response);
            return subject.getPrincipal() != null;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        /**
         * 如果是ajax请求则不进行跳转
         */
        if (ResponseWebUtils.isAjax(httpServletRequest)) {
            httpServletResponse.setHeader("sessionstatus", "timeout");

            R timeout = R.error(401, "登录超时，请重新登录");
            ResponseWebUtils.write(httpServletResponse, JSONUtils.beanToJson(timeout));
            return false;
        } else {

            /**
             * 第一次点击页面
             */
            String referer = httpServletRequest.getHeader("Referer");
            if (referer == null) {
                saveRequestAndRedirectToLogin(request, response);
                return false;
            } else {

                /**
                 * 从别的页面跳转过来的
                 */
                if (SecurityUtils.getSubject().getSession().getAttribute("sessionFlag") == null) {
                    httpServletRequest.setAttribute("errorMsg", "登录超时，请重新登录");
                    httpServletRequest.getRequestDispatcher("/login").forward(request, response);
                    return false;
                } else {
                    saveRequestAndRedirectToLogin(request, response);
                    return false;
                }
            }
        }
    }
}
