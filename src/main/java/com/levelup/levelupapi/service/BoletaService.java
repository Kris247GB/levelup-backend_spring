package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Boleta;
import com.levelup.levelupapi.model.DetalleBoleta;
import com.levelup.levelupapi.model.Producto;
import com.levelup.levelupapi.repository.BoletaRepository;
import com.levelup.levelupapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaService {

    private final BoletaRepository repo;

    @Autowired
    private ProductoRepository productoRepository;

    public BoletaService(BoletaRepository repo) {
        this.repo = repo;
    }

    // ✔ Crear boleta (validación + descuento de stock)
    public Boleta crearBoleta(Boleta boleta) {

        // 1. VALIDAR STOCK
        for (DetalleBoleta d : boleta.getDetalles()) {
            Producto producto = productoRepository.findById(d.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + d.getProductoId()));

            if (producto.getStock() < d.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }
        }

        // 2. DESCONTAR STOCK
        for (DetalleBoleta d : boleta.getDetalles()) {
            Producto producto = productoRepository.findById(d.getProductoId()).get();
            producto.setStock(producto.getStock() - d.getCantidad());
            productoRepository.save(producto);

            d.setBoleta(boleta); // relación detalle → boleta
        }

        // 3. GUARDAR BOLETA FINAL
        return repo.save(boleta);
    }

    public Boleta obtenerBoleta(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Boleta> listar() {
        return repo.findAll();
    }

    public List<Boleta> buscarPorUsuario(String email) {
        return repo.findByEmailUsuario(email);
    }
}
