package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.ClientEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Client {
    @PrimaryKey
    @SerializedName("clientId")
    private Integer clientId = 0;
    @SerializedName("sioId")
    private Integer sioId = 0;
    @SerializedName("rfc")
    private String rfc = "";
    @SerializedName("establishment")
    private String establishment = "";
    @SerializedName("lastName")
    private String lastName = "";
    @SerializedName("lastNameM")
    private String lastNameM = "";
    @SerializedName("name")
    private String name = "";
    @SerializedName("fisica")
    private Integer fisica = 0;
    @SerializedName("street")
    private String street = "";
    @SerializedName("number")
    private String number = "";
    @SerializedName("colony")
    private String colony = "";
    @SerializedName("locality")
    private String locality = "";
    @SerializedName("city")
    private String city = "";
    @SerializedName("state")
    private String state = "";
    @SerializedName("phone")
    private String phone = "";
    @SerializedName("postalCode")
    private String postalCode = "";
    @SerializedName("email")
    private String email = "";
    @SerializedName("latitud")
    private String latitud = "";
    @SerializedName("longitud")
    private String longitud = "";
    @SerializedName("dayVisit")
    private Integer dayVisit = 0;
    @SerializedName("ordenVisit")
    private Integer ordenVisit = 0;
    @SerializedName("version")
    private Integer version = 0;
    @SerializedName("routeId")
    private Integer routeId = 0;
    @SerializedName("typeVisit")
    private Integer typeVisit = 0;
    @SerializedName("typeClient")
    private Integer typeClient = 0;
    @SerializedName("giro")
    private Integer giro = 0;
    @SerializedName("businessName")
    private String businessName = "";
    @SerializedName("classificatioId")
    private Integer classificatioId = 0;
    @SerializedName("clientActive")
    private Integer clientActive = 0;
    @SerializedName("actualizacion")
    private Integer actualizacion = 0;
    @SerializedName("bank")
    private String bank = "";
    @SerializedName("bankAccount")
    private String bankAccount = "";
    @SerializedName("authorizedModification")
    private Integer authorizedModification = 0;
    @SerializedName("dayReschedule")
    private Integer dayReschedule = 0;
    @SerializedName("orderReschedule")
    private Integer orderReschedule = 0;
    @SerializedName("dateRegister")
    private String dateRegister = "";

    public Client() {
    }

    public Client(Integer clientId, Integer sioId, String rfc, String establishment, String lastName, String lastNameM, String name, Integer fisica, String street, String number, String colony, String locality, String city, String state, String phone, String postalCode, String email, String latitud, String longitud, Integer dayVisit, Integer ordenVisit, Integer version, Integer routeId, Integer typeVisit, Integer typeClient, Integer giro, String businessName, Integer classificatioId, Integer clientActive, Integer actualizacion, String bank, String bankAccount, Integer authorizedModification, Integer dayReschedule, Integer orderReschedule, String dateRegister) {
        this.clientId = clientId;
        this.sioId = sioId;
        this.rfc = rfc;
        this.establishment = establishment;
        this.lastName = lastName;
        this.lastNameM = lastNameM;
        this.name = name;
        this.fisica = fisica;
        this.street = street;
        this.number = number;
        this.colony = colony;
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.postalCode = postalCode;
        this.email = email;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dayVisit = dayVisit;
        this.ordenVisit = ordenVisit;
        this.version = version;
        this.routeId = routeId;
        this.typeVisit = typeVisit;
        this.typeClient = typeClient;
        this.giro = giro;
        this.businessName = businessName;
        this.classificatioId = classificatioId;
        this.clientActive = clientActive;
        this.actualizacion = actualizacion;
        this.bank = bank;
        this.bankAccount = bankAccount;
        this.authorizedModification = authorizedModification;
        this.dayReschedule = dayReschedule;
        this.orderReschedule = orderReschedule;
        this.dateRegister = dateRegister;
    }

    public Client(ClientEntity clientEntity) {
        this.clientId = clientEntity.getClientId();
        this.sioId = clientEntity.getSioId();
        this.rfc = clientEntity.getRfc();
        this.establishment = clientEntity.getEstablishment();
        this.lastName = clientEntity.getLastName();
        this.lastNameM = clientEntity.getLastNameM();
        this.name = clientEntity.getName();
        this.fisica = clientEntity.getFisica();
        this.street = clientEntity.getStreet();
        this.number = clientEntity.getNumber();
        this.colony = clientEntity.getColony();
        this.locality = clientEntity.getLocality();
        this.city = clientEntity.getCity();
        this.state = clientEntity.getState();
        this.phone = clientEntity.getPhone();
        this.postalCode = clientEntity.getPostalCode();
        this.email = clientEntity.getEmail();
        this.latitud = clientEntity.getLatitud();
        this.longitud = clientEntity.getLongitud();
        this.dayVisit = clientEntity.getDayVisit();
        this.ordenVisit = clientEntity.getOrdenVisit();
        this.version = clientEntity.getVersion();
        this.routeId = clientEntity.getRouteId();
        this.typeVisit = clientEntity.getTypeVisit();
        this.typeClient = clientEntity.getTypeClient();
        this.giro = clientEntity.getGiro();
        this.businessName = clientEntity.getBusinessName();
        this.classificatioId = clientEntity.getClassificatioId();
        this.clientActive = clientEntity.getClientActive();
        this.actualizacion = clientEntity.getActualizacion();
        this.bank = clientEntity.getBank();
        this.bankAccount = clientEntity.getBankAccount();
        this.authorizedModification = clientEntity.getAuthorizedModification();
        this.dayReschedule = clientEntity.getDayReschedule();
        this.orderReschedule = clientEntity.getOrderReschedule();
        this.dateRegister = clientEntity.getDateRegister();
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

    public static class Builder{
        private Integer clientId;
        private Integer sioId;
        private String rfc;
        private String establishment;
        private String lastName;
        private String lastNameM;
        private String name;
        private Integer fisica;
        private String street;
        private String number;
        private String colony;
        private String locality;
        private String city;
        private String state;
        private String phone;
        private String postalCode;
        private String email;
        private String latitud;
        private String longitud;
        private Integer dayVisit;
        private Integer ordenVisit;
        private Integer version;
        private Integer routeId;
        private Integer typeVisit;
        private Integer typeClient;
        private Integer giro;
        private String businessName;
        private Integer classificatioId;
        private Integer clientActive;
        private Integer actualizacion;
        private String bank;
        private String bankAccount;
        private Integer authorizedModification;
        private Integer dayReschedule;
        private Integer orderReschedule;
        private String dateRegister;

        public Builder(){}

        public Client build(){
            return new Client(
                    clientId,
                    sioId,
                    rfc,
                    establishment,
                    lastName,
                    lastNameM,
                    name,
                    fisica,
                    street,
                    number,
                    colony,
                    locality,
                    city,
                    state,
                    phone,
                    postalCode,
                    email,
                    latitud,
                    longitud,
                    dayVisit,
                    ordenVisit,
                    version,
                    routeId,
                    typeVisit,
                    typeClient,
                    giro,
                    businessName,
                    classificatioId,
                    clientActive,
                    actualizacion,
                    bank,
                    bankAccount,
                    authorizedModification,
                    dayReschedule,
                    orderReschedule,
                    dateRegister);
        }

        public Builder setClientId(Integer clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setSioId(Integer sioId) {
            this.sioId = sioId;
            return this;
        }

        public Builder setRfc(String rfc) {
            this.rfc = rfc;
            return this;
        }

        public Builder setEstablishment(String establishment) {
            this.establishment = establishment;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setLastNameM(String lastNameM) {
            this.lastNameM = lastNameM;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFisica(Integer fisica) {
            this.fisica = fisica;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder setColony(String colony) {
            this.colony = colony;
            return this;
        }

        public Builder setLocality(String locality) {
            this.locality = locality;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setLatitud(String latitud) {
            this.latitud = latitud;
            return this;
        }

        public Builder setLongitud(String longitud) {
            this.longitud = longitud;
            return this;
        }

        public Builder setDayVisit(Integer dayVisit) {
            this.dayVisit = dayVisit;
            return this;
        }

        public Builder setOrdenVisit(Integer ordenVisit) {
            this.ordenVisit = ordenVisit;
            return this;
        }

        public Builder setVersion(Integer version) {
            this.version = version;
            return this;
        }

        public Builder setRouteId(Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setTypeVisit(Integer typeVisit) {
            this.typeVisit = typeVisit;
            return this;
        }

        public Builder setTypeClient(Integer typeClient) {
            this.typeClient = typeClient;
            return this;
        }

        public Builder setGiro(Integer giro) {
            this.giro = giro;
            return this;
        }

        public Builder setBusinessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public Builder setClassificatioId(Integer classificatioId) {
            this.classificatioId = classificatioId;
            return this;
        }

        public Builder setClientActive(Integer clientActive) {
            this.clientActive = clientActive;
            return this;
        }

        public Builder setActualizacion(Integer actualizacion) {
            this.actualizacion = actualizacion;
            return this;
        }

        public Builder setBank(String bank) {
            this.bank = bank;
            return this;
        }

        public Builder setBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder setAuthorizedModification(Integer authorizedModification) {
            this.authorizedModification = authorizedModification;
            return this;
        }

        public Builder setDayReschedule(Integer dayReschedule) {
            this.dayReschedule = dayReschedule;
            return this;
        }

        public Builder setOrderReschedule(Integer orderReschedule) {
            this.orderReschedule = orderReschedule;
            return this;
        }

        public Builder setDateRegister(String dateRegister) {
            this.dateRegister = dateRegister;
            return this;
        }
    }
}
