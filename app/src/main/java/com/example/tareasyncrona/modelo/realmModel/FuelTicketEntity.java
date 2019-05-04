package com.example.tareasyncrona.modelo.realmModel;

import com.example.tareasyncrona.modelo.jsonModel.FuelTicket;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FuelTicketEntity extends RealmObject {

    @PrimaryKey
    private String fuelTicketId = "";
    private Integer fuelVoucherId = 0;
    private String folio = "";
    private float litros = 0;
    private float price = 0;
    private float subtotal = 0;
    private float iva = 0;
    private float total = 0;
    private String conditionPay = "";
    private float kilometraje = 0;
    private Integer userRegister = 0;

    public FuelTicketEntity() {
    }

    public FuelTicketEntity(FuelTicket fuelTicket) {
        this.fuelTicketId = fuelTicket.getFuelTicketId();
        this.fuelVoucherId = fuelTicket.getFuelVoucherId();
        this.folio = fuelTicket.getFolio();
        this.litros = fuelTicket.getLitros();
        this.price = fuelTicket.getPrice();
        this.subtotal = fuelTicket.getSubtotal();
        this.iva = fuelTicket.getIva();
        this.total = fuelTicket.getTotal();
        this.conditionPay = fuelTicket.getConditionPay();
        this.kilometraje = fuelTicket.getKilometraje();
        this.userRegister = fuelTicket.getUserRegister();
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
}
