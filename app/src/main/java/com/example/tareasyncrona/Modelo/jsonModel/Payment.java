package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.PaymentEntity;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import io.realm.annotations.PrimaryKey;

public class Payment {

    @PrimaryKey
    private String paymentId = UUID.randomUUID().toString();
    @SerializedName("chargeId")
    private Integer chargeId = 0;
    @SerializedName("date")
    private String date = "";
    @SerializedName("routeId")
    private Integer routeId = 0;
    @SerializedName("amount")
    private Double amount = 0.0;
    @SerializedName("type")
    private String type = "";
    @SerializedName("userRegister")
    private Integer userRegister = 0;
    @SerializedName("activo")
    private Integer active = 0;
    private String hour = "";

    public Payment() {
    }

    public Payment(String paymentId, Integer chargeId, String date, Integer routeId, Double amount, String type, Integer userRegister, Integer active, String hour) {
        this.paymentId = paymentId;
        this.chargeId = chargeId;
        this.date = date;
        this.routeId = routeId;
        this.amount = amount;
        this.type = type;
        this.userRegister = userRegister;
        this.active = active;
        this.hour = hour;
    }

    public Payment(PaymentEntity paymentEntity) {
        this.paymentId = paymentEntity.getPaymentId();
        this.chargeId = paymentEntity.getChargeId();
        this.date = paymentEntity.getDate();
        this.routeId = paymentEntity.getRouteId();
        this.amount = paymentEntity.getAmount();
        this.type = paymentEntity.getType();
        this.userRegister = paymentEntity.getUserRegister();
        this.active = paymentEntity.getActive();
        this.hour = paymentEntity.getHour();
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

    public static class Builder {
        private String paymentId;
        private Integer chargeId;
        private String date;
        private Integer routeId;
        private Double amount;
        private String type;
        private Integer userRegister;
        private Integer active;
        private String hour;

        public Builder() {

        }

        public Payment build() {
            return new Payment(
                    paymentId,
                    chargeId,
                    date,
                    routeId,
                    amount,
                    type,
                    userRegister,
                    active,
                    hour
            );
        }

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setChargeId(Integer chargeId) {
            this.chargeId = chargeId;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setRouteId(Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setUserRegister(Integer userRegister) {
            this.userRegister = userRegister;
            return this;
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }

        public Builder setHour(String hour) {
            this.hour = hour;
            return this;
        }
    }
}
