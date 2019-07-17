package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.RouteEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Route {

    @PrimaryKey
    @SerializedName("routeId")
    private Integer routeId = 0;
    @SerializedName("name")
    private Integer name = 0;
    @SerializedName("addClients")
    private Integer addClients = 0;
    @SerializedName("outTravel")
    private Integer outTravel = 0;
    @SerializedName("arqueo")
    private Integer arching = 0;
    @SerializedName("delivery_hour")
    private String deliveryHour = "";

    public Route() {
    }

    public Route(Integer routeId, Integer name, Integer addClients, Integer outTravel, Integer arching, String deliveryHour) {
        this.routeId = routeId;
        this.name = name;
        this.addClients = addClients;
        this.outTravel = outTravel;
        this.arching = arching;
        this.deliveryHour = deliveryHour;
    }

    public Route(RouteEntity routeEntity) {
        this.routeId = routeEntity.getRouteId();
        this.name = routeEntity.getName();
        this.addClients = routeEntity.getAddClients();
        this.outTravel = routeEntity.getOutTravel();
        this.arching = routeEntity.getArching();
        this.deliveryHour = routeEntity.getDeliveryHour();
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

    public static class Builder {
        private Integer routeId;
        private Integer name;
        private Integer addClients;
        private Integer outTravel;
        private Integer arching;
        private String deliveryHour;

        public Builder() {
        }

        public Route build(){
            return new Route(
                    routeId,
                    name,
                    addClients,
                    outTravel,
                    arching,
                    deliveryHour
            );
        }

        public Builder setRouteId(Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setName(Integer name) {
            this.name = name;
            return this;
        }

        public Builder setAddClients(Integer addClients) {
            this.addClients = addClients;
            return this;
        }

        public Builder setOutTravel(Integer outTravel) {
            this.outTravel = outTravel;
            return this;
        }

        public Builder setArching(Integer arching) {
            this.arching = arching;
            return this;
        }

        public Builder setDeliveryHour(String deliveryHour) {
            this.deliveryHour = deliveryHour;
            return this;
        }
    }
}
