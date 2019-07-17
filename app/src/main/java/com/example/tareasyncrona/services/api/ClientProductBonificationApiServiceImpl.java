package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ClientProductBonification;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ClientProductBonificationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ClientProductBonificationApiServiceImpl implements ClientProductBonificationService {

    private static ClientProductBonificationApiServiceImpl instance;

    private ClientProductBonificationApiServiceImpl() {

    }

    public static ClientProductBonificationApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientProductBonificationApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientProductBonification>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/productsbonifications";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(ClientProductBonification clientProductBonification) {

    }
}
