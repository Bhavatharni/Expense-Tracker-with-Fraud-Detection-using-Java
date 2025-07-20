package com.example.demo.service;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final FraudDetectionService fraudDetectionService;

    public ExpenseService(ExpenseRepository expenseRepository, FraudDetectionService fraudDetectionService) {
        this.expenseRepository = expenseRepository;
        this.fraudDetectionService = fraudDetectionService;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense) {
        boolean isFraud = fraudDetectionService.detectFraud(expense);
        expense.setFlaggedFraud(isFraud);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
