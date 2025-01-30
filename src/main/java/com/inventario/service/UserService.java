package com.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.Rol;
import com.inventario.entity.User;
import com.inventario.repository.RolRepository;
import com.inventario.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RolRepository rolRepository;

	public User findByUserAndPass(String username, String pass) {
		User user = userRepository.findByUsername(username);
		if (user != null && user.getPassword().equals(pass)) {
			return user;
		}
		return null;
	}
	public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Rol findRolById(Long rolId) {
        return rolRepository.findById(rolId).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
