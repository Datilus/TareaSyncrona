package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Exhibitor;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ExhibitorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ExhibitorApiServiceImpl implements ExhibitorService {

    private static ExhibitorApiServiceImpl instance;

    private ExhibitorApiServiceImpl() {

    }

    public static ExhibitorApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ExhibitorApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Exhibitor>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/exhibitors";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<Exhibitor>> response = request.executeForObject(ResponseList.class);

        ArrayList<Exhibitor> exhibitors = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            exhibitors = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Exhibitor>>() {
                            }
                                    .getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(exhibitors, 102, message);
        }
        return new ResponseDataWithCode<>(exhibitors, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Exhibitor> exhibitors) {

    }

    @Override
    public void addObject(Exhibitor exhibitor) {

    }
}
