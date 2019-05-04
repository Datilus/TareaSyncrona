package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.modelo.realmModel.TypeClientEntity;
import com.example.tareasyncrona.services.interfaces.TypeClientService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class TypeClientServiceDatabase implements TypeClientService {

    private static TypeClientServiceDatabase instance;

    private TypeClientServiceDatabase() {
    }

    public static TypeClientServiceDatabase getInstance() {
        if (instance == null)
            instance = new TypeClientServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<TypeClient>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<TypeClient> typeClients) {
        List<TypeClientEntity> typeClientEntities = Stream.of(typeClients)
                .map(typeClient -> new TypeClientEntity(typeClient))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(typeClientEntities));
        }
    }
}
