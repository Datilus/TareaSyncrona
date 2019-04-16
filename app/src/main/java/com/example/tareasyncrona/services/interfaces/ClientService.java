package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Client;

import java.util.ArrayList;

public interface ClientService {
    ArrayList<Client> fetch();

    void addList(ArrayList<Client> clients);
}
