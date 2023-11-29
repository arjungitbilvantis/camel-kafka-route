package com.bilvantis.microservices.camelmicroservicea.util;

import com.bilvantis.microservices.camelmicroservicea.DTO.CustomerDTO;
import com.bilvantis.microservices.camelmicroservicea.entity.Customer;

public class CustomerSupport {

    public static CustomerDTO convertCustomerEntityToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }

    public static Customer convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());
        return customer;
    }
}
