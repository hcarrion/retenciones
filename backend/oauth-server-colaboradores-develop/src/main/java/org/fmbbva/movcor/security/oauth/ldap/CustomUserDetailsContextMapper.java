package org.fmbbva.movcor.security.oauth.ldap;

import java.util.Collection;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.util.Assert;

public class CustomUserDetailsContextMapper implements UserDetailsContextMapper {

	public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
			Collection<? extends GrantedAuthority> authorities) {
		CustomerDetails.Essence p = new CustomerDetails.Essence(ctx);	

		p.setUsername(username);
		p.setAuthorities(authorities);

		return p.createUserDetails();

	}

	public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
		Assert.isInstanceOf(CustomerDetails.class, user,
				"UserDetails must be an CustomerDetails instance");

		CustomerDetails p = (CustomerDetails) user;
		p.populateContext(ctx);
	}
}
