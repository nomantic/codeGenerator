package com.fiscal.codeGenerator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gi_province")
public class Province {
    @Id
    @Column(name = "sigla_provincia")
    private String provinceAbbriviation;
    @Column(name = "codice_regione", length = 4)
    private String regionCode;
    @Column(name = "denominazione_provincia", length = 50)
    private String provinceName;
    @Column(name = "tipologia_provincia", length = 100)
    private String provinceType;
    @Column(name = "numero_comuni")
    private Integer comuneNumber;
    @Column(name= "superficie_kmq")
    private Double areaDistance;
    @Column(name = "codice_sovracomunale", unique = true, length = 6)
    private String provinceCode;

    public Province() {
    }

    public Province(String provinceAbbriviation, String regionCode, String provinceName, String provinceType, Integer comuneNumber, Double areaDistance, String provinceCode) {
        this.provinceAbbriviation = provinceAbbriviation;
        this.regionCode = regionCode;
        this.provinceName = provinceName;
        this.provinceType = provinceType;
        this.comuneNumber = comuneNumber;
        this.areaDistance = areaDistance;
        this.provinceCode = provinceCode;
    }

    public String getProvinceAbbriviation() {
        return provinceAbbriviation;
    }

    public void setProvinceAbbriviation(String provinceAbbriviation) {
        this.provinceAbbriviation = provinceAbbriviation;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceType() {
        return provinceType;
    }

    public void setProvinceType(String provinceType) {
        this.provinceType = provinceType;
    }

    public Integer getComuneNumber() {
        return comuneNumber;
    }

    public void setComuneNumber(Integer comuneNumber) {
        this.comuneNumber = comuneNumber;
    }

    public Double getAreaDistance() {
        return areaDistance;
    }

    public void setAreaDistance(Double areaDistance) {
        this.areaDistance = areaDistance;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceAbbriviation='" + provinceAbbriviation + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", provinceType='" + provinceType + '\'' +
                ", comuneNumber=" + comuneNumber +
                ", areaDistance=" + areaDistance +
                ", provinceCode='" + provinceCode + '\'' +
                '}';
    }
}
