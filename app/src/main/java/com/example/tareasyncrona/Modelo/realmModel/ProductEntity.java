package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.Product;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductEntity extends RealmObject {

    @PrimaryKey
    private Integer productId = 0;
    private Integer lineId = 0;
    private Integer preSale = 0;
    private Integer providerId = 0;
    private Integer inventory = 0;
    private String name = "";
    private String providerOrder = "";
    private float priceNeto = 0;
    private float priceUnitary = 0;
    private String provider = "";
    private boolean authorizationRmi = false;
    private float ieps = 0;
    private float iva = 0;
    private Integer physicInventory = 0;
    private String order = "";
    private Integer arching = 0;

    public ProductEntity() {
    }

    public ProductEntity(Product product) {
        this.productId = product.getProductId();
        this.lineId = product.getLineId();
        this.preSale = product.getPreSale();
        this.providerId = product.getProviderId();
        this.inventory = product.getInventory();
        this.name = product.getName();
        this.providerOrder = product.getProviderOrder();
        this.priceNeto = product.getPriceNeto();
        this.priceUnitary = product.getPriceUnitary();
        this.provider = product.getProvider();
        this.authorizationRmi = product.isAuthorizationRmi();
        this.ieps = product.getIeps();
        this.iva = product.getIva();
        this.physicInventory = product.getPhysicInventory();
        this.order = product.getOrder();
        this.arching = product.getArching();
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

    public Integer getPreSale() {
        return preSale;
    }

    public void setPreSale(Integer preSale) {
        this.preSale = preSale;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
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

    public float getPriceNeto() {
        return priceNeto;
    }

    public void setPriceNeto(float priceNeto) {
        this.priceNeto = priceNeto;
    }

    public float getPriceUnitary() {
        return priceUnitary;
    }

    public void setPriceUnitary(float priceUnitary) {
        this.priceUnitary = priceUnitary;
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

    public Integer getPhysicInventory() {
        return physicInventory;
    }

    public void setPhysicInventory(Integer physicInventory) {
        this.physicInventory = physicInventory;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getArching() {
        return arching;
    }

    public void setArching(Integer arching) {
        this.arching = arching;
    }
}
