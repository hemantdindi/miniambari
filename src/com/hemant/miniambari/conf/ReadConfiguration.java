package com.hemant.miniambari.conf;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {

	String ambariHost;
	String ambariPort;
	String ambariAdminUsr;
	String ambariAdminPwd;
	String ambariClusterName;

	String log4j;

	String dbhost;
	String dbport;
	String dbdriverclass;
	String dbname;
	String dbuser;
	String dbpassword;
	
	String smtphost;
	String smtpport;
	String smtpsender;

	public String getSmtphost() {
		return smtphost;
	}

	public void setSmtphost(String smtphost) {
		this.smtphost = smtphost;
	}

	public String getSmtpport() {
		return smtpport;
	}

	public void setSmtpport(String smtpport) {
		this.smtpport = smtpport;
	}

	public String getSmtpsender() {
		return smtpsender;
	}

	public void setSmtpsender(String smtpsender) {
		this.smtpsender = smtpsender;
	}

	
	public String getAmbariHost() {
		return ambariHost;
	}

	public void setAmbariHost(String ambariHost) {
		this.ambariHost = ambariHost;
	}

	public String getAmbariPort() {
		return ambariPort;
	}

	public void setAmbariPort(String ambariPort) {
		this.ambariPort = ambariPort;
	}

	public String getAmbariAdminUsr() {
		return ambariAdminUsr;
	}

	public void setAmbariAdminUsr(String ambariAdminUsr) {
		this.ambariAdminUsr = ambariAdminUsr;
	}

	public String getAmbariAdminPwd() {
		return ambariAdminPwd;
	}

	public void setAmbariAdminPwd(String ambariAdminPwd) {
		this.ambariAdminPwd = ambariAdminPwd;
	}

	public String getAmbariClusterName() {
		return ambariClusterName;
	}

	public void setAmbariClusterName(String ambariClusterName) {
		this.ambariClusterName = ambariClusterName;
	}

	public String getLog4j() {
		return log4j;
	}

	public void setLog4j(String log4j) {
		this.log4j = log4j;
	}

	public String getDbhost() {
		return dbhost;
	}

	public void setDbhost(String dbhost) {
		this.dbhost = dbhost;
	}

	public String getDbport() {
		return dbport;
	}

	public void setDbport(String dbport) {
		this.dbport = dbport;
	}

	public String getDbdriverclass() {
		return dbdriverclass;
	}

	public void setDbdriverclass(String dbdriverclass) {
		this.dbdriverclass = dbdriverclass;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbuser() {
		return dbuser;
	}

	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}

	public String getDbpassword() {
		return dbpassword;
	}

	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

	

	public ReadConfiguration() {
		Properties prop = new Properties();
		try {
			//prop.load(new FileInputStream("C:\\Users\\hedindi\\git\\acinonyx\\conf\\config.ini"));
			prop.load(new FileInputStream("C:\\Users\\hedindi\\config.ini"));
			//prop.load(new FileInputStream("/iamhere/src/main/java/com/hemant/iamhere/conf/config.ini"));
			this.setAmbariHost(prop.getProperty("ambari.host").trim());
			this.setAmbariPort(prop.getProperty("ambari.port").trim());
			this.setAmbariAdminUsr(prop.getProperty("ambari.admin.usr").trim());
			this.setAmbariAdminPwd(prop.getProperty("ambari.admin.pwd").trim());
			this.setAmbariClusterName(prop.getProperty("ambari.cluster.name").trim());

			this.setLog4j(prop.getProperty("log4j.config").trim());

			this.setDbdriverclass(prop.getProperty("db.driverclass").trim());
			this.setDbhost(prop.getProperty("db.host").trim());
			this.setDbname(prop.getProperty("db.name").trim());
			this.setDbpassword(prop.getProperty("db.password").trim());
			this.setDbport(prop.getProperty("db.port").trim());
			this.setDbuser(prop.getProperty("db.user").trim());
			
			this.setSmtphost(prop.getProperty("smtp.host").trim());
			this.setSmtpport(prop.getProperty("smtp.port").trim());
			this.setSmtpsender(prop.getProperty("smtp.sender").trim());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
