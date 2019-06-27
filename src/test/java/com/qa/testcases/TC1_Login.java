package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;

public class TC1_Login extends Meghanmethods {
	@Test(priority = 1, enabled = true)
	public static void login_both_valid_fields_testcase() throws Exception {
		driver.get(testlocalurl);
		logintestuser();
		closebrowser();
	}

	@Test(priority = 2, enabled = false)
	public static void login_with_both_invalid_fields() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(testlocalurl);
		myaccounticontopbar().click();
		myaccountpageusernametextbox().sendKeys(testinvalidusername);
		myaccountpagepasswordtextbox().sendKeys(testinvalidpassword);
		myaccountpageloginsubmitbutton().click();
		String actualvalidationmessage = driver.findElement(By.xpath("//section[@class='main']//li[1]")).getText();
		String expectedvalidationmessage = "ERROR: Invalid username. Lost your password?";
		if (actualvalidationmessage.equalsIgnoreCase(expectedvalidationmessage)) {
			System.out.println("Validation message appears properly for both invalid fields");
		} else {
			System.out.println("Validation message does not appears properly for both invalid fields");
			System.out.println(actualvalidationmessage);
			System.out.println(expectedvalidationmessage);
			Assert.fail("Login Test case validation Failed");
		}

	}

	@Test(priority = 3, enabled = false)
	public static void login_with_username_valid_password_invalid() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(testlocalurl);
		myaccounticontopbar().click();
		myaccountpageusernametextbox().sendKeys(testusername);
		myaccountpagepasswordtextbox().sendKeys(testinvalidpassword);
		myaccountpageloginsubmitbutton().click();
		String actualvalidationmessage = driver.findElement(By.xpath("//section[@class='main']//li[1]")).getText();
		String expectedvalidationmessage = "ERROR: The password you entered for the username " + testusername
				+ " is incorrect. Lost your password?";
		if (actualvalidationmessage.equalsIgnoreCase(expectedvalidationmessage)) {
			System.out.println("Validation message appears properly for valid username and invalid password fields");
		} else {
			System.out.println(
					"Validation message does not appears properly for valid username and invalid password fields");
			System.out.println(actualvalidationmessage);
			System.out.println(expectedvalidationmessage);
			Assert.fail("Login Test case validation Failed");
		}

	}

	@Test(priority = 4, enabled = false)
	public static void login_with_username_invalid_password_valid() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(testlocalurl);
		myaccounticontopbar().click();
		myaccountpageusernametextbox().sendKeys(testinvalidusername);
		myaccountpagepasswordtextbox().sendKeys(testpassword);
		myaccountpageloginsubmitbutton().click();
		String actualvalidationmessage = driver.findElement(By.xpath("//section[@class='main']//li[1]")).getText();
		String expectedvalidationmessage = "ERROR: Invalid username. Lost your password?";
		if (actualvalidationmessage.equalsIgnoreCase(expectedvalidationmessage)) {
			System.out.println("Validation message appears properly for invalid username and valid password fields");
		} else {
			System.out.println(
					"Validation message does not appears properly for invalid username and valid password fields");
			System.out.println(actualvalidationmessage);
			System.out.println(expectedvalidationmessage);
			Assert.fail("Login Test case validation Failed");
		}

	}

	@Test(priority = 5, enabled = false)
	public static void login_with_both_fields_blank() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(testlocalurl);
		myaccounticontopbar().click();
		myaccountpageusernametextbox().sendKeys("");
		myaccountpagepasswordtextbox().sendKeys("");
		myaccountpageloginsubmitbutton().click();
		String actualvalidationmessage = driver.findElement(By.xpath("//section[@class='main']//li[1]")).getText();
		String expectedvalidationmessage = "Error: Username is required.";
		if (actualvalidationmessage.equalsIgnoreCase(expectedvalidationmessage)) {
			System.out.println("Validation message appears properly for both blank fields");
		} else {
			System.out.println("Validation message does not appears properly for both blank fields");
			System.out.println(actualvalidationmessage);
			System.out.println(expectedvalidationmessage);
			Assert.fail("Login Test case validation Failed");
		}
		closebrowser();
	}

	public static void logintestuser() throws Exception {

		myaccounticontopbar().click();
		myaccountpageusernametextbox().sendKeys(testemailaddress);
		myaccountpagepasswordtextbox().sendKeys(testpassword);
		myaccountpageloginsubmitbutton().click();

		if (myaccountpagelogoutbuttontext().size() != 0) {
			System.out.println("Login was Passed");

		} else {
			System.out.println("Login was Failed");
			Assert.fail("Login Test Failed");
		}

	}

	public static WebElement myaccountpageusernametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("username"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement myaccountpagepasswordtextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("password"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement myaccountpageloginsubmitbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("/html/body/section/div/section/div/div/div/div/form/p[3]/button"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

}
