package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCAChinese34 {

	ShareCheck share = new ShareCheck();
	
	public void chineseAddContributingFactor(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Scroll down
		share.scrollToAPoint(driver, 1300);
		//Click on add contributing factor
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).click();
		//Scroll down
		share.scrollToAPoint(driver, 1400);
		//Verify all labels
		String label1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-addnewcf-cf']"))).getText();
		softly.assertThat(label1).as("test data").contains("促成因素:");
		String label2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-addnewcf-fi']"))).getText();
		softly.assertThat(label2).as("test data").contains("进一步调查:");
		String label3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-addnewcf-ca']"))).getText();
		softly.assertThat(label3).as("test data").contains("可能的纠正行动:");
		//Verify placeholders
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-cf"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 促成因素");
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-fi"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 进一步调查 (非必填)");
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-ca"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 可能的纠正行动 (非必填)");
		//Cancel button
		String cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-cancel"))).getText();
		softly.assertThat(cancel).as("test data").contains("取消");
		//Save button
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-save"))).getText();
		softly.assertThat(save).as("test data").contains("保存");
		//Scroll up
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(2000);
	}
}
