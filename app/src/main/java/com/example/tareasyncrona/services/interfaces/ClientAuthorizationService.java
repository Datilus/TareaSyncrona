package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;

import java.util.ArrayList;

public interface ClientAuthorizationService {
    ArrayList<ClientAuthorization> fetch();

    void addList(ArrayList<ClientAuthorization> clientAuthorizations);
}
