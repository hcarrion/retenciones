package org.fmbbva.movcor.security.oauth.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InsufficientScopeException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * @author xe35370
 * 
 * Clase para la traducción de excepciones
 * 
 * LdapAuthenticationProvider.badCredentials=Bad credentials
 * LdapAuthenticationProvider.credentialsExpired=User credentials have expired
 * LdapAuthenticationProvider.disabled=User is disabled
 * LdapAuthenticationProvider.expired=User account has expired
 * LdapAuthenticationProvider.locked=User account is locked
 * LdapAuthenticationProvider.emptyUsername=Empty username not allowed
 * LdapAuthenticationProvider.onlySupports=Only UsernamePasswordAuthenticationToken is supported
 * 
 */
public class ExceptionTranslator implements WebResponseExceptionTranslator {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionTranslator.class);

	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		return handleOAuth2Exception((OAuth2Exception) e);
	}
	
	private ResponseEntity<OAuth2Exception> handleOAuth2Exception(OAuth2Exception e) throws IOException {

		int status = e.getHttpErrorCode();
		
		logger.debug("httpErrorCode inicial {}", status);
		
		if(SpringSecurityMessageSource.getAccessor().getMessage("LdapAuthenticationProvider.disabled", "User is disabled").equals(e.getMessage())){
			status = HttpStatus.FORBIDDEN.value();
		}
		
		if(SpringSecurityMessageSource.getAccessor().getMessage("LdapAuthenticationProvider.locked", "User account is locked").equals(e.getMessage())){
			status = HttpStatus.UNAUTHORIZED.value();
		}
		
		if(SpringSecurityMessageSource.getAccessor().getMessage("LdapAuthenticationProvider.expired", "User account has expired").equals(e.getMessage()) || 
				SpringSecurityMessageSource.getAccessor().getMessage("LdapAuthenticationProvider.credentialsExpired","User credentials have expired").equals(e.getMessage())){
			status = HttpStatus.PRECONDITION_FAILED.value();
		}
		
		logger.debug("httpErrorCode final {}", status);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cache-Control", "no-store");
		headers.set("Pragma", "no-cache");
		if (status == HttpStatus.UNAUTHORIZED.value() || (e instanceof InsufficientScopeException)) {
			headers.set("WWW-Authenticate", String.format("%s %s", OAuth2AccessToken.BEARER_TYPE, e.getSummary()));
		}
		
		ResponseEntity<OAuth2Exception> response = new ResponseEntity<OAuth2Exception>(e, headers,
				HttpStatus.valueOf(status));

		return response;

	}
	
}
