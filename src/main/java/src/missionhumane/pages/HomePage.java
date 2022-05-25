package src.missionhumane.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.missionhumane.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="(//div[@role='button'])[1]")
	WebElement selectState;
	
	@FindBy(xpath="(//div[@role='button'])[2]")
	WebElement selectCity;
	
	@FindBy(xpath="(//div[@role='button'])[3]")
	WebElement selectItem;
	
	@FindBy(xpath="//button[@name='Search leads']")
	WebElement searchButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickState(String stateName) throws InterruptedException {
		selectState.click();
		Thread.sleep(500);
		String statePath="//li[normalize-space()='"+stateName+"']";
		WebElement element=driver.findElement(By.xpath(statePath));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	public void clickCity(String cityName) throws InterruptedException {
		selectCity.click();
		Thread.sleep(500);
		String cityPath="//li[normalize-space()='"+cityName+"']";
		WebElement element=driver.findElement(By.xpath(cityPath));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
			
	}
	
	public void clickItem(String itemName) throws InterruptedException {
		selectItem.click();
		Thread.sleep(500);
		String itemPath="//li[normalize-space()='"+itemName+"']";
		driver.findElement(By.xpath(itemPath)).click();
	}
	
	
	
	public SearchPage clickSearch() {
		searchButton.click();
		return new SearchPage();
	}
	

}
