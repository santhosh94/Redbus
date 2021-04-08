package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class RoundTripSteps {

	WebDriver driver;

	public By objfromCity=By.id("src");
	public By objtoCity=By.id("dest");
	public By objdate=By.id("onward_cal");
	public By objrespectivedate=By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td[contains(text(),'14')]");
	public By objSearchButton=By.id("search_btn");
	public By objSearchresult=By.cssSelector("span.f-bold.busFound");
	
	
	
//	WebDriverWait wait=new WebDriverWait(driver,30);
	
	public void imp(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	@Given("user is in redbus main page")
	public void user_is_on_make_my_trip_home_page() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.out.println("inside step 1");
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Santhosh\\workspace\\MakeMyTripProject1\\src\\test\\resources\\driver\\chromedriver.exe");
	
	driver=new ChromeDriver(options);

	driver.manage().window().maximize();
	
	System.out.println("open url");
	driver.navigate().to("https://www.redbus.in/");
	imp(2);
	
	}

	@When("user enters depart and return cities")
	public void user_enters_depart_and_return_cities() throws InterruptedException {
	    
	    System.out.println("step 2 : ");
	    //enter from city
	    
	    driver.findElement(objfromCity).sendKeys("Del");
	    System.out.println("entered from city");
	    
	    imp(5);
	    
	    driver.findElement(objtoCity).sendKeys("Bangalore");
        System.out.println("entered To city");
	    
        imp(5);
	    
	    
	}

	@When("user selects date")
	public void user_selects_date() throws InterruptedException {
	    System.out.println("step 3 : ");
	    
	    System.out.println("click depart date.");
	    driver.findElement(objdate).click();
	    
//	   wait.until(ExpectedConditions.invisibilityOfElementLocated(objrespectivedate));
	    
	    System.out.println("select respective date");
	    driver.findElement(objrespectivedate).click();
	    
	    imp(3);
	}

	@When("user clicked on searchBuses")
	public void user_clicked_on_searchBuses() throws InterruptedException {
	    System.out.println("step 4 : ");
	    imp(5);

	    System.out.println("click on search button");
	    driver.findElement(objSearchButton).click();
	}

	@Then("user should see redbus results")
	public void user_should_see_redbus_results() throws InterruptedException {
	    System.out.println("step 5 : ");
	    
	    imp(5);

	    System.out.println("waiting for search result.");
	    WebElement result=driver.findElement(objSearchresult);
	    if(result.isDisplayed()) {
	    	System.out.println("My results displayed.");
	    	
	    }
	    
	    driver.quit();
	    System.out.println("I quit my browser");
	}
}
