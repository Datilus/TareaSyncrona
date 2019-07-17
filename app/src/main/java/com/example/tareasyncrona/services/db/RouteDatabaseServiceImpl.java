package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Route;
import com.example.tareasyncrona.data.db.RouteEntity;
import com.example.tareasyncrona.domain.services.interfaces.RouteService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class RouteDatabaseServiceImpl implements RouteService {

    private static RouteDatabaseServiceImpl instance;

    private RouteDatabaseServiceImpl() {
    }

    public static RouteDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new RouteDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<Route> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Route> routes) {
        List<RouteEntity> routeEntities = Stream.of(routes)
                .map(route -> new RouteEntity(route))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(routeEntities));
        }
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
