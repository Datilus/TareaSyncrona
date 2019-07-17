package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.FormVisit;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.FormVisitEntity;
import com.example.tareasyncrona.domain.services.interfaces.FormVisitService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FormVisitDatabaseServiceImpl implements FormVisitService {

    private static FormVisitDatabaseServiceImpl instance;

    private FormVisitDatabaseServiceImpl() {
    }

    public static FormVisitDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new FormVisitDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<FormVisit>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<FormVisit> formVisits) {
        List<FormVisitEntity> formVisitEntities = Stream.of(formVisits)
                .map(formVisit -> new FormVisitEntity(formVisit))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(formVisitEntities));
        }
    }

    @Override
    public void addObject(FormVisit formVisit) {
        FormVisitEntity formVisitEntity = Stream.of(formVisit)
                .map(item -> new FormVisitEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(formVisitEntity));
        }
    }
}
