package com.selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class robotReopen {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shivraj.daraveshkar\\Documents\\chromedriver_win32\\chromedriver.exe");
		String url = "https://www.cowin.gov.in/home";

		WebDriver l_driver = null;

		ArrayList<String> zipCodeList = new ArrayList<String>();
		zipCodeList.add("400708");
		zipCodeList.add("400706");
		zipCodeList.add("400607");
		zipCodeList.add("400703");
		zipCodeList.add("400601");

		while (true) {

			for (int i = 0; i < zipCodeList.size(); i++) {

				System.out.println("#########   " + zipCodeList.get(i) + "   #########");

				l_driver = new ChromeDriver();
				l_driver.get(url);
				l_driver.manage().window().maximize();

				JavascriptExecutor js = (JavascriptExecutor) l_driver;

				enterTextValue(
						"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[2]/div/input",
						zipCodeList.get(i), l_driver);

				clickElementByXPath(
						"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[2]/div/div/button",
						l_driver);

				clickElementByXPath(
						"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[4]/div/div[1]/label",
						l_driver);

				clickElementByXPath(
						"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[4]/div/div[4]/label",
						l_driver);

				js.executeScript("window.scrollBy(0,400)");
				Thread.sleep(2000);
				l_driver.quit();

			}
		}

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
