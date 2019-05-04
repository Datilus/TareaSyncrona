package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.ProductRMI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.ProductRMIService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ProductRMIServiceImpl implements ProductRMIService {

    private static ProductRMIServiceImpl instance;

    private ProductRMIServiceImpl() {
    }

    public static ProductRMIServiceImpl getInstance() {
        if (instance == null)
            instance = new ProductRMIServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ProductRMI>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/listprice/1/rmi")
                .build();

        ANResponse<ResponseList<ProductRMI>> response = request.executeForObject(ResponseList.class);

        ArrayList<ProductRMI> productRMIS = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            productRMIS = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<ProductRMI>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(productRMIS, 102, message);
        }

        return new ResponseDataWithCode<>(productRMIS, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<ProductRMI> productRMIS) {

    }
}
