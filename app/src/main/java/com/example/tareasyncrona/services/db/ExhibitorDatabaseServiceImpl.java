package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Exhibitor;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ExhibitorEntity;
import com.example.tareasyncrona.domain.services.interfaces.ExhibitorService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ExhibitorDatabaseServiceImpl implements ExhibitorService {

    private static ExhibitorDatabaseServiceImpl instance;

    private ExhibitorDatabaseServiceImpl() {

    }

    public static ExhibitorDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ExhibitorDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Exhibitor>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Exhibitor> exhibitors) {
        List<ExhibitorEntity> exhibitorEntities = Stream.of(exhibitors)
                .map(exhibitor -> new ExhibitorEntity(exhibitor))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(exhibitorEntities));
        }
    }

    @Override
    public void addObject(Exhibitor exhibitor) {
        ExhibitorEntity exhibitorEntity = Stream.of(exhibitor)
                .map(item -> new ExhibitorEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(exhibitorEntity));
        }
    }
}
