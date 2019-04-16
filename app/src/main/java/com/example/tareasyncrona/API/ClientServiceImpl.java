package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Client;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ClientService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    private static ClientServiceImpl instance;

    private ClientServiceImpl(){}

    public static ClientServiceImpl getInstance(){
        if (instance == null)
            instance = new ClientServiceImpl();
        return instance;
    }

    @Override
    public ArrayList<Client> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/clients")
                .build();

        ANResponse<ResponseList<Client>> response = request.executeForObject(ResponseList.class);

        ArrayList<Client> clients = null;

        if (response.isSuccess() && response.getResult().getData() != null) {
            clients = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Client>>() {
                            }.getType());
        }
        return clients;
    }

    @Override
    public void addList(ArrayList<Client> clients) {

    }
}