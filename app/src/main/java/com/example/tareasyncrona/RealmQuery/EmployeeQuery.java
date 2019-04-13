package com.example.tareasyncrona.RealmQuery;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.Employee;
import com.example.tareasyncrona.Modelo.EmployeeEntity;
import com.example.tareasyncrona.services.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class EmployeeQuery implements EmployeeService {

    private static EmployeeQuery instance;

    private EmployeeQuery() {}

    public static EmployeeQuery getInstance(){
        if  (instance == null)
            instance = new EmployeeQuery();
        return instance;
    }

    @Override
    public ArrayList<Employee> fetch() {
        return null;
    }

    @Override
    public Employee get(int id) {
        try (Realm realmInstance = Realm.getDefaultInstance()){
            return new Employee(realmInstance.where(EmployeeEntity.class).findFirst());
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
