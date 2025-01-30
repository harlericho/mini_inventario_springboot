package com.inventario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "El categoria no puede estar vacio")
  private String categoria;
  @Size(min = 13, max = 13, message = "El codigo de barras debe tener 13 caracteres")
  @NotBlank(message = "El codigo de barras no puede estar vacio")
  private String codigoBarra;
  @NotBlank(message = "El campo nombres no puede estar vacio")
  private String nombre;
  @NotBlank(message = "El precio de venta no puede estar vacio")
  private String precioVenta;
  @NotBlank(message = "El stock no puede estar vacio")
  private String stock;
  @NotBlank(message = "El proveedor no puede estar vacio")
  private String proveedor;
  @NotBlank(message = "El estado no puede estar vacio")
  private String estado;
  
}
