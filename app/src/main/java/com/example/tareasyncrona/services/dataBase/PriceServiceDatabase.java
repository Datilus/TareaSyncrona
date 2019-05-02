package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Price;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.PriceEntity;
import com.example.tareasyncrona.services.interfaces.PriceService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class PriceServiceDatabase implements PriceService {

    private static PriceServiceDatabase instance;

    private PriceServiceDatabase() {
    }

    public static PriceServiceDatabase getInstance() {
        if (instance == null)
            instance = new PriceServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Price>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Price> prices) {
        List<PriceEntity> priceEntities = Stream.of(prices)
                .map(price -> new PriceEntity(price))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(priceEntities));
        }
    }
}
