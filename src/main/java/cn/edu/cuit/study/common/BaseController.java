package cn.edu.cuit.study.common;


import cn.edu.cuit.study.constant.SessionNames;
import cn.edu.cuit.study.entity.User;
import cn.edu.cuit.study.utils.HttpContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 所有controller的基类
 *
 * @author Flemming
 * @since 2018年6月15日
 */
public abstract class BaseController {


    /**
     * 获取request
     *
     * @return
     */
    protected HttpServletRequest getRequest() {
        return HttpContextUtils.getHttpServletRequest();
    }

    /**
     * 获取response
     *
     * @return
     */
    protected HttpServletResponse getResponse() {
        return HttpContextUtils.getHttpServletResponse();
    }

    /**
     * 获取session
     *
     * @return
     */
    protected HttpSession getSession() {
        return HttpContextUtils.getSession();
    }


    /**
     * 获取参数
     *
     * @param name 参数名
     * @return
     */
    protected String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取当前用户
     *
     * @return
     */
    protected User getCurrentUser() {
        HttpSession session = getSession();
        return session == null ? null : (User) session.getAttribute(SessionNames.SESSION_KEY_USER);
    }

    /**
     * 根据key获取Cookie的值
     *
     * @param key
     * @return value
     */
    protected String getCookieValue(String key) {
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    protected void removeCookies(){
        Cookie[] cookies = getRequest().getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            getResponse().addCookie(cookie);
        }
    }

    protected boolean isCookie(String key){
        return "".equals(getCookieValue(key));
    }

}
