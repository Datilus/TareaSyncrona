package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.Line;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.LineService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class LineServiceImpl implements LineService {

    private static LineServiceImpl instance;

    private LineServiceImpl() {

    }

    public static LineServiceImpl getInstance() {
        if (instance == null)
            instance = new LineServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Line>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/lines")
                .build();

        ANResponse<ResponseList<Line>> response = request.executeForObject(ResponseList.class);

        ArrayList<Line> lines = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            lines = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Line>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(lines, 102, message);
        }

        return new ResponseDataWithCode<>(lines, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Line> lines) {

    }
}
