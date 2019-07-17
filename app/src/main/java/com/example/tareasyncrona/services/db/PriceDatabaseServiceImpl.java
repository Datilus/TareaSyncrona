package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Price;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.PriceEntity;
import com.example.tareasyncrona.domain.services.interfaces.PriceService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class PriceDatabaseServiceImpl implements PriceService {

    private static PriceDatabaseServiceImpl instance;

    private PriceDatabaseServiceImpl() {
    }

    public static PriceDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new PriceDatabaseServiceImpl();
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

    @Override
    public void addObject(Price price) {
        PriceEntity priceEntity = Stream.of(price)
                .map(item -> new PriceEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(priceEntity));
        }
    }
}
