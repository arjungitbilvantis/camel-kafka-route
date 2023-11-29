package com.bilvantis.microservices.camelmicroservicea.controller;

import com.bilvantis.microservices.camelmicroservicea.DTO.CustomerDTO;
import com.bilvantis.microservices.camelmicroservicea.service.CustomerService;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService<CustomerDTO, Long> customerService;


    @Autowired
    private ProducerTemplate producerTemplate;


    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            producerTemplate.sendBody("direct:customer", customerDTO);
            return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            // Log or handle the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
