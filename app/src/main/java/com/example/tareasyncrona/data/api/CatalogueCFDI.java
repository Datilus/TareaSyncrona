package com.example.tareasyncrona.data.api;

import com.example.tareasyncrona.data.db.CatalogueCFDIEntity;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class CatalogueCFDI {
    @SerializedName("activo")
    private Integer active = 0;
    @SerializedName("clave")
    private String key = "";
    @SerializedName("descripcion")
    private String description = "";
    @SerializedName("fecha_fin")
    private String endDate = "";
    @SerializedName("fecha_inicio")
    private String startDate = "";
    private String fisica = "";
    @PrimaryKey
    @SerializedName("id_uso_cfdi")
    private Integer useIdCedis = 0;
    private String moral = "";

    public CatalogueCFDI() {
    }

    public CatalogueCFDI(Integer active, String key, String description, String endDate, String startDate, String fisica, Integer useIdCedis, String moral) {
        this.active = active;
        this.key = key;
        this.description = description;
        this.endDate = endDate;
        this.startDate = startDate;
        this.fisica = fisica;
        this.useIdCedis = useIdCedis;
        this.moral = moral;
    }

    public CatalogueCFDI(CatalogueCFDIEntity catalogueCFDIEntity) {
        this.active = catalogueCFDIEntity.getActive();
        this.key = catalogueCFDIEntity.getKey();
        this.description = catalogueCFDIEntity.getDescription();
        this.endDate = catalogueCFDIEntity.getEndDate();
        this.startDate = catalogueCFDIEntity.getStartDate();
        this.fisica = catalogueCFDIEntity.getFisica();
        this.useIdCedis = catalogueCFDIEntity.getUseIdCedis();
        this.moral = catalogueCFDIEntity.getMoral();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public Integer getUseIdCedis() {
        return useIdCedis;
    }

    public void setUseIdCedis(Integer useIdCedis) {
        this.useIdCedis = useIdCedis;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral;
    }

    public static class Builder {
        private Integer active;
        private String key;
        private String description;
        private String endDate;
        private String startDate;
        private String fisica;
        private Integer useIdCedis;
        private String moral;

        public Builder() {
        }

        public CatalogueCFDI build() {
            return new CatalogueCFDI(
                    active,
                    key,
                    description,
                    endDate,
                    startDate,
                    fisica,
                    useIdCedis,
                    moral
            );
        }

        public Builder setActive(Integer active) {
            this.active = active;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setFisica(String fisica) {
            this.fisica = fisica;
            return this;
        }

        public Builder setUseIdCedis(Integer useIdCedis) {
            this.useIdCedis = useIdCedis;
            return this;
        }

        public Builder setMoral(String moral) {
            this.moral = moral;
            return this;
        }
    }
}
