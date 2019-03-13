import org.openqa.selenium.By;


public class LoginPageObj {

	By LoginButton = By.id("pii-login-button");
	By UserName = By.id("pii-un");
	By Password = By.id("pii-pw");
	By SignInButton = By.id("pii-signin-button");
	By SignInMessage = By.id("pii-signin-message");
	By StickyNote = By.className("sticky-note");
	By StickyClose = By.className("sticky-close");
	By LoginNameOnTopRight = By.id("pii-user-loginname");
	By LogOutButton = By.id("pii-signout-button");
	By WebPageMessage = By.className("pii-slogan");
	By AgreeTermsButton = By.xpath(".//*[@id='pii-license-checkbox-div']/fieldset/div/div/label");
	By Iframe = By.xpath("//iframe[@name='pii-iframe-main']");
}
