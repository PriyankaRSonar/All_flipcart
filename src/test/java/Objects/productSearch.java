package Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class productSearch 
{
	WebDriver driver;
	public productSearch(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By searchbox = By.xpath("//input[@type='text']");
	By search_btn=By.xpath("//button[@type='submit']");
    By StrapMaterial_Filter = By.xpath("//div[contains(text(),'Strap Material')]");
	By Nylon_click = By.xpath("//div[text()='Nylon' and @class='_3879cV']");
	By print_result = By.xpath("//span[contains(text(),'Showing')]");
	By amount_element = By.xpath("//div[@class='_25b18c']//div[starts-with(text(),'₹')]");
	
	
	public void M_productSearch(String Searchinput)  
	{
		try 
		{
			driver.findElement(searchbox).sendKeys(Searchinput);
			driver.findElement(search_btn).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,800)");  //scrolldown
	        driver.findElement(StrapMaterial_Filter).click();
	        driver.findElement(Nylon_click).click();
	        
	        String result = driver.findElement(print_result).getText();
			System.out.println("Result :: "+ result);
			Thread.sleep(2000);
			
		}catch (Exception e)
		{
			System.out.println("Exception Caught"+e.getMessage());
		}
	}
	
	public void M_getNthProduct(int itemNumber)
	{
		String nthProduct = driver.findElement(By.xpath("(//div[@class='_1xHGtK _373qXS'])["+itemNumber+"]")).getText();
		
		System.out.println(itemNumber+"th Product :: "+ nthProduct);
	}
	
	public void M_fetchFirst5Products()
	{
		int count=1;
		List<WebElement> list= driver.findElements(amount_element);
		if(list.size()!=0)
		{
			for(int i=1;i<list.size();i++)
			{
				WebElement element = list.get(i);
				String amount = element.getText();
				int amont=Integer.parseInt(amount.replaceAll("[^0-9]","").toString());
				if(amont<=3000)
				{
					String title = driver.findElement(By.xpath("//div[starts-with(@class,'_3eWWd-')]//text())["+i+"]")).getText();
					System.out.println("Product:"+count+"title is"+title);
					count++;
				}
				if (count>=6)
				break;
			}
		}
	}
}
