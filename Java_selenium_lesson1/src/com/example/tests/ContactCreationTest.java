package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTest extends TestBase{


  @Test(dataProvider="randomValidContactGenerator")
  public void testAddUser(UserData user) throws Exception {
	app.navigateTo().mainPage();
	
	//save old state
    List<UserData> oldList = app.getContactHelper().getContacts();
    //actions
    app.getContactHelper().addNewUser();
    app.contactHelper.fillUserAttributes(user, CREATION);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state
    List<UserData> newList = app.getContactHelper().getContacts();
    
    
    //compare states
   oldList.add(user);
   Collections.sort(oldList);
   assertEquals(newList,oldList);
    
  }
}