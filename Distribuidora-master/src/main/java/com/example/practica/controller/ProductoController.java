package com.example.practica.controller;

import com.example.practica.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    @GetMapping
    public List<Producto> getAllProductos() {
        return productos;
    }

    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setDisponible(productoActualizado.isDisponible());
                return producto;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productos.removeIf(producto -> producto.getId().equals(id));
    }

    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
