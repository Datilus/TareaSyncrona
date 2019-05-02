package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.PriceEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Price {

    @PrimaryKey
    @SerializedName("id_producto")
    private Integer productId = 0;
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("fecha_inicio")
    private String startDate = "";
    @SerializedName("fecha_fin")
    private String endDate = "";
    @SerializedName("precio_unitario")
    private float priceUnitary = 0;

    public Price() {
    }

    public Price(Integer productId, String name, String startDate, String endDate, float priceUnitary) {
        this.productId = productId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceUnitary = priceUnitary;
    }

    public Price(PriceEntity priceEntity) {
        this.productId = priceEntity.getProductId();
        this.name = priceEntity.getName();
        this.startDate = priceEntity.getStartDate();
        this.endDate = priceEntity.getEndDate();
        this.priceUnitary = priceEntity.getPriceUnitary();
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

    public static class Builder {

        private Integer productId;
        private String name;
        private String startDate;
        private String endDate;
        private float priceUnitary;

        public Builder() {
        }

        public Price build() {
            return new Price(
                    productId,
                    name,
                    startDate,
                    endDate,
                    priceUnitary
            );
        }

        public Builder setProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setPriceUnitary(float priceUnitary) {
            this.priceUnitary = priceUnitary;
            return this;
        }
    }
}

