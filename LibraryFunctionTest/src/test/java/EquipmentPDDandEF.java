import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EquipmentPDDandEF {

	SoftAssertions softly = new SoftAssertions();	
	String keywordPDD = "QAAPDDTestSlides";
	String keywordEF = "QAAEFTestSlides";
	String titlePDD = "QAA PDD Test Slides";
	String titleEF = "QAA EF Test Slides";
	String keywordPDDie11 = "QAAPDDTestSlidesie11";
	String keywordEFie11 = "QAAEFTestSlidesie11";
	String titlePDDie11 = "QAA IE11 PDD Test Slides";
	String titleEFie11 = "QAA IE11 EF Test Slides";
	String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2018. Derivative Product Strictly Prohibited.";
	String keywordPDDDev ="SanityPDD";
	String keywordPDDDevPercent ="SanityPDD%";
	String keywordPDDDevSpcl ="SanityPDD./";
	String keywordEFDev ="SanityEF";
	String keywordEFDevPercent ="SanityEF%";
	String keywordEFDevSpcl ="SanityEF./";
	String keywordPDDProd = "packing friction force";
	String keywordPDDProdPercent = "90%";
	String keywordEFProd = "Ampere Electromagnetism Law";
	String keywordEFProdSpcl = "PM2.5 meter";
	String caseEFDev = "7450";
	String casePDDDev = "7890";
	String caseEFProd = "2014";
	String casePDDProd = "3005";
	String caseEFProdSpcl = "2017";
	String casePDDProdPercent = "3037";
	String titleEFDev = "Sanity: QAA Test (DO NOT DELETE)";
	String titlePDDDev = "Sanity: QAA Test (DO NOT DELETE)";
	String titleEFProd = "What is Faraday’s Law and Ampere’s Law?"+"\n";
	String titlePDDProd = "How do you reduce valve packing friction force?";
	
	public void searchWithPercent(WebDriver driver, String keypercent, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keypercent);
		if(identifier.equals(casePDDProdPercent))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		else
			clickDropdown(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void searchWithSpcl(WebDriver driver, String keyspcl, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyspcl);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void verifySearchOptions (WebDriver driver, String keyword, String identifier) throws Exception {
		
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
		clickDropdown(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void clickDropdown(WebDriver driver) throws Exception {
		
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
	
	public void verifyCaseModuleNames (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();	    
	    //Clicks on ErrorFree Bank
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Look for Human Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance")));
		//Look for Equipment Data Bank (Instructor Only)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Data Bank (Instructor Only)")));
		//Look for Electrical Failure modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Modes")));
		//Look for Mechanical failure modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Modes")));
		//Look for Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance")));
		//Look for Engineering Fundamentals
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engineering Fundamentals")));
	    //Look for Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prevention of Design Deficiencies")));
		//Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();	    
	}
	
	public void browseCaseID (WebDriver driver, String identifier, String title) throws Exception {
		
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
		previousBrowse(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void verifyNoCaseIDSearch (WebDriver driver) throws Exception {
		
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
	
	public void browseCaseNonAdmin(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
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
		if(keyword.equals(keywordPDDDev)||keyword.equals(keywordEFDev)||keyword.equals(keywordEFProd)||keyword.equals(keywordPDDProd))
		{
			//Click previous button to browse through case
			previousBrowse(driver,n,expected_title,identifier);
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		//verify no case id box
		verifyNoCaseIDSearch (driver);
	}
	
	public void browseCase(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
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
		if(keyword.equals(keywordPDDDev)||keyword.equals(keywordEFDev)||keyword.equals(keywordEFProd)||keyword.equals(keywordPDDProd))
		{
			//Click previous button to browse through case
			previousBrowse(driver,n,expected_title,identifier);
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void previousBrowse(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
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
	
	public void getEquipPerformancePIILink(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on ErrorFree Bank
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Equipment Performance Search PII
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-e-menu-equipPII"))).click();
	}
	
	public void getPDDLink(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on ErrorFree Bank
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prevention of Design Deficiencies"))).click();
	}
	
	public void getEFLink(WebDriver driver) throws Exception {
	
		WebDriverWait wait = new WebDriverWait(driver,40);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
	    //Clicks on Engineering Fundamentals
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engineering Fundamentals"))).click();
	}
	
	public String createCaseChrome(WebDriver driver, String keyword, String title) throws Exception{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Pick a Random number for case id
		Random random = new Random();
		String caseId="";
		while (true)
	    {
		  Thread.sleep(1000);
		  int y=random.nextInt(10000);
		  if(y<1000)
		     continue;
		  caseId = String.format("%d", y);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
		  Thread.sleep(1000);
		  Thread.sleep(1000);
		  WebElement errorCaseId;
		  try{
		  errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
		  }catch(org.openqa.selenium.NoSuchElementException e)
		  {
		  	break;
		  }
		  if(errorCaseId.isDisplayed()==true)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
			  continue;
		  }
		  if(errorCaseId.isDisplayed()==false)
			  break;
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
	    System.out.println("Case id: "+ caseId);
	    //Select Category
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-button"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-listbox")));
	    if(keyword.equals(keywordEF)||keyword.equals(keywordEFie11))
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engineering Fundamentals"))).click();
	    }
	    if(keyword.equals(keywordPDD)||keyword.equals(keywordPDDie11))
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prevention of Design Deficiencies"))).click();
	    }
	    try{
	    	driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
	    }catch (NoSuchElementException e)
		  {
		     driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a")).click();
		  }
	    catch (ElementNotInteractableException e1)
	    {
	    	driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a")).click();
	    }
	    //Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1700)");
		Thread.sleep(1000);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,2000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Uploads 5 slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))).click();
		Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
		p.waitFor();
		Thread.sleep(3000);
		//Checks if 5 images have been uploaded
		WebElement collapsible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a")));
		Actions act1 = new Actions(driver);
		act1.click(collapsible).build().perform();
		Thread.sleep(6000);
		int i;
		for (i=0; i<5;i++)
		{
		  String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
		  {
			  System.out.println("Uploaded Image : " + (i+1));
			  //list.add(driver.findElement(By.xpath(xpath)));
		  }
			  
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		return caseId;
	}
	
	public String createCaseFirefox(WebDriver driver, String keyword, String title) throws Exception{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Pick a Random number for case id
		Random random = new Random();
		String caseId="";
		while (true)
	    {
		  Thread.sleep(1000);
		  int y=random.nextInt(10000);
		  if(y<1000)
		     continue;
		  caseId = String.format("%d", y);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
		  Thread.sleep(1000);
		  Thread.sleep(1000);
		  WebElement errorCaseId;
		  try{
		  errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
		  }catch(org.openqa.selenium.NoSuchElementException e)
		  {
		  	break;
		  }
		  if(errorCaseId.isDisplayed()==true)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
			  continue;
		  }
		  if(errorCaseId.isDisplayed()==false)
			  break;
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
	    System.out.println("Case id: "+ caseId);
	    //Select Category
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-button"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-listbox")));
	    Thread.sleep(2000);
	    //Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-menu")));
	    if(keyword.equals(keywordEF)||keyword.equals(keywordEFie11))
	    {
	    	box.findElement(By.linkText("Engineering Fundamentals")).click();
	    }
	    if(keyword.equals(keywordPDD)||keyword.equals(keywordPDDie11))
	    {
	    	box.findElement(By.linkText("Prevention of Design Deficiencies")).click();
	    }
	    try{
	    	driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
	    }catch (NoSuchElementException e)
		  {
		     driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a")).click();
		  }
	    catch (ElementNotInteractableException e1)
	    {
	    	driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a")).click();
	    }
	    //Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1700)");
		Thread.sleep(1000);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,2000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Uploads 5 slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))).click();
		Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
		p.waitFor();
		Thread.sleep(3000);
		//Checks if 5 images have been uploaded
		WebElement collapsible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a")));
		Actions act1 = new Actions(driver);
		act1.click(collapsible).build().perform();
		Thread.sleep(6000);
		int i;
		for (i=0; i<5;i++)
		{
		  String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
		  {
			  System.out.println("Uploaded Image : " + (i+1));
			  //list.add(driver.findElement(By.xpath(xpath)));
		  }
			  
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		return caseId;
	}
	
	public String createCaseIE10(WebDriver driver, String keyword, String title) throws Exception{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Pick a Random number for case id
		Random random = new Random();
		String caseId="";
		while (true)
	    {
		  Thread.sleep(1000);
		  int y=random.nextInt(10000);
		  if(y<1000)
		     continue;
		  caseId = String.format("%d", y);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
		  Thread.sleep(1000);
		  Thread.sleep(1000);
		  WebElement errorCaseId;
		  try{
		  errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
		  }catch(org.openqa.selenium.NoSuchElementException e)
		  {
		  	break;
		  }
		  if(errorCaseId.isDisplayed()==true)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
			  continue;
		  }
		  if(errorCaseId.isDisplayed()==false)
			  break;
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
	    System.out.println("Case id: "+ caseId);
	    //Select Category
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-button"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-listbox")));
	    if(keyword.equals(keywordEF)||keyword.equals(keywordEFie11))
	    {
	    	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engineering Fundamentals")));
	    	Actions act = new Actions (driver);
	    	act.click(ele).build().perform();
	    }
	    if(keyword.equals(keywordPDD)||keyword.equals(keywordPDDie11))
	    {
	    	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prevention of Design Deficiencies")));
	    	Actions act = new Actions (driver);
	    	act.click(ele).build().perform();
	    }
	    try{
	    	WebElement ele = driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete"));
	    	Actions act = new Actions (driver);
	    	act.click(ele).build().perform();
	    }catch (NoSuchElementException e)
		  {
	    	WebElement ele = driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a"));
		     Actions act = new Actions (driver);
		     act.click(ele).build().perform();
		  }
	    catch (ElementNotInteractableException e1)
	    {
	    	WebElement ele = driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a"));
	    	Actions act = new Actions (driver);
	    	act.click(ele).build().perform();
	    }
	    //Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1700)");
		Thread.sleep(1000);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Uploads 5 slides
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input")));
		Actions act1 = new Actions(driver);
		act1.doubleClick(ele).build().perform();
		Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		p.waitFor();
		Thread.sleep(4000);
		//Checks if 5 images have been uploaded
		WebElement collapsible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a")));
		act1.click(collapsible).build().perform();
		Thread.sleep(6000);
		int i;
		for (i=0; i<5;i++)
		{
		  String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
		  {
			  System.out.println("Uploaded Image : " + (i+1));
			  //list.add(driver.findElement(By.xpath(xpath)));
		  }
			  
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		return caseId;
	}
	
	public String createCaseIE11(WebDriver driver, String keyword, String title) throws Exception{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Pick a Random number for case id
		Random random = new Random();
		String caseId="";
		while (true)
	    {
		  Thread.sleep(1000);
		  int y=random.nextInt(10000);
		  if(y<1000)
		     continue;
		  caseId = String.format("%d", y);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
		  Thread.sleep(1000);
		  Thread.sleep(1000);
		  WebElement errorCaseId;
		  try{
		  errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
		  }catch(org.openqa.selenium.NoSuchElementException e)
		  {
		  	break;
		  }
		  if(errorCaseId.isDisplayed()==true)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
			  continue;
		  }
		  if(errorCaseId.isDisplayed()==false)
			  break;
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
	    System.out.println("Case id: "+ caseId);
	    //Select Category
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-button"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-level-listbox")));
	    if(keyword.equals(keywordEF)||keyword.equals(keywordEFie11))
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engineering Fundamentals"))).click();
	    }
	    if(keyword.equals(keywordPDD)||keyword.equals(keywordPDDie11))
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prevention of Design Deficiencies"))).click();
	    }
	    try{
	    	driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
	    }catch (NoSuchElementException e)
		  {
		     driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a")).click();
		  }
	    catch (ElementNotInteractableException e1)
	    {
	    	driver.findElement(By.xpath(".//*[@id='pii-admin-efse-level-listbox']/div/a")).click();
	    }
	    //Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1700)");
		Thread.sleep(1000);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,2000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Uploads 5 slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))).click();
		Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		p.waitFor();
		Thread.sleep(4000);
		//Checks if 5 images have been uploaded
		WebElement collapsible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a")));
		Actions act1 = new Actions(driver);
		act1.click(collapsible).build().perform();
		Thread.sleep(6000);
		int i;
		for (i=0; i<5;i++)
		{
		  String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
		  {
			  System.out.println("Uploaded Image : " + (i+1));
			  //list.add(driver.findElement(By.xpath(xpath)));
		  }
			  
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		return caseId;
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
