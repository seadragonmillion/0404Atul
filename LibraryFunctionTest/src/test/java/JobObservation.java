import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JobObservation {

	SoftAssertions softly = new SoftAssertions();

	public String text(WebDriver driver) throws Exception {

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("I think I will <table> buy the red car, or I will lease the blue one.");
		else return ("I think I will buy the red car, or I will lease the blue one.");
	}

	public String text1(WebDriver driver) throws Exception {

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("As it currently <html> stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.");
		else return ("As it currently stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.");
	}

	public void verifyObservationTypesSelection (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Select different answers in Step 3 and  verify the path it leads to, change and verify each time
		//Skill based
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-SB"))).click();
		//Verify DDOTA
		verifyDDOTA(driver);
		//Click on Step 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-3-a"))).click();
		Thread.sleep(500);
		//Rule based
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-RB"))).click();
		//Verify DDOTA
		verifyDDOTA(driver);
		//Verify BURP
		verifyBURP(driver);
		//Verify ABC
		verifyABC(driver);
		//Verify TQA		
		verifyTQA(driver);
		//Click on Step 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-3-a"))).click();
		Thread.sleep(500);
		//Knowledge based
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-KB"))).click();
		//Verify DDOTA
		verifyDDOTA(driver);
		//Verify BOOST
		verifyBOOST(driver);
		//Click on Step 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-3-a"))).click();
		Thread.sleep(500);
		//Equipment
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-EQ"))).click();
		//Verify CAD
		verifyCAD(driver);
		//Click on Step 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-3-a"))).click();
		Thread.sleep(500);
		//Injury
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-IN"))).click();
		//Verify LOSE
		verifyLOSE(driver);
		//Click on Step 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-3-a"))).click();
		Thread.sleep(500);
	}

	public void verifyLOSE (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-L")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-O")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-S")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-E")));
		verifyLOSEStep5(driver);
	}

	public void verifyLOSEStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Line of fire
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-L"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Fall-and-bounce (cutting down poles and trees)");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Rolling down a sloping terrain (poles, trucks, tools)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Tool-use (knife and hammer)");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Hit-and-fly (sledge hammering)");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s13).as("test data").isEqualTo("Anchor-failure (load bearing anchors)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-5']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Falling object (loose object from the top)");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-6']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Distraction while-walking");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-7']"))).getText();
		softly.assertThat(s18).as("test data").isEqualTo("Roll-over (welding tractor, etc.)");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Overexertion
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-O"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Lift beyond limit");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Body position twisted");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Slip/Trip/Fall
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-S"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Slips/falls from same elevation-unqualified walkways");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Slips/falls from same elevation-sloping terrains");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Fall from elevation-ladder");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Fall from elevation-scaffolding");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s15).as("test data").isEqualTo("Fall from elevation-openings in working areas");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Equipment related
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-E"))).click();
		Thread.sleep(500);
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("Inadequate PPE or PIPE");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Roll-over");
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s19).as("test data").isEqualTo("Roll-down");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s20).as("test data").isEqualTo("Pinch");
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s21).as("test data").isEqualTo("Drawing-in");
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-5']"))).getText();
		softly.assertThat(s22).as("test data").isEqualTo("Malfunction");
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-6']"))).getText();
		softly.assertThat(s23).as("test data").isEqualTo("Welding");
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-7']"))).getText();
		softly.assertThat(s24).as("test data").isEqualTo("Back-feeding");
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-8']"))).getText();
		softly.assertThat(s25).as("test data").isEqualTo("Insulation damage");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public void verifyCAD (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-C")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-A")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-D")));
		verifyCADStep5(driver);
	}

	public void verifyCADStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Training
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-C"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Color");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Vibration level");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Geometry");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Qualification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-A"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Scratch marks");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Surface imperfections");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Small cracks");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Accountability
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-D"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Fractures");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Leak");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Damage");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public void verifyBOOST (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-3")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-4")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-5")));
		verifyBOOSTStep5(driver);
	}

	public void verifyBOOSTStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Blind trust
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-1"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Information incomplete and without supporting analysis");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Information inconsistent with experience and logic");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("No independent check on information");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Over confidence
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-2"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Did not recognize differences between the task in hand and the tasks that were successfully performed");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Inadequate capability");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Inadequate wisdom");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//OOS/OOM
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-3"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Failed to recognize possible failures");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Did not consider contingency plans for \"What-ifs\"");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Did not mitigate factors for possible failures");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Sunk cost trap
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-4"))).click();
		Thread.sleep(500);
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Did not consider future utilization value");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Did not consider replacement costs to change over");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Two option trap
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-5"))).click();
		Thread.sleep(500);
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Did not consider more options before making a decision");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Did not consider collecting more information before making a decision");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public void verifyTQA (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-T")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-Q")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-A")));
		verifyTQAStep5(driver);
	}

	public void verifyTQAStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Training
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-T"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Inadequate training materials in scope, timeliness, or usefulness");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Inadequate frequency of refresher training (>> one year)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Inadequate line management participation in training materials, development, and delivery");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Inadequate inclusion of lessons learned into training");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s13).as("test data").isEqualTo("Inadequate provision of needed training (off-the-job)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-5']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Inadequate provision of needed training (on-the-job)");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Qualification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-Q"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Inadequate task specific qualification of staff on critical jobs");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Inadequate qualification of supervisors and/or managers of critical jobs");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Inadequate qualification of vendors' services (QA/QC, source inspection)");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s15).as("test data").isEqualTo("Inadequate qualification of vendors' employees working on site");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s20).as("test data").isEqualTo("Inadequate qualification of training instructors");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Accountability
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-A"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Inadequate Performance Monitoring and Trending (PM&T) and feedback to staff");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Inadequate supervisory skills in Instant Feedback and Constant Reinforcement (IF&CR)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Inadequate penalty/reward system for performance control");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("Inadequate problem reporting, RCA and corrective actions and feedback to staff");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Inadequate field observation and feedback to staff");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public void verifyABC (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-A")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-B")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-C")));
		verifyABCStep5(driver);
	}

	public void verifyABCStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//All inclusive
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-A"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Omission of programmatic requirements");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Omission of operating conditions in program(s)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Omission of assumptions to be called out in program(s)");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Omission of scope in program(s)");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s13).as("test data").isEqualTo("Omission of testing or measurements in program validation");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-5']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("(1) Description of purpose; (2) Description of prerequisite; (3) Description of terminology; (4) Description of lessons learned in not-to-do lists; (5) References; (6) Request feedback from users");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-6']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Omission of elements in programs due to inadequate review");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-7']"))).getText();
		softly.assertThat(s18).as("test data").isEqualTo("Omission of elements in programs due to inadequate previous root cause analysis");
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-8']"))).getText();
		softly.assertThat(s19).as("test data").isEqualTo("Omission of elements in programs due to corrective action not carried out");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Bypass control
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-B"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Inadequate guidance for out-of-program or out-of-procedure situations");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Inadequate self-check or independent check of single-point-vulnerability (SPV) steps");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Point-of-no-return (PNR) steps not identified (to provide with review) to ensure past errors are corrected before proceeding");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s15).as("test data").isEqualTo("Place holding \"checks\" not used to prevent skipping steps or pages");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s20).as("test data").isEqualTo("Likely noncompliance situations not analyzed and mitigated (through symptom verification, over-check, not-to-do warnings, etc.)");
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-5']"))).getText();
		softly.assertThat(s21).as("test data").isEqualTo("Lack of job-site reminders to prevent inattention-to-detail errors for routine work");
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-6']"))).getText();
		softly.assertThat(s22).as("test data").isEqualTo("Lack of checklists to prevent forgetting-related errors");
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-7']"))).getText();
		softly.assertThat(s23).as("test data").isEqualTo("Inadequate positive peer pressure amongst employees to encourage and reinforce compliant behavior standards");
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-8']"))).getText();
		softly.assertThat(s24).as("test data").isEqualTo("Inadequate review");
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-9']"))).getText();
		softly.assertThat(s25).as("test data").isEqualTo("(1) Inadequate predictive maintenance; (2) Inadequate preventive maintenance; (3) Inadequate corrective maintenance; (4) Inadequate post-maintenance testing; (5) Inadequate troubleshooting and RCA; and (6) Maintenance errors");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Clarity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-C"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Use of vague or interpretable words (such as appropriate, as required, necessary, etc.) due to inexperienced rule preparers");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Use of non-quantifiable or interpretable conditions (such as reviewing sufficient samples, etc.) to avoid internal QA findings");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Requirement of judgment to execute procedure steps");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("Interfaces with other procedures not clearly defined");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Inadequate readability (i.e., greater than 8th grade reading level)");
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-5']"))).getText();
		softly.assertThat(s26).as("test data").isEqualTo("Unclear and inconsistent equipment labeling and identification between equipment and procedure");
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-6']"))).getText();
		softly.assertThat(s27).as("test data").isEqualTo("Time sensitive steps not called out");
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-7']"))).getText();
		softly.assertThat(s28).as("test data").isEqualTo("Measurement units are not clarified or quantified");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public void verifyBURP (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-B")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-U")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-R")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-P")));
		verifyBURPStep5(driver);
	}

	public void verifyBURPStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Burden
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-B"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Perceived burden to obtain tools and equipment");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Perceived burden to obtain documents or procedures");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Perceived burden to obtain and wear PPE");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Perceived burden to work with an over-complex or burdensome procedure");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s13).as("test data").isEqualTo("Did not go into field and verify in field due to task being too burdensome");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Undue motivation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-U"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").contains("Completion of work sooner so that the staff can go home earlier");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Completion of work sooner so that staff could be rewarded with bonus or to avoid penalty");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Completion of work sooner so that staff could start other jobs (especially for contractors who are paid based on number of tasks completed)");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s15).as("test data").contains("Completion of work sooner so that the staff could rest in a more comfortable environment (especially working at high temperature, radiation, or humid environment)");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Risk perceived
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-R"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Supervisors do not provide feedback about job performance");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Violation of established rules is not easily known (especially when working alone)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("The consequences of violations are perceived to be insignificant due to lack of a clear accountability system");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("Risk of injury due to violation is considered to be none or minimal");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-4']"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Feeling of low perceived risk due to peer observation (others are doing it the same way)");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Peer pressure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-P"))).click();
		Thread.sleep(500);
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Staff is not trained to coach or correct violations of other staff");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Staff is not held accountable to correct violations of other staff");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s18).as("test data").isEqualTo("Staff does not fully understand the behavior standards");
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-3']"))).getText();
		softly.assertThat(s19).as("test data").isEqualTo("Supervisors do not reinforce peer coaching in the field");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public void verifyDDOTA (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-2")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-3")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-4")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-5")));
		verifyDDOTAStep5(driver);
	}

	public void verifyDDOTAStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Distraction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-1"))).click();
		Thread.sleep(500);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Preoccupation (Blinding frustration)");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Interruptions");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Multitasking");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Drowsiness
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-2"))).click();
		Thread.sleep(500);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Daily Cycle");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Mental fatigue");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Over confidence
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-3"))).click();
		Thread.sleep(500);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Not knowing weakness");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Not seeking compensation for weakness");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-2']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Not addressing change, abnormality & decay");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Time pressure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-4"))).click();
		Thread.sleep(500);
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Reducing attention span");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Short-cutting");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
		//Attention bank and span insufficiency
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-5"))).click();
		Thread.sleep(500);
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-0']"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Working long hours (>10 hours)");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-1']"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Inadequate frequency of work breaks");
		//Click on Step 4 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-4-a"))).click();
		Thread.sleep(500);
	}

	public List<String> selectStep3Step4Step5Random(WebDriver driver) throws Exception {

		List<String> k = new ArrayList<String>();
		String s = selectStep3(driver);
		k.add(s);
		if(s.equals("Skill-based"))
			k.addAll(selectDDOTA(driver));
		if(s.equals("Rule-based"))
			k.addAll(selectOptionStep4Rule(driver));
		if(s.equals("Knowledge-based"))
			k.addAll(selectOptionStep4Knowledge(driver));
		if(s.equals("Equipment"))
			k.addAll(selectCAD(driver));
		if(s.equals("Injury"))
			k.addAll(selectLOSE(driver));
		List<String> step5 = selectStep5(driver);
		k.addAll(step5);
		return k;
	}

	public List<String> selectStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,3);
		List<String> step5 = new ArrayList<String>();
		Random random = new Random();
		int count=0;
		while(true)
		{
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-5-answer-"+count)));
				count=count+1;
			}catch(org.openqa.selenium.TimeoutException r)
			{
				break;
			}
		}
		int n = random.nextInt(count);
		for(int i=0;i<=n;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-"+i+"']"))).click();
			step5.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-joa-tab-5-answer-"+i+"']"))).getText());
		}
		return step5;
	}

	public List<String> selectOptionStep4Knowledge(WebDriver driver) throws Exception {

		Random random = new Random();
		int n = random.nextInt(2);
		if(n==0)
			return selectDDOTA(driver);
		else
			return selectBOOST(driver);
	}	

	public List<String> selectOptionStep4Rule(WebDriver driver) throws Exception {

		Random random = new Random();
		int n = random.nextInt(4);
		if(n==0)
			return selectDDOTA(driver);
		if(n==1)
			return selectBURP(driver);
		if(n==2)
			return selectABC(driver);
		else
			return selectTQA(driver);
	}

	public List<String> selectCAD (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		List<String> s = new ArrayList<String>();
		int n = random.nextInt(3);
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-C"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-C"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-A"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-A"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-D"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-CAD-D"))).click();
		}
		s.add("No6");
		return s;
	}

	public List<String> selectLOSE (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		List<String> s = new ArrayList<String>();
		int n = random.nextInt(4);
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-L"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-L"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-O"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-O"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-S"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-S"))).click();
		}
		if(n==3)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-E"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-LOSE-E"))).click();
		}
		s.add("No6");
		return s;
	}

	public List<String> selectBOOST (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> s = new ArrayList<String>();
		Random random = new Random();
		int n = random.nextInt(5);
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-1"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-1"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-2"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-2"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-3"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-3"))).click();
		}
		if(n==3)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-4"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-4"))).click();
		}
		if(n==4)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-5"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BOOST-5"))).click();
		}
		s.add("No6");
		return s;
	}

	public List<String> selectDDOTA(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		int n = random.nextInt(5);
		List<String> s = new ArrayList<String>();
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-1"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-1"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-2"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-2"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-3"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-3"))).click();
		}
		if(n==3)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-4"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-4"))).click();
		}
		if(n==4)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-5"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-5"))).click();
		}
		return s;
	}

	public List<String> selectBURP (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		List<String> s = new ArrayList<String>();
		int n = random.nextInt(4);
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-B"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-B"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-U"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-U"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-R"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-R"))).click();
		}
		if(n==3)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-P"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-BURP-P"))).click();
		}
		return s;
	}

	public List<String> selectABC (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> s = new ArrayList<String>();
		Random random = new Random();
		int n = random.nextInt(3);
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-A"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-A"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-B"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-B"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-C"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-ABC-C"))).click();
		}
		s.add("No6");
		return s;
	}

	public List<String> selectTQA (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> s = new ArrayList<String>();
		Random random = new Random();
		int n = random.nextInt(3);
		if(n==0)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-T"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-T"))).click();
		}
		if(n==1)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-Q"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-Q"))).click();
		}
		if(n==2)
		{
			s.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-A"))).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-TQA-A"))).click();
		}
		s.add("No6");
		return s;
	}

	public String selectStep3(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		int n = random.nextInt(5);
		String s = "";
		if(n==0)
		{
			s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-SB"))).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-SB"))).click();
		}
		if(n==1)
		{
			s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-RB"))).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-RB"))).click();
		}
		if(n==2)
		{
			s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-KB"))).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-KB"))).click();
		}
		if(n==3)
		{
			s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-EQ"))).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-EQ"))).click();
		}
		if(n==4)
		{
			s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-IN"))).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-IN"))).click();
		}
		return s;
	}

	public void path(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-next"))).click();
		//Verify Step 3/Step 4/Step 5
		verifyObservationTypesSelection(driver);
		//Select Step 3/4/5
		List<String> k = selectStep3Step4Step5Random(driver);
		//Enters text 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-notes-step5"))).sendKeys(text(driver));
		//Clicks on Next
		driver.findElement(By.id("pii-joa-tab-5-button")).click();
		if(k.contains("No6")==false)
		{
			//Clicks on both answers in step 6
			Actions act = new Actions(driver);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-answer-0")));
			act.moveToElement(element).click().build().perform();
			Thread.sleep(1000);
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-answer-1")));
			act.moveToElement(element).click().build().perform();
		}
		//Enters text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-notes-step6"))).sendKeys(text1(driver));
		//Clicks on build report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-report"))).click();
		//Clicks on build report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		//Verifies the text entered before
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[1]"))).getText();
		String r = s.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(text(driver));
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[2]"))).getText();
		String r1 = s1.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(text1(driver));
		//Verify random selections in report
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[2]/span"))).getText();
		softly.assertThat(s2).as("test data").contains(k.get(0)+"/"+k.get(1));
		if(k.contains("No6"))
		{			
			k.remove("No6");
		}
		for(int i=2;i<k.size()-1;i++)
		{
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[3]/span/ul/li["+(i-1)+"]"))).getText();
			softly.assertThat(s3).as("test data").contains(k.get(i));
		}
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-save"))).click();
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
	}

	public void dateTimeModifyChrome (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Edit Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("2018");
		Thread.sleep(500);
		//Edit Time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("AM");
		//Click outside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-div"))).click();
	}

	public void dateTimeModifyFirefox (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//CLick on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
		//Press tab to get to date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).sendKeys(Keys.TAB);
		//Edit Date
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("2018");
		Thread.sleep(500);
		//Press tab to get to time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.TAB);
		//Edit Time
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("AM");
		//Click outside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-div"))).click();
	}


	public void dateTimeModifyIE (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Edit Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).clear();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("2018-01-01");
		Thread.sleep(500);
		//Edit Time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).clear();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("01:01:01");
		Thread.sleep(500);
		//Click outside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-div"))).click();
	}

	public void imageUploadChrome(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Uploads a picture on next page in step 2
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo same photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload different photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");		
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();

	}

	public void imageUploadFirefox(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Uploads a picture on next page in step 2
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p.waitFor();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		Process q =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		q.waitFor();
		Thread.sleep(3000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload different photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		Process w =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		w.waitFor();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}


	public void imageUploadIE(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Uploads a picture on next page in step 2
		Thread.sleep(1000);
		jse.executeScript("return document.getElementById('pii-joa-tab-2-photo-input').click();");
		Thread.sleep(3000);
		//Uploads picture
		try{
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		Thread.sleep(1000);/*
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		act.doubleClick(element).build().perform();*/
		jse.executeScript("return document.getElementById('pii-joa-tab-2-photo-input').click();");
		Thread.sleep(3000);
		//Uploads picture
		try{
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}

	public void imageUploadIE11(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Uploads a picture on next page in step 2
		Thread.sleep(1000);/*
		WebElement element =  driver.findElement(By.id("pii-joa-tab-2-photo-input"));
		Actions act = new Actions(driver);
		act.click(element).build().perform();*/
		jse.executeScript("return document.getElementById('pii-joa-tab-2-photo-input').click();");
		Thread.sleep(2000);
		//Uploads picture
		try{
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		Thread.sleep(1000);
		//act.click(element).build().perform();
		jse.executeScript("return document.getElementById('pii-joa-tab-2-photo-input').click();");
		Thread.sleep(2000);
		//Uploads picture
		try{
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpeceted alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		Thread.sleep(1000);
		//act.click(element).build().perform();
		jse.executeScript("return document.getElementById('pii-joa-tab-2-photo-input').click();");
		Thread.sleep(2000);
		//Uploads a different picture
		try{
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpeceted alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}


	public void deleteNewRecord(WebDriver driver, String recordName, int y) throws Exception{

		//Clicks on delete button
		driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		//Clicks on delete report
		driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		Thread.sleep(2000);
		driver.findElement(By.id("pii-user-home-panel-btn-joa")).click();
		Thread.sleep(2000);
		//Verify record deleted
		//Click on 1st record
		String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");
		while(true)
		{
			Thread.sleep(1000);
			try{
				if (driver.findElement(By.className("sticky-note")).isDisplayed())
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{

				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}


		}
		//Verify report not retrieved by shared to person
		ErrorMeter obj = new ErrorMeter();
		String sharer = obj.decideSharer (y);
		ShareCheck obj1 = new ShareCheck();
		obj1.checkNoReportAfterDelete(driver, sharer, softly);	  			  
	}

	public void verifyTextReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Verifies the text entered before
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[1]"))).getText();
		String r = s.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(text(driver));
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[2]"))).getText();
		String r1 = s1.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(text1(driver));
	}

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		ErrorMeter obj = new ErrorMeter();
		String sharer = obj.decideSharer (y);
		EiRCA eirca = new EiRCA();
		String sharerAdded = obj.decideSharerAdded (y);	    	
		//CLicks on first newly created record
		driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Calls verifyTextReport to check text entered
		verifyTextReport(driver);
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		ShareCheck obj1 = new ShareCheck();
		obj1.shareTwice (driver,softly);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		obj1.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a/span[1]")));
		//Calls the Share check function
		obj1.receiptReport(driver, sharer, username, password1);
		//Clicks on Job Observation side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();;
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		ShareCheck obj1 = new ShareCheck();
		EiRCA eirca = new EiRCA();
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Checks if marked critical
		String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong"))).getText();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong")).isDisplayed())
			System.out.println("Marked critical");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		obj1.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a/span[1]")));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a/span[2]")));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();
		obj1.loadingServer(driver);
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong")).isDisplayed()==false)
		{
			System.out.println("Unmarked critical");
		}
		//Verify report not retrieved by shared to person
		ErrorMeter obj = new ErrorMeter();
		String sharer = obj.decideSharer (y);
		obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on EiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();	
	}

	public void imageUpload(WebDriver driver) throws Exception {

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if(browserName.equals("chrome"))
			imageUploadChrome(driver);
		if(browserName.equals("firefox"))
			imageUploadFirefox(driver);
		if(browserName.equals("internet explorer"))
		{
			if(v.startsWith("10"))
				imageUploadIE(driver);
			if(v.startsWith("11"))
				imageUploadIE11(driver);
		}
	}

	public void dateTimeModify(WebDriver driver) throws Exception {

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if(browserName.equals("chrome"))
			dateTimeModifyChrome(driver);
		if(browserName.equals("firefox"))
			dateTimeModifyFirefox(driver);
		if(browserName.equals("internet explorer"))
			dateTimeModifyIE(driver);
	}

	public String reportCreate(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		EiRCA obj = new EiRCA ();
		ShareCheck obj1 = new ShareCheck();
		String text = obj.textCreate(driver);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Job Observation Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo"))).click();
		//Clicks on new
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-new"))).click();
		//Click on new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		//Fills mandatory details in step1
		driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys(text);
		driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys(text);
		driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys(text);
		String ev1 = driver.findElement(By.id("pii-joa-tab-1-observer")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-joa-tab-1-location")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-joa-tab-1-job")).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(By.id("pii-joa-tab-1-observer")).clear();
			driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(By.id("pii-joa-tab-1-location")).clear();
			driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(By.id("pii-joa-tab-1-job")).clear();
			driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys(text);
		}
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-joa-tab-1-form']/div[6]/div/button"))).click();
		//Uploads image, clears it, rotates it
		imageUpload(driver);
		//Modify date time
		dateTimeModify(driver);
		//Continues on 
		path(driver);
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		obj1.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-btn-savedactivities"))).click();
		obj1.loadingServer(driver);
		//Clicks on side panel option for job observation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		obj1.loadingServer(driver);
		//Gets the name of the record created
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"));
		String recordName = record.getText();
		String r = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(text);
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ r);
		}
		else
			System.out.println ("Record not found.");

		return(r);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
	}
}
