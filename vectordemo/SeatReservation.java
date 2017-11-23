package com.yash.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SeatReservation 
{
	ArrayList<Integer> demo = new ArrayList<Integer>();
	
	public SeatReservation(){
		for(int i=0;i<10;i++){
			demo.add(i);
		}
	}
	
	public void searchNumber(int input){
		for (int i=0;i<demo.size();i++) {
			if(demo.get(i)==input){
				System.out.println(demo.get(i));
			}
		}
		
	}
	
	public void deleteNumber(int input){
		for(int i=0;i<demo.size();i++){
			if(demo.get(i)==input){
				demo.remove(demo.indexOf(demo.get(i)));
			}
		}
		
	}
	
	
	
}
