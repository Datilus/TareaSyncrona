package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Folio;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface FolioService {
    ResponseDataWithCode<ArrayList<Folio>> fetch();

    void addList(ArrayList<Folio> folios);
}
