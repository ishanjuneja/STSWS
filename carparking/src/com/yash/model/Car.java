package com.yash.model;

public class Car {
String ownerName;
String carName;
int regNo;
ParkingToken token;

public void Car(String cname){
	this.carName=cname;
	
}
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
public String getCarName() {
	return carName;
}
public void setCarName(String carName) {
	this.carName = carName;
}
public int getRegNo() {
	return regNo;
}
public void setRegNo(int regNo) {
	this.regNo = regNo;
}
public ParkingToken getToken() {
	return token;
}
public void setToken(ParkingToken token) {
	this.token = token;
}

}
