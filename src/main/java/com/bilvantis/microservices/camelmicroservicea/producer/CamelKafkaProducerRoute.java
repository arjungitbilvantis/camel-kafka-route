package com.bilvantis.microservices.camelmicroservicea.producer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class CamelKafkaProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:customer")
                .log("Sending message before Json conversion: ${body}")
                .marshal().json(JsonLibrary.Jackson, String.class)
                .log("Sending message: ${body}")
                .to("kafka:my-topic?brokers=localhost:9092");
    }
}
