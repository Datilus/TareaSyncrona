package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.ClientProductBonificationEntity;
import com.google.gson.annotations.SerializedName;

public class ClientProductBonification {

    @SerializedName("id_cliente")
    private Integer clientId = 0;
    @SerializedName("id_producto")
    private Integer productId = 0;
    @SerializedName("porcentaje")
    private Double percent = 0.0;
    @SerializedName("afecta_precio")
    private boolean afectPrice = false;
    @SerializedName("activo")
    private Integer active = 0;

    public ClientProductBonification() {
    }

    public ClientProductBonification(Integer clientId, Integer productId, Double percent, boolean afectPrice, Integer active) {
        this.clientId = clientId;
        this.productId = productId;
        this.percent = percent;
        this.afectPrice = afectPrice;
        this.active = active;
    }

    public ClientProductBonification(ClientProductBonificationEntity clientProductBonificationEntity) {
        this.clientId = clientProductBonificationEntity.getClientId();
        this.productId = clientProductBonificationEntity.getProductId();
        this.percent = clientProductBonificationEntity.getPercent();
        this.afectPrice = clientProductBonificationEntity.isAfectPrice();
        this.active = clientProductBonificationEntity.getActive();
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

    public static class Builder {
        private Integer clientId;
        private Integer productId;
        private Double percent;
        private boolean afectPrice;
        private Integer active;

        public Builder() {

        }

        public ClientProductBonification build() {
            return new ClientProductBonification(
                    clientId,
                    productId,
                    percent,
                    afectPrice,
                    active
            );
        }

        public Builder setClientId(Integer clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder setPercent(Double percent) {
            this.percent = percent;
            return this;
        }

        public Builder setAfectPrice(boolean afectPrice) {
            this.afectPrice = afectPrice;
            return this;
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }
    }
}
