package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;

public class TC2_Register extends Meghanmethods {

	@Test
	public static void registertestcase() throws Exception {
		openchromebrowser();
		driver.get(testlocalurl);
		registertestuser();
		driver.quit();
	}

	public static void registertestuser() throws Exception {

		myaccounticontopbar().click();
		myaccountpagecreateanaccountlink().click();
		registerpageusernametextbox().sendKeys(testusername);
		registerpageemailaddresstextbox().sendKeys(testemailaddress);
		registerpagepasswordtextbox().sendKeys(testpassword);
		registerpageregistersubmitbutton().click();
		registerpagepasswordtextbox().sendKeys(testpassword);
		registerpageregistersubmitbutton().click();

		if (myaccountpagelogoutbuttontext().size() != 0) {
			
			System.out.println("Registeration was Successful");

		} else {
			System.out.println("Registeration Failed");
		}

	}

	public static WebElement myaccountpagecreateanaccountlink() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//a[@class='create-acc']"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement registerpageusernametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("reg_username"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement registerpageemailaddresstextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("reg_email"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement registerpagepasswordtextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("reg_password"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement registerpageregistersubmitbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//button[@name='register']"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

}
