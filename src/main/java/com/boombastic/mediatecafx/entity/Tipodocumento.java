package com.boombastic.mediatecafx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipodocumento")
public class Tipodocumento {
    @Id
    @Column(name = "idTipoDocumento", nullable = false)
    private Integer id;

    @Column(name = "nombreTipo", nullable = false, length = 50)
    private String nombreTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}