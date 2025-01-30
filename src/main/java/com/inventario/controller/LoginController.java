package com.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventario.entity.Rol;
import com.inventario.entity.User;
import com.inventario.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String login() {
		return "home/login";
	}
	@GetMapping("/register")
	public String register(Model model) {
		return "home/register";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
    User user = userService.findByUserAndPass(username, password);
    if (user != null) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("rol", user.getRol().getDescripcion());
        if (user.getRol().getId() == 1) {
            return "home/admin"; // Redirección para el rol admin
        } else {
            return "home/employee"; // Redirección para el rol employee
        }
    }
    model.addAttribute("error", "Usuario o contraseña incorrectos");
    return "home/login";
}
	
	@PostMapping("/register")
	public String register(
	    @RequestParam String username,
	    @RequestParam String password,
	    @RequestParam Long rolId,
	    Model model
	) {
		
	    // Verificar si el username ya existe
	    if (userService.findByUsername(username) != null) {
	        model.addAttribute("error", "El nombre de usuario ya existe.");
	        return "home/register";
	    }

	    // Crear el usuario y asignar el rol
	    User newUser = new User();
	    newUser.setUsername(username);
	    newUser.setPassword(password);
	    Rol rol = userService.findRolById(rolId);
	    newUser.setRol(rol);

	    userService.saveUser(newUser);

	    model.addAttribute("success", "Registro exitoso. Ahora puedes iniciar sesión.");
	    return "home/register";
	}
}
