package com.sub.test;

public class Person {

	 int eyes=2;
	 int ears=2;
	 int mouth=1;
	 int nose=1;
	 int hands=2;
	 int legs=2;
	
	 public String name;
	 public String job;
	 public String address;
	 public String bikeName;
	 public String carName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	void display() {
		System.out.println(getName());
		System.out.println(getJob());
		System.out.println(getAddress());
	}
}
