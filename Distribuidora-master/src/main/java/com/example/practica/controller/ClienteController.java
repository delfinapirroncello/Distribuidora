package com.example.practica.controller;

import com.example.practica.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clientes;
    }

    @GetMapping("/mostrar")
    public void mostrarListaClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody String nuevoNombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                cliente.setNombre(nuevoNombre);
                return cliente;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    @GetMapping("/{id}")
    public Cliente buscarClienteUnico(@PathVariable Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
}
