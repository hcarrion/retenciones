package org.fmbbva.movcor.security.oauth.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="oauth2.client")
public class OAuth2ClientCfg {

	/** **/
	private String id;
	/** **/
	private String resourceId;
	/** **/
	private String clientId;
	/** **/
	private String clientSecret;
	/** **/
	private List<String> authorizedGrantTypes;
	/** **/
	private List<String> scopes;
	/** **/
	private Integer accessTokenValiditySeconds;
	/** **/
	private Integer refreshTokenValiditySeconds;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public List<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public void setAuthorizedGrantTypes(List<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}
	public List<String> getScopes() {
		return scopes;
	}
	public void setScopes(List<String> scopes) {
		this.scopes = scopes;
	}
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}
	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}
	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

}
