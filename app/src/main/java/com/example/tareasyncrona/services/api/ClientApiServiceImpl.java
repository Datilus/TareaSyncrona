package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Client;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ClientService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientApiServiceImpl implements ClientService {

    private static ClientApiServiceImpl instance;

    private ClientApiServiceImpl() {
    }

    public static ClientApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Client>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/clients";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<Client>> response = request.executeForObject(ResponseList.class);

        ArrayList<Client> clients = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            clients = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Client>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(clients, 102, message);
        }
        return new ResponseDataWithCode<>(clients, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Client> clients) {

    }

    @Override
    public void addObject(Client client) {

    }
}
