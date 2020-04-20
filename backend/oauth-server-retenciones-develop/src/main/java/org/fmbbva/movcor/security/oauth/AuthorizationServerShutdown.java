package org.fmbbva.movcor.security.oauth;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationServerShutdown {

	private static Logger logger = LoggerFactory.getLogger(AuthorizationServerShutdown.class);

	@PreDestroy
	public void shutdown(){
        logger.info("[AUTHSERVER-SHUTDOWN] Procediendo a la parada ordenada de la aplicación.");
        logger.info("[AUTHSERVER-SHUTDOWN] Fin de la parada ordenada.");
	}
}
