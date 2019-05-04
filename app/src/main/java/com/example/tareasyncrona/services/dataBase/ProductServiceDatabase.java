package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.Product;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.ProductEntity;
import com.example.tareasyncrona.services.interfaces.ProductService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ProductServiceDatabase implements ProductService {

    private static ProductServiceDatabase instance;

    private ProductServiceDatabase() {
    }

    public static ProductServiceDatabase getInstance() {
        if (instance == null)
            instance = new ProductServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Product>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Product> products) {
        List<ProductEntity> productEntities = Stream.of(products)
                .map(product -> new ProductEntity(product))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(productEntities));
        }
    }
}
