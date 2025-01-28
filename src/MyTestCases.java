import java.awt.RenderingHints.Key;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String WebSite = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void mySetUp() {

		driver.manage().window().maximize();
		driver.get(WebSite);

	}

	@Test(priority = 1, description = "Radio Button", invocationCount = 1, enabled = false)

	public void RadioButtonExample() throws InterruptedException {

		List<WebElement> AllRadioButtons = driver.findElements(By.className("radioButton"));

		int randomIndex = rand.nextInt(AllRadioButtons.size());

		AllRadioButtons.get(randomIndex).click();

	
	}
	
	
	
	
	@Test(priority = 2 , description = "drop down" , enabled = false)
	public void DynamicDropdownExample() throws InterruptedException {
		
		 String[] randomTwoLetterCombinations = {
				 "JO", "RD", "AN", // Jordan
		            "UN", "IT", "ED", "ST", "AT", "ES", // United States
		            "CA", "NA", "DA", // Canada
		            "AU", "ST", "RA", "LI", "IA", // Australia
		            "BR", "AZ", "IL", // Brazil
		            "SO", "UT", "AF", "RI", "CA", // South Africa
		            "EG", "YP", "PT", // Egypt
		            "IN", "DI", "IA", // India
		            "JA", "PA", "AN", // Japan
		            "CH", "IN", "NA"};
		 
		 int randomIndex = rand.nextInt(randomTwoLetterCombinations.length);
		 
		 WebElement DynamicListInput = driver.findElement(By.id("autocomplete"));
		 
		 DynamicListInput.sendKeys(randomTwoLetterCombinations[randomIndex]);
		 
		 Thread.sleep(1000);
		 
		 DynamicListInput.sendKeys(Keys.chord(Keys.ARROW_DOWN , Keys.ENTER));

	}
	
	
	@Test(priority = 3 , description = "Static Dropdown" , enabled = false)
	
	public void StaticDropdownExample () {
		
		WebElement SelectElement = driver.findElement(By.id("dropdown-class-example"));
		
		Select sel = new Select(SelectElement);
		
	}
	
	
	@Test(priority = 4 , description = "Check Boxes" , enabled = false)
	public void CheckboxExample () throws InterruptedException {
		
		List<WebElement> Checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int randomIndex = rand.nextInt(Checkbox.size());
		
		for(int i = 0 ; i < Checkbox.size() ; i++) {
			
			Thread.sleep(1000);
			Checkbox.get(i).click();
		}

	}
	
	
	
	@Test(priority = 5 , description = "Moving from window to another one" , enabled = false)
	public void SwitchWindowExample () throws InterruptedException {
		WebElement OpenWIndowButton = driver.findElement(By.id("openwindow"));
		OpenWIndowButton.click();
		
		Thread.sleep(2000);
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		
		
		System.out.println(windowHandles.size());
		
		
		driver.switchTo().window(windowHandles.get(1));
		
		WebElement ContactButton = driver.findElement(By.id("menu-item-9680"));
		ContactButton.click();
		
		System.out.println(driver.getTitle() + "hello from the second window");
		
		driver.close();
		
		driver.switchTo().window(windowHandles.get(0));

	}
	
	
	@Test(priority = 6 , description = "check moving to another tab" , enabled = false)
	public void SwitchTabExample() throws InterruptedException {
		
		WebElement openTabButton = driver.findElement(By.id("opentab"));
		openTabButton.click();
		
		List<String> WindowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(WindowHandles.get(1));
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}
	
	
	
	@Test(priority = 7 , description = "Alert and confirm" , enabled = false)
	
	public void SwitchToAlertExample () throws InterruptedException {
		
		WebElement nameBox = driver.findElement(By.id("name"));
		
		nameBox.sendKeys("ibrahem");
		
		WebElement AlertBox = driver.findElement(By.id("alertbtn"));
		AlertBox.click();
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	 Thread.sleep(1000);
		

	}
	
	
	@Test(priority = 8 )
	public void WebTableExample() {
		WebElement TheTable = driver.findElement(By.id("product"));
		
		List<WebElement> theDataInsideTheTable = TheTable.findElements(By.tagName("tr"));
		
		for(int i = 1 ; i < theDataInsideTheTable.size() ; i++) {
			
			int totalTdInTheRow = theDataInsideTheTable.get(i).findElements(By.tagName("td")).size();
			
			
			
			System.out.println(theDataInsideTheTable.get(i).findElements(By.tagName("td")).get(totalTdInTheRow-1).getText());
			
		}
		
		
	}

	
	
	


	

}
