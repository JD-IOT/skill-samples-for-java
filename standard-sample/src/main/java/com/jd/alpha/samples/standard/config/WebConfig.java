package com.jd.alpha.samples.standard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ControllerAdvice
public class WebConfig extends WebMvcConfigurerAdapter {

}
