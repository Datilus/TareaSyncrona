package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.ProductRMI;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductRMIEntity extends RealmObject {

    @PrimaryKey
    private Integer productId = 0;
    private Integer lineId = 0;
    private Integer providerId = 0;
    private String name = "";
    private String providerOrder = "";
    private float price = 0;
    private String provider = "";
    private boolean authorizationRmi = false;
    private float ieps = 0;
    private float iva = 0;

    public ProductRMIEntity() {
    }

    public ProductRMIEntity(ProductRMI productRMI) {
        this.productId = productRMI.getProductId();
        this.lineId = productRMI.getLineId();
        this.providerId = productRMI.getProviderId();
        this.name = productRMI.getName();
        this.providerOrder = productRMI.getProviderOrder();
        this.price = productRMI.getPrice();
        this.provider = productRMI.getProvider();
        this.authorizationRmi = productRMI.isAuthorizationRmi();
        this.ieps = productRMI.getIeps();
        this.iva = productRMI.getIva();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderOrder() {
        return providerOrder;
    }

    public void setProviderOrder(String providerOrder) {
        this.providerOrder = providerOrder;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isAuthorizationRmi() {
        return authorizationRmi;
    }

    public void setAuthorizationRmi(boolean authorizationRmi) {
        this.authorizationRmi = authorizationRmi;
    }

    public float getIeps() {
        return ieps;
    }

    public void setIeps(float ieps) {
        this.ieps = ieps;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }
}
