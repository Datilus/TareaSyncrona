package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Line;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.LineEntity;
import com.example.tareasyncrona.domain.services.interfaces.LineService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class LineDatabaseServiceImpl implements LineService {

    private static LineDatabaseServiceImpl instance;

    private LineDatabaseServiceImpl() {
    }

    public static LineDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new LineDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Line>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Line> lines) {
        List<LineEntity> lineEntities = Stream.of(lines)
                .map(line -> new LineEntity(line))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(lineEntities));
        }
    }

    @Override
    public void addObject(Line line) {
        LineEntity lineEntity = Stream.of(line)
                .map(item -> new LineEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(lineEntity));
        }
    }
}
