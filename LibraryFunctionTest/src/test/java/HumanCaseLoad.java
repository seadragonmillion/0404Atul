import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HumanCaseLoad {
	
	String keyword1 = "Slide100images";
	String keyword2 = "Slide100NoImages";
	String keyword3 = "Slide100Images50";

	public long searchCase100(WebDriver driver, String keyword, String identifier) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		System.out.println("Case with only images");
		//Types in the keyword to get slide 4568
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on collapsible on Q4568
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-"+identifier))).click();
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.equals("Show Slides(101)")==false)
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
		driver.findElement(By.id("pii-slideshow-"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		long total=0;
		for(int i=0;i<n-1;i++)
		{
			long f1=System.currentTimeMillis();
			System.out.println("Slide "+(i+1));
			if(i==0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
			String load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-"+identifier+"-"+(i+1)))).getAttribute("src");
			while (load.contains("loading.gif")==true)
			{
				load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-"+identifier+"-"+(i+1)))).getAttribute("src");	
			}
			long f2=System.currentTimeMillis();
			System.out.println("Total loading time in milliseconds: "+ (f2-f1));
			total=total+(f2-f1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
		System.out.println("Total time in milliseconds for case with only images:"+total);
		System.out.println("Total time in seconds for case with only images:"+(total/1000));
		long total1=total;
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		return total1;
	}

}
