package com.example.tareasyncrona.API;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Modelo.jsonModel.Employee;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl instance;

    private EmployeeServiceImpl(){}

    public static EmployeeServiceImpl getInstance(){
        if (instance == null)
            instance = new EmployeeServiceImpl();
        return instance;
    }


    @Override
    public ArrayList<Employee> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/cedis/1/employees")
                .build();

        ANResponse<ResponseList<Employee>> response = request.executeForObject(ResponseList.class);

        ArrayList<Employee> employees = null;

        if (response.isSuccess() && response.getResult().getData() != null) {
            employees = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Employee>>() {
                            }.getType());
        } else if (response.isSuccess() && response.getResult().getData() == null) { //Crea un empleado por defecto, al no enviar uno la API
            employees.add(new Employee());
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void addList(ArrayList<Employee> employees) {

    }
}
