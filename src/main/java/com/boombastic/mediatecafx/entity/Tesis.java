package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tesis", indexes = {
        @Index(name = "ID_Documento", columnList = "idDocumento")
})
@NamedQuery(name = "getAllInfoTes", query = "select tes from Tesis tes join fetch tes.idDocumento doc")
@NamedQuery(name = "getCDByTes", query = "select tes from Tesis tes join fetch tes.idDocumento doc where tes.id = :tesId")
@NamedQuery(name = "updateTes", query = "update Tesis tes SET tes.departamento = :newDept, tes.directorTesis = :newDirectorTes, " +
        "tes.gradoObtenido = :newGradoObt where id = :tesId")
@NamedQuery(name = "deleteTes", query = "delete Tesis cd where id = :tesId")
public class Tesis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTesis", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocumento")
    private Documento idDocumento;

    @Column(name = "directorTesis")
    private String directorTesis;

    @Column(name = "gradoObtenido", length = 50)
    private String gradoObtenido;

    @Column(name = "departamento")
    private String departamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDirectorTesis() {
        return directorTesis;
    }

    public void setDirectorTesis(String directorTesis) {
        this.directorTesis = directorTesis;
    }

    public String getGradoObtenido() {
        return gradoObtenido;
    }

    public void setGradoObtenido(String gradoObtenido) {
        this.gradoObtenido = gradoObtenido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}