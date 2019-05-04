package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.CatalogueCFDIService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CatalogueCFDIServiceImpl implements CatalogueCFDIService {

    private static CatalogueCFDIServiceImpl instance;

    private CatalogueCFDIServiceImpl() {
    }

    public static CatalogueCFDIServiceImpl getInstance() {
        if (instance == null)
            instance = new CatalogueCFDIServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<CatalogueCFDI>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/uses_cfdi")
                .build();
        ANResponse<ResponseList<CatalogueCFDI>> response = request.executeForObject(ResponseList.class);

        ArrayList<CatalogueCFDI> catalogueCFDIs = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            catalogueCFDIs = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<CatalogueCFDI>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            new ResponseDataWithCode<>(catalogueCFDIs, 102, message);
        }
        return new ResponseDataWithCode<>(catalogueCFDIs, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<CatalogueCFDI> catalogueCFDIS) {

    }
}
