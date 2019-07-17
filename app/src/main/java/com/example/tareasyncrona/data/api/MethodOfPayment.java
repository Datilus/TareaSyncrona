package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.MethodOfPaymentEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class MethodOfPayment {

    @PrimaryKey
    @SerializedName("id_metodo_pago")
    private String methodPaymentId = "";
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("clave_sat")
    private String satKey = "";
    @SerializedName("requiere_datos")
    private Integer dataEequires = 0;
    @SerializedName("activo")
    private Integer active = 0;

    public MethodOfPayment() {
    }

    public MethodOfPayment(String methodPaymentId, String name, String satKey, Integer dataEequires, Integer active) {
        this.methodPaymentId = methodPaymentId;
        this.name = name;
        this.satKey = satKey;
        this.dataEequires = dataEequires;
        this.active = active;
    }

    public MethodOfPayment(MethodOfPaymentEntity methodOfPaymentEntity) {
        this.methodPaymentId = methodOfPaymentEntity.getMethodPaymentId();
        this.name = methodOfPaymentEntity.getName();
        this.satKey = methodOfPaymentEntity.getSatKey();
        this.dataEequires = methodOfPaymentEntity.getDataEequires();
        this.active = methodOfPaymentEntity.getActive();
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

    public static class Builder {
        private String methodPaymentId;
        private String name;
        private String satKey;
        private Integer dataEequires;
        private Integer active;

        public Builder() {

        }

        public MethodOfPayment build() {
            return new MethodOfPayment(
                    methodPaymentId,
                    name,
                    satKey,
                    dataEequires,
                    active
            );
        }

        public Builder setMethodPaymentId(String methodPaymentId) {
            this.methodPaymentId = methodPaymentId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSatKey(String satKey) {
            this.satKey = satKey;
            return this;
        }

        public Builder setDataEequires(Integer dataEequires) {
            this.dataEequires = dataEequires;
            return this;
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }
    }

}
