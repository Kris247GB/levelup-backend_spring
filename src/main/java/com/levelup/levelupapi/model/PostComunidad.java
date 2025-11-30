package com.levelup.levelupapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PostComunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;   // nombre o email del usuario
    private String titulo;  // encabezado del post
    private String contenido;

    private LocalDateTime fecha = LocalDateTime.now();

    // Getters y Setters
    public Long getId() { return id; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFecha() { return fecha; }
}
