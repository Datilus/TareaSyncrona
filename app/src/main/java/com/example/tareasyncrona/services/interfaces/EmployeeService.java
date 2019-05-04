package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Employee;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface EmployeeService {

    ResponseDataWithCode<ArrayList<Employee>> fetch();

    Employee getById(int id);

    void add(Employee employee);

    void addList(ArrayList<Employee> employees);
}
