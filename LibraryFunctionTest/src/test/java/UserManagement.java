import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserManagement {
	
	SoftAssertions softly = new SoftAssertions();
	
	public void checkAccess(WebDriver driver, int login, String[]op) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Click on Knowledge
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-k"))).click();
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException r){
			throw r;
		}
		List<String>f = Arrays.asList(op);
		WebElement element;
		//Verify the modules selected
		if(f.contains("Event Reports"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Event Reports")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Event Reports enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Event Reports disabled");
		}
		if(f.contains("JIT Wisdom"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Wisdom")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("JIT Wisdom enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("JIT Wisdom disabled");
		}
		if(f.contains("JIT Risk Joggers"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Risk Joggers")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("JIT Risk Joggers enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("JIT Risk Joggers disabled");
		}
		if(f.contains("Knowledge Bank"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Bank")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Knowledge Bank enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Knowledge Bank disabled");
		}
		if(f.contains("Knowledge Exchange"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Exchange")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Knowledge Exchange enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Knowledge Exchange disabled");
		}
		if(f.contains("Project Management"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Performance Accountability & Analytics")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Performance Accountability & Analytics enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Performance Accountability & Analytics disabled");
		}
		//Clicks on Analysis
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
	    if(f.contains("SPV Error Meter"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("SPV Error Meter enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("SPV Error Meter disabled");
		}
		if(f.contains("Human Performance Inspector"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("HPI enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("HPI disabled");
		}
		if(f.contains("Human Error Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("HiRCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("HiRCA disabled");
		}
		if(f.contains("Equipment Failure Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("EiRCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("EiRCA disabled");
		}
		if(f.contains("Organization & Programmatic Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("O&PiRCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("O&PiRCA disabled");
		}
		if(f.contains("Instant Common Cause Analysis"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("ICCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("ICCA disabled");
		}
		if(f.contains("Job Observation Analysis"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Job Obs enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("Job Obs disabled");
		}
		if(f.contains("3-Pass Review"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("3 Pass Review enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("3 Pass Review disabled");
		}
		if(f.contains("Remote Verification"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Remote Verification enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("Remote Verification disabled");
		}
		//Clicks on Learning
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Learning"))).click();
		//Clicks on Error-Free Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		if(f.contains("Human Performance Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Human Performance enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Human Performance disabled");
		}
		if(f.contains("Equipment Performance Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Equipment Performance enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Equipment Performance disabled");
		}
		if(f.contains("Electrical Failure Mode Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Modes")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Electrical Failure Modes enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Electrical Failure Modes disabled");
		}
		if(f.contains("Mechanical Failure Mode Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Modes")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Mechanical Failure Modes enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Mechanical Failure Modes disabled");
		}		    
	}
	
	
	public void deleteUser(WebDriver driver, String company_id) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Edit user
		  driver.findElement(By.id("pii-admin-user-edit")).click();
		  Thread.sleep(2000);
		  //Searches for newly created user
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		  //Selects the newly created user
		  WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		  //Clicks on delete user
		  driver.findElement(By.id("pii-admin-user-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("User deleted");
	}
	
	public void deleteGroup(WebDriver driver, String company_id) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Edit group
		  driver.findElement(By.id("pii-admin-group-edit")).click();
		  Thread.sleep(2000);
		  //Searches for newly created group
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		  //Selects the newly created group
		  WebElement select = driver.findElement(By.id("pii-admin-group-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		  //Clicks on delete group
		  driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Group deleted");
	}
	
	public void deleteCompany(WebDriver driver, String company_id) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Companies
		  driver.findElement(By.id("pii-admin-customers-button")).click();
		  Thread.sleep(2000);
		  //Enters company id in ID field 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		  //Clicks on newly created company id
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		  Thread.sleep(2000);
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on delete company
		  driver.findElement(By.id("pii-admin-cust-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Company deleted");
	}

}
