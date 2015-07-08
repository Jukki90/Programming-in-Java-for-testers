package com.example.tests;

import org.testng.annotations.Test;

public class TestCreateGroup extends TestBase {
 

	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {

	app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupPage();
    app.getGroupHelper().createGroup();
    GroupData group = new GroupData();
    group.name="Alexander Army";
    group.header="header 1";
    group.footer="footer 1";
    app.getGroupHelper().fillGroupPage(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }


}
