package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.ProductRMIEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class ProductRMI {

    @PrimaryKey
    @SerializedName("id_producto")
    private Integer productId = 0;
    @SerializedName("id_linea")
    private Integer lineId = 0;
    @SerializedName("id_proveedor")
    private Integer providerId = 0;
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("orden_proveedor")
    private String providerOrder = "";
    @SerializedName("precio_unitario")
    private float price = 0;
    @SerializedName("proveedor")
    private String provider = "";
    @SerializedName("rmi_autorizado")
    private boolean authorizationRmi = false;
    @SerializedName("tasa_ieps")
    private float ieps = 0;
    @SerializedName("tasa_iva")
    private float iva = 0;

    public ProductRMI() {
    }

    public ProductRMI(Integer productId, Integer lineId, Integer providerId, String name, String providerOrder, float price, String provider, boolean authorizationRmi, float ieps, float iva) {
        this.productId = productId;
        this.lineId = lineId;
        this.providerId = providerId;
        this.name = name;
        this.providerOrder = providerOrder;
        this.price = price;
        this.provider = provider;
        this.authorizationRmi = authorizationRmi;
        this.ieps = ieps;
        this.iva = iva;
    }

    public ProductRMI(ProductRMIEntity productRMIEntity) {
        this.productId = productRMIEntity.getProductId();
        this.lineId = productRMIEntity.getLineId();
        this.providerId = productRMIEntity.getProviderId();
        this.name = productRMIEntity.getName();
        this.providerOrder = productRMIEntity.getProviderOrder();
        this.price = productRMIEntity.getPrice();
        this.provider = productRMIEntity.getProvider();
        this.authorizationRmi = productRMIEntity.isAuthorizationRmi();
        this.ieps = productRMIEntity.getIeps();
        this.iva = productRMIEntity.getIva();
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

    public static class Builder {
        private Integer productId;
        private Integer lineId;
        private Integer providerId;
        private String name;
        private String providerOrder;
        private float price;
        private String provider;
        private boolean authorizationRmi;
        private float ieps;
        private float iva;

        public Builder() {
        }

        public ProductRMI build() {
            return new ProductRMI(
                    productId,
                    lineId,
                    providerId,
                    name,
                    providerOrder,
                    price,
                    provider,
                    authorizationRmi,
                    ieps,
                    iva
            );
        }

        public Builder setProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder setLineId(Integer lineId) {
            this.lineId = lineId;
            return this;
        }

        public Builder setProviderId(Integer providerId) {
            this.providerId = providerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setProviderOrder(String providerOrder) {
            this.providerOrder = providerOrder;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setProvider(String provider) {
            this.provider = provider;
            return this;
        }

        public Builder setAuthorizationRmi(boolean authorizationRmi) {
            this.authorizationRmi = authorizationRmi;
            return this;
        }

        public Builder setIeps(float ieps) {
            this.ieps = ieps;
            return this;
        }

        public Builder setIva(float iva) {
            this.iva = iva;
            return this;
        }
    }
}
