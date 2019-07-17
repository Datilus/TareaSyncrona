package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.FuelTicket;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface FuelTicketService {
    ResponseDataWithCode<ArrayList<FuelTicket>> fetch();

    void addList(ArrayList<FuelTicket> fuelTickets);

    void addObject(FuelTicket fuelTicket);
}
