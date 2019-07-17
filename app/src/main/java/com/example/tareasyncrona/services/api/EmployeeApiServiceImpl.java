package com.example.tareasyncrona.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.example.tareasyncrona.Constants;
import com.example.tareasyncrona.data.api.Employee;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.ResponseList;
import com.example.tareasyncrona.domain.services.interfaces.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EmployeeApiServiceImpl implements EmployeeService {

    private static EmployeeApiServiceImpl instance;

    private EmployeeApiServiceImpl() {
    }

    public static EmployeeApiServiceImpl getInstance() {
        if (instance == null)
            instance = new EmployeeApiServiceImpl();
        return instance;
    }


    @Override
    public ResponseDataWithCode<ArrayList<Employee>> fetch() {
        String URL = Constants.Api.URL.getIP() + "/api/cedis/1/employees";
        ANRequest request = AndroidNetworking.get(URL)
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
    public void addList(ArrayList<Employee> employees) {

    }

    @Override
    public void addObject(Employee employee) {

    }
}
