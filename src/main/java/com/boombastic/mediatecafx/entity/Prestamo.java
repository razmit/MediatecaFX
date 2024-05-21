package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestamos", indexes = {
        @Index(name = "ID_Usuario", columnList = "idUsuario"),
        @Index(name = "ID_Documento", columnList = "idDocumento")
})
@NamedQuery(name = "getAllInfoPrestamoAndAssociations", query =
        "SELECT pres FROM Prestamo pres " +
                "JOIN FETCH pres.idDocumento doc " +
                "LEFT JOIN FETCH doc.idTipoDocumento tp " +
                "LEFT JOIN FETCH doc.cdaudioList cda " +
                "LEFT JOIN FETCH doc.libroList libro " +
                "LEFT JOIN FETCH doc.revistaList revista " +
                "LEFT JOIN FETCH doc.dvdList dvd " +
                "LEFT JOIN FETCH doc.tesisList tesis")
@NamedQuery(name = "getPrestamoById", query =
        "SELECT pres FROM Prestamo pres " +
                "JOIN FETCH pres.idDocumento doc " +
                "LEFT JOIN FETCH doc.idTipoDocumento tp " +
                "LEFT JOIN FETCH doc.cdaudioList cda " +
                "LEFT JOIN FETCH doc.libroList libro " +
                "LEFT JOIN FETCH doc.revistaList revista " +
                "LEFT JOIN FETCH doc.dvdList dvd " +
                "LEFT JOIN FETCH doc.tesisList tesis " +
                "WHERE pres.id = :presId")
@NamedQuery(name = "findPrestamoByUsuarioWithAllAssociations", query =
        "SELECT pres FROM Prestamo pres " +
                "JOIN FETCH pres.idDocumento doc " +
                "LEFT JOIN FETCH doc.idTipoDocumento tp " +
                "LEFT JOIN FETCH doc.cdaudioList cda " +
                "LEFT JOIN FETCH doc.libroList libro " +
                "LEFT JOIN FETCH doc.revistaList revista " +
                "LEFT JOIN FETCH doc.dvdList dvd " +
                "LEFT JOIN FETCH doc.tesisList tesis " +
                "JOIN FETCH pres.idUsuario usr " +
                "WHERE usr.id = :usuarioId") // Consigue prestamos basados en usuarios
@NamedQuery(name = "findPrestamoByMora", query =
        "SELECT pres FROM Prestamo pres " +
                "JOIN FETCH pres.idDocumento doc " +
                "LEFT JOIN FETCH doc.idTipoDocumento tp " +
                "LEFT JOIN FETCH doc.cdaudioList cda " +
                "LEFT JOIN FETCH doc.libroList libro " +
                "LEFT JOIN FETCH doc.revistaList revista " +
                "LEFT JOIN FETCH doc.dvdList dvd " +
                "LEFT JOIN FETCH doc.tesisList tesis " +
                "JOIN pres.idUsuario usr " +
                "WHERE usr.cantidadMora > 0 OR usr.tiempoMora > 0") // Consigue prestamos basados en mora
@NamedQuery(name = "findPrestamoByTipoDoc", query =
        "SELECT pres FROM Prestamo pres " +
                "JOIN pres.idDocumento doc " +
                "JOIN doc.idTipoDocumento tp " +
                "LEFT JOIN FETCH doc.cdaudioList cda " +
                "LEFT JOIN FETCH doc.libroList libro " +
                "LEFT JOIN FETCH doc.revistaList revista " +
                "LEFT JOIN FETCH doc.dvdList dvd " +
                "LEFT JOIN FETCH doc.tesisList tesis " +
                "WHERE tp.nombreTipo = :tipoDoc") // Consigue prestamos basados en tipoDoc
//@NamedQuery(name = "updatePrestamo", query = "update Prestamo pres SET pres.fechaPrestamo = :newArtista, pres.duracion = :newDuracion, " +
//        "pres.genero = :newGenero, pres.numCanciones = :newNumCancion where id = :presId")
@NamedQuery(name = "deletePrestamo", query = "delete Prestamo pres where id = :presId")
public class Prestamo {

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestamo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocumento")
    private Documento idDocumento;

    @Column(name = "fechaPrestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    @ColumnDefault("'Prestado'")
    @Lob
    @Column(name = "estado")
    private String estado;

    @ColumnDefault("0.00")
    @Column(name = "mora", precision = 10, scale = 2)
    private BigDecimal mora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
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