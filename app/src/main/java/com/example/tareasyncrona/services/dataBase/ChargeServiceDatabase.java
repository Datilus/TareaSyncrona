package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.Charge;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.ChargeEntity;
import com.example.tareasyncrona.services.interfaces.ChargeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ChargeServiceDatabase implements ChargeService {

    private static ChargeServiceDatabase instance;

    private ChargeServiceDatabase(){}

    public static ChargeServiceDatabase getInstance(){
        if (instance == null)
            instance = new ChargeServiceDatabase();
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

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(chargeEntities));
        }
    }
}
