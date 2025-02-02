package JavaAutomation.JavaSeleniumUIAutomation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import JavaSeleniumUIAutomation.pageobjects.LandingPage;
import JavaSeleniumUIAutomation.pageobjects.ProductCatalouge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SubmitOrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName = "IPHONE 13 PRO";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("sumitkoley727@gmail.com", "Sumit@123");
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		//List<WebElement>products =productCatalouge.getProductList();
		productCatalouge.addProductToCart(productName);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder ='Select Country']")),"India").build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	}

}
