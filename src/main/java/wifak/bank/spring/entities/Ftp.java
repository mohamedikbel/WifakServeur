package wifak.bank.spring.entities;

import java.io.Serializable;

public class Ftp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ServerName;
	private String UserName;
	private String Passwrd;
	private int port;

	public String getServerName() {
		return ServerName;
	}

	public Ftp(String serverName, String userName, String passwrd, int port) {
		super();
		ServerName = serverName;
		UserName = userName;
		Passwrd = passwrd;
		this.port = port;
	}

	public Ftp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ftp [ServerName=" + ServerName + ", UserName=" + UserName + ", Passwrd=" + Passwrd + ", port=" + port
				+ "]";
	}

	public void setServerName(String serverName) {
		ServerName = serverName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPasswrd() {
		return Passwrd;
	}

	public void setPasswrd(String passwrd) {
		Passwrd = passwrd;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
