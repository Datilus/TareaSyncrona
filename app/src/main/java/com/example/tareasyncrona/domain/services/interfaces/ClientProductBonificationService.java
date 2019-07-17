package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ClientProductBonification;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientProductBonificationService {

    ResponseDataWithCode<ArrayList<ClientProductBonification>> fetch();

    void addList(ArrayList<ClientProductBonification> clientProductBonifications);

    void addObject(ClientProductBonification clientProductBonification);
}
