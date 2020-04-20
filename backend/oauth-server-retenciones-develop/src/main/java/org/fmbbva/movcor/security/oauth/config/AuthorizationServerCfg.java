package org.fmbbva.movcor.security.oauth.config;

import org.fmbbva.movcor.security.oauth.exception.ExceptionTranslator;
import org.mfbbva.movcor.security.oauth.token.CustomerAccessTokenConverter;
import org.mfbbva.movcor.security.oauth.token.SynchronizedTokenServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Configuración para el servidor OAuth2
 * 
 * @author xe62596
 * @since 1.0
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE)
@EnableAuthorizationServer
public class AuthorizationServerCfg extends AuthorizationServerConfigurerAdapter {

	private static Logger logger = LoggerFactory.getLogger(AuthorizationServerCfg.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	OAuth2ClientCfg oauth2ClientCfg;
	
	@Autowired
	private TokenStore tokenStore;
	
	
	/**
	 * Configuración de los servicios que gestionan el token de autorización
	 * <ul>
	 * 	<li>{@link DefaultTokenServices} se configura el servicio de persistencia del token</li>
	 *  <li>{@link ClientDetailsService} se configura el servicio de persistencia del client</li>
	 * </ul>
	 * @return los servicios {@link AuthorizationServerTokenServices} configurados 
	 */
    @Bean
	public AuthorizationServerTokenServices authorizationServerTokenServices() {
    	
		logger.debug("[AUTHSERVER-CONF] Creando AuthorizationServerTokenServices");
		DefaultTokenServices defaultTokenServices = new SynchronizedTokenServices();
		//TODO: observar la posibilidad de tener un repositorio de ClientDetails en lugar de estático
		defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setSupportRefreshToken(true);

		logger.debug("[AUTHSERVER-CONF] AuthorizationServerTokenServices creados");
		return defaultTokenServices;
	}
    
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		logger.info("[AUTHSERVER-CONF] Configuring client details service");
		// @formatter:off
        clients.inMemory()
	        .withClient(oauth2ClientCfg.getClientId())
	            .authorizedGrantTypes(oauth2ClientCfg.getAuthorizedGrantTypes().toArray(new String[oauth2ClientCfg.getAuthorizedGrantTypes().size()]))
	            .scopes(oauth2ClientCfg.getScopes().toArray(new String[oauth2ClientCfg.getScopes().size()]))
	            .resourceIds(oauth2ClientCfg.getResourceId())
	            .secret(oauth2ClientCfg.getClientSecret())
	            .accessTokenValiditySeconds(oauth2ClientCfg.getAccessTokenValiditySeconds())
	            .refreshTokenValiditySeconds(oauth2ClientCfg.getRefreshTokenValiditySeconds());

		// @formatter:on
		logger.info("[AUTHSERVER-CONF] Client details service configured");
	}    
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	   oauthServer.checkTokenAccess("isAuthenticated()");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		logger.debug("[AUTHSERVER-CONF] Configuring endpoints");
		endpoints.tokenServices(authorizationServerTokenServices());
		endpoints.authenticationManager(authenticationManager);
		endpoints.accessTokenConverter(new CustomerAccessTokenConverter());
		endpoints.exceptionTranslator(new ExceptionTranslator());
		logger.debug("[AUTHSERVER-CONF] Endpoints configured");
    }

}
