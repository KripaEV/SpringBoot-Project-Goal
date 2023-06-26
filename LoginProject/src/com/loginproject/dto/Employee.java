package com.loginproject.dto;


public class Employee {
	private String name;
	private String pswd;
	private int role;
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public String getPswd() {
		return pswd;
	}
	public String setPswd(String pswd) {
		return this.pswd = pswd;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", pswd=" + pswd + ", role=" + role + "]";
	}
	
}
