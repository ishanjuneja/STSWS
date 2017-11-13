package com.yash.main;

import java.util.Scanner;

import com.yash.model.Car;
import com.yash.model.ParkingToken;
import com.yash.service.ParkingService;

public class CarStartupApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ParkingService service = new ParkingService();
		String cont;
		int choice;
		do {
			System.out.println("-----main menu-----");
			System.out.println("1.) Add Car");
			System.out.println("2.) Remove Car");
			System.out.println("3.) Show Lists");
			System.out.println("0.) exit");
			System.out.println("enter your choice");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				
				System.out.println("enter car name :");
				sc.nextLine();
				String CName=sc.nextLine();
	
				System.out.println("enter owner name :");
				
				String OName=sc.nextLine();
				
				System.out.println("enter registeration number :");
				int carRegNo=sc.nextInt();
				service.park(CName, OName, carRegNo);
				break;
			case 2:
				System.out.println("enter token of the car to be removed : ");
				ParkingToken token = new ParkingToken();
				int inputtoken=sc.nextInt();
				token.setToken(inputtoken);
				service.remove(token);
				break;
			case 3:
				service.showParking();
				break;
			case 0:
				System.exit(0);
			default:
				break;
			}
			System.out.println("enter yes to continue");
			cont=sc.nextLine();
		} while (true);
		
	}

}
