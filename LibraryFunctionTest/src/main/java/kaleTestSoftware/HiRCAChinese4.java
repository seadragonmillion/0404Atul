package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese4 {
	
	HiRCAChinese6 hc6 = new HiRCAChinese6();
	ShareCheck share = new ShareCheck();

	public void chineseStepOneL31 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(heading).as("test data").contains("个人层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这些促成因素归因于个人，因为这关系到影响组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.1.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.1.1] 能力不足");
		//Click on 3.1.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();

		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.1.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.1.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c2).as("test data").contains("重复失误？");
		//Click on 2nd collapsible for 3.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.1.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c3).as("test data").contains("重新调到合适岗位");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c37).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.1.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.1.2] 态度和任务不匹配");
		//Click on 3.1.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();

		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");

		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.1.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.1.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.1.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c5).as("test data").contains("性格-态度分析？");
		//Click on 2nd collapsible for 3.1.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.1.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.1.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c6).as("test data").contains("改善任务分工策略");
		//Click on 3rd collapsible for 3.1.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.1.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.1.3] 性格和任务不匹配");
		//Click on 3.1.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");

		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.1.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.1.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.1.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c8).as("test data").contains("性格-态度分析？");
		//Click on 2nd collapsible for 3.1.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.1.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.1.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c9).as("test data").contains("改善任务分工策略");
		//Click on 3rd collapsible for 3.1.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.1.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.1.4] 缺乏专业经验");
		//Click on 3.1.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.1.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.1.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.1.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c14).as("test data").contains("工作历史？");
		//Click on 2nd collapsible for 3.1.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.1.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.1.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("PJB 和MJB上提供即时经验提醒");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c15).as("test data").contains("辅导");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();

		softly.assertThat(c23).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.1.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.1.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.1.5] 对自我缺点认识不足，缺乏相应弥补措施");
		//Click on 3.1.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.1.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.1.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.1.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c19).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.1.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.1.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.1.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("辅导");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c26).as("test data").contains("自我分析培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();

		softly.assertThat(c24).as("test data").contains("开展自我分析");
		//Click on 3rd collapsible for 3.1.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		share.scrollToAPoint(driver, 1200);
		//3.1.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();		
		softly.assertThat(q396).as("test data").contains("[3.1.6] 不适合工作（生病、有心事等）");
		//Click on 3.1.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();		
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");		
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.1.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.1.6
		String c151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c151);
		softly.assertThat(c151).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.1.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c28).as("test data").contains("访谈同事？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c29).as("test data").contains("访谈主管？");
		//Click on 2nd collapsible for 3.1.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.1.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.1.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("监督性行为跟踪培训");
		//Click on 3rd collapsible for 3.1.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc6.chineseAddContributingFactor(driver,softly);
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneL321 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("高风险情况(");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("30%的错误是由高风险情况所影响导致的。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.21.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.21.1] 未能识别和缓解时间相关的高风险情况，例如日常失误陷阱、工作时间、节假日影响等");
		//Click on 3.21.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();		
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.21.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.21.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.21.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("高风险情境警觉培训？");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c27).as("test data").contains("作业前意识系统的完善？");
		//Click on 2nd collapsible for 3.21.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.21.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.21.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c3).as("test data").contains("高风险情境警觉培训");
		//Click on 3rd collapsible for 3.21.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.21.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.21.2] 未能识别和缓解活动相关的高风险情况，例如伪装的首次执行操作、利益失衡、单项弱点失去管理、专门技能缺陷等等");
		//Click on 3.21.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();		
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");		
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.21.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.21.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.21.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("高风险情境警觉培训？");
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c51).as("test data").contains("作业前意识系统的完善？");
		//Click on 2nd collapsible for 3.21.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.21.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.21.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c6).as("test data").contains("高风险情境警觉培训");
		//Click on 3rd collapsible for 3.21.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.21.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.21.3] 未能识别和缓解人员相关的高风险情况，例如能力、态度、性格、与人打交道的经验存在不足");
		//Click on 3.21.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();		
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");		
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.21.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.21.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.21.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c8).as("test data").contains("高风险情境警觉培训？");
		String c81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c81);
		softly.assertThat(c81).as("test data").contains("作业前意识系统的完善？");
		//Click on 2nd collapsible for 3.21.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.21.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.21.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("高风险情境警觉培训");
		//Click on 3rd collapsible for 3.21.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.21.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.21.4] 未能识别和缓解环境相关的高风险情况，例如工作条件恶劣（温度、照明、噪音、高辐射水平等等）以及人机接口（标牌、显示屏、控制器等）");
		//Click on 3.21.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();		
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");		
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.21.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.21.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.21.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c14).as("test data").contains("高风险情境警觉培训？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("作业前意识系统的完善？");
		//Click on 2nd collapsible for 3.21.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.21.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.21.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("高风险情境警觉培训");
		//Click on 3rd collapsible for 3.21.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();		
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc6.chineseAddContributingFactor(driver,softly);
	}
	
	public void chineseStepOneL39 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(heading).as("test data").contains("培训");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("若培训不充分导致失误发生，需要探讨是培训范围和内容还是实际教学出问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.9.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.9.1] 培训材料在适用性、及时性或实用性方面有所欠缺");
		//Click on 3.9.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();

		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.9.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.9.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("与类似组织对标？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c22).as("test data").contains("通过现场观察审查培训效果？");
		//Click on 2nd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c3).as("test data").contains("加强培训资源");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c27).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		//Click on 3rd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.9.2] 复训频率不高(>> 一年)");
		//Click on 3.9.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();

		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");

		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.9.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.9.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("复训的形式？");
		//Click on 2nd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c6).as("test data").contains("增加复训频率，改善复训形式");
		//Click on 3rd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.9.3] 部门管理层未充分参与培训材料的编写和培训的实施");
		//Click on 3.9.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");

		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.9.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.9.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c8).as("test data").contains("部门经理审查关于培训材料的意见？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c25).as("test data").contains("部门经理监督对上课情况？");
		//Click on 2nd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c9).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		//Click on 3rd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.9.4] 未将经验教训充分包含到培训中");
		//Click on 3.9.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.9.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.9.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c14).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		//Click on 2nd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c17).as("test data").contains("提高对培训效果的审查");
		//Click on 3rd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.9.5] 所需培训开展不充分（脱岗）");
		//Click on 3.9.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.9.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.9.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c19).as("test data").contains("培训签到表，%员工接受了培训？");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c24).as("test data").contains("现场承包商没有经过培训？");
		//Click on 2nd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("完善承包商控制方针");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c26).as("test data").contains("完善培训资源");
		//Click on 3rd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		share.scrollToAPoint(driver, 1200);
		//3.9.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();

		softly.assertThat(q396).as("test data").contains("[3.9.6] 所需培训开展不充分（在岗）");
		//Click on 3.9.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();

		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");

		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.9.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.9.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c28).as("test data").contains("在岗培训方针？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c29).as("test data").contains("经验不足的员工没有经过培训？");
		//Click on 2nd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("完善在岗培训方针");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c32).as("test data").contains("完善培训资源");
		//Click on 3rd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc6.chineseAddContributingFactor(driver,softly);
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(2000);
	}


	public void chineseStepOneL315 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("同事互助提醒（好文化）");
		softly.assertThat(heading).as("test data").contains("不充分的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("缺乏同事互助提醒是否是这个失误的促成因素？如果是，同事互助提醒为什么会缺乏或无效？同事互助（好文化）是指互相指导或协助，帮助对方免受受害或违反规则。只有在同事互助按照制度标准建立、工作人员经过培训且对指导对方负责的情况下，同事互助才有效。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.15.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.15.1] 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		//Click on 3.15.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();		
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.15.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.15.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c2).as("test data").contains("审查相关培训？");
		//Click on 2nd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c3).as("test data").contains("同事互助提醒（好文化）培训");
		//Click on 3rd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.15.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.15.2] 未要求员工对纠正他人违规的情况承担责任");
		//Click on 3.15.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();		
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");		
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.15.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.15.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c5).as("test data").contains("审查关于同事互助提醒（好文化）的管理期望和标准？");
		//Click on 2nd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c6).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		//Click on 3rd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.15.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.15.3] 员工未充分理解相关行为规范");
		//Click on 3.15.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");		
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.15.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.15.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c8).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		//Click on 2nd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("行为规范培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("采用行为规范提醒物");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();

		softly.assertThat(c24).as("test data").contains("采用禁止事项警告清单");
		//Click on 3rd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.15.4] 主管未到现场强化");
		softly.assertThat(q344).as("test data").contains("同事指导");
		//Click on 3.15.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();		
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");		
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.15.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.15.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c14).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		//Click on 2nd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("监督管理能力培训");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c15).as("test data").contains("就监督管理强化，对管理者实施问责");
		//Click on 3rd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();		
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc6.chineseAddContributingFactor(driver,softly);
	}


	public void chineseStepOneL318 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("知识型错误");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("是否有证据表明以下思维模式促使犯错人员在本失误中的判断错误？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.18.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.18.1] 盲目信任: 关键信息使用质疑的态度QV&V℠不到位");
		//Click on 3.18.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();		
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.18.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.18.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("审查培训材料？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c22).as("test data").contains("审查以往类似事件？");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c3).as("test data").contains("提高质疑的态度");
		softly.assertThat(c3).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.18.2] 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		//Click on 3.18.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();		
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");		
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.18.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.18.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("过去有过超出能力工作的事件?");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c24).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c6).as("test data").contains("行为培训，避免过度自信");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.18.3] 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		//Click on 3.18.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();		
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");		
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.18.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.18.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c8).as("test data").contains("因忽略相关风险而未设置屏障");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c25).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("改善风险控制项目");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c26).as("test data").contains("完善");
		softly.assertThat(c26).as("test data").contains("体系");
		//Click on 3rd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.18.4] 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		//Click on 3.18.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.18.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.18.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c14).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c17).as("test data").contains("审查以往决策的有效性，提高管理监督");
		//Click on 3rd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.18.5] 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		//Click on 3.18.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.18.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.18.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c19).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c21).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//Click on 3rd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc6.chineseAddContributingFactor(driver,softly);
	}

	public void chineseStepOneL34 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("关键思考和关键追问不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();		
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("是否多次遇到过这样的情况：如果花时间进行关键思考或关键追问，本来可以缓解失误？关键思考指的是省思如何让一天或一项任务获得成功；包括检查个人和他人的精神状态或检查程序问题。关键追问指的是探讨准备工作是否足以取得成功；包括澄清任何未知情况。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.4.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.4.1] 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		//Click on 3.4.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();		
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.4.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.4.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c2).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c3).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.4.2] 采取行动前没有考虑易出错的心理状况");
		//Click on 3.4.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();		
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");		
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.4.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.4.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c5).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c6).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.4.3] 采取行动前没有考虑高风险情境（如单项弱点）");
		//Click on 3.4.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();		
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");		
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.4.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.4.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c8).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c9).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();		
		softly.assertThat(q344).as("test data").contains("[3.4.4] 感到疑惑时质疑不充分");
		//Click on 3.4.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();		
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");		
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.4.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.4.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c14).as("test data").contains("访谈犯错者");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c15).as("test data").contains("访谈主管");
		//Click on 2nd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c17).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.4.5] 任务准备过程中质疑不充分");
		//Click on 3.4.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();		
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");		
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.4.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.4.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c19).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c21).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc6.chineseAddContributingFactor(driver,softly);
	}

	
	public void chineseLevel3SelectionsStep4_1st(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").isEqualTo("3.2.1: 组长强化标准方面的管理能力不足");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label"))).getText();
		softly.assertThat(tr1).as("test data").contains("纠正行动:");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label/small"))).getText();
		softly.assertThat(tr2).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/textarea"))).getText();
		softly.assertThat(tr3).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(tr4).as("test data").isEqualTo("3.2.2: 组长绩效反馈方面的管理能力不足");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]/label"))).getText();
		softly.assertThat(tr5).as("test data").contains("纠正行动:");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]/label/small"))).getText();
		softly.assertThat(tr6).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]/textarea"))).getText();
		softly.assertThat(tr7).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(tr8).as("test data").isEqualTo("3.2.3: 组长召开经验反馈的管理技能不足");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]/label"))).getText();
		softly.assertThat(tr9).as("test data").contains("纠正行动:");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]/label/small"))).getText();
		softly.assertThat(tr10).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]/textarea"))).getText();
		softly.assertThat(tr11).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(tr12).as("test data").isEqualTo("3.2.4: 组长在岗培训方面管理能力不足");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]/label"))).getText();
		softly.assertThat(tr13).as("test data").contains("纠正行动:");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]/label/small"))).getText();
		softly.assertThat(tr14).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]/textarea"))).getText();
		softly.assertThat(tr15).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(tr16).as("test data").isEqualTo("3.2.5: 组长对团队缺点认识不足，缺乏相应弥补措施");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]/label"))).getText();
		softly.assertThat(tr17).as("test data").contains("纠正行动:");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]/label/small"))).getText();
		softly.assertThat(tr18).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]/textarea"))).getText();
		softly.assertThat(tr19).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(tr20).as("test data").isEqualTo("3.2.6: 组长发出指令和后续贯彻的沟通及协调能力不足");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]/label"))).getText();
		softly.assertThat(tr21).as("test data").contains("纠正行动:");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]/label/small"))).getText();
		softly.assertThat(tr22).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]/textarea"))).getText();
		softly.assertThat(tr23).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(tr24).as("test data").isEqualTo("3.3.1: 经理团队资源分配不到位");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]/label"))).getText();
		softly.assertThat(tr25).as("test data").contains("纠正行动:");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]/label/small"))).getText();
		softly.assertThat(tr26).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]/textarea"))).getText();
		softly.assertThat(tr27).as("test data").isEqualTo("提升管理技能，完善资源分配体系");
		String tr28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(tr28).as("test data").isEqualTo("3.3.2: 经理团队所需培训开展不充分");
		String tr29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]/label"))).getText();
		softly.assertThat(tr29).as("test data").contains("纠正行动:");
		String tr30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]/label/small"))).getText();
		softly.assertThat(tr30).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]/textarea"))).getText();
		softly.assertThat(tr31).as("test data").isEqualTo("成立培训计划委员会");
		String tr32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(tr32).as("test data").isEqualTo("3.3.3: 经理团队问责制不到位");
		String tr33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]/label"))).getText();
		softly.assertThat(tr33).as("test data").contains("纠正行动:");
		String tr34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]/label/small"))).getText();
		softly.assertThat(tr34).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]/textarea"))).getText();
		softly.assertThat(tr35).as("test data").isEqualTo("完善问责制");
		String tr36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(tr36).as("test data").isEqualTo("3.3.4: 经理团队对确定工作优先级和计划方面不到位");
		String tr37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]/label"))).getText();
		softly.assertThat(tr37).as("test data").contains("纠正行动:");
		String tr38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]/label/small"))).getText();
		softly.assertThat(tr38).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]/textarea"))).getText();
		softly.assertThat(tr39).as("test data").contains("完善管理优先级确定和计划体系");
		String tr40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(tr40).as("test data").isEqualTo("3.3.5: 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String tr41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]/label"))).getText();
		softly.assertThat(tr41).as("test data").contains("纠正行动:");
		String tr42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]/label/small"))).getText();
		softly.assertThat(tr42).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]/textarea"))).getText();
		softly.assertThat(tr43).as("test data").isEqualTo("开展关于标准设定的管理培训, 开展关于程序和保护屏障设计的培训");
		String tr44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(tr44).as("test data").isEqualTo("3.3.6: 经理团队绩效跟踪与趋势分析不到位");
		String tr45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]/label"))).getText();
		softly.assertThat(tr45).as("test data").contains("纠正行动:");
		String tr46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]/label/small"))).getText();
		softly.assertThat(tr46).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]/textarea"))).getText();
		softly.assertThat(tr47).as("test data").isEqualTo("定期开展共因分析, 改善绩效跟踪与趋势分析项目, 完善KPI");
		String tr48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[38]/td[1]"))).getText();
		softly.assertThat(tr48).as("test data").isEqualTo("3.3.7: 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String tr49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]/label"))).getText();
		softly.assertThat(tr49).as("test data").contains("纠正行动:");
		String tr50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]/label/small"))).getText();
		softly.assertThat(tr50).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]/textarea"))).getText();
		softly.assertThat(tr51).as("test data").isEqualTo("开展组织设计方面的管理培训, 在经理人员之间建立共同目标、共同利益和共同责任");
		String tr52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(tr52).as("test data").isEqualTo("3.3.8: 经理团队纠正行动不足");
		String tr53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]/label"))).getText();
		softly.assertThat(tr53).as("test data").contains("纠正行动:");
		String tr54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]/label/small"))).getText();
		softly.assertThat(tr54).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]/textarea"))).getText();
		softly.assertThat(tr55).as("test data").isEqualTo("提高纠正行动计划的落实, 改善根本原因分析方法, 完善突发紧急问题（危机）管理机制");
		String tr56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(tr56).as("test data").isEqualTo("3.3.9: 经理团队垂直沟通体系不完善");
		String tr57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]/label"))).getText();
		softly.assertThat(tr57).as("test data").contains("纠正行动:");
		String tr58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]/label/small"))).getText();
		softly.assertThat(tr58).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]/textarea"))).getText();
		softly.assertThat(tr59).as("test data").isEqualTo("完善垂直沟通体系");
		String tr60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(tr60).as("test data").isEqualTo("3.3.10: 经理团队横向沟通体系不完善");
		String tr61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]/label"))).getText();
		softly.assertThat(tr61).as("test data").contains("纠正行动:");
		String tr62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]/label/small"))).getText();
		softly.assertThat(tr62).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]/textarea"))).getText();
		softly.assertThat(tr63).as("test data").isEqualTo("完善程序设计, 制定共同目标和共同利益");
		String tr64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(tr64).as("test data").isEqualTo("3.4.1: 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String tr65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]/label"))).getText();
		softly.assertThat(tr65).as("test data").contains("纠正行动:");
		String tr66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]/label/small"))).getText();
		softly.assertThat(tr66).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]/textarea"))).getText();
		softly.assertThat(tr67).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[53]/td[1]"))).getText();
		softly.assertThat(tr68).as("test data").isEqualTo("3.4.2: 采取行动前没有考虑易出错的心理状况");
		String tr69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]/label"))).getText();
		softly.assertThat(tr69).as("test data").contains("纠正行动:");
		String tr70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]/label/small"))).getText();
		softly.assertThat(tr70).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]/textarea"))).getText();
		softly.assertThat(tr71).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[56]/td[1]"))).getText();
		softly.assertThat(tr72).as("test data").isEqualTo("3.4.3: 采取行动前没有考虑高风险情境（如单项弱点）");
		String tr73 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]/label"))).getText();
		softly.assertThat(tr73).as("test data").contains("纠正行动:");
		String tr74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]/label/small"))).getText();
		softly.assertThat(tr74).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]/textarea"))).getText();
		softly.assertThat(tr75).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[59]/td[1]"))).getText();
		softly.assertThat(tr76).as("test data").isEqualTo("3.4.4: 感到疑惑时质疑不充分");
		String tr77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]/label"))).getText();
		softly.assertThat(tr77).as("test data").contains("纠正行动:");
		String tr78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]/label/small"))).getText();
		softly.assertThat(tr78).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]/textarea"))).getText();
		softly.assertThat(tr79).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[62]/td[1]"))).getText();
		softly.assertThat(tr80).as("test data").isEqualTo("3.4.5: 任务准备过程中质疑不充分");
		String tr81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]/label"))).getText();
		softly.assertThat(tr81).as("test data").contains("纠正行动:");
		String tr82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]/label/small"))).getText();
		softly.assertThat(tr82).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]/textarea"))).getText();
		softly.assertThat(tr83).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[65]/td[1]"))).getText();
		softly.assertThat(tr84).as("test data").isEqualTo("3.5.1: 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String tr85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[67]/td[1]/label"))).getText();
		softly.assertThat(tr85).as("test data").contains("纠正行动:");
		String tr86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[67]/td[1]/label/small"))).getText();
		softly.assertThat(tr86).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[67]/td[1]/textarea"))).getText();
		softly.assertThat(tr87).as("test data").isEqualTo("情况警觉培训, 作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String tr88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[68]/td[1]"))).getText();
		softly.assertThat(tr88).as("test data").isEqualTo("3.5.2: 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String tr89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[70]/td[1]/label"))).getText();
		softly.assertThat(tr89).as("test data").contains("纠正行动:");
		String tr90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[70]/td[1]/label/small"))).getText();
		softly.assertThat(tr90).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[70]/td[1]/textarea"))).getText();
		softly.assertThat(tr91).as("test data").isEqualTo("情况警觉培训");
		String tr92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[71]/td[1]"))).getText();
		softly.assertThat(tr92).as("test data").isEqualTo("3.5.3: 对人员表现的观察技能不足");
		String tr93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[73]/td[1]/label"))).getText();
		softly.assertThat(tr93).as("test data").contains("纠正行动:");
		String tr94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[73]/td[1]/label/small"))).getText();
		softly.assertThat(tr94).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[73]/td[1]/textarea"))).getText();
		softly.assertThat(tr95).as("test data").isEqualTo("开展人员表现观察技能方面的培训");
		String tr96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[74]/td[1]"))).getText();
		softly.assertThat(tr96).as("test data").isEqualTo("3.5.4: 对设备性能的观察技能不足");
		String tr97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[76]/td[1]/label"))).getText();
		softly.assertThat(tr97).as("test data").contains("纠正行动:");
		String tr98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[76]/td[1]/label/small"))).getText();
		softly.assertThat(tr98).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[76]/td[1]/textarea"))).getText();
		softly.assertThat(tr99).as("test data").isEqualTo("开展退化、异常和变化等设备性能观察技能方面的培训");
		String tr100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[77]/td[1]"))).getText();
		softly.assertThat(tr100).as("test data").isEqualTo("3.6.1: 要求有遗漏");
		String tr101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[79]/td[1]/label"))).getText();
		softly.assertThat(tr101).as("test data").contains("纠正行动:");
		String tr102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[79]/td[1]/label/small"))).getText();
		softly.assertThat(tr102).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[79]/td[1]/textarea"))).getText();
		softly.assertThat(tr103).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[80]/td[1]"))).getText();
		softly.assertThat(tr104).as("test data").isEqualTo("3.6.2: 运行条件有遗漏");
		String tr105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[82]/td[1]/label"))).getText();
		softly.assertThat(tr105).as("test data").contains("纠正行动:");
		String tr106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[82]/td[1]/label/small"))).getText();
		softly.assertThat(tr106).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[82]/td[1]/textarea"))).getText();
		softly.assertThat(tr107).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[83]/td[1]"))).getText();
		softly.assertThat(tr108).as("test data").isEqualTo("3.6.3: 假设有遗漏");
		String tr109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[85]/td[1]/label"))).getText();
		softly.assertThat(tr109).as("test data").contains("纠正行动:");
		String tr110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[85]/td[1]/label/small"))).getText();
		softly.assertThat(tr110).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[85]/td[1]/textarea"))).getText();
		softly.assertThat(tr111).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[86]/td[1]"))).getText();
		softly.assertThat(tr112).as("test data").isEqualTo("3.6.4: 范围有遗漏");
		String tr113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[88]/td[1]/label"))).getText();
		softly.assertThat(tr113).as("test data").contains("纠正行动:");
		String tr114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[88]/td[1]/label/small"))).getText();
		softly.assertThat(tr114).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[88]/td[1]/textarea"))).getText();
		softly.assertThat(tr115).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[89]/td[1]"))).getText();
		softly.assertThat(tr116).as("test data").isEqualTo("3.6.5: 试验或测量有遗漏");
		String tr117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[91]/td[1]/label"))).getText();
		softly.assertThat(tr117).as("test data").contains("纠正行动:");
		String tr118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[91]/td[1]/label/small"))).getText();
		softly.assertThat(tr118).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[91]/td[1]/textarea"))).getText();
		softly.assertThat(tr119).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[92]/td[1]"))).getText();
		softly.assertThat(tr120).as("test data").contains("3.6.6: 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(tr120).as("test data").contains("不准做清单");
		softly.assertThat(tr120).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String tr121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[94]/td[1]/label"))).getText();
		softly.assertThat(tr121).as("test data").contains("纠正行动:");
		String tr122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[94]/td[1]/label/small"))).getText();
		softly.assertThat(tr122).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[94]/td[1]/textarea"))).getText();
		softly.assertThat(tr123).as("test data").isEqualTo("开展程序设计编写培训, 改善程序编写导则");
		String tr124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[95]/td[1]"))).getText();
		softly.assertThat(tr124).as("test data").isEqualTo("3.6.7: 审查不到位导致制度有遗漏项");
		String tr125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[97]/td[1]/label"))).getText();
		softly.assertThat(tr125).as("test data").contains("纠正行动:");
		String tr126 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[97]/td[1]/label/small"))).getText();
		softly.assertThat(tr126).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr127 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[97]/td[1]/textarea"))).getText();
		softly.assertThat(tr127).as("test data").isEqualTo("开展程序审查培训");
		String tr128 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[98]/td[1]"))).getText();
		softly.assertThat(tr128).as("test data").isEqualTo("3.6.8: 根本原因分析不到位导致制度有遗漏项");
		String tr129 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[100]/td[1]/label"))).getText();
		System.out.println(tr129);
		softly.assertThat(tr129).as("test data").contains("纠正行动:");
		String tr130 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[100]/td[1]/label/small"))).getText();
		System.out.println(tr130);
		softly.assertThat(tr130).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[100]/td[1]/textarea"))).getText();
		System.out.println(tr131);
		softly.assertThat(tr131).as("test data").isEqualTo("开展根本原因培训");
		String tr132 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[101]/td[1]"))).getText();
		System.out.println(tr132);
		softly.assertThat(tr132).as("test data").isEqualTo("3.6.9: 纠正措施执行不到位导致制度有遗漏项");
		String tr133 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[103]/td[1]/label"))).getText();
		System.out.println(tr133);
		softly.assertThat(tr133).as("test data").contains("纠正行动:");
		String tr134 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[103]/td[1]/label/small"))).getText();
		System.out.println(tr134);
		softly.assertThat(tr134).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr135 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[103]/td[1]/textarea"))).getText();
		System.out.println(tr135);
		softly.assertThat(tr135).as("test data").contains("改善纠正措施制度的监督与执行");
		String tr136 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[104]/td[1]"))).getText();
		System.out.println(tr136);
		softly.assertThat(tr136).as("test data").isEqualTo("3.9.1: 培训材料在适用性、及时性或实用性方面有所欠缺");
		String tr137 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[106]/td[1]/label"))).getText();
		System.out.println(tr137);
		softly.assertThat(tr137).as("test data").contains("纠正行动:");
		String tr138 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[106]/td[1]/label/small"))).getText();
		System.out.println(tr138);
		softly.assertThat(tr138).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[106]/td[1]/textarea"))).getText();
		System.out.println(tr139);
		softly.assertThat(tr139).as("test data").contains("加强培训资源, 开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String tr140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[107]/td[1]"))).getText();
		System.out.println(tr140);
		softly.assertThat(tr140).as("test data").isEqualTo("3.9.2: 复训频率不高(>> 一年)");
		String tr141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[109]/td[1]/label"))).getText();
		System.out.println(tr141);
		softly.assertThat(tr141).as("test data").contains("纠正行动:");
		String tr142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[109]/td[1]/label/small"))).getText();
		System.out.println(tr142);
		softly.assertThat(tr142).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[109]/td[1]/textarea"))).getText();
		System.out.println(tr143);
		softly.assertThat(tr143).as("test data").contains("增加复训频率，改善复训形式");
		String tr144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[110]/td[1]"))).getText();
		System.out.println(tr144);
		softly.assertThat(tr144).as("test data").isEqualTo("3.9.3: 部门管理层未充分参与培训材料的编写和培训的实施");
		String tr145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[112]/td[1]/label"))).getText();
		System.out.println(tr145);
		softly.assertThat(tr145).as("test data").contains("纠正行动:");
		String tr146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[112]/td[1]/label/small"))).getText();
		System.out.println(tr146);
		softly.assertThat(tr146).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[112]/td[1]/textarea"))).getText();
		System.out.println(tr147);
		softly.assertThat(tr147).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String tr148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[113]/td[1]"))).getText();
		System.out.println(tr148);
		softly.assertThat(tr148).as("test data").isEqualTo("3.9.4: 未将经验教训充分包含到培训中");
		String tr149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[115]/td[1]/label"))).getText();
		System.out.println(tr149);
		softly.assertThat(tr149).as("test data").contains("纠正行动:");
		String tr150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[115]/td[1]/label/small"))).getText();
		System.out.println(tr150);
		softly.assertThat(tr150).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[115]/td[1]/textarea"))).getText();
		System.out.println(tr151);
		softly.assertThat(tr151).as("test data").contains("提高对培训效果的审查");
		String tr152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[116]/td[1]"))).getText();
		System.out.println(tr152);
		softly.assertThat(tr152).as("test data").isEqualTo("3.9.5: 所需培训开展不充分（脱岗）");
		String tr153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[118]/td[1]/label"))).getText();
		System.out.println(tr153);
		softly.assertThat(tr153).as("test data").contains("纠正行动:");
		String tr154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[118]/td[1]/label/small"))).getText();
		System.out.println(tr154);
		softly.assertThat(tr154).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[118]/td[1]/textarea"))).getText();
		System.out.println(tr155);
		softly.assertThat(tr155).as("test data").contains("完善承包商控制方针, 完善培训资源");
		String tr156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[119]/td[1]"))).getText();
		System.out.println(tr156);
		softly.assertThat(tr156).as("test data").isEqualTo("3.9.6: 所需培训开展不充分（在岗）");
		String tr157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[121]/td[1]/label"))).getText();
		System.out.println(tr157);
		softly.assertThat(tr157).as("test data").contains("纠正行动:");
		String tr158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[121]/td[1]/label/small"))).getText();
		System.out.println(tr158);
		softly.assertThat(tr158).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[121]/td[1]/textarea"))).getText();
		System.out.println(tr159);
		softly.assertThat(tr159).as("test data").contains("完善在岗培训方针, 完善培训资源");
		String tr160 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[122]/td[1]"))).getText();
		System.out.println(tr160);
		softly.assertThat(tr160).as("test data").isEqualTo("3.10.1: 关键岗位员工的作业授权不充分");
		String tr161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[124]/td[1]/label"))).getText();
		System.out.println(tr161);
		softly.assertThat(tr161).as("test data").contains("纠正行动:");
		String tr162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[124]/td[1]/label/small"))).getText();
		System.out.println(tr162);
		softly.assertThat(tr162).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[124]/td[1]/textarea"))).getText();
		System.out.println(tr163);
		softly.assertThat(tr163).as("test data").contains("完善作业授权");
		String tr164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[125]/td[1]"))).getText();
		System.out.println(tr164);
		softly.assertThat(tr164).as("test data").isEqualTo("3.10.2: 关键岗位主管和（或）经理授权不充分");
		String tr165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[127]/td[1]/label"))).getText();
		System.out.println(tr165);
		softly.assertThat(tr165).as("test data").contains("纠正行动:");
		String tr166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[127]/td[1]/label/small"))).getText();
		System.out.println(tr166);
		softly.assertThat(tr166).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[127]/td[1]/textarea"))).getText();
		System.out.println(tr167);
		softly.assertThat(tr167).as("test data").contains("完善主管和经理的岗位授权");
		String tr168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[128]/td[1]"))).getText();
		System.out.println(tr168);
		softly.assertThat(tr168).as("test data").isEqualTo("3.10.3: 供应商服务（QA/RC、来源检查）授权不充分");
		String tr169 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[130]/td[1]/label"))).getText();
		System.out.println(tr169);
		softly.assertThat(tr169).as("test data").contains("纠正行动:");
		String tr170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[130]/td[1]/label/small"))).getText();
		System.out.println(tr170);
		softly.assertThat(tr170).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[130]/td[1]/textarea"))).getText();
		System.out.println(tr171);
		softly.assertThat(tr171).as("test data").contains("完善供应商控制制度");
		String tr172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[131]/td[1]"))).getText();
		System.out.println(tr172);
		softly.assertThat(tr172).as("test data").isEqualTo("3.10.4: 现场供应商人员授权不充分");
		String tr173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[133]/td[1]/label"))).getText();
		System.out.println(tr173);
		softly.assertThat(tr173).as("test data").contains("纠正行动:");
		String tr174 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[133]/td[1]/label/small"))).getText();
		System.out.println(tr174);
		softly.assertThat(tr174).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr175 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[133]/td[1]/textarea"))).getText();
		System.out.println(tr175);
		softly.assertThat(tr175).as("test data").contains("完善供应商控制制度");
		String tr176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[134]/td[1]"))).getText();
		System.out.println(tr176);
		softly.assertThat(tr176).as("test data").isEqualTo("3.10.5: 培训教员授权不充分");
		String tr177 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[136]/td[1]/label"))).getText();
		System.out.println(tr177);
		softly.assertThat(tr177).as("test data").contains("纠正行动:");
		String tr178 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[136]/td[1]/label/small"))).getText();
		System.out.println(tr178);
		softly.assertThat(tr178).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr179 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[136]/td[1]/textarea"))).getText();
		System.out.println(tr179);
		softly.assertThat(tr179).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		String tr180 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[137]/td[1]"))).getText();
		System.out.println(tr180);
		softly.assertThat(tr180).as("test data").isEqualTo("3.11.1: 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String tr181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[139]/td[1]/label"))).getText();
		System.out.println(tr181);
		softly.assertThat(tr181).as("test data").contains("纠正行动:");
		String tr182 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[139]/td[1]/label/small"))).getText();
		System.out.println(tr182);
		softly.assertThat(tr182).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr183 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[139]/td[1]/textarea"))).getText();
		System.out.println(tr183);
		softly.assertThat(tr183).as("test data").contains("完善趋势分析体系, 完善趋势反馈");
		String tr184 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[140]/td[1]"))).getText();
		System.out.println(tr184);
		softly.assertThat(tr184).as("test data").isEqualTo("3.11.2: 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String tr185 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[142]/td[1]/label"))).getText();
		System.out.println(tr185);
		softly.assertThat(tr185).as("test data").contains("纠正行动:");
		String tr186 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[142]/td[1]/label/small"))).getText();
		System.out.println(tr186);
		softly.assertThat(tr186).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr187 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[142]/td[1]/textarea"))).getText();
		System.out.println(tr187);
		softly.assertThat(tr187).as("test data").contains("提高主管人员的问责意识, 改善关于管理技能的培训");
		String tr188 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[143]/td[1]"))).getText();
		System.out.println(tr188);
		softly.assertThat(tr188).as("test data").isEqualTo("3.11.3: 用于绩效控制的奖惩制度不到位");
		String tr189 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[145]/td[1]/label"))).getText();
		System.out.println(tr189);
		softly.assertThat(tr189).as("test data").contains("纠正行动:");
		String tr190 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[145]/td[1]/label/small"))).getText();
		System.out.println(tr190);
		softly.assertThat(tr190).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[145]/td[1]/textarea"))).getText();
		System.out.println(tr191);
		softly.assertThat(tr191).as("test data").contains("完善奖惩制度");
		String tr192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[146]/td[1]"))).getText();
		System.out.println(tr192);
		softly.assertThat(tr192).as("test data").isEqualTo("3.11.4: 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String tr193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[148]/td[1]/label"))).getText();
		System.out.println(tr193);
		softly.assertThat(tr193).as("test data").contains("纠正行动:");
		String tr194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[148]/td[1]/label/small"))).getText();
		System.out.println(tr194);
		softly.assertThat(tr194).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[148]/td[1]/textarea"))).getText();
		System.out.println(tr195);
		softly.assertThat(tr195).as("test data").contains("在问题报告政策中要求包含一切问题和及时性, RCA培训和授权, 改善对RCA结果的反馈");
		String tr196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[149]/td[1]"))).getText();
		System.out.println(tr196);
		softly.assertThat(tr196).as("test data").isEqualTo("3.11.5: 现场观察不充分，给员工的反馈不到位");
		String tr197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[151]/td[1]/label"))).getText();
		System.out.println(tr197);
		softly.assertThat(tr197).as("test data").contains("纠正行动:");
		String tr198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[151]/td[1]/label/small"))).getText();
		System.out.println(tr198);
		softly.assertThat(tr198).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[151]/td[1]/textarea"))).getText();
		System.out.println(tr199);
		softly.assertThat(tr199).as("test data").contains("针对现场观察结果，改善给员工的反馈, 改进现场观察员的制度和TQA");
		String tr200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[152]/td[1]"))).getText();
		System.out.println(tr200);
		softly.assertThat(tr200).as("test data").isEqualTo("3.15.1: 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String tr201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[154]/td[1]/label"))).getText();
		System.out.println(tr201);
		softly.assertThat(tr201).as("test data").contains("纠正行动:");
		String tr202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[154]/td[1]/label/small"))).getText();
		System.out.println(tr202);
		softly.assertThat(tr202).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr203 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[154]/td[1]/textarea"))).getText();
		System.out.println(tr203);
		softly.assertThat(tr203).as("test data").contains("同事互助提醒（好文化）培训");
		String tr204 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[155]/td[1]"))).getText();
		System.out.println(tr204);
		softly.assertThat(tr204).as("test data").isEqualTo("3.15.2: 未要求员工对纠正他人违规的情况承担责任");
		String tr205 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[157]/td[1]/label"))).getText();
		System.out.println(tr205);
		softly.assertThat(tr205).as("test data").contains("纠正行动:");
		String tr206 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[157]/td[1]/label/small"))).getText();
		System.out.println(tr206);
		softly.assertThat(tr206).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr207 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[157]/td[1]/textarea"))).getText();
		System.out.println(tr207);
		softly.assertThat(tr207).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String tr208 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[158]/td[1]"))).getText();
		System.out.println(tr208);
		softly.assertThat(tr208).as("test data").isEqualTo("3.15.3: 员工未充分理解相关行为规范");
		String tr209 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[160]/td[1]/label"))).getText();
		System.out.println(tr209);
		softly.assertThat(tr209).as("test data").contains("纠正行动:");
		String tr210 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[160]/td[1]/label/small"))).getText();
		System.out.println(tr210);
		softly.assertThat(tr210).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[160]/td[1]/textarea"))).getText();
		System.out.println(tr211);
		softly.assertThat(tr211).as("test data").contains("行为规范培训, 采用行为规范提醒物, 采用禁止事项警告清单");
		String tr212 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[161]/td[1]"))).getText();
		System.out.println(tr212);
		softly.assertThat(tr212).as("test data").contains("3.15.4: 主管未到现场强化");
		softly.assertThat(tr212).as("test data").contains("同事指导");
		String tr213 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[163]/td[1]/label"))).getText();
		System.out.println(tr213);
		softly.assertThat(tr213).as("test data").contains("纠正行动:");
		String tr214 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[163]/td[1]/label/small"))).getText();
		System.out.println(tr214);
		softly.assertThat(tr214).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr215 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[163]/td[1]/textarea"))).getText();
		System.out.println(tr215);
		softly.assertThat(tr215).as("test data").contains("监督管理能力培训, 就监督管理强化，对管理者实施问责");
		String tr216 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[164]/td[1]"))).getText();
		System.out.println(tr216);
		softly.assertThat(tr216).as("test data").contains("3.18.1: 盲目信任: 关键信息使用质疑的态度QV&V");
		softly.assertThat(tr216).as("test data").contains("不到位");
		String tr217 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[166]/td[1]/label"))).getText();
		System.out.println(tr217);
		softly.assertThat(tr217).as("test data").contains("纠正行动:");
		String tr218 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[166]/td[1]/label/small"))).getText();
		System.out.println(tr218);
		softly.assertThat(tr218).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr219 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[166]/td[1]/textarea"))).getText();
		System.out.println(tr219);
		softly.assertThat(tr219).as("test data").contains("提高质疑的态度QV&V");
		softly.assertThat(tr219).as("test data").contains("培训");
		String tr220 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[167]/td[1]"))).getText();
		System.out.println(tr220);
		softly.assertThat(tr220).as("test data").isEqualTo("3.18.2: 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String tr221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[169]/td[1]/label"))).getText();
		System.out.println(tr221);
		softly.assertThat(tr221).as("test data").contains("纠正行动:");
		String tr222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[169]/td[1]/label/small"))).getText();
		System.out.println(tr222);
		softly.assertThat(tr222).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[169]/td[1]/textarea"))).getText();
		System.out.println(tr223);
		softly.assertThat(tr223).as("test data").contains("Error-Free");
		softly.assertThat(tr223).as("test data").contains("行为培训，避免过度自信");
		String tr224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[170]/td[1]"))).getText();
		System.out.println(tr224);
		softly.assertThat(tr224).as("test data").isEqualTo("3.18.3: 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String tr225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[172]/td[1]/label"))).getText();
		System.out.println(tr225);
		softly.assertThat(tr225).as("test data").contains("纠正行动:");
		String tr226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[172]/td[1]/label/small"))).getText();
		System.out.println(tr226);
		softly.assertThat(tr226).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[172]/td[1]/textarea"))).getText();
		System.out.println(tr227);
		softly.assertThat(tr227).as("test data").contains("改善风险控制项目(FUSE");
		softly.assertThat(tr227).as("test data").contains("), 完善PM&T体系");
		String tr228 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[173]/td[1]"))).getText();
		System.out.println(tr228);
		softly.assertThat(tr228).as("test data").isEqualTo("3.18.4: 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String tr229 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[175]/td[1]/label"))).getText();
		System.out.println(tr229);
		softly.assertThat(tr229).as("test data").contains("纠正行动:");
		String tr230 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[175]/td[1]/label/small"))).getText();
		System.out.println(tr230);
		softly.assertThat(tr230).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[175]/td[1]/textarea"))).getText();
		System.out.println(tr231);
		softly.assertThat(tr231).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String tr232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[176]/td[1]"))).getText();
		System.out.println(tr232);
		softly.assertThat(tr232).as("test data").isEqualTo("3.18.5: 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String tr233 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[178]/td[1]/label"))).getText();
		System.out.println(tr233);
		softly.assertThat(tr233).as("test data").contains("纠正行动:");
		String tr234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[178]/td[1]/label/small"))).getText();
		System.out.println(tr234);
		softly.assertThat(tr234).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr235 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[178]/td[1]/textarea"))).getText();
		System.out.println(tr235);
		softly.assertThat(tr235).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		String tr236 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[179]/td[1]"))).getText();
		System.out.println(tr236);
		softly.assertThat(tr236).as("test data").isEqualTo("3.22.1: 对规则的现场试验不充分");
		String tr237 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[181]/td[1]/label"))).getText();
		System.out.println(tr237);
		softly.assertThat(tr237).as("test data").contains("纠正行动:");
		String tr238 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[181]/td[1]/label/small"))).getText();
		System.out.println(tr238);
		softly.assertThat(tr238).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr239 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[181]/td[1]/textarea"))).getText();
		System.out.println(tr239);
		softly.assertThat(tr239).as("test data").contains("发布规则/程序前，执行现场试验");
		String tr240 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[182]/td[1]"))).getText();
		System.out.println(tr240);
		softly.assertThat(tr240).as("test data").isEqualTo("3.22.2: 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String tr241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[184]/td[1]/label"))).getText();
		System.out.println(tr241);
		softly.assertThat(tr241).as("test data").contains("纠正行动:");
		String tr242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[184]/td[1]/label/small"))).getText();
		System.out.println(tr242);
		softly.assertThat(tr242).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[184]/td[1]/textarea"))).getText();
		System.out.println(tr243);
		softly.assertThat(tr243).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序, 制定遇到程序关键错误后要求停止操作的政策");
		String tr244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[185]/td[1]"))).getText();
		System.out.println(tr244);
		softly.assertThat(tr244).as("test data").isEqualTo("3.22.3: 盲目信任错误规则");
		String tr245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[187]/td[1]/label"))).getText();
		System.out.println(tr245);
		softly.assertThat(tr245).as("test data").contains("纠正行动:");
		String tr246 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[187]/td[1]/label/small"))).getText();
		System.out.println(tr246);
		softly.assertThat(tr246).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr247 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[187]/td[1]/textarea"))).getText();
		System.out.println(tr247);
		softly.assertThat(tr247).as("test data").contains("QV&V");
		softly.assertThat(tr247).as("test data").contains("培训");
		String tr248 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[188]/td[1]"))).getText();
		softly.assertThat(tr248).as("test data").isEqualTo("3.22.4: 规则审核不到位");
		String tr249 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[190]/td[1]/label"))).getText();
		softly.assertThat(tr249).as("test data").contains("纠正行动:");
		String tr250 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[190]/td[1]/label/small"))).getText();
		softly.assertThat(tr250).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[190]/td[1]/textarea"))).getText();
		softly.assertThat(tr251).as("test data").contains("提供有效审核的相关培训");
		String tr252 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[191]/td[1]"))).getText();
		softly.assertThat(tr252).as("test data").isEqualTo("3.22.5: 工前会、班前会、交底会的规则不充分");
		String tr253 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[193]/td[1]/label"))).getText();
		softly.assertThat(tr253).as("test data").contains("纠正行动:");
		String tr254 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[193]/td[1]/label/small"))).getText();
		softly.assertThat(tr254).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr255 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[193]/td[1]/textarea"))).getText();
		softly.assertThat(tr255).as("test data").contains("完善关于工前会、班前会、交底会的规则");
	}

}
