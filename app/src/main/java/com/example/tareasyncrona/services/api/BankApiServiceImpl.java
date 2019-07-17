package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Bank;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.BankService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class BankApiServiceImpl implements BankService {

    private static BankApiServiceImpl instance;

    private BankApiServiceImpl() {
    }

    public static BankApiServiceImpl getInstance() {
        if (instance == null)
            instance = new BankApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Bank>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/banks";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<Bank>> response = request.executeForObject(ResponseList.class);

        ArrayList<Bank> banks = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            banks = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Bank>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(banks, 102, message);
        }
        return new ResponseDataWithCode<>(banks, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Bank> banks) {
    }

    @Override
    public void addObject(Bank bank) {

    }
}