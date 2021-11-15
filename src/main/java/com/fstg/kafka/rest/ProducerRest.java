package com.fstg.kafka.rest;

import com.fstg.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ProducerRest {
    @Autowired
    private ProducerService producerService;
    @GetMapping("/{firstName}/{lastName}")
    public void sendMessage(@PathVariable String firstName,@PathVariable String lastName){
        System.out.println("the message received is");
        producerService.sendMessage(firstName,lastName);
    }
}
