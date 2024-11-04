package com.patasSolidarias.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patasSolidarias.api.models.User;
import com.patasSolidarias.api.services.AuthService;
import com.patasSolidarias.api.services.UserServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("auth")
public class AuthController {
    
    @Autowired
    private UserServices service;
    
    @Autowired
    private AuthService authService;

    
    @Operation(summary = "Login do usuário", description = "Realiza o login do usuário com base nas credenciais fornecidas.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login bem-sucedido"),
        @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User usuario) {
        return authService.login(usuario);
    }

    @Operation(summary = "Criar um novo usuário", description = "Cria um novo usuário com os dados fornecidos.")
    @PostMapping("/create")
    public ResponseEntity<?> criarUsuario(@RequestBody User usuario) {
        return service.criarUsuario(usuario);
    }

}
