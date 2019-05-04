package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.ClientProductBonification;

import io.realm.RealmObject;

public class ClientProductBonificationEntity extends RealmObject {

    private Integer clientId = 0;
    private Integer productId = 0;
    private Double percent = 0.0;
    private boolean afectPrice = false;
    private Integer active = 0;

    public ClientProductBonificationEntity() {
    }

    public ClientProductBonificationEntity(ClientProductBonification clientProductBonification) {
        this.clientId = clientProductBonification.getClientId();
        this.productId = clientProductBonification.getProductId();
        this.percent = clientProductBonification.getPercent();
        this.afectPrice = clientProductBonification.isAfectPrice();
        this.active = clientProductBonification.getActive();
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public boolean isAfectPrice() {
        return afectPrice;
    }

    public void setAfectPrice(boolean afectPrice) {
        this.afectPrice = afectPrice;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
