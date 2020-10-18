package com.sub.test;

public class Employee extends Person {

	Address addr;
	void address() {
		System.out.println(name+ " Address "+addr);
	}
	void goingToGym(Bike bike) {
		bike.start();
		System.out.println(name+" is going to gym by => "+bikeName);
		bike.stop();
		System.out.println(name+" is reaced to Gym");
	}
	
	void goingToOffice(Car car) {
		car.start();
		System.out.println(name+ " is going to Office by => "+carName);
		car.stop();
		System.out.println(name+" is reached to Office");
	}
	
}
