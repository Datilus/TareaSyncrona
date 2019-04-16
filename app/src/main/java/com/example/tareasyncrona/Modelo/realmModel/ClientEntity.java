package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.Client;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ClientEntity extends RealmObject {
    @PrimaryKey
    private Integer clientId = 0;
    private Integer sioId = 0;
    private String rfc = "";
    private String establishment = "";
    private String lastName = "";
    private String lastNameM = "";
    private String name = "";
    private Integer fisica = 0;
    private String street = "";
    private String number = "";
    private String colony = "";
    private String locality = "";
    private String city = "";
    private String state = "";
    private String phone = "";
    private String postalCode = "";
    private String email = "";
    private String latitud = "";
    private String longitud = "";
    private Integer dayVisit = 0;
    private Integer ordenVisit = 0;
    private Integer version = 0;
    private Integer routeId = 0;
    private Integer typeVisit = 0;
    private Integer typeClient = 0;
    private Integer giro = 0;
    private String businessName = "";
    private Integer classificatioId = 0;
    private Integer clientActive = 0;
    private Integer actualizacion = 0;
    private String bank = "";
    private String bankAccount = "";
    private Integer authorizedModification = 0;
    private Integer dayReschedule = 0;
    private Integer orderReschedule = 0;
    private String dateRegister = "";

    public ClientEntity() {
    }

    public ClientEntity(Client client) {
        this.clientId = client.getClientId();
        this.sioId = client.getSioId();
        this.rfc = client.getRfc();
        this.establishment = client.getEstablishment();
        this.lastName = client.getLastName();
        this.lastNameM = client.getLastNameM();
        this.name = client.getName();
        this.fisica = client.getFisica();
        this.street = client.getStreet();
        this.number = client.getNumber();
        this.colony = client.getColony();
        this.locality = client.getLocality();
        this.city = client.getCity();
        this.state = client.getState();
        this.phone = client.getPhone();
        this.postalCode = client.getPostalCode();
        this.email = client.getEmail();
        this.latitud = client.getLatitud();
        this.longitud = client.getLongitud();
        this.dayVisit = client.getDayVisit();
        this.ordenVisit = client.getOrdenVisit();
        this.version = client.getVersion();
        this.routeId = client.getRouteId();
        this.typeVisit = client.getTypeVisit();
        this.typeClient = client.getTypeClient();
        this.giro = client.getGiro();
        this.businessName = client.getBusinessName();
        this.classificatioId = client.getClassificatioId();
        this.clientActive = client.getClientActive();
        this.actualizacion = client.getActualizacion();
        this.bank = client.getBank();
        this.bankAccount = client.getBankAccount();
        this.authorizedModification = client.getAuthorizedModification();
        this.dayReschedule = client.getDayReschedule();
        this.orderReschedule = client.getOrderReschedule();
        this.dateRegister = client.getDateRegister();
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSioId() {
        return sioId;
    }

    public void setSioId(Integer sioId) {
        this.sioId = sioId;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFisica() {
        return fisica;
    }

    public void setFisica(Integer fisica) {
        this.fisica = fisica;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Integer getDayVisit() {
        return dayVisit;
    }

    public void setDayVisit(Integer dayVisit) {
        this.dayVisit = dayVisit;
    }

    public Integer getOrdenVisit() {
        return ordenVisit;
    }

    public void setOrdenVisit(Integer ordenVisit) {
        this.ordenVisit = ordenVisit;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getTypeVisit() {
        return typeVisit;
    }

    public void setTypeVisit(Integer typeVisit) {
        this.typeVisit = typeVisit;
    }

    public Integer getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(Integer typeClient) {
        this.typeClient = typeClient;
    }

    public Integer getGiro() {
        return giro;
    }

    public void setGiro(Integer giro) {
        this.giro = giro;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getClassificatioId() {
        return classificatioId;
    }

    public void setClassificatioId(Integer classificatioId) {
        this.classificatioId = classificatioId;
    }

    public Integer getClientActive() {
        return clientActive;
    }

    public void setClientActive(Integer clientActive) {
        this.clientActive = clientActive;
    }

    public Integer getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Integer actualizacion) {
        this.actualizacion = actualizacion;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getAuthorizedModification() {
        return authorizedModification;
    }

    public void setAuthorizedModification(Integer authorizedModification) {
        this.authorizedModification = authorizedModification;
    }

    public Integer getDayReschedule() {
        return dayReschedule;
    }

    public void setDayReschedule(Integer dayReschedule) {
        this.dayReschedule = dayReschedule;
    }

    public Integer getOrderReschedule() {
        return orderReschedule;
    }

    public void setOrderReschedule(Integer orderReschedule) {
        this.orderReschedule = orderReschedule;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }
}
