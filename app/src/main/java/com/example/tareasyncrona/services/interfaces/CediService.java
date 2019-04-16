package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Cedi;

import java.util.ArrayList;

public interface CediService {
    Cedi fetch();

    void addList(ArrayList<Cedi> cedis);

    void addObject(Cedi cedi);
}
