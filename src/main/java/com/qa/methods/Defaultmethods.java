package com.qa.methods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.variables.Defaultvariables;

public class Defaultmethods extends Defaultvariables {

	public static String path = System.getProperty("user.dir");
	static WebElement datePicker;
	static List<WebElement> noOfColumns;
	static List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December");
	// Expected Date, Month and Year
	static int expMonth;
	static int expYear;
	static String expDate = null;
	// Calendar Month and Year
	static String calMonth = null;
	static String calYear = null;
	static boolean dateNotFound;
	public static String excel = "\\Excelsheet\\eberjey.xlsx";

	@BeforeClass
	@Parameters({ "browser" })
	public static void setup(String browser) {
		if (browser.equals("FFX")) {
			try {
				System.out.println("Test Starts Running In Firefox Browser.");
				System.setProperty("webdriver.gecko.driver", path + "//browsersetup//geckodriver.exe");

				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (browser.equals("CRM")) {
			try {
				System.out.println("Test Starts Running In Chrome Browser.");

				System.setProperty("webdriver.chrome.driver", path + "//browsersetup//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void writeexcel() {

		try {

		} catch (Exception e) {
			System.out.println("Testtest");
			System.out.println(e.getMessage());

		}

	}

	public static void waitForElementVisible(WebElement element) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void waitForElementsVisible(List<WebElement> elements) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			System.out.println(e);
		}
	}



	public static class SaveScreenshot {
		public static void capture(String testCaseName, WebDriver driver) {
			// Cast driver object to TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			// Get the screenshot as an image File
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			try {
				// Specify the destination where the image will be saved
				File dest = new File(path + "\\screenshots\\" + testCaseName + "_" + timestamp() + ".jpg");
				// Copy the screenshot to destination
				FileUtils.copyFile(src, dest);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}

		public static String timestamp() {
			// Timestamp to make each screenshot name unique
			return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		}
	}

	public static String between(String value, String a, String b) {
		// Return a substring between the two strings.
		try {
			int posA = value.indexOf(a);
			if (posA == -1) {
				return "";
			}
			int posB = value.lastIndexOf(b);
			if (posB == -1) {
				return "";
			}
			int adjustedPosA = posA + a.length();
			if (adjustedPosA >= posB) {
				return "";
			}
			return value.substring(adjustedPosA, posB);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	public static String before(String value, String a) {
		// Return substring containing all characters before a string.
		int posA = value.indexOf(a);
		if (posA == -1) {
			return "";
		}
		return value.substring(0, posA);
	}

	public static String after(String value, String a) {
		// Returns a substring containing all characters after a string.
		int posA = value.lastIndexOf(a);
		if (posA == -1) {
			return "";
		}
		int adjustedPosA = posA + a.length();
		if (adjustedPosA >= value.length()) {
			return "";
		}
		return value.substring(adjustedPosA);
	}

	public static void currentdate() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String todaysdate = dateFormat.format(date);

		// Print the Date
		System.out.println("Current date and time is " + todaysdate);
	}

	public static void pickExpDate() throws InterruptedException {

		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int expDates = cal.get(Calendar.DAY_OF_MONTH);
		String expDate = Integer.toString(expDates);
		int expMonths = cal.get(Calendar.MONTH);
		int expMonth = expMonths + 1;
		int expYear = cal.get(Calendar.YEAR);
		System.out.println(today);
		System.out.println(expDate);
		System.out.println(expMonth);
		System.out.println(expYear);
		// Click on date text box to open date picker popup.
		dateNotFound = true;

		// Set your expected date, month and year.

		// This loop will be executed continuously till dateNotFound Is true.
		while (dateNotFound) {
			// Retrieve current selected month name from date picker popup.
			calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			// Retrieve current selected year name from date picker popup.
			calYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			// If current selected month and year are same as expected month and year then
			// go Inside this condition.
			if (monthList.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
				// Call selectDate function with date to select and set dateNotFound flag to
				// false.
				selectDate(expDate);
				dateNotFound = false;
			}
			// If current selected month and year are less than expected month and year then
			// go Inside this condition.
			else if (monthList.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear > Integer.parseInt(calYear)) {
				// Click on next button of date picker.
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
			}
			// If current selected month and year are greater than expected month and year
			// then go Inside this condition.
			else if (monthList.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear < Integer.parseInt(calYear)) {
				// Click on previous button of date picker.
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
			}
		}
		Thread.sleep(3000);
	}

	public static void selectDate(String date) {
		datePicker = driver.findElement(By.id("ui-datepicker-div"));
		noOfColumns = datePicker.findElements(By.tagName("td"));

		// Loop will rotate till expected date not found.
		for (WebElement cell : noOfColumns) {
			// Select the date from date picker when condition match.
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}
		}
	}

	public static int stringCompare(String str1, String str2) {

		int l1 = str1.length();
		int l2 = str2.length();
		int lmin = Math.min(l1, l2);

		for (int i = 0; i < lmin; i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);

			if (str1_ch != str2_ch) {
				return str1_ch - str2_ch;
			}
		}

		// Edge case for strings like
		// String 1="Geeks" and String 2="Geeksforgeeks"
		if (l1 != l2) {
			return l1 - l2;
		}

		// If none of the above conditions is true,
		// it implies both the strings are equal
		else {
			return 0;
		}
	}

	public static void pressenter() throws Exception {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void waitshort() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void waitlong() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void closebrowser() throws Exception {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void closebrowsertab() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	private static File getLatestFilefromDir() {
//		File dir = new File(path + "\\target\\surefire-reports");
//		System.out.println("List of file directory");
//		File[] files = dir.listFiles();
//		System.out.println(files);
//		
//
//		if (files == null || files.length == 0) {
//			return null;
//		}
//		List<File> metricFile = new ArrayList<File>();
//		for (int i = 1; i < files.length; i++) {
//
//			if (files[i].getName().startsWith("Metrics")) {
//				metricFile.add(files[i]);
//			}
//
//		}
//		File lastModifiedFile = metricFile.get(0);
//		for (File f : metricFile) {
//			if (lastModifiedFile.lastModified() < f.lastModified()) {
//				lastModifiedFile = f;
//			}
//		}
//		return lastModifiedFile;
//	}

	@AfterSuite
	public static void sendemailreport() throws Exception {
		try {
			String[] attachFiles = new String[1];
//			File file = getLatestFilefromDir();
//			System.out.println(file.getAbsolutePath() + "::::::" + file.getName());

			attachFiles[0] = path + "\\test-output\\emailable-report.html";
			SendMailMethod.sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message,
					attachFiles);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = path + "\\ExtentReportHTML\\Extentreportscreenshots\\" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
