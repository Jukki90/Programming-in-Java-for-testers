package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		UserData user = new UserData();
		user.firstName="����";
		app.contactHelper.fillUserAttributes( user);
		app.getContactHelper().SubmitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
