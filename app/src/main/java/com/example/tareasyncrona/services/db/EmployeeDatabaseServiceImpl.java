package com.example.tareasyncrona.services.db;

import com.annimon.stream.Stream;
import com.example.tareasyncrona.data.api.Employee;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.db.EmployeeEntity;
import com.example.tareasyncrona.domain.services.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class EmployeeDatabaseServiceImpl implements EmployeeService {

    private static EmployeeDatabaseServiceImpl instance;

    private EmployeeDatabaseServiceImpl() {
    }

    public static EmployeeDatabaseServiceImpl getInstance() {
        if (instance == null)
            instance = new EmployeeDatabaseServiceImpl();
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
    public void addList(ArrayList<Employee> employees) {
        List<EmployeeEntity> employeeEntities = Stream.of(employees)
                .map(employee -> new EmployeeEntity(employee))
                .toList();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(employeeEntities));
        }
    }

    @Override
    public void addObject(Employee employee) {
        EmployeeEntity employeeEntity = Stream.of(employee)
                .map(item -> new EmployeeEntity(item))
                .single();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> innerRealm.copyToRealmOrUpdate(employeeEntity));
        }
    }
}
