package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.CatalogueCFDI;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.CatalogueCFDIEntity;
import com.example.tareasyncrona.domain.services.interfaces.CatalogueCFDIService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class CatalogueCFDIDatabaseServiceImpl implements CatalogueCFDIService {

    private static CatalogueCFDIDatabaseServiceImpl instance;

    private CatalogueCFDIDatabaseServiceImpl() {
    }

    public static CatalogueCFDIDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new CatalogueCFDIDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<CatalogueCFDI>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<CatalogueCFDI> catalogueCFDIS) {
        List<CatalogueCFDIEntity> catalogueCFDIEntities = Stream.of(catalogueCFDIS)
                .map(catalogueCFDI -> new CatalogueCFDIEntity(catalogueCFDI))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(catalogueCFDIEntities));
        }
    }

    @Override
    public void addObject(CatalogueCFDI catalogueCFDI) {
        CatalogueCFDIEntity catalogueCFDIEntity = Stream.of(catalogueCFDI)
                .map(item -> new CatalogueCFDIEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(catalogueCFDIEntity));
        }
    }
}
