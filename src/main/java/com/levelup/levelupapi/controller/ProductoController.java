package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.Producto;
import com.levelup.levelupapi.model.Comentario;  // Asegúrate de tener la clase Comentario importada
import com.levelup.levelupapi.service.ProductoService;
import com.levelup.levelupapi.service.ComentarioService;  // Asegúrate de tener el servicio de Comentario

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "API para gestión de productos LevelUp Gamer")
public class ProductoController {

    private final ProductoService service;
    private final ComentarioService comentarioService;  // Agregar el servicio de comentarios

    public ProductoController(ProductoService service, ComentarioService comentarioService) {
        this.service = service;
        this.comentarioService = comentarioService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Retorna una lista de todos los productos disponibles en la tienda. Utilizado para mostrar el catálogo completo.")
    public List<Producto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID", description = "Retorna el producto correspondiente al ID proporcionado. Si no se encuentra, lanza un error 404.")
    public Producto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/codigo/{codigo}")
    @Operation(summary = "Obtener un producto por código", description = "Retorna el producto correspondiente al código proporcionado. Si no se encuentra, lanza un error 404.")
    public Producto getByCodigo(@PathVariable String codigo) {
        return service.getByCodigo(codigo);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Permite crear un nuevo producto con la información proporcionada.")
    public Producto create(@RequestBody Producto p) {
        return service.create(p);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente", description = "Actualiza la información de un producto existente. Si el producto no existe, lanza un error 404.")
    public Producto update(@PathVariable Long id, @RequestBody Producto p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Elimina el producto correspondiente al ID proporcionado. Si no se encuentra, lanza un error 404.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/categorias")
    @Operation(summary = "Obtener categorías disponibles", description = "Retorna una lista de las categorías disponibles para los productos en la tienda.")
    public List<String> categorias() {
        return service.listarCategorias();
    }

    // 🚀 Nuevo endpoint para obtener comentarios de un producto
    @GetMapping("/{productoId}/comentarios")
    @Operation(summary = "Obtener comentarios de un producto", description = "Retorna los comentarios de un producto específico.")
    public List<Comentario> obtenerComentarios(@PathVariable Long productoId) {
        return comentarioService.obtenerComentariosPorProducto(productoId);
    }

    // 🚀 Nuevo endpoint para agregar un comentario a un producto
    @PostMapping("/{productoId}/comentarios")
    @Operation(summary = "Agregar un comentario a un producto", description = "Permite agregar un comentario a un producto específico.")
    public Comentario agregarComentario(@PathVariable Long productoId, @RequestBody Comentario comentario) {
        return comentarioService.agregarComentario(productoId, comentario);
    }
    // ❤️ LIKE A UN COMENTARIO
    @PostMapping("/comentarios/{id}/like")
    public Comentario likeComentario(@PathVariable Long id) {
        return comentarioService.agregarLike(id);
    }

    // 💬 RESPUESTA A UN COMENTARIO
    @PostMapping("/comentarios/{id}/respuesta")
    public Comentario responderComentario(@PathVariable Long id, @RequestBody String respuesta) {
        return comentarioService.agregarRespuesta(id, respuesta);
    }

}
