package com.tao.jiang.demo.config.sso;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.filter.XxlSsoWebFilter;
import com.xxl.sso.core.util.JedisUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XxlSsoConfig implements DisposableBean {

    @Value("${xxl.sso.server}")
    private String xxlSsoServer;

    @Value("${xxl.sso.logout.path}")
    private String xxlSsoLogoutPath;

    @Value("${xxl.sso.redis.address}")
    private String xxlSsoRedisAddress;

    @Value("${xxl-sso.excluded.paths}")
    private String xxlSsoExcludedPaths;

    @Bean
    public FilterRegistrationBean<XxlSsoWebFilter> xxlSsoFilterRegistration() {
        // xxl-sso, redis init
        JedisUtil.init(xxlSsoRedisAddress);
        // xxl-sso, filter init
        FilterRegistrationBean<XxlSsoWebFilter> registration = new FilterRegistrationBean<>();
        registration.setName("XxlSsoWebFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        registration.setFilter(new XxlSsoWebFilter());
        registration.addInitParameter(Conf.SSO_SERVER, xxlSsoServer);
        registration.addInitParameter(Conf.SSO_LOGOUT_PATH, xxlSsoLogoutPath);
        return registration;
    }

    @Override
    public void destroy() throws Exception {
        JedisUtil.close();
    }
}
