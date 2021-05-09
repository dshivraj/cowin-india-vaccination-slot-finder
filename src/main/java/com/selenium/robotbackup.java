package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class robotbackup {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shivraj.daraveshkar\\Documents\\chromedriver_win32\\chromedriver.exe");
		String url = "https://www.cowin.gov.in/home";
		String t = "Available Slot";

		WebDriver l_driver = null;

		l_driver = new ChromeDriver();
		System.out.println("Invoked Chrome");
		l_driver.get(url);
		l_driver.manage().window().maximize();

		enterTextValue(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[2]/div/input",
				"400043", l_driver);

		clickElementByXPath(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[2]/div/div/button",
				l_driver);

		// Find elements using tag name
		List<WebElement> allInputElements = l_driver.findElements(By.cssSelector("slots-box"));

		WebElement allInputWebElement = l_driver.findElement(By.cssSelector("a:contains('slots-box')"));

		if (allInputElements.size() != 0) {
			System.out.println(allInputElements.size() + " Elements found by Class Name as input \n");

			for (WebElement inputElement : allInputElements) {
				System.out.println(inputElement.getAttribute("placeholder"));
				String abc = inputElement.getAttribute("no-seat");

				System.out.println(abc);
//				if (true ==  inputElement.getAttribute("no-seat")) {
//				
//				}

			}
		} else {

			System.out.println(allInputElements.size() + " Bhag sale");
		}

		String colr = l_driver.findElement(By.xpath(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[7]/div/div/div/div[1]/div/div/div[2]/ul/li[2]/div/div/div[1]"))
				.getCssValue("color");

		String bckgclr = l_driver.findElement(By.xpath(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[7]/div/div/div/div[1]/div/div/div[2]/ul/li[2]/div/div/div[1]"))
				.getCssValue("background-color");

		List<WebElement> allInputElementss = l_driver.findElements(By.xpath(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/div/div/div[1]/div/div/div[2]/ul/li[2]/div"));

		System.out.println(colr);
		System.out.println(bckgclr);

		// identify elements with text()
//	      List<WebElement> l= driver.findElements(By.xpath("//*[contains(text(),'You are browsin')]"));
		// verify list size
//	      if ( l.size() > 0){
//	         System.out.println("Text: " + t + " is present. ");
//	      } else {
//	         System.out.println("Text: " + t + " is not present. ");
//	      }

	}

	public static void clickElementByXPath(String elementPath, WebDriver l_driver) throws Exception {
		try {
			l_driver.findElement(By.xpath(elementPath)).click();
		} catch (Exception p_exp) {
			// log the error message
			throw p_exp;
		}
	}

	public boolean verifyElementTextByXPath(String elementPath, String text, WebDriver l_driver) throws Exception {
		boolean result = false;
		try {
			if (null != text && !"".equalsIgnoreCase(text)) {
				if (text.equals(l_driver.findElement(By.xpath(elementPath)).getText())) {
					result = true;
				}
			}
		} catch (Exception p_exp) {
			// log the error message
			throw p_exp;
		}
		return result;
	}

//	public static void getText(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ghs6kor\\Desktop\\Java\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		String url = "https://www.tutorialspoint.com/index.htm";
//		driver.get(url);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		String t = "You are browsing the best resource for Online Education";
//		// getPageSource() to get page source
//		if (driver.getPageSource().contains("You are browsin")) {
//			System.out.println("Text: " + t + " is present. ");
//		} else {
//			System.out.println("Text: " + t + " is not present. ");
//		}
//	}

	public static boolean enterTextValue(String elementPath, String key, WebDriver l_driver) throws Exception {
		boolean result = false;
		try {
			l_driver.findElement(By.xpath(elementPath)).sendKeys(key);
			result = true;
		} catch (Exception p_exp) {
			// log the error message
			throw p_exp;
		}
		return result;
	}

}
