package kaleTestSoftware;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese8 {

	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	
	public void selectAllChecklist(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
	}
	
	public void chineseLevel3SelectionsStep4_2nd(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").isEqualTo("3.17.1: ???????????????????????????????????????");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/strong"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("????????????");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label[1]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("????????????:");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label[2]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("????????????:");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label[3]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("????????????????????????????????????:");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/label"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").contains("????????????:");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/label/small"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/textarea"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").isEqualTo("??????????????????, ???????????????????????????????????????????????????, ????????????????????????????????????");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").isEqualTo("3.17.2: ????????????????????????/??????(QA/QC) ????????????????????????");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/label"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").contains("????????????:");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/label/small"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/textarea"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").isEqualTo("????????????QA/QC ??????");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[1]"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").isEqualTo("3.17.3: ????????????????????????????????????????????????");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/label"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").contains("????????????:");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/label/small"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/textarea"))).getText();
		System.out.println(tr15);
		softly.assertThat(tr15).as("test data").isEqualTo("???????????????????????????????????????");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		System.out.println(tr16);
		softly.assertThat(tr16).as("test data").isEqualTo("3.17.4: ???????????????: (1) ?????????????????????; (2) ?????????????????????; (3) ????????????");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]/label"))).getText();
		System.out.println(tr17);
		softly.assertThat(tr17).as("test data").contains("????????????:");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]/label/small"))).getText();
		System.out.println(tr18);
		softly.assertThat(tr18).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]/textarea"))).getText();
		System.out.println(tr19);
		softly.assertThat(tr19).as("test data").isEqualTo("??????????????????????????????, ????????????????????????????????????");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[1]"))).getText();
		System.out.println(tr20);
		softly.assertThat(tr20).as("test data").isEqualTo("3.17.5: ???????????????????????????");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]/label"))).getText();
		System.out.println(tr21);
		softly.assertThat(tr21).as("test data").contains("????????????:");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]/label/small"))).getText();
		System.out.println(tr22);
		softly.assertThat(tr22).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]/textarea"))).getText();
		System.out.println(tr23);
		softly.assertThat(tr23).as("test data").isEqualTo("????????????????????????");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[1]"))).getText();
		System.out.println(tr24);
		softly.assertThat(tr24).as("test data").isEqualTo("3.17.6: ???????????????");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]/label"))).getText();
		System.out.println(tr25);
		softly.assertThat(tr25).as("test data").contains("????????????:");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]/label/small"))).getText();
		System.out.println(tr26);
		softly.assertThat(tr26).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]/textarea"))).getText();
		System.out.println(tr27);
		softly.assertThat(tr27).as("test data").isEqualTo("???????????????????????????, ???????????????????????????");
		String tr28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[1]"))).getText();
		System.out.println(tr28);
		softly.assertThat(tr28).as("test data").isEqualTo("3.17.7: ?????????????????????????????????");
		String tr29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]/label"))).getText();
		System.out.println(tr29);
		softly.assertThat(tr29).as("test data").contains("????????????:");
		String tr30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]/label/small"))).getText();
		System.out.println(tr30);
		softly.assertThat(tr30).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		String tr31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]/textarea"))).getText();
		System.out.println(tr31);
		softly.assertThat(tr31).as("test data").isEqualTo("???????????????????????????");
		//Click on HML
		//High for 3.17.2
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/fieldset/div/div[1]/label")));
		share2.scrollToElement(driver, l);
		//Click H
		jse.executeScript("arguments[0].focus();", l);
		jse.executeScript("arguments[0].click();", l);
		//Medium for 3.17.3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/fieldset/div/div[2]/label")));
		share2.scrollToElement(driver, l);
		//Click M
		jse.executeScript("arguments[0].focus();", l);
		jse.executeScript("arguments[0].click();", l);
		//Low for 3.17.4
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/fieldset/div/div[3]/label")));
		share2.scrollToElement(driver, l);
		//Click L
		jse.executeScript("arguments[0].focus();", l);
		jse.executeScript("arguments[0].click();", l);
		//Scroll up
		share2.scrollToTop(driver);
	}
	
	public void chineseLevel3SelectionsSUEP2nd(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").isEqualTo("3.17.1 ???????????????????????????????????????");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").isEqualTo("3.17.2 ????????????????????????/??????(QA/QC) ????????????????????????");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").isEqualTo("3.17.3 ????????????????????????????????????????????????");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("3.17.4 ???????????????: (1) ?????????????????????; (2) ?????????????????????; (3) ????????????");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("3.17.5 ???????????????????????????");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").isEqualTo("3.17.6 ???????????????");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").isEqualTo("3.17.7 ?????????????????????????????????");
		//Select all 4 checkboxes for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]/div/input"))).click();
	}
	
	public void chineseHiRCASelfChecklistTitleReportTab (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//HiRCA self checklist chinese, none selected
		//Title
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[9]"))).getText();
		softly.assertThat(title2).as("test data").contains("????????????");
		//Heading
		String heading50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading50).as("test data").contains("??????");
		String heading51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading51).as("test data").contains("????????????");
		String heading52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading52).as("test data").contains("?????????????");
	}

	public void chineseLastTableReportTab (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//last table with reviewed by etc rows
		//title
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]"))).getText();
		softly.assertThat(title3).as("test data").contains("??????");
		//Rows
		String r703 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r703).as("test data").contains("??????");
		String r704 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r704).as("test data").contains("??????");
		String r705 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r705).as("test data").contains("??????");
		String r706 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r706).as("test data").contains("??????");
		String r707 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r707).as("test data").contains("??????");
		String r708 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r708).as("test data").contains("??????");
	}

	public void chineseSUEPFullFormReportTab (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//SUEP titles
		String r631 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[1]"))).getText();
		softly.assertThat(r631).as("test data").contains("???????????????????????????SUEP???");
		String r632 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[2]"))).getText();
		softly.assertThat(r632).as("test data").contains(": ??????????????????????????????????");
		String r633 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[3]"))).getText();
		softly.assertThat(r633).as("test data").contains(": ????????????????????????????");
		String r634 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[4]"))).getText();
		softly.assertThat(r634).as("test data").contains(": ????????????????????????????");
		String r635 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[5]"))).getText();
		softly.assertThat(r635).as("test data").contains(": ?????????????????????????");
		//SUEP table heading
		String heading49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading49).as("test data").contains("????????????");
	}
	
	public void chineseTable7ReportTab (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table 7 title
		String r621 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/div"))).getText();
		softly.assertThat(r621).as("test data").contains("????????????????????????");

		//Table 7 headings
		String heading461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading461).as("test data").contains("????????????");
		String heading47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading47).as("test data").contains("??????");
		String heading48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading48).as("test data").contains("????????????");
		//Table 7 rows
		String r622 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r622).as("test data").contains("???????????????????????????????????????????????????");
		String r623 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r623).as("test data").contains("?????????");
		String r624 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r624).as("test data").contains("?????????");
		String r625 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r625).as("test data").contains("2.21 ????????????????????????????????????");
		String r626 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r626).as("test data").contains("?????????");
		String r627 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r627).as("test data").contains("?????????");
		String r628 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r628).as("test data").contains("????????????????????????????????????????????????");
		String r629 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r629).as("test data").contains("?????????");
		String r630 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r630).as("test data").contains("?????????");		
	}
	
	public void downloadReportChrome (WebDriver driver, SoftAssertions softly, List<String> verifyChinese) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String window = driver.getWindowHandle();
		//Clicks on download button
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		//Save report with AutoIt script
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
			q.waitFor();
			Thread.sleep(3000);
		}catch (UnhandledAlertException f){	
			System.out.println("AutoItScript -SaveReport result: Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("AutoItScript -SaveReport result: No unexpected alert");
		}
		//pdf check
		pdfCheck(driver,softly,verifyChinese);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	public void downloadReportFirefox(WebDriver driver, SoftAssertions softly, List<String> verifyChinese) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(2000);/*
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();
		Thread.sleep(2000);
		//If no pdf repeat
		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException r)
		{
			//deletes files in reports folder before starting to download
			HiRCAEvent obj2 = new HiRCAEvent();
			obj2.deleteFiles(file);
			// press Ctrl+S the Robot's way
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_S);
			Thread.sleep(2000);
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
			q.waitFor();
			Thread.sleep(7000);
		}*/
		//pdf check
		pdfCheck(driver,softly,verifyChinese);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();      
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	public void downloadReportIE(WebDriver driver, SoftAssertions softly, List<String> verifyChinese)throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//If no pdf repeat
		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
			if(lastFilePath.get().endsWith(".pdf")==false)
				throw new NullPointerException("No pdf in ie10");
		}catch(java.util.NoSuchElementException | NullPointerException r)
		{
			//deletes files in reports folder before starting to download
			obj1.deleteFiles(file);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
			Thread.sleep(3000);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(3000);
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				q.waitFor();
			}catch (UnhandledAlertException f){	
				System.out.println("Unexpected alert");
				driver.switchTo().alert().accept();

			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert");
			}
			Thread.sleep(7000);
		}
		//pdf verification
		pdfCheck(driver,softly,verifyChinese);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	public void downloadReportIE11(WebDriver driver, SoftAssertions softly, List<String> verifyChinese)throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//If no pdf repeat
		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException r)
		{
			obj1.deleteFiles(file);
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
				q.waitFor();
			}catch (UnhandledAlertException f){	
				System.out.println("Unexpected alert");
				driver.switchTo().alert().accept();

			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert");
			}
			Thread.sleep(7000);
		}
		//pdf verification
		pdfCheck(driver,softly,verifyChinese);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);	
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	public void pdfCheck(WebDriver driver, SoftAssertions softly, List<String> verifyChinese) throws Exception {

		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{
			
		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+ans.get(i);	        	
		}
		//Verifies all chinese texts
		for(int i=0;i<verifyChinese.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(verifyChinese.get(i));
		}
		//Close pdf
		pddoc.close();
	}
}
