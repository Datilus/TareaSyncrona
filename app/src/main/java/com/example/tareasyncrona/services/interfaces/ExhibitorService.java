package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Exhibitor;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ExhibitorService {
    ResponseDataWithCode<ArrayList<Exhibitor>> fetch();

    void addList(ArrayList<Exhibitor> exhibitors);
}
