package com.example.tareasyncrona.modelo.jsonModel;

import com.example.tareasyncrona.modelo.realmModel.FolioEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Folio {

    @PrimaryKey
    @SerializedName("serieId")
    private Integer serieId = 0;
    @SerializedName("serie")
    private String serie = "";
    @SerializedName("folioInitial")
    private Integer initialFolio = 0;
    @SerializedName("folioFinal")
    private Integer finalFolio = 0;
    @SerializedName("folioCurrent")
    private Integer folioCurrent = 0;
    @SerializedName("status")
    private Integer status = 0;
    @SerializedName("concept")
    private String concept = "";

    public Folio() {
    }

    public Folio(Integer serieId, String serie, Integer initialFolio, Integer finalFolio, Integer folioCurrent, Integer status, String concept) {
        this.serieId = serieId;
        this.serie = serie;
        this.initialFolio = initialFolio;
        this.finalFolio = finalFolio;
        this.folioCurrent = folioCurrent;
        this.status = status;
        this.concept = concept;
    }

    public Folio(FolioEntity folioEntity) {
        this.serieId = folioEntity.getSerieId();
        this.serie = folioEntity.getSerie();
        this.initialFolio = folioEntity.getInitialFolio();
        this.finalFolio = folioEntity.getFinalFolio();
        this.folioCurrent = folioEntity.getFolioCurrent();
        this.status = folioEntity.getStatus();
        this.concept = folioEntity.getConcept();
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getInitialFolio() {
        return initialFolio;
    }

    public void setInitialFolio(Integer initialFolio) {
        this.initialFolio = initialFolio;
    }

    public Integer getFinalFolio() {
        return finalFolio;
    }

    public void setFinalFolio(Integer finalFolio) {
        this.finalFolio = finalFolio;
    }

    public Integer getFolioCurrent() {
        return folioCurrent;
    }

    public void setFolioCurrent(Integer folioCurrent) {
        this.folioCurrent = folioCurrent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public static class Builder {
        private Integer serieId;
        private String serie;
        private Integer initialFolio;
        private Integer finalFolio;
        private Integer folioCurrent;
        private Integer status;
        private String concept;

        public Builder() {

        }

        public Folio build() {
            return new Folio(
                    serieId,
                    serie,
                    initialFolio,
                    finalFolio,
                    folioCurrent,
                    status,
                    concept
            );
        }

        public Builder setSerieId(Integer serieId) {
            this.serieId = serieId;
            return this;
        }

        public Builder setSerie(String serie) {
            this.serie = serie;
            return this;
        }

        public Builder setInitialFolio(Integer initialFolio) {
            this.initialFolio = initialFolio;
            return this;
        }

        public Builder setFinalFolio(Integer finalFolio) {
            this.finalFolio = finalFolio;
            return this;
        }

        public Builder setFolioCurrent(Integer folioCurrent) {
            this.folioCurrent = folioCurrent;
            return this;
        }

        public Builder setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Builder setConcept(String concept) {
            this.concept = concept;
            return this;
        }
    }
}
