package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipodocumento")
@NamedQuery(name = "getAllTipoDocs", query = "select tp from Tipodocumento tp")
@NamedQuery(name = "getTPById", query = "select tp from Tipodocumento tp where id =:tpId")
@NamedQuery(name = "updateTP", query = "update Tipodocumento tp SET tp.nombreTipo = :newNombreTipo " +
        "where id = :tpId")
@NamedQuery(name = "deleteTP", query = "delete Tipodocumento tp where id = :tpId")
public class Tipodocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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