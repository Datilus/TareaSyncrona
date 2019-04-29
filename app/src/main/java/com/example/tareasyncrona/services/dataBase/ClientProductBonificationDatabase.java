package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.ClientProductBonification;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.ClientProductBonificationEntity;
import com.example.tareasyncrona.services.interfaces.ClientProductBonificationService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientProductBonificationDatabase implements ClientProductBonificationService {

    private static ClientProductBonificationDatabase instance;

    private ClientProductBonificationDatabase() {

    }

    public static ClientProductBonificationDatabase getInstance() {
        if (instance == null)
            instance = new ClientProductBonificationDatabase();
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
}
