package org.fmbbva.movcor.security.oauth.config;

import org.fmbbva.movcor.security.oauth.ldap.CustomUserDetailsContextMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

/**
 * Spring security LDAP configuration.
 * @author angelo.boursin
 */
@Configuration
@EnableWebSecurity
public class WebSecurityCfg extends WebSecurityConfigurerAdapter{
	
	private static Logger logger = LoggerFactory.getLogger(WebSecurityCfg.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private LDAPCfg ldapCgf;
	
	public WebSecurityCfg(){
		super();
		logger.info("Load...");
	}

	/**
	 * Configure 'in memory' authentication.
	 * @param auth {@link AuthenticationManagerBuilder}
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsContextMapper customUserDetailsContextMapper, GrantedAuthoritiesMapper grantedAuthoritiesMapper) throws Exception {
		
		if(env.acceptsProfiles("local")){
			logger.warn(
					"[AUTHSERVER-SECURITY] Configuración de la conexión con el servidor LDAP en MEMORIA para autenticación. Sólo entorno local/test!!");
			auth.ldapAuthentication()
				.userDetailsContextMapper(customUserDetailsContextMapper)
				.userSearchBase(ldapCgf.getSearchBase())
				.userSearchFilter(ldapCgf.getUserSearch())
				.groupSearchBase(ldapCgf.getGroupSearchBase())
				.groupSearchFilter(ldapCgf.getSearchFilter())
				.contextSource()
				.root(ldapCgf.getRootDn())
				.ldif("classpath:test-server.ldif");
			logger.info(
					"[AUTHSERVER-SECURITY] Finalizada configuración de la conexión con el servidor LDAP para autenticación.");
		} else {
    		logger.info(
    				"[AUTHSERVER-SECURITY] Configuración de la conexión con el servidor LDAP para autenticación.");
    		
    		logger.info("[AD-PROVIDER] INICIO Configuración AD para autenticación.");
    		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(ldapCgf.getDomain(), ldapCgf.getUrl(), ldapCgf.getRootDn());
    		provider.setConvertSubErrorCodesToExceptions(true);
    		provider.setUseAuthenticationRequestCredentials(true);
    		provider.setUserDetailsContextMapper(customUserDetailsContextMapper);
    		provider.setAuthoritiesMapper(grantedAuthoritiesMapper);
    		logger.info("[AD-PROVIDER] FIN Configuración AD para autenticación.");
			
    		auth.authenticationProvider(provider);
			logger.info(
    	    		"[AUTHSERVER-SECURITY] Finalizada configuración de la conexión con el servidor LDAP para autenticación.");
		}
	}
	
	/**
	 * LDAP Template bean.
	 * @param contextSource LDAP context source
	 * @return New instance of {@link LdapTemplate}
	 * @throws Exception
	 */
	@Bean
	public UserDetailsContextMapper customUserDetailsContextMapper() throws Exception{
		CustomUserDetailsContextMapper customUserDetailsContextMapper = new CustomUserDetailsContextMapper();
		return customUserDetailsContextMapper;
	}
	
	/**
	 * Mapeo de authorities
	 * @return
	 * @throws Exception
	 */
	@Bean 
	public GrantedAuthoritiesMapper simpleAuthorityMapper() throws Exception {
		SimpleAuthorityMapper grantedAuthoritiesMapper = new SimpleAuthorityMapper();
		grantedAuthoritiesMapper.setConvertToUpperCase(true);
		return grantedAuthoritiesMapper;
	}
	
	/**
	 * {@inheritDoc}
	 * Authorize only authenticated users.
	 * Describe login & logout actions.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		logger.info("[AUTHSERVER-SECURITY] Configurando la seguridad de los endpoints del servidor oauth");
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
		.and()
			.authorizeRequests()
				.antMatchers("/h2-console/**").permitAll();
	
		// TODO comprobar si realmente es necesario
		http.csrf().disable();
		http.headers().frameOptions().disable();

		logger.info("[AUTHSERVER-SECURITY] Finalizada configuración de seguridad del servidor oauth");

	}

}
