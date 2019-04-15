package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.TypeClientEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class TypeClient {

    @PrimaryKey
    @SerializedName("id_cliente_tipo")
    private int idTypeClient = 0;
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("activo")
    private int active = 0;
    @SerializedName("usuario_registro")
    private int userRegister = 0;
    @SerializedName("fecha_registro")
    private String dateRegister = "";

    public TypeClient() {
    }

    public TypeClient(int idTypeClient, String name, int active, int userRegister, String dateRegister) {
        this.idTypeClient = idTypeClient;
        this.name = name;
        this.active = active;
        this.userRegister = userRegister;
        this.dateRegister = dateRegister;
    }

    public TypeClient(TypeClientEntity typeClientEntity){
        this.idTypeClient = typeClientEntity.getIdTypeClient();
        this.name = typeClientEntity.getName();
        this.active = typeClientEntity.getActive();
        this.userRegister = typeClientEntity.getUserRegister();
        this.dateRegister = typeClientEntity.getDateRegister();
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

    public static class Builder {
        private int idTypeClient;
        private String name;
        private int active;
        private int userRegister;
        private String dateRegister;

        public Builder() {
        }

        public TypeClient build(){
            return new TypeClient(
                    idTypeClient,
                    name,
                    active,
                    userRegister,
                    dateRegister);
        }

        public Builder setIdTypeClient(int idTypeClient){
            this.idTypeClient = idTypeClient;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setActive(int active){
            this.active = active;
            return this;
        }

        public Builder setUserRegister(int userRegister){
            this.userRegister = userRegister;
            return this;
        }

        public Builder setDateRegister(String dateRegister){
            this.dateRegister = dateRegister;
            return this;
        }
    }
}
