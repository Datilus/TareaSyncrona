package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.Folio;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FolioEntity extends RealmObject {

    @PrimaryKey
    private Integer serieId = 0;
    private String serie = "";
    private Integer initialFolio = 0;
    private Integer finalFolio = 0;
    private Integer folioCurrent = 0;
    private Integer status = 0;
    private String concept = "";

    public FolioEntity() {
    }

    public FolioEntity(Folio folio) {
        this.serieId = folio.getSerieId();
        this.serie = folio.getSerie();
        this.initialFolio = folio.getInitialFolio();
        this.finalFolio = folio.getFinalFolio();
        this.folioCurrent = folio.getFolioCurrent();
        this.status = folio.getStatus();
        this.concept = folio.getConcept();
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
}
