package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.TypeClient;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.TypeClientService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TypeClientApiServiceImpl implements TypeClientService {

    private static TypeClientApiServiceImpl instance;

    private TypeClientApiServiceImpl() {
    }

    public static TypeClientApiServiceImpl getInstance() {
        if (instance == null)
            instance = new TypeClientApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<TypeClient>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/types_clients";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<TypeClient>> response = request.executeForObject(ResponseList.class);

        ArrayList<TypeClient> typeClients = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            typeClients = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<TypeClient>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(typeClients, 102, message);
        }

        return new ResponseDataWithCode<>(typeClients, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<TypeClient> typeClients) {

    }

    @Override
    public void addObject(TypeClient typeClient) {

    }
}
