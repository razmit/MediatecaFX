package com.boombastic.mediatecafx.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@NamedQuery(name = "getAllUsers", query = "select u FROM Usuario u")
@NamedQuery(name = "getUserById", query = "select u from Usuario u WHERE u.id = :userId")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "tipoUsuario", length = 150)
    private String tipoUsuario;

    @Column(name = "contrasena", length = 100)
    private String contrasena;

    @Column(name = "cantidadMora", nullable = false)
    private Integer cantidadMora;

    @Column(name = "tiempoMora", nullable = false)
    private Integer tiempoMora;

    @Column(name = "codigoUsuario", nullable = false, length = 100)
    private String codigoUsuario;

    @OneToMany(mappedBy = "idUsuario")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getCantidadMora() {
        return cantidadMora;
    }

    public void setCantidadMora(Integer cantidadMora) {
        this.cantidadMora = cantidadMora;
    }

    public Integer getTiempoMora() {
        return tiempoMora;
    }

    public void setTiempoMora(Integer tiempoMora) {
        this.tiempoMora = tiempoMora;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

}