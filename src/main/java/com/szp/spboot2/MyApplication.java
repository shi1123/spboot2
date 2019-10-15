package com.szp.spboot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/*
* Thymeleaf
* JDWP: Java Debug Wire Protocol
* */
@SpringBootApplication
public class MyApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @PostConstruct
    public void myLog(){
        logger.trace("trace output");
        logger.debug("debug output");
        logger.warn("warn output");
        logger.info("info output");
        logger.error("error outout");
//        logger.trace("trace debug");
    }
}
