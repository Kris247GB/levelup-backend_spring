package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.Producto;
import com.levelup.levelupapi.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "API para gestión de productos LevelUp Gamer")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    public List<Producto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID")
    public Producto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/codigo/{codigo}")
    @Operation(summary = "Obtener un producto por código")
    public Producto getByCodigo(@PathVariable String codigo) {
        return service.getByCodigo(codigo);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto")
    public Producto create(@RequestBody Producto p) {
        return service.create(p);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente")
    public Producto update(@PathVariable Long id, @RequestBody Producto p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/categorias")
    @Operation(summary = "Obtener categorías disponibles")
    public List<String> categorias() {
        return service.listarCategorias();
    }
}
