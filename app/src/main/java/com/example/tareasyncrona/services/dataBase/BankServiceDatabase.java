package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Bank;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.realmModel.BankEntity;
import com.example.tareasyncrona.services.interfaces.BankService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class BankServiceDatabase implements BankService {

    private static BankServiceDatabase instance;

    private BankServiceDatabase() {
    }

    public static BankServiceDatabase getInstance() {
        if (instance == null)
            instance = new BankServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Bank>> fetch() {
        return null;
    }

    @Override
    public void addList(ArrayList<Bank> banks) {
        List<BankEntity> bankEntities = Stream.of(banks)
                .map(bank -> new BankEntity(bank))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(bankEntities));
        }
    }
}
