package com.bootcamp.GCave.service;

import com.bootcamp.GCave.model.Transaction;
import com.bootcamp.GCave.repository.TransactionRepository;
import com.bootcamp.GCave.serviceInterface.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        List<Transaction> users = (List<Transaction>) transactionRepository.findAll();

        return users;
    }

    @Override
    public Transaction findById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        return transaction;
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);

    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);

    }

    @Override
    public boolean validateTransactionExist(Long id) {
        return false;
    }


}
