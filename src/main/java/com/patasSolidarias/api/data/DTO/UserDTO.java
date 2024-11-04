package com.patasSolidarias.api.data.DTO;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import com.patasSolidarias.api.models.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String email;
	private String telefone;
	private String cidade;
	private String sobre;
	private String foto;
	private Set<String> roles;

	public UserDTO() {
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.nome = user.getNome();
		this.email = user.getEmail();
		this.telefone = user.getTelefone();
		this.cidade = user.getCidade();
		this.roles = user.getRoles();
		this.sobre = user.getSobre();
		this.foto = user.getFoto();
	}


	public UserDTO(String id, String nome, String email, Set<String> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles != null ? roles : Collections.emptySet();
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String srcImagemPerfil) {
		this.foto = srcImagemPerfil;
	}
}
