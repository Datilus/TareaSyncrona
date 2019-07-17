package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.TypeClient;
import com.example.tareasyncrona.data.db.TypeClientEntity;
import com.example.tareasyncrona.domain.services.interfaces.TypeClientService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class TypeClientDatabaseServiceImpl implements TypeClientService {

    private static TypeClientDatabaseServiceImpl instance;

    private TypeClientDatabaseServiceImpl() {
    }

    public static TypeClientDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new TypeClientDatabaseServiceImpl();
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

    @Override
    public void addObject(TypeClient typeClient) {
        TypeClientEntity typeClientEntity = Stream.of(typeClient)
                .map(item -> new TypeClientEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(typeClientEntity));
        }
    }
}
