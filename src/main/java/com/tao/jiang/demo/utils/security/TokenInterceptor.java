package com.tao.jiang.demo.utils.security;

import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.repository.token.TokenRepository;
import com.tao.jiang.demo.utils.ConfigurationManager;
import com.tao.jiang.demo.utils.general.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenRepository tokenRepository;

    private Log log = LogFactory.getFactory().getInstance(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) {
        String tokenString = httpServletRequest.getHeader("token");
        String userName = httpServletRequest.getParameter("userName");
        Token token = tokenRepository.findByToken(tokenString);


        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html; charset=utf-8");

        try {

            if (StringUtils.isEmpty(tokenString)) {
                writer = httpServletResponse.getWriter();
                writer.print("Token missing!");
                return false;
            }
            // token not exist
            if (token == null) {
                writer = httpServletResponse.getWriter();
                writer.print("Token not exist!");
                return false;
            }
            // token exist
            else {
                //check if token validate
                if (TimeUtils.tokenValidate(token.getCreateTime(), new Date(), ConfigurationManager.getInstance().getTokenExpirationPeriod())) {
                    //check if token belongs to user
                    if (token.getOwnerName().equals(userName)) {
                        return true;
                    } else {
                        writer = httpServletResponse.getWriter();
                        writer.print("Token not belong to this user!");
                        return false;
                    }
                }
                // not validate
                else {
                    writer = httpServletResponse.getWriter();
                    writer.print("Token expired!");
                    return false;
                }
            }
        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}