package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Price;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.PriceService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class PriceApiServiceImpl implements PriceService {

    private static PriceApiServiceImpl instance;

    private PriceApiServiceImpl() {
    }

    public static PriceApiServiceImpl getInstance() {
        if (instance == null)
            instance = new PriceApiServiceImpl();
        return instance;
    }


    @Override
    public ResponseDataWithCode<ArrayList<Price>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/date/2018-05-02/prices";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(Price price) {

    }
}
