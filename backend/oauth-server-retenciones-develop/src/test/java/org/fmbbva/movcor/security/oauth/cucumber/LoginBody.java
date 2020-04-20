package org.fmbbva.movcor.security.oauth.cucumber;

public class LoginBody {

	private String username = null;
	private String password = null;
	private String grantType = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LoginBody username(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBody password(String password) {
		this.password = password;
		return this;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public LoginBody grantType(String grantType) {
		this.grantType = grantType;
		return this;
	}

	@Override
	public String toString() {
		return "UsuarioBody [username=" + username + ", password=" + password + ", grantType=" + grantType + "]";
	}
	
	
}
