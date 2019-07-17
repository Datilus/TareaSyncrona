package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.MethodOfPayment;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.MethodOfPaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MethodOfPaymentApiServiceImpl implements MethodOfPaymentService {

    private static MethodOfPaymentApiServiceImpl instance;

    private MethodOfPaymentApiServiceImpl() {

    }

    public static MethodOfPaymentApiServiceImpl getInstance() {
        if (instance == null)
            instance = new MethodOfPaymentApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<MethodOfPayment>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/methodspayments";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(MethodOfPayment methodOfPayment) {

    }
}
