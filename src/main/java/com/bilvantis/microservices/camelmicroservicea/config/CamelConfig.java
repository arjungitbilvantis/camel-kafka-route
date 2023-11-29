package com.bilvantis.microservices.camelmicroservicea.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.camel.CamelContext;
import org.apache.camel.Configuration;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Configuration
public class CamelConfig {

    @Autowired
    private CamelContext camelContext;

    @PostConstruct
    public void postConstruct() {
        // Log the Camel context status
        System.out.println("Camel Context Status: " + camelContext.getStatus());
    }

    @PreDestroy
    public void preDestroy() {
        // Log the Camel context status before shutting down
        System.out.println("Camel Context Status before shutdown: " + camelContext.getStatus());
    }

    @Bean
    public ProducerTemplate producerTemplate() {
        camelContext.start();
        return camelContext.createProducerTemplate();
    }
}
