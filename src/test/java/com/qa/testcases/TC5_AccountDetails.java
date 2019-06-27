package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;

public class TC5_AccountDetails extends Meghanmethods {

	@Test
	public static void accountdetailstestcase() throws Exception {
		driver.get(testlocalurl);
		TC1_Login.logintestuser();
		accountdetails();
		closebrowser();

	}

	public static void accountdetails() throws Exception {

		myaccountpageaccountdetailstablink().click();
		accountdetailsfirstnametextbox().clear();
		accountdetailsfirstnametextbox().sendKeys(testfirstname);
		accountdetailslastnametextbox().clear();
		accountdetailslastnametextbox().sendKeys(testlastname);
		accountdetailsdisplaynametextbox().clear();
		accountdetailsdisplaynametextbox().sendKeys(testdisplayname);
		accountdetailsemailaddresstextbox().clear();
		accountdetailsemailaddresstextbox().sendKeys(testemailaddress);
		accountdetailscurrentpasswordtextbox().sendKeys(testpassword);
		accountdetailsnewpasswordtextbox().sendKeys(testnewpassword);
		accountdetailsconfirmnewpasswordtextbox().sendKeys(testnewpassword);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				accountdetailssavechangesbutton());
		accountdetailssavechangesbutton().click();
		if (accountdetailsexpectedsuccessmessage().equalsIgnoreCase("Account details changed successfully.")) {

			System.out.println("Account Details updation is Passed");
		} else {
			System.out.println("Account Details updation is Failed");
			System.out.println(accountdetailsexpectedsuccessmessage());

		}

	}

	public static WebElement myaccountpageaccountdetailstablink() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//a[contains(text(),'Account details')]"));
		} catch (Exception e) {
			System.out.println("myaccountpageaccountdetailstablink");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailsfirstnametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("account_first_name"));
		} catch (Exception e) {
			System.out.println("accountdetailsfirstnametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailslastnametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("account_last_name"));
		} catch (Exception e) {
			System.out.println("accountdetailslastnametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailsdisplaynametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("account_display_name"));
		} catch (Exception e) {
			System.out.println("accountdetailsdisplaynametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailsemailaddresstextbox() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.id("account_email"));

		} catch (Exception e) {
			System.out.println("accountdetailsemailaddresstextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailscurrentpasswordtextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("password_current"));
		} catch (Exception e) {
			System.out.println("accountdetailscurrentpasswordtextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailsnewpasswordtextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("password_1"));
		} catch (Exception e) {
			System.out.println("accountdetailsnewpasswordtextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailsconfirmnewpasswordtextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("password_2"));
		} catch (Exception e) {
			System.out.println("accountdetailsconfirmnewpasswordtextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement accountdetailssavechangesbutton() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//button[@name='save_account_details']"));
		} catch (Exception e) {
			System.out.println("accountdetailssavechangesbutton");
			throw (e);
		}
		return element;
	}

	public static String accountdetailsexpectedsuccessmessage() throws Exception {

		try {

			stringelement = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();

		} catch (Exception e) {
			System.out.println("accountdetailsexpectedsuccessmessage");
			throw (e);
		}
		return stringelement;
	}

}
