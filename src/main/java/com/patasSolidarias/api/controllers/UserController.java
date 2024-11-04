package com.patasSolidarias.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patasSolidarias.api.data.Resposta;
import com.patasSolidarias.api.data.DTO.UserDTO;
import com.patasSolidarias.api.models.User;
import com.patasSolidarias.api.services.UserServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/user")
public class UserController {
    
    @Autowired
    private UserServices service;
    

    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista de usuários.")
    @GetMapping
    public List<UserDTO> listarUsuarios() {
        return service.listarUsuarios();
    }
    
    @Operation(summary = "Buscar um usuário por ID", description = "Retorna um usuário com base no ID fornecido.")
    @GetMapping("/{id}")
    public User buscarUsuario(@PathVariable String id) {
        return service.buscarUsuario(id);
    }
    @CrossOrigin("http://http://127.0.0.1:5500")
    @Operation(summary = "Editar um usuário ", description = "Retorna o usuário editado.")
    @PutMapping
    public ResponseEntity<Resposta> editarUsuario(@RequestBody User usuario) {
        return service.editarUsuario(usuario);
    }

    @Operation(summary = "Deletar um usuário", description = "Deleta um usuário com base no ID fornecido.")
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable String id) {
        service.deletarUsuario(id);
    }
}
