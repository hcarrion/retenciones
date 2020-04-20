package org.fmbbva.movcor.security.oauth;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
//añade la posibilidad de porder desplegar como WAR
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * Clase de inicio del servidor de autenticación
 * @author xe62596
 * @since 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan(basePackages={ "org.fmbbva.movcor.security", "org.fmbbva.movcli.arq.web"})
public class AuthorizationServerApplication extends SpringBootServletInitializer {
    
    private static Logger logger = LoggerFactory.getLogger(AuthorizationServerApplication.class);
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthorizationServerApplication.class);
    }
    
    /**
     * Método principal que arranca la aplicación
     *
     * @param args argumentos de la línea de comandos
     * @throws UnknownHostException si el host local no puede ser mapeado
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(AuthorizationServerApplication.class);
        Environment env = app.run(args).getEnvironment();
        logger.info("\n----------------------------------------------------------\n\t" +
                "La aplicación '{}' está ejecutándose! URLs de acceso:\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "External: \thttp://{}:{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));

    }
    
}
