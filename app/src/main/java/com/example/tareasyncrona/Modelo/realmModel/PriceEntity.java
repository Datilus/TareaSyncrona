package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.Price;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PriceEntity extends RealmObject {

    @PrimaryKey
    private Integer productId = 0;
    private String name = "";
    private String startDate = "";
    private String endDate = "";
    private float priceUnitary = 0;

    public PriceEntity() {
    }

    public PriceEntity(Price price) {
        this.productId = price.getProductId();
        this.name = price.getName();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.priceUnitary = price.getPriceUnitary();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getPriceUnitary() {
        return priceUnitary;
    }

    public void setPriceUnitary(float priceUnitary) {
        this.priceUnitary = priceUnitary;
    }
}
