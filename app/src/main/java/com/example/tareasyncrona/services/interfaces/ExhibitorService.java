package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Exhibitor;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ExhibitorService {
    ResponseDataWithCode<ArrayList<Exhibitor>> fetch();

    void addList(ArrayList<Exhibitor> exhibitors);
}
