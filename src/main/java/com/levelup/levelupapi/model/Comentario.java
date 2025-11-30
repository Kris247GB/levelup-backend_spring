package com.levelup.levelupapi.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId;
    private String texto;
    private Integer rating;
    private String fecha;
    private Integer likes = 0; // ❤️ NUEVO

    @ElementCollection
    private List<String> respuestas = new ArrayList<>(); // 💬 NUEVO

    public Long getId() { return id; }
    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Integer getLikes() { return likes; }
    public void setLikes(Integer likes) { this.likes = likes; }

    public List<String> getRespuestas() { return respuestas; }
    public void setRespuestas(List<String> respuestas) { this.respuestas = respuestas; }
}
