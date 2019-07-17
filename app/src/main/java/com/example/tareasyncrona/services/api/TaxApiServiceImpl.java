package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Tax;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.TaxService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaxApiServiceImpl implements TaxService {

    private static TaxApiServiceImpl instance;

    private TaxApiServiceImpl() {
    }

    public static TaxApiServiceImpl getInstance() {
        if (instance == null)
            instance = new TaxApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Tax>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/taxes";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(Tax tax) {

    }
}
