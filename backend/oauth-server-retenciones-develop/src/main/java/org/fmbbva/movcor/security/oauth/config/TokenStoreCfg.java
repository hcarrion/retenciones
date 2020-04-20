package org.fmbbva.movcor.security.oauth.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * Clase de configuración para la persistencia del Token OAuth de autorización 
 * @author xe62596
 * @since 1.0
 */
@Configuration
public class TokenStoreCfg {

	private static Logger logger = LoggerFactory.getLogger(TokenStoreCfg.class);

	@Autowired // configurar a mano
	DataSourceCfg dataSourceCfg;
	
	/**
	 * Instancia un objeto de tipo {@link JdbcTokenStore} que almacena los token en BBDD
	 * @return una instacia de {@link JdbcTokenStore} con el data source configurado
	 */
	@Bean
	@Profile({"feature", "dev", "pre", "prod"})
	public TokenStore jdbcTokenStore(){
        logger.debug("[AUTHSERVER-CONF] Registrando la configuración de data source para token store.");
		// TODO: añadir un pool de conexiones tomcat.pool
		logger.debug("[AUTHSERVER-CONF] token store registered");
        return new JdbcTokenStore(createDataSource());
		
	}
	
	/**
	 * Instancia un objeto de tipo {@link InMemoryTokenStore} que almacena los token en memoria
	 * <i>Sólo para entornos con un nodo</i>
	 * @return una instancia de {@link InMemoryTokenStore}
	 */
	@Bean
	@Profile({"local"})
	public TokenStore inMemoryJdbcTokenStore(){
		return new JdbcTokenStore(createInMemoryDataSource());
	}
	
	/**
	 * Creación de datasource en memoria
	 * @return
	 */
	private DataSource createInMemoryDataSource(){

		logger.warn("[AUTHSERVER-CONF] Registrando data source en memoria. Sólo para el entorno de test/local!!");
	    EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript
	            ("classpath:db/schema.sql").build();
	    
	    logger.info("[AUTHSERVER-CONF] data source en memoria registrado");
	    return embeddedDatabase;
	}
	
	/**
	 * Creación de datasource
	 * @return
	 */
	private DataSource createDataSource(){

        logger.info("[AUTHSERVER-CONF] Registrando el datasource con la configuración '{}'", dataSourceCfg);

		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(dataSourceCfg.getDriver());
		dataSource.setUrl(dataSourceCfg.getUrl());
		dataSource.setUsername(dataSourceCfg.getUser());
		dataSource.setPassword(dataSourceCfg.getPassword());

		//Configuración del pool

		//Tamaño del pool inicial y mínimas conexiones abiertas desocupadas
		dataSource.setInitialSize(dataSourceCfg.getInitialSize());
		dataSource.setMinIdle(dataSourceCfg.getMinIdle());

		//Máximas conexiones abiertas desocupadas
		dataSource.setMaxActive(dataSourceCfg.getMaxActive());
		dataSource.setMaxIdle(dataSourceCfg.getMaxIdle());

		//Póliticas de testeo de conexiones desocupadas
		dataSource.setTimeBetweenEvictionRunsMillis(dataSourceCfg.getTimeBetweenEvictionRunsMillis());
		dataSource.setRemoveAbandoned(dataSourceCfg.isRemoveAbandoned());
		dataSource.setRemoveAbandonedTimeout(dataSourceCfg.getRemoveAbandonedTimeout());
		dataSource.setLogAbandoned(dataSourceCfg.isLogAbandoned());
		dataSource.setTestWhileIdle(dataSourceCfg.isTestWhileIdle());
		//dataSource.setTestOnBorrow(true);

		logger.info("[AUTHSERVER-CONF] data source registrado");
		return dataSource;
	}
	
}
