package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Cedi;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseObject;
import com.example.tareasyncrona.domain.services.interfaces.CediService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CediApiServiceImpl implements CediService {

    private static CediApiServiceImpl instance;

    private CediApiServiceImpl() {
    }

    public static CediApiServiceImpl getInstance() {
        if (instance == null)
            instance = new CediApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<Cedi> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/cedis/1/version/6.3.9";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseObject<Cedi>> response = request.executeForObject(ResponseObject.class);

        Cedi cedi = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            cedi = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            Cedi.class);
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(cedi, 102, message);
        }
        return new ResponseDataWithCode<>(cedi, response.getOkHttpResponse().code(), message);
    }

    public ResponseDataWithCode<ArrayList<Cedi>> jalar() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/cedis/1/version/6.3.9")
                .build();

        ANResponse<ResponseObject<Cedi>> response = request.executeForObject(ResponseObject.class);

        ArrayList<Cedi> cedis = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            cedis = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Cedi>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(cedis, 102, message);
        }
        return new ResponseDataWithCode<>(cedis, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Cedi> cedis) {

    }

    @Override
    public void addObject(Cedi cedi) {

    }
}
