package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Bank;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.BankService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class BankServiceImpl implements BankService {

    private static BankServiceImpl instance;

    private BankServiceImpl() {
    }

    public static BankServiceImpl getInstance() {
        if (instance == null)
            instance = new BankServiceImpl();
        return instance;
    }


    @Override
    public ArrayList<Bank> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/banks")
                .build();

        ANResponse<ResponseList<Bank>> response = request.executeForObject(ResponseList.class);

        ArrayList<Bank> banks = null;

        if (response.isSuccess() && response.getResult().getData() != null) {
            banks = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Bank>>() {
                            }.getType());
        }
        return banks;
    }

    @Override
    public void addList(ArrayList<Bank> banks) {

    }
}