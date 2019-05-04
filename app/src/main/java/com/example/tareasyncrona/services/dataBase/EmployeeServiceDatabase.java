package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.modelo.jsonModel.Employee;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.realmModel.EmployeeEntity;
import com.example.tareasyncrona.services.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class EmployeeServiceDatabase implements EmployeeService {

    private static EmployeeServiceDatabase instance;

    private EmployeeServiceDatabase() {
    }

    public static EmployeeServiceDatabase getInstance() {
        if (instance == null)
            instance = new EmployeeServiceDatabase();
        return instance;
    }

    @Override
    public ResponseDataWithCode<ArrayList<Employee>> fetch() {
        return null;
    }

    @Override
    public Employee getById(int id) {
        try (Realm realmInstance = Realm.getDefaultInstance()) {
            return new Employee(realmInstance.where(EmployeeEntity.class)
                    .equalTo("employeeId", id)
                    .findFirst());
        }
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void addList(ArrayList<Employee> employees) {
        List<EmployeeEntity> employeeEntities = Stream.of(employees)
                .map(employee -> new EmployeeEntity(employee))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(employeeEntities));
        }
    }
}
