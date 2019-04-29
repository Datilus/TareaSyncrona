package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Cedi;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface CediService {

    ResponseDataWithCode<Cedi> fetch();

    void addList(ArrayList<Cedi> cedis);

    void addObject(Cedi cedi);
}
