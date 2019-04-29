package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.ExhibitorEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Exhibitor {

    @PrimaryKey
    @SerializedName("exhibitorId")
    private Integer exhibitorId = 0;
    @SerializedName("providerId")
    private Integer providerId = 0;
    @SerializedName("name")
    private String name = "";

    public Exhibitor() {
    }

    public Exhibitor(ExhibitorEntity exhibitorEntity) {
        this.exhibitorId = exhibitorEntity.getExhibitorId();
        this.providerId = exhibitorEntity.getProviderId();
        this.name = exhibitorEntity.getName();
    }

    public Exhibitor(Integer exhibitorId, Integer providerId, String name) {
        this.exhibitorId = exhibitorId;
        this.providerId = providerId;
        this.name = name;
    }

    public Integer getExhibitorId() {
        return exhibitorId;
    }

    public void setExhibitorId(Integer exhibitorId) {
        this.exhibitorId = exhibitorId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        private Integer exhibitorId;
        private Integer providerId;
        private String name;

        public Builder() {

        }

        public Exhibitor build() {
            return new Exhibitor(
                    exhibitorId,
                    providerId,
                    name
            );
        }

        public Builder setExhibitorId(Integer exhibitorId) {
            this.exhibitorId = exhibitorId;
            return this;
        }

        public Builder setProviderId(Integer providerId) {
            this.providerId = providerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    }


}
