package com.fiscal.codeGenerator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "gi_comuni_validita")
public class ValidComune {
        @Column(name = "sigla_provincia")
        private String provinceInitials;
        @Id
        @Column(name = "codice_istat")
        private String stateCode;
        @Column(name = "denominazione_ita")
        private String placeName;
        @Column(name = "codice_belfiore")
        private String belfioreCode;
        @Column(name = "data_inizio_validita")
        private LocalDate startDate;
        @Column(name = "data_fine_validita")
        private LocalDate endDate;
        @Column(name = "stato_validita")
        private String validationState;

        public ValidComune() {
        }

        public ValidComune(String provinceInitials, String stateCode, String placeName, String belfioreCode, LocalDate startDate, LocalDate endDate, String validationState) {
                this.provinceInitials = provinceInitials;
                this.stateCode = stateCode;
                this.placeName = placeName;
                this.belfioreCode = belfioreCode;
                this.startDate = startDate;
                this.endDate = endDate;
                this.validationState = validationState;
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

        public String getBelfioreCode() {
                return belfioreCode;
        }

        public void setBelfioreCode(String belfioreCode) {
                this.belfioreCode = belfioreCode;
        }

        public LocalDate getStartDate() {
                return startDate;
        }

        public void setStartDate(LocalDate startDate) {
                this.startDate = startDate;
        }

        public LocalDate getEndDate() {
                return endDate;
        }

        public void setEndDate(LocalDate endDate) {
                this.endDate = endDate;
        }

        public String getValidationState() {
                return validationState;
        }

        public void setValidationState(String validationState) {
                this.validationState = validationState;
        }

        @Override
        public String toString() {
                return "ValidComune{" +
                        "provinceInitials='" + provinceInitials + '\'' +
                        ", stateCode='" + stateCode + '\'' +
                        ", placeName='" + placeName + '\'' +
                        ", belfioreCode='" + belfioreCode + '\'' +
                        ", startDate=" + startDate +
                        ", endDate=" + endDate +
                        ", validationState='" + validationState + '\'' +
                        '}';
        }
}
