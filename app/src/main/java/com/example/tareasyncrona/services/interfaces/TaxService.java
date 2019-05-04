package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.Tax;

import java.util.ArrayList;

public interface TaxService {
    ResponseDataWithCode<ArrayList<Tax>> fetch();

    void addList(ArrayList<Tax> taxes);
}
