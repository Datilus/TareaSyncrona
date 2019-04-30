package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Folio;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.FolioEntity;
import com.example.tareasyncrona.services.interfaces.FolioService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FolioServiceDatabase implements FolioService {

    private static FolioServiceDatabase instance;

    private FolioServiceDatabase() {

    }

    public static FolioServiceDatabase getInstance() {
        if (instance == null)
            instance = new FolioServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Folio>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Folio> folios) {
        List<FolioEntity> folioEntities = Stream.of(folios)
                .map(folio -> new FolioEntity(folio))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(folioEntities));
        }
    }
}
