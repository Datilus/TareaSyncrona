package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Payment;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.PaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class PaymentServiceImpl implements PaymentService {

    private static PaymentServiceImpl instance;

    private PaymentServiceImpl(){

    }

    public static PaymentServiceImpl getInstance(){
        if (instance == null)
            instance = new PaymentServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Payment>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/payments")
                .build();

        ANResponse<ResponseList<Payment>> response = request.executeForObject(ResponseList.class);

        ArrayList<Payment> payments = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            payments = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Payment>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(payments, 102, message);
        }

        return new ResponseDataWithCode<>(payments, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Payment> payments) {

    }
}
