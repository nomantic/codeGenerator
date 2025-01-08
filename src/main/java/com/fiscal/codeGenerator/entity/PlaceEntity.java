package com.fiscal.codeGenerator.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comuni")
public class PlaceEntity {
    @Id
    @SequenceGenerator(name = "place_sequence", sequenceName = "place_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_sequence")
    private Long id;
    private String sigla_Provincia;
    private String denominazione_Ita;
    private String codice_Belfiore;
    private LocalDate data_Inizio_Validita;
    private LocalDate data_Fine_Validita;

    // Constructors, Getters, Setters

    public PlaceEntity() {
    }

    public PlaceEntity(String sigla_Provincia, String denominazione_Ita, String codice_Belfiore, LocalDate data_Inizio_Validita, LocalDate data_Fine_Validita) {
        this.sigla_Provincia = sigla_Provincia;
        this.denominazione_Ita = denominazione_Ita;
        this.codice_Belfiore = codice_Belfiore;
        this.data_Inizio_Validita = data_Inizio_Validita;
        this.data_Fine_Validita = data_Fine_Validita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla_Provincia() {
        return sigla_Provincia;
    }

    public void setSigla_Provincia(String sigla_Provincia) {
        this.sigla_Provincia = sigla_Provincia;
    }

    public String getDenominazione_Ita() {
        return denominazione_Ita;
    }

    public void setDenominazione_Ita(String denominazione_Ita) {
        this.denominazione_Ita = denominazione_Ita;
    }

    public String getCodice_Belfiore() {
        return codice_Belfiore;
    }

    public void setCodice_Belfiore(String codice_Belfiore) {
        this.codice_Belfiore = codice_Belfiore;
    }

    public LocalDate getData_Inizio_Validita() {
        return data_Inizio_Validita;
    }

    public void setData_Inizio_Validita(LocalDate data_Inizio_Validita) {
        this.data_Inizio_Validita = data_Inizio_Validita;
    }

    public LocalDate getData_Fine_Validita() {
        return data_Fine_Validita;
    }

    public void setData_Fine_Validita(LocalDate data_Fine_Validita) {
        this.data_Fine_Validita = data_Fine_Validita;
    }

    @Override
    public String toString() {
        return "PlaceEntity{" +
                "id=" + id +
                ", sigla_Provincia='" + sigla_Provincia + '\'' +
                ", denominazione_Ita='" + denominazione_Ita + '\'' +
                ", codice_Belfiore='" + codice_Belfiore + '\'' +
                ", data_Inizio_Validita=" + data_Inizio_Validita +
                ", data_Fine_Validita=" + data_Fine_Validita +
                '}';
    }
}

