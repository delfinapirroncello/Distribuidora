package com.example.practica.controller;

import com.example.practica.model.Cliente;
import com.example.practica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/mostrar")
    public void mostrarListaClientes() {
        clienteService.mostrarListaClientes();
    }

    @PostMapping("/create")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody String nuevoNombre) {
        return clienteService.actualizarCliente(id, nuevoNombre);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }

    @GetMapping("/{id}")
    public Cliente buscarClienteUnico(@PathVariable Long id) {
        return clienteService.buscarClienteUnico(id);
    }
}
