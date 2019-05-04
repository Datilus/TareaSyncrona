package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.Cedi;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.CediEntity;
import com.example.tareasyncrona.services.interfaces.CediService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class CediServiceDatabase implements CediService {

    private static CediServiceDatabase instance;

    private CediServiceDatabase() {
    }

    public static CediServiceDatabase getInstance() {
        if (instance == null)
            instance = new CediServiceDatabase();
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
        List<CediEntity> cediEntities = Stream.of(cedi)
                .map(cedi1 -> new CediEntity(cedi1))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(cediEntities));
        }
    }
}
