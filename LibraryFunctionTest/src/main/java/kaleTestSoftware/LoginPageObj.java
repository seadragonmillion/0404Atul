package kaleTestSoftware;

import org.openqa.selenium.By;


public class LoginPageObj {

	public By LoginButton = By.id("pii-login-button");
	public By UserName = By.id("pii-un");
	public By Password = By.id("pii-pw");
	public By SignInButton = By.id("pii-signin-button");
	public By SignInMessage = By.id("pii-signin-message");
	public By StickyNote = By.className("sticky-note");
	public By StickyClose = By.className("sticky-close");
	public By LoginNameOnTopRight = By.id("pii-user-loginname");
	public By LogOutButton = By.id("pii-signout-button");
	public By WebPageMessage = By.className("pii-slogan");
	public By AgreeTermsButton = By.xpath(".//*[@id='pii-license-checkbox-div']/fieldset/div/div/label");
	public By Iframe = By.xpath("//iframe[@name='pii-iframe-main']");
}
