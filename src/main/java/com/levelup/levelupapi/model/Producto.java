package com.levelup.levelupapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // ID autogenerado

    private String codigo;      // Ej: "P001"
    private String categoria;   // Ej: "Accesorios"
    private String nombre;      // Nombre del producto
    private int precio;         // Precio en CLP
    private String imagen;      // URL o ruta de imagen
    private String descripcion; // Descripción
    private int stock;          // Stock disponible
    private boolean destacado;  // Si es producto destacado o no
}
