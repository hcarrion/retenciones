package org.mfbbva.movcor.security.oauth.token;

import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

public class CustomerAccessTokenConverter extends DefaultAccessTokenConverter {

	private UserAuthenticationConverter userTokenConverter = new CustomerAuthenticationConverter();
	
	public CustomerAccessTokenConverter() {
		super();
		super.setUserTokenConverter(userTokenConverter);
	}
}
