package com.yash.sumofdigits;


public class SumOfDigits {

	public int calculate(String string) {
		
		if(string.equals("")){
		return 0;
		}
		string=string.replaceAll("[^0-9 || \\+]", "");
		string=string.replaceAll("\\++", "\\+");
		System.out.println(string);
		String[] arrayofStr = string.split("\\+");
		int sum=0;
		int iterator=0;
		while(iterator<arrayofStr.length){
			sum+=Integer.parseInt(arrayofStr[iterator]);
			iterator++;
		}
		System.out.println(sum);
		return sum;
	}
	
	

}
