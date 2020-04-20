package org.fmbbva.movcor.security.oauth.ldap;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.ldap.userdetails.InetOrgPerson;

public class CustomerDetails extends InetOrgPerson {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	protected void populateContext(DirContextAdapter adapter) {
		super.populateContext(adapter);

	}

}

