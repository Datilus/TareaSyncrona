package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Payment;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.PaymentEntity;
import com.example.tareasyncrona.services.interfaces.PaymentService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class PaymentServiceDatabase implements PaymentService {

    private static PaymentServiceDatabase instance;

    private PaymentServiceDatabase() {

    }

    public static PaymentServiceDatabase getInstance(){
        if (instance == null)
            instance = new PaymentServiceDatabase();
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
}
