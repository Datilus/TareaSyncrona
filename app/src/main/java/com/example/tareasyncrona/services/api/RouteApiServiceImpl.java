package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Route;
import com.example.tareasyncrona.data.api.ResponseObject;
import com.example.tareasyncrona.domain.services.interfaces.RouteService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class RouteApiServiceImpl implements RouteService {

    private static RouteApiServiceImpl instance;

    private RouteApiServiceImpl() {
    }

    public static RouteApiServiceImpl getInstance() {
        if (instance ==  null)
            instance = new RouteApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<Route> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/routes/4";
        ANRequest request = AndroidNetworking.get(URL)
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
    public void addList(ArrayList<Route> routes) {

    }

    @Override
    public void addObject(Route route) {

    }
}
