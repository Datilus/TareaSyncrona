package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.Line;

import io.realm.RealmObject;

public class LineEntity extends RealmObject {

    private Integer lineId = 0;
    private Integer active = 0;
    private String account0 = "";
    private String account16 = "";
    private Integer groupProviderId = 0;
    private String name = "";
    private String order = "";
    private String registrationDate = "";
    private Integer registrationUser = 0;

    public LineEntity() {
    }

    public LineEntity(Line line) {
        this.lineId = line.getLineId();
        this.active = line.getActive();
        this.account0 = line.getAccount0();
        this.account16 = line.getAccount16();
        this.groupProviderId = line.getGroupProviderId();
        this.name = line.getName();
        this.order = line.getOrder();
        this.registrationDate = line.getRegistrationDate();
        this.registrationUser = line.getRegistrationUser();
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getAccount0() {
        return account0;
    }

    public void setAccount0(String account0) {
        this.account0 = account0;
    }

    public String getAccount16() {
        return account16;
    }

    public void setAccount16(String account16) {
        this.account16 = account16;
    }

    public Integer getGroupProviderId() {
        return groupProviderId;
    }

    public void setGroupProviderId(Integer groupProviderId) {
        this.groupProviderId = groupProviderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getRegistrationUser() {
        return registrationUser;
    }

    public void setRegistrationUser(Integer registrationUser) {
        this.registrationUser = registrationUser;
    }
}
