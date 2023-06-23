package com.webapp.sambram.Dto;

public class LoginDto {
	private String UserMail;
	private String Password;
	public String getUserMail() {
		return UserMail;
	}
	public void setUserMail(String userMail) {
		UserMail = userMail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString()
	{
		StringBuffer buff = new StringBuffer();
		buff.append("{").append("\n");
		buff.append("Email:").append(UserMail).append("\n");
		buff.append("Password:").append(Password).append("\n");
		buff.append("}");
		return buff.toString();
	}
}
