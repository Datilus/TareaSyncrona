package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.TypeClient;
import com.example.tareasyncrona.Modelo.TypeClientEntity;
import com.example.tareasyncrona.services.interfaces.TypeClientService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class TypeClientServiceDataBase implements TypeClientService {

    private static TypeClientServiceDataBase instance;

    private TypeClientServiceDataBase() {}

    public static TypeClientServiceDataBase getInstance(){
        if (instance == null)
            instance = new TypeClientServiceDataBase();
        return instance;
    }

    @Override
    public ArrayList<TypeClient> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<TypeClient> typeClients) {
        List<TypeClientEntity> typeClientEntities = Stream.of(typeClients)
                .map(typeClient -> new TypeClientEntity(typeClient))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(typeClientEntities));
        }
    }
}
