package org.mfbbva.movcor.security.oauth.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

//TODO: observar comportamiento bajo estres
/**
 * Clase que sincroniza el acceso en la creación para evitar problemas de concurrencia
 * @author xe62596
 * @since 1.0
 */
public class SynchronizedTokenServices extends DefaultTokenServices {
	private static Logger logger = LoggerFactory.getLogger(SynchronizedTokenServices.class);

	@Override
	public synchronized OAuth2AccessToken createAccessToken(OAuth2Authentication authentication)
			throws AuthenticationException {
		logger.debug("[SERVER-CFG] Se crea un access token para el usuario autenticado como '{}' y con client id '{}'",
				authentication.getName(), authentication.getOAuth2Request().getClientId());
		OAuth2AccessToken accessToken = super.createAccessToken(authentication);
		logger.debug("[SERVER-CFG] Access token para el usuario autenticado como '{}' y con client id '{} se almacenó correctamente",
				authentication.getName(), authentication.getOAuth2Request().getClientId());
		return accessToken;
	}
}
