/**
 * 
 */
package com.osu.capstone.project.unsecure.record;

import javax.persistence.*;
/**
 * @author Zach Earl
 *
 * Represents a single customer record in the MySQL relational database.
 * Interaction with the underlying database (saving, loading) can be achieved 
 * through the {@link CustomerDAO} class.
 * RESTful API endpoints for this object are available through the
 * {@link CustomerController} class.
 */
@Entity
@Table(name = "customer")
public class CustomerRecord {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer customerId;
	@Column(name = "username", unique = true)
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "phone")
	private String phone;
	@Transient
	private String new_password;
	
	public CustomerRecord() {}

	public CustomerRecord(String userName, String password, String firstName, String lastName,
			String email, String phone) {
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
