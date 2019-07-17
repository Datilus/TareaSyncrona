package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Charge;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ChargeEntity;
import com.example.tareasyncrona.domain.services.interfaces.ChargeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ChargeDatabaseServiceImpl implements ChargeService {

    private static ChargeDatabaseServiceImpl instance;

    private ChargeDatabaseServiceImpl() {
    }

    public static ChargeDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ChargeDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Charge>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Charge> charges) {
        List<ChargeEntity> chargeEntities = Stream.of(charges)
                .map(charge -> new ChargeEntity(charge))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(chargeEntities));
        }
    }

    @Override
    public void addObject(Charge charge) {
        ChargeEntity chargeEntity = Stream.of(charge)
                .map(item -> new ChargeEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(chargeEntity));
        }
    }
}
