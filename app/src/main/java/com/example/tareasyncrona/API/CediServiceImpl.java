package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Cedi;
import com.example.tareasyncrona.ResponseObject;
import com.example.tareasyncrona.services.interfaces.CediService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class CediServiceImpl implements CediService {

    private static CediServiceImpl instance;

    private CediServiceImpl() {
    }

    public static CediServiceImpl getInstance() {
        if (instance == null)
            instance = new CediServiceImpl();
        return instance;
    }

    @Override
    public Cedi fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/cedis/1/version/6.3.9")
                .build();

        ANResponse<ResponseObject<Cedi>> response = request.executeForObject(ResponseObject.class);

        Cedi cedis = null;

        if (response.isSuccess() && response.getResult().getData() != null) {
            cedis = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            Cedi.class);
        }
        return cedis;
    }

    @Override
    public void addList(ArrayList<Cedi> cedis) {

    }

    @Override
    public void addObject(Cedi cedi) {

    }
}
