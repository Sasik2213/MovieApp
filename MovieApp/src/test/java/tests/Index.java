package tests;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class Index {
	
	public void checkHeadingText(WebElement element,String texString) {
		Assert.assertEquals(element.getText().toString(),texString,"Please Verify Once Properly!!");
	}
	public void checkUserNameLabel(WebElement element,String teString) {
		Assert.assertEquals(element.getText().toString(), teString,"Please Verify Once Properly!!");
	}
	public void checkPasswordLabel(WebElement element,String teString) {
		Assert.assertEquals(element.getText().toString(), teString,"Please Verify Once Properly!!");
	}
	public void checkErrorMessageOccured(WebElement element) {
		System.out.println(element.getText().toString());
	}

	public WebDriver driver;
	public LoginPage loginPage;

	@BeforeTest
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qamoviesapp.ccbp.tech");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
	}

//	@AfterTest
//	public void end() {
//		driver.quit();
//	}

	@Test
	public void loginPageUI() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.checkLogo(loginPage.siteLogo);
		checkHeadingText(loginPage.loginText,"Login");
		checkUserNameLabel(loginPage.userNameText,"USERNAME");
		checkPasswordLabel(loginPage.passwordText, "PASSWORD");
		loginPage.checkLoginBtn(loginPage.loginText);
	}

	@Test
	public void loginPageFunctions() throws Exception {
		loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn)).click();
		checkErrorMessageOccured(driver.findElement(By.xpath("//p[@class='error-message']")));
		loginPage.loginEntries("Hello","Rahul@2021");
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn)).click();
		checkErrorMessageOccured(driver.findElement(By.xpath("//p[@class='error-message']")));
		loginPage.loginEntries("rahul","rahul@2021");
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn)).click();
	}
}
