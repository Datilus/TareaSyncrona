package com.example.tareasyncrona.modelo.jsonModel;

import com.example.tareasyncrona.modelo.realmModel.ClientExhibitorEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class ClientExhibitor {
    @PrimaryKey
    @SerializedName("clientIdExhibitor")
    private Integer clientIdExhibitor = 0;
    @SerializedName("clientId")
    private Integer clientId = 0;
    @SerializedName("exhibitorId")
    private Integer exhibitorId = 0;
    @SerializedName("routeId")
    private Integer routeId = 0;
    @SerializedName("active")
    private Integer active = 0;

    public ClientExhibitor() {
    }

    public ClientExhibitor(Integer clientIdExhibitor, Integer clientId, Integer exhibitorId, Integer routeId, Integer active) {
        this.clientIdExhibitor = clientIdExhibitor;
        this.clientId = clientId;
        this.exhibitorId = exhibitorId;
        this.routeId = routeId;
        this.active = active;
    }

    public ClientExhibitor(ClientExhibitorEntity clientExhibitorEntity) {
        this.clientIdExhibitor = clientExhibitorEntity.getClientIdExhibitor();
        this.clientId = clientExhibitorEntity.getClientId();
        this.exhibitorId = clientExhibitorEntity.getExhibitorId();
        this.routeId = clientExhibitorEntity.getRouteId();
        this.active = clientExhibitorEntity.getActive();
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

    public static class Builder{
        private Integer clientIdExhibitor;
        private Integer clientId;
        private Integer exhibitorId;
        private Integer routeId;
        private Integer active;

        public Builder(){}

        public ClientExhibitor build() {
            return new ClientExhibitor(
                    clientIdExhibitor,
                    clientId,
                    exhibitorId,
                    routeId,
                    active);
        }

        public Builder setClientIdExhibitor(Integer clientIdExhibitor) {
            this.clientIdExhibitor = clientIdExhibitor;
            return this;
        }

        public Builder setClientId(Integer clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setExhibitorId(Integer exhibitorId) {
            this.exhibitorId = exhibitorId;
            return this;
        }

        public Builder setRouteId(Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }
    }
}
