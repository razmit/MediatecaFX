package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
@NamedQuery(name = "getAllMaterias", query = "select mat from Materia mat")
@NamedQuery(name = "getMateriaById", query = "select mat from Materia mat where id =:matId")
@NamedQuery(name = "updateMateria", query = "update Materia mat SET mat.nombre = :newNombreMateria " +
        "where id = :matId")
@NamedQuery(name = "deleteMateria", query = "delete Materia mat where id = :matId")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateria", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}