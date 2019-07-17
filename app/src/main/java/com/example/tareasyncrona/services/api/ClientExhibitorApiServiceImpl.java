package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ClientExhibitor;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ClientExhibitorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientExhibitorApiServiceImpl implements ClientExhibitorService {

    private static ClientExhibitorApiServiceImpl instance;

    private ClientExhibitorApiServiceImpl() {
    }

    public static ClientExhibitorApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientExhibitorApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientExhibitor>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/exhibitors";
        ANRequest request = AndroidNetworking.get(URL)
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

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(clientExhibitors, 102, message);
        }
        return new ResponseDataWithCode<>(clientExhibitors, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<ClientExhibitor> clientExhibitors) {

    }

    @Override
    public void addObject(ClientExhibitor clientExhibitor) {

    }
}
