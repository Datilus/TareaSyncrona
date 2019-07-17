package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ClientAuthorization;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ClientAuthorizationService {
    ResponseDataWithCode<ArrayList<ClientAuthorization>> fetch();

    void addList(ArrayList<ClientAuthorization> clientAuthorizations);

    void addObject(ClientAuthorization clientAuthorization);
}
