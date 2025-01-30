package com.inventario.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 10, max = 15, message = "El numero de la cedula debe tener entre 10 y 15 caracteres")
	@NotBlank(message = "El campo cedula no puede estar vacio")
  private String cedula;
  @Size(min = 3, max = 50, message = "Los nombres debe tener entre 3 y 50 caracteres")
  @NotBlank(message = "El campo nombres no puede estar vacio")
  private String nombres;
  @Email(message = "El email no es valido")
  @NotBlank(message = "El campo email no puede estar vacio")
  private String email;
  @Size(min = 3, max = 50, message = "La direccion debe tener entre 3 y 50 caracteres")
  @NotBlank(message = "El campo direccion no puede estar vacio")
  private String direccion;
  @Size(min = 10, max = 10, message = "El telefono debe 10 numeros")
  @NotBlank(message = "El campo telefono no puede estar vacio")
  private String telefono;
}
