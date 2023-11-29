package com.bilvantis.microservices.camelmicroservicea.service;


import com.bilvantis.microservices.camelmicroservicea.DTO.CustomerDTO;

import java.io.Serializable;
import java.util.List;

public interface CustomerService<I extends CustomerDTO, ID extends Serializable> {

    I createCustomer(I customerDTO);

    List<I> getAllCustomers();

    I getCustomerById(ID id);
    void updateCustomer(Long customerId, I customer);
}
