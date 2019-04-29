package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.ClientAuthorizationEntity;
import com.example.tareasyncrona.services.interfaces.ClientAuthorizationService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ClientAuthorizationServiceDatabase implements ClientAuthorizationService {

    private static ClientAuthorizationServiceDatabase instance;

    private ClientAuthorizationServiceDatabase(){}

    public static ClientAuthorizationServiceDatabase getInstance(){
        if (instance == null)
            instance = new ClientAuthorizationServiceDatabase();
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

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(clientAuthorizationEntities));
        }
    }
}
