package com.example.tareasyncrona.data.db;

import com.example.tareasyncrona.data.api.Tax;

import io.realm.RealmObject;

public class TaxEntity extends RealmObject {

    private String name = "";
    private String concept = "";
    private float percent = 0;
    private String startDate = "";
    private String endDate = "";
    private Integer active = 0;

    public TaxEntity() {
    }

    public TaxEntity(Tax tax) {
        this.name = tax.getName();
        this.concept = tax.getConcept();
        this.percent = tax.getPercent();
        this.startDate = tax.getStartDate();
        this.endDate = tax.getEndDate();
        this.active = tax.getActive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
