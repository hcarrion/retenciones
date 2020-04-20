package org.fmbbva.movcor.security.oauth.cucumber;


/*
 * {
 *	  "access_token": "eb5f1af5-333e-46c2-a640-06974fd60e16",
 *	  "token_type": "bearer",
 *	  "refresh_token": "20f0b3f7-29b7-4035-82e9-7ff37f6bcba0",
 *	  "expires_in": 599,
 *	  "scope": "read write"
 *	}
 */
public class LoginResponse {

	private String accessToken = null;
	private String tokenType = null;
	private String refreshToken = null;
	private String scope = null;
	private Integer expiresIn = null;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
