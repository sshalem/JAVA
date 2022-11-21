package com.json;

import java.util.Arrays;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private String[] languages;

	public Student() {
		super();
	}

	public Student(int id, String firstName, String lastName, boolean active, Address address, String[] languages) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.address = address;
		this.languages = languages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", \n	firstName=" + firstName + ", \n	lastName=" + lastName + ", \n	active="
				+ active + ", \n	address=" + address + ", \n	languages=" + Arrays.toString(languages) + "]";
	}

}
