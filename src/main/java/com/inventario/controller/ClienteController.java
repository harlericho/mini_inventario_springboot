package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.entity.Cliente;
import com.inventario.service.ClienteService;

import jakarta.validation.Valid;

@Controller
public class ClienteController {
  @Autowired
  private ClienteService clienteService;

  @GetMapping("/clientes")
  public String listadoClientes(Model model)
  {
    List<Cliente> clientes = clienteService.findAll();
    model.addAttribute("clientes", clientes);
    return "clientes/clientes";
  }
  @GetMapping("/crearClientes")
	public String crearCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "clientes/crearClientes";
  }
  @PostMapping("/guardarCliente")
  public String guardarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {
	if(result.hasErrors()) {
      return "clientes/crearClientes";
    }
    clienteService.saveCliente(cliente);
    return "redirect:/clientes";
  }
  @GetMapping("/editarCliente/{id}")
  public String editarCliente(Model model, @PathVariable Long id, @ModelAttribute Cliente cliente ) {
		Cliente dato = clienteService.findById(id);
		model.addAttribute("cliente", dato);
		return "clientes/crearClientes";
  }
  @PostMapping("/editarCliente/{id}")
  public String actualizarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {
	  if(result.hasErrors())
	  {
		return "clientes/crearClientes";
	  }
      clienteService.saveCliente(cliente);
      return "redirect:/clientes";
  }
  @GetMapping("/eliminarCliente/{id}")
  public String eliminarCliente(@PathVariable Long id) {
    clienteService.deleteCliente(id);
    return "redirect:/clientes";
  }
  
}
