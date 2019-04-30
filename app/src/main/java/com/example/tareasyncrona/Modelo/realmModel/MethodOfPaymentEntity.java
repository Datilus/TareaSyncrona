package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.MethodOfPayment;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MethodOfPaymentEntity extends RealmObject {

    @PrimaryKey
    private String methodPaymentId = "";
    private String name = "";
    private String satKey = "";
    private Integer dataEequires = 0;
    private Integer active = 0;

    public MethodOfPaymentEntity() {
    }

    public MethodOfPaymentEntity(MethodOfPayment methodOfPayment) {
        this.methodPaymentId = methodOfPayment.getMethodPaymentId();
        this.name = methodOfPayment.getName();
        this.satKey = methodOfPayment.getSatKey();
        this.dataEequires = methodOfPayment.getDataEequires();
        this.active = methodOfPayment.getActive();
    }

    public String getMethodPaymentId() {
        return methodPaymentId;
    }

    public void setMethodPaymentId(String methodPaymentId) {
        this.methodPaymentId = methodPaymentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSatKey() {
        return satKey;
    }

    public void setSatKey(String satKey) {
        this.satKey = satKey;
    }

    public Integer getDataEequires() {
        return dataEequires;
    }

    public void setDataEequires(Integer dataEequires) {
        this.dataEequires = dataEequires;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
