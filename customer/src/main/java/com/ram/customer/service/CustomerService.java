package com.ram.customer.service;

import com.ram.customer.bean.Customer;
import com.ram.customer.bean.FraudCheckResponse;
import com.ram.customer.record.CustomerRequest;
import com.ram.customer.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void register(CustomerRequest customerRequest) {
        Customer customer = Customer.builder().firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName()).email(customerRequest.email()).build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if(fraudCheckResponse!=null && fraudCheckResponse.isFraudster()!=null && fraudCheckResponse.isFraudster()){
             throw new IllegalArgumentException("Fruadster");
        }
    }
}
