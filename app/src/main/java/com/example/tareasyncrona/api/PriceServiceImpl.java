package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.Price;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.PriceService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class PriceServiceImpl implements PriceService {

    private static PriceServiceImpl instance;

    private PriceServiceImpl() {
    }

    public static PriceServiceImpl getInstance() {
        if (instance == null)
            instance = new PriceServiceImpl();
        return instance;
    }


    @Override
    public ResponseDataWithCode<ArrayList<Price>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/date/2018-05-02/prices")
                .build();

        ANResponse<ResponseList<Price>> response = request.executeForObject(ResponseList.class);

        ArrayList<Price> prices = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            prices = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Price>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(prices, 102, message);
        }

        return new ResponseDataWithCode<>(prices, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Price> prices) {

    }
}
