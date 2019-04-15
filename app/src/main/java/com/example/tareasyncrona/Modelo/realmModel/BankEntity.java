package com.example.tareasyncrona.Modelo.realmModel;

import com.example.tareasyncrona.Modelo.jsonModel.Bank;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BankEntity extends RealmObject {

    @PrimaryKey
    private Integer bankId = 0;
    private String name = "";
    private String fiscalKey = "";
    private Integer active = 0;
    private String account = "";
    private String registerDate = "";
    private Integer registerUser = 0;
    private String webPage = "";

    public BankEntity() {
    }

    public BankEntity(Bank bank) {
        this.bankId = bank.getBankId();
        this.name = bank.getName();
        this.fiscalKey = bank.getFiscalKey();
        this.active = bank.getActive();
        this.account = bank.getAccount();
        this.registerDate = bank.getRegisterDate();
        this.registerUser = bank.getRegisterUser();
        this.webPage = bank.getWebPage();
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiscalKey() {
        return fiscalKey;
    }

    public void setFiscalKey(String fiscalKey) {
        this.fiscalKey = fiscalKey;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(Integer registerUser) {
        this.registerUser = registerUser;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
}
