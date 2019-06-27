package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.methods.Meghanmethods;

public class TC6_PlaceOrder extends Meghanmethods {
	@Test
	public static void logintestcase() throws Exception {
		driver.get(testlocalurl);
		TC1_Login.logintestuser();
		driver.get(testproducturl);
//		driver.findElement(By.xpath("//*[@id=\"product-8074\"]/div/div[2]/form/table/tbody/tr[1]/td[2]/ul/li[2]/span"))
//				.click();
//		driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
//		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
//		driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//				driver.findElement(By.xpath("//div[@id='stripe-card-element']")));
//		driver.findElement(By.xpath("//div[@id='stripe-card-element']")).sendKeys("4111111111111111");
//		driver.findElement(By.xpath("//div[@id='stripe-exp-element']")).sendKeys("12 / 23");
//		driver.findElement(By.xpath("//div[@id='stripe-cvc-element']")).sendKeys("123");
//		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		closebrowser();

	}

}
