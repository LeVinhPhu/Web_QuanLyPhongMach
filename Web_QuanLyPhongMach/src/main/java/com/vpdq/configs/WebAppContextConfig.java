/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author vinhp
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.vpdq.controllers",
    "com.vpdq.repository",
    "com.vpdq.service"
})
public class WebAppContextConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }
    
    
//    //Tao View (chỉ sử dụng khi viết header, footer, content vào 1 file .jsp)
//    @Bean
//    public InternalResourceViewResolver viewResolver ()
//    {
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        
//        r.setPrefix("/WEB-INF/jsp/"); // set cho chua view
//        r.setSuffix(".jsp"); // set hau to file
//        r.setViewClass(JstlView.class);
//        
//        return r;
//    }
    
}
