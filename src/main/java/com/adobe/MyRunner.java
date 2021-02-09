package com.adobe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.adobe.service.*;
import java.util.*;


@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired 
	private IntegerToRoman intToRoman; 
	
	@Override
	public void run(String... args)
	{
		System.out.println("Started the application");
	}

}
