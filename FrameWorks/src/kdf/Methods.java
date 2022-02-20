package kdf;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {

	WebDriver driver;
	
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void implementImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	
	public void enterInTextBox(String locValue, String testData) {
		driver.findElement(By.id(locValue)).sendKeys(testData);
	}
	
	public void clickButton(String loc, String locValue) {
		if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
		else if(loc.equals("xpath")) {
			driver.findElement(By.xpath(locValue)).click();
		}
	}
	
	public String getMsg(String loc,String locValue) {
		String text = null;
		if(loc.equals("cssSelector")) {
			 text = driver.findElement(By.cssSelector(locValue)).getText();
		}
		else if(loc.equals("id")) {
			text = driver.findElement(By.id(locValue)).getText();
		}
		return text;
	}
	
	public void closeApplication() {
		driver.quit();
	}
}
