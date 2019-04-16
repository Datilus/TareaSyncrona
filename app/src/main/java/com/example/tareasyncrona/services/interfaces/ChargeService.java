package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Charge;

import java.util.ArrayList;

public interface ChargeService {
    ArrayList<Charge> fetch();

    void addList(ArrayList<Charge> charges);
}
