package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.ClientExhibitor;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.ClientExhibitorEntity;
import com.example.tareasyncrona.services.interfaces.ClientExhibitorService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientExhibitorServiceDatabase implements ClientExhibitorService {

    private static ClientExhibitorServiceDatabase instance;

    private ClientExhibitorServiceDatabase() {}

    public static ClientExhibitorServiceDatabase getInstance(){
        if (instance == null)
            instance = new ClientExhibitorServiceDatabase();
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

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientExhibitorEntities));
        }
    }
}
