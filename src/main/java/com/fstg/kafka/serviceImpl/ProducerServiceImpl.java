package com.fstg.kafka.serviceImpl;

import com.fstg.kafka.bean.User;
import com.fstg.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    @Value(value = "${kafka.topicName}")
    private String topicName;

    @Override
    public void sendMessage(String firstName, String lastName) {
        for (int i = 0; i < 10000; i++) {
            this.kafkaTemplate.send(topicName, new User(firstName, lastName));
        }
    }
}
