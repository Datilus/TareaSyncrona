package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Client;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientService {
    ResponseDataWithCode<ArrayList<Client>> fetch();

    void addList(ArrayList<Client> clients);
}
