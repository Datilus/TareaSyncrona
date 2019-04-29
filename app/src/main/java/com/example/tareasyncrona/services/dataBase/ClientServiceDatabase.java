package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Client;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.ClientEntity;
import com.example.tareasyncrona.services.interfaces.ClientService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientServiceDatabase implements ClientService {

    private static ClientServiceDatabase instance;

    private ClientServiceDatabase(){}

    public static ClientServiceDatabase getInstance(){
        if (instance == null)
            instance= new ClientServiceDatabase();
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

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientEntities));
        }
    }
}
