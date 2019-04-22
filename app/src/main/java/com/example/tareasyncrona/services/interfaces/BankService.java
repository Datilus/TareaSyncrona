package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Bank;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface BankService {
    ResponseDataWithCode<ArrayList<Bank>> fetch();

    void addList(ArrayList<Bank> banks);
}
