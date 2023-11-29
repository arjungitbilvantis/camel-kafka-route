package com.bilvantis.microservices.camelmicroservicea.service.Impl;

import com.bilvantis.microservices.camelmicroservicea.DTO.CustomerDTO;
import com.bilvantis.microservices.camelmicroservicea.entity.Customer;
import com.bilvantis.microservices.camelmicroservicea.repository.CustomerRepo;
import com.bilvantis.microservices.camelmicroservicea.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bilvantis.microservices.camelmicroservicea.util.CustomerSupport.convertCustomerDTOToCustomerEntity;
import static com.bilvantis.microservices.camelmicroservicea.util.CustomerSupport.convertCustomerEntityToCustomerDTO;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService<CustomerDTO, Long> {


    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = convertCustomerDTOToCustomerEntity(customerDTO);
        customer = customerRepo.save(customer);
        return convertCustomerEntityToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(Long aLong) {
        return null;
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDTO customer) {

    }
}
