package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.EmployeeEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Employee {

    @PrimaryKey
    @SerializedName("id_empleado")
    private Integer employeeId = 0;
    @SerializedName("id_puesto")
    private Integer jobId = 0;
    @SerializedName("limite_credito")
    private Double creditLimit = 0.0;
    @SerializedName("empleado")
    private String employee = "";
    @SerializedName("id_ruta")
    private Integer routeId = 0;
    @SerializedName("id_lista_precio_por_ruta")
    private Integer priceListByRouteId = 0;
    @SerializedName("ruta")
    private Integer route = 0;
    @SerializedName("tipo_ruta")
    private Integer routeType = 0;
    @SerializedName("tipo_mercado")
    private Integer marketType = 0;
    @SerializedName("usuario")
    private String user = "";
    @SerializedName("contrasenia")
    private String password = "";
    @SerializedName("fecha")
    private String date = "";

    public Employee() {
    }

    public Employee(Integer employeeId, Integer jobId, Double creditLimit, String employee, Integer routeId, Integer priceListByRouteId, Integer route, Integer routeType, Integer marketType, String user, String password, String date) {
        this.employeeId = employeeId;
        this.jobId = jobId;
        this.creditLimit = creditLimit;
        this.employee = employee;
        this.routeId = routeId;
        this.priceListByRouteId = priceListByRouteId;
        this.route = route;
        this.routeType = routeType;
        this.marketType = marketType;
        this.user = user;
        this.password = password;
        this.date = date;
    }

    public Employee(EmployeeEntity employeeEntity) {
        this.employeeId = employeeEntity.getEmployeeId();
        this.jobId = employeeEntity.getJobId();
        this.creditLimit = employeeEntity.getCreditLimit();
        this.employee = employeeEntity.getEmployee();
        this.routeId = employeeEntity.getRouteId();
        this.priceListByRouteId = employeeEntity.getPriceListByRouteId();
        this.route = employeeEntity.getRoute();
        this.routeType = employeeEntity.getRouteType();
        this.marketType = employeeEntity.getMarketType();
        this.user = employeeEntity.getUser();
        this.password = employeeEntity.getPassword();
        this.date = employeeEntity.getDate();
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

    public static class Builder {
        private Integer employeeId;
        private Integer jobId;
        private Double creditLimit;
        private String employee;
        private Integer routeId;
        private Integer priceListByRouteId;
        private Integer route;
        private Integer routeType;
        private Integer marketType;
        private String user;
        private String password;
        private String date;

        public Builder() {
        }

        public Employee build() {
            return new Employee(
                    employeeId,
                    jobId,
                    creditLimit,
                    employee,
                    routeId,
                    priceListByRouteId,
                    route,
                    routeType,
                    marketType,
                    user,
                    password,
                    date
            );
        }

        public Builder setEmployeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setJobId(Integer jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder setCreditLimit(Double creditLimit) {
            this.creditLimit = creditLimit;
            return this;
        }

        public Builder setEmployee(String employee) {
            this.employee = employee;
            return this;
        }

        public Builder setRouteId(Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setPriceListByRouteId(Integer priceListByRouteId) {
            this.priceListByRouteId = priceListByRouteId;
            return this;
        }

        public Builder setRoute(Integer route) {
            this.route = route;
            return this;
        }

        public Builder setRouteType(Integer routeType) {
            this.routeType = routeType;
            return this;
        }

        public Builder setMarketType(Integer marketType) {
            this.marketType = marketType;
            return this;
        }

        public Builder setUser(String user) {
            this.user = user;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

    }
}
