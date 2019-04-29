package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.ClientExhibitor;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientExhibitorService {
    ResponseDataWithCode<ArrayList<ClientExhibitor>> fetch();

    void addList(ArrayList<ClientExhibitor> clientExhibitors);
}