package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.jsonModel.Tax;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.TaxService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaxServiceImpl implements TaxService {

    private static TaxServiceImpl instance;

    private TaxServiceImpl() {
    }

    public static TaxServiceImpl getInstance() {
        if (instance == null)
            instance = new TaxServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Tax>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/taxes")
                .build();

        ANResponse<ResponseList<Tax>> response = request.executeForObject(ResponseList.class);

        ArrayList<Tax> taxes = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            taxes = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Tax>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(taxes, 102, message);
        }

        return new ResponseDataWithCode<>(taxes, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Tax> taxes) {

    }
}
