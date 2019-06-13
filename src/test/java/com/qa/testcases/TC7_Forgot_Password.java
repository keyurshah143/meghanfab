package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;

public class TC7_Forgot_Password extends Meghanmethods {

	@Test(priority = 1, enabled = true)
	public static void login_both_valid_fields_testcase() throws Exception {
		driver.get(testlocalurl);
		myaccounticontopbar().click();
		lostyourpasswordbuttonlink().click();
		lostyourpasswordusernameemailtextbox().sendKeys(testusername);
		lostyourpasswordsubmitbutton().click();
		String lostyourpasswordexpectedsuccessmessage = "Password reset email has been sent.";
		if (lostyourpasswordactualsuccessmessage().equalsIgnoreCase(lostyourpasswordexpectedsuccessmessage)) {

			System.out.println("Lost your password page is working properly");
		} else {
			System.out.println("Failed - Lost your password page is not working properly");
			System.out.println(lostyourpasswordexpectedsuccessmessage);
			System.out.println(lostyourpasswordactualsuccessmessage());
			Assert.fail("Forgot password Test case Failed");
		}
	}

	public static WebElement lostyourpasswordbuttonlink() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//a[@class='lost-pass']"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement lostyourpasswordusernameemailtextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("user_login"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement lostyourpasswordsubmitbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//button[@class='woocommerce-Button button']"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static String lostyourpasswordactualsuccessmessage() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
			stringelement = element.getText();
		} catch (Exception e) {
			throw (e);
		}
		return stringelement;
	}

}
