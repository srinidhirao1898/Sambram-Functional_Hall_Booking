package com.webapp.sambram.Dto;

public class SignUpDto {
	private String UserMail;
	private String Password;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String Phone1;
	public SignUpDto()
	{
		super();
	}
	public SignUpDto(String UserMail, String Password, String FirstName, String MiddleName, String LastName,
			String Phone1) {
		super();
		this.UserMail = UserMail;
		this.Password = Password;
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.Phone1 = Phone1;
	}
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
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhone1() {
		return Phone1;
	}
	public void setPhone1(String phone1) {
		Phone1 = phone1;
	}
	
	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		str.append("{").append("\n");
		str.append("\"UserMail:\"").append("\"").append(UserMail).append("\",");
		str.append("\"Password:\"").append("\"").append(Password).append("\",");
		str.append("\"FirstName:\"").append("\"").append(FirstName).append("\",");
		str.append("\"MiddleName:\"").append("\"").append(MiddleName).append("\",");
		str.append("\"LastName:\"").append("\"").append(LastName).append("\",");
		str.append("\"Phone1:\"").append("\"").append(Phone1).append("\",");
		str.append("}");
		
		return str.toString();
	}
}
