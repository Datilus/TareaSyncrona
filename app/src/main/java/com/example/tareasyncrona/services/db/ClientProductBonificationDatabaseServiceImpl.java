package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ClientProductBonification;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ClientProductBonificationEntity;
import com.example.tareasyncrona.domain.services.interfaces.ClientProductBonificationService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientProductBonificationDatabaseServiceImpl implements ClientProductBonificationService {

    private static ClientProductBonificationDatabaseServiceImpl instance;

    private ClientProductBonificationDatabaseServiceImpl() {

    }

    public static ClientProductBonificationDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientProductBonificationDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientProductBonification>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<ClientProductBonification> clientProductBonifications) {
        List<ClientProductBonificationEntity> clientProductBonificationEntities = Stream.of(clientProductBonifications)
                .map(clientProductBonification -> new ClientProductBonificationEntity(clientProductBonification))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientProductBonificationEntities));
        }
    }

    @Override
    public void addObject(ClientProductBonification clientProductBonification) {
        ClientProductBonificationEntity clientProductBonificationEntity = Stream.of(clientProductBonification)
                .map(item -> new ClientProductBonificationEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientProductBonificationEntity));
        }
    }
}
