package com.itwill.shoes.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource {
	private String driverClass;
	private String url;
	private String user;
	private String password;
	
	public DataSource() throws Exception{
		Properties properties=new Properties();
		
		InputStream propertiesInput = DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(propertiesInput);
		this.driverClass = properties.getProperty("driverClass");
		this.url = properties.getProperty("url");
		this.user = properties.getProperty("user");
		this.password = properties.getProperty("password");
	}
	
	public Connection getConnection() throws Exception{
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
		
	}
	
	public void close(Connection con) throws Exception{
		con.close();
	}

}
