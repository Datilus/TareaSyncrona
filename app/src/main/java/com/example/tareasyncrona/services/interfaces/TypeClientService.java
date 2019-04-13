package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.TypeClient;

import java.util.ArrayList;

public interface TypeClientService {
    ArrayList<TypeClient> fetch();
    void addList(ArrayList<TypeClient> typeClients);
}
