package com.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.methods.Defaultmethods;
import com.qa.methods.Meghanmethods;

public class TC1_Login extends Meghanmethods {
	@Test
	public static void logintestcase() throws Exception {
		openchromebrowser();
		driver.get(testlocalurl);
		logintestuser();
		driver.quit();

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
