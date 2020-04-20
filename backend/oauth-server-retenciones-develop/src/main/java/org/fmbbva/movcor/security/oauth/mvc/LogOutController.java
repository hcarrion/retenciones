package org.fmbbva.movcor.security.oauth.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LogOutController {

	private static Logger logger = LoggerFactory.getLogger(LogOutController.class);
	
	@Autowired
	TokenStore tokenStore;

	private WebResponseExceptionTranslator exceptionTranslator = new DefaultWebResponseExceptionTranslator();
	
    @RequestMapping(value = "/oauth/logout", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestParam String token) {
    	
    	logger.debug("Haciendo logout del token '{}'", token);
    	
    	OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(token);
    	
    	try{
	    	tokenStore.removeAccessTokenUsingRefreshToken(refreshToken);
	    	tokenStore.removeRefreshToken(refreshToken);
    	} catch(Exception e){
        	throw new InvalidTokenException("Invalid refresh token: " + token);
    	}

    }

	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<OAuth2Exception> handleException(Exception e) throws Exception {
		logger.info("Capturando el error : " + e.getClass().getSimpleName() + ", " + e.getMessage());
		// This isn't an oauth resource, so we don't want to send an
		// unauthorized code here. The client has already authenticated
		// successfully with basic auth and should just
		// get back the invalid token error.
		@SuppressWarnings("serial")
		InvalidTokenException e400 = new InvalidTokenException(e.getMessage()) {
			@Override
			public int getHttpErrorCode() {
				return 400;
			}
		};
		return exceptionTranslator.translate(e400);
	}
    
}
