package com.sub.test;

public class Student extends Person {

	
	Address addr;
	void address() {
		System.out.println(name+" Address "+addr);
	}
	void goingToCollege(Bike bike) {
		System.out.println(name+ " is going to college by => "+bikeName);
	}
	
	void goingToGym(Car car) {
		System.out.println(name+ " is going to gym by => "+this.carName);
	}
	
	
}
