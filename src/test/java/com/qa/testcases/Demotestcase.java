package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.methods.Defaultmethods;

public class Demotestcase extends Defaultmethods {

	@BeforeMethod
	public static void openbrowser() {

		Defaultmethods obj = new Defaultmethods();
		obj.openchromebrowser();
		driver.get("https://www.google.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public static void maximisebrowser() {
		driver.manage().window().maximize();

	}

	@AfterMethod
	public static void closebrowser() {
		driver.quit();

	}
}
