package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Charge;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ChargeService {
    ResponseDataWithCode<ArrayList<Charge>> fetch();

    void addList(ArrayList<Charge> charges);
}
