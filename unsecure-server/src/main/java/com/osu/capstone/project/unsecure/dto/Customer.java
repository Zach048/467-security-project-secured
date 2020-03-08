/**
 * 
 */
package com.osu.capstone.project.unsecure.dto;


/**
 * The purpose of this class is to decouple the underlying database structure from the 
 * data available to the end user.
 * @author Zach Earl
 */
public class Customer {
	
	private Integer customerId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String new_password;
	
	
	public Customer(Integer customerId, String userName, String password, String firstName, String lastName, String email,
			String phone) {
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getNewPassword() {
		return new_password;
	}

	public void setNewPassword(String new_password) {
		this.new_password = new_password;
	}
}
