package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.FormVisitEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class FormVisit {

    @SerializedName("justificacion")
    private String justification = "";
    @SerializedName("fecha_vigencia")
    private String validitydate = "";
    @PrimaryKey
    @SerializedName("id_visita")
    private int visitid = 0;
    @SerializedName("id_tipo_visita")
    private int typevisitid = 0;
    @SerializedName("activo")
    private int active = 0;
    @SerializedName("id_ruta")
    private int routeid = 0;

    public FormVisit() {
    }

    public FormVisit(String justification, String validitydate, int visitid, int typevisitid, int active, int routeid) {
        this.justification = justification;
        this.validitydate = validitydate;
        this.visitid = visitid;
        this.typevisitid = typevisitid;
        this.active = active;
        this.routeid = routeid;
    }

    public FormVisit(FormVisitEntity formVisitEntity) {
        this.justification = formVisitEntity.getJustification();
        this.validitydate = formVisitEntity.getValiditydate();
        this.visitid = formVisitEntity.getVisitid();
        this.typevisitid = formVisitEntity.getTypevisitid();
        this.active = formVisitEntity.getActive();
        this.routeid = formVisitEntity.getRouteid();
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getValiditydate() {
        return validitydate;
    }

    public void setValiditydate(String validitydate) {
        this.validitydate = validitydate;
    }

    public int getVisitid() {
        return visitid;
    }

    public void setVisitid(int visitid) {
        this.visitid = visitid;
    }

    public int getTypevisitid() {
        return typevisitid;
    }

    public void setTypevisitid(int typevisitid) {
        this.typevisitid = typevisitid;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getRouteid() {
        return routeid;
    }

    public void setRouteid(int routeid) {
        this.routeid = routeid;
    }

    public static class Builder {

        private String justification;
        private String validitydate;
        private int visitid;
        private int typevisitid;
        private int active;
        private int routeid;

        public Builder() {
        }

        public FormVisit build() {
            return new FormVisit(
                    justification,
                    validitydate,
                    visitid,
                    typevisitid,
                    active,
                    routeid
            );
        }

        public Builder setJustification(String justification) {
            this.justification = justification;
            return this;
        }

        public Builder setValiditydate(String validitydate) {
            this.validitydate = validitydate;
            return this;
        }

        public Builder setVisitid(int visitid) {
            this.visitid = visitid;
            return this;
        }

        public Builder setTypevisitid(int typevisitid) {
            this.typevisitid = typevisitid;
            return this;
        }

        public Builder setActive(int active) {
            this.active = active;
            return this;
        }

        public Builder setRouteid(int routeid) {
            this.routeid = routeid;
            return this;
        }
    }
}
