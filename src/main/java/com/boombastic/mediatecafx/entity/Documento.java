package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "documentos", indexes = {
        @Index(name = "ID_Tipo_Documento", columnList = "idTipoDocumento")
})
@NamedQuery(name = "getAllDocs", query = "select doc from Documento doc join fetch doc.idTipoDocumento td")
@NamedQuery(name = "findAllUsesOfDocs", query = "SELECT doc FROM Documento doc " +
        "JOIN FETCH doc.idTipoDocumento tp " +
        "LEFT JOIN FETCH doc.cdaudioList cda " +
        "LEFT JOIN FETCH doc.libroList libro " +
        "LEFT JOIN FETCH doc.revistaList revista " +
        "LEFT JOIN FETCH doc.dvdList dvd " +
        "LEFT JOIN FETCH doc.tesisList tesis " +
        "LEFT JOIN FETCH doc.prestamoList presta")
//@NamedQuery(name = "updateDoc", query = "SET")
public class Documento {

    @OneToMany(mappedBy = "idDocumento")
    private List<Cdaudio> cdaudioList;
    @OneToMany(mappedBy = "idDocumento")
    private List<Dvd> dvdList;
    @OneToMany(mappedBy = "idDocumento")
    private List<Libro> libroList;
    @OneToMany(mappedBy = "idDocumento")
    private List<Tesis> tesisList;
    @OneToMany(mappedBy = "idDocumento")
    private List<Revista> revistaList;
    @OneToMany(mappedBy = "idDocumento")
    private List<Prestamo> prestamoList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoDocumento")
    private Tipodocumento idTipoDocumento;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "`añoPublicacion`")
    private Integer añoPublicacion;

    @Column(name = "ubicacionFisica", length = 100)
    private String ubicacionFisica;

    @Column(name = "cantidadDisponible", nullable = false)
    private Integer cantidadDisponible;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fechaAdquisicion")
    private LocalDate fechaAdquisicion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipodocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Tipodocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Integer añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public List<Cdaudio> getCdaudioList() {
        return cdaudioList;
    }

    public void setCdaudioList(List<Cdaudio> cdaudioList) {
        this.cdaudioList = cdaudioList;
    }

    public List<Dvd> getDvdList() {
        return dvdList;
    }

    public void setDvdList(List<Dvd> dvdList) {
        this.dvdList = dvdList;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    public List<Tesis> getTesisList() {
        return tesisList;
    }

    public void setTesisList(List<Tesis> tesisList) {
        this.tesisList = tesisList;
    }

    public List<Revista> getRevistaList() {
        return revistaList;
    }

    public void setRevistaList(List<Revista> revistaList) {
        this.revistaList = revistaList;
    }
}