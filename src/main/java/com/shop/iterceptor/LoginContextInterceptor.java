package com.shop.iterceptor;

import com.shop.config.JwtUtils;
import com.shop.config.PrintHttpUtils;
import com.shop.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截
 *
 */
public class LoginContextInterceptor implements HandlerInterceptor {
    @Autowired
    private PrintHttpUtils printHttpUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfoVo userInfoVo = JwtUtils.getMemberIdByJwtToken(request);
        if (userInfoVo == null) {
            Result<Object> result = new Result<>("未登录", "-1");
            printHttpUtils.print(response, result);
            return false;
        }
        return true;
    }
}
