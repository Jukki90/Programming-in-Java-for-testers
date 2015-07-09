package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupPage();
		 //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.name="New name";
		app.getGroupHelper().fillGroupPage(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
		 
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    
	    //compare states
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList,oldList);
	}
}