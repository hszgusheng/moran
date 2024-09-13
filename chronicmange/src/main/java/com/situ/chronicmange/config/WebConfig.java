package com.situ.chronicmange.config;


import com.situ.chronicmange.intercepor.MyIntercetor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
*
* springMVC拦截配置
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //注入拦截器
    @Autowired
    private MyIntercetor myIntercetor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myIntercetor)
                .addPathPatterns("/**") //拦截路径 (拦截所有页面)
                .excludePathPatterns(//放行路径 放行图片，css，login注册页面
                    "/layui/**",
                    "/img/**",
                    "/login"

                );
    }


}
