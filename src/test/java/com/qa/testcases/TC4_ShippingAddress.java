package com.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class TC4_ShippingAddress extends Meghanmethods {

	@Test
	public static void shippingaddresstestcase() throws Exception {
		openchromebrowser();
		driver.get(testlocalurl);
		TC1_Login.logintestuser();
		addbillingaddress();
		driver.quit();

	}

	public static void addbillingaddress() throws Exception {

		myaccountpageaddresstablink().click();
		editshippingaddressbutton().click();
		shippingaddressfirstnametextbox().clear();
		shippingaddressfirstnametextbox().sendKeys(testfirstname);
		shippingaddresslastnametextbox().clear();
		shippingaddresslastnametextbox().sendKeys(testlastname);
		shippingaddresscompanynametextbox().clear();
		shippingaddresscompanynametextbox().sendKeys(testcompanyname);
		shippingaddresscountrydropdown().click();
		shippingaddresscountrydropdowntextbox().sendKeys(testcountryname);
		shippingaddresscountrydropdowntextboxselect().click();
		shippingaddressstreetaddresstextbox1().clear();
		shippingaddressstreetaddresstextbox1().sendKeys(teststreetaddress1);
		shippingaddressstreetaddresstextbox2().clear();
		shippingaddressstreetaddresstextbox2().sendKeys(teststreetaddress2);
		shippingaddresstowncitytextbox().clear();
		shippingaddresstowncitytextbox().sendKeys(testcitytown);
		shippingaddressstatecountydropdown().click();
		shippingaddressstatecountydropdowntextbox().sendKeys(teststatecounty);
		shippingaddressstatecountydropdowntextboxselect().click();
		shippingaddresspostcodeziptextbox().clear();
		shippingaddresspostcodeziptextbox().sendKeys(testpostcodezip);

		shippingaddresssaveaddressbutton().click();
		if (shippingaddressexpectedsuccessmessage().equalsIgnoreCase("Address changed successfully.")) {

			System.out.println("Shipping Address updation is Passed");
		} else {
			System.out.println("Shipping Address updation is Failed");
			System.out.println(shippingaddressexpectedsuccessmessage());

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

	public static WebElement editshippingaddressbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath(
					"//div[@class='u-columns woocommerce-Addresses col2-set addresses']//div[2]//header[1]//a[1]"));
		} catch (Exception e) {
			System.out.println("editshippingaddressbutton");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddressfirstnametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_first_name"));
		} catch (Exception e) {
			System.out.println("shippingaddressfirstnametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresslastnametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_last_name"));
		} catch (Exception e) {
			System.out.println("shippingaddresslastnametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresscompanynametextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_company"));
		} catch (Exception e) {
			System.out.println("shippingaddresscompanynametextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresscountrydropdown() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.id("select2-shipping_country-container"));

		} catch (Exception e) {
			System.out.println("shippingaddresscountrydropdown");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresscountrydropdowntextbox() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));

		} catch (Exception e) {
			System.out.println("shippingaddresscountrydropdowntextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresscountrydropdowntextboxselect() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[1]"));

		} catch (Exception e) {
			System.out.println("shippingaddresscountrydropdowntextboxselect");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddressstreetaddresstextbox1() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_address_1"));
		} catch (Exception e) {
			System.out.println("shippingaddressstreetaddresstextbox1");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddressstreetaddresstextbox2() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_address_2"));
		} catch (Exception e) {
			System.out.println("shippingaddressstreetaddresstextbox2");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresstowncitytextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_city"));
		} catch (Exception e) {
			System.out.println("shippingaddresstowncitytextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddressstatecountydropdown() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.id("select2-shipping_state-container"));

		} catch (Exception e) {
			System.out.println("shippingaddressstatecountydropdown");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddressstatecountydropdowntextbox() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));

		} catch (Exception e) {
			System.out.println("shippingaddresscountrydropdowntextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddressstatecountydropdowntextboxselect() throws Exception {

		try {

			waitForElementVisible(element);
			element = driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[1]"));

		} catch (Exception e) {
			System.out.println("shippingaddresscountrydropdowntextboxselect");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresspostcodeziptextbox() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.id("shipping_postcode"));
		} catch (Exception e) {
			System.out.println("shippingaddresspostcodeziptextbox");
			throw (e);
		}
		return element;
	}

	public static WebElement shippingaddresssaveaddressbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//button[@name='save_address']"));
		} catch (Exception e) {
			System.out.println("shippingaddresssaveaddressbutton");
			throw (e);
		}
		return element;
	}

	public static String shippingaddressexpectedsuccessmessage() throws Exception {

		try {

			stringelement = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();

		} catch (Exception e) {
			System.out.println("shippingaddressexpectedsuccessmessage");
			throw (e);
		}
		return stringelement;
	}

}
