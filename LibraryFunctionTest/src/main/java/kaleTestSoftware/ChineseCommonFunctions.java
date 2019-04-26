package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChineseCommonFunctions {

	EiRCAPageObj eirca = new EiRCAPageObj();

	public void verifyChineseAddSharerPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Verify pop up header
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
			softly.assertThat(s).as("test data").isEqualTo("共享报告");
			//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
			softly.assertThat(s1).as("test data").isEqualTo("请确认将此报告共享给 [QAA (jenkins_1_nonadmin)]?");
			//Verify note under question
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
			softly.assertThat(s4).as("test data").isEqualTo("注：保存后报告共享生效。");
			//Cancel button
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
			softly.assertThat(s2).as("test data").isEqualTo("取消");
			//Open button
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
			softly.assertThat(s3).as("test data").isEqualTo("共享");
		}
	}	
}
