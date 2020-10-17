package com.spring.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
@Component
public class CommonBean {
	private String username;
	private String password;
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
	
	public static void main(String[] args) {
		System.out.println("hhhhhhhhhhh");
	}
}
