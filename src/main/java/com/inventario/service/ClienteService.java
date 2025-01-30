package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.Cliente;
import com.inventario.repository.ClienteRepository;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository clienteRepository;

  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }
  public Cliente findById(Long id) {
    return clienteRepository.findById(id).orElse(null);
  }
  public Cliente saveCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }
  public Cliente updateCliente(Cliente cliente) {
    cliente = clienteRepository.findById(cliente.getId()).orElse(null);
    if (cliente != null) {
      return clienteRepository.save(cliente);
    } else {
      return null;
    } 
  }
  public void deleteCliente(Long id) {
    clienteRepository.deleteById(id);
  }
}
