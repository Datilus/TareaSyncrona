package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.ProductRMI;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ProductRMIEntity;
import com.example.tareasyncrona.domain.services.interfaces.ProductRMIService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ProductRMIDatabaseServiceImpl implements ProductRMIService {

    private static ProductRMIDatabaseServiceImpl instance;

    private ProductRMIDatabaseServiceImpl() {
    }

    public static ProductRMIDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ProductRMIDatabaseServiceImpl();
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

    @Override
    public void addObject(ProductRMI productRMI) {
        ProductRMIEntity productRMIEntity = Stream.of(productRMI)
                .map(item -> new ProductRMIEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(productRMIEntity));
        }
    }
}
