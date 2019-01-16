import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class deleteNotifications {

	String urlDev= "https://kaleqa.error-free.com/";
	String urlUS= "https://kale.error-free.com/";

	private By IFrame = By.xpath("//iframe[@name='pii-iframe-main']");
	private By StickyPopUp = By.cssSelector(".sticky.border-top-right.sticky-error");
	private By StickyClose = By.className("sticky-close");
	private By NotificationBell = By.id("pii-notification-button");
	private By NotificationAllCheckBox = By.id("pii-notif-jqgrid_cb");
	private By NotificationDeleteButton = By.id("pii-notif-del-btn");
	private By NotificationReadConfirmButton = By.id("pii-notifcenter-dialog-confirmed");
	private By NotificationReadConfirmButton2 = By.id("pii-notif-dialog-confirmed");

	public String decideSharerRVVerifier(int y) throws Exception {
		
		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2=admin ie11
		 * 3=non admin ie11
		 * US
		 * 4=us admin
		 * 5=us non admin
		 * 6=us admin ie11
		 * 7=us non admin ie11
		 */
		if(y==0)
		{
			String sharer ="qaarvverifier1";
			return sharer;
		}
		if(y==1)
		{
			String sharer ="qaarvverifiernonadmin";
			return sharer;
		}
		if(y==2)
		{
			String sharer ="qaaie11rvverifier";
			return sharer;
		}
		if(y==3)
		{
			String sharer ="qaaie11rvverifiernonadmin";
			return sharer;
		}
		if(y==4)
		{
			String sharer ="qaausrvverifier";
			return sharer;
		}
		if(y==5)
		{
			String sharer ="qaausrvverifiernonadmin";
			return sharer;
		}
		if(y==6)
		{
			String sharer ="qaausie11rvverifier";
			return sharer;
		}		
		if(y==7)
		{
			String sharer ="qaarvverifier";
			return sharer;
		}
		else
		{
			String sharer ="qaausie11rvverifiernonadmin";
			return sharer;
		}
	}
	
	public String decideSharerAndroid (int y) throws Exception{

		/* Dev/Asia
		 * 0=android 7
		 * 1=android 8
		 * 2=android 9
		 * US
		 * 3=android 7
		 * 4=android 8
		 * 5=android 9
		 */
		if(y==0)
		{
			String sharer ="qaaandroidshare1";
			return sharer;
		}
		if(y==1)
		{
			String sharer ="qaaandroidshare2";
			return sharer;
		}
		if(y==2)
		{
			String sharer ="qaaandroidshare3";
			return sharer;
		}
		if(y==3)
		{
			String sharer ="qaausandroidshare1";
			return sharer;
		}
		if(y==4)
		{
			String sharer ="qaausandroidshare2";
			return sharer;
		}
		else
		{
			String sharer ="qaausandroidshare3";
			return sharer;
		}
	}

	public void deleteNotif(WebDriver driver,Login obj, int login) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj1 = new ShareCheck();
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(IFrame));
		Thread.sleep(5000);
		if (login==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(StickyPopUp);
					ele.findElement(StickyClose).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(4000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBell)).click();
		obj1.scrollToTop(driver);
		//Click on check box for selecting all noifications
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationAllCheckBox)).click();
		Thread.sleep(2000);
		//Click on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationDeleteButton)).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadConfirmButton)).click();
		}catch(org.openqa.selenium.TimeoutException r){
			wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadConfirmButton2)).click();
		}
		Thread.sleep(2000);
		obj1.loadingServer(driver);
		//LogOut
		obj.logout(driver);
		Thread.sleep(4000);		
	}

}
