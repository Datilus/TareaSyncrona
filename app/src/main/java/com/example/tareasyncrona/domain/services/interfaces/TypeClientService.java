package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.TypeClient;

import java.util.ArrayList;

public interface TypeClientService {
    ResponseDataWithCode<ArrayList<TypeClient>> fetch();

    void addList(ArrayList<TypeClient> typeClients);

    void addObject(TypeClient typeClient);
}
