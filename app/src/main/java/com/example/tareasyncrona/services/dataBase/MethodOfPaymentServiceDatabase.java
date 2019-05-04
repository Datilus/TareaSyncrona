package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.MethodOfPayment;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.MethodOfPaymentEntity;
import com.example.tareasyncrona.services.interfaces.MethodOfPaymentService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MethodOfPaymentServiceDatabase implements MethodOfPaymentService {

    private static MethodOfPaymentServiceDatabase instance;

    private MethodOfPaymentServiceDatabase() {

    }

    public static MethodOfPaymentServiceDatabase getInstance(){
        if (instance == null)
            instance = new MethodOfPaymentServiceDatabase();
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

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(methodOfPaymentEntities));
        }
    }
}
