package com.szp.spboot2.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics="myTopic", groupId = "myGroup")
    public void obtainMessage(ConsumerRecord<String, String> consumerRecord){
        System.out.println("message recievec!");
        String topic = consumerRecord.topic();
        String key = consumerRecord.key();
        String value = consumerRecord.value();
        int partition = consumerRecord.partition();
        long timeStamp = consumerRecord.timestamp();

        System.out.println(" topic" + topic);
        System.out.println("key " + key);
        System.out.println("value " + value);
        System.out.println("partition " + partition);
        System.out.println("timeStamp " + timeStamp);
        System.out.println(" ");
    }
}
