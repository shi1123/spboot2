package com.szp.spboot2.controller;

import com.szp.spboot2.config.MyConfigBean;
import com.szp.spboot2.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyController {
    @Value("${myConfig.myObject.myName}")
    private String myName;
    @Value("${myConfig.myObject.myAge}")
    private int myAge;
    @Autowired
    private MyConfigBean myConfigBean;


    @RequestMapping(value="/test", method = RequestMethod.GET)
    public Object getPerson(){
        Person person = new Person();
        person.setId(myConfigBean.getMyAge());
        person.setName(myConfigBean.getMyName());
        person.setBirthday(new Date());

        return person;
    }
}
