import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAEvent {

	SoftAssertions softly = new SoftAssertions();
	String reason1="I think I will buy the red car, or I will lease the blue one.";
	String paragraph_investigators = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu lorem sapien. Donec molestie ligula nec diam mollis scelerisque ac et orci. Phasellus facilisis urna quis nibh faucibus, quis vestibulum nunc fringilla. Sed efficitur elit a nulla ultrices, at cursus ligula pharetra. Ut sollicitudin libero in nunc iaculis, ac mollis eros finibus. Nam iaculis pretium augue, vel tristique ligula sodales id. Maecenas sit amet tellus lobortis, pellentesque urna non, rutrum ante. Etiam enim quam, porta vel iaculis tincidunt, feugiat in nisl.@#$%&*()"
			+"\n"
			+"Donec gravida ante congue orci dictum, ut pretium velit elementum. Aliquam mattis sapien ut felis consequat tempor. Integer eget justo libero. Etiam hendrerit massa odio, non scelerisque leo fringilla nec. Curabitur ac magna dolor. Suspendisse mi nisi, dictum non dolor sit amet, venenatis tempor ipsum. Praesent maximus mauris tortor, ut hendrerit est pulvinar vitae. Aenean vel justo dignissim, scelerisque urna ultricies, hendrerit magna. Etiam elementum accumsan turpis ut efficitur. Aliquam luctus, nulla eget faucibus fermentum, tortor eros dignissim ante, vitae fermentum tellus ligula consectetur ligula. Etiam sagittis nisl mi, sit amet scelerisque eros venenatis sit amet. Fusce facilisis nisl nunc, eu euismod dui tristique nec. Donec lorem enim, sodales eu sem in, feugiat varius nunc. Phasellus cursus laoreet sapien, ac posuere tortor!?:;"
			;
	String paragraph_background= "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
			+"\n"+"\n"
			+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. The Apache FontBox library is an open source Java tool to obtain low level information from font files. FontBox is a subproject of Apache PDFBox. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains commandline tools using Apache PDFBox."
			;
	String paragraph_timeline = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for lorem ipsum will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose. I have a house."
			+"\n"+"\n"
			+"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains examples on how the library can be used."
			;
	String paragraph_problem = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it."
			+"\n"+"\n"
			+"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted."
			;
	String text = "As it currently stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.";
	String executive= "According to the 1993 Israel-Palestinian peace accords, the final status of Jerusalem is meant to be discussed in the latter stages of peace talks.";
	String event_id="Its a small world after all";
	String text184 = "This list looks quite big but the setup is quite easy but time-consuming and once you are done with setup next time it will hardly take two min to start you Mobile test.";

	public void deleteNewRecord(WebDriver driver, String recordName) throws Exception{	  

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Clicks on new record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		//Clicks on delete report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Verify record deleted
		//Get name of 1st record
		String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted "+name);
		else
			System.out.println("Record could not be deleted");
		while(true)
		{
			try{
				if (driver.findElement(By.className("sticky-note")).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{

				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException o)
			{
				Thread.sleep(3000);
				break;
			}
		}

	}

	public void saveFourthReportCheckImages(WebDriver driver, String username, String password, Login obj, int f) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj1 = new ShareCheck();
		/* while(true)
		  {
			  try{
			  if (driver.findElement(By.className("sticky-note")).isDisplayed())
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

			  }}catch (NoSuchElementException e)
			  {
				  break;
			  }
			  catch( StaleElementReferenceException f1)
			  {

				 break;
			  }
			  catch (org.openqa.selenium.TimeoutException u)
			  {
				  break;
			  }

		  }*/
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		Thread.sleep(2000);
		Actions act = new Actions (driver);
		//Logout
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		if(f==1)
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login
		obj.LoginUser(driver, username, password);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Wait for loading message to disappear		  
		obj1.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		obj1.loadingServer(driver);
		//Click on Open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Clicks on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Changes the event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title thrice");
		//Clicks on Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		Thread.sleep(2000);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Scroll down and check for 5 images uploaded
		int scroll =700;

		for (int i=0;i<=4;i++)
		{
			jse.executeScript("scroll(0, "+scroll+")");
			//Clicks on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))).click();

			//Checks for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
			Thread.sleep(2000);
			//Clicks on collapsible again
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))).click();
			scroll=scroll+20;

		}
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String newRecord=creationDate + "_"+username+"_"+ "changed title thrice";
		System.out.println(newRecord);
		jse.executeScript("scroll(0, 0)");
		//Clicks on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
		deleteNewRecord(driver, newRecord);

	}

	public void saveThirdReportCheckImages(WebDriver driver, String username, String password, Login obj,int f) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj1 = new ShareCheck();
		/*while(true)
			  {
				  try{
				  if (driver.findElement(By.className("sticky-note")).isDisplayed())
				  {
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				  }}catch (NoSuchElementException e)
				  {
					  break;
				  }
				  catch( StaleElementReferenceException f1)
				  {

					 break;
				  }
				  catch (org.openqa.selenium.TimeoutException u)
				  {
					  break;
				  }

			  }*/
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		Thread.sleep(2000);
		Actions act = new Actions (driver);
		//Logout
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		if(f==1)
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login
		obj.LoginUser(driver, username, password);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Click on Open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Clicks on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Changes the event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title twice");
		//Clicks on Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		Thread.sleep(2000);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Scroll down and check for 5 images uploaded
		int scroll =700;

		for (int i=0;i<=4;i++)
		{
			jse.executeScript("scroll(0, "+scroll+")");
			//Clicks on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
			//Checks for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
			Thread.sleep(2000);
			//Clicks on collapsible again
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))).click();
			scroll=scroll+20;

		}
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String newRecord=creationDate + "_"+username+"_"+ "changed title twice";
		System.out.println(newRecord);
		jse.executeScript("scroll(0, 0)");
		//Clicks on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		saveFourthReportCheckImages(driver, username, password, obj,f);
		//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
		deleteNewRecord(driver, newRecord);

	}

	public void saveNewReport(WebDriver driver, String username, String password, Login obj,int f) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj1 = new ShareCheck();
		/* while(true)
			  {
				  try{
				  if (driver.findElement(By.className("sticky-note")).isDisplayed())
				  {
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				  }}catch (NoSuchElementException e)
				  {
					  break;
				  }
				  catch( StaleElementReferenceException f1)
				  {

					 break;
				  }
				  catch (org.openqa.selenium.TimeoutException u)
				  {
					  break;
				  }

			  }*/
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		Thread.sleep(2000);
		Actions act = new Actions (driver);
		//Logout
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		if(f==1)
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login
		obj.LoginUser(driver, username, password);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on Open button
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Clicks on Info tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Changes the event title
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title");
		//Clicks on Save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		Thread.sleep(2000);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Scroll down and check for 5 images uploaded
		int scroll =700;

		for (int i=0;i<=4;i++)
		{
			jse.executeScript("scroll(0, "+scroll+")");
			//Clicks on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))).click();

			//Checks for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
			Thread.sleep(2000);
			//Clicks on collapsible again
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))).click();
			scroll=scroll+20;

		}
		Thread.sleep(1000);
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String newRecord=creationDate + "_"+username+"_"+ "changed title";
		System.out.println(newRecord);
		jse.executeScript("scroll(0, 0)");
		//Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		saveThirdReportCheckImages(driver, username, password, obj,f);
		//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
		deleteNewRecord(driver, newRecord);

	}

	public void openReport(WebDriver driver) throws Exception{

		//Clicks on Open button
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Clicks on Save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		Thread.sleep(1000);
		//Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
	}


	public void downloadRecordChrome (WebDriver driver, String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		pdfCheck(get_date,get_time,get_dept,creationDate);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);

	}


	public void downloadRecordFirefox(WebDriver driver,  String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();

		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
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
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s"));
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();
		pdfCheck(get_date,get_time,get_dept,creationDate);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();


	}

	public void downloadRecordIE(WebDriver driver,  String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		Thread.sleep(2000);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
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
			deleteFiles(file);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
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
		pdfCheck(get_date,get_time,get_dept,creationDate);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);				    		    	
	}


	public void downloadRecordIE11(WebDriver driver,  String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();

		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
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
		pdfCheck(get_date,get_time,get_dept,creationDate);
		Thread.sleep(4000);
		//Close pdf
		//Switch to window    	
		driver.switchTo().window(window);			    		    	
	}


	public List<RenderedImage> getImagesFromPDF(PDDocument document) throws IOException {
		List<RenderedImage> images = new ArrayList<>();
		for (PDPage page : document.getPages()) {
			images.addAll(getImagesFromResources(page.getResources()));
		}

		return images;
	}

	private List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {
		List<RenderedImage> images = new ArrayList<>();

		for (COSName xObjectName : resources.getXObjectNames()) {
			PDXObject xObject = resources.getXObject(xObjectName);

			if (xObject instanceof PDFormXObject) {
				images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
			} else if (xObject instanceof PDImageXObject) {
				images.add(((PDImageXObject) xObject).getImage());
			}
		}

		return images;
	}

	public void pdfCheck( String get_date, String get_time, String get_dept, String creationDate) throws Exception{

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
		images=getImagesFromPDF(pddoc);
		System.out.println("Number of images: "+images.size());
		softly.assertThat(images.size()).as("test data").isEqualTo(10);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData="";
		for (int i = 0; i < ans.size(); i++)
		{

			//System.out.println(ans.get(i));
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData = newData+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData = newData+" "+ans.get(i);

		}
		newData=newData.replace("  ", " ");
		// System.out.println(newData);
		//Verifies event id
		event_id=event_id.replace("  ", " ");
		softly.assertThat(event_id).as("test data").isSubstringOf(newData);
		//Verifies title
		text184=text184.replace("  ", " ");
		softly.assertThat("Event title "+text184).as("test data").isSubstringOf(newData);
		//Verifies location of event
		text=text.replace("  ", " ");
		softly.assertThat(text).as("test data").isSubstringOf(newData);
		//Verifies investigators data
		paragraph_investigators=paragraph_investigators.replace("\n", "");
		paragraph_investigators=paragraph_investigators.replace("  ", " ");
		softly.assertThat("Investigators"+paragraph_investigators).as("test data").isSubstringOf(newData);
		//Verifies background data
		paragraph_background=paragraph_background.replace("\n", "");
		paragraph_background=paragraph_background.replace("  ", " ");
		softly.assertThat("Background information"+paragraph_background).as("test data").isSubstringOf(newData);
		//Verifies Timeline data
		paragraph_timeline=paragraph_timeline.replace("\n", "");
		paragraph_timeline=paragraph_timeline.replace("  ", " ");
		softly.assertThat("Timeline of event"+paragraph_timeline).as("test data").isSubstringOf(newData);
		//Verifies Problem statement
		paragraph_problem=paragraph_problem.replace("\n", "");
		paragraph_problem=paragraph_problem.replace("  ", " ");
		softly.assertThat("Problem statement"+paragraph_problem).as("test data").isSubstringOf(newData);
		//Verifies date
		softly.assertThat(get_date).as("test data").isSubstringOf(newData);
		//Verifies time
		softly.assertThat(get_time).as("test data").isSubstringOf(newData);
		//Verifies Department
		softly.assertThat(get_dept).as("test data").isSubstringOf(newData);
		//Verfies creation date
		softly.assertThat(creationDate).as("test data").isSubstringOf(newData);
		//Verifies executive summary
		executive=executive.replace("  ", " ");
		softly.assertThat(executive).as("test data").isSubstringOf(newData);
		//Verifies supporting reason in act of nature
		reason1=reason1.replace("  ", " ");
		softly.assertThat(reason1).as("test data").isSubstringOf(newData);
		//Verifies HiRCA self checklist
		softly.assertThat("General").as("test data").isSubstringOf(newData);
		softly.assertThat("All involved parties interviewed and all relevant data collected?").as("test data").isSubstringOf(newData);
		softly.assertThat("Past similar events examined?").as("test data").isSubstringOf(newData);
		softly.assertThat("Triggering event and related LOPs identified?").as("test data").isSubstringOf(newData);
		softly.assertThat("Triggering Event").as("test data").isSubstringOf(newData);
		softly.assertThat("Error type involving the triggering event determined?").as("test data").isSubstringOf(newData);
		softly.assertThat("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?").as("test data").isSubstringOf(newData);
		softly.assertThat("Contributing factors determined?").as("test data").isSubstringOf(newData);
		softly.assertThat("Root Causes").as("test data").isSubstringOf(newData);
		softly.assertThat("Root causes meeting SUEP").as("test data").isSubstringOf(newData);
		softly.assertThat("criteria?").as("test data").isSubstringOf(newData);
		softly.assertThat("Root causes surviving the CHOP'N").as("test data").isSubstringOf(newData);
		softly.assertThat("challenge?").as("test data").isSubstringOf(newData);
		softly.assertThat("Levels of importance for root causes identified?").as("test data").isSubstringOf(newData);
		softly.assertThat("Corrective Actions").as("test data").isSubstringOf(newData);
		softly.assertThat("Recommended corrective actions covering all root causes and contributing factors?").as("test data").isSubstringOf(newData);
		softly.assertThat("Recommended corrective actions cost effective?").as("test data").isSubstringOf(newData);
		//Verifies for Root Cause
		softly.assertThat("1.1 Was the triggering event a human error, an equipment failure, or an act of nature? Act of nature").as("test data").isSubstringOf(newData);
		softly.assertThat("1.2 What was the type of human error? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.3 For a rule-based error, was the error intentional or unintentional? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.4 Was the unintentional error related to inattention-to-detail behavior or inadequate rules? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.5 If I were the error-maker, would I make the same error? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.6 When the error-maker violated the established standards or policies, was there other staff looking on? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.7 Could the error have been prevented by self check or independent check? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.8 Was the error-maker trained to manage error-prone mental states and high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.9 Was the error-maker held accountable after the event by his or her supervisor or by management? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.10 If a PJB (or PSM, TO, MJB) was held, why was the participant not aware so that he or she could mitigate the risk? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.11 Why did this error occur now, and not before? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.12 If PJB (or PSM, TO, MJB) was not performed, why? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.13 Was the error contributed to by error-prone mental states and/ or high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.14 Did the supervisor conduct routine meetings to discuss lessons learned? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.15 Did the event involve a single-point-vulnerability item? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.16 Was the error related to inadequate supervision? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.17 Did inadequate management by the manager contribute to this error? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.18 Was the error caused by incorrect rules? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.19 Was there a rising trend of similar errors? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.20 Was the error contributed to by changes during jobs? n/a n/a").as("test data").isSubstringOf(newData);
		//Verify LOP failure inquiry
		softly.assertThat("Were there LOPs in place to prevent the triggering event? No n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("2.21 What LOPs can prevent this event from happening? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("2.22 Was HiRCA").as("test data").isSubstringOf(newData);
		softly.assertThat("adequate in leading this investigation? n/a n/a").as("test data").isSubstringOf(newData);
		//Verify SUEP
		softly.assertThat("Contributing factor(s) S U E P n/a n/a n/a n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("(SUEP) S: Substandard Practice? U: Under Management Control? E: Early in Event Sequence? P: Prevention Of Recurrence?").as("test data").isSubstringOf(newData);
		//Verify Missing LOPS
		softly.assertThat("Missing LOPs No missing LOPs specified").as("test data").isSubstringOf(newData);
		pddoc.close();	      
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

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		ErrorMeter obj = new ErrorMeter();
		String sharer = obj.decideSharer (y);
		String sharerAdded = obj.decideSharerAdded (y);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		ShareCheck obj1 = new ShareCheck();
		obj1.shareTwice (driver);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
		//Calls the Share check function
		obj1.receiptReport(driver, sharer, username, password1);
		//Clicks on HiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();;
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Checks if marked critical
		String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/thead/tr/th/strong"))).getText();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/thead/tr/th/strong")).isDisplayed())
			System.out.println("Marked critical");
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		if(driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/thead/tr/th/strong")).isDisplayed()==false)
			System.out.println("Unmarked critical");
		//Verify report not retrieved by shared to person
		ErrorMeter obj = new ErrorMeter();
		String sharer = obj.decideSharer (y);
		ShareCheck obj1 = new ShareCheck();
		obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on HiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
	}

	public void openCheckRecord(WebDriver driver, String username,  String get_date, String get_time, String get_dept, String creationDate) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Checks for Event title data
		String eve_title =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(eve_title).as("test data").isEqualTo(text184);
		//Checks for Date of event data
		String eve_date =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(eve_date).as("test data").isEqualTo(get_date);
		//Checks for Time of event data
		String eve_time =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[4]"))).getText();
		softly.assertThat(eve_time).as("test data").isEqualTo(get_time);
		//Checks for Location of event data
		String eve_loc =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(eve_loc).as("test data").isEqualTo(text);
		//Checks for Department data
		String eve_dept =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(eve_dept).as("test data").isEqualTo(get_dept);
		//Checks for Investigators data
		String eve_inv =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(eve_inv).as("test data").isEqualTo(paragraph_investigators);
		//Checks for Report creation date data
		String creation_date =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(creation_date).as("test data").isEqualTo(creationDate);
		//Checks for Problem statement data
		String eve_prob =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(eve_prob).as("test data").isEqualTo(paragraph_problem);
		//Checks for Timeline of event data
		String eve_timeline =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(eve_timeline).as("test data").isEqualTo(paragraph_timeline);
		//Checks for Background information data
		String eve_back =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(eve_back).as("test data").isEqualTo(paragraph_background);
		//Check for creator
		String eve_creator =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(username).as("test data").isSubstringOf(eve_creator);
		System.out.println(eve_creator);
		//Check for Event id
		String eve_id= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(event_id).as("test data").isSubstringOf(eve_id);
		System.out.println(eve_id);
		//Check for Executive summary
		String eve_exec =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(eve_exec).as("test data").isEqualTo(executive);
		//Verify the n/a in LOPs
		String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(lop1).as("test data").isEqualTo("n/a");
		String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(lop2).as("test data").isEqualTo("n/a");
		String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(lop3).as("test data").isEqualTo("n/a");
		String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(lop4).as("test data").isEqualTo("n/a");
		String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(lop5).as("test data").isEqualTo("n/a");
		String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(lop6).as("test data").isEqualTo("n/a");
		String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr/td"))).getText();
		softly.assertThat(lop7).as("test data").isEqualTo("No missing LOPs specified");
		//Verify root causes
		String rc1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(rc1).as("test data").isEqualTo("Act of nature");
		String rc2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(rc2).as("test data").isEqualTo(reason1);
		String rc3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(rc3).as("test data").isEqualTo("n/a");
		String rc4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(rc4).as("test data").isEqualTo("n/a");
		String rc5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(rc5).as("test data").isEqualTo("n/a");
		String rc6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(rc6).as("test data").isEqualTo("n/a");
		String rc7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(rc7).as("test data").isEqualTo("n/a");
		String rc8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(rc8).as("test data").isEqualTo("n/a");
		String rc9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(rc9).as("test data").isEqualTo("n/a");
		String rc10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(rc10).as("test data").isEqualTo("n/a");
		String rc11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(rc11).as("test data").isEqualTo("n/a");
		String rc12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(rc12).as("test data").isEqualTo("n/a");
		String rc13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(rc13).as("test data").isEqualTo("n/a");
		String rc14 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(rc14).as("test data").isEqualTo("n/a");
		String rc15 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(rc15).as("test data").isEqualTo("n/a");
		String rc16 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(rc16).as("test data").isEqualTo("n/a");
		String rc17 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(rc17).as("test data").isEqualTo("n/a");
		String rc18 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(rc18).as("test data").isEqualTo("n/a");
		String rc19 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(rc19).as("test data").isEqualTo("n/a");
		String rc20 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(rc20).as("test data").isEqualTo("n/a");
		String rc21 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(rc21).as("test data").isEqualTo("n/a");
		String rc22 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(rc22).as("test data").isEqualTo("n/a");
		String rc23 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(rc23).as("test data").isEqualTo("n/a");
		String rc24 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(rc24).as("test data").isEqualTo("n/a");
		String rc25 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(rc25).as("test data").isEqualTo("n/a");
		String rc26 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(rc26).as("test data").isEqualTo("n/a");
		String rc27 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(rc27).as("test data").isEqualTo("n/a");
		String rc28 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(rc28).as("test data").isEqualTo("n/a");
		String rc29 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(rc29).as("test data").isEqualTo("n/a");
		String rc30 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(rc30).as("test data").isEqualTo("n/a");
		String rc31 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(rc31).as("test data").isEqualTo("n/a");
		String rc32 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(rc32).as("test data").isEqualTo("n/a");
		String rc33 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(rc33).as("test data").isEqualTo("n/a");
		String rc34 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(rc34).as("test data").isEqualTo("n/a");
		String rc35 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(rc35).as("test data").isEqualTo("n/a");
		String rc36 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(rc36).as("test data").isEqualTo("n/a");
		String rc37 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(rc37).as("test data").isEqualTo("n/a");
		String rc38 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(rc38).as("test data").isEqualTo("n/a");
		String rc39 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(rc39).as("test data").isEqualTo("n/a");
		String rc40 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(rc40).as("test data").isEqualTo("n/a");
		//Verify LOP failure inquiry
		String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(lop8).as("test data").isEqualTo("No");
		String lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(lop9).as("test data").isEqualTo("n/a");
		String lop10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(lop10).as("test data").isEqualTo("n/a");
		String lop11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(lop11).as("test data").isEqualTo("n/a");
		String lop12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(lop12).as("test data").isEqualTo("n/a");
		String lop13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(lop13).as("test data").isEqualTo("n/a");
		//Verify SUEP
		String rc41 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(rc41).as("test data").isEqualTo("n/a");
		String rc42 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(rc42).as("test data").isEqualTo("n/a");
		String rc43 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(rc43).as("test data").isEqualTo("n/a");
		String rc44 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[4]"))).getText();
		softly.assertThat(rc44).as("test data").isEqualTo("n/a");
		String rc45 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[5]"))).getText();
		softly.assertThat(rc45).as("test data").isEqualTo("n/a");
		//Verify HiRCA checklist
		String rc46 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(rc46).as("test data").isEqualTo("General");
		String rc47 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(rc47).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
		String rc48 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(rc48).as("test data").isEqualTo("");
		String rc49 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(rc49).as("test data").isEqualTo("");
		String rc50 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(rc50).as("test data").isEqualTo("Past similar events examined?");
		String rc51 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(rc51).as("test data").isEqualTo("");
		String rc52 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(rc52).as("test data").isEqualTo("");
		String rc53 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(rc53).as("test data").isEqualTo("Triggering event and related LOPs identified?");
		String rc54 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(rc54).as("test data").isEqualTo("");
		String rc55 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(rc55).as("test data").isEqualTo("Triggering Event");
		String rc56 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(rc56).as("test data").isEqualTo("Error type involving the triggering event determined?");
		String rc57 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(rc57).as("test data").isEqualTo("");
		String rc58 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(rc58).as("test data").isEqualTo("");
		String rc59 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(rc59).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
		String rc60 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(rc60).as("test data").isEqualTo("");
		String rc61 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(rc61).as("test data").isEqualTo("");
		String rc62 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(rc62).as("test data").isEqualTo("Contributing factors determined?");
		String rc63 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(rc63).as("test data").isEqualTo("");
		String rc64 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(rc64).as("test data").isEqualTo("Root Causes");
		String rc65 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(rc65).as("test data").contains("Root causes meeting SUEP");
		softly.assertThat(rc65).as("test data").contains(" criteria?");
		String rc66 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(rc66).as("test data").isEqualTo("");
		String rc67 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(rc67).as("test data").isEqualTo("");
		String rc68 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(rc68).as("test data").contains("Root causes surviving the CHOP'N");
		softly.assertThat(rc68).as("test data").contains(" challenge?");
		String rc69 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(rc69).as("test data").isEqualTo("");
		String rc70 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(rc70).as("test data").isEqualTo("");
		String rc71 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(rc71).as("test data").isEqualTo("Levels of importance for root causes identified?");
		String rc72 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(rc72).as("test data").isEqualTo("");
		String rc73 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(rc73).as("test data").isEqualTo("Corrective Actions");
		String rc74 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(rc74).as("test data").contains("Recommended corrective actions covering all root causes and contributing factors?");
		String rc75 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(rc75).as("test data").isEqualTo("");
		String rc76 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(rc76).as("test data").isEqualTo("");
		String rc77 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(rc77).as("test data").isEqualTo("Recommended corrective actions cost effective?");
		String rc78 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(rc78).as("test data").isEqualTo("");
		jse.executeScript("scroll(0, 3300)");
		Thread.sleep(2000);
		int n =3500;
		//Checks the 5 images if appearing
		for (int j=0; j<5; j++)
		{				  
			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-h-event-report-filecollapsible-"+j;
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			n=n+1200;
			String scroll ="scroll(0,"+n+")";
			jse.executeScript(scroll);
			String img = "pii-irca-h-event-report-file-img-"+j;
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				System.out.println("Image "+ (j+1) + " is displayed");	

			}
		}
		Thread.sleep(1000);
		jse.executeScript("scroll(0, 0)");
	}

	public void rootCause(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on next
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		//Click on Act of Nature
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
		//Verify the texts on the options
		String hum_err = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		System.out.println(hum_err);
		softly.assertThat(hum_err).as("test data").isEqualTo("Human error");
		String eq_err = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		System.out.println(eq_err);
		softly.assertThat(eq_err).as("test data").isEqualTo("Equipment failure");
		String nat_err = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		System.out.println(nat_err);
		softly.assertThat(nat_err).as("test data").isEqualTo("Act of nature");
		String rc11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(rc11);
		softly.assertThat(rc11).as("test data").contains("[1.1] Was the triggering event a human error, an equipment failure, or an act of nature?");
		//Enter data in reason entry
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click on garbage can
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		//Clicks on clear answers
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pii-irca-dialog-title")));
		//Click on Act of Nature
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
		//Enter data in reason entry
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click on next
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Clicks on Root Cause
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Verify the n/a in LOPs
		String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(lop1);
		softly.assertThat(lop1).as("test data").isEqualTo("n/a");
		String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(lop2);
		softly.assertThat(lop2).as("test data").isEqualTo("n/a");
		String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(lop3);
		softly.assertThat(lop3).as("test data").isEqualTo("n/a");
		String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
		System.out.println(lop4);
		softly.assertThat(lop4).as("test data").isEqualTo("n/a");
		String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
		System.out.println(lop5);
		softly.assertThat(lop5).as("test data").isEqualTo("n/a");
		//Click on skip
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Verify the n/a in LOPs
		String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(lop6);
		softly.assertThat(lop6).as("test data").isEqualTo("n/a");
		String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(lop7);
		softly.assertThat(lop7).as("test data").isEqualTo("n/a");
		String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(lop8);
		softly.assertThat(lop8).as("test data").isEqualTo("n/a");
		//Click on skip
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Clicks on check boxes from top to bottom and unchecks them from bottom to top
		//Checks the check boxes
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
		//Unchecks them all
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		//Click on skip
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);		  
	}

	public void uploadFiveImagesChrome(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		int n=500;
		for (int j=0; j<5; j++)
		{

			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-event-filecollapsible-"+j;
			driver.findElement(By.id(id)).click();
			//Uploads file
			String file = "pii-irca-event-file-"+j;
			WebElement l=driver.findElement(By.id(file));
			Actions act= new Actions(driver);
			act.moveToElement(l).build().perform();
			l.sendKeys(filepath);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(1000);
				driver.findElement(By.id(del)).click(); 					  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				if(j!=0)
				{
					driver.findElement(By.id("pii-irca-addnewfile-button")).click();
					Thread.sleep(1000);
					n=n+80;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);
				}
				//Click on Supporting file details
				driver.findElement(By.id(id)).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				driver.findElement(By.id(file)).sendKeys(filepath);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					l=driver.findElement(By.id(rotate));
					act.moveToElement(l).build().perform();
					l.sendKeys(Keys.ARROW_DOWN);
					l.sendKeys(Keys.ARROW_DOWN);
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						if(j==4)
							jse.executeScript("scroll(0, 1000)");

						l.click();
					}
				}
				Thread.sleep(2000);
				//Debug
				//Clicks on save without images
				obj.scrollToTop(driver);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				Thread.sleep(2000);
				//Clicks on Save
				driver.findElement(By.id("efi-irca-button-save")).click();
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
				Thread.sleep(1500);
				//Wait for loading message to disappear
				obj.loadingServer(driver); 
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					jse.executeScript("scroll(0, 2200)");
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		jse.executeScript("scroll(0,600)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-4"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		//Upload image
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-4"))).sendKeys(filepath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		jse.executeScript("scroll(0, 2000)");
	}

	public void uploadFiveImagesFirefox(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		int n=500;
		for (int j=0; j<5; j++)
		{

			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-event-filecollapsible-"+j;
			driver.findElement(By.id(id)).click();
			//Uploads file
			String file = "pii-irca-event-file-"+j;
			WebElement l=driver.findElement(By.id(file));
			/*act.moveToElement(l).build().perform();*/
			jse.executeScript("arguments[0].scrollIntoView();", l);
			l.click();
			Thread.sleep(2000);
			Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
			p.waitFor();
			Thread.sleep(2000);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(1000);				  
				driver.findElement(By.id(del)).click(); 				  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				if(j!=0)
				{
					driver.findElement(By.id("pii-irca-addnewfile-button")).click();
					Thread.sleep(1000);
					n=n+80;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);
				}
				Thread.sleep(2000);
				//Click on Supporting file details
				driver.findElement(By.id(id)).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				l=driver.findElement(By.id(file));
				jse.executeScript("arguments[0].scrollIntoView();", l);
				l.click();
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
				q.waitFor();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						if(j==4)
							jse.executeScript("scroll(0, 1000)");
						l=driver.findElement(By.id(rotate));
						//act.moveToElement(l).build().perform();
						//jse.executeScript("arguments[0].scrollIntoView();", l);
						l.click();
					}
				}
				//Debug
				//Clicks on save without images
				obj.scrollToTop(driver);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				//Clicks on Save
				driver.findElement(By.id("efi-irca-button-save")).click();
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
				Thread.sleep(1500);
				//Wait for loading message to disappear
				obj.loadingServer(driver);  
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					jse.executeScript("scroll(0, 2000)");
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
					//jse.executeScript("arguments[0].scrollIntoView(true);", add);
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		jse.executeScript("scroll(0,600)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-4"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		//Upload image
		WebElement l=driver.findElement(By.id("pii-irca-event-file-4"));
		jse.executeScript("arguments[0].scrollIntoView();", l);
		l.click();
		Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
		q.waitFor();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		jse.executeScript("scroll(0, 2000)");

	}

	public void uploadFiveImagesIE(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		int n=450;
		for (int j=0; j<5; j++)
		{
			Actions act = new Actions(driver);
			//Click on Supporting file details
			Thread.sleep(1500);
			String id = "pii-irca-event-filecollapsible-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			//Uploads file
			String file = "pii-irca-event-file-"+j;/*
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(file))).click();
			  WebElement element =  driver.findElement(By.id(file));			  
			  act.doubleClick(element).build().perform();*/
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
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).click(); 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				if(j!=0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).click();
					Thread.sleep(1000);
					n=n+180;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);
				}
				//Click on Supporting file details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				/*  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(file))).click();
				  WebElement element1 =  driver.findElement(By.id(file));
				  Actions act1 = new Actions(driver);
				  act1.doubleClick(element1).build().perform();*/
				jse.executeScript("return document.getElementById('"+file+"').click();");
				Thread.sleep(8000);
				try {
					Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
					q.waitFor();
				}catch (UnhandledAlertException f){	
					System.out.println("Unexpecetd alert for picture 2");
					driver.switchTo().alert().accept();

				}catch (NoAlertPresentException f){
					System.out.println ("No unexpected alert for picture 2");
				}
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						if(j==4)
							jse.executeScript("scroll(0, 1000)");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))).click();
					}
				}
				//Debug
				//Clicks on save without images
				obj.scrollToTop(driver);
				Thread.sleep(3000);
				//Clicks on Save
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save")));
				act.click(ele).build().perform();
				Thread.sleep(3000);
				//Clicks on Save report
				/* try{
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpecetd alert");
					  driver.switchTo().alert().accept();

			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }*/
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
				Thread.sleep(1500);
				//Wait for loading message to disappear
				obj.loadingServer(driver); 		  
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					jse.executeScript("scroll(0, 1800)");
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button")));
					//jse.executeScript("arguments[0].scrollIntoView(true);", add);
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		jse.executeScript("scroll(0,600)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-4"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		//Upload image
		WebElement l=driver.findElement(By.id("pii-irca-event-file-4"));
		Actions act1 = new Actions(driver);
		act1.doubleClick(l).build().perform();
		Thread.sleep(8000);
		Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
		q.waitFor();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		jse.executeScript("scroll(0, 2000)");

	}


	public void uploadFiveImagesIE11(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		int n=500;
		int x=1800;
		for (int j=0; j<5; j++)
		{

			//Click on Supporting file details
			Thread.sleep(1500);
			String id = "pii-irca-event-filecollapsible-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			x=x+200;
			String scroll1 = "scroll(0,"+x+")";
			jse.executeScript(scroll1);
			//Uploads file
			String file = "pii-irca-event-file-"+j;/*
			  WebElement element =  driver.findElement(By.id(file));
			  Actions act = new Actions(driver);
			  act.click(element).build().perform();*/
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
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(1000);
				jse.executeScript("scroll(0,"+(x-150)+")");
				if(j==0||j==2||j==4 || j==3)
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).sendKeys(Keys.ARROW_UP);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).sendKeys(Keys.ARROW_UP);
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).click(); 				  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				if(j!=0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).click();
					Thread.sleep(1000);
					n=n+150;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);
				}
				//Click on Supporting file details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				/*  WebElement element1 =  driver.findElement(By.id(file));
				  Actions act1 = new Actions(driver);
				  act1.click(element1).build().perform();*/
				jse.executeScript("return document.getElementById('"+file+"').click();");
				Thread.sleep(2000);
				try {
					Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
					q.waitFor();
				}catch (UnhandledAlertException f){	
					System.out.println("Unexpecetd alert for picture 2");
					driver.switchTo().alert().accept();

				}catch (NoAlertPresentException f){
					System.out.println ("No unexpected alert for picture 2");
				}
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						if(j==4)
							jse.executeScript("scroll(0, 1000)");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))).click();
					}
				}
				//Debug
				//Clicks on save without images
				obj.scrollToTop(driver);
				Thread.sleep(2000);
				//Clicks on Save
				driver.findElement(By.id("efi-irca-button-save")).click();
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
				Thread.sleep(1500);
				//Wait for loading message to disappear
				obj.loadingServer(driver);		  
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					if(j<3)
					{ 
						jse.executeScript("scroll(0, 1600)");
					} 
					if(j>2)
					{ 
						jse.executeScript("scroll(0, 2000)");
					}
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button")));
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		jse.executeScript("scroll(0,600)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-4"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		//Upload image
		WebElement l=driver.findElement(By.id("pii-irca-event-file-4"));
		Actions act1 = new Actions(driver);
		act1.click(l).build().perform();
		Thread.sleep(8000);
		Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
		q.waitFor();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		obj.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(4000);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(2000);
		jse.executeScript("scroll(0, 2000)");
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
