package Test_Scenarios;
/*This line is created for test*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.Number_of_Links_on_Page;
import Objects.flipcart_search;

import Objects.productSearch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Method 
{
	WebDriver driver;
	flipcart_search objectrepo;
	
	@SuppressWarnings("deprecation")
	@BeforeTest 
	public void beforetest() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//div[@class='QS5gu sy4vM' and contains(text(),'Accept all')]"))
		                                                                                   .click();	
		driver.manage().window().maximize();
	}
	
	@Test
	public void SearchOperation() throws InterruptedException  
	{
		flipcart_search page=new flipcart_search(driver);
		page.searchgoogle("flipKart");
		objectrepo = new flipcart_search(driver);
		objectrepo.click_Flipcart();
		
	}
	
	@Test
	public void NoOfLinks()
	{
		Number_of_Links_on_Page page=new Number_of_Links_on_Page(driver);
		page.getLinkCount();
	}

	@Test (priority = 1)
	public void TM_productSearch()
	{
		productSearch page=new productSearch(driver);
		page.M_productSearch("apple watch");
	}
	
	@Test (priority = 2)
	public void M_getNthProduct() throws InterruptedException  
	{
		productSearch page=new productSearch(driver);
		page.M_getNthProduct(2);
	}
	
//	@Test (priority = 2)
//	public void TM_fetchFirst5Products() 
//	{
//		productSearch page=new productSearch(driver);
//		page.M_fetchFirst5Products();
//	}
	

}
