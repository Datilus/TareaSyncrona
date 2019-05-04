package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.Route;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RouteEntity extends RealmObject {

    @PrimaryKey
    private Integer routeId = 0;
    private Integer name = 0;
    private Integer addClients = 0;
    private Integer outTravel = 0;
    private Integer arching = 0;
    private String deliveryHour = "";

    public RouteEntity() {
    }

    public RouteEntity(Route route) {
        this.routeId = route.getRouteId();
        this.name = route.getName();
        this.addClients = route.getAddClients();
        this.outTravel = route.getOutTravel();
        this.arching = route.getArching();
        this.deliveryHour = route.getDeliveryHour();
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getAddClients() {
        return addClients;
    }

    public void setAddClients(Integer addClients) {
        this.addClients = addClients;
    }

    public Integer getOutTravel() {
        return outTravel;
    }

    public void setOutTravel(Integer outTravel) {
        this.outTravel = outTravel;
    }

    public Integer getArching() {
        return arching;
    }

    public void setArching(Integer arching) {
        this.arching = arching;
    }

    public String getDeliveryHour() {
        return deliveryHour;
    }

    public void setDeliveryHour(String deliveryHour) {
        this.deliveryHour = deliveryHour;
    }
}
