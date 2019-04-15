package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<Employee> fetch();
    Employee getById(int id);
    void add(Employee employee);
    void addList(ArrayList<Employee> employees);
}
