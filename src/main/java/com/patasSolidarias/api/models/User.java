package com.patasSolidarias.api.models;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private Set<String> roles;
    
	public User() {}

	/*
	 * public User(String id, String nome, String email, String senha, Set<String>
	 * roles) { super(); this.id = id; this.nome = nome; this.email = email;
	 * this.senha = senha; this.roles = roles; }
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<String> getRoles() {
		return roles != null ? roles : Collections.emptySet();
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
}