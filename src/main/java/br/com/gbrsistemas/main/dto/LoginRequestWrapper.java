package br.com.gbrsistemas.main.dto;

public class LoginRequestWrapper {
	
	private LoginRequest loginRequest;
    private VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest;
    
    private LoginRequestWrapper() {}

	public LoginRequest getLoginRequest() {
		return loginRequest;
	}

	public void setLoginRequest(LoginRequest loginRequest) {
		this.loginRequest = loginRequest;
	}

	public VistoriaEfetuadaSeletorRequest getVistoriaEfetuadaSeletorRequest() {
		return vistoriaEfetuadaSeletorRequest;
	}

	public void setVistoriaEfetuadaSeletorRequest(VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest) {
		this.vistoriaEfetuadaSeletorRequest = vistoriaEfetuadaSeletorRequest;
	}
    
}
