package org.fmbbva.movcor.security.oauth.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ldap")
public class LDAPCfg {
    
    /**
     * URL LDAP.
     */
    @NotNull
    private String url;

    /** User DN **/
    @NotNull
    private String rootDn;

    /** contraseña de conexión con ldap **/
    private String password;

    /** base **/

    private String base;

    /** base para búsquedas, por defecto {@code ou=people} **/
    private String searchBase = "ou=people"; 
    
    /** filtro para las búsquedas, por defecto {@code (uid={0})} **/
    private String searchFilter = "(uid={0})";
    
    /** **/
    private String userSearch = "";
    
    /** **/
    private String groupSearchBase = "";
    
    /** **/
    private String managerDn = "";
    
    /** **/
    private String managerPwd = "";
    
    /** **/
    private String domain = "";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRootDn() {
		return rootDn;
	}

	public void setRootDn(String rootDn) {
		this.rootDn = rootDn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getSearchBase() {
		return searchBase;
	}

	public void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public String getUserSearch() {
		return userSearch;
	}

	public void setUserSearch(String userSearch) {
		this.userSearch = userSearch;
	}

	public String getGroupSearchBase() {
		return groupSearchBase;
	}

	public void setGroupSearchBase(String groupSearchBase) {
		this.groupSearchBase = groupSearchBase;
	}

	public String getManagerDn() {
		return managerDn;
	}

	public void setManagerDn(String managerDn) {
		this.managerDn = managerDn;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public final String getDomain() {
		return domain;
	}

	public final void setDomain(String domain) {
		this.domain = domain;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LDAPCfg [url=");
		builder.append(url);
		builder.append(", rootDn=");
		builder.append(rootDn);
		builder.append(", password=");
		builder.append(password);
		builder.append(", base=");
		builder.append(base);
		builder.append(", searchBase=");
		builder.append(searchBase);
		builder.append(", searchFilter=");
		builder.append(searchFilter);
		builder.append(", userSearch=");
		builder.append(userSearch);
		builder.append(", groupSearchBase=");
		builder.append(groupSearchBase);
		builder.append(", managerDn=");
		builder.append(managerDn);
		builder.append(", managerPwd=");
		builder.append(managerPwd);
		builder.append(", domain=");
		builder.append(domain);
		builder.append("]");
		return builder.toString();
	}

}
