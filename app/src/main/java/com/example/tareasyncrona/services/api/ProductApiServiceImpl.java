package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Product;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ProductApiServiceImpl implements ProductService {

    private static ProductApiServiceImpl instance;

    private ProductApiServiceImpl() {
    }

    public static ProductApiServiceImpl getInstance() {
        if (instance == null)
            instance = new ProductApiServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Product>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/inventory";
        ANRequest request = AndroidNetworking.get(URL)
                .build();

        ANResponse<ResponseList<Product>> response = request.executeForObject(ResponseList.class);

        ArrayList<Product> products = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            products = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Product>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(products, 102, message);
        }

        return new ResponseDataWithCode<>(products, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<Product> products) {

    }

    @Override
    public void addObject(Product product) {

    }
}
