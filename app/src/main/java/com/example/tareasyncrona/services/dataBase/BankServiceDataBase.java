package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Bank;
import com.example.tareasyncrona.Modelo.realmModel.BankEntity;
import com.example.tareasyncrona.services.interfaces.BankService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class BankServiceDataBase implements BankService {

    private static BankServiceDataBase instance;

    private BankServiceDataBase() {
    }

    public static BankServiceDataBase getInstance() {
        if (instance == null)
            instance = new BankServiceDataBase();
        return instance;
    }

    @Override
    public ArrayList<Bank> fetch() {
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
