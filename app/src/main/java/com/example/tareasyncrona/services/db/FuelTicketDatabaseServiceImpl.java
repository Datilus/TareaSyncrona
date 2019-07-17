package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.FuelTicket;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.FuelTicketEntity;
import com.example.tareasyncrona.domain.services.interfaces.FuelTicketService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FuelTicketDatabaseServiceImpl implements FuelTicketService {

    private static FuelTicketDatabaseServiceImpl instance;

    private FuelTicketDatabaseServiceImpl() {

    }

    public static FuelTicketDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new FuelTicketDatabaseServiceImpl();
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

    @Override
    public void addObject(FuelTicket fuelTicket) {
        FuelTicketEntity fuelTicketEntity = Stream.of(fuelTicket)
                .map(item -> new FuelTicketEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(fuelTicketEntity));
        }
    }
}
