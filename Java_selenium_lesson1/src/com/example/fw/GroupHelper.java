package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase{
	public GroupHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void openGroupPage() {
		click(By.linkText("groups"));
	}
	
	public void createGroup() {
		driver.findElement(By.name("new")).click();
		
	}
	
	public void returnToGroupPage() {
		click(By.linkText("group page"));
	}
	
	

	public void fillGroupPage(GroupData groupData) {
	    type(By.name("group_name"), groupData.name);
	    type(By.name("group_header"), groupData.header);
	    type(By.name("group_footer"), groupData.footer);

	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+index+"]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		
	}



	public void submitGroupModification() {
		click(By.name("update"));
		
	}
	
	public void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

}
