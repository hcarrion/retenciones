Feature: debería poder hacer login con las credenciales de cliente 
Scenario: el cliente hace una llamada a POST /uaa/oauth/token
	Given username 'corresponsal1' y su password 'pass' 
	And  clientId 'demo' y clientSecret 'secret_demo' 
	When el cliente hace una solicitud a /uaa/oauth/token 
	Then el cliente debería recibir como respuesta de autenticación un status code de 200
	And el cliente recibirá su token de autorización