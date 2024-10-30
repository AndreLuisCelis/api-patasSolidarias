package com.patasSolidarias.api.models;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "animals")
public class Animal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
    private String id;
    private String nome;
    private String tipo;
    private int idade;

    @DBRef
    private User usuario;

    public Animal() {}

	public Animal(String id, String nome, String tipo, int idade, User usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.idade = idade;
		this.usuario = usuario;
	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
    
    
}

