package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Cedi;
import com.example.tareasyncrona.Modelo.realmModel.CediEntity;
import com.example.tareasyncrona.services.interfaces.CediService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class CediServiceDataBase implements CediService {

    private static CediServiceDataBase instance;

    private CediServiceDataBase() {
    }

    public static CediServiceDataBase getInstance() {
        if (instance == null)
            instance = new CediServiceDataBase();
        return instance;
    }

    @Override
    public Cedi fetch() {
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
        List<CediEntity> cediEntities = Stream.of(cedi)
                .map(cedi1 -> new CediEntity(cedi1))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(cediEntities));
        }
    }
}
