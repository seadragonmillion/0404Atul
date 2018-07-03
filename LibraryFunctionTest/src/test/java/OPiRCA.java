import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCA {
	
	SoftAssertions softly = new SoftAssertions();
	String event_title = "Sanity Test";
	
	By DeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By OpenButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a");
	By DownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	By ShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]");
	By ShareTextBox = By.id("pii-uhshare-search-input");
	By ShareDropdown = By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul");
	By FirstSelectionUnderDropdown = By.cssSelector(".ui-first-child");
	By SharerAdded = By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a");
	By UserNameDisplayInReport = By.xpath(".//*[@id='opa-rpt']/div/table/tbody/tr[6]/td[2]");
	By ShareSaveButton = By.id("pii-uhshare-save");
	By OPiRCASidePanel = By.id("pii-user-home-panel-btn-opa");
	By MarkCritical = By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label");
	By OPIRCAMarkCriticalIndicatorText = By.xpath(".//*[@id='opa-rpt']/div/table/thead/tr/th/strong");
	By OPiRCASaveButton = By.id("efi-opa-button-save");
	By OPiRCASavePopupTitle = By.id("pii-opa-dialog-title");
	By OPiRCASaveConfirmButton = By.id("pii-opa-dialog-confirmed");
	By OPiRCASavedActivitiesButton = By.id("efi-opa-btn-savedactivities");
	By ConfirmPopupTitle = By.id("pii-user-home-dialog-title");
	By ConfirmPopupButton = By.id("pii-user-home-dialog-confirmed");
	By OPiRCAFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a");
	By StickyNote = By.className("sticky-note");
	By StickySuccess = By.className("sticky-success");
	
	By HiRCADropdownMenuPopup = By.id("pii-opa-step1-select-menu");
	By HiRCADropdownMenuButton = By.id("pii-opa-step1-select-button");
	By HiRCADropdownMenuCloseButton = By.xpath(".//*[@id='pii-opa-step1-select-dialog']/div/div[1]/a");
	
	By OPiRCANextButton = By.id("efi-opa-button-next");
	By OPiRCASkipButton = By.id("efi-opa-button-skip");
	By OPiRCAInfoTab = By.id("efi-opa-tab-0");
	By OPiRCAStep1Tab = By.id("efi-opa-tab-1");
	By OPiRCAStep3Tab = By.id("efi-opa-tab-3");
	By OPiRCANextButtonAtBottomOfInfoTab = By.xpath(".//*[@id='pii-opa-event-form']/div[12]/div/button");
	
	By OPiRCAReportCreationDateTimeField = By.id("pii-opa-event-repdatetime");
	By OPiRCAEventTitleField = By.id("pii-opa-event-title");
	By OPiRCAEventLocationField = By.id("pii-opa-event-location");
	By OPiRCAProblemStatementField = By.id("pii-opa-event-pbstatement");
	By OPiRCATimelineOfEventField = By.id("pii-opa-event-events");
	By OPiRCABackgroundInfoField = By.id("pii-opa-event-bginfos");
	By OPiRCAInvestigatorsField = By.id("pii-opa-event-investigators");
	
	By PageTitle = By.id("efi-opa-question");
	By SField = By.xpath(".//*[@id='efi-opa-answers']/div[1]");
	By UField = By.xpath(".//*[@id='efi-opa-answers']/div[2]");
	By RField = By.xpath(".//*[@id='efi-opa-answers']/div[3]");
	By EField = By.xpath(".//*[@id='efi-opa-answers']/div[4]");
	
	By OPiRCANoRCField1 = By.xpath(".//*[@id='opa-rpt']/div[4]/table/tbody/tr/td[1]");
	By OPiRCANoRCField2 = By.xpath(".//*[@id='opa-rpt']/div[4]/table/tbody/tr/td[2]");
	By OPiRCANoRCField3 = By.xpath(".//*[@id='opa-rpt']/div[4]/table/tbody/tr/td[3]");
	
	//Step1
	By Step1DescriptionPlusSign = By.xpath(".//*[@id='efi-opa-description']/h4/a");
	By Step1DescriptionText = By.id("efi-opa-description-text");

	public void deleteNewRecord(WebDriver driver,String recordName, int y) throws Exception{
		  		
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		  ShareCheck obj1 = new ShareCheck();
		  //Clicks on first newly created record
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();
	      obj1.loadingServer(driver);
		  //Clicks on delete button
		  driver.findElement(DeleteButton).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(StickyNote));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(OPiRCAFirstRecord).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  //Verify report not retrieved by shared to person
	      ErrorMeter obj = new ErrorMeter();
		  String sharer = obj.decideSharer (y);
		  obj1.checkNoReportAfterDelete(driver, sharer, softly);
	  }


	  public void openReport(WebDriver driver) throws Exception{

		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		  ShareCheck obj = new ShareCheck();
		  //Clicks on Open button	    	
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(OpenButton)).click();
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	      //Clicks on open report
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	      //Clicks on Save
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASaveButton)).click();
		  //Clicks on Save report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASavePopupTitle)).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASaveConfirmButton)).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(StickySuccess));
		  //Wait for loading message
		  obj.loadingServer(driver);
		  Thread.sleep(1000);
	      //Clicks on Saved activities
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASavedActivitiesButton)).click();
		  Thread.sleep(2000);		  
		  //Wait for loading message
		  obj.loadingServer(driver);
	  }
	  
	  public void downloadRecordChrome(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ShareCheck obj = new ShareCheck();			
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();
	    	//Wait for loading message
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(8000);
	    	pdfCheck(hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
	    	for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    }
	        driver.close();
	    	driver.switchTo().window(window);
	    	Thread.sleep(1000);	    		    	
	    }
	  
	  public void downloadRecordFirefox(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ShareCheck obj = new ShareCheck();
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();
	    	//Wait for loading message to disappear			
			obj.loadingServer(driver);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear			
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(8000);
	    	for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
	    	Thread.sleep(2000);
	    	//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s"));
	    	Robot robot = new Robot();
	    	// press Ctrl+S the Robot's way
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_S);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_S);
	    	Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
	    	p.waitFor();
	    	pdfCheck(hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
	    	Thread.sleep(4000);
	    	driver.close();
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    }
	    
	    public void downloadRecordIE10(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ShareCheck obj = new ShareCheck();
			//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();
	    	//Wait for loading message to disappear			
			obj.loadingServer(driver);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(3000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }
	    	Thread.sleep(7000);
	    	//pdf verification
		    pdfCheck(hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
		    Thread.sleep(4000);
	    	//Switch to window    	
	    	driver.switchTo().window(window);	
	    }
	    
	    public void downloadRecordIE11(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ShareCheck obj = new ShareCheck();
			//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();
	    	//Wait for loading message to disappear			
			obj.loadingServer(driver);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(3000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }
	    	Thread.sleep(7000);
	    	//pdf verification
		    pdfCheck(hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
		    Thread.sleep(4000);
	    	//Switch to window    	
	    	driver.switchTo().window(window);
	    }
	    
		public void pdfCheck(List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception{
	    	
			// specify your directory
	    	Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
	    	// here we get the stream with full directory listing
	    	// exclude subdirectories from listing
	    	// finally get the last file using simple comparator by lastModified field
	    	Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
	    	System.out.println(lastFilePath.get());
	    	//Loads the file to check if correct data is present
		    String fileName=lastFilePath.get().toString();
		    File oldfile = new File(fileName);
		    PDDocument pddoc= PDDocument.load(oldfile);
		    //Checks text in pdf
		    String data = new PDFTextStripper().getText(pddoc);
		    List<String> ans= Arrays.asList(data.split("\r\n"));
		    String newData1="";
		    for (int i = 0; i < ans.size(); i++)
		        {	        	
		        	int n=ans.get(i).length()-1;
		        	if (ans.get(i).charAt(n)==' ')
		        		newData1 = newData1+ans.get(i);
		        	else if (ans.get(i).charAt(n)!=' ')
		        		newData1 = newData1+" "+ans.get(i);	        	
		        }
		    newData1 = newData1.replace("  ", " ");
		    System.out.println(newData1);
		    //Verify all lists present in pdf
		    for(int i=0;i<hircaNewList.size();i++)
		    {
		    	//Add : 		    	
    			int m = hircaNewList.get(i).indexOf(" ");
    			if(Character.isDigit(hircaNewList.get(i).charAt(m-1))==true)
    			{
    				String s = hircaNewList.get(i).substring(0, m)+": "+hircaNewList.get(i).substring(m+1, hircaNewList.get(i).length());
        			softly.assertThat(newData1).as("test data").contains(s);
    			}    			
		    }
		    for(int i=0;i<apparentCausesNew.size();i++)
		    {
		    	softly.assertThat(newData1).as("test data").contains(apparentCausesNew.get(i));
		    }
		    for(int i=0;i<apparentCausesAnswersNew.size();i++)
		    {
		    	softly.assertThat(newData1).as("test data").contains(apparentCausesAnswersNew.get(i));
		    }
		    //Check HML order for root cause
		    checkOrderHMLRC(hml,options,newData1);
		    //Check HML order for contributing factor
		    int n = apparentCausesAnswersNew.size();
		    int cf = n-options.get("Root causes");
		    checkOrderHMLCF(hml,options,newData1,cf);
		    //Close pdf
		    pddoc.close();
		}
		
		public void checkOrderHMLCF(HashMap<String,String> hml, HashMap<String,Integer> options, String newData1, int cf) {
			
			
			if(cf>0)
	    	   {
	    		   List<Integer> high = new ArrayList<Integer>();
	    		   List<Integer> medium = new ArrayList<Integer>();
	    		   List<Integer> low = new ArrayList<Integer>();
	    		   List<Integer> none = new ArrayList<Integer>();
	    		   for (Map.Entry<String, Integer> e : options.entrySet())
	    		   {
	    			   //If it has 4 ticks in SURE then its a RC
	    			   if(e.getValue()!=4)
	    			   {
	    				   String s2 = e.getKey();
	    				   //Remove first : from options answer
	    				   int m = s2.indexOf(":");
	    				   if(m==-1)
	    					   continue;
	   	    			   String s = s2.substring(0, m)+s2.substring(m+1, s2.length());
	    				   if(hml.get(s)=="High")
	    				   {
	    					   if(newData1.indexOf(s+ " High")>-1)
	    						   high.add(newData1.indexOf(s+ " High"));
	    					   if(newData1.indexOf(s+ "\n"+"High")>-1)
	    						   high.add(newData1.indexOf(s+ "\n"+"High"));
	    				   }
	    				   if(hml.get(s)=="Medium")
	    				   {
	    					   if(newData1.indexOf(s+ " Medium")>-1)
	    						   high.add(newData1.indexOf(s+ " Medium"));
	    					   if(newData1.indexOf(s+ "\n"+"Medium")>-1)
	    						   high.add(newData1.indexOf(s+ "\n"+"Medium"));
	    				   }
	    				   if(hml.get(s)=="Low")
	    				   {
	    					   if(newData1.indexOf(s+ " Low")>-1)
	    						   high.add(newData1.indexOf(s+ " Low"));
	    					   if(newData1.indexOf(s+ "\n"+"Low")>-1)
	    						   high.add(newData1.indexOf(s+ "\n"+"Low"));
	    				   }
	    				   if(hml.get(s)=="")
	    				   {
	    					   none.add(newData1.indexOf(s));
	    				   }
	    			   }    			   
	    		   }
	    		   //Sort the lists
	    		   Collections.sort(high);
	    		   Collections.sort(medium);
	    		   Collections.sort(low);
	    		   Collections.sort(none);
	    		   System.out.println(high);
		    	   System.out.println(medium);
		    	   System.out.println(low);
		    	   System.out.println(none);
		    	   //Verify the importance order
		    		if(medium.size()>0 && high.size()>0)
		    		{
		    			if(high.get(high.size()-1)>medium.get(0))
		    				softly.fail("Medium cf are before High cf");
		    		}
		    			
		    		if(low.size()>0 && medium.size()>0)
		    		{
		    			if(medium.get(medium.size()-1)>low.get(0))
		    				softly.fail("Low cf are before Medium cf");
		    		}
		    		if(none.size()>0 && low.size()>0)
		    		{
		    			if(low.get(low.size()-1)>none.get(0))
		    				softly.fail("None cf are before Low cf");
		    		}
	    	   }
		}
		
		public void checkOrderHMLRC(HashMap<String,String> hml, HashMap<String,Integer> options, String newData1) {
			
			if(options.get("Root causes")>0)
	    	{
	    		List<Integer> high = new ArrayList<Integer>();
	    		List<Integer> medium = new ArrayList<Integer>();
	    		List<Integer> low = new ArrayList<Integer>();
	    		List<Integer> none = new ArrayList<Integer>();
	    		for (Map.Entry<String, Integer> e : options.entrySet())
	    		{
	    		   //If it has 4 ticks in SURE then its a RC
	    		   if(e.getValue()==4)
	    		   {
	    			   String s2 = e.getKey();
    				   //Remove first : from options answer
    				   int m = s2.indexOf(":");
    				   if(m==-1)
    					   continue;
   	    			   String s = s2.substring(0, m)+s2.substring(m+1, s2.length());
   	    			if(hml.get(s)=="High")
 				   {
 					   if(newData1.indexOf(s+ " High")>-1)
 						   high.add(newData1.indexOf(s+ " High"));
 					   if(newData1.indexOf(s+ "\n"+"High")>-1)
 						   high.add(newData1.indexOf(s+ "\n"+"High"));
 				   }
 				   if(hml.get(s)=="Medium")
 				   {
 					   if(newData1.indexOf(s+ " Medium")>-1)
 						   high.add(newData1.indexOf(s+ " Medium"));
 					   if(newData1.indexOf(s+ "\n"+"Medium")>-1)
 						   high.add(newData1.indexOf(s+ "\n"+"Medium"));
 				   }
 				   if(hml.get(s)=="Low")
 				   {
 					   if(newData1.indexOf(s+ " Low")>-1)
 						   high.add(newData1.indexOf(s+ " Low"));
 					   if(newData1.indexOf(s+ "\n"+"Low")>-1)
 						   high.add(newData1.indexOf(s+ "\n"+"Low"));
 				   }
 				   if(hml.get(s)=="")
 				   {
 					   none.add(newData1.indexOf(s));
 				   }	    			   
	    		   }    		    		   
	    		}
	    		//Sort the lists
	    		Collections.sort(high);
	    		Collections.sort(medium);
	    		Collections.sort(low);
	    		Collections.sort(none);
	    		System.out.println(high);
	    		System.out.println(medium);
	    		System.out.println(low);
	    		System.out.println(none);
	    		//Verify the importance order
	    		if(medium.size()>0 && high.size()>0)
	    		{
	    			if(high.get(high.size()-1)>medium.get(0))
	    				softly.fail("Medium rc are before High rc");
	    		}	    			
	    		if(low.size()>0 && medium.size()>0)
	    		{
	    			if(medium.get(medium.size()-1)>low.get(0))
	    				softly.fail("Low rc are before Medium rc");
	    		}
	    		if(none.size()>0 && low.size()>0)
	    		{
	    			if(low.get(low.size()-1)>none.get(0))
	    				softly.fail("None rc are before Low rc");
	    		}
	    	}
		}
	    
	    public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	 
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareButton)).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareTextBox)).sendKeys(sharer);
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareDropdown));
			dropdown.findElement(FirstSelectionUnderDropdown).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(SharerAdded)).getText();
			softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
			ShareCheck obj1 = new ShareCheck();
			obj1.shareTwice (driver);
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareSaveButton)).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
			 //Checks the username of creator
			 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(UserNameDisplayInReport));
			 String creatorUsername= creator.getText();
			 System.out.println(creatorUsername);
			 softly.assertThat(creatorUsername).as("test data").isEqualTo(username);
			//Calls the Share check function
			obj1.receiptReport(driver, sharer, username, password1);
			//Clicks on OPiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASidePanel)).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
		    //Clicks on first newly created record
			wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();
	    }
	    
	    public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(MarkCritical)).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(OPIRCAMarkCriticalIndicatorText)).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(OPIRCAMarkCriticalIndicatorText).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(MarkCritical)).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			Thread.sleep(2000);
			if(driver.findElement(OPIRCAMarkCriticalIndicatorText).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
			//Verify report not retrieved by shared to person
		    ErrorMeter obj = new ErrorMeter();
			String sharer = obj.decideSharer (y);
			ShareCheck obj1 = new ShareCheck();
			obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
			//Clicks on O&PiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASidePanel)).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);	    					
	    }
	    
	    public List<String> selectHiRCALevel3(WebDriver driver) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	//Choose a number between 0 to 31 for number of selections
	    	Random random = new Random();
	    	int n = random.nextInt(32);
	    	//Create a List to store HiRCA selections
	    	List<String> hircaL3 = new ArrayList<String>();
	    	for(int i=1;i<=n;i++)
	    	{
	    		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCADropdownMenuPopup));
	    		int y;
	    		//Choose a number between 1 and 31
	    		while(true)
	    		{
	    			y = random.nextInt(32);
	    			//if option is already checked then choose another number
	    			String s1 = ele.findElement(By.xpath(".//*[@data-option-index='"+y+"']/a")).getAttribute("class");
	    			if(y<1)
	    				continue;	    			
	    			else if(s1.contains("ui-checkbox-on"))
	    				continue;
	    			else 
	    				break;
	    		}	    		
	    		WebElement l = ele.findElement(By.xpath(".//*[@data-option-index='"+y+"']/a"));
	    		//Scroll to element
	    		Point p = l.getLocation();
	    		int yaxis= p.getY()-250;
	    		Thread.sleep(2000);
	    		jse.executeScript("scroll(0,"+yaxis+")");
	    		Thread.sleep(2000);
	    		//Click on option
	    		l.click();
	    		//Store selection name in list
	    		String s = l.getText();
	    		hircaL3.add(s);
	    	}
	    	//Scroll to the top
	    	Thread.sleep(2000);
    		jse.executeScript("scroll(0,0)");
    		Thread.sleep(2000);
	    	//Close the pop up
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCADropdownMenuCloseButton)).click();	    	
	    	return hircaL3;
	    }
	    
	    
	    public List<String> storeApparentCauses(WebDriver driver) throws Exception{
	    	
	    	//Create a List to store apparent causes
	    	List<String> ac = new ArrayList<String>();
	    	int i=1;
	    	while(true)
	    	{
	    		try{
	    			String s = driver.findElement(By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li["+i+"]")).getText();
	    			ac.add(s);
	    			i=i+1;
	    		}catch(NoSuchElementException e)
	    		{
	    			break;
	    		}
	    	}	    	
	    	return ac;
	    }
	    
	    public List<String> selectApparentCausesAnswers(WebDriver driver,List<String> apparentCauses) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	//Create a list to store any apparent cause answer selected
	    	List<String> ac = new ArrayList<String>();
	    	for(int i=0;i<apparentCauses.size();i++)
	    	{
	    		//Check the description collapsible 
		    	collapsibleCheckDescription(driver);
	    		int count =0;
	    		int k=1;
	    		//Identify number of answers for an apparent cause
	    		while(true)
	    		{
	    			try{
	    				String s = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/div["+k+"]")).getAttribute("class");
	    				k=k+1;
	    				if(s.equals("ui-contain"))
	    					count = count +1;
	    			}catch(NoSuchElementException e)
	    			{
	    				break;
	    			}
	    		}
	    		int x;
	    		//Select number of options to select
	    		while(true)
	    		{
	    			Random random = new Random();
	    			x=random.nextInt(count+1);
	    			if(x==0)
	    				continue;
	    			else break;
	    		}
	    		for(int j=0;j<x;j++)
	    		{
	    		//Select any answer between 1 and count
	    		//Choose a number between 1 and count
	    		int y;
	    		while(true)
	    		{
	    			Random random = new Random();
	    			y=random.nextInt(count+1);
	    			if(y==0)
	    				continue;
	    			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div/input")));
	    			if(e.isSelected())
	    				continue;
	    			break;	    			
	    		}
	    		//Click on answer
	    		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div/label")));
	    		//Scroll to element
	    		Point p = l.getLocation();
	    		int yaxis= p.getY()-250;
	    		Thread.sleep(1000);
	    		jse.executeScript("scroll(0,"+yaxis+")");
	    		Thread.sleep(1000);
	    		l.click();
	    		//Get answer name and store in list
	    		String s1 = l.getText();
	    		ac.add(s1);
	    		//Check if Evidence entry and Possible corrective action are in collapsible form
	    		checkCollapsibleEvidenceEntryPossibleCorrectiveAction(driver,y);
	    		}
	    		//Scroll to top
	    		Thread.sleep(2000);
	    		jse.executeScript("scroll(0,0)");
	    		Thread.sleep(2000);
	    		//Click on next
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANextButton)).click();
	    	}	    	
	    	return ac;
	    }
	    
	    public void checkCollapsibleEvidenceEntryPossibleCorrectiveAction(WebDriver driver,int y) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Verify Evidence Entry text not visible
	    	try{
	    		WebElement l = driver.findElement(By.id("efi-opa-evidence-text-"+(y-1)));
	    		if(l.isDisplayed()==true)
	    			softly.fail("Evidence Entry text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No Evidence Entry visible as the + sign for Evidence Entry has not been clicked");
	    	}
	    	//Click on Evidence Entry
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-evidence-text-div-"+(y-1)+"']/h4/a"))).click();
	    	//Verify Evidence Entry text
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-evidence-text-"+(y-1))));
	    	//Click on Evidence Entry again
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-evidence-text-div-"+(y-1)+"']/h4/a"))).click();
	    	//Verify Evidence Entry text not visible
	    	try{
	    		WebElement l = driver.findElement(By.id("efi-opa-evidence-text-"+(y-1)));
	    		if(l.isDisplayed()==true)
	    			softly.fail("Evidence Entry text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
	    	}
	    	
	    	//Verify Possible Corrective Action text not visible
	    	try{
	    		WebElement l = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div"));
	    		if(l.isDisplayed()==true)
	    			softly.fail("Possible Corrective Action text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No Possible Corrective Action text visible as the + sign for Possible Corrective Action has not been clicked");
	    	}
	    	//Click on Possible Corrective Action 
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
	    	//Verify Possible Corrective Action text
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div")));
	    	//Click on Possible Corrective Action again
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
	    	//Verify Possible Corrective Action text not visible
	    	try{
	    		WebElement l = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div"));
	    		if(l.isDisplayed()==true)
	    			softly.fail("Possible Corrective Action text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No Possible Corrective Action text visible as the + sign for Possible Corrective Action has not been clicked");
	    	}
	    }
	    
	    public List<String> modifyList(List<String> apparentCausesAnswers)  throws Exception{
	    	
	    	List<String> ac = new ArrayList<String>();
	    	for(int i=0;i<apparentCausesAnswers.size();i++)
	    	{
	    		String s = apparentCausesAnswers.get(i).trim();
	    		s=s.replace("]", ":");
	    		s=s.replace("[", "");
	    		ac.add(s);
	    	}	    	
	    	return ac;
	    }
	    
	    public void verifyApparentCauses(WebDriver driver,List<String> apparentCausesAnswers) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Remove [ ] and spaces from list
	    	List<String> ac = modifyList(apparentCausesAnswers);
	    	for(int i=1;i<=apparentCausesAnswers.size();i++)
	    	{
	    		//Get text of answer in Step 3 under SURE
	    		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+(i+1)+"]/td[1]"))).getText();
	    		if(ac.contains(s)==false)
	    			softly.fail("Apparent cause selected not present: "+s);
	    	}
	    }
	    
	    public Map<String, List<String>> opircaHiRCAApparentCauseList() throws Exception {
	    	
	    	Map<String, List<String>> map = new HashMap<String, List<String>>();
	    	//3.1
	    	List<String> l31= new ArrayList<>(Arrays.asList("O5: Inadequate individual skills, rule use, or knowledge","OP1: Inadequate commitment to implementation","P1: Omission of program","P2: Inadequate all-inclusiveness"));
	    	map.put("3.1 Individual specific", l31);
	    	//3.2
	    	map.put("3.2 Supervisor specific", l31);
	    	//3.3.1
	    	List<String> l331= new ArrayList<>(Arrays.asList("O1: Inadequate organizational function or structure","OP1: Inadequate commitment to implementation"));
	    	map.put("3.3.1 Inadequate resource allocation in the manager's group, by the manager", l331);	  
	    	//3.3.2
	    	List<String> l332= new ArrayList<>(Arrays.asList("OP1: Inadequate commitment to implementation"));
	    	map.put("3.3.2 Inadequate provision of needed training in the manager's group, by the manager", l332);
	    	//3.3.3
	    	List<String> l333= new ArrayList<>(Arrays.asList("OP4: Inadequate ORRA"));
	    	map.put("3.3.3 Inadequate accountability system in the manager's group, by the manager", l333);
	    	//3.3.4
	    	List<String> l334= new ArrayList<>(Arrays.asList("O3: Inadequate process design and improvement capabilities","P1: Omission of program","P2: Inadequate all-inclusiveness"));
	    	map.put("3.3.4 Inadequate prioritization and planning of work in the manager's group, by the manager", l334);
	    	//3.3.5
	    	List<String> l335= new ArrayList<>(Arrays.asList("O1: Inadequate organizational function or structure","P1: Omission of program","P2: Inadequate all-inclusiveness"));
	    	map.put("3.3.5 Inadequate standard setting by the manager in (1) behavior (2) procedure and LOPs", l335);
	    	//3.3.6
	    	List<String> l336= new ArrayList<>(Arrays.asList("OP2: Inadequate performance monitoring and trending"));
	    	map.put("3.3.6 Inadequate performance monitoring and trending in the manager's group", l336);
	    	//3.3.7
	    	List<String> l337= new ArrayList<>(Arrays.asList("OO1: Inadequate common goals/interests/accountability","OO2: Inadequate interface between organizations","OO3: Overlapping or omission of work functions between two interfacing organizations"));
	    	map.put("3.3.7 Inadequate establishment of common goals, common interests, and common accountability for team work in the manager's group", l337);
	    	//3.3.8
	    	List<String> l338= new ArrayList<>(Arrays.asList("P2: Inadequate all-inclusiveness"));
	    	map.put("3.3.8 Inadequate corrective actions program in the manager's group", l338);
	    	//3.3.9
	    	List<String> l339= new ArrayList<>(Arrays.asList("O4: Inadequate communication within organization"));
	    	map.put("3.3.9 Inadequate vertical communication system in the manager's group", l339);
	    	//3.3.10
	    	map.put("3.3.10 Inadequate lateral communication in the manager's group", l339);
	    	//3.4
	    	map.put("3.4 Inadequate critical thinking and questioning", l31);
	    	//3.5
	    	map.put("3.5 Inadequate situation awareness", l31);
	    	//3.6
	    	List<String> l36= new ArrayList<>(Arrays.asList("P1: Omission of program","P2: Inadequate all-inclusiveness"));
	    	map.put("3.6 Inadequate \"all-inclusiveness\"", l36);
	    	//3.7
	    	List<String> l37= new ArrayList<>(Arrays.asList("P3: Inadequate bypass control"));
	    	map.put("3.7 Inadequate bypass control", l37);
	    	//3.8
	    	List<String> l38= new ArrayList<>(Arrays.asList("P4: Inadequate clarity or incorrectness"));
	    	map.put("3.8 Inadequate clarity", l38);
	    	//3.9
	    	List<String> l39= new ArrayList<>(Arrays.asList("OP1: Inadequate commitment to implementation"));
	    	map.put("3.9 Inadequate training", l39);
	    	//3.10
	    	map.put("3.10 Inadequate qualification", l39);
	    	//3.11
	    	List<String> l311= new ArrayList<>(Arrays.asList("OP2: Inadequate performance monitoring and trending","OP4: Inadequate ORRA"));
	    	map.put("3.11 Inadequate job accountability", l311);
	    	//3.12
	    	List<String> l312= new ArrayList<>(Arrays.asList("O3: Inadequate process design and improvement capabilities","P5: Excessive requirements"));
	    	map.put("3.12 Contributing factor for \"perceived burden\"", l312);
	    	//3.13
	    	map.put("3.13 Contributing factor for \"undue motivation\"", l31);
	    	//3.14
	    	List<String> l314= new ArrayList<>(Arrays.asList("O4: Inadequate communication within organization","OP4: Inadequate ORRA"));
	    	map.put("3.14 Contributing factor for \"low perceived risk\"", l314);
	    	//3.15
	    	List<String> l315= new ArrayList<>(Arrays.asList("O5: Inadequate individual skills, rule use, or knowledge","OP1: Inadequate commitment to implementation","P1: Omission of program"));
	    	map.put("3.15 Contributing factors for inadequate peer coaching (assistance)", l315);
	    	//3.16
	    	map.put("3.16 Contributing factor for inattention-to-detail", l31);
	    	//3.17
	    	List<String> l317= new ArrayList<>(Arrays.asList("OP1: Inadequate commitment to implementation","P1: Omission of program","P2: Inadequate all-inclusiveness"));
	    	map.put("3.17 QTM - equipment qualification, testing and maintenance", l317);
	    	//3.18
	    	map.put("3.18 Knowledge-based errors", l31);
	    	//3.19
	    	map.put("3.19 Inadequate engagement at TO, PJB or MJB", l317);
	    	//3.20
	    	map.put("3.20 HiRCA™ technology", l338);
	    	//3.21
	    	map.put("3.21 High Risk Situations (TAPE", l31);
	    	//3.22
	    	List<String> l322= new ArrayList<>(Arrays.asList("OP2: Inadequate performance monitoring and trending","OP3: Inadequate self evaluation or assessment","P4: Inadequate clarity or incorrectness"));
	    	map.put("3.22 Incorrect Rules", l322);
	    	return map;
	    }
	    
	    public void verifyCorrespondingApparentCauses(WebDriver driver,List<String> hircaL3,List<String> apparentCauses) throws Exception{
	    	
	    	//Get Map with HiRCA and its corresponding Apparent causes
	    	Map<String, List<String>> map= opircaHiRCAApparentCauseList();
	    	for(int i=0;i<hircaL3.size();i++)
	    	{
	    		//for 3.21 it didn't recognise superscript 3.21 High Risk Situations (TAPE
	    		if(hircaL3.get(i).startsWith("3.21"))
	    			apparentCauses.containsAll(map.get("3.21 High Risk Situations (TAPE"));
	    		else
	    			apparentCauses.containsAll(map.get((hircaL3).get(i)));
	    	}	    	
	    }
	    
	    public List<String> modifyStep1(WebDriver driver, List<String> hircaL3) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	//create a new list without the unselected hirca level 3 option
	    	List<String> hircaNewList = new ArrayList<String>(hircaL3);
	    	//Click on Step 1 tab
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep1Tab)).click();
	    	if(hircaL3.size()<0)
	    	{
	    		return hircaNewList;
	    	}
	    	//Click on dropdown field
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCADropdownMenuButton)).click();
	    	//Choose a number between 0 and hircaL3.size()-1
	    	Random random = new Random();
	    	int n = random.nextInt(hircaL3.size());
	    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(hircaL3.get(n))));
	    	//Scroll to element
    		Point p = l.getLocation();
    		int yaxis= p.getY()-250;
    		Thread.sleep(2000);
    		jse.executeScript("scroll(0,"+yaxis+")");
    		Thread.sleep(2000);
	    	//Unselect the chosen HiRCA level 3 option
	    	l.click();
	    	//Scroll to the top
	    	Thread.sleep(2000);
    		jse.executeScript("scroll(0,0)");
    		Thread.sleep(2000);
	    	//Close the pop up
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCADropdownMenuCloseButton)).click();
	    	//remove the unselected option from list
	    	hircaNewList.remove(n);
	    	return hircaNewList;
	    }
	    
	    public List<String> getOnlyNumberOfApparentCauses(List<String> apparentCausesNew) throws Exception{
	    	
	    	List<String> ac = new ArrayList<String>();
	    	for(int i=0;i<apparentCausesNew.size();i++)
	    	{
	    		//Get index of :
	    		int n = apparentCausesNew.get(i).indexOf(":");
	    		//get only number of the apparent cause
	    		String s = apparentCausesNew.get(i).substring(0, n);
	    		//Add to list
	    		ac.add(s);
	    	}	    	
	    	return ac;
	    }
	    
	    public List<String> verifyModifiedStep3(WebDriver driver, List<String> apparentCausesNew) throws Exception{
	    	
	    	//Get first few characters in apparent causes and store in a list
	    	List<String> ac = getOnlyNumberOfApparentCauses(apparentCausesNew);
	    	//Create list to store the new list for apparent cause answers
	    	List<String> ac1 = new ArrayList<String>();
	    	//Get text of answer in Step 3 under SURE
	    	int i=2;
	    	while(true)
	    	{
	    		try{
	    			//Get text of apparent cause answer
	    			String s = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]")).getText();
	    			//Remove first appearing : and store in list
	    			int m = s.indexOf(":");
	    			if(Character.isDigit(s.charAt(m-1))==true)
	    			{
	    				String s2 = s.substring(0, m)+s.substring(m+1, s.length());
	    				ac1.add(s2);
	    			}
	    			i=i+1;
	    			int n = s.indexOf(".");
	    			//Gets only apparent cause name from answer
	    			String s1 = s.substring(0, n);
	    			if(ac.contains(s1)==false)
	    				softly.fail("Apparent cause unselected is still present: "+s);	    			
	    		}catch(NoSuchElementException e)
	    		{
	    			break;
	    		}
	    	}	    	
	    	return ac1;
	    }
	    
	    public void verifyHTML(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			//Clicks on first newly created record
		    wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAFirstRecord)).click();	
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Number of root cause and contributing factors
			int rc,cf;
			if(apparentCausesAnswersNew.size()>0)
			{
				rc = options.get("Root causes");
				//Get number of contributing factors
				cf = apparentCausesAnswersNew.size()-rc;				
			}
			else
			{
				rc=0;
				cf=0;
			}
			//When no root causes present
			if (rc==0)
			{
				//Verify Root cause as n/a
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANoRCField1)).getText();
				softly.assertThat(s).as("test data").isEqualTo("n/a");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANoRCField2)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("n/a");
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANoRCField3)).getText();
				softly.assertThat(s2).as("test data").isEqualTo("n/a");		
			}
			//Also checks if High Medium Low order is correct in Level 3 answers
			int b=4;
			//When root cause is present
			for (int i=4;i<=rc+3;i++)
			{
				//Get name of level 3 answer
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+i+"]/table[1]/tbody/tr/td[1]"))).getText();
				//Verify if this level 3 answer was selected
				if(apparentCausesAnswersNew.contains(s)==false)
				{
					softly.fail("Apparent cause answer is not suppose to be here: "+s);
				}
				//Add : 
				int m = s.indexOf(" ");
    			if(Character.isDigit(s.charAt(m-1))==true)
    			{
    				String s1 = s.substring(0, m)+": "+s.substring(m+1, s.length());
    				//Check if it has 4 boxes ticked
    				if(options.get(s1)!=4)
    				{
    					softly.fail("Not a root cause, Not all four boxes are ticked, only some are: "+ options.get(s));
    				}
    				
    			}  
				//Get importance and verify
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+i+"]/table[1]/tbody/tr/td[2]"))).getText();
				//Verify high medium low
				softly.assertThat(s1).as("test data").isEqualTo(hml.get(s));	
				//Verify order of High Medium Low
				if(s1.equals("High"))
				  {
					  if(b>3||b==3)
					  {
						  b=3;
						  System.out.println("Order is correct:High");
					  }
					  if(b<3)
						  softly.fail("Currently in High Block: Order is wrong");
				  }
				if(s1.equals("Medium"))
				  {
					  if(b>2||b==2)
					  {
						  b=2;
						  System.out.println("Order is correct:Medium");
					  }
					  if(b<2)
						  softly.fail("Currently in Medium Block: Order is wrong");
				  }
				if(s1.equals("Low"))
				  {
					  if(b>1||b==1)
					  {
						  b=1;
						  System.out.println("Order is correct:Low");
					  }
					  if(b<1)
						  softly.fail("Currently in Low Block: Order is wrong");
				  }
				if(s1.equals("")||s1==""||s1.equals(null))
				  {
					  if(b>0||b==0)
					  {
						  b=0;
						  System.out.println("Order is correct:None");
					  }
					  if(b<0)
						  softly.fail("Currently in None Block: Order is wrong");
				  }
			}
			if(rc==0)
			{
				//Because there will be a div with Root Cause as n/a
				rc=rc+1;
			}	
			//When no contributing factors present
			if(cf==0)
			{
				//Verify Contributing factors as n/a
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("n/a");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[2]"))).getText();
				softly.assertThat(s1).as("test data").isEqualTo("n/a");
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[3]"))).getText();
				softly.assertThat(s2).as("test data").isEqualTo("n/a");					
			}
			//When contributing factors are present
			int i=1;
			b=4;
			while(i<=cf)
			{
				//Get name of level 3 answer
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[1]"))).getText();
				//Verify if this level 3 answer was selected
				if(apparentCausesAnswersNew.contains(s)==false)
				{
					softly.fail("Apparent cause answer is not suppose to be here: "+s);
				}
				//Add : 
				int m = s.indexOf(" ");
    			if(Character.isDigit(s.charAt(m-1))==true)
    			{
    				String s1 = s.substring(0, m)+": "+s.substring(m+1, s.length());
    				//Check if it has 4 boxes ticked
    				if(options.get(s1)==4)
    				{
    					softly.fail("Not a contributing factor, All four boxes are ticked, only some should be: "+ options.get(s));
    				}    				
    			} 				
				//Get importance and verify
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getText();
				//Verify high medium low
				softly.assertThat(s1).as("test data").isEqualTo(hml.get(s));
				//Increase i for next cf
				i=i+1;
				//Verify order of High Medium Low
				if(s1.equals("High"))
				  {
					  if(b>3||b==3)
					  {
						  b=3;
						  System.out.println("Order is correct:High");
					  }
					  if(b<3)
						  softly.fail("Currently in High Block: Order is wrong");
				  }
				if(s1.equals("Medium"))
				  {
					  if(b>2||b==2)
					  {
						  b=2;
						  System.out.println("Order is correct:Medium");
					  }
					  if(b<2)
						  softly.fail("Currently in Medium Block: Order is wrong");
				  }
				if(s1.equals("Low"))
				  {
					  if(b>1||b==1)
					  {
						  b=1;
						  System.out.println("Order is correct:Low");
					  }
					  if(b<1)
						  softly.fail("Currently in Low Block: Order is wrong");
				  }
				if(s1.equals("")||s1==""||s1.equals(null))
				  {
					  if(b>0||b==0)
					  {
						  b=0;
						  System.out.println("Order is correct:None");
					  }
					  if(b<0)
						  softly.fail("Currently in None Block: Order is wrong");
				  }
			}
			//Create a list
			List<String> list1 = new ArrayList<String>();
			//Verify Selected HiRCA Results
			i=1;
			while (true)
			{
				try{
					String s = driver.findElement(By.xpath(".//*[@id='opa-rpt']/div["+(rc+5)+"]/table/tbody/tr[1]/td[1]/ul/li["+i+"]")).getText();
					//Remove first appearing : and store in list, since hirca new list doesnt have : after the numbering
	    			int m = s.indexOf(":");
	    			String s1 = s.replace(Character.toString(s.charAt(m)), "");
					list1.add(s1);
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			//Verify if Selected HiRCA Results list is same as new hirca list
			softly.assertThat(list1).as("test data").containsAll(hircaNewList);
			//Empty list1
			list1.clear();
			//Verify Apparent O&P causes
			i=1;
			while (true)
			{
				try{
					String s = driver.findElement(By.xpath(".//*[@id='opa-rpt']/div["+(rc+5)+"]/table/tbody/tr[1]/td[2]/ul/li["+i+"]")).getText();
					list1.add(s);
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			//Verify if Apparent O&P causes list is same as new apparent causes list
			softly.assertThat(list1).as("test data").containsAll(apparentCausesNew);
			//Empty list1
			list1.clear();
			//Verify Possible contributing factors
			i=1;
			while (true)
			{
				try{
					String s = driver.findElement(By.xpath(".//*[@id='opa-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[1]")).getText();
					list1.add(s);
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			//Verify if Possible contributing factors or Apparent causes answers list is same as new apparent causes answers list
			softly.assertThat(list1).as("test data").containsAll(apparentCausesAnswersNew);
			//Empty list1
			list1.clear();
			//Verify contributing factors under SURE
			i=1;
			while (true)
			{
				try{
					String s = driver.findElement(By.xpath(".//*[@id='opa-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td[1]")).getText();
					list1.add(s);
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}			
			//Verify if Possible contributing factors or Apparent causes answers list is same as new apparent causes answers list
			softly.assertThat(list1).as("test data").containsAll(apparentCausesAnswersNew);
			//Empty list1
			list1.clear();
	    }
	    
	    public void verifySURE(WebDriver driver) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Verify SURE title
			String title = wait.until(ExpectedConditions.visibilityOfElementLocated(PageTitle)).getText();
			softly.assertThat(title).as("test data").contains("Step 3 - Root Causes Determination Checklist (SURE");
			//Verify SURE full form
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(SField)).getText();
			softly.assertThat(s1).as("test data").isEqualTo("S: Substandard Practice?");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(UField)).getText();
			softly.assertThat(s2).as("test data").isEqualTo("U: Under Management Control?");
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(RField)).getText();
			softly.assertThat(s3).as("test data").isEqualTo("R: Reduce Probability Significantly?");
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(EField)).getText();
			softly.assertThat(s4).as("test data").isEqualTo("E: Not an Effect of Other Contributing Factors?");
	    }
	    
	    public HashMap<String,Integer>  markSUREStep3(WebDriver driver, List<String> apparentCausesAnswersNew) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	//Scroll to top
			Thread.sleep(2000);
    		jse.executeScript("scroll(0,0)");
    		Thread.sleep(2000);
    		//Verify SURE
    		verifySURE(driver);
    		//Hashmap for storing number of SURE checkboxes ticked
    		HashMap<String,Integer> options = new HashMap<String,Integer> ();
    		//Get size of Apparent Causes Answers
    		int n=apparentCausesAnswersNew.size();
    		if (n<1)
    			return options;
    		//Row no starts from 2
    		//Count for root causes
    		int r=0;
    		for(int i =2;i<=n+1;i++)
    		{
    			//Get text of apparent answer
    			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
    			//Click on random SURE
    			Random random = new Random();
    			//Choose a number between 0 and 4 for number of selections
    			int num=random.nextInt(5);
    			if (num==4)
    				r=r+1;
    			//Store no of SURE checkboxes in hashmap: key=level 3 answer, value = no of sure checks
    			options.put(s, num);
    			for (int j=1;j<=num;j++)
    			{
    				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input")));
    				//Scroll to element
    	    		Point p = l.getLocation();
    	    		int yaxis= p.getY()-250;
    	    		Thread.sleep(1000);
    	    		jse.executeScript("scroll(0,"+yaxis+")");
    	    		Thread.sleep(1000);
    				//Click on checkbox of SURE
    				l.click();
    			}
    		}
    		//Add no of root causes in hashmap
    		options.put("Root causes",r);
    		System.out.println(options);
    		//Scroll up
    		jse.executeScript("scroll(0,0)");
    		Thread.sleep(2000);
    		return options;
	    }
	    
	    public void clickNextSkip(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	String skip=wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASkipButton)).getAttribute("class");
			Thread.sleep(2000);
			if(skip.contains("ui-state-disabled"))
			{
				//Click on next
				wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANextButton)).click();
			}
			else
			{
				//Click on skip
				wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASkipButton)).click();
			}
	    }
	    
		public HashMap<String,String> markHML(WebDriver driver,HashMap<String,Integer>options,List<String>apparentCausesAnswersNew) throws Exception {
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Verify title
			String title = wait.until(ExpectedConditions.visibilityOfElementLocated(PageTitle)).getText();
			softly.assertThat(title).as("test data").contains("Step 4 - Level of Importance Attribution For Root Causes & Contributing Factors");
			//Hashmap for storing HML for root cause and contributing factors
			HashMap<String,String> hml= new HashMap<String,String>();
			//No Level 3 selected then return
			if(apparentCausesAnswersNew.size()==0)
			{
				System.out.println("No root causes or contributing factors");
				return hml;
			}
			//Get number of Root causes in Level 3 answers
			int count = options.get("Root causes");
			System.out.println("No of root causes:"+count);
			//Gets number of contributing factors
			int count1 = apparentCausesAnswersNew.size()-count;
			System.out.println("No of contributing factors:"+count1);		
			//tr starts at 2 and each root cause has 4 four rows
			int i=2;
			//Verify if any root causes are appearing
			while(i<=((count*3)+1))
			{
				//Get name of level 3 answer
				String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
				//Remove the 1st : from level 3
				//Remove first appearing : and store in list
    			int m = level3.indexOf(":");
    			String s2 = level3.substring(0, m)+level3.substring(m+1, level3.length());
				//Verify if this level 3 answer was selected
				if(apparentCausesAnswersNew.contains(s2)==false)
				{
					softly.fail("Apparent Cause Answer is not suppose to be here: "+level3);
				}
				//Check if it has 4 boxes ticked
				if(options.get(level3)!=4)
				{
					softly.fail("Not all four boxes are ticked, only some are: "+ options.get(level3));
				}
				//Check if Apparent Cause answer is root cause
				String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("checked");
				softly.assertThat(lop1).as("test data").isEqualTo("true");
				//Check if Apparent Cause answer is not a contributing factor
				String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("disabled");
				softly.assertThat(lop4).as("test data").isEqualTo("true");
				//HML random select
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]")));
				//Scroll down to HML row
	    		Point p = ele.getLocation();
	    		int yaxis= p.getY()-250;
	    		Thread.sleep(1000);
	    		jse.executeScript("scroll(0,"+yaxis+")");
	    		Thread.sleep(1000);
				//Select a number between 0 to 3 for H,M,L
				Random random =new Random();
				int y=random.nextInt(4);
				if(y==1)
				{
				  //Click on H
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				  softly.assertThat(lop2).as("test data").isEqualTo("H");
				  //Insert in hashmap answer and hml
				  hml.put(s2, "High");
				}
				if(y==2)
				{
				  //Click on M
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				  softly.assertThat(lop2).as("test data").isEqualTo("M");
				  //Insert in hashmap answer and hml
				  hml.put(s2, "Medium");
				}
				if(y==3)
				{
				  //Click on L
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				  softly.assertThat(lop2).as("test data").isEqualTo("L");
				  //Insert in hashmap answer and hml
				  hml.put(s2, "Low");
				}
				if(y==0)
				{
					//Insert in hashmap answer and hml
					hml.put(s2, "");
				}
				//Increase i for extra root cause text boxes
				i=i+1;
				//Increase i for changing corrective actions
				i=i+1;
				//Increase i for next root cause
				i=i+1;
			}
			//Verifies if any contributing factors
			//tr starts at 2 and each root cause has 4 four rows
			System.out.println("Starting row of contributing factors:"+i);
			int start =i-1;
			//Verify if any contributing factors are appearing
			while(i<=((count1*2)+start))
			{
				//Get name of level 3 answer
				String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
				//Remove the 1st : from level 3
				//Remove first appearing : and store in list
    			int m = level3.indexOf(":");
    			String s2 = level3.substring(0, m)+level3.substring(m+1, level3.length());
    			//Verify if this level 3 answer was selected
				if(apparentCausesAnswersNew.contains(s2)==false)
				{
					softly.fail("Level 3 is not suppose to be here: "+s2);
				}
				//Check if it has 4 boxes ticked
				if(options.get(level3)>3)
				{
					softly.fail("All four boxes are ticked"+ options.get(level3));
				}
				//Check if Level 3 is contributing factors
				String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
				softly.assertThat(lop1).as("test data").isEqualTo("true");
				//Check if Level 3 is not a root cause
				String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("disabled");
				softly.assertThat(lop4).as("test data").isEqualTo("true");
				//HML random select
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]")));
				//Scroll down to HML row
	    		Point p = ele.getLocation();
	    		int yaxis= p.getY()-250;
	    		Thread.sleep(1000);
	    		jse.executeScript("scroll(0,"+yaxis+")");
	    		Thread.sleep(1000);
				//Select a number between 0 to 3 for H,M,L
				Random random =new Random();
				int y=random.nextInt(4);
				if(y==1)
				{
				  //Click on H
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				  softly.assertThat(lop2).as("test data").isEqualTo("H");
				  //Insert in hashmap answer and hml
				  hml.put(s2, "High");
				}
				if(y==2)
				{
				  //Click on M
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				  softly.assertThat(lop2).as("test data").isEqualTo("M");
				  //Insert in hashmap answer and hml
				  hml.put(s2, "Medium");
				}
				if(y==3)
				{
				  //Click on L
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				  softly.assertThat(lop2).as("test data").isEqualTo("L");
				  //Insert in hashmap answer and hml
				  hml.put(s2, "Low");
				}
				if(y==0)
				{
					//Insert in hashmap answer and hml
					hml.put(s2, "");
				}
				//Increase i for changing corrective actions
				i=i+1;
				//Increase i for next contributing factor
				i=i+1;
			}
			//Scroll up
			jse.executeScript("scroll(0,0)");
			Thread.sleep(2000);
			jse.executeScript("scroll(0,0)");
			Thread.sleep(2000);
			return hml;
		}
		
	    public void collapsibleCheckDescription(WebDriver driver) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Verify the presence of description
	    	try{
	    		driver.findElement(Step1DescriptionPlusSign);	    		
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No description text on this page");
	    		return;
	    	}
	    	//Verify description text not visible
	    	try{
	    		WebElement l = driver.findElement(Step1DescriptionText);
	    		if(l.isDisplayed()==true)
	    			softly.fail("Description text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No description text visible as the + sign for description has not been clicked");
	    	}
	    	//Click on Description
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Step1DescriptionPlusSign)).click();
	    	//Verify description text
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Step1DescriptionText));
	    	//Click on Description again
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Step1DescriptionPlusSign)).click();
	    	//Verify description text not visible
	    	try{
	    		WebElement l = driver.findElement(Step1DescriptionText);
	    		if(l.isDisplayed()==true)
	    			softly.fail("Description text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No description text visible as the + sign for description has not been clicked");
	    	}
	    }
	    
	    public void pathOPiRCA(WebDriver driver, String username) throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Scroll down
	    	Thread.sleep(1000);
	    	jse.executeScript("scroll(0,1500)");	 
	    	Thread.sleep(1000);
	    	//Click next
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANextButtonAtBottomOfInfoTab)).click();
	    	//Scroll top
	    	Thread.sleep(1000);
	    	jse.executeScript("scroll(0,0)");	 
	    	Thread.sleep(1000);
	    	//Click on dropdown field
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCADropdownMenuButton)).click();
	    	//Select HiRCA options for level 3
	    	List<String> hircaL3 = selectHiRCALevel3(driver);
	    	//Check the description collapsible 
	    	collapsibleCheckDescription(driver);
	    	//Store selected apparent causes in List
	    	List<String> apparentCauses = storeApparentCauses(driver);
	    	//Verify the apparent causes appearing
	    	verifyCorrespondingApparentCauses(driver,hircaL3,apparentCauses);
	    	if(hircaL3.isEmpty())
	    	{
	    		//Click on skip if no selections made
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASkipButton)).click();
	    	}
	    	else
	    	{
	    		//Click on next
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANextButton)).click();
	    	}
	    	if(apparentCauses.isEmpty()==true)
	    	{
	    		//Click on skip if no selections made
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASkipButton)).click();
	    	}
	    	//If any apparent causes selected then click on them and store in a list
    		List<String> apparentCausesAnswers = selectApparentCausesAnswers(driver,apparentCauses);
	    	//Skip all Step 2 questions
	    	for (int i=0;i<12;i++)
	    	{
	    		//Click on skip
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASkipButton)).click();
	    	}
	    	//Verify apparent causes selections
	    	verifyApparentCauses(driver,apparentCausesAnswers);
	    	//Unselect one HiRCA Level 3 option
	    	List<String> hircaNewList = modifyStep1(driver,hircaL3);
	    	//Store new list of apparent causes
	    	List<String> apparentCausesNew = storeApparentCauses(driver);
	    	//Verify that apparent cause of only the selected HiRCA level 3 options are visible
	    	verifyCorrespondingApparentCauses(driver,hircaNewList,apparentCausesNew);
	    	//Scroll top
	    	Thread.sleep(1000);
	    	jse.executeScript("scroll(0,0)");	 
	    	Thread.sleep(1000);
	    	//Click on Step 3
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3Tab)).click();
	    	/*Verify the new apparent causes answers
	    	 * And
	    	Get new apparent causes answers: remove unselected ones*/
	    	List<String> apparentCausesAnswersNew = verifyModifiedStep3(driver,apparentCausesNew);	
	    	//Select some checkboxes in Step 3 SURE
	    	HashMap<String,Integer> options = markSUREStep3(driver,apparentCausesAnswersNew);
	    	//Click skip or next
	    	clickNextSkip(driver);
	    	//Mark HML for all apparent causes answers
	    	HashMap<String,String> hml = markHML(driver,options,apparentCausesAnswersNew);
	    	//Click skip or next
	    	clickNextSkip(driver);
	    	//Scroll to top
			Thread.sleep(2000);
    		jse.executeScript("scroll(0,0)");
    		Thread.sleep(2000);
	    	//Clicks on save button
			jse.executeScript("return document.getElementById('efi-opa-button-save').click();");
			//Clicks on save report
			WebDriverWait wait1 = new WebDriverWait(driver,20);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASavePopupTitle));
			jse.executeScript("return document.getElementById('pii-opa-dialog-confirmed').click();");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(StickyNote));
			//Clicks on Info tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoTab)).click();
			//Creates the expected name of record
			String creationDate = driver.findElement(OPiRCAReportCreationDateTimeField).getAttribute("value");
			String name = creationDate +"_"+ username + "_" + event_title;
			System.out.println("Expected name of record: " + name);			  
			//Click on saved activities
			jse.executeScript("return document.getElementById('efi-opa-btn-savedactivities').click();");
			Thread.sleep(3000);
			//Clicks on O&P IRCA side panel
			jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
			WebElement record = driver.findElement(OPiRCAFirstRecord);
			String recordName = record.getText();
			if (record.isDisplayed())
			{
			  System.out.println("Record found: "+ recordName);
			}
			else
			  System.out.println ("Record not found.");
			softly.assertThat(name).as("test data").isEqualTo(recordName);
			//Verify Apparent Causes in HTML
			verifyHTML(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
			//Open report
			openReport(driver);
			//Download report
			downloadSelectFunction(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
			Thread.sleep(2000);
	    }
	    
	    public void downloadSelectFunction (WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew, List<String> apparentCausesAnswersNew, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception {
	    	
	    	//deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	HiRCAEvent obj1 = new HiRCAEvent();
	    	obj1.deleteFiles(file);
	    	//Get browser name
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println(browserName);
		    String v = cap.getVersion().toString();
		    System.out.println(v);
		    //Download report to check pdf
		    if (browserName.equals("chrome"))
		    	downloadRecordChrome(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
		    if (browserName.equals("firefox"))
		    	downloadRecordFirefox(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
		    if (browserName.equals("internet explorer"))
		    {
		    	if (v.startsWith("10"))
		    		downloadRecordIE10(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
		    	if (v.startsWith("11"))
		    		downloadRecordIE11(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options);
		    }
	    }
	    
	    public void reportCreate(WebDriver driver, String username) throws Exception {
	    	
	    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	  //Clicks on O&P IRCA
			  jse.executeScript("return document.getElementById('pii-a-menu-opirca').click();");
			  //Fills the mandatory fields
			  driver.findElement(OPiRCAEventTitleField).sendKeys(event_title);
			  driver.findElement(OPiRCAEventLocationField).sendKeys("San Diego");
			  driver.findElement(OPiRCAProblemStatementField).sendKeys("Sanity Test");
			  driver.findElement(OPiRCATimelineOfEventField).sendKeys("Sanity Test");
			  driver.findElement(OPiRCABackgroundInfoField).sendKeys("Sanity Test");
			  driver.findElement(OPiRCAInvestigatorsField).sendKeys("Sanity Test");
			  String ev1 = driver.findElement(OPiRCAEventTitleField).getAttribute("value");
			  String ev2 = driver.findElement(OPiRCAEventLocationField).getAttribute("value");
			  String ev3 = driver.findElement(OPiRCAProblemStatementField).getAttribute("value");
			  String ev4 = driver.findElement(OPiRCATimelineOfEventField).getAttribute("value");
			  String ev5 = driver.findElement(OPiRCABackgroundInfoField).getAttribute("value");
			  String ev6 = driver.findElement(OPiRCAInvestigatorsField).getAttribute("value");
			  if ((ev1.equals(event_title)==false))
			  {
				  driver.findElement(OPiRCAEventTitleField).clear();
				  driver.findElement(OPiRCAEventTitleField).sendKeys(event_title);
			  }
			  if ((ev2.equals("San Diego")==false))
			  {
				  driver.findElement(OPiRCAEventLocationField).clear();
				  driver.findElement(OPiRCAEventLocationField).sendKeys("San Diego");
			  }
			  if ((ev3.equals("Sanity Test")==false))
			  {
				  driver.findElement(OPiRCAProblemStatementField).clear();
				  driver.findElement(OPiRCAProblemStatementField).sendKeys("Sanity Test");
			  }
			  if ((ev4.equals("Sanity Test")==false))
			  {
				  driver.findElement(OPiRCATimelineOfEventField).clear();
				  driver.findElement(OPiRCATimelineOfEventField).sendKeys("Sanity Test");
			  }
			  if ((ev5.equals("Sanity Test")==false))
			  {
				  driver.findElement(OPiRCABackgroundInfoField).clear();
				  driver.findElement(OPiRCABackgroundInfoField).sendKeys("Sanity Test");
			  }
			  if ((ev6.equals("Sanity Test")==false))
			  {
				  driver.findElement(OPiRCAInvestigatorsField).clear();
				  driver.findElement(OPiRCAInvestigatorsField).sendKeys("Sanity Test");
			  }
			  //Step1 and KALE-1838
			  pathOPiRCA(driver,username);			  
	    }
	    
	    public void softAssert() throws Exception {
			softly.assertAll();
			System.gc();
		}

}
