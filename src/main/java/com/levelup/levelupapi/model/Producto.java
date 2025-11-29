package com.levelup.levelupapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El código no puede estar vacío")
    @Size(min = 3, max = 20, message = "El código debe tener entre 3 y 20 caracteres")
    private String codigo;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser mayor a 0")
    private Integer precio;

    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(min = 3, max = 50, message = "La categoría debe tener entre 3 y 50 caracteres")
    private String categoria;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String descripcion;

    @NotBlank(message = "La URL de imagen no puede estar vacía")
    private String imagen;

    @NotNull(message = "El stock no puede ser nulo")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El campo destacado no puede ser nulo")
    private Boolean destacado;

    public Producto() {}

    // ---------- GETTERS ----------
    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Integer getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public String getDescripcion() { return descripcion; }
    public String getImagen() { return imagen; }
    public Integer getStock() { return stock; }
    public Boolean getDestacado() { return destacado; }

    // ---------- SETTERS ----------
    public void setId(Long id) { this.id = id; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Integer precio) { this.precio = precio; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public void setStock(Integer stock) { this.stock = stock; }
    public void setDestacado(Boolean destacado) { this.destacado = destacado; }
}
