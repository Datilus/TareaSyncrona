package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.FuelTicket;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.FuelTicketService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FuelTicketServiceImpl implements FuelTicketService {

    private static FuelTicketServiceImpl instance;

    private FuelTicketServiceImpl() {

    }

    public static FuelTicketServiceImpl getInstance() {
        if (instance == null)
            instance = new FuelTicketServiceImpl();
        return instance;
    }


    @Override
    public ResponseDataWithCode<ArrayList<FuelTicket>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/route/4/fuels")
                .build();

        ANResponse<ResponseList<FuelTicket>> response = request.executeForObject(ResponseList.class);

        ArrayList<FuelTicket> fuelTickets = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            fuelTickets = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<FuelTicket>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(fuelTickets, 102, message);
        }

        return new ResponseDataWithCode<>(fuelTickets, response.getOkHttpResponse().code(), message);
    }

    @Override
    public void addList(ArrayList<FuelTicket> fuelTickets) {

    }
}
