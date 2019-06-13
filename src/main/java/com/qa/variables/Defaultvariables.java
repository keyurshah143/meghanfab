package com.qa.variables;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Defaultvariables {
	public static WebElement element;
	public static List<WebElement> elements;
	public static String stringelement;
	public static WebDriver driver = null;

	public static String testlocalurl = "http://meghanfabulous.local/";
	public static String testusername = "keyurshah21";
	public static String testemailaddress = "keyur.shah+21@sooryen.com";
	public static String testpassword = "Sooryen@1234";
	public static String testnewpassword = "Sooryen@1234";
	public static String testfirstname = "Keyur";
	public static String testlastname = "Shah";
	public static String testcompanyname = "Company Name";
	public static String testcountryname = "United States (US)";
	public static String teststreetaddress1 = "369 Shutter Street";
	public static String teststreetaddress2 = "Street 2";
	public static String testcitytown = "California";
	public static String teststatecounty = "California";
	public static String testpostcodezip = "90012";
	public static String testphonenumber = "9876543210";
	public static String testdisplayname = "keyurshah14";
	public static String testproducturl = "http://meghanfabulous.local/product/bali-maxi-dress-peacock/";
	public static String testinvalidusername = "keyurshah19invalid";
	public static String testinvalidemailaddress = "keyur.shahinvalid@sooryen.com";
	public static String testinvalidpassword = "Sooryen@123456789";
	
	
	

	public static String host = "smtp.gmail.com";
	public static String port = "587";
	public static String mailFrom = "sooryenqateam@gmail.com";
	public static String password = "Sooryen@123";
	public static String mailTo = "keyur.shah@sooryen.com";
	public static String subject = "New email with attachments";
	public static String message = "I have some attachments for you.";
	public static String path = System.getProperty("user.dir");
	public static String destination = path + "\\ExtentReportHTML\\EberjeyHTMLReport.html";
	public static String latestmetricsfilename = "Metrics-2019Jun13-";
	
	

}
