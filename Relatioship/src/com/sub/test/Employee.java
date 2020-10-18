package com.sub.test;

public class Employee extends Person {

	Address addr;
	void address() {
		System.out.println(name+ " Address "+addr);
	}
	
	void goingToOffice(Car car) {
		System.out.println(name+ " is going to Office by => "+carName);
	}
	
	void goingToGym(Bike bike) {
		System.out.println(name+" is going to gym by => "+bikeName);
	}
}
