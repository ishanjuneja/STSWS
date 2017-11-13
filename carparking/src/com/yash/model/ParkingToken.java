package com.yash.model;

public class ParkingToken {
String ownerName;
int token;

public void ParkingToken(String Oname,int tokenNo){
	this.ownerName=Oname;
	this.token=tokenNo;
}

public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
public int getToken() {
	return token;
}
public void setToken(int token) {
	this.token = token;
}


}
