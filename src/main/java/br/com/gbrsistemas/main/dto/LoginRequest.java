package br.com.gbrsistemas.main.dto;

public class LoginRequest {
	
	private String login;
	private String senha;
	private String grant_type;
	
	public LoginRequest() {}
	
	public LoginRequest(String login, String senha) {
		this.grant_type = "password";
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
