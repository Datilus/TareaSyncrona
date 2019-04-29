package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Exhibitor;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ExhibitorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ExhibitorServiceImpl implements ExhibitorService {

    private static ExhibitorServiceImpl instance;

    private ExhibitorServiceImpl() {

    }

    public static ExhibitorServiceImpl getInstance() {
        if (instance == null)
            instance = new ExhibitorServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Exhibitor>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/exhibitors")
                .build();

        ANResponse<ResponseList<Exhibitor>> response = request.executeForObject(ResponseList.class);

        ArrayList<Exhibitor> exhibitors = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            exhibitors = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Exhibitor>>() {
                            }
                                    .getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(exhibitors, 102, message);
        }
        return new ResponseDataWithCode<>(exhibitors, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Exhibitor> exhibitors) {

    }
}
