package com.ram.fraud.service;

import com.ram.fraud.data.FraudCheckHistory;
import com.ram.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    @Autowired
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder().customerId(customerId)
        .isFraudster(false).createdAt(LocalDateTime.now()).build());
        return false;
    }
}
