package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.Exhibitor;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.ExhibitorEntity;
import com.example.tareasyncrona.services.interfaces.ExhibitorService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ExhibitorServiceDatabase implements ExhibitorService {

    private static ExhibitorServiceDatabase instance;

    private ExhibitorServiceDatabase() {

    }

    public static ExhibitorServiceDatabase getInstance() {
        if (instance == null)
            instance = new ExhibitorServiceDatabase();
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
}
