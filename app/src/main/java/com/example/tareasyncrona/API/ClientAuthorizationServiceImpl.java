package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ClientAuthorizationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientAuthorizationServiceImpl implements ClientAuthorizationService {

    private static ClientAuthorizationServiceImpl instance;

    private ClientAuthorizationServiceImpl(){}

    public static ClientAuthorizationServiceImpl getInstance(){
        if (instance == null)
            instance = new ClientAuthorizationServiceImpl();
        return instance;
    }

    @Override
    public ArrayList<ClientAuthorization> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/authorizations")
                .build();

        ANResponse<ResponseList<ClientAuthorization>> response = request.executeForObject(ResponseList.class);

        ArrayList<ClientAuthorization> clientAuthorizations = null;

        if (response.isSuccess() && response.getResult().getData() != null) {
            clientAuthorizations = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<ClientAuthorization>>() {
                            }.getType());
        }
        return clientAuthorizations;
    }

    @Override
    public void addList(ArrayList<ClientAuthorization> clientAuthorizations) {

    }
}
