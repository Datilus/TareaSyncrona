package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Bank;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.BankEntity;
import com.example.tareasyncrona.domain.services.interfaces.BankService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class BankDatabaseServiceImpl implements BankService {

    private static BankDatabaseServiceImpl instance;

    private BankDatabaseServiceImpl() {
    }

    public static BankDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new BankDatabaseServiceImpl();
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

    @Override
    public void addObject(Bank bank) {
        List<BankEntity> bankEntities = Stream.of(bank)
                .map(item -> new BankEntity(item))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(bankEntities));
        }
    }
}
