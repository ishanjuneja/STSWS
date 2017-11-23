package com.yash.main;

import com.yash.model.Collecting;
import com.yash.model.Person;
import com.yash.model.SeatReservation;

public class StartUpApplication {

	public static void main(String[] args) {
		SeatReservation seatReservation = new SeatReservation();
		Person thread1 = new Person(seatReservation);
		Collecting thread2 = new Collecting(seatReservation);
		thread1.start();	
		System.out.println("ishan thread ended");
		thread2.start();	
	}
}
