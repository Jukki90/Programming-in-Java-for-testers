package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestCreateGroup extends TestBase {
 

	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {

	app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    //actions
    app.getGroupHelper().createGroup();
    GroupData group = new GroupData();
    group.name="Alexander Army";
    group.header="header 1";
    group.footer="footer 1";
    app.getGroupHelper().fillGroupPage(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    
    //compare states
   // assertEquals(newList.size(), oldList.size()+1);
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList,oldList);
    
  }

  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupPage();
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    //actions
    
    app.getGroupHelper().createGroup();
    GroupData group = new GroupData("", "", "");
	app.getGroupHelper().fillGroupPage(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    
    //compare states
   // assertEquals(newList.size(), oldList.size()+1);
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList,oldList);
  }

}
