package com.gk;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class EmailConfiguration {

	private String queueName;

	private String encryptedPassword;

	private String host;

	private Integer port;

	private String mailConfigUser;

	private String authName;

	private String authValue;

	private String protocol;

	private String protocolName;

	private String isDebug;

	private String socketClassName;

	private String socketClass;

	private String protocolDebug;

	private String starttlsName;

	private String starttlsVlaue;

	private Map<String, Object> mailProperties;

	public Map<String, Object> getMailProperties() {
		return mailProperties;
	}

	public void setMailProperties(Map<String, Object> mailProperties) {
		this.mailProperties = mailProperties;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getMailConfigUser() {
		return mailConfigUser;
	}

	public void setMailConfigUser(String mailConfigUser) {
		this.mailConfigUser = mailConfigUser;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthValue() {
		return authValue;
	}

	public void setAuthValue(String authValue) {
		this.authValue = authValue;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getIsDebug() {
		return isDebug;
	}

	public void setIsDebug(String isDebug) {
		this.isDebug = isDebug;
	}

	public String getSocketClassName() {
		return socketClassName;
	}

	public void setSocketClassName(String socketClassName) {
		this.socketClassName = socketClassName;
	}

	public String getSocketClass() {
		return socketClass;
	}

	public void setSocketClass(String socketClass) {
		this.socketClass = socketClass;
	}

	public String getProtocolDebug() {
		return protocolDebug;
	}

	public void setProtocolDebug(String protocolDebug) {
		this.protocolDebug = protocolDebug;
    }
}
