package com.example.tareasyncrona.Modelo.jsonModel;

import com.example.tareasyncrona.Modelo.realmModel.ChargeEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Charge {

    @PrimaryKey
    @SerializedName("id_cargo")
    private Integer chargeId = 0;
    @SerializedName("id_ruta")
    private Integer routeId = 0;
    @SerializedName("id_empleado")
    private Integer employeeId = 0;
    @SerializedName("tipo_credito")
    private String creditType = "";
    @SerializedName("fecha_inicio")
    private String startDate = "";
    @SerializedName("fecha_fin")
    private String endDate = "";
    @SerializedName("id_cliente")
    private Integer clientId = 0;
    @SerializedName("concepto")
    private String concept = "";
    @SerializedName("folio_recibo")
    private Integer folioReceived = 0;
    @SerializedName("folio_factura")
    private String folioFacture = "";
    @SerializedName("importe")
    private Double amount = 0.0;
    @SerializedName("importe_letra")
    private String letterAmount = "";
    @SerializedName("saldo")
    private Double balance = 0.0;
    @SerializedName("fecha_registro")
    private String registrationDate = "";
    @SerializedName("usuario_registro")
    private Integer registrationUser = 0;
    @SerializedName("activo")
    private Integer active = 0;
    @SerializedName("folio_nota")
    private String folioNote = "";
    @SerializedName("origen")
    private Integer origin;
    @SerializedName("vencida")
    private Integer expired = 0;
    @SerializedName("id_motivo_cancelacion")
    private Integer cancellationReasonId = 0;
    private Integer newCharge = 0;

    public Charge() {
    }

    public Charge(Integer chargeId, Integer routeId, Integer employeeId, String creditType, String startDate, String endDate, Integer clientId, String concept, Integer folioReceived, String folioFacture, Double amount, String letterAmount, Double balance, String registrationDate, Integer registrationUser, Integer active, String folioNote, Integer origin, Integer expired, Integer cancellationReasonId, Integer newCharge) {
        this.chargeId = chargeId;
        this.routeId = routeId;
        this.employeeId = employeeId;
        this.creditType = creditType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId = clientId;
        this.concept = concept;
        this.folioReceived = folioReceived;
        this.folioFacture = folioFacture;
        this.amount = amount;
        this.letterAmount = letterAmount;
        this.balance = balance;
        this.registrationDate = registrationDate;
        this.registrationUser = registrationUser;
        this.active = active;
        this.folioNote = folioNote;
        this.origin = origin;
        this.expired = expired;
        this.cancellationReasonId = cancellationReasonId;
        this.newCharge = newCharge;
    }

    public Charge(ChargeEntity chargeEntity) {
        this.chargeId = chargeEntity.getChargeId();
        this.routeId = chargeEntity.getRouteId();
        this.employeeId = chargeEntity.getEmployeeId();
        this.creditType = chargeEntity.getCreditType();
        this.startDate = chargeEntity.getStartDate();
        this.endDate = chargeEntity.getEndDate();
        this.clientId = chargeEntity.getClientId();
        this.concept = chargeEntity.getConcept();
        this.folioReceived = chargeEntity.getFolioReceived();
        this.folioFacture = chargeEntity.getFolioFacture();
        this.amount = chargeEntity.getAmount();
        this.letterAmount = chargeEntity.getLetterAmount();
        this.balance = chargeEntity.getBalance();
        this.registrationDate = chargeEntity.getRegistrationDate();
        this.registrationUser = chargeEntity.getRegistrationUser();
        this.active = chargeEntity.getActive();
        this.folioNote = chargeEntity.getFolioNote();
        this.origin = chargeEntity.getOrigin();
        this.expired = chargeEntity.getExpired();
        this.cancellationReasonId = chargeEntity.getCancellationReasonId();
        this.newCharge = chargeEntity.getNewCharge();
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Integer getFolioReceived() {
        return folioReceived;
    }

    public void setFolioReceived(Integer folioReceived) {
        this.folioReceived = folioReceived;
    }

    public String getFolioFacture() {
        return folioFacture;
    }

    public void setFolioFacture(String folioFacture) {
        this.folioFacture = folioFacture;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getLetterAmount() {
        return letterAmount;
    }

    public void setLetterAmount(String letterAmount) {
        this.letterAmount = letterAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getRegistrationUser() {
        return registrationUser;
    }

    public void setRegistrationUser(Integer registrationUser) {
        this.registrationUser = registrationUser;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getFolioNote() {
        return folioNote;
    }

    public void setFolioNote(String folioNote) {
        this.folioNote = folioNote;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Integer getCancellationReasonId() {
        return cancellationReasonId;
    }

    public void setCancellationReasonId(Integer cancellationReasonId) {
        this.cancellationReasonId = cancellationReasonId;
    }

    public Integer getNewCharge() {
        return newCharge;
    }

    public void setNewCharge(Integer newCharge) {
        this.newCharge = newCharge;
    }

    public static class Builder {
        private Integer chargeId;
        private Integer routeId;
        private Integer employeeId;
        private String creditType;
        private String startDate;
        private String endDate;
        private Integer clientId;
        private String concept;
        private Integer folioReceived;
        private String folioFacture;
        private Double amount;
        private String letterAmount;
        private Double balance;
        private String registrationDate;
        private Integer registrationUser;
        private Integer active;
        private String folioNote;
        private Integer origin;
        private Integer expired;
        private Integer cancellationReasonId;
        private Integer newCharge;

        public Builder() {
        }

        public Charge build() {
            return new Charge(
                    chargeId,
                    routeId,
                    employeeId,
                    creditType,
                    startDate,
                    endDate,
                    clientId,
                    concept,
                    folioReceived,
                    folioFacture,
                    amount,
                    letterAmount,
                    balance,
                    registrationDate,
                    registrationUser,
                    active,
                    folioNote,
                    origin,
                    expired,
                    cancellationReasonId,
                    newCharge);
        }

        public Builder setChargeId(Integer chargeId) {
            this.chargeId = chargeId;
            return this;
        }

        public Builder setRouteId(Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setEmployeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setCreditType(String creditType) {
            this.creditType = creditType;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setClientId(Integer clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setConcept(String concept) {
            this.concept = concept;
            return this;
        }

        public Builder setFolioReceived(Integer folioReceived) {
            this.folioReceived = folioReceived;
            return this;
        }

        public Builder setFolioFacture(String folioFacture) {
            this.folioFacture = folioFacture;
            return this;
        }

        public Builder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setLetterAmount(String letterAmount) {
            this.letterAmount = letterAmount;
            return this;
        }

        public Builder setBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setRegistrationUser(Integer registrationUser) {
            this.registrationUser = registrationUser;
            return this;
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }

        public Builder setFolioNote(String folioNote) {
            this.folioNote = folioNote;
            return this;
        }

        public Builder setOrigin(Integer origin) {
            this.origin = origin;
            return this;
        }

        public Builder setExpired(Integer expired) {
            this.expired = expired;
            return this;
        }

        public Builder setCancellationReasonId(Integer cancellationReasonId) {
            this.cancellationReasonId = cancellationReasonId;
            return this;
        }

        public Builder setNewCharge(Integer newCharge) {
            this.newCharge = newCharge;
            return this;
        }
    }
}
