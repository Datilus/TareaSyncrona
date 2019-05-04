package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.FuelTicket;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface FuelTicketService {
    ResponseDataWithCode<ArrayList<FuelTicket>> fetch();

    void addList(ArrayList<FuelTicket> fuelTickets);
}
