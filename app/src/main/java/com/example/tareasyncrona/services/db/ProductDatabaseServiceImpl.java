package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Product;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.ProductEntity;
import com.example.tareasyncrona.domain.services.interfaces.ProductService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ProductDatabaseServiceImpl implements ProductService {

    private static ProductDatabaseServiceImpl instance;

    private ProductDatabaseServiceImpl() {
    }

    public static ProductDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new ProductDatabaseServiceImpl();
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

    @Override
    public void addObject(Product product) {
        ProductEntity productEntity = Stream.of(product)
                .map(item -> new ProductEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(productEntity));
        }
    }
}
