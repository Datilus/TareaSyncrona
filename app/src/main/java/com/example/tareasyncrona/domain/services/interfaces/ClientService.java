package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Client;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientService {
    ResponseDataWithCode<ArrayList<Client>> fetch();

    void addList(ArrayList<Client> clients);

    void addObject(Client client);
}
