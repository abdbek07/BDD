package definition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
private WebDriver driver;
	
	@Before
		public void SetUp(){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
	}
	
	@Given("a user on amazon homepage")
	public void a_user_on_amazon_homepage() {
		driver.navigate().to("https://www.amazon.com/");
	}

	@When("he enters \"([^\"]*)\" in search box")
	public void he_enters_in_search_box(String string) {
	   WebElement searchbox = driver.findElement(By.ByXPath.xpath("//*[@id=\"twotabsearchtextbox\"]"));
	   searchbox.sendKeys(string);
	   
	}

	@When("he submits the request")
	public void he_submits_the_request() {
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
	}
	
	@Then("ensure search is successfull \"(.*)\"")
	public void ensure_search_is_successfull(String msg) {
		WebElement message = driver.findElement(By.xpath("//*[@id=\"s-result-count\"]/span/span"));
		
		assertEquals(message.getText(),msg);
	}
	
	@After
    public void tearDown() {
      driver.close();
    }
}
