package com.apn.bo;

public class UserBO {
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String mobile;
	private String email;
	private String accountNo;
	private String userId;
	private String passowrd;
	private float balance;
	private String status;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public UserBO(String firstName, String lastName, String gender, String address, String mobile, String email,
			String accountNo, String userId, String passowrd, float balance, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.accountNo = accountNo;
		this.userId = userId;
		this.passowrd = passowrd;
		this.balance = balance;
		this.status = status;
	}
	public UserBO() {
		// TODO Auto-generated constructor stub
	}	
}
