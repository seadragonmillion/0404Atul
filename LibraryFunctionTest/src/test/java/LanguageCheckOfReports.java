import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguageCheckOfReports {

	SoftAssertions softly = new SoftAssertions();
	
	public boolean containsHanScript(String s) {
	    return s.codePoints().anyMatch(
	            codepoint ->
	            Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
	}
	
	public void chineseCheck(String s) throws Exception{
		
		if (containsHanScript(s)==false)
			softly.fail("Not in chinese");
	}
	
	public void englishCheck(String s) {
		if (containsHanScript(s)==true)
			softly.fail("Not in english");
	}
	
	public void downloadReportIE(WebDriver driver, int y, WebElement element) throws Exception {
    	
    	//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	Thread.sleep(2000);
		//Clicks on download button
		element.click();
		Thread.sleep(3000);
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(7000);
    	Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
		q.waitFor();
		Thread.sleep(15000);
    	//pdf verification
    	pdfCheck(y);
    	Thread.sleep(8000);
    	//Switch to window    	
    	driver.switchTo().window(window);
    	//Switches to the iframe
        wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
			    		    	
    }
	
	public void downloadReportIE11(WebDriver driver, int y, WebElement element) throws Exception {
    	
    	//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	Thread.sleep(2000);
		//Clicks on download button
		element.click();
		Thread.sleep(3000);
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(7000);
    	Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
		q.waitFor();
		Thread.sleep(15000);
    	//pdf verification
    	pdfCheck(y);
    	Thread.sleep(8000);
    	//Switch to window    	
    	driver.switchTo().window(window);
    	//Switches to the iframe
        wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
			    		    	
    }
	
	 public void downloadReportFirefox (WebDriver driver, int y, WebElement element) throws Exception {
	    	
	    	//deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on download button
			element.click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(12000);
	    	for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
	    	Thread.sleep(14000);
	    	Robot robot = new Robot();
	    	// press Ctrl+S the Robot's way
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_S);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_S);
	    	Thread.sleep(8000);
	    	Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
	    	p.waitFor();
	    	Thread.sleep(4000);
	    	pdfCheck(y);
	    	Thread.sleep(4000);
	    	driver.close();
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    	//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	       	    		    	
	    }
	
	public void downloadReportChrome (WebDriver driver, int y, WebElement element) throws Exception {
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports");
    	deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	String window = driver.getWindowHandle();
		//Clicks on download button
		element.click();
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
    	Thread.sleep(3000);
    	pdfCheck(y);
    	for(String winHandle : driver.getWindowHandles())
    	{
	        driver.switchTo().window(winHandle);
	    }
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}
	
	public void deleteFiles(File folder) throws IOException {
        File[] files = folder.listFiles();
         for(File file: files){
                if(file.isFile()){
                    String fileName = file.getName();
                    boolean del= file.delete();
                    System.out.println(fileName + " : got deleted ? " + del);
                }else if(file.isDirectory()) {
                    deleteFiles(file);
                }
            }
        }
	
	public void pdfCheck(int y) throws Exception {
		
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
	    String newData="";
	    for (int i = 0; i < ans.size(); i++)
	        {	        	
	        	int n=ans.get(i).length()-1;
	        	if (ans.get(i).charAt(n)==' ')
	        		newData = newData+ans.get(i);
	        	if (ans.get(i).charAt(n)!=' ')
	        		newData = newData+" "+ans.get(i);	        	
	        }
	    if (y==0)
	    	chineseCheck(newData);
		if (y==1)
			englishCheck(newData);
	      
	}
	
	public WebElement errorMeter(WebDriver driver, int y) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on error meter side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Stores text of SPV title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-epm-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of username label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td/strong"))).getText());
		//Stores text of username label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/strong"))).getText());
		//Stores text of date label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td[2]/strong"))).getText());
		//Stores text of time label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td[2]/strong"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of label of error %
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/span"))).getText());
		//Stores text of label of error low
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td[2]/span"))).getText());
		//Stores text of Error Low
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td[2]/strong"))).getText());
		//Stores text of label of PJB
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[1]/strong"))).getText());
		//Stores text of label of Analysis
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[2]/strong"))).getText());
		//Stores text of label of report title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[3]/strong"))).getText());
		//Stores text of label of 1-general review
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[4]/strong"))).getText());
		//Stores text of PAPE full form
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[4]/tbody/tr/td/span"))).getText());
		//Stores text of label of 1st table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 1st table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 1st table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr/th[4]"))).getText());
		//Stores text of label of 2nd table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 2nd table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 2nd table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr/th[4]"))).getText());
		//Stores text of label of 3rd table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 3rd table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 3rd table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr/th[4]"))).getText());
		//Stores text of label of 4th table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 4th table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 4th table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr/th[4]"))).getText());
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))));
	}
	
	
	public void hpi(WebDriver driver, int y) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on hpi side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Stores text of HPI title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-hpi-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
	}
	
	public WebElement hirca(WebDriver driver, int y) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on hirca side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Stores text of HiRCA title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-irca-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of open button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText());
		//Stores text of title of 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/thead/tr/th"))).getText());
		//Stores the labels of all the rows in 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[3]/td[3]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText());
		//Stores text of title of 2nd table
	    s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/thead/tr/th"))).getText());
	    //Stores the labels of all the rows in 2nd table
	    s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[1]/td[1]"))).getText());
	    s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText());		
	    s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText());
	    s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText());  
	    //Randomly generated tables so think about it*****
	    
	    
	    
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))));
		
	}
	
	public WebElement eirca(WebDriver driver, int y) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on eirca side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-mirca"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }		
		//Stores text of EiRCA title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-mirca-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of open button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText());
		//Stores text of title of 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/thead/tr/th"))).getText());
		//Stores the labels of all the rows in 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[10]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[11]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[12]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[13]/td[1]"))).getText());
		//Stores the report header
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[2]"))).getText());		
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
		
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))));
	}
	
	public WebElement opirca(WebDriver driver, int y) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on opirca side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-opa"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		
		
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))));

	}
	
	public void jobs(WebDriver driver, int y) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on job observation side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-jo-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		

	}
	
	public void passReview(WebDriver driver, int y) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on 3 pass review side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-3pr"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-3pr-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of open button
        s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		

	}
	
	public WebElement rv(WebDriver driver, int y) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on remote verification side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-rv"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Stores text of Remote Verification title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of title of 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[1]/table/tbody/tr/th/span[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[1]/table/tbody/tr/th/span[2]"))).getText());
		//Stores text of username
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[1]/strong"))).getText());
		//Stores text of verifier
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[2]/strong"))).getText());
		//Stores text of time
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]/strong"))).getText());
		//Stores text of verifier status
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[4]/strong"))).getText());
		//Stores text of 2nd table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[3]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Stores text of 3rd table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[4]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Stores text of 4th table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[5]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Stores text of 5th table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[6]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))));

	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
	}
	
	
}
