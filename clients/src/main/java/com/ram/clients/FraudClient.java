package com.ram.clients;


import org.springframework.web.bind.annotation.PathVariable;


public interface fraud {

    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
