package com.example.tareasyncrona.modelo.jsonModel;

import com.example.tareasyncrona.modelo.realmModel.FuelTicketEntity;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import io.realm.annotations.PrimaryKey;

public class FuelTicket {

    @PrimaryKey
    @SerializedName("id_combustible_ticket")
    private String fuelTicketId = UUID.randomUUID().toString();
    @SerializedName("id_combustible_vale")
    private Integer fuelVoucherId = 0;
    @SerializedName("folio")
    private String folio = "";
    @SerializedName("litros")
    private float litros = 0;
    @SerializedName("precio")
    private float price = 0;
    @SerializedName("subtotal")
    private float subtotal = 0;
    @SerializedName("iva")
    private float iva = 0;
    @SerializedName("total")
    private float total = 0;
    @SerializedName("condiciones_pago")
    private String conditionPay = "";
    @SerializedName("kilometraje")
    private float kilometraje = 0;
    @SerializedName("usuario_registro")
    private Integer userRegister = 0;

    public FuelTicket() {
    }

    public FuelTicket(String fuelTicketId, Integer fuelVoucherId, String folio, float litros, float price, float subtotal, float iva, float total, String conditionPay, float kilometraje, Integer userRegister) {
        this.fuelTicketId = fuelTicketId;
        this.fuelVoucherId = fuelVoucherId;
        this.folio = folio;
        this.litros = litros;
        this.price = price;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.conditionPay = conditionPay;
        this.kilometraje = kilometraje;
        this.userRegister = userRegister;
    }

    public FuelTicket(FuelTicketEntity fuelTicketEntity) {
        this.fuelTicketId = fuelTicketEntity.getFuelTicketId();
        this.fuelVoucherId = fuelTicketEntity.getFuelVoucherId();
        this.folio = fuelTicketEntity.getFolio();
        this.litros = fuelTicketEntity.getLitros();
        this.price = fuelTicketEntity.getPrice();
        this.subtotal = fuelTicketEntity.getSubtotal();
        this.iva = fuelTicketEntity.getIva();
        this.total = fuelTicketEntity.getTotal();
        this.conditionPay = fuelTicketEntity.getConditionPay();
        this.kilometraje = fuelTicketEntity.getKilometraje();
        this.userRegister = fuelTicketEntity.getUserRegister();
    }

    public String getFuelTicketId() {
        return fuelTicketId;
    }

    public void setFuelTicketId(String fuelTicketId) {
        this.fuelTicketId = fuelTicketId;
    }

    public Integer getFuelVoucherId() {
        return fuelVoucherId;
    }

    public void setFuelVoucherId(Integer fuelVoucherId) {
        this.fuelVoucherId = fuelVoucherId;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getConditionPay() {
        return conditionPay;
    }

    public void setConditionPay(String conditionPay) {
        this.conditionPay = conditionPay;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Integer getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(Integer userRegister) {
        this.userRegister = userRegister;
    }

    public static class Builder {
        private String fuelTicketId;
        private Integer fuelVoucherId;
        private String folio;
        private float litros;
        private float price;
        private float subtotal;
        private float iva;
        private float total;
        private String conditionPay;
        private float kilometraje;
        private Integer userRegister;

        public Builder() {

        }

        public FuelTicket build() {
            return new FuelTicket(
                    fuelTicketId,
                    fuelVoucherId,
                    folio,
                    litros,
                    price,
                    subtotal,
                    iva,
                    total,
                    conditionPay,
                    kilometraje,
                    userRegister
            );
        }

        public Builder setFuelTicketId(String fuelTicketId) {
            this.fuelTicketId = fuelTicketId;
            return this;
        }

        public Builder setFuelVoucherId(Integer fuelVoucherId) {
            this.fuelVoucherId = fuelVoucherId;
            return this;
        }

        public Builder setFolio(String folio) {
            this.folio = folio;
            return this;
        }

        public Builder setLitros(float litros) {
            this.litros = litros;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setSubtotal(float subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder setIva(float iva) {
            this.iva = iva;
            return this;
        }

        public Builder setTotal(float total) {
            this.total = total;
            return this;
        }

        public Builder setConditionPay(String conditionPay) {
            this.conditionPay = conditionPay;
            return this;
        }

        public Builder setKilometraje(float kilometraje) {
            this.kilometraje = kilometraje;
            return this;
        }

        public Builder setUserRegister(Integer userRegister) {
            this.userRegister = userRegister;
            return this;
        }
    }
}
