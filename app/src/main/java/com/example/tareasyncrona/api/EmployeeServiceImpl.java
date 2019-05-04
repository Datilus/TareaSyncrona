package com.example.tareasyncrona.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.modelo.jsonModel.Employee;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.ResponseList;
import com.example.tareasyncrona.services.interfaces.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl instance;

    private EmployeeServiceImpl() {
    }

    public static EmployeeServiceImpl getInstance() {
        if (instance == null)
            instance = new EmployeeServiceImpl();
        return instance;
    }


    @Override
    public ResponseDataWithCode<ArrayList<Employee>> fetch() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/cedis/1/employees")
                .build();

        ANResponse<ResponseList<Employee>> response = request.executeForObject(ResponseList.class);

        ArrayList<Employee> employees = null;
        String message;

        if (response.isSuccess() && response.getResult().getData() != null) {
            employees = new GsonBuilder()
                    .create()
                    .fromJson(new Gson().toJsonTree(response.getResult().getData()),
                            new TypeToken<ArrayList<Employee>>() {
                            }.getType());
            message = response.getResult().getMessage();
        } else {
            message = response.getError().getMessage();
        }

        if (response.getOkHttpResponse() == null) {
            return new ResponseDataWithCode<>(employees, 102, message);
        }

        return new ResponseDataWithCode<>(employees, response.getOkHttpResponse().code(), message);
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
