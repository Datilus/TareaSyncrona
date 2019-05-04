package com.example.tareasyncrona.modelo.jsonModel;

import com.example.tareasyncrona.modelo.realmModel.BankEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Bank {
    @PrimaryKey
    @SerializedName("id_banco")
    private Integer bankId = 0;
    @SerializedName("nombre")
    private String name = "";
    @SerializedName("clave_fiscal")
    private String fiscalKey = "";
    @SerializedName("activo")
    private Integer active = 0;
    @SerializedName("cuenta_contable")
    private String account = "";
    @SerializedName("fecha_registro")
    private String registerDate = "";
    @SerializedName("usuario_registro")
    private Integer registerUser = 0;
    @SerializedName("pagina_web")
    private String webPage = "";

    public Bank() {
    }

    public Bank(Integer bankId, String name, String fiscalKey, Integer active, String account, String registerDate, Integer registerUser, String webPage) {
        this.bankId = bankId;
        this.name = name;
        this.fiscalKey = fiscalKey;
        this.active = active;
        this.account = account;
        this.registerDate = registerDate;
        this.registerUser = registerUser;
        this.webPage = webPage;
    }

    public Bank(BankEntity bankEntity) {
        this.bankId = bankEntity.getBankId();
        this.name = bankEntity.getName();
        this.active = bankEntity.getActive();
        this.account = bankEntity.getAccount();
        this.registerDate = bankEntity.getRegisterDate();
        this.registerUser = bankEntity.getRegisterUser();
        this.webPage = bankEntity.getWebPage();
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

    public static class Builder {
        private Integer bankId;
        private String name;
        private String fiscalKey;
        private Integer active;
        private String account;
        private String registerDate;
        private Integer registerUser;
        private String webPage;

        public Builder() {
        }

        public Bank build() {
            return new Bank(
                    bankId,
                    name,
                    fiscalKey,
                    active,
                    account,
                    registerDate,
                    registerUser,
                    webPage
            );
        }

        public Builder setBankId(Integer bankId) {
            this.bankId = bankId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFiscalKey(String fiscalKey) {
            this.fiscalKey = fiscalKey;
            return this;
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }

        public Builder setAccount(String account) {
            this.account = account;
            return this;
        }

        public Builder setRegisterDate(String registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public Builder setRegisterUser(Integer registerUser) {
            this.registerUser = registerUser;
            return this;
        }

        public Builder setWebPage(String webPage) {
            this.webPage = webPage;
            return this;
        }
    }
}
