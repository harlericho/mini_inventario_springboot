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

import com.inventario.entity.Producto;
import com.inventario.service.ProductoService;

import jakarta.validation.Valid;

@Controller
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public String listadoProductos(Model model) {
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		return "productos/productos";
	}
	@GetMapping("/crearProductos")
	public String crearProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "productos/crearProductos";
	}
	@PostMapping("/guardarProducto")
	public String guardarProducto(@Valid @ModelAttribute Producto producto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "productos/crearProductos";
		}
		productoService.saveProducto(producto);
		return "redirect:/productos";
	}
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(Model model, @PathVariable Long id, @ModelAttribute Producto producto) {
		Producto dato = productoService.findById(producto.getId());
		model.addAttribute("producto", dato);
		return "productos/crearProductos";
	}
	@PostMapping("/editarProducto/{id}")
	public String actualizarProducto(@Valid @ModelAttribute Producto producto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "productos/crearProductos";
		}
		productoService.saveProducto(producto);
		return "redirect:/productos";
	}
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.deleteProducto(id);
		return "redirect:/productos";
	}
	
}
