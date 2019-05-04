package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.ClientExhibitor;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ClientExhibitorEntity extends RealmObject {
    @PrimaryKey
    private Integer clientIdExhibitor = 0;
    private Integer clientId = 0;
    private Integer exhibitorId = 0;
    private Integer routeId = 0;
    private Integer active = 0;

    public ClientExhibitorEntity() {
    }

    public ClientExhibitorEntity(ClientExhibitor clientExhibitor) {
        this.clientIdExhibitor = clientExhibitor.getClientIdExhibitor();
        this.clientId = clientExhibitor.getClientId();
        this.exhibitorId = clientExhibitor.getExhibitorId();
        this.routeId = clientExhibitor.getRouteId();
        this.active = clientExhibitor.getActive();
    }

    public Integer getClientIdExhibitor() {
        return clientIdExhibitor;
    }

    public void setClientIdExhibitor(Integer clientIdExhibitor) {
        this.clientIdExhibitor = clientIdExhibitor;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getExhibitorId() {
        return exhibitorId;
    }

    public void setExhibitorId(Integer exhibitorId) {
        this.exhibitorId = exhibitorId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
