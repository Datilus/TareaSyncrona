package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ClientAuthorizationEntity extends RealmObject {
    @PrimaryKey
    private Integer clientId;
    private Integer creditAuthorized;
    private Integer creditSpecial;
    private Integer timeLimit;
    private Integer creditLimit;
    private Integer invoice;

    public ClientAuthorizationEntity() {
    }

    public ClientAuthorizationEntity(ClientAuthorization clientAuthorization) {
        this.clientId = clientAuthorization.getClientId();
        this.creditAuthorized = clientAuthorization.getCreditAuthorized();
        this.creditSpecial = clientAuthorization.getCreditSpecial();
        this.timeLimit = clientAuthorization.getTimeLimit();
        this.creditLimit = clientAuthorization.getCreditLimit();
        this.invoice = clientAuthorization.getInvoice();
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
}
