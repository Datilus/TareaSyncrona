package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.Cedi;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CediEntity extends RealmObject {
    @PrimaryKey
    private Integer cedisId = 0;
    private String key = "";
    private String cedisName = "";
    private Integer priceListId = 0;
    private String latitude = "";
    private String longitude = "";
    private String company = "";
    private String address = "";

    public CediEntity() {
    }

    public CediEntity(Cedi cedi) {
        this.cedisId = cedi.getCedisId();
        this.key = cedi.getKey();
        this.cedisName = cedi.getCedisName();
        this.priceListId = cedi.getPriceListId();
        this.latitude = cedi.getLatitude();
        this.longitude = cedi.getLongitude();
        this.company = cedi.getCompany();
        this.address = cedi.getAddress();
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

}
