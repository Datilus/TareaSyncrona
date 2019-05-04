package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.Route;
import com.example.tareasyncrona.ResponseObject;
import com.example.tareasyncrona.services.interfaces.RouteService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RouteServiceImpl implements RouteService {

    private static RouteServiceImpl instance;

    private RouteServiceImpl() {
    }

    public static RouteServiceImpl getInstance() {
        if (instance ==  null)
            instance = new RouteServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<Route> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.130:8000/api/routes/4")
                .build();

        ANResponse<ResponseObject<Route>> response = request.executeForObject(ResponseObject.class);

        Route route = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            route = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            Route.class);
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(route, 102, message);
        }
        return new ResponseDataWithCode<>(route, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addObject(Route route) {

    }
}
