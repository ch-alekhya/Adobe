package com.adobe.service;

import org.springframework.stereotype.Component;

@Component
public class IntegerToRoman {
	
	
	static String m[] = {"","M","MM","MMM"};
	static String c[]= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	static String x[]= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	static String i[]= {"","I","II","III","IV","V","VI","VII","VIII","IX"};

	public String intToRoman(int integer)
	{
		
		String thousands = m[integer/1000];
		String hundereds = c[(integer%1000)/100];
		String tens = x[(integer%100)/10];
		String ones = i[(integer%10)];
		
		String result = thousands+hundereds+tens+ones;
		
		return result;
		
	}

	
	/*public static void main(String[] args)
	{
		IntegerToRoman obj = new IntegerToRoman();
		System.out.println(obj.intToRoman(3549));
		
	}*/
}
