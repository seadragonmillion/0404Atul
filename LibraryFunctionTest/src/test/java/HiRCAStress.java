import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAStress {
	
	static String text = "HiRCA Stress test";
	static SoftAssertions softly = new SoftAssertions();

	public static void HiRCAUpload10Images(WebDriver driver) throws Exception {
		
		HiRCALOPBug obj = new HiRCALOPBug();
		ShareCheck obj1 = new ShareCheck();
		HiRCALevel1 obj2 = new HiRCALevel1();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Go to Analysis page and fill Info page
		obj.fillPage(driver, text);
		//Upload 10 images
		uploadFiveImages(driver);
		//Clicks on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		obj1.loadingServer(driver);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		obj1.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		obj1.loadingServer(driver);
		//Checks the 5 images if appearing
		for (int j=0; j<5; j++)
		{				  
			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-h-event-report-filecollapsible-"+j;
			obj1.scrollToElement(driver, driver.findElement(By.id(id)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
			String img = "pii-irca-h-event-report-file-img-"+j;
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			}catch(org.openqa.selenium.TimeoutException y)
			{
				softly.fail("Image not visible");
			}
			
		}
		Thread.sleep(1000);
		obj1.scrollToTop(driver);
		//Downloads record
		downloadSelectFunction(driver);
		Thread.sleep(2000);	
		//Delete report
		obj2.deleteReport(driver);
	}
	
	public static void downloadSelectFunction (WebDriver driver) throws Exception {

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
			downloadRecordChrome(driver);
		if (browserName.equals("firefox"))
			downloadRecordFirefox(driver);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadRecordIE10(driver);
			if (v.startsWith("11"))
				downloadRecordIE11(driver);
		}
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(2000);
	}
	
	public static void pdfCheck() throws Exception{

		HiRCAEvent obj = new HiRCAEvent();
		List<String> results = new ArrayList<String>();
		//Gets the file name which has been downloaded
		File[] files = new File("C://Users//IEUser//Downloads//reports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		//Loads the file to check if correct data is present
		String fileName="C://Users//IEUser//Downloads//reports//"+results.get(0);
		File oldfile = new File(fileName);
		//Checks number of images in pdf
		PDDocument pddoc= PDDocument.load(oldfile);
		List<RenderedImage> images = new ArrayList<>();
		images=obj.getImagesFromPDF(pddoc);
		System.out.println("Number of images: "+images.size());
		softly.assertThat(images.size()).as("test data").isEqualTo(20);
		pddoc.close();	      
	}
	
	public static void downloadRecordChrome (WebDriver driver) throws Exception {

		ShareCheck obj = new ShareCheck();
		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		pdfCheck();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}


	public static void downloadRecordFirefox(WebDriver driver) throws Exception {

		ShareCheck obj = new ShareCheck();
		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(4000);
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();
		pdfCheck();
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
	}

	public static void downloadRecordIE10(WebDriver driver) throws Exception {

		ShareCheck obj = new ShareCheck();
		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert for picture 2");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(7000);
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//IEUser//Downloads//reports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			obj2.deleteFiles(file);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(4000);
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				q.waitFor();
			}catch (UnhandledAlertException f){	
				System.out.println("Unexpected alert");
				driver.switchTo().alert().accept();

			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert");
			}
			Thread.sleep(6000);
		}
		//pdf verification
		pdfCheck();
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);				    		    	
	}


	public static void downloadRecordIE11(WebDriver driver) throws Exception {

		ShareCheck obj = new ShareCheck();
		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(4000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(8000);
		//pdf verification
		pdfCheck();
		Thread.sleep(4000);
		//Close pdf
		//Switch to window    	
		driver.switchTo().window(window);			    		    	
	}
	
	public static void uploadTenImagesChrome(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-"+j))).sendKeys(filepath);
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				obj.scrollToElement(driver, add);
				add.click();
			}
		}
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		obj.loadingServer(driver);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}
	
	public static void uploadTenImagesFirefox(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-"+j))).click();
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
			q.waitFor();
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				obj.scrollToElement(driver, add);
				add.click();
			}
		}
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		obj.loadingServer(driver);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}
	
	public static void uploadTenImagesIE10(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			String file = "pii-irca-event-file-"+j;
			jse.executeScript("return document.getElementById('"+file+"').click();");
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert for picture 2");
			}
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				obj.scrollToElement(driver, add);
				add.click();
			}
		}
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		obj.loadingServer(driver);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}
	
	public static void uploadTenImagesIE11(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			String file = "pii-irca-event-file-"+j;
			jse.executeScript("return document.getElementById('"+file+"').click();");
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert for picture 2");
			}
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				obj.scrollToElement(driver, add);
				add.click();
			}
		}
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		obj.loadingServer(driver);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}
	
	public static void verifyImagesUploaded(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		for (int i=0;i<=9;i++)
		{
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))));
			//Clicks on collapsible
			if(driver.findElement(By.id("pii-irca-event-file-img-"+i)).isDisplayed()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))).click();
			//Checks for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
			Thread.sleep(2000);
			//Clicks on collapsible again
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))).click();
		}
		obj.scrollToTop(driver);
		obj.scrollToTop(driver);
	}
	
	public static void uploadFiveImages(WebDriver driver) throws Exception {

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			uploadTenImagesChrome(driver);
		if (browserName.equals("firefox"))
			uploadTenImagesFirefox(driver);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				uploadTenImagesIE10(driver);
			if (v.startsWith("11"))
				uploadTenImagesIE11(driver);
		}
	}
	
	public static void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
	
}