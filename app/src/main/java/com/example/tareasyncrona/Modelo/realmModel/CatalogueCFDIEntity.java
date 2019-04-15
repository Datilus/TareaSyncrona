package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.CatalogueCFDI;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CatalogueCFDIEntity extends RealmObject {
    private Integer active = 0;
    private String key = "";
    private String description = "";
    private String endDate = "";
    private String startDate = "";
    private String fisica = "";
    @PrimaryKey
    private Integer useIdCedis = 0;
    private String moral = "";

    public CatalogueCFDIEntity() {
    }

    public CatalogueCFDIEntity(CatalogueCFDI catalogueCFDI) {
        this.active = catalogueCFDI.getActive();
        this.key = catalogueCFDI.getKey();
        this.description = catalogueCFDI.getDescription();
        this.endDate = catalogueCFDI.getEndDate();
        this.startDate = catalogueCFDI.getStartDate();
        this.fisica = catalogueCFDI.getFisica();
        this.useIdCedis = catalogueCFDI.getUseIdCedis();
        this.moral = catalogueCFDI.getMoral();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public Integer getUseIdCedis() {
        return useIdCedis;
    }

    public void setUseIdCedis(Integer useIdCedis) {
        this.useIdCedis = useIdCedis;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral;
    }
}
