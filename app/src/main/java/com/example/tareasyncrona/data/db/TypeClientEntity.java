package com.example.tareasyncrona.data.db;

import com.example.tareasyncrona.data.api.TypeClient;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TypeClientEntity extends RealmObject {

    @PrimaryKey
    private Integer idTypeClient = 0;
    private String name = "";
    private Integer active = 0;
    private Integer userRegister = 0;
    private String dateRegister = "";

    public TypeClientEntity() {
    }

    public TypeClientEntity(TypeClient typeClient) {
        this.idTypeClient = typeClient.getIdTypeClient();
        this.name = typeClient.getName();
        this.active = typeClient.getActive();
        this.userRegister = typeClient.getUserRegister();
        this.dateRegister = typeClient.getDateRegister();
    }

    public Integer getIdTypeClient() {
        return idTypeClient;
    }

    public void setIdTypeClient(Integer idTypeClient) {
        this.idTypeClient = idTypeClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(Integer userRegister) {
        this.userRegister = userRegister;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }
}
