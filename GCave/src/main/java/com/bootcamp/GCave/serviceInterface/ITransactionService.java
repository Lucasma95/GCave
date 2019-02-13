package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> findAll();

    Transaction findById(Long id);

    void save(Transaction transaction);

    void deleteById(Long id);

    boolean validateTransactionExist(Long id);


}
