Integración de OAuth Server con aplicaciones
============================================


<!-- toc orderedList:0 depthFrom:1 depthTo:6 -->

* [Integración de OAuth Server con aplicaciones](#integración-de-oauth-server-con-aplicaciones)
  * [Introducción](#introducción)
  * [End-points](#end-points)
    * [Extensiones](#extensiones)
    * [Access Token Endpoint](#access-token-endpoint)
      * [Protección del Endpoint](#protección-del-endpoint)
      * [Request parameters](#request-parameters)
      * [Gestión de errores para el endpoint token access](#gestión-de-errores-para-el-endpoint-token-access)
    * [Validation Endpoint](#validation-endpoint)
      * [Request parameters](#request-parameters-1)
        * [Extensiones](#extensiones-1)
      * [Errores de validación soportados](#errores-de-validación-soportados)
    * [Extensiones](#extensiones-2)
      * [Logout](#logout)
        * [Request parameters](#request-parameters-2)
  * [Servidor de recursos](#servidor-de-recursos)
    * [Datos extendidos](#datos-extendidos)
      * [Configuración servidor](#configuración-servidor)
      * [Acceso a los nuevos atributos](#acceso-a-los-nuevos-atributos)

<!-- tocstop -->

## Introducción

El objetivo de este documento es servir de ayuda en la integración del servidor OAuth con otras aplicaciones.

## End-points

Exiten 3 endpoint que realizan las funciones necesarias para cubrir el protocolo OAuth de autneticación:

- **Token**:  se realiza la autorización de la aplicación (client_id + client_secret) y del usuario (persistido en LDAP). Este tipo de autorización es la soportada por el _grant_type_ **password** y devuelve los refresh_token_ y _access_token_ correspondientes.
- **Check Token**: Este endpoint es responsable de recibir los _acccess_token_ y realizar una serie de validaciones sobre ellos (formato, expiración, etc.). El servidor de recursos es el encargado de realizar las peticiones de validación sobre este endpoint.
- **Refresh token**: se realiza sobre el mismo endpoint de **Token** y gracias al _grant_type_ **refresh_token** devuelve, si cumple con los requisitos, un nuevo _access_token_ cuando este se ha caducado.

### Extensiones

Se han realizado extensiones para realizar otras operaciones que están fuera del propio protocolo:

- **Logout**: desconecta al usuario del sistema. Realiza un borrado de los token _access_token_ y _refresh_token_ del almacenamiento, invalidándolos en las siguientes peticiones.  

### Access Token Endpoint

Se utiliza la implementación que provee Spring oaut:
 `https://<server:port>/oauth/token`

En el flujo de *Resource Owner Password Grant*, el cliente llama al endpoint para obtener el access token enviando las credenciales que previamente a introducido del usuario (resource owner) en la aplicación.
En el flujo de *Refresh Token Grant*, el cliente llama al endpoint para obtener un nuevo access token renovado.

#### Protección del Endpoint

El endponit está protegido por defecto con autorización http-basic en las cabeceras, con lo que el identificador y la contraseña del cliente (clientId y clientSecret) tienen que ser incluídos en la cabecera de la solicitud HTTP para autenticar la aplicación cliente.
ej.: Authorization: Basic Y2xpZW50SWQ6Y2xpZW50U2VjcmV0

#### Request parameters

Los parámetros soportados por la petición son:
- Si el flujo es *Resource Owner Password Grant*:
  - ***grant_type*** (obligatorio): el campo se rellena con el valor ***password***.
  - ***scope*** (opcional): lista de scopes de acceso solicitados.
  - ***username*** (obligatorio): nombre del usuario (resource owner). El atributo Ldap para el cual se realiza el filtro `userSearch: (employeeNumber={0})`.
  - ***password*** (obligatorio): Contraseña del usuario (resource owner).
- Si el flujo es *Refresh token Grant*:
  - ***grant_type*** (obligatorio): el campo se rellena con el valor del  ***refresh_token***.
  - ***refresh_token*** (obligatorio): el refresh token.


La salida será en formato JSON incluyendo los siguientes campos:

- ***access_token***: access token emitido por el Authorization Server.
- ***token_type***: Tipo de token emitido. En nuestro caso será "bearer".
- ***expires_in***: tiempo de vida del acces token
- ***refresh_token*** : el token que puede ser utilizado para obtener nuevos acces token utilizando el mismo grant.
- ***scope***: los scopes soportados para el usuario en la aplicación cliente.

Ejemplo de respuesta:

```json
{
  "access_token":"9b678b10-cc8e-42ef-a479-1ceadbc2e176",
  "token_type":"bearer",
  "refresh_token": "6ddab6a6-e720-4830-bccf-aba0fffe6643",
  "expires_in":43199,
  "scope":"read write"
}
```

#### Gestión de errores para el endpoint token access 

Todas las repuestas están en formato JSON. Se devuelven con el siguiente formato:
```json
{
  "error": "Internal server error",
  "error_description": "The server encountered an internal error or misconfiguration and was unable to complete your request"
}
```

Excepciones válidas:

| ***Error*** | ***Description*** | ***HTTP Status*** | ***Cause*** |
|-------------|-------------------|-------------------|-------------|
| invalid_client         | Bad client credentials  | 401 | - The specified client does not exist in the repository<br> - Invalid client credentials                            |
| invalid_client         | Client ID mismatch  | 401               | The specified client does not match the one used to request the code                                                |
| invalid_client         | Given client ID does not match authenticated client                             | 401               | The specified client does not match that has been authenticated in the petition                                     |
| invalid_client         | Unauthorized grant type: [grantType]                                            | 401               | The client is not authorized to perform the specified type of grant                                                 |
| invalid_grant          | Invalid authorization code: [authCode]                                          | 400               | The specified code does not correspond to a previously generated code                                               |
| invalid_grant          | Implicit grant type not supported from token endpoint                           | 400               | It is specified as implicit type grant                                                                              |
| invalid_request        | An authorization code must be supplied                                          | 400               | It not specified an authorization code                                                                              |
| invalid_request        | Missing grant type                                                              | 400               | It has not specified a grant type                                                                                   |
| invalid_grant          | Redirect URI mismatch                                                           | 400               | Redirect_uri is specified parameter in the request token and its value does not match the request for authorization |
| invalid_scope          | Invalid scope: [scope]                                                          | 400               | An scope included in the request has not been registered by the client                                              |
| invalid_scope          | Empty scope (either the client or the user is not allowed the requested scopes) | 400               | No scopes specified in the request and the client does not have registered any scope                                |
| server_error           | Internal Server Error                                                           | 500               | There was an unhandled exception                                                                                    |
| unauthorized           | e.getMessage()                                                                  | 401               | There was an exception authentication                                                                               |
| unsupported_grant_type | Unsupported grant type: [grantType]                                             | 400               | Is not enabled on the server the requested grant_Type                                                               |


### Validation Endpoint

Este endpoint de validación es utilizado exclusivamente pro el servidor de recursos para validar el access token enviado por la aplicación (`https://<server:port>/oauth/check_token`).

Este endpoint está protegido por autorización http-baisc que tiene que ser enviada en una cabecera de la solicitud desde el srevidor de recursos (clientId and clientSecret).

#### Request parameters

El único parámetro obligatorio es:

- ***token*** (obligatorio): el valor del access token a validar.

Si el token es correcto, la respuesta será un JSON con los siguientes valores:

- ***aud***: el ámbito de la respuesta. El servidor de OAuth puede manejar más de uno.
- ***exp***: expiración del Token.
- ***user_name***: el usuario que ha realizado el login (resource owner). En nuestro caso es el **uuid**
- ***client_id***: identificador de la aplicación cliente.
- ***scope***: listado de scopes permitidos para el usuario.
- ***authorities***: los roles del usuario para aplicar autorización en la aplicación cliente. Se obtienen del filtro LDAP `groupSearchBase: ou=groups` y `searchFilter: (member={0})`
`
##### Extensiones

Para poder enviar más información relativa al usuario se aumentan las parámetros devueltos por el estándar dentro del atributo **user_info**.


> **Nota**: se podría contemplar otra implementación con JWT para devolver más valores de usuarios cifrados.

Example valid access token:

```json
{
  "aud": [
    "portal"
  ],
  "user_info": {
    "country": "604",
    "documentNumber": "00059842",
    "documentType": "021"
  },
  "user_name": "corresponsal1",
  "scope": [
    "read",
    "write",
    "trust"
  ],
  "exp": 1489793993,
  "authorities": [
    "ROLE_USER"
  ],
  "client_id": "demo"
}
```
En caso de error, se rebirá una respuesta con los siguientes valores:

- ***error***: código de error (ej.: invalid_token)
- ***error_description***: descripción del error (ej.: Token was not recognised)

Ejmplo de respuesta de error:

```json
{
  "error": "invalid_token",
  "error_description": "Token was not recognised"
}
```

#### Errores de validación soportados

| ***Error***   | ***Description***            | ***HTTP Status*** | ***Cause***                                                                   |
|---------------|------------------------------|-------------------|-------------------------------------------------------------------------------|
| invalid_token | Token was not recognised     | 400               | The token does not correspond with a token generated by the auth server       |
| invalid_token | Token has expired            | 400               | The token has expired                                                         |
| invalid_token | Client not valid: [clientId] | 400               | The client for which the token was generated does not exist in the repository |
| server_error  | Internal Server Error        | 500               | There was an unhandled exception                                              |



### Extensiones

#### Logout

Se realiza una petición POST al endpoint:
 `https://<server:port>/oauth/logout`

Este endpoint está protegido por autorización http-baisc que tiene que ser enviada en una cabecera de la solicitud desde el srevidor de recursos (clientId and clientSecret).

##### Request parameters

El único parámetro obligatorio es:

- ***token*** (obligatorio): el valor del refresh token a invalidar.

En caso de error, se rebirá una respuesta con los siguientes valores:

- ***error***: código de error invalid_token
- ***error_description***: descripción del error (ej.: Token was not recognised)


Ejemplo de respuesta error:
```json
{
  "error": "invalid_token",
  "error_description": "Invalid refresh token: 02be6b46-4533-4a5e-81a9-d7ebdc724043"
}
```

## Servidor de recursos

Se utiliza la implementación de Spring Security para configurar un servidor de recursos.
Para ello tenemos que añadir un bean de configuración con la anotación **@EnableResourceServer** y que extienda de **ResourceServerConfigurerAdapter**.

 Por ejemplo
 ```java
 @Configuration
 @ConditionalOnProperty(prefix = "security.basic", name = "enabled", havingValue = "true", matchIfMissing = true)
 @EnableResourceServer
 @EnableGlobalMethodSecurity(securedEnabled = true)
 public class ResourceServerCfg extends ResourceServerConfigurerAdapter {

   // Implementación de los endpoints de seguridad
   public void configure(HttpSecurity http) throws Exception {
     logger.info("Entrando en ResourceServerConfigurerAdapter.configure");

     http
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .authorizeRequests()
             .antMatchers(HttpMethod.GET, "/api/**").access("#oauth2.hasScope('read')")
             .antMatchers(HttpMethod.POST, "/api/**").access("#oauth2.hasScope('write')");

     logger.info("Fin ResourceServerConfigurerAdapter.configure");
   }

 }
```

Gracias a esto, todos los métodos/endpoints protegidos seguirán el flujo OAuth definido en por el tipo de _grant_ configurado en el fichero `application.yml` de la aplicación.


```yml
security:
    oauth2:
      resource:
        user-info-uri:  "${auth-server:http://localhost:9999/uaa}/oauth/check_token"
      client:
        client-id: demo
        client-secret: secret_demo
        resource-ids: portal
```

> **Nota**: la varibale **auth-server** se pasará como parámetro en el arranque del servicio y será diferente por entorno.

### Datos extendidos

#### Configuración servidor

Para poder mostrar los datos extendidos que se utilizan para mostrar información de usuario dentro del atributo **user_info** se tiene que importar la librería de arquitectura en el pom.xml

```xml
<!-- Componente Arquitectura -->
<dependency>
  <groupId>org.fmbbva.movcli.arq</groupId>
  <artifactId>arq</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

El siguiente paso es añadir en la clase de configuración que extiende **ResourceServerConfigurerAdapter** lo siguiente:

1. Dependencias
```java
import org.fmbbva.movcli.arq.web.security.CustomerAuthenticationConverter;
```

2. Inyectar la clase **RemoteTokenServices** de spring security oauth

```java
@Autowired 	
RemoteTokenServices remoteTokenServices;
```

3. Configurar la clase **UserAuthenticationConverter** con el conversor proporcionado por la librería de arquitectura y utilizar este para configurar por defecto el conversor de acces token **AccessTokenConverter**:

```java
  @Bean 	
  public UserAuthenticationConverter userAuthenticationConverter() { 		
    return new CustomerAuthenticationConverter(); 	
  } 	

  @Bean 	
  public AccessTokenConverter accessTokenConverter() { 		
    DefaultAccessTokenConverter datc = new DefaultAccessTokenConverter();
    datc.setUserTokenConverter(userAuthenticationConverter()); 		
    return datc; 	
  }
```

4. Sobreescribir la configuración de servidor de recursos con el nuevo conversor:

```java
	@Override 	
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
    resources.resourceId("portal");
  }
```

> **Nota**: se tiene que añadir el resourceId que corresponda con la configuración que espera el servidor OAuth

#### Acceso a los nuevos atributos

Para obtener desde la aplicación los nuevos datos de usuario.

 1. Añadimos las dependencias

 ```java
 import org.fmbbva.movcli.arq.web.security.SecurityUtils;
 import org.fmbbva.movcli.arq.web.security.CustomerDetails;
 ```

 2. Obtenemos el **UserDetails** personalizado gracias a la clase **SecurityUtils**

 ```java
    CustomerDetails auth = SecurityUtils.getCurrentCustomer();

    logger.debug("UUID: '{}'", auth.getUuid());
    logger.debug("Country: '{}'", auth.getCountry());
    logger.debug("DocumentNumber: '{}'", auth.getDocumentNumber());
    logger.debug("DocumentType: '{}'", auth.getDocumentType());
 ```
