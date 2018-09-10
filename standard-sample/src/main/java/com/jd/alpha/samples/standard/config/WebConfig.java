package com.jd.alpha.samples.standard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web 配置类
 *
 * @author cdyangyang18
 */
@Configuration
@ControllerAdvice
public class WebConfig extends WebMvcConfigurerAdapter {

}
