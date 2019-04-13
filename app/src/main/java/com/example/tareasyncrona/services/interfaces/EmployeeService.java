package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<Employee> fetch();
    Employee get(int id);
    void add(Employee employee);
    void addList(ArrayList<Employee> employees);
}
