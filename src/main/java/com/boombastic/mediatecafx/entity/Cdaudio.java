package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cdaudio", indexes = {
        @Index(name = "ID_Documento", columnList = "idDocumento")
})
@NamedQuery(name = "getAllInfoCD", query = "select cda from Cdaudio cda join fetch cda.idDocumento doc")
@NamedQuery(name = "getCDById", query = "select cda from Cdaudio cda join fetch cda.idDocumento doc where cda.id = :cdId")
@NamedQuery(name = "updateCD", query = "update Cdaudio cd SET cd.artista = :newArtista, cd.duracion = :newDuracion, " +
        "cd.genero = :newGenero, cd.numCanciones = :newNumCancion where id = :cdId")
@NamedQuery(name = "deleteCD", query = "delete Cdaudio cd where id = :cdId")
public class Cdaudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCdAudio", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocumento")
    private Documento idDocumento;

    @Column(name = "artista")
    private String artista;

    @Column(name = "genero", length = 50)
    private String genero;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "numCanciones")
    private Integer numCanciones;

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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(Integer numCanciones) {
        this.numCanciones = numCanciones;
    }

}