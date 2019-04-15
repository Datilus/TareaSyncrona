package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TypeClientEntity extends RealmObject {

    @PrimaryKey
    private int idTypeClient = 0;
    private String name = "";
    private int active = 0;
    private int userRegister = 0;
    private String dateRegister = "";

    public TypeClientEntity() {
    }

    public TypeClientEntity(TypeClient typeClient){
        this.idTypeClient = typeClient.getIdTypeClient();
        this.name = typeClient.getName();
        this.active = typeClient.getActive();
        this.userRegister = typeClient.getUserRegister();
        this.dateRegister = typeClient.getDateRegister();
    }

    public int getIdTypeClient() {
        return idTypeClient;
    }

    public void setIdTypeClient(int idTypeClient) {
        this.idTypeClient = idTypeClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(int userRegister) {
        this.userRegister = userRegister;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }
}
