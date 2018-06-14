import java.awt.Robot;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseBrowse {
	
	SoftAssertions softly = new SoftAssertions();
	String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2018. Derivative Product Strictly Prohibited.";
	String caseHumanDev = "1459";
	String caseEquipDev = "1459";
	String caseElecDev = "1678";
	String caseMechDev = "1210";
	String caseHumanProd = "746";
	String caseHumanProdPercent = "618";
	String caseEquipProd = "231";
	String caseEquipProdPercent = "1341";
	String caseElecProd = "1260";
	String caseMechProd = "1638";
	String keywordHumanDev = "test data";
	String keywordHumanDevSpcl = "test.1/1";
	String keywordHumanDevPercent = "Testpercentage%";
	String keywordEquipDev = "test data";
	String keywordEquipDevSpcl = "test.1/1";
	String keywordEquipDevPercent = "Testpercentage%";
	String keywordElecDev = "sanity";
	String keywordElecDevSpcl = "test.1/1";
	String keywordElecDevPercent = "Testpercentel%";
	String keywordMechDev = "Sanity test";
	String keywordMechDevSpcl = "test.1/1";
	String keywordMechDevPercent = "Testpercentme%";
	String keywordHumanProd = "power plant worker";
	String keywordHumanProdPercent = "50%";
	String keywordEquipProd = "Static electrification failure mechanism";
	String keywordEquipProdPercent = "20%";
	String keywordElecProd = "pneumatic controller";
	String keywordMechProd = "benefits and failure modes of U-cup";
	String titleDev = "Sanity Test: DO NOT DELETE: QAA";
	String titleHumanProd = "How is an Error-Free® work day achieved for power plant workers?";	
	String titleEquipProd = "What are the controlling parameters affecting static electrification in a transformer?";
	String titleElecProd = "What are the operating principles and failure modes of a pneumatic controller?";
	String titleMechProd = "What are the benefits and failure modes of U-cup (U-ring) or an O-ring Loaded U-cup?";
	String keywordHumanProdAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	String keywordHumanProdAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String keywordEquipProdAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:";
	String keywordEquipProdAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String keywordHumanDevAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	String keywordHumanDevAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String keywordEquipDevAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	String keywordEquipDevAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String[] s= {"@","!","#","$","%","&"," ","/","?",",","."};
	
	public void getHumanPerformanceLink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on ErrorFree Bank
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
		//Clicks on Human Performance
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance"))).click();
	}
	
	public void getEquipPerformanceLink(WebDriver driver, int y) throws Exception {
	
		WebDriverWait wait = new WebDriverWait(driver,20);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Equipment Performance
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance"))).click();
	}
	
	public void getEquipPerformancePIILink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Equipment Performance PII
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Data Bank (Instructor Only)"))).click();
	}
	
	public void getElecFailureModeLink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Electrical Failure Mode
        try{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Modes"))).click();
        }catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
        {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Failure Modes"))).click();
        }
	}
	
	public void getMechFailureModeLink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Mechanical Failure Mode
        try{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Modes"))).click();
        }catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
        {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Failure Modes"))).click();
        }	    
	}
	
	public void verifyOrderOfModules(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify order
		//Human Performance
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[1]/a"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Human Performance");
		//Engineering Fundamentals
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[2]/a"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Engineering Fundamentals");
		//Equipment Performance
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[3]/a"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Equipment Performance");
		String url = driver.getCurrentUrl();
		if(url.contains("kaledev"))
		{
			//Failure Modes
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[4]/a"))).getText();
			softly.assertThat(s3).as("test data").isEqualTo("Failure Modes");
			//Prevention of Design Deficiencies
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[5]/a"))).getText();
			softly.assertThat(s4).as("test data").isEqualTo("Prevention of Design Deficiencies");
			if(y==0)
			{
				//Equipment Data Bank (Instructor Only)
				String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[6]/a"))).getText();
				softly.assertThat(s5).as("test data").isEqualTo("Equipment Data Bank (Instructor Only)");
			}
		}
		else
		{
			//Failure Modes
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[4]/a"))).getText();
			softly.assertThat(s3).as("test data").isEqualTo("Electrical Failure Modes");
			//Failure Modes
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[5]/a"))).getText();
			softly.assertThat(s5).as("test data").isEqualTo("Mechanical Failure Modes");
			//Prevention of Design Deficiencies
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[6]/a"))).getText();
			softly.assertThat(s4).as("test data").isEqualTo("Prevention of Design Deficiencies");
			if(y==0)
			{
				//Equipment Data Bank (Instructor Only)
				String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[7]/a"))).getText();
				softly.assertThat(s6).as("test data").isEqualTo("Equipment Data Bank (Instructor Only)");
			}
		}
		if(y==1)
			verifyNoEquipPII(driver);
	}
	
	public void verifyNoEquipPII(WebDriver driver) throws Exception {
		
		//Checks for equipment search pii
		if(driver.findElement(By.id("pii-e-menu-equipPII")).isDisplayed()==false)
		{
		  System.out.println("Non admin user cannot see Equipment Search PII");
	    }
		else softly.fail("Equipment PII is present in non admin");
	}
	
	public void addKeywordWithAllSpecialCharactersEquip(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    String url = driver.getCurrentUrl();
	    //Clear keyword field
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
	    //Assigns keyword as per browser and url
	    if(url.contains("kaledev"))
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keywordEquipDevAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keywordEquipDevAllSpecial);
	    	}
	    }
	    else
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keywordEquipProdAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keywordEquipProdAllSpecial);
	    	}
	    }
	    Thread.sleep(2000);
	    jse.executeScript("scroll(0,2000)");	
	    Thread.sleep(2000);
	    //Click on add keyword
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();	
	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input")));
	    for (int i=0; i<s.length;i++)
		{
			//clear keyword field
			ele.clear();
			Thread.sleep(1000);
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			Thread.sleep(1500);
			jse.executeScript("scroll(0,2000)");	
		    Thread.sleep(2000);
			//Click on add keyword
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();	
		}
	    jse.executeScript("scroll(0,2000)");	
	    Thread.sleep(2000);
	}
	
	public void addKeywordWithAllSpecialCharactersHuman(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    String url = driver.getCurrentUrl();
	    //Clear keyword field
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
	    Thread.sleep(1000);
	    //Assigns keyword as per browser and url
	    if(url.contains("kaledev"))
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keywordHumanDevAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keywordHumanDevAllSpecial);
	    	}
	    }
	    else
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keywordHumanProdAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keywordHumanProdAllSpecial);
	    	}
	    }
	    Thread.sleep(2000);
	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input")));
	    //Click on add keyword
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();	
	    for (int i=0; i<s.length;i++)
		{
			//clear keyword field
			ele.clear();
			Thread.sleep(1000);
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			Thread.sleep(1500);
			//Click on add keyword
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();	
		}
	    jse.executeScript("scroll(0,2000)");	
	    Thread.sleep(2000);
	}
	
	public void searchWithKeyKeywordWithAllSpecialCharacters(WebDriver driver,String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement ele=null;
		//Search for either Human or Equipment search element for Term field
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input")));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input")));
		}
		//clear term field
		ele.clear();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    String url = driver.getCurrentUrl();
		//Assigns keyword as per browser and url
	    if(url.contains("kaledev"))
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		ele.sendKeys(keywordHumanDevAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		ele.sendKeys(keywordHumanDevAllSpecial);
	    	}
	    }
	    else
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		ele.sendKeys(keywordHumanProdAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		ele.sendKeys(keywordHumanProdAllSpecial);
	    	}
	    }
	    Thread.sleep(2000);
	    //Press ENTER
	    ele.sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Look for case
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		}		
		//Clear
		try{
			driver.findElement(By.id("pii-efse-clear")).click();
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException e)
		{
			driver.findElement(By.id("pii-efsh-clear")).click();
		}
	}

	
	public void searchWithKeywordKALE1964(WebDriver driver, SoftAssertions softly1) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		WebElement ele=null;
		//Search for either Human or Equipment search element for Term field
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input")));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input")));
		}
		//Array of special characters
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String v = cap.getVersion().toString();
		for (int i=0; i<s.length;i++)
		{
			//clear term field
			ele.clear();
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			WebElement dropdown;
			//Look for dynamic dropdown
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-keyword-list")));
			}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
			{
				try{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-keyword-list")));
				}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e1)
				{
					System.out.println("Dropdown not visible as no case exists with keyword: " +"qaafoo"+s[i]+"qaafoo");
				}				
			}
			//Press Enter
			ele.sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			//Verify dropdown has disappeared
			try{
				dropdown = driver.findElement(By.id("pii-efse-keyword-list"));
			}catch (NoSuchElementException u)
			{
				dropdown = driver.findElement(By.id("pii-efsh-keyword-list"));
			}
			if(dropdown.isDisplayed()==true)
			{
				softly1.fail("Dropdown visible and the webelement is: "+dropdown.getAttribute("id"));
			}
			//Clear
			try{
				driver.findElement(By.id("pii-efse-clear")).click();
			}catch (NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException e)
			{
				driver.findElement(By.id("pii-efsh-clear")).click();
			}
		}	
	}	
		
	public void searchWithPercentEquip(WebDriver driver, String keypercent, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void searchWithSpclEquip(WebDriver driver, String keyspcl, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyspcl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void verifySearchOptionsEquip (WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-keyword-block-equip']/div[4]/div/div/a")));
		act1.click(act).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(2000);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownEquip(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void clickDropdownEquip(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efse-keyword-list']/li")));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]"))).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]"))).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]"))).click();
		}
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);	
	}
	
	public void browseTermEquip (WebDriver driver, String keyword, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	    int n = searchKeywordForBrowseCaseEquip(driver,keyword,identifier);
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void browseCaseIDEquip (WebDriver driver, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-input"))).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(By.xpath(".//*[@id='pii-keyword-block-equip']/div[3]/div/div/a"));
		Actions act = new Actions (driver);
		act.click(ele).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-input"))).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-input"))).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void browseTermHuman (WebDriver driver, String keyword, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	    int n = searchKeywordForBrowseCaseHuman(driver,keyword,identifier);
		Thread.sleep(1000);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
	}
	
	public void browseCaseNonAdminHuman(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(1000);
		int n = searchKeywordForBrowseCaseHuman(driver,keyword,identifier);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanNonAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		//verify no case id box
		verifyNoCaseIDSearchHuman (driver);
	}
	
	public void browseCaseIDHuman (WebDriver driver, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbyid-input"))).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(By.xpath(".//*[@id='pii-keyword-block']/div[3]/div/div/a"));
		Actions act = new Actions (driver);
		act.click(ele).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbyid-input"))).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbyid-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbyid-input"))).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbyid-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-Q"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
	}
	
	public void verifyNoCaseIDSearchEquip (WebDriver driver) throws Exception {
		
		//Searches for case id box
		  try{
		  	WebElement caseSearch= driver.findElement(By.id("pii-efse-searchbyid-input"));
		  	if (caseSearch.isDisplayed()==true)
		  		softly.fail("Case id search displayed");
		  	if(caseSearch.isDisplayed()==false)
		  		System.out.println("Case id search box not displayed");

		  }catch(NoSuchElementException e)
		  {
			  System.out.println("Case id search box not present.");
		  }
	}
	
	public void verifyNoCaseIDSearchHuman (WebDriver driver) throws Exception {
		
		//Searches for case id box
		  try{
		  	WebElement caseSearch= driver.findElement(By.id("pii-efsh-searchbyid-input"));
		  	if (caseSearch.isDisplayed()==true)
		  		softly.fail("Case id search displayed");
		  	if(caseSearch.isDisplayed()==false)
		  		System.out.println("Case id search box not displayed");

		  }catch(NoSuchElementException e)
		  {
			  System.out.println("Case id search box not present.");
		  }
	}
	
	public int searchKeywordForBrowseCaseHuman(WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-Q"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		return n;
	}
	
	public int searchKeywordForBrowseCaseEquip(WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-search-label"))).getText();
		if(str.contains("equipment performance cases (PII)"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		}
		else{
		//Look for case by clicking on dropdown
		Thread.sleep(4000);
		WebElement match = null;
		try{
			match=driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li"));
		}catch(NoSuchElementException r)
		{
			//Wait for a few seconds and then try again
			Thread.sleep(3000);
			//Types in the keyword to get slide
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
			Thread.sleep(3000);
			match=driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li"));
		}
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
		  driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]")).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
		  driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]")).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
		  driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]")).click();
		}
		}
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		return n;
	}
	
	public void browseCaseNonAdminEquip(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(1000);
		int n = searchKeywordForBrowseCaseEquip(driver,keyword,identifier);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipNonAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		//verify no case id box
		verifyNoCaseIDSearchEquip (driver);
	}
	
	public void nextBrowseEquipNonAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			 //Moves out of the slideshow and checks for security
			  Thread.sleep(1000);
			  //Clicks on copyright
			  if(i==2)
				  driver.findElement(By.xpath(copyright_xpath)).click();
			  //Clicks on logo
			  if(i==3)
				  driver.findElement(By.xpath(image_xpath)).click();
			  //Clicks outside
			  if(i==4)
			  {
				  Actions act2 = new Actions(driver);
				  Point coordinates = driver.findElement(By.linkText("Next")).getLocation();
				  Robot robot = new Robot();
				  robot.mouseMove(coordinates.getX()+100,coordinates.getY());
				  Thread.sleep(2000);
				  act2.click().build().perform();
			  }
			  //Clicks on title
			  else 
				  driver.findElement(By.xpath(title_xpath)).click();
			  Thread.sleep(3000);
			  //Show slides
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-show-F"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
	}
	
	public void nextBrowseHumanNonAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			 //Moves out of the slideshow and checks for security
			  Thread.sleep(1000);
			  //Clicks on copyright
			  if(i==2)
				  driver.findElement(By.xpath(copyright_xpath)).click();
			  //Clicks on logo
			  if(i==3)
				  driver.findElement(By.xpath(image_xpath)).click();
			  //Clicks outside
			  if(i==4)
			  {
				  Actions act2 = new Actions(driver);
				  Point coordinates = driver.findElement(By.linkText("Next")).getLocation();
				  Robot robot = new Robot();
				  robot.mouseMove(coordinates.getX()+100,coordinates.getY());
				  Thread.sleep(2000);
				  act2.click().build().perform();
			  }
			  //Clicks on title
			  else 
				  driver.findElement(By.xpath(title_xpath)).click();
			  Thread.sleep(3000);
			  //Show slides
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-show-Q"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
	}
	
	public void nextBrowseHumanAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
	}
	
	public void previousBrowseHuman(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Previous"))).click();
		//Checks if there are slides present
		for (int i=n;i>=2;i--)
		{
			System.out.println("Slide "+(i));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
		    //Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
		    //Click on previous
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Previous"))).click();
		}
	}
	
	public void nextBrowseEquipAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
	}
	
	public void previousBrowseEquip(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Previous"))).click();
		//Checks if there are slides present
		for (int i=n;i>=2;i--)
		{
			System.out.println("Slide "+(i));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
		    //Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
		    //Click on previous
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Previous"))).click();
		}
	}
	
	public void searchWithPercentHuman(WebDriver driver, String keypercent, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
	}
	
	public void searchWithSpclHuman(WebDriver driver, String keyspcl, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyspcl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
	}
	
	public void verifySearchOptionsHuman (WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-keyword-block']/div[4]/div/div/a")));
		act1.click(act).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-btn"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(2000);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownHuman(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
	}
	
	public void clickDropdownHuman(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efsh-keyword-list']/li")));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]"))).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]"))).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]"))).click();
		}
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);		
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
