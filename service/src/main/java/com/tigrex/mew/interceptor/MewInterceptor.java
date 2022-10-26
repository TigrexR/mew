package com.tigrex.mew.interceptor;

import lombok.SneakyThrows;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linus
 */
public class MewInterceptor extends HandlerInterceptorAdapter {

    private static final String login = "/user/login";
    private static final String logout = "/user/logout";
    private static final String USER_CODE = "code";

    @Override
    @SneakyThrows(Exception.class)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        if (!login.equals(request.getRequestURI()) && !logout.equals(request.getRequestURI())) {
//            String token = request.getHeader("token");
//            if(StringUtils.isEmpty(token)) {
//                token = request.getParameter("token");
//            }
//            if (StringUtils.isEmpty(token)) {
//                return false;
//            } else {
//                Claims claims = JwtUtils.getClaims(token);
//                if (claims != null) {
//                    // 验证账号
//                    UserVO user = JacksonUtils.getJackson().readValue(JacksonUtils.getJackson().writeValueAsString(claims.get("user")), UserVO.class);
//                    if (!request.getHeader(USER_CODE).equals(user.getCode())) {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
    }
}
