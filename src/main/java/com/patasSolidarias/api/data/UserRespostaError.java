package com.patasSolidarias.api.data;

import com.patasSolidarias.api.models.User;

public class UserRespostaError implements Resposta{
	
	private String mensagem;
	private User user;
	private Boolean success = false;
	
	

	public UserRespostaError(String mensagem, User user) {
		super();
		this.mensagem = mensagem;
		this.user = user;
		this.success = getSuccess();
	}
	
	public UserRespostaError( User user) {
		this.user = user;
	}
	
	public UserRespostaError(String mensagem) {
		this.mensagem = mensagem;
	}


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	

	@Override
	public String getMensagem() {
		return this.mensagem;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public Boolean getSuccess() {
		return this.success;
	}

	

}
