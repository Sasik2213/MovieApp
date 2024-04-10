package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='login website logo']")
	public WebElement siteLogo;
	
	@FindBy(xpath ="//h1[normalize-space()='Login']")
	public WebElement loginText;
	
	@FindBy(xpath = "//label[normalize-space()='USERNAME']")
	public WebElement userNameText;
	
	@FindBy(xpath = "//label[normalize-space()='PASSWORD']")
	public WebElement passwordText;
	
	@FindBy(xpath = "//input[@id='usernameInput']")
	public WebElement userNameInput;
	
	@FindBy(xpath = "//input[@id='passwordInput']")
	public WebElement passwordInpt;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	public WebElement loginBtn;
	
	
	public void checkLogo(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("Logo Displayed!!");
		}
		else
		{
			System.out.println("Logo Not Displayed!!");
		}
	}
	public void checkLoginBtn(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("Login Text Displayed!");
		}
		else
		{
			System.out.println("Login Text Not Displayed!");
		}
	}
	public void loginEntries(String uname,String pswd) {
		userNameInput.clear();
		passwordInpt.clear();
		userNameInput.sendKeys(uname);
		passwordInpt.sendKeys(pswd);
		loginBtn.click();
	}
	

}
