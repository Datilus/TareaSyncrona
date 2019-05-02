package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.ProductEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Product {

    @SerializedName("id_linea")
    private Integer lineId = 0;
    @PrimaryKey
    @SerializedName("id_producto")
    private Integer productId = 0;
    @SerializedName("preventa")
    private Integer preSale = 0;
    @SerializedName("id_proveedor")
    private Integer providerId = 0;
    @SerializedName("inventario")
    private Integer inventory = 0;
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("orden_proveedor")
    private String providerOrder = "";
    @SerializedName("precio_neto")
    private float priceNeto = 0;
    @SerializedName("precio_unitario")
    private float priceUnitary = 0;
    @SerializedName("proveedor")
    private String provider = "";
    @SerializedName("rmi_autorizado")
    private boolean authorizationRmi = false;
    @SerializedName("tasa_ieps")
    private float ieps = 0;
    @SerializedName("tasa_iva")
    private float iva = 0;
    @SerializedName("inventario_fisico")
    private Integer physicInventory = 0;
    @SerializedName("order_insert")
    private String order = "";
    @SerializedName("arqueador")
    private Integer arching = 0;

    public Product() {
    }

    public Product(Integer lineId, Integer productId, Integer preSale, Integer providerId, Integer inventory, String name, String providerOrder, float priceNeto, float priceUnitary, String provider, boolean authorizationRmi, float ieps, float iva, Integer physicInventory, String order, Integer arching) {
        this.lineId = lineId;
        this.productId = productId;
        this.preSale = preSale;
        this.providerId = providerId;
        this.inventory = inventory;
        this.name = name;
        this.providerOrder = providerOrder;
        this.priceNeto = priceNeto;
        this.priceUnitary = priceUnitary;
        this.provider = provider;
        this.authorizationRmi = authorizationRmi;
        this.ieps = ieps;
        this.iva = iva;
        this.physicInventory = physicInventory;
        this.order = order;
        this.arching = arching;
    }

    public Product(ProductEntity productEntity) {
        this.lineId = productEntity.getLineId();
        this.productId = productEntity.getProductId();
        this.preSale = productEntity.getPreSale();
        this.providerId = productEntity.getProviderId();
        this.inventory = productEntity.getInventory();
        this.name = productEntity.getName();
        this.providerOrder = productEntity.getProviderOrder();
        this.priceNeto = productEntity.getPriceNeto();
        this.priceUnitary = productEntity.getPriceUnitary();
        this.provider = productEntity.getProvider();
        this.authorizationRmi = productEntity.isAuthorizationRmi();
        this.ieps = productEntity.getIeps();
        this.iva = productEntity.getIva();
        this.physicInventory = productEntity.getPhysicInventory();
        this.order = productEntity.getOrder();
        this.arching = productEntity.getArching();
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public static class Builder {
        private Integer productId;
        private Integer lineId;
        private Integer preSale;
        private Integer providerId;
        private Integer inventory;
        private String name;
        private String providerOrder;
        private float priceNeto;
        private float priceUnitary;
        private String provider;
        private boolean authorizationRmi;
        private float ieps;
        private float iva;
        private Integer physicInventory;
        private String order;
        private Integer arching;

        public Builder() {
        }

        public Product build() {
            return new Product(
                    productId,
                    lineId,
                    preSale,
                    providerId,
                    inventory,
                    name,
                    providerOrder,
                    priceNeto,
                    priceUnitary,
                    provider,
                    authorizationRmi,
                    ieps,
                    iva,
                    physicInventory,
                    order,
                    arching
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

        public Builder setPreSale(Integer preSale) {
            this.preSale = preSale;
            return this;
        }

        public Builder setProviderId(Integer providerId) {
            this.providerId = providerId;
            return this;
        }

        public Builder setInventory(Integer inventory) {
            this.inventory = inventory;
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

        public Builder setPriceNeto(float priceNeto) {
            this.priceNeto = priceNeto;
            return this;
        }

        public Builder setPriceUnitary(float priceUnitary) {
            this.priceUnitary = priceUnitary;
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

        public Builder setPhysicInventory(Integer physicInventory) {
            this.physicInventory = physicInventory;
            return this;
        }

        public Builder setOrder(String order) {
            this.order = order;
            return this;
        }

        public Builder setArching(Integer arching) {
            this.arching = arching;
            return this;
        }
    }
}
