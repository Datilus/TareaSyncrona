package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Tax;
import com.example.tareasyncrona.data.db.TaxEntity;
import com.example.tareasyncrona.domain.services.interfaces.TaxService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class TaxDatabaseServiceImpl implements TaxService {

    private static TaxDatabaseServiceImpl instance;

    private TaxDatabaseServiceImpl() {
    }

    public static TaxDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new TaxDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Tax>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Tax> taxes) {
        List<TaxEntity> taxEntities = Stream.of(taxes)
                .map(tax -> new TaxEntity(tax))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(taxEntities));
        }
    }

    @Override
    public void addObject(Tax tax) {
        TaxEntity taxEntity = Stream.of(tax)
                .map(item -> new TaxEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(taxEntity));
        }
    }
}
