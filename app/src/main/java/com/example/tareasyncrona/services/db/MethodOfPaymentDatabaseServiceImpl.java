package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.MethodOfPayment;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.MethodOfPaymentEntity;
import com.example.tareasyncrona.domain.services.interfaces.MethodOfPaymentService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MethodOfPaymentDatabaseServiceImpl implements MethodOfPaymentService {

    private static MethodOfPaymentDatabaseServiceImpl instance;

    private MethodOfPaymentDatabaseServiceImpl() {

    }

    public static MethodOfPaymentDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new MethodOfPaymentDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<MethodOfPayment>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<MethodOfPayment> methodOfPayments) {
        List<MethodOfPaymentEntity> methodOfPaymentEntities = Stream.of(methodOfPayments)
                .map(methodOfPayment -> new MethodOfPaymentEntity(methodOfPayment))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(methodOfPaymentEntities));
        }
    }

    @Override
    public void addObject(MethodOfPayment methodOfPayment) {
        MethodOfPaymentEntity methodOfPaymentEntity = Stream.of(methodOfPayment)
                .map(item -> new MethodOfPaymentEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(methodOfPaymentEntity));
        }
    }
}
