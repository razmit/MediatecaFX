package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "revista", indexes = {
        @Index(name = "ID_Documento", columnList = "idDocumento")
})
@NamedQuery(name = "getAllInfoRev", query = "select rev from Revista rev join fetch rev.idDocumento doc")
@NamedQuery(name = "getRevById", query = "select rev from Revista rev join fetch rev.idDocumento doc where rev.id = :cdId")
@NamedQuery(name = "updateRev", query = "update Revista rev SET rev.editorial = :newEditorial, rev.issn = :newIssn, " +
        "rev.periodicidad = :newPeriodicidad, rev.fechaPublicacion = :newFechaPublic where id = :revId")
@NamedQuery(name = "deleteRev", query = "delete Revista rev where id = :revId")
public class Revista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRevista", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocumento")
    private Documento idDocumento;

    @Column(name = "issn", length = 20)
    private String issn;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "periodicidad", length = 20)
    private String periodicidad;

    @Column(name = "fechaPublicacion")
    private LocalDate fechaPublicacion;

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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}