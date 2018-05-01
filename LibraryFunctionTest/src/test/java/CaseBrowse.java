import java.awt.Robot;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseBrowse {
	
	SoftAssertions softly = new SoftAssertions();
	String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2017. Derivative Product Strictly Prohibited.";
	String caseHumanDev = "1459";
	String caseEquipDev = "1459";
	String caseElecDev = "1678";
	String caseMechDev = "1210";
	String caseHumanProd = "746";
	String caseEquipProd = "718";
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
	String keywordEquipProd = "failure";
	String keywordEquipProdPercent = "20%";
	String keywordElecProd = "failure";
	String keywordMechProd = "benefits and failure modes of U-cup";
	String titleDev = "Sanity Test: DO NOT DELETE: QAA";
	String titleHumanProd = "How is an Error-Free work day achieved for power plant workers?";
	String titleEquipProd = "What is the difference between a failure mechanism and a failure mode?";
	String titleElecProd = "What are the operating principles and failure modes of a pneumatic controller?";
	String titleMechProd = "What are the benefits and failure modes of U-cup (U-ring) or an O-ring Loaded U-cup?";
	
	
	public void searchWithPercentEquip(WebDriver driver, String keypercent, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-btn"))).click();
		try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		//Waits for black loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(2000);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
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
		//Waits for black loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }		
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
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-input"))).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbyid-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
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
	
	public void browseCaseNonAdminEquip(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
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
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		//verify no case id box
		verifyNoCaseIDSearchEquip (driver);
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
		try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		//Waits for black loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(2000);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownEquip(driver);
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
		//Waits for black loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }		
	}
	
	

}
