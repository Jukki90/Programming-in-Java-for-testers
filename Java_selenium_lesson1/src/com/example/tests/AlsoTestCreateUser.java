package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AlsoTestCreateUser extends TestBase{
 

  @Test
  public void testAddUser() throws Exception {
	openMainPage();
	addNewUser();
    UserData user = new UserData();
    user.firstName="����";
    user.lastName="�����������";
    user.address="���������";
    user.homePhone="84959002211";
    user.mobilePhone="89197778879";
    user.email="army@mail.ru";
    user.birthDay="11";
    user.birthMonth="July";
    user.birthYear="360";
    user.group="Alexander Army";
    user.address2="����������� �������";
    
    fillUserAttributes(user);
    pressSubmit();
    openMainPage();
  }



}