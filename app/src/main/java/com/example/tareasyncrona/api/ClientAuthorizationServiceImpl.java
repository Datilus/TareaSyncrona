package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ClientAuthorizationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientAuthorizationServiceImpl implements ClientAuthorizationService {

    private static ClientAuthorizationServiceImpl instance;

    private ClientAuthorizationServiceImpl() {
    }

    public static ClientAuthorizationServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientAuthorizationServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientAuthorization>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/authorizations")
                .build();

        ANResponse<ResponseList<ClientAuthorization>> response = request.executeForObject(ResponseList.class);

        ArrayList<ClientAuthorization> clientAuthorizations = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            clientAuthorizations = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<ClientAuthorization>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(clientAuthorizations, 102, message);
        }
        return new ResponseDataWithCode<>(clientAuthorizations, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<ClientAuthorization> clientAuthorizations) {

    }
}
