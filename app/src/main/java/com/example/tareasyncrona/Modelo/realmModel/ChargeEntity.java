package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.Charge;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ChargeEntity extends RealmObject {
    @PrimaryKey
    private Integer chargeId = 0;
    private Integer routeId = 0;
    private Integer employeeId = 0;
    private String creditType = "";
    private String startDate = "";
    private String endDate = "";
    private Integer clientId = 0;
    private String concept = "";
    private Integer folioReceived = 0;
    private String folioFacture = "";
    private Double amount = 0.0;
    private String letterAmount = "";
    private Double balance = 0.0;
    private String registrationDate = "";
    private Integer registrationUser = 0;
    private Integer active = 0;
    private String folioNote = "";
    private Integer origin;
    private Integer expired = 0;
    private Integer cancellationReasonId = 0;
    private Integer newCharge = 0;

    public ChargeEntity() {
    }

    public ChargeEntity(Charge charge) {
        this.chargeId = charge.getChargeId();
        this.routeId = charge.getRouteId();
        this.employeeId = charge.getEmployeeId();
        this.creditType = charge.getCreditType();
        this.startDate = charge.getStartDate();
        this.endDate = charge.getEndDate();
        this.clientId = charge.getClientId();
        this.concept = charge.getConcept();
        this.folioReceived = charge.getFolioReceived();
        this.folioFacture = charge.getFolioFacture();
        this.amount = charge.getAmount();
        this.letterAmount = charge.getLetterAmount();
        this.balance = charge.getBalance();
        this.registrationDate = charge.getRegistrationDate();
        this.registrationUser = charge.getRegistrationUser();
        this.active = charge.getActive();
        this.folioNote = charge.getFolioNote();
        this.origin = charge.getOrigin();
        this.expired = charge.getExpired();
        this.cancellationReasonId = charge.getCancellationReasonId();
        this.newCharge = charge.getNewCharge();
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
}
