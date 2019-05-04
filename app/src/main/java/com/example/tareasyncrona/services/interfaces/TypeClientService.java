package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.TypeClient;

import java.util.ArrayList;

public interface TypeClientService {
    ResponseDataWithCode<ArrayList<TypeClient>> fetch();

    void addList(ArrayList<TypeClient> typeClients);
}
