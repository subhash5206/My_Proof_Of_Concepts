package com.sub.test;

public class Student extends Person {

	
	Address addr;
	void address() {
		System.out.println(name+" Address "+addr);
	}
	void goingToCollege(Bike bike) {
		bike.start();
		System.out.println(name+ " is going to college by => "+bikeName);
		bike.stop();
		System.out.println(name+ "is reached to College");
	}
	
	void goingToGym(Car car) {
		car.start();
		System.out.println(name+ " is going to gym by => "+this.carName);
		car.stop();
	}
	
	
}
