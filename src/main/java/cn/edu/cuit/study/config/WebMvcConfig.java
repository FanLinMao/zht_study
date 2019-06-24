package cn.edu.cuit.study.config;

import cn.edu.cuit.study.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/getAuthCode","/login.html", "/loginPage", "/loginout","/register.html","/addregister");

    }
}
