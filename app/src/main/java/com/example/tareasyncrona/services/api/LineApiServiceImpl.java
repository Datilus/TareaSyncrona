package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Line;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.LineService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class LineApiServiceImpl implements LineService {

    private static LineApiServiceImpl instance;

    private LineApiServiceImpl() {

    }

    public static LineApiServiceImpl getInstance() {
        if (instance == null)
            instance = new LineApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Line>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/lines";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(Line line) {

    }
}
