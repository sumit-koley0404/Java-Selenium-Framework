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
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    @FindBy(css="div[class='left mt-1'] h3")
    WebElement atmnTxt;
	
	By btn = By.cssSelector("#login");
	By automationText = By.cssSelector("div[class='left mt-1'] h3");
	By invalidLoginPopup = By.cssSelector("div[aria-label='Incorrect email or password.']");
	
	
	
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
	public String automationText()
	{
		waitForElementToAppear(automationText);
		return atmnTxt.getText();
	}
	public String invalidMessage()
	{
		waitForElementToAppear(invalidLoginPopup);
		return errorMessage.getText();
		
	}

	
	

}
