package src.missionhumane.scrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.missionhumane.base.BaseClass;
import com.missionhumane.utils.XLWriter;

import src.missionhumane.pages.HomePage;
import src.missionhumane.pages.SearchPage;

public class ScrapeMain extends BaseClass{
	
	HomePage homePage;
	SearchPage searchPage;
	String state,city,item;
	
	void setUp() {
		
		//Launch the browser and url. from BaseClass
		initialize();
		
		homePage=new HomePage();
		
		//Load the properties file
		Properties prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\Rakhi\\SDET09 workspace\\MissionHumaneScrapper\\src\\main\\java\\com\\missionhumane\\config\\input.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException fe) {
			
		}
		catch(IOException e) {
			
		}
		
		//Get the input data from properties file 
		state=prop.getProperty("stateName");
		city=prop.getProperty("cityName");
		item=prop.getProperty("lookUpItem");
		
		System.out.println("State:"+state+"\tcity:"+city+"\tLook up item:"+item);
		
		
	}
	
	//Enter the search criteria on homepage and go to search page
	void searchItem() throws InterruptedException {
		homePage.clickState(state);
		homePage.clickCity(city);
		homePage.clickItem(item);
		searchPage=homePage.clickSearch();
		
	}
	
	  
	  List<String> getItemNames() throws InterruptedException  { 
	     List<String> itemName=searchPage.getItemNames();
	     return itemName;
	 	      
	  }
	  
	  List<String> getContactNames()   { 
		     List<String> contactNames=searchPage.getContactNames();
		     return contactNames;
		 	      
		  }
	 
	  
	  List<String> getContactNumbers()   { 
		     List<String> contactNumbers=searchPage.getContacts();
		     return contactNumbers;
		 	      
		  }
	  
	  List<String> getLocations()  { 
		     List<String> locations=searchPage.getLocations();
		     return locations;
		 	      
		  }
	 
	  List<String> getDescription() throws InterruptedException  { 
		     List<String> description=searchPage.getDescription();
		     return description;
		 	      
		  }

	public static void main(String[] args) throws InterruptedException, IOException {
		ScrapeMain scrape=new ScrapeMain();
		
		// Launch the browser and get the input data from properties file
		scrape.setUp();
		
		//Input the search criteria on homepage
		scrape.searchItem();
		
		List<List<String>> DataScraped=new ArrayList<>();
		
		//Add the data scraped to the Arraylist of lists
		DataScraped.add(scrape.getItemNames());
		DataScraped.add(scrape.getContactNames());
		DataScraped.add(scrape.getContactNumbers());
		DataScraped.add(scrape.getLocations());
		DataScraped.add(scrape.getDescription());
		
		/*Printing the data on console
		 * for(int i=0;i<DataScraped.get(0).size();i++) { for(int
		 * j=0;j<DataScraped.size();j++) {
		 * System.out.print(DataScraped.get(j).get(i)+"\t"); } System.out.println();
		 * 
		 * }
		 */

		  XLWriter.writeExcel("C:\\Users\\Rakhi\\SDET09 workspace\\MissionHumaneScrapper\\src\\main\\java\\output", "data_scraped2.xlsx", "Sheet1", DataScraped);
		 
		
		driver.quit();

	}

}
