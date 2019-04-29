package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.ClientProductBonification;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ClientProductBonificationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientProductBonificationServiceImpl implements ClientProductBonificationService {

    private static ClientProductBonificationServiceImpl instance;

    private ClientProductBonificationServiceImpl(){

    }

    public static ClientProductBonificationServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientProductBonificationServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientProductBonification>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/productsbonifications")
                .build();

        ANResponse<ResponseList<ClientProductBonification>> response = request.executeForObject(ResponseList.class);

        ArrayList<ClientProductBonification> clientProductBonifications = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            clientProductBonifications = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<ClientProductBonification>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(clientProductBonifications, 102, message);
        }

        return new ResponseDataWithCode<>(clientProductBonifications, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<ClientProductBonification> clientProductBonifications) {

    }
}
