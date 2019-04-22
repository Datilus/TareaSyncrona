package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.TypeClientService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TypeClientServiceImpl implements TypeClientService {

    private static TypeClientServiceImpl instance;

    private TypeClientServiceImpl() {
    }

    public static TypeClientServiceImpl getInstance() {
        if (instance == null)
            instance = new TypeClientServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<TypeClient>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/types_clients")
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

        if (response.getOkHttpResponse() == null){
            return new ResponseDataWithCode<>(typeClients, 102, message);
        }

        return new ResponseDataWithCode<>(typeClients, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<TypeClient> typeClients) {

    }
}
