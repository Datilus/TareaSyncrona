package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ClientExhibitor;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ClientExhibitorEntity;
import com.example.tareasyncrona.domain.services.interfaces.ClientExhibitorService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientExhibitorDatabaseServiceImpl implements ClientExhibitorService {

    private static ClientExhibitorDatabaseServiceImpl instance;

    private ClientExhibitorDatabaseServiceImpl() {
    }

    public static ClientExhibitorDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ClientExhibitorDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ClientExhibitor>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<ClientExhibitor> clientExhibitors) {
        List<ClientExhibitorEntity> clientExhibitorEntities = Stream.of(clientExhibitors)
                .map(clientExhibitor -> new ClientExhibitorEntity(clientExhibitor))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientExhibitorEntities));
        }
    }

    @Override
    public void addObject(ClientExhibitor clientExhibitor) {
        ClientExhibitorEntity clientExhibitorEntity = Stream.of(clientExhibitor)
                .map(item -> new ClientExhibitorEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientExhibitorEntity));
        }
    }
}
