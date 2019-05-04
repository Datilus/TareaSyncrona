package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.MethodOfPayment;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.MethodOfPaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MethodOfPaymentServiceImp implements MethodOfPaymentService {

    private static MethodOfPaymentServiceImp instance;

    private MethodOfPaymentServiceImp() {

    }

    public static MethodOfPaymentServiceImp getInstance() {
        if (instance == null)
            instance = new MethodOfPaymentServiceImp();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<MethodOfPayment>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/methodspayments")
                .build();

        ANResponse<ResponseList<MethodOfPayment>> response = request.executeForObject(ResponseList.class);

        ArrayList<MethodOfPayment> methodOfPayments = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            methodOfPayments = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<MethodOfPayment>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(methodOfPayments, 102, message);
        }

        return new ResponseDataWithCode<>(methodOfPayments, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<MethodOfPayment> methodOfPayments) {

    }
}
