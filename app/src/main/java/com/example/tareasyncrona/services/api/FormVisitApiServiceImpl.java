package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.data.api.FormVisit;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.domain.services.interfaces.FormVisitService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FormVisitApiServiceImpl implements FormVisitService {

    private static FormVisitApiServiceImpl instance;

    private FormVisitApiServiceImpl() {
    }

    public static FormVisitApiServiceImpl getInstance() {
        if (instance == null)
            instance = new FormVisitApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<FormVisit>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/forms_visits";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<FormVisit>> response = request.executeForObject(ResponseList.class);

        ArrayList<FormVisit> formVisits = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            formVisits = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<FormVisit>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(formVisits, 102, message);
        }

        return new ResponseDataWithCode<>(formVisits, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<FormVisit> formVisits) {

    }

    @Override
    public void addObject(FormVisit formVisit) {

    }
}
