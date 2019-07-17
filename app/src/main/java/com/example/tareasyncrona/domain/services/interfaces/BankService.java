package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Bank;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface BankService {
    ResponseDataWithCode<ArrayList<Bank>> fetch();

    void addList(ArrayList<Bank> banks);

    void addObject(Bank bank);
}
