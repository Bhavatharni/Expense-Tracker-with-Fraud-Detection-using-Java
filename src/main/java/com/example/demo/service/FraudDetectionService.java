package com.example.demo.service;

import com.example.demo.model.Expense;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {
    public boolean detectFraud(Expense expense) {
        // Dummy logic: Flag if amount > 10000
        return expense.getAmount() != null && expense.getAmount() > 10000;
    }
}
