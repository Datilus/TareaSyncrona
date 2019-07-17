package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ClientAuthorization;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ClientAuthorizationEntity;
import com.example.tareasyncrona.domain.services.interfaces.ClientAuthorizationService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientAuthorizationDatabaseServiceImpl implements ClientAuthorizationService {

    private static ClientAuthorizationDatabaseServiceImpl instance;

    private ClientAuthorizationDatabaseServiceImpl() {
    }

    public static ClientAuthorizationDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientAuthorizationDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientAuthorization>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<ClientAuthorization> clientAuthorizations) {
        List<ClientAuthorizationEntity> clientAuthorizationEntities = Stream.of(clientAuthorizations)
                .map(clientAuthorization -> new ClientAuthorizationEntity(clientAuthorization))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientAuthorizationEntities));
        }
    }

    @Override
    public void addObject(ClientAuthorization clientAuthorization) {
        ClientAuthorizationEntity clientAuthorizationEntity = Stream.of(clientAuthorization)
                .map(item -> new ClientAuthorizationEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientAuthorizationEntity));
        }
    }
}
