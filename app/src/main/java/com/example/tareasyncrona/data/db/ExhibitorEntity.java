package com.example.tareasyncrona.data.db;

import com.example.tareasyncrona.data.api.Exhibitor;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ExhibitorEntity extends RealmObject {

    @PrimaryKey
    private Integer exhibitorId = 0;
    private Integer providerId = 0;
    private String name = "";

    public ExhibitorEntity() {
    }

    public ExhibitorEntity(Exhibitor exhibitor) {
        this.exhibitorId = exhibitor.getExhibitorId();
        this.providerId = exhibitor.getProviderId();
        this.name = exhibitor.getName();
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
}
