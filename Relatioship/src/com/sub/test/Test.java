package com.sub.test;

public class Test {

	public static void main(String[] args) {

		Student s1=new Student();
		s1.setName("SUBHASH GOSWAMI");
		s1.setJob("Java Developer");
		s1.setAddress("Hyderabad");
		s1.setBikeName("pulsar");
		s1.setCarName("HUNDAI");
		s1.display();
		s1.goingToCollege(new Bike());
		s1.goingToGym(new Car());
		
		System.out.println("=========================================================");
		
		Employee e1=new Employee();
		e1.setName("VIKAS NAYAK");
		e1.setJob("FULL STACK DEVELOPER");
		e1.setAddress("Banglore");
		e1.setBikeName("Apache");
		e1.setCarName("Scorpio");
		e1.display();
		e1.goingToGym(new Bike());
		e1.goingToOffice(new Car());
		
		
	}

}
