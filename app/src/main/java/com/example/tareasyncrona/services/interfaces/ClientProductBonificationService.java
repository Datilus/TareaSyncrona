package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.ClientProductBonification;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientProductBonificationService {

    ResponseDataWithCode<ArrayList<ClientProductBonification>> fetch();

    void addList(ArrayList<ClientProductBonification> clientProductBonifications);
}
