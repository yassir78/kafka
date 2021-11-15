package com.fstg.kafka.rest;

import com.fstg.kafka.bean.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRest {

    @KafkaListener(topics = "mytopic", groupId = "groupId")
    public void listenGroupFoo(User user) {
        System.out.println("************************************");
        System.out.println("Received Message in group foo: " + user.toString());
    }
}
