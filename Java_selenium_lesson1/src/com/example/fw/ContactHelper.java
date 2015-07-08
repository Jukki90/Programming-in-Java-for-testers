package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.TestBase;
import com.example.tests.UserData;

public class ContactHelper extends HelperBase{
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}


	public void fillUserAttributes( UserData user) {
		type(By.name("firstname"), user.firstName);
		type(By.name("lastname"), user.lastName);
		type(By.name("address"), user.address);
		type(By.name("home"), user.homePhone);
		type(By.name("mobile"), user.mobilePhone);
		type(By.name("email"), user.email);
		type(By.name("byear"), user.birthYear);
		type(By.name("address2"), user.address2);
		
	    selectByText(By.name("bday"), user.birthDay);
	    selectByText(By.name("bmonth"), user.birthMonth);
	    
	    selectByText(By.name("new_group"), user.group);
	  
	}




	public void addNewUser() {
		click(By.linkText("add new"));
	}
	
	public void deleteContact(int index) {
		initContactModification(index);
		click(By.xpath("//input[@value='Delete']"));
		
	}


	public void SubmitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	}
	
	public void initContactModification(int index) {
		++index;
		click(By.xpath("(//img[@alt='Edit'])["+index+"]"));
		
		
	}
	
	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

}
