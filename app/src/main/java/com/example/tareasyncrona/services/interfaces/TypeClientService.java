package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;

import java.util.ArrayList;

public interface TypeClientService {
    ResponseDataWithCode<ArrayList<TypeClient>> fetch();

    void addList(ArrayList<TypeClient> typeClients);
}
