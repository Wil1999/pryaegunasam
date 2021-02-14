package com.flores.integracion.parametros;

public class Conexion {

	private String driverclassname;
	private String url;
	private String username;
	private String password;
	
	public Conexion() {
		// TODO Auto-generated constructor stub
	}

	public Conexion(String driverclassname, String url, String username, String password) {
		super();
		this.driverclassname = driverclassname;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getDriverclassname() {
		return driverclassname;
	}

	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
