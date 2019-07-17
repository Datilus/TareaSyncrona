package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Charge;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ChargeService {
    ResponseDataWithCode<ArrayList<Charge>> fetch();

    void addList(ArrayList<Charge> charges);

    void addObject(Charge charge);
}
