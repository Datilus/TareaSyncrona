package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.Modelo.realmModel.ClientAuthorizationEntity;
import com.example.tareasyncrona.services.interfaces.ClientAuthorizationService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientAuthorizationDataBase implements ClientAuthorizationService {

    private static ClientAuthorizationDataBase instance;

    private ClientAuthorizationDataBase(){}

    public static ClientAuthorizationDataBase getInstance(){
        if (instance == null)
            instance = new ClientAuthorizationDataBase();
        return instance;
    }

    @Override
    public ArrayList<ClientAuthorization> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<ClientAuthorization> clientAuthorizations) {
        List<ClientAuthorizationEntity> clientAuthorizationEntities = Stream.of(clientAuthorizations)
                .map(clientAuthorization -> new ClientAuthorizationEntity(clientAuthorization))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientAuthorizationEntities));
        }
    }
}