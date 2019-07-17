package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Cedi;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.CediEntity;
import com.example.tareasyncrona.domain.services.interfaces.CediService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class CediDatabaseServiceImpl implements CediService {

    private static CediDatabaseServiceImpl instance;

    private CediDatabaseServiceImpl() {
    }

    public static CediDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new CediDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<Cedi> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Cedi> cedis) {
        List<CediEntity> cediEntities = Stream.of(cedis)
                .map(cedi -> new CediEntity(cedi))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(cediEntities));
        }
    }

    @Override
    public void addObject(Cedi cedi) {
        CediEntity cediEntity = Stream.of(cedi)
                .map(item -> new CediEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(cediEntity));
        }
    }
}
