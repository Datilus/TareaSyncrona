package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.ProductRMI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.ProductRMIEntity;
import com.example.tareasyncrona.services.interfaces.ProductRMIService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ProductRMIServiceDatabase implements ProductRMIService {

    private static ProductRMIServiceDatabase instance;

    private ProductRMIServiceDatabase() {
    }

    public static ProductRMIServiceDatabase getInstance() {
        if (instance == null)
            instance = new ProductRMIServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<ProductRMI>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<ProductRMI> productRMIS) {
        List<ProductRMIEntity> productRMIEntities = Stream.of(productRMIS)
                .map(productRMI -> new ProductRMIEntity(productRMI))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(productRMIEntities));
        }
    }
}
