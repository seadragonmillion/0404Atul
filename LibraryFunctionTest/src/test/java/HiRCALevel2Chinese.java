import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HiRCALevel2Chinese {

	String text = "HiRCA Level 2 Chinese";
	SoftAssertions softly = new SoftAssertions();

	public void pathHiRCALevel2(WebDriver driver) throws Exception{

		HiRCALOPBug obj = new HiRCALOPBug();
		HiRCALevel2 obj3 = new HiRCALevel2();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//create a new report
		obj.fillUpHiRCAEventInfo(driver, text);
		//Select 3 lops with Act of Nature
		List<String> lopSelected = select3LOPs(driver);
		//Select answers for 1st lop
		List<String> a1 = answerLOPRelatedQuestions(driver);
		List<String> level21stLOP = obj3.level2List(a1);
		List<String> level31stLOP = obj3.level3List(a1).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 2nd lop
		List<String> a2 = answerLOPRelatedQuestions(driver);
		List<String> level22ndLOP = obj3.level2List(a2);
		List<String> level32ndLOP = obj3.level3List(a2).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 3rd lop
		List<String> a3 = answerLOPRelatedQuestions(driver);
		List<String> level23rdLOP = obj3.level2List(a3);
		List<String> level33rdLOP = obj3.level3List(a3).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 2.20
		chineseQ220(driver);
		//2.20 - make some selections and click next
		List<String> list220 = selectAllLevel3(driver,12).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.22 - skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Step 3 skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		/*Step 4 / Step 5 / Report/ pdf
		0=english
		1=chinese
		*/
		obj3.verifyRemainingSteps(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,1);
	}
	
	public List<String> answerLOPRelatedQuestions(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		HiRCAChinese obj2 = new HiRCAChinese();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//2.1
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q21(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.17
			chineseStep2verify317(driver, softly);
			level3.addAll(selectAllLevel3(driver,7));
			combined.addAll(level2);
			combined.addAll(level3);
			return combined;
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.2
		//Choose option to select
		n = obj.chooseRandomOption(3, 0);
		//Add answer to list
		chineseStep2q22(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.16
			obj2.chineseStepOneL316(driver, softly);
			level3.addAll(selectAllLevel3(driver,7));
			if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
			{
				combined.addAll(level2);
				combined.addAll(level3);
				return combined;
			}
			else
			{
				//Click next
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				//2.3 to 2.8
				List<String> c = followQuestions23To28(driver);
				level2.addAll(obj1.level2List(c));
				level3.addAll(obj1.level3List(c));
			}
		}
		if(n==1)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//2.3 to 2.8
			List<String> c = followQuestions23To28(driver);
			level2.addAll(obj1.level2List(c));
			level3.addAll(obj1.level3List(c));
		}
		if(n==2)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//2.9 to 2.12
			List<String> c = followQuestions29To212(driver);
			level2.addAll(obj1.level2List(c));
			level3.addAll(obj1.level3List(c));
		}
		combined.addAll(level2);
		combined.addAll(level3);
		return combined;
	}
	
	public List<String> followQuestions29To212(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		HiRCAChinese obj2 = new HiRCAChinese();
		HiRCAChinese4 obj3 = new HiRCAChinese4();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//2.9
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q29(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.12
			obj2.chineseStepOneL312(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.10
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q210(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.13
			obj2.chineseStepOneL313(driver, softly);
			level3.addAll(selectAllLevel3(driver,4));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.11
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q211(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.14
			obj2.chineseStepOneL314(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.12
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q212(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.15
			obj3.chineseStepOneL315(driver, softly);
			level3.addAll(selectAllLevel3(driver,4));			
		}
		combined.addAll(level2);
		combined.addAll(level3);
		return combined;
	}
	
	public List<String> followQuestions23To28(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		HiRCAChinese obj2 = new HiRCAChinese();
		HiRCAChinese4 obj3 = new HiRCAChinese4();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//2.3
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q23(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			obj2.chineseStepOneL36(driver, softly);
			level3.addAll(selectAllLevel3(driver,9));			
		}
		else
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			obj2.chineseStepOneL322(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));
		}
		if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
		{
			combined.addAll(level2);
			combined.addAll(level3);
			return combined;
		}
		else
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		//2.4
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q24(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.7
			obj2.chineseStepOneL37(driver, softly);
			level3.addAll(selectAllLevel3(driver,10));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.5
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q25(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.8
			obj2.chineseStepOneL38(driver, softly);
			level3.addAll(selectAllLevel3(driver,8));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.6
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q26(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.9
			obj3.chineseStepOneL39(driver, softly);
			level3.addAll(selectAllLevel3(driver,6));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.7
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q27(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.10
			obj3.chineseStepOneL310(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.8
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q28(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.11
			obj3.chineseStepOneL311(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));			
		}
		combined.addAll(level2);
		combined.addAll(level3);
		return combined;
	}
	
	public List<String> selectAllLevel3(WebDriver driver, int count) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		List<String> ac = new ArrayList<String>();
		outer:
			for(int j=1;j<=count;j++)
			{
				//Select any answer between 1 and count
				//Choose a number between 1 and count
				WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/input")));
				if(e.isSelected())
				{
					ac.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/label"))).getText());
					continue outer;
				}					
				//Click on answer
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/label")));
				//Scroll to element
				obj.scrollToElement(driver, l);
				l.click();
				//Get answer name and store in list
				String s1 = l.getText();
				ac.add(s1);	
			}
		//Scroll to top
		obj.scrollToTop(driver);
		return ac;		
	}
	
	public List<String> select3LOPs(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		List<String> a = new ArrayList<String>();
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Verify Step 2 question 1
		chinesestep2Q20(driver);
		//Select 3 LOPs randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		for(int i=0;i<3;i++)
		{
			while(true)
			{
				y=random.nextInt(9);
				//System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			//System.out.println("Picked a no");
			//System.out.println("Option no: "+y);
			Thread.sleep(500);
			//Scroll to element
			obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			//Click on LOP
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
			a.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText());
		}
		//Scroll to the top
		obj.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		return a;
	}
	
	public void chineseQ220(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();
		softly.assertThat(s).as("test data").contains("[2.20] 若此事件需额外的屏障，请选择所需屏障:");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("请选择执行后可防止这一失误再次发生的其它屏障。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Answers - LOPs
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("工前会、班前会、交底会等等");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("监护制");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("防护设计");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer4)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("独立检查");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer5)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("及时报警");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer6)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("及时提醒（标牌、禁止事项张贴）");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer7)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("实体保护（安全绳索、安全带等等）");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer8)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("同事提醒");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer9)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("审查");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer10)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("自检");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer11)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("组长监督");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer12)).getText();
		softly.assertThat(s12).as("test data").contains("其他:");
	}
	
	public void chineseStep2q212 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.12] 有意违反屏障要求是否由同事默许导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了缺乏来自同事的提醒（好文化的存在）是否是故意违章导致屏障失效的原因。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q211 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.11] 有意违反屏障要求是否由预期风险低导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了预期风险低是否导致屏障失效的原因。我们的研究发现当工作人员认为违规的风险较低时更容易违反规定。风险是两个方面的和。一个方面是被抓到的概率和受惩罚后果的乘积。另一方面是受伤的概率和受伤后果的乘积。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q210 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.10] 有意违反屏障要求是否由不当动机导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨故意违章使得屏障失效（如：简化屏障要求，比如不按照要求执行PJB等）是否是由于不当动机造成的，如：提前回家、逃避恶劣的工作环境等");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q29 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.9] 有意违反屏障要求是否由麻烦负担导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨故意违反是否是由于执行屏障时感觉麻烦负担造成的。麻烦负担是一种感觉，认为花费在执行屏障上的时间或努力都是不值得的。造成这种麻烦负担的原因有：问责机制存在不足、不理解屏障存在的必要性、过度规定繁琐屏障。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q28 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.8] 屏障失效是否由问责不足导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了屏障失效是否是因为几乎没有问责机制导致没有执行所需屏障。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q27 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.7] 屏障失效是否由资质授权不足导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("授权是培训完成后的一种能力证明（类似获得驾照前的驾驶执照考试）。这个问题评估重点屏障的使用如审查和独立验证是否有授权考核。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q26 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.6] 屏障失效是否由培训不足导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了屏障失效是否是由于缺少培训导致的。例如，如果员工没有接受过执行工前会的培训（课堂培训或在岗培训），导致缺工前会执行不到位或未执行。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q25 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.5 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.5] 屏障失效是否由规则模糊不明确导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨屏障失效是否是由于要求不明确导致的。例如，由于员工不理解什么工作需要工前会、什么不需要工前会，而不执行工前会。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q24 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.4 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.4] 屏障失效是否由偏差控制不妥导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("要正确执行屏障（如工前会），通常采用偏差控制措施。包括：行为标准、禁止事项警告、检查清单、工作现场提醒单、程序步骤标记等。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q23 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.3] 屏障失效是由规则不全面还是规则不正确导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("屏障失效的两个情况为设计不完整或设计时规则不正确。屏障不完整的例子如：无法涵盖所有工况。例如，\"审查\"屏障不完整时，未要求审查人员验证假设的有效性。屏障不正确的情况，包含一些不正确的指令。例如，不正确的");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("规则不全面");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("规则有误");
	}
	
	public void chineseStep2q22 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.2] 屏障失效是由规则存在不足、规则不正确还是粗心犯错导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了屏障失效（如，未执行独立检查）是故意还是非故意的？");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("粗心犯错");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("规则存在不足或规则不正确");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("皆非");
	}
	
	public void chineseStep2q21 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.1] 屏障失效是由设备失效导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("一些屏障与为实体设备使用相关，如安全带、坠落保护带、及时警报等。设备故障的促成因素包括下列四类：授权存在不足、检查性试验不到位、维护存在不足、操作存在不足。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2verify317 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAHumanError obj = new HiRCAHumanError();
		ShareCheck obj1 = new ShareCheck();
		HiRCALevel2Text obj2 = new HiRCALevel2Text();		
		HiRCAChinese4 obj3 = new HiRCAChinese4();		
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("设备的鉴定、试验和维修(QTM)");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.UnderDescriptionText)).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("若始发事件是由设备失效造成，可初步评估设备可能失效原因。完整的设备根本原因分析或故障排除请使用EiRCA模块。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.DescriptionPlusSign)).click();
		//3.17.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains("[3.17.1] 采购和（或）设计规范不充分");
		//2nd collapsible for 3.17.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer1)).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer1)).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("用于制定技术规范的行业标准？QA/QC?");
		String c2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c2a).as("test data").contains("供应商资格？");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer1)).click();
		//3rd collapsible 3.17.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer1)).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer1)).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("提高风险管理");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("针对高风险技术规范，利用专家委员会");
		String c26a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c26a).as("test data").contains("对重复技术规范实现标准化");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer1)).click();
		//3.17.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains("[3.17.2] 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		//2nd collapsible for 3.17.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer2)).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer2)).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("QA/QC 人员的培训和授权？全范围QA审计？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("连续审计/检查或抽查审计/检查？");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer2)).click();
		//3rd collapsible 3.17.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer2)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer2)).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("改善来源QA/QC 项目");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer2)).click();
		//3.17.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer3)).getText();
		softly.assertThat(q343).as("test data").contains("[3.17.3] 设计确认和（或）使用前试验不充分");
		//2nd collapsible for 3.17.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer3)).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer3)).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("外推过多而没有执行鉴定试验？");
		String c8a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c8a).as("test data").contains("复杂分析或计算的独立验证？");
		String c8b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c8b).as("test data").contains("非编码计算的不确定性分析？");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer3)).click();
		//3rd collapsible 3.17.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer3)).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer3)).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("改善设计确认和鉴定试验项目");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer3)).click();
		//3.17.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer4)).getText();
		softly.assertThat(q344).as("test data").contains("[3.17.4] 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		//2nd collapsible for 3.17.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer4)).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer4)).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("审查运行程序编写指导文件");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer4)).click();
		//3rd collapsible 3.17.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer4)).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer4)).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("纠正运行程序中的缺陷");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c37).as("test data").contains("完善运行程序编写指导文件");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer4)).click();
		//Scroll to the end
		obj1.scrollToAPoint(driver, 1500);
		//3.17.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer5)).getText();
		softly.assertThat(q345).as("test data").contains("[3.17.5] 定期监督试验不到位");
		//2nd collapsible for 3.17.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer5)).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer5)).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("没有执行监督试验？");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer5)).click();
		//3rd collapsible 3.17.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer5)).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer5)).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("完善监督试验大纲");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer5)).click();
		//3.17.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer6)).getText();
		softly.assertThat(q396).as("test data").contains("[3.17.6] 维修不到位");
		//2nd collapsible for 3.17.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer6)).getText();
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer6)).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c28).as("test data").contains("没有执行预防性维修？");
		String c28a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c28a).as("test data").contains("纠正性维修没有效果？");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer6)).click();
		//3rd collapsible 3.17.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer6)).getText();
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer6)).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("完善预防性维修大纲");
		String c31a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c31a).as("test data").contains("完善纠正性维修大纲");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer6)).click();
		//3.17.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer7)).getText();
		softly.assertThat(q367).as("test data").contains("[3.17.7] 设备的标识和识别不到位");
		//2nd collapsible for 3.17.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer7)).getText();
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer7)).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("检查所有提及的设备不仅有标识，且标识正确");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FurtherInvestigationCollapsibleAnswer7)).click();
		//3rd collapsible 3.17.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer7)).getText();
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer7)).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c45).as("test data").contains("改进设备标识和识别");
		//Click on 3rd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PossibleCorrectiveActionAnswer7)).click();
		//Verify Add Contributing factor
		obj3.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj1.scrollToTop(driver);
		Thread.sleep(2000);
	}
	
	public void chinesestep2Q20(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCAHumanError obj = new HiRCAHumanError();
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析");
		//Question before 2.0
		String q11a = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.PageQuestionBefore20)).getText();		
		softly.assertThat(q11a).as("test data").contains("屏障是否存在能预防始发事件的发生？");
		//Description
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).click();
		String descTab = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).getText();
		softly.assertThat(descTab).as("test data").contains("描述");
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionTextBefore20)).getText();
		softly.assertThat(lop3).as("test data").contains("屏障：为预防、侦测和阻止事件发生的机制。可以程序、实体保护或是行动来落实。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).click();
		//Verify Yes 
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnswerYes)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Verify No
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnswerNo)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
		//2.0 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.0] 请选择哪些失效屏障造成事件的发生(至多3个)？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer1)).getText();		
		softly.assertThat(ans3).as("test data").contains("工前会、班前会、交底会等等");
		//Answer 2
		String ans4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer2)).getText();		
		softly.assertThat(ans4).as("test data").contains("监护制");
		//Answer 3
		String ans5 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer3)).getText();
		softly.assertThat(ans5).as("test data").contains("防护设计");
		//Answer 1
		String ans6 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer4)).getText();		
		softly.assertThat(ans6).as("test data").contains("独立检查");
		//Answer 2
		String ans7 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer5)).getText();		
		softly.assertThat(ans7).as("test data").contains("及时报警");
		//Answer 3
		String ans8 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer6)).getText();
		softly.assertThat(ans8).as("test data").contains("及时提醒（标牌、禁止事项张贴）");
		//Answer 1
		String ans9 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer7)).getText();		
		softly.assertThat(ans9).as("test data").contains("实体保护（安全绳索、安全带等等）");
		//Answer 2
		String ans10 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer8)).getText();		
		softly.assertThat(ans10).as("test data").contains("同事提醒");
		//Answer 3
		String ans11 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer9)).getText();
		softly.assertThat(ans11).as("test data").contains("审查");
		//Answer 1
		String ans12 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer10)).getText();		
		softly.assertThat(ans12).as("test data").contains("自检");
		//Answer 2
		String ans13 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer11)).getText();		
		softly.assertThat(ans13).as("test data").contains("组长监督");
		//Answer 3
		String ans14 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Answer12)).getText();
		softly.assertThat(ans14).as("test data").contains("其他:");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
