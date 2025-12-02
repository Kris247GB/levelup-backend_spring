package com.levelup.levelupapi.security.dto;

public class RegisterRequest {
    private String nombre;
    private String email;
    private String password;
    private Boolean mayor18;
    private String preferencias;
    private String codigoReferente;

    // GETTERS & SETTERS
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getMayor18() { return mayor18; }
    public void setMayor18(Boolean mayor18) { this.mayor18 = mayor18; }

    public String getPreferencias() { return preferencias; }
    public void setPreferencias(String preferencias) { this.preferencias = preferencias; }

    public String getCodigoReferente() { return codigoReferente; }
    public void setCodigoReferente(String codigoReferente) { this.codigoReferente = codigoReferente; }
}
