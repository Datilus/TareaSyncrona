package com.example.tareasyncrona.data.db;

import com.example.tareasyncrona.data.api.FormVisit;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FormVisitEntity extends RealmObject {

    private String justification = "";
    private String validitydate = "";
    @PrimaryKey
    private int visitid = 0;
    private int typevisitid = 0;
    private int active = 0;
    private int routeid = 0;

    public FormVisitEntity() {
    }

    public FormVisitEntity(FormVisit formVisit) {
        this.justification = formVisit.getJustification();
        this.validitydate = formVisit.getValiditydate();
        this.visitid = formVisit.getVisitid();
        this.typevisitid = formVisit.getTypevisitid();
        this.active = formVisit.getActive();
        this.routeid = formVisit.getRouteid();
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
}
