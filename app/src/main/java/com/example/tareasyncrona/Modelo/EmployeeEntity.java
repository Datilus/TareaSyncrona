package com.example.tareasyncrona.Modelo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EmployeeEntity extends RealmObject {

    @PrimaryKey
    private Integer employeeId = 0;
    private Integer jobId = 0;
    private Double creditLimit = 0.0;
    private String employee = "";
    private Integer routeId = 0;
    private Integer priceListByRouteId = 0;
    private Integer route = 0;
    private Integer routeType = 0;
    private Integer marketType = 0;
    private String user = "";
    private String password = "";
    private String date = "";

    public EmployeeEntity() {

    }

    public EmployeeEntity(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.jobId = employee.getJobId();
        this.creditLimit = employee.getCreditLimit();
        this.employee = employee.getEmployee();
        this.routeId = employee.getRouteId();
        this.priceListByRouteId = employee.getPriceListByRouteId();
        this.route = employee.getRoute();
        this.routeType = employee.getRouteType();
        this.marketType = employee.getMarketType();
        this.user = employee.getUser();
        this.password = employee.getPassword();
        this.date = employee.getDate();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getPriceListByRouteId() {
        return priceListByRouteId;
    }

    public void setPriceListByRouteId(Integer priceListByRouteId) {
        this.priceListByRouteId = priceListByRouteId;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    public Integer getMarketType() {
        return marketType;
    }

    public void setMarketType(Integer marketType) {
        this.marketType = marketType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
