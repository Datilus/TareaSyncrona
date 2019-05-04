package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.Product;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance;

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null)
            instance = new ProductServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Product>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/inventory")
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
}
