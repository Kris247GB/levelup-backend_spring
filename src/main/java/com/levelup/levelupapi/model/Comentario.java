package com.levelup.levelupapi.model;

public class Comentario {

    private Long id;
    private Long productoId; // ID del producto al que pertenece el comentario
    private String texto;    // El contenido del comentario
    private Integer rating;  // Calificación (1-5 estrellas)
    private String fecha;    // Fecha del comentario (puedes usar LocalDateTime si prefieres)

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
