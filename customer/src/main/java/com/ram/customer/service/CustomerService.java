package com.ram.customer.service;

import com.ram.clients.fraud.FraudCheckResponse;
import com.ram.clients.fraud.FraudClient;
import com.ram.clients.notification.NotificationClient;
import com.ram.customer.bean.Customer;
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

    @Autowired
    private FraudClient fraudClient;

    @Autowired
    private NotificationClient notificationClient;

    public void register(CustomerRequest customerRequest) {
        Customer customer = Customer.builder().firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName()).email(customerRequest.email()).build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse!=null && fraudCheckResponse.isFraudster()!=null && fraudCheckResponse.isFraudster()){
             throw new IllegalArgumentException("Fruadster");
        }else{
            notificationClient.sendNotification(customer.getId());
        }


    }
}
