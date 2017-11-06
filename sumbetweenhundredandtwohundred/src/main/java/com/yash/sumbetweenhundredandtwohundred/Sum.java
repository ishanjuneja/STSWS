package com.yash.sumbetweenhundredandtwohundred;

public class Sum {

	public int evaluate(int x, int y) {
		if(x<100||y<100||x>200||y>200||y<x){
			return 0;
			
		}
		System.out.println(x);
		int sum =0;
		for(int i=x;i<=y;i++){
			if(i%7==0){
				sum+=i;
			}
			
		}
		
		System.out.println(sum);
		return sum;
	}

}
