package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.CediEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Cedi {
    @PrimaryKey
    @SerializedName("id_cedis")
    private Integer cedisId = 0;
    @SerializedName("clave")
    private String key = "";
    @SerializedName("nombre_cedis")
    private String cedisName = "";
    @SerializedName("id_lista_precio")
    private Integer priceListId = 0;
    @SerializedName("latitud")
    private String latitude = "";
    @SerializedName("longitud")
    private String longitude = "";
    @SerializedName("empresa")
    private String company = "";
    @SerializedName("domicilio")
    private String address = "";

    public Cedi() {
    }

    public Cedi(Integer cedisId, String key, String cedisName, Integer priceListId, String latitude, String longitude, String company, String address) {
        this.cedisId = cedisId;
        this.key = key;
        this.cedisName = cedisName;
        this.priceListId = priceListId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.company = company;
        this.address = address;
    }

    public Cedi(CediEntity cediEntity) {
        this.cedisId = cediEntity.getCedisId();
        this.key = cediEntity.getKey();
        this.cedisName = cediEntity.getCedisName();
        this.priceListId = cediEntity.getPriceListId();
        this.latitude = cediEntity.getLatitude();
        this.longitude = cediEntity.getLongitude();
        this.company = cediEntity.getCompany();
        this.address = cediEntity.getAddress();

    }

    public Integer getCedisId() {
        return cedisId;
    }

    public void setCedisId(Integer cedisId) {
        this.cedisId = cedisId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCedisName() {
        return cedisName;
    }

    public void setCedisName(String cedisName) {
        this.cedisName = cedisName;
    }

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static class Builder {
        private Integer cedisId;
        private String key;
        private String cedisName;
        private Integer priceListId;
        private String latitude;
        private String longitude;
        private String company;
        private String address;
        private String version;

        public Builder() {
        }

        public Cedi build() {
            return new Cedi(
                    cedisId,
                    key,
                    cedisName,
                    priceListId,
                    latitude,
                    longitude,
                    company,
                    address);
        }

        public Builder setCedisId(Integer cedisId) {
            this.cedisId = cedisId;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setCedisName(String cedisName) {
            this.cedisName = cedisName;
            return this;
        }

        public Builder setPriceListId(Integer priceListId) {
            this.priceListId = priceListId;
            return this;
        }

        public Builder setLatitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
    }
}
