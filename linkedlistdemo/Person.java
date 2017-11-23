package com.yash.model;

public class Person {
private String name;
private int aadhar;
private Ticket ticket;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAadhar() {
	return aadhar;
}
public void setAadhar(int aadhar) {
	this.aadhar = aadhar;
}
public Ticket getTicket() {
	return ticket;
}
public void setTicket(Ticket ticket) {
	this.ticket = ticket;
}

	@Override
		public String toString() {
			return "name : "+this.getName()+" ticket number : "+this.getTicket().getTicketId();
		}
	
}
