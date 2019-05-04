package com.example.tareasyncrona.modelo.jsonModel;

import com.example.tareasyncrona.modelo.realmModel.ClientAuthorizationEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class ClientAuthorization {
    @PrimaryKey
    @SerializedName("clientId")
    private Integer clientId;
    @SerializedName("creditAuthorized")
    private Integer creditAuthorized;
    @SerializedName("creditSpecial")
    private Integer creditSpecial;
    @SerializedName("timeLimit")
    private Integer timeLimit;
    @SerializedName("creditLimit")
    private Integer creditLimit;
    @SerializedName("invoice")
    private Integer invoice;

    public ClientAuthorization() {
    }

    public ClientAuthorization(Integer clientId, Integer creditAuthorized, Integer creditSpecial, Integer timeLimit, Integer creditLimit, Integer invoice) {
        this.clientId = clientId;
        this.creditAuthorized = creditAuthorized;
        this.creditSpecial = creditSpecial;
        this.timeLimit = timeLimit;
        this.creditLimit = creditLimit;
        this.invoice = invoice;
    }

    public ClientAuthorization(ClientAuthorizationEntity clientAuthorizationEntity) {
        this.clientId = clientAuthorizationEntity.getClientId();
        this.creditAuthorized = clientAuthorizationEntity.getCreditAuthorized();
        this.creditSpecial = clientAuthorizationEntity.getCreditSpecial();
        this.timeLimit = clientAuthorizationEntity.getTimeLimit();
        this.creditLimit = clientAuthorizationEntity.getCreditLimit();
        this.invoice = clientAuthorizationEntity.getInvoice();
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCreditAuthorized() {
        return creditAuthorized;
    }

    public void setCreditAuthorized(Integer creditAuthorized) {
        this.creditAuthorized = creditAuthorized;
    }

    public Integer getCreditSpecial() {
        return creditSpecial;
    }

    public void setCreditSpecial(Integer creditSpecial) {
        this.creditSpecial = creditSpecial;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public static class Builder{
        private Integer clientId;
        private Integer creditAuthorized;
        private Integer creditSpecial;
        private Integer timeLimit;
        private Integer creditLimit;
        private Integer invoice;

        public Builder(){}

        public ClientAuthorization build(){
            return new ClientAuthorization(
                    clientId,
                    creditAuthorized,
                    creditSpecial,
                    timeLimit,
                    creditLimit,
                    invoice);
        }

        public Builder setClientId(Integer clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setCreditAuthorized(Integer creditAuthorized) {
            this.creditAuthorized = creditAuthorized;
            return this;
        }

        public Builder setCreditSpecial(Integer creditSpecial) {
            this.creditSpecial = creditSpecial;
            return this;
        }

        public Builder setTimeLimit(Integer timeLimit) {
            this.timeLimit = timeLimit;
            return this;
        }

        public Builder setCreditLimit(Integer creditLimit) {
            this.creditLimit = creditLimit;
            return this;
        }

        public Builder setInvoice(Integer invoice) {
            this.invoice = invoice;
            return this;
        }
    }
}
