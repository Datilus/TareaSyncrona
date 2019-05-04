package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.CatalogueCFDIEntity;
import com.example.tareasyncrona.services.interfaces.CatalogueCFDIService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class CatalogueCFDIServiceDatabase implements CatalogueCFDIService {

    private static CatalogueCFDIServiceDatabase instance;

    private CatalogueCFDIServiceDatabase() {
    }

    public static CatalogueCFDIServiceDatabase getInstance() {
        if (instance == null)
            instance = new CatalogueCFDIServiceDatabase();
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
}
