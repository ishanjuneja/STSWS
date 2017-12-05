package com.yash.main;

import com.yash.model.Collecting;
import com.yash.model.Person;
import com.yash.service.SeatReservation;

public class StartUpApplication {

	public static void main(String[] args) throws InterruptedException {
		SeatReservation seatReservation = new SeatReservation();
		Collecting thread1 = new Collecting(seatReservation);
		thread1.setName("ishan");
		Person thread2 = new Person(seatReservation);
		thread2.setName("aakash");
		thread1.start();
		System.out.println("ishan thread ended");
		
		thread2.start();
		
	
	}
}
