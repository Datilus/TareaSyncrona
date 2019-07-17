package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Folio;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.FolioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FolioApiServiceImpl implements FolioService {

    private static FolioApiServiceImpl instance;

    private FolioApiServiceImpl() {

    }

    public static FolioApiServiceImpl getInstance() {
        if (instance == null)
            instance = new FolioApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Folio>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/folios";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<Folio>> response = request.executeForObject(ResponseList.class);

        ArrayList<Folio> folios = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            folios = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Folio>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(folios, 102, message);
        }

        return new ResponseDataWithCode<>(folios, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Folio> folios) {

    }

    @Override
    public void addObject(Folio folio) {

    }
}
