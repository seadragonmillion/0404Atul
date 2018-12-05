import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCABug2 {

	HiRCALOPBug hlb = new HiRCALOPBug();
	HiRCALevel1 hircaL1 = new HiRCALevel1();
	HiRCALevel2 hircaL2 = new HiRCALevel2();
	ShareCheck share = new ShareCheck();

	String text = "HiRCA bug";
	SoftAssertions softly = new SoftAssertions();

	public void uploadImageChrome(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		int j=0;
		String id = "pii-irca-event-filecollapsible-"+j;
		share.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		l.sendKeys(filepath);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		//Fill title and description
		String title_id="pii-irca-event-file-title-"+j;
		driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
		String desc = "pii-irca-event-file-description-"+j;
		driver.findElement(By.id(desc)).sendKeys("Description0"+j);
	}
	
	public void uploadImageFirefox(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		int j=0;
		String id = "pii-irca-event-filecollapsible-"+j;
		share.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		share.scrollToElement(driver, l);
		Thread.sleep(2000);
		Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
		p.waitFor();
		Thread.sleep(2000);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		//Fill title and description
		String title_id="pii-irca-event-file-title-"+j;
		driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
		String desc = "pii-irca-event-file-description-"+j;
		driver.findElement(By.id(desc)).sendKeys("Description0"+j);
	}
	
	public void uploadImageIE10(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int j=0;
		String id = "pii-irca-event-filecollapsible-"+j;
		share.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		share.scrollToElement(driver, l);
		jse.executeScript("return document.getElementById('"+file+"').click();");
		Thread.sleep(8000);
		try {
			Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
			p.waitFor();
		}catch (UnhandledAlertException f){		
			System.out.println("Unexpecetd alert for picture 2");
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(6000);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		//Fill title and description
		String title_id="pii-irca-event-file-title-"+j;
		driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
		String desc = "pii-irca-event-file-description-"+j;
		driver.findElement(By.id(desc)).sendKeys("Description0"+j);
	}
	
	public void uploadImageIE11(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int j=0;
		String id = "pii-irca-event-filecollapsible-"+j;
		share.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		share.scrollToElement(driver, l);
		jse.executeScript("return document.getElementById('"+file+"').click();");
		Thread.sleep(2000);
		try {
			Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
			p.waitFor();
		}catch (UnhandledAlertException f){		
			System.out.println("Unexpecetd alert for picture 2");
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(2000);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		//Fill title and description
		String title_id="pii-irca-event-file-title-"+j;
		driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
		String desc = "pii-irca-event-file-description-"+j;
		driver.findElement(By.id(desc)).sendKeys("Description0"+j);
	}
	
	public void uploadImage(WebDriver driver) throws Exception {

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if(browserName.equals("chrome"))
			uploadImageChrome(driver);
		if(browserName.equals("firefox"))
			uploadImageFirefox(driver);
		if(browserName.equals("internet explorer"))
		{
			if(v.startsWith("10"))
				uploadImageIE10(driver);
			if(v.startsWith("11"))
				uploadImageIE11(driver);
		}
	}

	public void pathHiRCABug(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		hlb.fillPage(driver, text);
		//Scroll to image and upload one image with title
		uploadImage(driver);
		//Click on add supporting file
		WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
		share.scrollToElement(driver, add);
		add.click();
		//save hirca report and open report
		share.scrollToTop(driver);
		hircaL2.saveHiRCAReport(driver);
		//Scroll down
		share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-0"))));
		//Click on collapsible of image
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-0"))).click();
		//Wait for loading message to disappear
		share.loadingServer(driver);
		//Verify the warning message
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-file-status-0"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Warning: no file attached.");
		}catch(org.openqa.selenium.TimeoutException t)
		{
			
		}
		share.scrollToTop(driver);
		//Delete report
		hircaL1.deleteReport(driver);
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
