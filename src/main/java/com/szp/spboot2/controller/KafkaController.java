package com.szp.spboot2.controller;

import com.szp.spboot2.kafka.KafkaMessage;
import com.szp.spboot2.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value="/kafka", produces=APPLICATION_JSON_UTF8_VALUE)
public class KafkaController {
    @Autowired
    KafkaProducer kafkaProducer;

    @RequestMapping(value="/message",method = RequestMethod.GET)
    public KafkaMessage sendKafkaMessage(@RequestParam( name="id")long id,
                                 @RequestParam(name="userName") String userName,
                                 @RequestParam(name="password")String password){
        System.out.println("send message to kafka");
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(id);
        kafkaMessage.setName(userName);
        kafkaMessage.setPassword(password);

        kafkaProducer.sendKafkaMessage(kafkaMessage);

        return kafkaMessage;
    }
}
