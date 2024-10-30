package com.patasSolidarias.api.data;

import com.patasSolidarias.api.data.DTO.UserDTO;
import com.patasSolidarias.api.models.User;

public class UserResposta implements Resposta{
	
	private String mensagem;
	private UserDTO user;
	private Boolean success = true;

	public UserResposta(String mensagem, User user) {
		this.mensagem = mensagem;
		this.user = new UserDTO(user);
		this.success = getSuccess();
	}
	
	public UserResposta( User user) {
		this.user = new UserDTO(user);
	}
	
	public UserResposta(String mensagem) {
		this.mensagem = mensagem;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = new UserDTO(user);
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	@Override
	public String getMensagem() {
		return this.mensagem;
	}

	@Override
	public Boolean getSuccess() {
		return this.success;
	}

	

}
