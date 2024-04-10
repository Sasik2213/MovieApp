package pages;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[normalize-space()='Home']")
	public WebElement homeBtn;
	@FindBy(xpath = "//div[@class='home-movie-details-container']")
	public WebElement playBtn;
	@FindBy(xpath = "//p[@class='contact-us-paragraph']")
	public WebElement contactUs;
	public void checkElementHead(WebElement element) {
		System.out.println("Head Element is Displayed: "+element.isDisplayed());
	}
	public void checkAnyElementFindOrNot(WebElement element) {
		System.out.println("Element Found:"+element.getText().toString()+" is Displayed!!");
	}
	public void isElementDisplayed(WebElement element) {
		System.out.println(element.isDisplayed());
	}
}
