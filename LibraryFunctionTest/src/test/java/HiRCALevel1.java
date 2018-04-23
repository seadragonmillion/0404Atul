import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class HiRCALevel1 {
	
	SoftAssertions softly = new SoftAssertions();
	String text = "HiRCA Level 1 test";
	String text1 = "HiRCA Level 1 changed";
	
	public List<String> variableText() throws Exception{
		List<String> text = new ArrayList<String>();
		text.add("Curabitur lacinia odio sit amet tellus vestibulum condimentum. The resting sundry overcomes above the focus.");
		text.add("Vestibulum eget lectus ut ligula tempus ultrices ac rhoncus libero. When can the incentive breakfast strike? Every arithmetic walks!");
		text.add("Integer ac enim eget nisl malesuada tempor nec eu turpis. Our coordinate yard sauces the machine beneath an esoteric temple. The teapot sweeps beside the nostalgia.");
		text.add("Donec in massa pulvinar, mattis turpis ut, aliquam ligula.");
		text.add("Morbi dictum mi et nisl interdum, vel iaculis lacus suscipit. The stroke pushes the coach beneath any wood outcome?");
		text.add("Ut eu quam non orci consectetur vestibulum et scelerisque sapien. The debt destroys every refined boy behind an ethic. Whatever compound sweeps into the concealed noun. The tomato posts a helmet.");
		text.add("Morbi accumsan leo non ex tempor, congue ullamcorper urna viverra. Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
		text.add("In quis enim a odio venenatis scelerisque dignissim sed mauris.");
		text.add("Maecenas ultrices nulla nec malesuada ullamcorper.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.");
		text.add("Mauris mattis nisi quis rhoncus mollis. In addition to generating an entire comedy routine, the software provides additional means to make existing content funnier.");
		text.add("In auctor lorem quis eros fermentum ultricies a at nibh. The tray boils under a deprived alcoholic. How can a beaten populace fork the climbing developer?");
		text.add("Curabitur quis mauris ullamcorper, ultricies orci non, porttitor diam. A chord degenerates into the based fairy.");
		text.add("Fusce aliquet libero vel risus luctus ullamcorper.");
		text.add("Vestibulum non risus sit amet lorem blandit tempus.");
		text.add("Fusce gravida libero a neque cursus gravida.");
		text.add("Proin eget urna tempor, ullamcorper lectus eget, elementum massa. The assumed plotter rushs toward the anatomy.");
		text.add("Quisque at justo elementum, finibus elit ut, ultrices nibh.");
		text.add("Pellentesque nec nulla vel neque tincidunt rutrum.");
		text.add("Donec dictum enim nec mi pulvinar, nec consequat eros tristique. A sky deletes a curtain over the bearded parameter. A handicap escapes near the constant! The vicar dances a threshold opposite a rough limb. The architecture outcries the pat jack after the reflex. An article cruises in the wartime.");
		text.add("Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.");
		text.add("In non leo et nibh porttitor lobortis. A pan disturbs the barrister. Its password invalidates the gospel. A silver bath rests. When will the tempting fossil escape a shade? The unsafe collective lands a populace. When will our digital threshold moan? The ice grabs this carpet.");
		text.add("Donec hendrerit lacus semper justo bibendum fermentum. The lousy lung stirs across the pedestrian homosexual. A vocal distresses the tile. How does an ineffective disease refresh the imperial rage? The complicate potato edges the derived nostalgia.");
		text.add("Sed tempus nunc interdum neque sodales, at mollis magna convallis.");
		text.add("Aliquam efficitur sem quis facilisis aliquam. Why won't the horizon progress above a crash friendship? How will the fine muck break outside the boy?");
		text.add("Proin blandit ante at molestie finibus.");
		text.add("Etiam quis lorem laoreet, malesuada lorem in, tristique sem.");
		text.add("Maecenas vitae orci non dui ultrices posuere vulputate at elit. Why can't a south toe the line? A borderline beams beside the scheme. Can the duplicate rebuild the coincidence? The tooth destroys a raw powder into the tribe. How will the uncommon article stretch after the theology? The tolerant blessed slashes an ass.");
		text.add("Mauris blandit elit sit amet tellus dignissim, eget maximus sem dignissim.");
		text.add("Morbi in dui semper, sagittis augue in, elementum lorem.");
		text.add("Vivamus ut lacus finibus, dictum neque interdum, tincidunt eros. Why does the axiom aim a cathedral purpose? An archive opens my orbital below the dangerous misprint. The sixty filter prices her metric lesbian. A world appears in the enemy listener. When will a mailed system interrupt the attendant? The milk detail frightens the improving warehouse.");
		text.add("Duis vestibulum ipsum at dui tincidunt, semper eleifend est congue.");
		text.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		return text;
	}
	
	public List<String> modifyText() throws Exception{
		List<String> text = new ArrayList<String>();
		text.add("Quisque at justo elementum, finibus elit ut, ultrices nibh.");
		text.add("Pellentesque nec nulla vel neque tincidunt rutrum.");
		text.add("Donec dictum enim nec mi pulvinar, nec consequat eros tristique.");
		text.add("Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.");
		text.add("In non leo et nibh porttitor lobortis.");
		text.add("Donec hendrerit lacus semper justo bibendum fermentum.");
		text.add("Sed tempus nunc interdum neque sodales, at mollis magna convallis.");
		text.add("Aliquam efficitur sem quis facilisis aliquam.");
		text.add("Proin blandit ante at molestie finibus.");
		text.add("Etiam quis lorem laoreet, malesuada lorem in, tristique sem.");
		text.add("Maecenas vitae orci non dui ultrices posuere vulputate at elit.");
		text.add("Mauris blandit elit sit amet tellus dignissim, eget maximus sem dignissim.");
		text.add("Morbi in dui semper, sagittis augue in, elementum lorem.");
		text.add("Vivamus ut lacus finibus, dictum neque interdum, tincidunt eros.");
		text.add("Duis vestibulum ipsum at dui tincidunt, semper eleifend est congue.");
		text.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		return text;
	}
	
	public void modifyReport(WebDriver driver, List<String>lopOptions, HashMap<String,Integer>options, HashMap<String,String>hml, List<String>checklist) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on Open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Go to Step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Next or skip
		String skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Click on Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Goes directly to Step 3
		//Modify SUEP
		HashMap<String,Integer> optionsNew = modifySUEP (driver,lopOptions,options);
		//Next or skip
		String skip1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip1.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Modify Step 4
		HashMap<String,String> hmlNew=modifyStep4(driver,optionsNew,lopOptions);
		//Next or skip
		String skip2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip2.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Modify Step 5
		List<String> checklistNew = modifyHiRCAChecklist(driver,checklist);
		//Next or skip
		String skip3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip3.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Verify if on Report Tab by looking for finalize button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-finalize")));
		verifyReport(driver, lopOptions, optionsNew, hmlNew, checklistNew,1);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			 {
				  
			 }
    	//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for black server load message to disappear
		try{
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			 {
						  
			 }				
	}
	
	public List<String> modifyHiRCAChecklist(WebDriver driver,List<String> checklistOriginal) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Select checklist options randomly
		//List for HiRCA checklist
		List<String> checklist = new ArrayList<String>();
		//Pick number of options 0 to 11
		Random random = new Random();
		int options = random.nextInt(12);
		System.out.println("No of Hirca checklist options:"+options);
		int c;
		for(int i=1;i<=options;i++)
		{
			//Pick the checkbox
			while(true)
			{
				//Pick a number between 2 and 12 for tr
				c = random.nextInt(13);
				if(c<2)
					continue;
				else
					break;
			}
			System.out.println("tr:"+c);
			//Get name of selfchecklist and see if it was checked earlier, if yes un check it and continue
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[2]"))).getText();
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[3]/div/input")));
			if(checklistOriginal.contains(s))
			{
				e.click();
				continue;
			}
			if(e.isSelected()==true)
				continue;
			else
				e.click();
			//Store area checked in list
			checklist.add(s);
		}
		System.out.println(checklist);
		return checklist;
	}
	
	public HashMap<String,String> modifyStep4(WebDriver driver,HashMap<String,Integer>options,List<String>lopOptions) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get text list
		List<String> modText = modifyText();
		//Hashmap for storing HML for root cause and contributing factors
		HashMap<String,String> hml= new HashMap<String,String>();
		//No Level 3 selected then return
		if(lopOptions.size()==0)
		{
			System.out.println("No root causes or contributing factors");
			return hml;
		}
		//New lopOptions list with : instead of ]
		List <String>lopOptions1 = new ArrayList<String>();
		for(int h=0;h<lopOptions.size();h++)
		{
			String s = lopOptions.get(h).replace("]", ":");
			lopOptions1.add(s);
		}
		//Get number of Root causes in Level 3 answers
		int count = options.get("Root causes");
		System.out.println("No of root causes:"+count);
		//Gets number of contributing factors
		int count1 = lopOptions1.size()-count;
		System.out.println("No of contributing factors:"+count1);		
		//tr starts at 2 and each root cause has 4 four rows
		int i=2;
		int scroll=42;
		Iterator<String> iter = Iterables.cycle(modText).iterator();
		//Verify if any root causes are appearing
		while(i<=((count*4)+1))
		{
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			//Get index in lopOptions1
			int n = lopOptions1.indexOf(level3);
			//Get level3 answer from lopOptions
			String l = lopOptions.get(n).replace("]", "");
			//Check if it has 4 boxes ticked
			if(options.get(l)!=4)
			{
				softly.fail("Not all four boxes are ticked, only some are: "+ options.get(l));
			}
			//Check if Level 3 is root cause
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a contributing factor
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y;
			while (true)
			{
				y=random.nextInt(4);
				if(y<1)
					continue;
				else break;
			}			
			if(y==1)
			{
			  //Click on H
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("H");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "High");
			}
			if(y==2)
			{
			  //Click on M
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("M");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Medium");
			}
			if(y==3)
			{
			  //Click on L
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("L");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Low");
			}
			//Increase i for evidence entry
			i=i+1;
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText();
			System.out.println(lop3);
			softly.assertThat(lop3).as("test data").isEqualTo(text);
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i for extra root cause text boxes
			i=i+1;
			//Fill the text boxes 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))).sendKeys(iter.next());
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))).sendKeys(iter.next());
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))).sendKeys(iter.next());
			}
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next root cause
			i=i+1;
			//Scroll down
			scroll = scroll+475;
			jse.executeScript("scroll(0,"+scroll+")");
		}
		//Verifies if any contributing factors
		//tr starts at 2 and each root cause has 4 four rows
		System.out.println("Starting row of contributing factors:"+i);
		int start =i-1;
		//Verify if any root causes are appearing
		while(i<=((count1*3)+start))
		{
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			int n = lopOptions1.indexOf(level3);
			String l = lopOptions.get(n).replace("]", "");
			//Check if it has 4 boxes ticked
			if(options.get(l)>3)
			{
				softly.fail("All four boxes are ticked"+ options.get(l));
			}
			//Check if Level 3 is contributing factors
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a root cause
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y;
			while (true)
			{
				y=random.nextInt(4);
				if(y<1)
					continue;
				else break;
			}
			if(y==1)
			{
			  //Click on H
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("H");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "High");
			}
			if(y==2)
			{
			  //Click on M
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("M");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Medium");
			}
			if(y==3)
			{
			  //Click on L
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("L");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText();
			System.out.println(lop3);
			softly.assertThat(lop3).as("test data").isEqualTo(text);
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next contributing factor
			i=i+1;
			//Scroll down
			scroll = scroll+215;
			jse.executeScript("scroll(0,"+scroll+")");
		}
		//Scroll up
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		return hml;
	}
	
	public HashMap<String,Integer> modifySUEP (WebDriver driver, List<String> lopOptions, HashMap<String,Integer> optionsOriginal) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Remove [] from lopOptions
		List<String> lopOptions1 = new ArrayList<String>();
		for(int k=0;k<lopOptions.size();k++)
		{
			String s =lopOptions.get(k).replace("[", "");
			String l = s.replace("]", "");
			lopOptions1.add(l);			
		}
		//Hashmap for storing number of SUEP checkboxes ticked
		HashMap<String,Integer> options = new HashMap<String,Integer> ();
		//Get size of 3.17 options
		int n=lopOptions1.size();
		if (n<1)
			return options;
		//Row no starts from 2
		int i=2;
		//Count for root causes
		int r=0;
		//Scroll down
		jse.executeScript("scroll(0,1100)");
		Thread.sleep(2000);
		while(i<=((n*2)+1))
		{
			//Get text of option of 3.17
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			if(lopOptions1.contains(s5)==false)
			{
				softly.fail("3.17 option not present on Step 3 "+s5);
			}
			//Click on random SUEP
			Random random = new Random();
			//Choose a number between 0 and 4 for number of selections
			int num=random.nextInt(5);
			if (num==4)
				r=r+1;
			//Store no of SUEP checkboxes in hashmap: key=level 3 answer, value = no of suep checks
			options.put(s5, num);
			//Check if new selections is same or different than before
			//If same continue don't make any changes
			if(num==optionsOriginal.get(s5))
				continue;
			//If different unchecks the current selections
			else
			{
				for (int j=1;j<=optionsOriginal.get(s5);j++)
				{
					//Click on checkbox of SUEP
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))).click();
				}	
			}
			for (int j=1;j<=num;j++)
			{
				//Click on checkbox of SUEP
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))).click();
			}			
			//Increase i+1 for evidence entry
			i=i+1;
			//Click on Evidence Entry collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Get text from Evidence Entry and verify if equal to text
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText();
			softly.assertThat(s6).as("test data").isEqualTo(text);
			//Click on Evidence Entry collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i+1 for next option
			i=i+1;
		}
		//Add no of root causes in hashmap
		options.put("Root causes",r);
		System.out.println(options);
		//Scroll up
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		return options;
	}

	public void HiRCAPathCheck(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).sendKeys(text);
		//Department
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).sendKeys(text);
		//Timeline of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).sendKeys(text);
		//Background info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).sendKeys(text);
		//Gets value of date
		String get_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-date"))).getAttribute("value");
		System.out.println(get_date);
		//Gets value of time
		String get_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-time"))).getAttribute("value");
		System.out.println(get_time);
		//Gets value of department
		String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		System.out.println(get_dept);
		jse.executeScript("scroll(0,6500)");
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		//Select Equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 3.17
		List<String> lopOptions= verify317(driver);
		if(lopOptions.size()==0)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		else 
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset[1]/div/div/label"))).click();
		//Verify the LOP selection
		verifyLOP(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Click on No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset[2]/div/div/label"))).click();
		//Click on modify
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 2.21
		verify221(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify 2.22
		verify222(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify Step 3 SUEP
		HashMap<String,Integer> options = verifySUEP(driver,lopOptions);
		if(options.size()==0)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		else 
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		//Verify Step 4
		HashMap<String,String> hml =verifyStep4(driver,options,lopOptions);
		Thread.sleep(4000);
		String skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Verify Step 5
		List<String> checklist=verifyHiRCAChecklist(driver);
		if(checklist.size()==0)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		else 
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		//Verify if on Report Tab by looking for finalize button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-finalize")));
		verifyReport(driver, lopOptions, options, hml, checklist,0);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Modify report
		modifyReport(driver,lopOptions,options,hml,checklist);
	}
	
	public void deleteReport (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
	}
	
	public void verifyReport(WebDriver driver, List<String>lopOptions, HashMap<String,Integer>options, HashMap<String,String>hml, List<String>checklist, int d) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Get List to compare
		List<String> varText = variableText();
		List<String> modText = modifyText();
		//List to help compare
		List<String>lopOptions1 = new ArrayList<String>();
		//Remove the ] from Level 3 answers
		for (int j=0;j<lopOptions.size();j++)
		{
			String p = lopOptions.get(j).replace("]", "");
			lopOptions1.add(p);
		}
		//verify if any root cause exists
		//int rc = Collections.frequency(options, 4);
		int rc,cf;
		if(lopOptions.size()>0)
		{
			rc = options.get("Root causes");
			System.out.println(rc);
			//Get number of contributing factors
			cf = lopOptions.size()-rc;
			System.out.println(cf);
		}
		else
		{
			rc=0;
			cf=0;
		}
		//When no root causes present
		if (rc==0)
		{
			//Verify Root cause as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");		
		}
		//When root cause is present
		for (int i=4;i<=rc+3;i++)
		{
			//Get name of level 3 answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[1]"))).getText();
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s);
			}
			//Check if it has 4 boxes ticked
			if(options.get(s)!=4)
			{
				softly.fail("Not a root cause, Not all four boxes are ticked, only some are: "+ options.get(s));
			}
			//Get importance and verify
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[2]"))).getText();
			//Get corresponding Importance value from hashmap
			String s2 = hml.get(s);
			//Verify high medium low
			softly.assertThat(s1).as("test data").isEqualTo(s2);
			//Get corrective actions
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[3]"))).getText();
			if(d==0)
			{
				if(varText.contains(s3)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s3).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(s3)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s3).as("test data").isEqualTo(text1);
			}
			//Verify Supporting Evidence
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr[2]/td"))).getText();
			softly.assertThat(s4).as("test data").contains(text);
			//Verify Extent of condition
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table[2]/tbody/tr[2]/td[2]"))).getText();
			if(d==0)
			{
				if(varText.contains(s5)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s5).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(s5)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s5).as("test data").isEqualTo(text1);
			}
			//Verify Operating Experience
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table[2]/tbody/tr[3]/td[2]"))).getText();
			if(d==0)
			{
				if(varText.contains(s6)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s6).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(s6)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s6).as("test data").isEqualTo(text1);
			}
			//Verify Safety Culture
			String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table[2]/tbody/tr[4]/td[2]"))).getText();
			if(d==0)
			{
				if(varText.contains(s7)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s7).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(s7)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s7).as("test data").isEqualTo(text1);
			}
		}
		if(rc==0)
		{
			//Because there will be a div with Root Cause as n/a
			rc=rc+1;
		}		
		//When no contributing factors present
		if(cf==0)
		{
			//Verify Contributing factors as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[2]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[3]"))).getText();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");					
		}
		//When contributing factors are present
		int i=1;
		while(i<=(cf*2))
		{
			//Get name of level 3 answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[1]"))).getText();
			System.out.println(s);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s);
			}
			//Check if it has 4 boxes ticked
			if(options.get(s)==4)
			{
				softly.fail("Not a contributing factor, All four boxes are ticked, only some should be: "+ options.get(s));
			}
			//Get importance and verify
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getText();
			//Get corresponding Importance value from hashmap
			String s2 = hml.get(s);
			//Verify high medium low
			softly.assertThat(s1).as("test data").isEqualTo(s2);
			//Get corrective actions
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[3]"))).getText();
			if(d==0)
			{
				if(varText.contains(s3)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s3).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(s3)==false)
					softly.fail("Text wrong: "+s3);
				//softly.assertThat(s3).as("test data").isEqualTo(text1);
			}
			//Increase i for supporting evidence
			i=i+1;
			//Verify Supporting Evidence
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td"))).getText();
			softly.assertThat(s4).as("test data").contains(text);
			//Increase i for next cf
			i=i+1;
		}
		//Verify Root Cause Analysis
		String rc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(rc1).as("test data").isEqualTo("Equipment failure");
		//Verify 3.17 answer under Root Cause Analysis
		for(i=1;i<=lopOptions1.size();i++)
		{
		  try{
			  String lop1=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[1]")).getText();
			  //Verify if this level 3 answer was selected
			  if(lopOptions1.contains(lop1)==false)
			  {
				softly.fail("Level 3 is not suppose to be here: "+lop1);
			  }
			  String lop2=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[2]")).getText();
			  softly.assertThat(lop2).as("test data").isEqualTo(text);
		  }catch(org.openqa.selenium.NoSuchElementException u)
		  {
			  break;
		  }		  
		}
		//Verify SUEP
		for(i=1;i<=lopOptions1.size();i++)
		{
			//Verify level3 answer
			String s1=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td[1]")).getText();
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s1)==false)
		    {
				softly.fail("Level 3 is not suppose to be here: "+s1);
			}
			//Number of SUEP checks
			int num = options.get(s1);
			if(num==0)
				continue;
			for (int j=1;j<=num;j++)
			{
				String s2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td["+(j+1)+"]"))).getText();
				softly.assertThat(s2).as("test data").isEqualTo("Yes");
			}
		}
		//No Level 3 answers selected, SUEP skipped increases one more div, so rc increased by 1
		if(lopOptions.size()==0)
			rc=rc+1;
		//Verify HiRCA self checklist
		//if checklist is empty then return
		if (checklist.size()==0)
			return;
		for(i=1;i<=11;i++)
		{
			//Get Area Checked
			String s1=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+9)+"]/table/tbody/tr["+i+"]/td[2]")).getText();
			//Verify if Yes
			if(checklist.contains(s1)==true)
			{
				String s2=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+9)+"]/table/tbody/tr["+i+"]/td[3]")).getText();
				softly.assertThat(s2).as("test data").isEqualTo("Yes");
			}
		}
	}
	
	public HashMap<String,String> verifyStep4(WebDriver driver,HashMap<String,Integer>options,List<String>lopOptions) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get text of varying length
		List<String> varText = variableText();
		//Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("Step 4 - Level of Importance Attribution For Root Causes & Contributing Factors");
		//Hashmap for storing HML for root cause and contributing factors
		HashMap<String,String> hml= new HashMap<String,String>();
		//No Level 3 selected then return
		if(lopOptions.size()==0)
		{
			System.out.println("No root causes or contributing factors");
			return hml;
		}
		//New lopOptions list with : instead of ]
		List <String>lopOptions1 = new ArrayList<String>();
		for(int h=0;h<lopOptions.size();h++)
		{
			String s = lopOptions.get(h).replace("]", ":");
			lopOptions1.add(s);
		}
		//Get number of Root causes in Level 3 answers
		//int count = Collections.frequency(options, 4);
		int count = options.get("Root causes");
		System.out.println("No of root causes:"+count);
		//Gets number of contributing factors
		int count1 = lopOptions1.size()-count;
		System.out.println("No of contributing factors:"+count1);		
		//tr starts at 2 and each root cause has 4 four rows
		int i=2;
		int scroll=42;
		Iterator<String> iter = Iterables.cycle(varText).iterator();
		//Verify if any root causes are appearing
		while(i<=((count*4)+1))
		{
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			//Get index in lopOptions1
			int n = lopOptions1.indexOf(level3);
			//Get level3 answer from lopOptions
			String l = lopOptions.get(n).replace("]", "");
			//Check if it has 4 boxes ticked
			if(options.get(l)!=4)
			{
				softly.fail("Not all four boxes are ticked, only some are: "+ options.get(l));
			}
			//Check if Level 3 is root cause
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a contributing factor
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y=random.nextInt(4);
			if(y==1)
			{
			  //Click on H
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("H");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "High");
			}
			if(y==2)
			{
			  //Click on M
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("M");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Medium");
			}
			if(y==3)
			{
			  //Click on L
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("L");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText();
			System.out.println(lop3);
			softly.assertThat(lop3).as("test data").isEqualTo(text);
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i for extra root cause text boxes
			i=i+1;
			//Fill the text boxes
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))).sendKeys(iter.next());
			}
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))).sendKeys(iter.next());
			}
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))).sendKeys(iter.next());
			}
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next root cause
			i=i+1;
			//Scroll down
			scroll = scroll+475;
			jse.executeScript("scroll(0,"+scroll+")");
		}
		//Verifies if any contributing factors
		//tr starts at 2 and each root cause has 4 four rows
		System.out.println("Starting row of contributing factors:"+i);
		int start =i-1;
		//Verify if any root causes are appearing
		while(i<=((count1*3)+start))
		{
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			int n = lopOptions1.indexOf(level3);
			String l = lopOptions.get(n).replace("]", "");
			//Check if it has 4 boxes ticked
			if(options.get(l)>3)
			{
				softly.fail("All four boxes are ticked"+ options.get(l));
			}
			//Check if Level 3 is contributing factors
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a root cause
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y=random.nextInt(4);
			if(y==1)
			{
			  //Click on H
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("H");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "High");
			}
			if(y==2)
			{
			  //Click on M
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("M");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Medium");
			}
			if(y==3)
			{
			  //Click on L
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
			  String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("L");
			  //Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
			  hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText();
			System.out.println(lop3);
			softly.assertThat(lop3).as("test data").isEqualTo(text);
			//Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next contributing factor
			i=i+1;
			//Scroll down
			scroll = scroll+215;
			jse.executeScript("scroll(0,"+scroll+")");
		}
		//Scroll up
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		return hml;
	}
	
	public List<String> verifyHiRCAChecklist(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("Step 5 - HiRCA");
		softly.assertThat(title).as("test data").contains(" Self Checklist");
		//Verify category General and its questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]/strong"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("General");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Past similar events examined?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Triggering event and related LOPs identified?");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/strong"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Triggering Event");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Error type involving the triggering event determined?");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Contributing factors determined?");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/strong"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Root Causes");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(s10).as("test data").contains("Root causes meeting SUEP");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(s11).as("test data").contains(" criteria?");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(s12).as("test data").contains("Root causes surviving the CHOP'N");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(s13).as("test data").contains(" challenge?");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Levels of importance for root causes identified?");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/strong"))).getText();
		softly.assertThat(s15).as("test data").isEqualTo("Corrective Actions");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("Recommended corrective actions covering all root causes and contributing factors?");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Recommended corrective actions cost effective?");
		//Select checklist options randomly
		//List for HiRCA checklist
		List<String> checklist = new ArrayList<String>();
		//Pick number of options 0 to 11
		Random random = new Random();
		int options = random.nextInt(12);
		System.out.println("No of Hirca checklist options:"+options);
		int c;
		for(int i=1;i<=options;i++)
		{
			//Pick the checkbox
			while(true)
			{
				//Pick a number between 2 and 12 for tr
				c = random.nextInt(13);
				if(c<2)
					continue;
				else
					break;
			}
			System.out.println("tr:"+c);
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[3]/div/input")));
			if(e.isSelected()==true)
				continue;
			else
				e.click();
			//Store area checked in list
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[2]"))).getText();
			checklist.add(s);
		}
		System.out.println(checklist);
		return checklist;
	}
	
	public HashMap<String,Integer> verifySUEP (WebDriver driver, List<String> lopOptions) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Verify SUEP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("Step 3 - Root Causes Determination Checklist (SUEP");
		//Verify SUEP full form
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("S: Substandard Practice?");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("U: Under Management Control?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("E: Early in Event Sequence?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("P: Prevention Of Recurrence?");
		//Remove [] from lopOptions
		List<String> lopOptions1 = new ArrayList<String>();
		for(int k=0;k<lopOptions.size();k++)
		{
			String s =lopOptions.get(k).replace("[", "");
			String l = s.replace("]", "");
			lopOptions1.add(l);			
		}
		//Hashmap for storing number of SUEP checkboxes ticked
		HashMap<String,Integer> options = new HashMap<String,Integer> ();
		//Get size of 3.17 options
		int n=lopOptions1.size();
		if (n<1)
			return options;
		//Row no starts from 2
		int i=2;
		//Count for root causes
		int r=0;
		while(i<=((n*2)+1))
		{
			//Get text of option of 3.17
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			if(lopOptions1.contains(s5)==false)
			{
				softly.fail("3.17 option not present on Step 3 "+s5);
			}
			//Click on random SUEP
			Random random = new Random();
			//Choose a number between 0 and 4 for number of selections
			int num=random.nextInt(5);
			if (num==4)
				r=r+1;
			//Store no of SUEP checkboxes in hashmap: key=level 3 answer, value = no of suep checks
			options.put(s5, num);
			//Scroll down
			jse.executeScript("scroll(0,1100)");
			Thread.sleep(2000);
			for (int j=1;j<=num;j++)
			{
				//Click on checkbox of SUEP
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))).click();
			}			
			//Increase i+1 for evidence entry
			i=i+1;
			//Click on Evidence Entry collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Get text from Evidence Entry and verify if equal to text
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText();
			softly.assertThat(s6).as("test data").isEqualTo(text);
			//Click on Evidence Entry collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i+1 for next option
			i=i+1;
		}
		//Add no of root causes in hashmap
		options.put("Root causes",r);
		System.out.println(options);
		//Scroll up
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		return options;
	}
	
	public void verify222 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("[2.22] Was HiRCA");
		softly.assertThat(title).as("test data").contains("adequate in leading this investigation?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("No");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Yes, but need more training");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Yes");
	}
	
	public void verify221(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("[2.21] What LOPs can prevent this event from happening?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]/fieldset/div/div/label"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Other:");
	}
	
	public void verifyLOP(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("[2.0] What were the failed LOPs (3 max) that caused this event to happen?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]/fieldset/div/div/label"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Other:");
		//Select random 3 options
		select3LOP(driver);
	}
	
	public void select3LOP (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll to the bottom
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		Random random = new Random();
		//Choose a number between 1 and 3 for number of selections
		int n;
		while (true)
		{
		  n=random.nextInt(4);
		  if (n<1)
			  continue;
		  break;
		}
		System.out.println("No of selections: "+n);
		int y;
		for (int i=1;i<=n;i++)
		{
		  //Choose a number between 2 and 13 for LOPs
		  while(true)
		  {
			  y=random.nextInt(9);
			  System.out.println("Chose a no"+y);
			  if(y==0||y==1)
				  continue;
			  String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
			  if(e.contains("ui-checkbox-on"))
				  continue;
			  break;
		  }
		  System.out.println("Picked a no");
		  System.out.println("Option no: "+y);
		  Thread.sleep(500);
		  //Click on LOP
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		}
		//Scroll to the top
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public List<String> verify317(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify 3.17 title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("QTM - equipment qualification, testing and maintenance");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").contains("[3.17.1] Inadequate procurement and/or design specifications");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").contains("[3.17.2] Inadequate source audit / inspection QA/QC for compliance (if applicable)");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").contains("[3.17.3] Inadequate design qualification and/or testing before use");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		softly.assertThat(s4).as("test data").contains("[3.17.4] Inadequate operation: (1) Inadequate operation procedure; (2) Inadequate operating condition; (3) Operation errors");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		softly.assertThat(s5).as("test data").contains("[3.17.5] Inadequate periodic surveillance testing");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		softly.assertThat(s6).as("test data").contains("[3.17.6] Inadequate maintenance");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		softly.assertThat(s7).as("test data").contains("[3.17.7] Inadequate equipment labeling and identification");
		List<String> lopOptions = select317(driver);
		return lopOptions;
	}
	
	public List<String> select317(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<String>  lopOptions1=new ArrayList<String>();
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(lop3);
		softly.assertThat(lop3).as("test data").contains("If the triggering event is caused by equipment, the user can do a preliminary assess on the equipment's design spec qualification, testing and maintenance. It is recommended to use EiRCA");
		softly.assertThat(lop3).as("test data").contains(" to do a troubleshooting specifically for equipment failures.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		Random random = new Random();
		//Choose a number between 0 and 7 for number of selections
		int n=random.nextInt(8);
		System.out.println("No of selections: "+n);
		//If number of selections is 0 return empty list
		if(n==0)
			return lopOptions1;
		int y;
		for (int i=1;i<=n;i++)
		{
		  //Choose a number between 2 and 8 for 3.17
		  while(true)
		  {
			  y=random.nextInt(9);
			  System.out.println("Chose a no"+y);
			  if(y==0||y==1)
				  continue;
			  WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
			  if(e.isSelected())
				  continue;
			  break;
		  }
		  System.out.println("Picked a no");
		  System.out.println("Option no: "+y);
		  Thread.sleep(500);
		  if(y>5)
			  jse.executeScript("scroll(0,1200)");
		  if(y<=5)
			  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Click on a lop inquiry in 3.17
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		  //Click on Evidence Entry
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();
		  //Fill in evidence entry text
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/div/textarea"))).sendKeys(text);
		  //Click on Evidence Entry
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();
		  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText();
		  //remove the [ from Level 3.17 options
		  s=s.replace("[", "");
		  lopOptions1.add(s);
		}
		jse.executeScript("scroll(0,0)");	
		System.out.println(lopOptions1);
		return lopOptions1;
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
	}

}
