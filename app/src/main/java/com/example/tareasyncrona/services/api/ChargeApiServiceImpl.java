package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Charge;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ChargeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ChargeApiServiceImpl implements ChargeService {

    private static ChargeApiServiceImpl instance;

    private ChargeApiServiceImpl() {
    }

    public static ChargeApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ChargeApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Charge>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/charges";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<Charge>> response = request.executeForObject(ResponseList.class);

        ArrayList<Charge> charges = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            charges = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Charge>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(charges, 102, message);
        }
        return new ResponseDataWithCode<>(charges, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Charge> charges) {

    }

    @Override
    public void addObject(Charge charge) {

    }
}
