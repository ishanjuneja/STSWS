package com.yash.service;
import com.yash.model.Car;
import com.yash.model.ParkingToken;

public class ParkingService {
	int placeAvailable;
Car[] parkingSpace=new Car[15];
boolean[] tokens = new boolean[15];
public void ParkingService(){
	for(int i=0;i<15;i++){
	tokens[i]=true;	
	}
}	

public void park(String Cname, String Oname, int RegNo){
	placeAvailable=searchSpace(parkingSpace);
	if(placeAvailable!=16){
		ParkingToken token = new ParkingToken();
		Car car = new Car();
		car.setCarName(Cname);
		car.setOwnerName(Oname);
		car.setRegNo(RegNo);
		token.setOwnerName(car.getOwnerName());
		token.setToken(placeAvailable+101);
		car.setToken(token);
		parkingSpace[placeAvailable]=car;
	}else System.out.println("parking space is full");
}
public void remove(ParkingToken token){
	for (int i=0;i<15;i++) {
		if(parkingSpace[i].getToken().getToken()==token.getToken()){
			System.out.println("car removed with token number "+parkingSpace[i].getToken().getToken()+" owner was "+parkingSpace[i].getOwnerName());
			parkingSpace[i]=null;
			return;
		}else System.out.println("token not found");
	}
}

public void showParking(){
			for (int i=0;i<15;i++) {
				if(parkingSpace[i]!=null){
				System.out.println(parkingSpace[i].getToken().getToken()+"--"+parkingSpace[i].getCarName());
					}
				}
			}

public int searchSpace(Car[] parking){
	for(int i=0;i<15;i++){
		if(parking[i]==null){
			return i;		
		}
	}
	return 16;
}
}
