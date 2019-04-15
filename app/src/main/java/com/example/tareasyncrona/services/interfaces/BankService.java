package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Bank;

import java.util.ArrayList;

public interface BankService {
    ArrayList<Bank> fetch();

    void addList(ArrayList<Bank> banks);
}
