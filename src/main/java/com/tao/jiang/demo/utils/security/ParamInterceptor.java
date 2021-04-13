package com.tao.jiang.demo.utils.security;

import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.repository.token.TokenRepository;
import com.tao.jiang.demo.utils.ConfigurationManager;
import com.tao.jiang.demo.utils.general.TimeUtils;
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
public class ParamInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenRepository tokenRepository;

    private Log log = LogFactory.getFactory().getInstance(ParamInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //TODO enhance logic
        String tokenString = httpServletRequest.getHeader("token");
        String userName = httpServletRequest.getParameter("userName");
        Token token = tokenRepository.findByToken(tokenString);
        // token not exist
        if (token == null) {
            PrintWriter writer = null;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("text/html; charset=utf-8");
            try {
                writer = httpServletResponse.getWriter();
                String error = "Token not exist!";
                writer.print(error);
                return false;
            } catch (IOException e) {
                log.error("response error", e);
            } finally {
                if (writer != null)
                    writer.close();
                return false;
            }
        }
        // token exist
        else {
            //check if token expire
            if (TimeUtils.timeSlotLongerThan(token.getCreateTime(), new Date(), ConfigurationManager.getInstance().getTokenExpirationPeriod())) {

                return false;
            }
            if (token.getOwnerName().equals(userName)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}