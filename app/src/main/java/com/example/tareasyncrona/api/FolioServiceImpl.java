package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.Folio;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.FolioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FolioServiceImpl implements FolioService {

    private static FolioServiceImpl instance;

    private FolioServiceImpl() {

    }

    public static FolioServiceImpl getInstance() {
        if (instance == null)
            instance = new FolioServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Folio>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/folios")
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
}
