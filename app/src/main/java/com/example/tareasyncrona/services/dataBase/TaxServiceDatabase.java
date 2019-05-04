package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.Tax;
import com.example.tareasyncrona.modelo.realmModel.TaxEntity;
import com.example.tareasyncrona.services.interfaces.TaxService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class TaxServiceDatabase implements TaxService {

    private static TaxServiceDatabase instance;

    private TaxServiceDatabase() {
    }

    public static TaxServiceDatabase getInstance() {
        if (instance == null)
            instance = new TaxServiceDatabase();
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
}
