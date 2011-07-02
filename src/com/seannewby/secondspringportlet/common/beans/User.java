package com.seannewby.secondspringportlet.common.beans;


public class User {
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String birthdate;
	private String email;
	private Address address = new Address();
	private String phone;
	private String fax;
	private String creditCardNum;
	private String creditCardExp;
	private Integer creditCardSecurityNum;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getCreditCardExp() {
		return creditCardExp;
	}
	public void setCreditCardExp(String creditCardExp) {
		this.creditCardExp = creditCardExp;
	}
	public String getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	public Integer getCreditCardSecurityNum() {
		return creditCardSecurityNum;
	}
	public void setCreditCardSecurityNum(Integer creditCardSecurityNum) {
		this.creditCardSecurityNum = creditCardSecurityNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
