package stepdefinations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Constants;
public class Steps extends BaseTest {

	@Before
	public void openBrowser(){
		BaseTest.initBrowser();
	}
		
	
	@Given("^User is on Application  Page$")
	public void user_is_on_Application_Page() throws Exception{
		String URL = prop.getProperty("ApplicationURL");
		driver.get(URL);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("9177110255");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("nidhi123");
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		System.out.println("user is in application page");
	}
	@Then("^User selects product$")
	public void user_selects_product() {
	WebElement a=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
	a.sendKeys("mobiles");
	a.sendKeys(Keys.ENTER);
	System.out.println("user selects product ");
	}

	@Then("^User click Product$")
	public void user_click_Product(){
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();	
		System.out.println("user clicks product ");
		String parent_Window=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String w:windows)
		{
			if(!parent_Window.equals(w))
			{
				driver.switchTo().window(w);
			}
		}
	}

	@Then("^User click on ADD TO CART$")
	public void user_click_on_ADD_TO_CART(){
	
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		System.out.println("user add to cart product ");
		
	}
}
