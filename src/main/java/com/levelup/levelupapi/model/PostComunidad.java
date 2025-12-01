package com.levelup.levelupapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PostComunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;
    private String titulo;
    private String contenido;
    private int likes = 0;

    private LocalDateTime fecha = LocalDateTime.now();

    public Long getId() { return id; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public LocalDateTime getFecha() { return fecha; }
}
