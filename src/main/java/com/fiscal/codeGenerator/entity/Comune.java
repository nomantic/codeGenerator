package com.fiscal.codeGenerator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gi_comuni")
public class Comune {
    @Column(name = "sigla_provincia")
    private String provinceInitials;
    @Id
    @Column(name = "codice_istat")
    private String stateCode;
    @Column(name = "denominazione_ita")
    private String placeName;
    @Column(name = "flag_capoluogo")
    private String capitalCity;
    @Column(name = "codice_belfiore")
    private String belfioreCode;
    @Column(name = "lat")
    private Double latitude;
    @Column(name = "lon")
    private Double longitude;
    @Column(name = "superficie_kmq")
    private Double areaDistance;
    @Column(name = "codice_sovracomunale")
    private String provinceCode;

    public Comune() {
    }

    public Comune(String provinceInitials, String stateCode, String placeName, String capitalCity, String belfioreCode, Double latitude, Double longitude, Double areaDistance, String provinceCode) {
        this.provinceInitials = provinceInitials;
        this.stateCode = stateCode;
        this.placeName = placeName;
        this.capitalCity = capitalCity;
        this.belfioreCode = belfioreCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaDistance = areaDistance;
        this.provinceCode = provinceCode;
    }

    public String getProvinceInitials() {
        return provinceInitials;
    }

    public void setProvinceInitials(String provinceInitials) {
        this.provinceInitials = provinceInitials;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getBelfioreCode() {
        return belfioreCode;
    }

    public void setBelfioreCode(String belfioreCode) {
        this.belfioreCode = belfioreCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
        return "Commune{" +
                "provinceInitials='" + provinceInitials + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", placeName='" + placeName + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", belfireCode='" + belfioreCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", areaDistance=" + areaDistance +
                ", provinceCode='" + provinceCode + '\'' +
                '}';
    }
}
