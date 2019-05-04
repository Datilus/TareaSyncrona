package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.Bank;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
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
    public ResponseDataWithCode<ArrayList<Bank>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/banks")
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

//    public ResponseDataWithCode<ArrayList> infoManager(Class clase, ANRequest anRequest) {
//
//        ANResponse<ResponseList<clase>> response = anRequest.executeForObject(ResponseList.class);
//
//        ArrayList<clase> banks = null;
//        String message;
//
//        if (response.isSuccess() && response.getResult().getData() != null) {
//            banks = new GsonBuilder()
//                    .create()
//                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
//                            new TypeToken<ArrayList<clase>>() {
//                            }.getType());
//            message = response.getResult().getMessage();
//        } else {
//            message = response.getError().getMessage();
//        }
//
//        if (response.getOkHttpResponse() == null) {
//            return new ResponseDataWithCode<>(banks, 102, message);
//        }
//
//        return new ResponseDataWithCode<>(banks, response.getOkHttpResponse().code(), message);
//    }
}
