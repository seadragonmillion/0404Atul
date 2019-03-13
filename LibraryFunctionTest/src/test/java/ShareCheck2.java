import org.openqa.selenium.WebDriver;


public class ShareCheck2 {

	ShareCheckPageObj share = new ShareCheckPageObj();

	public void loadingServer(WebDriver driver) throws Exception {

		while (true)
		{
			try{
				Thread.sleep(4000);
				if(driver.findElement(share.LoadingMessage).isDisplayed())
				{
					Thread.sleep(5000);
				}
				else
					break;
			}catch (org.openqa.selenium.NoSuchElementException |org.openqa.selenium.StaleElementReferenceException e)
			{
				break;
			}
			catch (org.openqa.selenium.ScriptTimeoutException e)
			{
				Thread.sleep(6000);
			}
		}
	}

}
