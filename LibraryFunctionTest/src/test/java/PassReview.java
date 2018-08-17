import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PassReview {

	public void deleteNewRecord(WebDriver driver, String recordName) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on first newly created record
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a"))).click();
		  ShareCheck obj = new ShareCheck();
		  obj.loadingServer(driver);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  obj.loadingServer(driver);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-3pr"))).click();
		  obj.loadingServer(driver);
		  //Verify record deleted
		  //Click on 1st record
		  Thread.sleep(2000);
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");			  
	  }
	
	public void openReport(WebDriver driver) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,10); 
		//Clicks on record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a"))).click();
		//Wait for loading message
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Clicks on open
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		//Clicks on open
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-save"))).click();
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-dialog-confirmed"))).click();
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		obj.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-savedactivities"))).click();
		obj.loadingServer(driver);
		//Clicks on side panel option for job observation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-3pr"))).click();
		obj.loadingServer(driver);
	}
	
	public String createReport (WebDriver driver) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,10); 
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA ();
		String text = obj1.textCreate(driver);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		}catch (UnhandledAlertException f){			  
		  driver.switchTo().alert().dismiss();
		}
		//Clicks on 3 Pass review
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr"))).click();
		Thread.sleep(2000);
		//Fills in mandatory details
		driver.findElement(By.id("pii-3pr-tab-1-reviewer")).sendKeys(text);
		driver.findElement(By.id("pii-3pr-tab-1-title")).sendKeys(text);
		driver.findElement(By.id("pii-3pr-tab-1-org")).sendKeys(text);
		String ev1 = driver.findElement(By.id("pii-3pr-tab-1-reviewer")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-3pr-tab-1-title")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-3pr-tab-1-org")).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
		  driver.findElement(By.id("pii-3pr-tab-1-reviewer")).clear();
		  driver.findElement(By.id("pii-3pr-tab-1-reviewer")).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
		  driver.findElement(By.id("pii-3pr-tab-1-title")).clear();
		  driver.findElement(By.id("pii-3pr-tab-1-title")).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
		  driver.findElement(By.id("pii-3pr-tab-1-org")).clear();
		  driver.findElement(By.id("pii-3pr-tab-1-org")).sendKeys(text);
		}
		//Select Purpose from dropdown
		WebElement element = driver.findElement(By.id("pii-3pr-tab-1-doctype"));
		Select s = new Select (element);
		s.selectByVisibleText("Drawing");
		Thread.sleep(2000);		  
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-save"))).click();
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-dialog-confirmed"))).click();
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		//Wait for loading message
		obj.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-3pr-savedactivities"))).click();
		obj.loadingServer(driver);
		//Clicks on side panel option for job observation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-3pr"))).click();
		obj.loadingServer(driver);
		//Gets the name of the record created
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a"));
		String recordName = record.getText();
		if (record.isDisplayed())
		{
		  System.out.println("Record found: "+ recordName);
		}
		else
		  System.out.println ("Record not found.");
		
		return recordName;
	}

}
