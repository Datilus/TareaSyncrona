package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.CatalogueCFDIEntity;
import com.example.tareasyncrona.services.interfaces.CatalogueCFDIService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class CatalogueCFDIDataBase implements CatalogueCFDIService {

    private static CatalogueCFDIDataBase instance;

    private CatalogueCFDIDataBase() {
    }

    public static CatalogueCFDIDataBase getInstance() {
        if (instance == null)
            instance = new CatalogueCFDIDataBase();
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
