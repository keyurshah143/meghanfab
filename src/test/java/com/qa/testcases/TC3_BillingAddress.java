package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;

public class TC3_BillingAddress extends Meghanmethods {

	@Test
	public static void billingaddresstestcase() throws Exception {
		openchromebrowser();
		driver.get(testlocalurl);
		TC1_Login.logintestuser();
		addbillingaddress();
		closebrowser();

	}

	public static void addbillingaddress() throws Exception {

		myaccountpageaddresstablink().click();
		editbillingaddressbutton().click();
		billingaddressfirstnametextbox().clear();
		billingaddressfirstnametextbox().sendKeys(testfirstname);
		billingaddresslastnametextbox().clear();
		billingaddresslastnametextbox().sendKeys(testlastname);
		billingaddresscompanynametextbox().clear();
		billingaddresscompanynametextbox().sendKeys(testcompanyname);
		billingaddresscountrydropdown().click();
		billingaddresscountrydropdowntextbox().sendKeys(testcountryname);
		billingaddresscountrydropdowntextboxselect().click();
		billingaddressstreetaddresstextbox1().clear();
		billingaddressstreetaddresstextbox1().sendKeys(teststreetaddress1);
		billingaddressstreetaddresstextbox2().clear();
		billingaddressstreetaddresstextbox2().sendKeys(teststreetaddress2);
		billingaddresstowncitytextbox().clear();
		billingaddresstowncitytextbox().sendKeys(testcitytown);
		billingaddressstatecountydropdown().click();
		billingaddressstatecountydropdowntextbox().sendKeys(teststatecounty);
		billingaddressstatecountydropdowntextboxselect().click();
		billingaddresspostcodeziptextbox().clear();
		billingaddresspostcodeziptextbox().sendKeys(testpostcodezip);
		billingaddressphonetextbox().clear();
		billingaddressphonetextbox().sendKeys(testphonenumber);
		billingaddressemailaddresstextbox().clear();
		billingaddressemailaddresstextbox().sendKeys(testemailaddress);
		billingaddresssaveaddressbutton().click();
		if (billingaddressexpectedsuccessmessage().equalsIgnoreCase("Address changed successfully.")) {

			System.out.println("BillingAddress updation is Passed");
		} else {
			System.out.println("Billing Address updation is Failed");
			System.out.println(billingaddressexpectedsuccessmessage());

		}

	}

	public static WebElement myaccountpageaddresstablink() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
		} catch (Exception e) {
			System.out.println("myaccountpageaddresstablink");
			throw (e);
		}
		return element;
	}

	public static WebElement editbillingaddressbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver
					.findElement(By.xpath("//div[@class='row justify-content-center']//div[1]//header[1]//a[1]"));
		} catch (Exception e) {
			System.out.println("editbillingaddressbutton");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressfirstnametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_first_name"));
		} catch (Exception e) {
			System.out.println("billingaddressfirstnametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresslastnametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_last_name"));
		} catch (Exception e) {
			System.out.println("billingaddresslastnametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresscompanynametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_company"));
		} catch (Exception e) {
			System.out.println("billingaddresscompanynametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresscountrydropdown() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.id("select2-billing_country-container"));

		} catch (Exception e) {
			System.out.println("billingaddresscountrydropdown");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresscountrydropdowntextbox() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));

		} catch (Exception e) {
			System.out.println("billingaddresscountrydropdowntextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresscountrydropdowntextboxselect() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[1]"));

		} catch (Exception e) {
			System.out.println("billingaddresscountrydropdowntextboxselect");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressstreetaddresstextbox1() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_address_1"));
		} catch (Exception e) {
			System.out.println("billingaddressstreetaddresstextbox1");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressstreetaddresstextbox2() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_address_2"));
		} catch (Exception e) {
			System.out.println("billingaddressstreetaddresstextbox2");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresstowncitytextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_city"));
		} catch (Exception e) {
			System.out.println("billingaddresstowncitytextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressstatecountydropdown() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.id("select2-billing_state-container"));

		} catch (Exception e) {
			System.out.println("billingaddressstatecountydropdown");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressstatecountydropdowntextbox() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));

		} catch (Exception e) {
			System.out.println("billingaddressstatecountydropdowntextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressstatecountydropdowntextboxselect() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[1]"));

		} catch (Exception e) {
			System.out.println("billingaddressstatecountydropdowntextboxselect");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresspostcodeziptextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_postcode"));
		} catch (Exception e) {
			System.out.println("billingaddresspostcodeziptextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressphonetextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_phone"));
		} catch (Exception e) {
			System.out.println("billingaddressphonetextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddressemailaddresstextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("billing_email"));
		} catch (Exception e) {
			System.out.println("billingaddressemailaddresstextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement billingaddresssaveaddressbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//button[@name='save_address']"));
		} catch (Exception e) {
			System.out.println("billingaddresssaveaddressbutton");
			throw (e);
		}
		return element;
	}

	public static String billingaddressexpectedsuccessmessage() throws Exception {

		try {

			stringelement = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();

		} catch (Exception e) {
			System.out.println("billingaddresssaveaddressbutton");
			throw (e);
		}
		return stringelement;
	}

}
