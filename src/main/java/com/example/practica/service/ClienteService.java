package com.example.practica.service;

import com.example.practica.model.Cliente;
import com.example.practica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired(required = false)
    private ClienteRepository clienteRepository;

    // Métodos CRUD
    // Crear o guardar cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Leer todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Actualizar cliente por ID
    public Cliente actualizarCliente(Long id, String nuevoNombre) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNombre(nuevoNombre);
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Buscar cliente por ID
    public Cliente buscarClienteUnico(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Mostrar lista de clientes
    public void mostrarListaClientes() {
        List<Cliente> clientes = getAllClientes();
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", ID: " + cliente.getId());
        }
        System.out.println();
    }
}
