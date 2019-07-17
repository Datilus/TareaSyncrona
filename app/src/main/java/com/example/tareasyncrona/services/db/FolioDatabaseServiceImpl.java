package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Folio;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.FolioEntity;
import com.example.tareasyncrona.domain.services.interfaces.FolioService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FolioDatabaseServiceImpl implements FolioService {

    private static FolioDatabaseServiceImpl instance;

    private FolioDatabaseServiceImpl() {
    }

    public static FolioDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new FolioDatabaseServiceImpl();
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

    @Override
    public void addObject(Folio folio) {
        FolioEntity folioEntity = Stream.of(folio)
                .map(item -> new FolioEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(folioEntity));
        }
    }
}
