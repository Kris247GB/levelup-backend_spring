package com.levelup.levelupapi;

import com.levelup.levelupapi.model.Producto;
import com.levelup.levelupapi.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    public DataLoader(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Agregar productos de prueba solo si la base de datos está vacía
        if (productoRepository.count() == 0) {
            Producto producto1 = new Producto();
            producto1.setCodigo("P001");
            producto1.setNombre("Control Xbox");
            producto1.setPrecio(49999);
            producto1.setCategoria("Accesorios");
            producto1.setDescripcion("Control inalámbrico Xbox para PC");
            producto1.setImagen("link_to_image");
            producto1.setStock(10);
            producto1.setDestacado(true);

            Producto producto2 = new Producto();
            producto2.setCodigo("P002");
            producto2.setNombre("Auriculares Gaming");
            producto2.setPrecio(79999);
            producto2.setCategoria("Audio");
            producto2.setDescripcion("Auriculares con micrófono HyperX");
            producto2.setImagen("link_to_image");
            producto2.setStock(15);
            producto2.setDestacado(true);

            Producto producto3 = new Producto();
            producto3.setCodigo("P003");
            producto3.setNombre("Ratón Gamer");
            producto3.setPrecio(39999);
            producto3.setCategoria("Accesorios");
            producto3.setDescripcion("Razer DeathAdder V2");
            producto3.setImagen("link_to_image");
            producto3.setStock(20);
            producto3.setDestacado(false);

            // Guardar los productos en la base de datos
            productoRepository.save(producto1);
            productoRepository.save(producto2);
            productoRepository.save(producto3);

            System.out.println("Productos de prueba cargados!");
        }
    }
}
