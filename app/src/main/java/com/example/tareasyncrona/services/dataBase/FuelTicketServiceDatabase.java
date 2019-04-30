package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.FuelTicket;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.FuelTicketEntity;
import com.example.tareasyncrona.services.interfaces.FuelTicketService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FuelTicketServiceDatabase implements FuelTicketService {

    private static FuelTicketServiceDatabase instance;

    private FuelTicketServiceDatabase() {

    }

    public static FuelTicketServiceDatabase getInstance() {
        if (instance == null)
            instance = new FuelTicketServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<FuelTicket>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<FuelTicket> fuelTickets) {
        List<FuelTicketEntity> fuelTicketEntities = Stream.of(fuelTickets)
                .map(fuelTicket -> new FuelTicketEntity(fuelTicket))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(fuelTicketEntities));
        }
    }
}
