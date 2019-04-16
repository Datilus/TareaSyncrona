package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Charge;
import com.example.tareasyncrona.Modelo.realmModel.ChargeEntity;
import com.example.tareasyncrona.services.interfaces.ChargeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ChargeServiceDataBase implements ChargeService {

    private static ChargeServiceDataBase instance;

    private ChargeServiceDataBase(){}

    public static ChargeServiceDataBase getInstance(){
        if (instance == null)
            instance = new ChargeServiceDataBase();
        return instance;
    }

    @Override
    public ArrayList<Charge> fetch() {
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
