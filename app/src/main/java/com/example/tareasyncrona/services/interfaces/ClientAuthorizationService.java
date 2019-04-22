package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientAuthorizationService {
    ResponseDataWithCode<ArrayList<ClientAuthorization>> fetch();

    void addList(ArrayList<ClientAuthorization> clientAuthorizations);
}
