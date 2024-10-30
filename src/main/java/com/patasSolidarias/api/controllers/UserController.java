package com.patasSolidarias.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patasSolidarias.api.models.User;
import com.patasSolidarias.api.services.AuthService;
import com.patasSolidarias.api.services.UserServices;

@RestController
@RequestMapping("public/api/user")
public class UserController {
    
    @Autowired
    private UserServices service;
    
    @Autowired
    private AuthService authService;

    @GetMapping
    public List<User> listarUsuarios() {
        return service.listarUsuarios();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User usuario) {
    	return authService.login(usuario);
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody User usuario) {
        return service.criarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public User buscarUsuario(@PathVariable String id) {
        return service.buscarUsuario(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable String id) {
        return;
    }
}
