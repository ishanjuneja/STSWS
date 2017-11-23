package com.yash.model;

import java.util.ArrayList;
import java.util.List;

public class Person extends Thread {

	List<Integer> temp = new ArrayList<>();
	
	
	SeatReservation reservation;
	
	public Person(SeatReservation reserve) {
		this.reservation = reserve;
		for(int i=0;i<10;i++){
			temp.add(i);
		}
	}
	
	@Override
	public void run() {
		reservation.searchNumber(5);
		System.out.println("person"+reservation.demo);
		
	}
	
}
