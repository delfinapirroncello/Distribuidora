package com.example.practica.controller;

import com.example.practica.model.Pedido;
import com.example.practica.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidos;
    }

    @PostMapping("/crear")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoActualizado) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                pedido.setCliente(pedidoActualizado.getCliente());
                pedido.setProductos(pedidoActualizado.getProductos());
                return pedido;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidos.removeIf(pedido -> pedido.getId().equals(id));
    }

    @GetMapping("/{id}")
    public Pedido buscarPedidoPorId(@PathVariable Long id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId().equals(id))
                .findFirst()
                .orElse(null); // Manejar caso si no se encuentra el pedido
    }
}
