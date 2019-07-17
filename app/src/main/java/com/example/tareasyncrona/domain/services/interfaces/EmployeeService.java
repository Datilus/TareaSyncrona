package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Employee;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface EmployeeService {
    ResponseDataWithCode<ArrayList<Employee>> fetch();

    Employee getById(int id);

    void addList(ArrayList<Employee> employees);

    void addObject(Employee employee);
}
