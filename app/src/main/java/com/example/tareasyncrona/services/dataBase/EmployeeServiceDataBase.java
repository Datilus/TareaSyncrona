package com.example.tareasyncrona.services.dataBase;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.Modelo.jsonModel.Employee;
import com.example.tareasyncrona.Modelo.realmModel.EmployeeEntity;
import com.example.tareasyncrona.services.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class EmployeeServiceDataBase implements EmployeeService {

    private static EmployeeServiceDataBase instance;

    private EmployeeServiceDataBase() {}

    public static EmployeeServiceDataBase getInstance(){
        if  (instance == null)
            instance = new EmployeeServiceDataBase();
        return instance;
    }

    @Override
    public ArrayList<Employee> fetch() {
        return null;
    }

    @Override
    public Employee getById(int id) {
        try (Realm realmInstance = Realm.getDefaultInstance()){
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
