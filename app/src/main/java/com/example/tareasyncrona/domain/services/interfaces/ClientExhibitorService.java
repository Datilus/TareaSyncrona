package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ClientExhibitor;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientExhibitorService {
    ResponseDataWithCode<ArrayList<ClientExhibitor>> fetch();

    void addList(ArrayList<ClientExhibitor> clientExhibitors);

    void addObject(ClientExhibitor clientExhibitor);
}
