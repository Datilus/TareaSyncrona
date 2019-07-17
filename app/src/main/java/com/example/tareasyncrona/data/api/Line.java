package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.LineEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Line {

    @PrimaryKey
    @SerializedName("id_linea")
    private Integer lineId = 0;
    @SerializedName("activo")
    private Boolean active = false;
    @SerializedName("cuenta_0")
    private String account0 = "";
    @SerializedName("cuenta_16")
    private String account16 = "";
    @SerializedName("id_proveedor_grupo")
    private Integer groupProviderId = 0;
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("orden")
    private String order = "";
    @SerializedName("fecha_registro")
    private String registrationDate = "";
    @SerializedName("usuario_registro")
    private Integer registrationUser = 0;

    public Line() {
    }

    public Line(Boolean active, String account0, String account16, Integer lineId, Integer groupProviderId, String name, String order, String registrationDate, Integer registrationUser) {
        this.active = active;
        this.account0 = account0;
        this.account16 = account16;
        this.lineId = lineId;
        this.groupProviderId = groupProviderId;
        this.name = name;
        this.order = order;
        this.registrationDate = registrationDate;
        this.registrationUser = registrationUser;
    }

    public Line(LineEntity lineEntity) {
        this.active = lineEntity.getActive();
        this.account0 = lineEntity.getAccount0();
        this.account16 = lineEntity.getAccount16();
        this.lineId = lineEntity.getLineId();
        this.groupProviderId = lineEntity.getGroupProviderId();
        this.name = lineEntity.getName();
        this.order = lineEntity.getOrder();
        this.registrationDate = lineEntity.getRegistrationDate();
        this.registrationUser = lineEntity.getRegistrationUser();

    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
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

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
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

    public static class Builder {
        private Boolean active;
        private String account0;
        private String account16;
        private Integer lineId;
        private Integer groupProviderId;
        private String name;
        private String order;
        private String registrationDate;
        private Integer registrationUser;

        public Builder() {

        }

        public Line build() {
            return new Line(
                    active,
                    account0,
                    account16,
                    lineId,
                    groupProviderId,
                    name,
                    order,
                    registrationDate,
                    registrationUser
            );
        }

        public Builder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder setAccount0(String account0) {
            this.account0 = account0;
            return this;
        }

        public Builder setAccount16(String account16) {
            this.account16 = account16;
            return this;
        }

        public Builder setLineId(Integer lineId) {
            this.lineId = lineId;
            return this;
        }

        public Builder setGroupProviderId(Integer groupProviderId) {
            this.groupProviderId = groupProviderId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setOrder(String order) {
            this.order = order;
            return this;
        }

        public Builder setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setRegistrationUser(Integer registrationUser) {
            this.registrationUser = registrationUser;
            return this;
        }
    }
}
