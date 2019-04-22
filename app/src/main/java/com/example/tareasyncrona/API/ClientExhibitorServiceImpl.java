package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.ClientExhibitor;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ClientExhibitorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientExhibitorServiceImpl implements ClientExhibitorService {

    private static ClientExhibitorServiceImpl instance;

    private ClientExhibitorServiceImpl(){}

    public static ClientExhibitorServiceImpl getInstance(){
        if (instance == null)
            instance = new ClientExhibitorServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientExhibitor>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/exhibitors")
                .build();

        ANResponse<ResponseList<ClientExhibitor>> response = request.executeForObject(ResponseList.class);

        ArrayList<ClientExhibitor> clientExhibitors = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            clientExhibitors = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<ClientExhibitor>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null){
            return new ResponseDataWithCode<>(clientExhibitors, 102, message);
        }
        return new ResponseDataWithCode<>(clientExhibitors, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<ClientExhibitor> clientExhibitors) {

    }
}
