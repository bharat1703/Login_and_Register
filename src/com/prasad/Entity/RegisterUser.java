package com.prasad.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTER_USER33")
public class RegisterUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private int age;

	@Column
	private String email;

	@Column
	private String passowrd;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterUser(int id, String firstName, String lastName, int age, String userName, String passowrd) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.passowrd = passowrd;
	}

	@Override
	public String toString() {
		return "RegisterUser [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", email=" + email + ", passowrd=" + passowrd + "]";
	}

}
