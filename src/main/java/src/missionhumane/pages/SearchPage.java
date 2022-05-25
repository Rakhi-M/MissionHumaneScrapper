package src.missionhumane.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.missionhumane.base.BaseClass;

public class SearchPage extends BaseClass{
	
	
	/*
	 * @FindBy(
	 * className="MuiTypography-root-99 mb-4 MuiTypography-body1-101 MuiTypography-colorTextSecondary-125"
	 * ) WebElement Result;
	 */
	  
	
	/*
	 * @FindBy(xpath="//h6") List<WebElement> itemNames;
	 */
	  
	/*
	 * @FindAll(@FindBy(xpath=
	 * "//div//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[2]//p[2]//a[1]"
	 * )) List<WebElement> contacts;
	 * 
	 * @FindAll(@FindBy(xpath=
	 * "//div//div[1]//div[1]//div[1]//div[2]//div[1]//div[4]//p[2]"))
	 * List<WebElement> description;
	 */
	 
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
		
	
	public List<String> getItemNames() throws InterruptedException { 
	    Thread.sleep(5000);
		
		List<WebElement> itemNames=driver.findElements(By.xpath("//h6"));
		List<String> itemNameDesc=new ArrayList<String>(); 
		//System.out.println(itemNames.size());
		for(WebElement item:itemNames) {
				itemNameDesc.add(item.getText()); 
				//System.out.println(item.getText());
			} 
		itemNameDesc.remove("Follow Us");
		return itemNameDesc; 
		}
	
	public List<String> getContactNames() { 
	    
		
		List<WebElement> contactNamesEle=driver.findElements(By.xpath("//div//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//p[2]"));
		List<String> contactNames=new ArrayList<String>(); 
		//System.out.println(itemNames.size());
		for(WebElement item:contactNamesEle) {
				contactNames.add(item.getText()); 
				//System.out.println(item.getText());
			} 
		
		return contactNames; 
		}
	
        public List<String> getLocations() { 
	    		
		List<WebElement> locationEle=driver.findElements(By.xpath("//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//p[2]"));
		List<String> locations=new ArrayList<String>(); 
		//System.out.println(itemNames.size());
		for(WebElement item:locationEle) {
				locations.add(item.getText()); 
				//System.out.println(item.getText());
			} 
		
		return locations; 
		}
	
	
	
	public List<String> getContacts(){ 
	  //  Thread.sleep(5000);
		
		List<WebElement> contacts=driver.findElements(By.xpath("//div//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[2]//p[2]//a[1]"));
		List<String> contactNumbers=new ArrayList<String>(); 
		//System.out.println(itemNames.size());
		for(WebElement contact:contacts) {
				contactNumbers.add(contact.getText()); 
				//System.out.println(contact.getText());
			} 
		
		return contactNumbers; 
		}
	 
	public List<String> getDescription() { 
	  //  Thread.sleep(5000);
		
		List<WebElement> descriptionEle=driver.findElements(By.xpath("//div//div[1]//div[1]//div[1]//div[2]//div[1]//div[4]//p[2]"));
		List<String> descriptions=new ArrayList<String>(); 
		//System.out.println(itemNames.size());
		for(WebElement description:descriptionEle) {
				descriptions.add(description.getText()); 
				//System.out.println(description.getText());
			} 
		
		return descriptions; 
		}
	 
	
	
	

}
