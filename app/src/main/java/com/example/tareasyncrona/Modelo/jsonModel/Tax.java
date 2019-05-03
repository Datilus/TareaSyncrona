package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.TaxEntity;
import com.google.gson.annotations.SerializedName;

public class Tax {

    @SerializedName("nombre")
    private String name = "";
    @SerializedName("concepto")
    private String concept = "";
    @SerializedName("importe")
    private float percent = 0;
    @SerializedName("fecha_inicio")
    private String startDate = "";
    @SerializedName("fecha_fin")
    private String endDate = "";
    @SerializedName("activo")
    private Integer active = 0;

    public Tax() {
    }

    public Tax(String name, String concept, float percent, String startDate, String endDate, Integer active) {
        this.name = name;
        this.concept = concept;
        this.percent = percent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    public Tax(TaxEntity taxEntity) {
        this.name = taxEntity.getName();
        this.concept = taxEntity.getConcept();
        this.percent = taxEntity.getPercent();
        this.startDate = taxEntity.getStartDate();
        this.endDate = taxEntity.getEndDate();
        this.active = taxEntity.getActive();
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

    public static class Builder {
        private String name;
        private String concept;
        private float percent;
        private String startDate;
        private String endDate;
        private Integer active;

        public Builder() {
        }

        public Tax build() {
            return new Tax(
                    name,
                    concept,
                    percent,
                    startDate,
                    endDate,
                    active
            );
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setConcept(String concept) {
            this.concept = concept;
            return this;
        }

        public Builder setPercent(float percent) {
            this.percent = percent;
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

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }
    }
}
