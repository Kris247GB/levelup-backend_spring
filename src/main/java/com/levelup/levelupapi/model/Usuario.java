package com.levelup.levelupapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String rol = "USER"; // USER o ADMIN

    private Boolean mayor18;

    private String codigoReferido;

    private String codigoReferente;

    private Integer levelUpPoints = 0;

    private Integer descuentoDuoc = 0;

    private String preferencias;

    private LocalDateTime fechaRegistro = LocalDateTime.now();

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol != null ? rol.toUpperCase() : "USER"; }

    public Boolean getMayor18() { return mayor18; }
    public void setMayor18(Boolean mayor18) { this.mayor18 = mayor18; }

    public String getCodigoReferido() { return codigoReferido; }
    public void setCodigoReferido(String codigoReferido) { this.codigoReferido = codigoReferido; }

    public String getCodigoReferente() { return codigoReferente; }
    public void setCodigoReferente(String codigoReferente) { this.codigoReferente = codigoReferente; }

    public Integer getLevelUpPoints() { return levelUpPoints; }
    public void setLevelUpPoints(Integer levelUpPoints) { this.levelUpPoints = levelUpPoints; }

    public Integer getDescuentoDuoc() { return descuentoDuoc; }
    public void setDescuentoDuoc(Integer descuentoDuoc) { this.descuentoDuoc = descuentoDuoc; }

    public String getPreferencias() { return preferencias; }
    public void setPreferencias(String preferencias) { this.preferencias = preferencias; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
