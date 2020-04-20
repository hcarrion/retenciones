package org.fmbbva.movcor.security.oauth.cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.CucumberException;

@CucumberStepsDefinition
public class LoginSteps {
	
	@Autowired
	protected TestRestTemplate restTemplate;
	
	private static final String APP_HOST = "http://localhost";
	private static final String APP_PORT = "9999";
	private static final String ENDPOINT = new StringBuilder().append(APP_HOST).append(":").append(APP_PORT)
			.append("/uaa/oauth/token").toString();
	
	// OUT parameters
	private int statusCodeValueOk;
	private LoginResponse loginResponse;
	
	// IN parameters 
	private String username;
	private String password;
	private String clientId;
	private String clientSecret;
	private static final String grantType = "password";
	
	@Given("^username '(.*?)' y su password '(.*?)'$")
	public void username_user_y_su_password_pass(String user, String password) throws Throwable {
		this.username = user;
		this.password = password;
	}
	

	@Given("^clientId '(.*?)' y clientSecret '(.*?)'$")
	public void clientid_demo_y_clientSecret_secret_demo(String clientId, String clientSecret) throws Throwable {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	@When("^el cliente hace una solicitud a /uaa/oauth/token$")
	public void el_cliente_hace_una_solicitud_a_uaa_oauth_token() throws Throwable {

		final ResponseEntity<LoginResponse> responseEntity = tryToPostLogin();
		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			throw new CucumberException("Error llamando a /posicionGlobal");
		}

		loginResponse = responseEntity.getBody();
		statusCodeValueOk = responseEntity.getStatusCodeValue();

	}

	@Then("^el cliente debería recibir como respuesta de autenticación un status code de (\\d+)$")
	public void el_cliente_debería_recibir_como_respuesta_de_autenticación_un_status_code_de(int statusCode) throws Throwable {
		assertThat(statusCode).isEqualTo(statusCodeValueOk);
	}
	

	@Then("^el cliente recibirá su token de autorización$")
	public void el_cliente_recibirá_su_token_de_autorización() throws Throwable {
		assertThat(loginResponse).isNotNull();
	}
	
	/**
	 * Método encargado de realizar la de login
	 * 
	 * @return El objeto login
	 */
	private ResponseEntity<LoginResponse> tryToPostLogin() {
		LoginBody usuarioBody = new LoginBody().username(username).password(password).grantType(grantType);
		HttpEntity<LoginBody> entity = new HttpEntity<>(usuarioBody);
		
		return restTemplate.exchange(ENDPOINT, HttpMethod.POST, entity, new ParameterizedTypeReference<LoginResponse>() {
		});
	}

}
