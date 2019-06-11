package com.qa.methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Meghanmethods extends Defaultmethods {
	
	

	public static WebElement myaccounticontopbar() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("/html/body/header/div[2]/a[3]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	
	public static WebElement myaccountpagelogoutbutton() throws Exception {

		try {
			waitForElementVisible(element);
			element = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static List<WebElement> myaccountpagelogoutbuttontext() throws Exception {

		try {
			waitForElementsVisible(elements);
			elements = driver.findElements(By.xpath("//a[contains(text(),'Log out')]"));
		} catch (Exception e) {
			throw (e);
		}
		return elements;
	}
}
