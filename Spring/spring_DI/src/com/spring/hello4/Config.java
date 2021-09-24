package com.spring.hello4;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class Config {
	//변수
	String driver;
	String url;
	String user;
	String pwd;
	
	//getter,setter
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//메서드 
	//Object.toString()
	public String toString(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("driver:"+driver+"\n");
		sb.append("url:"+url+"\n");
		sb.append("user:"+user+"\n");
		sb.append("pwd:"+pwd+"\n");
		
		return sb.toString();//String으로 변환하여 리턴 해 준다
	}
}//class-end
