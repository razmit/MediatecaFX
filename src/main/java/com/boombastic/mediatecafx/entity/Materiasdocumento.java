package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "materiasdocumentos")
@NamedQuery(name = "getAllMDs", query = "select md from Materiasdocumento md")
@NamedQuery(name = "getMDById", query = "select md from Materiasdocumento md where id = :mdID")
@NamedQuery(name = "updateMD", query = "update Materiasdocumento md SET md.idDocumento = :newIdDocumento," +
        " md.idMateria = :newIdMateria WHERE id = :mdToUpdate")
@NamedQuery(name = "deleteMD", query = "delete Materiasdocumento md where id = :mdId")
public class Materiasdocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateriaDocumento", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idDocumento", nullable = false)
    private Documento idDocumento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idMateria", nullable = false)
    private Materia idMateria;

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

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

}