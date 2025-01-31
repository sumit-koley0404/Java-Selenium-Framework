package JavaSeleniumUIAutomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import JavaSeleniumUIAutomation.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage (WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css="#userEmail")
	WebElement userEmail;
	@FindBy(css ="#userPassword")
	WebElement password;
	@FindBy(css="#login")
	WebElement submit;
	By btn = By.cssSelector("#login");
	
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	public void loginApplication(String email,String psw)
	{
		waitForElementToAppear(btn);
		userEmail.sendKeys(email);
		password.sendKeys(psw);
		submit.click();
	}
	
	

}
