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

            // Nuevos productos de prueba
            Producto producto4 = new Producto();
            producto4.setCodigo("P004");
            producto4.setNombre("Catan");
            producto4.setPrecio(39999);
            producto4.setCategoria("Juegos de mesa");
            producto4.setDescripcion("Catan, el juego de estrategia para 3-4 jugadores.");
            producto4.setImagen("link_to_image");
            producto4.setStock(30);
            producto4.setDestacado(true);

            Producto producto5 = new Producto();
            producto5.setCodigo("P005");
            producto5.setNombre("PlayStation 5");
            producto5.setPrecio(499999);
            producto5.setCategoria("Consolas");
            producto5.setDescripcion("PS5, la consola de última generación de Sony.");
            producto5.setImagen("link_to_image");
            producto5.setStock(10);
            producto5.setDestacado(true);

            Producto producto6 = new Producto();
            producto6.setCodigo("P006");
            producto6.setNombre("PC Gamer ASUS ROG Strix");
            producto6.setPrecio(999999);
            producto6.setCategoria("PC Gamer");
            producto6.setDescripcion("PC Gamer potente de ASUS, ideal para juegos de alto rendimiento.");
            producto6.setImagen("link_to_image");
            producto6.setStock(5);
            producto6.setDestacado(true);

            Producto producto7 = new Producto();
            producto7.setCodigo("P007");
            producto7.setNombre("Silla Gamer Secretlab Titan");
            producto7.setPrecio(79999);
            producto7.setCategoria("Accesorios");
            producto7.setDescripcion("Silla ergonómica de alta calidad para largas sesiones de juego.");
            producto7.setImagen("link_to_image");
            producto7.setStock(20);
            producto7.setDestacado(false);

            Producto producto8 = new Producto();
            producto8.setCodigo("P008");
            producto8.setNombre("Mouse Gamer Logitech G502 HERO");
            producto8.setPrecio(59999);
            producto8.setCategoria("Accesorios");
            producto8.setDescripcion("Mouse gamer con precisión de hasta 16,000 DPI.");
            producto8.setImagen("link_to_image");
            producto8.setStock(50);
            producto8.setDestacado(true);

            Producto producto9 = new Producto();
            producto9.setCodigo("P009");
            producto9.setNombre("Auriculares Gaming HyperX Cloud II");
            producto9.setPrecio(79999);
            producto9.setCategoria("Audio");
            producto9.setDescripcion("Auriculares con sonido envolvente 7.1 para una experiencia inmersiva.");
            producto9.setImagen("link_to_image");
            producto9.setStock(40);
            producto9.setDestacado(false);

            Producto producto10 = new Producto();
            producto10.setCodigo("P010");
            producto10.setNombre("Polera Gamer Personalizada \"Level-Up\"");
            producto10.setPrecio(24999);
            producto10.setCategoria("Ropa");
            producto10.setDescripcion("Polera gamer personalizada con el logo de \"Level-Up\".");
            producto10.setImagen("link_to_image");
            producto10.setStock(100);
            producto10.setDestacado(true);

            Producto producto11 = new Producto();
            producto11.setCodigo("P011");
            producto11.setNombre("Cuchuflí");
            producto11.setPrecio(1000);
            producto11.setCategoria("Comida");
            producto11.setDescripcion("Delicioso dulce chileno, ideal para acompañar con un café.");
            producto11.setImagen("link_to_image");
            producto11.setStock(150);
            producto11.setDestacado(false);

            Producto producto12 = new Producto();
            producto12.setCodigo("P012");
            producto12.setNombre("Alfajor de Chocolate");
            producto12.setPrecio(1500);
            producto12.setCategoria("Comida");
            producto12.setDescripcion("Alfajor relleno de manjar y cubierto con chocolate.");
            producto12.setImagen("link_to_image");
            producto12.setStock(100);
            producto12.setDestacado(false);

            Producto producto13 = new Producto();
            producto13.setCodigo("P013");
            producto13.setNombre("Polera Personalizada \"Gamer\"");
            producto13.setPrecio(29999);
            producto13.setCategoria("Ropa");
            producto13.setDescripcion("Polera personalizada para gamers.");
            producto13.setImagen("link_to_image");
            producto13.setStock(80);
            producto13.setDestacado(false);

            Producto producto14 = new Producto();
            producto14.setCodigo("P014");
            producto14.setNombre("Teclado Mecánico Corsair K95 RGB");
            producto14.setPrecio(129999);
            producto14.setCategoria("Accesorios");
            producto14.setDescripcion("Teclado mecánico con retroiluminación RGB.");
            producto14.setImagen("link_to_image");
            producto14.setStock(25);
            producto14.setDestacado(true);

            // Guardar los productos en la base de datos
            productoRepository.save(producto1);
            productoRepository.save(producto2);
            productoRepository.save(producto3);
            productoRepository.save(producto4);
            productoRepository.save(producto5);
            productoRepository.save(producto6);
            productoRepository.save(producto7);
            productoRepository.save(producto8);
            productoRepository.save(producto9);
            productoRepository.save(producto10);
            productoRepository.save(producto11);
            productoRepository.save(producto12);
            productoRepository.save(producto13);
            productoRepository.save(producto14);

            System.out.println("Productos de prueba cargados!");
        }
    }
}
