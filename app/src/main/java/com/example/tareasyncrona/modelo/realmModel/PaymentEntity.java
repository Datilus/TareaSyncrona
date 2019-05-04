package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.Payment;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PaymentEntity extends RealmObject {

    @PrimaryKey
    private String paymentId = "";
    private Integer chargeId = 0;
    private String date = "";
    private Integer routeId = 0;
    private Double amount = 0.0;
    private String type = "";
    private Integer userRegister = 0;
    private Integer active = 0;
    private String hour = "";

    public PaymentEntity() {
    }

    public PaymentEntity(Payment payment) {
        this.paymentId = payment.getPaymentId();
        this.chargeId = payment.getChargeId();
        this.date = payment.getDate();
        this.routeId = payment.getRouteId();
        this.amount = payment.getAmount();
        this.type = payment.getType();
        this.userRegister = payment.getUserRegister();
        this.active = payment.getActive();
        this.hour = payment.getHour();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(Integer userRegister) {
        this.userRegister = userRegister;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
