package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.ClientExhibitor;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.ClientExhibitorEntity;
import com.example.tareasyncrona.services.interfaces.ClientExhibitorService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientExhibitorDataBase implements ClientExhibitorService {

    private static ClientExhibitorDataBase instance;

    private ClientExhibitorDataBase() {}

    public static ClientExhibitorDataBase getInstance(){
        if (instance == null)
            instance = new ClientExhibitorDataBase();
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
