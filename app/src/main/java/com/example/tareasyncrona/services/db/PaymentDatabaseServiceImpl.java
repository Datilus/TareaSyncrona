package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Payment;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.PaymentEntity;
import com.example.tareasyncrona.domain.services.interfaces.PaymentService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class PaymentDatabaseServiceImpl implements PaymentService {

    private static PaymentDatabaseServiceImpl instance;

    private PaymentDatabaseServiceImpl() {
    }

    public static PaymentDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new PaymentDatabaseServiceImpl();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Payment>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Payment> payments) {
        List<PaymentEntity> paymentEntities = Stream.of(payments)
                .map(payment -> new PaymentEntity(payment))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(paymentEntities));
        }
    }

    @Override
    public void addObject(Payment payment) {
        PaymentEntity paymentEntity = Stream.of(payment)
                .map(item -> new PaymentEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(paymentEntity));
        }
    }
}
