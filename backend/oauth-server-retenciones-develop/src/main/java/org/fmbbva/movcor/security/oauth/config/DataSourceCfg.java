package org.fmbbva.movcor.security.oauth.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Bean de configuración del DataSource
 *
 * @author xe62596
 */
@Configuration
@ConfigurationProperties(prefix = "oauthData.database", exceptionIfInvalid = false)
public class DataSourceCfg {

    /**
     * Driver DataSource
     */
    @NotNull
    private String driver;

    /**
     * url DataSource
     */
    @NotNull
    private String url;

    /**
     * user DataSource
     */
    @NotNull
    private String user;

    /**
     * password DataSource
     */
    @NotNull
    private String password;

    /**
     * initialSize DataSource
     * default value = 10
     */
    @NotNull
    private int initialSize = 10;

    /**
     * minIdle DataSource
     * default value = 10
     */
    @NotNull
    private int minIdle = 10;

    /**
     * maxActive DataSource
     * default value = 100
     *
     */
    @NotNull
    private int maxActive = 100;

    /**
     * maxIdle DataSource
     * default value = 50
     */
    @NotNull
    private int maxIdle = 50;

    /**
     * TimeBetweenEvictionRunsMillis DataSource
     * default value = 30000
     */
    @NotNull
    private int timeBetweenEvictionRunsMillis = 30000;

    /**
     * RemoveAbandoned DataSource
     * default value = true
     */
    @NotNull
    private boolean removeAbandoned = true;

    /**
     * RemoveAbandonedTimeout DataSource
     * default value = 60
     */
    @NotNull
    private int removeAbandonedTimeout = 60;

    /**
     * LogAbandoned DataSource
     * default value = true
     */
    @NotNull
    private boolean logAbandoned = true;

    /**
     * TestWhileIdle DataSource
     * default value = true
     */
    @NotNull
    private boolean testWhileIdle = true;

    /**
    * Returns the DataSource driver.
    * @return String Returns the DataSource driver.
    */
    public String getDriver() {
        return driver;
    }

    /**
     * Set the DataSource driver.
     * @param driver The DataSource driver value.
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Returns the url.
     * @return String Returns the url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the DataSource url.
     * @param url The DataSource url value.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the DataSource user.
     * @return String Returns the DataSource user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Set the DataSource user.
     * @param user The DataSource user value.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Returns the DataSource password.
     * @return String Returns the DataSource password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the DataSource password.
     * @param password The DataSource password value.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the property of DataSource initialSize.
     * @return int Returns the property of DataSource initialSize.
     */
    public int getInitialSize() { return initialSize; }

    /**
     * Set the property of DataSource initialSize.
     * @param initialSize The property of DataSource initialSize value.
     */
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    /**
     * Returns the property of DataSource minIdle.
     * @return int Returns the property of DataSource minIdle.
     */
    public int getMinIdle() {
        return minIdle;
    }

    /**
     * Set the property of DataSource minIdle.
     * @param minIdle The property of DataSource minIdle value.
     */
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    /**
     * Returns the property of DataSource maxActive.
     * @return int Returns the property of DataSource maxActive.
     */
    public int getMaxActive() {
        return maxActive;
    }

    /**
     * Set the property of DataSource maxActive.
     * @param maxActive The property of DataSource maxActive value.
     */
    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * Returns the property of DataSource maxIdle.
     * @return int Returns the property of DataSource maxIdle.
     */
    public int getMaxIdle() {
        return maxIdle;
    }

    /**
     * Set the property of DataSource maxIdle.
     * @param maxIdle The property of DataSource maxIdle value.
     */
    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    /**
     * Returns the property of DataSource timeBetweenEvictionRunsMillis .
     * @return int Returns the property of DataSource timeBetweenEvictionRunsMillis.
     */
    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    /**
     * Set the property of DataSource timeBetweenEvictionRunsMillis.
     * @param timeBetweenEvictionRunsMillis The property of DataSource timeBetweenEvictionRunsMillis value.
     */
    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    /**
     * Returns the property of DataSource removeAbandoned.
     * @return boolean Returns the property of DataSource removeAbandoned.
     */
    public boolean isRemoveAbandoned() {
        return removeAbandoned;
    }

    /**
     * Set the property of DataSource removeAbandoned.
     * @param removeAbandoned The property of DataSource removeAbandoned value.
     */
    public void setRemoveAbandoned(boolean removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }

    /**
     * Returns the property of DataSource removeAbandonedTimeout.
     * @return int Returns the property of DataSource removeAbandonedTimeout.
     */
    public int getRemoveAbandonedTimeout() {
        return removeAbandonedTimeout;
    }

    /**
     * Set the property of DataSource removeAbandonedTimeout.
     * @param removeAbandonedTimeout The property of DataSource removeAbandonedTimeout value.
     */
    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }

    /**
     * Returns the property of DataSource testWhileIdle.
     * @return boolean Returns the property of DataSource testWhileIdle.
     */
    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    /**
     * Set the property of DataSource testWhileIdle.
     * @param testWhileIdle The property of DataSource testWhileIdle value.
     */
    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    /**
     * Returns the property of DataSource logAbandoned.
     * @return boolean Returns the property of DataSource logAbandoned.
     */
    public boolean isLogAbandoned() {
        return logAbandoned;
    }

    /**
     * Set the property of DataSource logAbandoned.
     * @param logAbandoned The property of DataSource logAbandoned value.
     */
    public void setLogAbandoned(boolean logAbandoned) {
        this.logAbandoned = logAbandoned;
    }

	@Override
	public String toString() {
		return "DataSourceCfg [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password
				+ ", initialSize=" + initialSize + ", minIdle=" + minIdle + ", maxActive=" + maxActive + ", maxIdle="
				+ maxIdle + ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis + ", removeAbandoned="
				+ removeAbandoned + ", removeAbandonedTimeout=" + removeAbandonedTimeout + ", logAbandoned="
				+ logAbandoned + ", testWhileIdle=" + testWhileIdle + "]";
	}

    
}
