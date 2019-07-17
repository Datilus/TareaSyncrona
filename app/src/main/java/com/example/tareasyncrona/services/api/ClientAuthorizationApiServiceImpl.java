package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ClientAuthorization;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ClientAuthorizationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientAuthorizationApiServiceImpl implements ClientAuthorizationService {

    private static ClientAuthorizationApiServiceImpl instance;

    private ClientAuthorizationApiServiceImpl() {
    }

    public static ClientAuthorizationApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientAuthorizationApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientAuthorization>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/authorizations";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(ClientAuthorization clientAuthorization) {

    }
}
