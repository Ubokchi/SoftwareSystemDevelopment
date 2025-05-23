package com.example.member.model;

public class MemberInfo {

	private String id;
	private String name;
	private Address address;	
	private String email;
	private String password;
	private boolean allowNoti;

	public MemberInfo() {
	}

	public MemberInfo(String id, String name, String email, String password, boolean alloNoti, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.allowNoti = alloNoti;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public Address getAddress() {
		return address;
	}

	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
