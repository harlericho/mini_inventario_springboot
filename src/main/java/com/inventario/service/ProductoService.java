package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.Producto;
import com.inventario.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	public Producto updateProducto(Producto producto) {
		producto = productoRepository.findById(producto.getId()).orElse(null);
		if (producto != null) {
			return productoRepository.save(producto);
		} else {
			return null;
		}
	}

	public void deleteProducto(Long id) {
		productoRepository.deleteById(id);
	}
}
