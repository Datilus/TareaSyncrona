package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.FuelTicket;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.FuelTicketService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FuelTicketApiServiceImpl implements FuelTicketService {

    private static FuelTicketApiServiceImpl instance;

    private FuelTicketApiServiceImpl() {

    }

    public static FuelTicketApiServiceImpl getInstance() {
        if (instance == null)
            instance = new FuelTicketApiServiceImpl();
        return instance;
    }


    @Override
    public ResponseDataWithCode<ArrayList<FuelTicket>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/route/4/fuels";
        ANRequest request = AndroidNetworking.get(URL)
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

    @Override
    public void addObject(FuelTicket fuelTicket) {

    }
}
