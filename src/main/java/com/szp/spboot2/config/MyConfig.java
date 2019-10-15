package com.szp.spboot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyConfigBean myconfig(){
        return new MyConfigBean();
    }
}
