package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	

	
	@BeforeTest
	public void setUp() throws Exception {
		app=new ApplicationManager();
	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(int i=0; i<5;i++){
			GroupData group = new GroupData();
			group.name=generateRandomString();
			group.header=generateRandomString();
			group.footer=generateRandomString();
			list.add(new Object[]{group});
					
		}
		return list.iterator();
				
	}
	
	

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(int i=0; i<5;i++){
			UserData user = new UserData();
			user.firstName=generateRandomString();
			user.lastName=generateRandomString();
			user.email=generateRandomString();
			user.mobilePhone=generateRandomString();
			user.homePhone=generateRandomString();
			user.birthDay=generateRandomNumber(30);
			user.birthMonth=generateRandomMonth();
			user.birthYear=generateRandomNumber(2000);
			//user.group="Rob";
			user.address2=generateRandomString();
			list.add(new Object[]{user});
					
		}
		return list.iterator();
				
	}

	public String generateRandomString() {
		Random rnd= new Random();
		if (rnd.nextInt(3)==0){
			return "�";
		}else{
			return ("test"+rnd.nextInt());
		}
	}
	
	public String generateRandomNumber(int max) {
		Random rnd= new Random();
		String str="";
		str+=(rnd.nextInt(max)+1);
		return str;
	}
	
	public String generateRandomMonth() {
		String[] arr={
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December",
			"-"
				
		};
		
		Random rnd= new Random();
		return arr[rnd.nextInt(12)];
	}


}
