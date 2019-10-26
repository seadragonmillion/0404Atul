package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_5 {

	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj login = new LoginPageObj();

	public List<String> EiRCAStep7 (WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> step7 = new ArrayList<String>();
		//Click on 1st collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Collapsible)).click();
		//Choose a number from 0 to 7 for number of boxes to click
		Random random = new Random();
		int n = random.nextInt(8);
		//Click random checkboxes and match the score
		int sumOfPoints = 0;	
		//Verify probability ranking
		String rankingValue = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1ProbabilityRanking)).getText();
		verifyProbabilityRankinfForFailureMode(rankingValue,sumOfPoints,softly);
		for(int i=0;i<=n;i++){
			int checkNum = random.nextInt(8);
			switch(checkNum){
			case 0:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox1)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox1)).isSelected())
					sumOfPoints+=5;
				else sumOfPoints-=5;
			}
			case 1:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox2)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox2)).isSelected())
					sumOfPoints+=4;
				else sumOfPoints-=4;
			}
			case 2:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox3)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox3)).isSelected())
					sumOfPoints+=3;
				else sumOfPoints-=3;
			}
			case 3:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox4)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox4)).isSelected())
					sumOfPoints+=3;
				else sumOfPoints-=3;
			}
			case 4:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox5)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox5)).isSelected())
					sumOfPoints+=2;
				else sumOfPoints-=2;
			}
			case 5:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox6)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox6)).isSelected())
					sumOfPoints+=2;
				else sumOfPoints-=2;
			}
			case 6:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox7)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox7)).isSelected())
					sumOfPoints+=1;
				else sumOfPoints-=1;
			}
			case 7:{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox8)).click();
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Checkbox8)).isSelected())
					sumOfPoints-=1;
				else sumOfPoints+=1;
			}			
			}	
			//Verify probability ranking
			String rankingValue1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1ProbabilityRanking)).getText();
			verifyProbabilityRankinfForFailureMode(rankingValue1,sumOfPoints,softly);
		}
		//Verify total probability ranking
		String rankingValue1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1ProbabilityRanking)).getText();
		verifyProbabilityRankinfForFailureMode(rankingValue1,sumOfPoints,softly);
		//
		//next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return step7;
	}
	
	public void verifyProbabilityRankinfForFailureMode(String rankingValue, int sumOfPoints, SoftAssertions softly) throws Exception {
		
		System.out.println(sumOfPoints);
		System.out.println(rankingValue);
		if(sumOfPoints>5){
			softly.assertThat(rankingValue).isEqualTo("Very High");
		}		
		if(sumOfPoints<=5 && sumOfPoints>=4){
			softly.assertThat(rankingValue).isEqualTo("High");
		}		
		if(sumOfPoints<=3 && sumOfPoints>=2){
			softly.assertThat(rankingValue).isEqualTo("Medium");
		}		
		if(sumOfPoints<=1 && sumOfPoints>=0){
			softly.assertThat(rankingValue).isEqualTo("Low");
		}		
		if(sumOfPoints<0){
			softly.assertThat(rankingValue).isEqualTo("Extremely Low");
		}
	}

}
