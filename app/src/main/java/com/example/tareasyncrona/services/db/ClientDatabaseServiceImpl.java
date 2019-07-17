package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Client;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ClientEntity;
import com.example.tareasyncrona.domain.services.interfaces.ClientService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientDatabaseServiceImpl implements ClientService {

    private static ClientDatabaseServiceImpl instance;

    private ClientDatabaseServiceImpl() {
    }

    public static ClientDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Client>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Client> clients) {
        List<ClientEntity> clientEntities = Stream.of(clients)
                .map(client -> new ClientEntity(client))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientEntities));
        }
    }

    @Override
    public void addObject(Client client) {
        ClientEntity clientEntity = Stream.of(client)
                .map(item -> new ClientEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientEntity));
        }
    }
}
