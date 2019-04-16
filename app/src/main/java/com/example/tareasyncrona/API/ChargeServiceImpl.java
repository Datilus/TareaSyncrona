package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Charge;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ChargeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ChargeServiceImpl implements ChargeService {

    private static ChargeServiceImpl instance;

    private ChargeServiceImpl(){}

    public static ChargeServiceImpl getInstance(){
        if (instance == null)
            instance = new ChargeServiceImpl();
        return instance;
    }

    @Override
    public ArrayList<Charge> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/charges")
                .build();

        ANResponse<ResponseList<Charge>> response = request.executeForObject(ResponseList.class);

        ArrayList<Charge> charges = null;

        if (response.isSuccess() && response.getResult().getData() != null) {
            charges = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Charge>>() {
                            }.getType());
        }
        return charges;
    }

    @Override
    public void addList(ArrayList<Charge> charges) {

    }
}
