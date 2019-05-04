package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.Route;
import com.example.tareasyncrona.modelo.realmModel.RouteEntity;
import com.example.tareasyncrona.services.interfaces.RouteService;

import java.util.List;

import io.realm.Realm;

public class RouteServiceDatabase implements RouteService {

    private static RouteServiceDatabase instance;

    private RouteServiceDatabase() {
    }

    public static RouteServiceDatabase getInstance() {
        if (instance == null)
            instance = new RouteServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<Route> fetch() {
        return null;
    }

    @Override
    public void addObject(Route route) {
        List<RouteEntity> routeEntities = Stream.of(route)
                .map(route1 -> new RouteEntity(route1))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(routeEntities));
        }
    }
}
