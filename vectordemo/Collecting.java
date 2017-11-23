package com.yash.model;

import java.util.ArrayList;
import java.util.List;

public class Collecting extends Thread {

	SeatReservation reservation;
	List<Integer> temp = new ArrayList<>();
	public Collecting(SeatReservation reserve) {
		this.reservation=reserve;
		for(int i=0;i<10;i++){
			temp.add(i);
		}
	}
	
	
	@Override
public void run() {
	reservation.deleteNumber(2);
	System.out.println("collecting thread"+reservation.demo);
}
	
}
