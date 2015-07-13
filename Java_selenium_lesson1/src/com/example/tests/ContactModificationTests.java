package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test(dataProvider="randomValidContactGenerator")
	public void modifySomeContact(UserData user){
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<UserData> oldList = app.getContactHelper().getContacts();
	    //actions
	    Random rnd=new Random();
	    int index = rnd.nextInt(oldList.size()-1);    
		app.getContactHelper().initContactModification(index);
		
		user.firstName="����";
		user.lastName="����";
		
		app.contactHelper.fillUserAttributes(user);
		app.getContactHelper().SubmitContactModification();
		app.getContactHelper().returnToHomePage();
		
		//save new state
	    List<UserData> newList = app.getContactHelper().getContacts();
	    
	    //compare states

	    
	    oldList.remove(index);
	    oldList.add(user);
	    Collections.sort(newList);
	    Collections.sort(oldList);
	    
	    
	    assertEquals(newList,oldList);
	    
	}
}
