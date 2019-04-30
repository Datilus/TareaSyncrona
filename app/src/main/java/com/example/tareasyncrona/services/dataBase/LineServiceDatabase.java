package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Line;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.LineEntity;
import com.example.tareasyncrona.services.interfaces.LineService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class LineServiceDatabase implements LineService {

    private static LineServiceDatabase instance;

    private LineServiceDatabase() {

    }

    public static LineServiceDatabase getInstance() {
        if (instance == null)
            instance = new LineServiceDatabase();
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
}
