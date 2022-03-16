import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerificationPageObj;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.ShareCheckPageObj;


public class ChromeOffline2 {

	WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheckPageObj share = new ShareCheckPageObj();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();

	
	@Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("target/screenshots/"+"failshot.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
  //          driver.quit();
        }
	};
		
	@Before
	  public void beforeTest() throws MalformedURLException, InterruptedException{
		  System.out.println("RV OfflineSync: close browser before putting wifi back on");
		
		  
		System.setProperty("webdriver.chrome.driver",chrome_path);
		
		  ChromeOptions options = new ChromeOptions();
			//options.addArguments("user-data-dir=C:/Users/mama/AppData/Local/Google/Chrome/User Data/");
			options.addArguments("user-data-dir=C:/Users/mama/AppData/Local//Google/Chrome/User Data/");
			options.addArguments("profile-directory=Profile 4");
		  driver = new ChromeDriver(options);
		  
        Thread.sleep(5000);
        driver.manage().deleteAllCookies(); //delete all cookies
        Thread.sleep(7000); //wait 7 seconds to clear cookies.
        
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  

	@Test
	public void test() throws Exception{
		//Login User
		Login obj = new Login ();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(2000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
               if (login==1)
               {
                     WebDriverWait wait2 = new WebDriverWait(driver,20);
                     wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
               }
        }catch (NoSuchElementException e){
               throw e;
        }
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		
		//Click on Analysis on main menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on RV module
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv"))).click();
		//Disconnect with WiFi
		Runtime.getRuntime().exec("netsh wlan disconnect");
		//Assert: Confirm Offline warning message and print and close
		try{
			//Closes server warning
			String s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText().trim();
			System.out.println("Disconnecting wifi sticky: " +s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
		}catch (org.openqa.selenium.TimeoutException e)
		{

		}
		Thread.sleep(7000);
		//Fill in (1) Verification report information.(create random number at the end of report title)
				Random rn = new Random();
				rn.nextInt(999999);
				String title = "OfflineRVreportSyncTest" + rn;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-title"))).sendKeys(title);
				
				//Click checkbox I certify...
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-photo-icertify-checkbox"))).click();
				//tempout
			/*	//Upload Supporting files (3 times) (2) Take or choose a photo of work needing verification.
					String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
					for (int j=0; j<3; j++)
					{
						//Click on Supporting file details
						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-"+j))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-"+j))).click();
						//Uploads file
						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-button-"+j))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-button-"+j))).click();
						//Fill each supporting file title
						String title_id="pii-rv-event-file-title-"+j;
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+(j+1));
						//Fill each supporting file description
						String des_id="pii-rv-event-file-description-"+j;
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(des_id))).sendKeys("Des0"+(j+1));
						//Choose File upload photo
						driver.findElement(By.id("pii-rv-event-file-"+j)).sendKeys(filepath);
						Runtime.getRuntime().exec("C:\\Users\\mama\\Downloads\\clickcancel2.exe");
						//Wait for image
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-img-"+j)));
						//Click on attach another file
						WebElement add= driver.findElement(By.id("pii-rv-addnewfile-button"));
						share2.scrollToElement(driver, add);
						add.click();
						/*
						if(j<3)
						{
							//Click on attach another file
							WebElement add= driver.findElement(By.id("pii-rv-addnewfile-button"));
							share2.scrollToElement(driver, add);
							add.click();
						}*/
			//		}
			
				
				
				//Upload photo (3) Take or choose a photo of the person requesting verification.
				String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-photo-input"))));
				driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(filepath);
				Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\clickcancel2.exe");
				//Fill in (4) Fill in relevant details and description of work needing verification.
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-details"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-details"))).sendKeys("work evaluation");
				share2.scrollToAPoint(driver, 400);
				//Click on (5) Select whether this verification is: In Person 
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-5-inperson-radio-ip"))));
				//Click (6) Verifier sign-off checkbox: I certify that...
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6ip-icertify-checkbox"))));
				//Fill in (6) Verifier sign-off's Name
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-name"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-name"))).sendKeys("MarryAnne");
				//Fill in (6) Verifier sign-off's Title
				share2.scrollToAPoint(driver,400);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-title"))).sendKeys("Site Manager");
				//Click on Save Button
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))).click();
				//Click Save in Save report popup
				jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-confirmed"))));
				//Assert: Confirm Green Offline syncing message and print and close
				try{
					//Closes server warning
					String s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText().trim();
					System.out.println("Offline report saved in Offline mode sticky: " +s);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
				}catch (org.openqa.selenium.TimeoutException e)
				{

				}
				Thread.sleep(7000);
				//Click on RV tab on side panel
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-rv"))).click();
				//Assert: Offline report display in Offline Listing
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).getText();
				softly.assertThat(s).as("test data").contains("//a[contains(text(),'" + title + "')]");	
				System.out.println(s);
				//Manual Testing below
				//1. Close Browser
				//2. WiFi back 
				//3. Re-login, check sycronizing blue message on Kale
				//4. Result: Offline report is synced to Online Listing
				
//				assertEquals(driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]")).isDisplayed(), true);
				
				//Close browser before putting wifi back
				//driver.close();
				
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//				
//				//Connect wifi, insert network name
//				Runtime.getRuntime().exec("netsh wlan connect name=\"AMBO-5G\"");
//				System.setProperty("webdriver.chrome.driver",chrome_path);
//				 
//				ChromeOptions options = new ChromeOptions();
//					options.addArguments("user-data-dir=C:/Users/mama/AppData/Local/Google/Chrome/User Data/");
//					options.addArguments("profile-directory=Profile 4");*/
//				  driver = new ChromeDriver();
//		        Thread.sleep(5000);
//		        
//				  //Browser is maximized
//				  driver.manage().window().maximize();
//				  //Browser navigates to the KALE url
//				  driver.get(url);
//				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				
//				  //Login User
//					obj = new Login ();
//					login = obj.LoginUser(driver, username, password);
//					//Wait for loading message to disappear
//					share2.loadingServer(driver);
//					
//					//Switches to the iframe
//					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
//					try{
//						if (login==1)
//						{
//							WebDriverWait wait2 = new WebDriverWait(driver,30);
//							wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
//						}
//					}catch (org.openqa.selenium.TimeoutException e){
//						throw e;
//					}
//					Thread.sleep(7000);
//					//Click on Analysis on main menu
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
//					//Click User
//					try{
//						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
//					}catch(org.openqa.selenium.UnhandledAlertException t)
//					{
//						driver.switchTo().alert().dismiss();
//					}
//					//Click Activity
//					wait.until(ExpectedConditions.visibilityOfElementLocated(share.ActivityOnTopRight)).click();
//					//Click on RV side panel 
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-rv"))).click();
//					share2.loadingServer(driver);
///////////////////////////////////////////////////////////////////////////////////////////////				
//				
//				//Assert: Offline report display in Online Listing
//				softly.assertThat(s).as("test data").contains("//a[contains(text(),'" + title + "')]");	
//				System.out.println("Offline report has successfully synced to online: "+s);
////				assertEquals(driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]")).isDisplayed(), true);
//				
//				//Logout User
//				Login login2 = new Login();
//				login2.logout(driver);
//				driver.manage().window().maximize();
//			}
//		
//	
//	public void afterTest() {
//		  driver.quit();
//		  softly.assertAll();
//		  }
	  }
	
}
