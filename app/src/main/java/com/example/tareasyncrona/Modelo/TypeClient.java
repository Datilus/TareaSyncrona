package com.example.tareasyncrona.Modelo;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TypeClient extends RealmObject {

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

    public int isActivo() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
