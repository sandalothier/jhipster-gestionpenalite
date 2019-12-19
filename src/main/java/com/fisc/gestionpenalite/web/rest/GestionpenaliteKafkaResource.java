package com.fisc.gestionpenalite.web.rest;

import com.fisc.gestionpenalite.service.GestionpenaliteKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gestionpenalite-kafka")
public class GestionpenaliteKafkaResource {

    private final Logger log = LoggerFactory.getLogger(GestionpenaliteKafkaResource.class);

    private GestionpenaliteKafkaProducer kafkaProducer;

    public GestionpenaliteKafkaResource(GestionpenaliteKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
