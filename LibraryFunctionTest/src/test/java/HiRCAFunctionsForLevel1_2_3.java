import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAFunctionsForLevel1_2_3 {
	
	OPiRCA op = new OPiRCA();
	OPiRCA3 op3 = new OPiRCA3();
	LanguageCheckOfReports lcr = new LanguageCheckOfReports();
	
	public String getNoteShowingPreviousAnswer(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,1);
		HiRCAHumanError hhe = new HiRCAHumanError();
		//Get question text
		String question = wait.until(ExpectedConditions.visibilityOfElementLocated(hhe.PageQuestion)).getText().trim();
		//remove [ and ] 
		int indexOfQuestionMark = question.lastIndexOf("?");
		String r = question.substring(0, indexOfQuestionMark+1).replace("]", "").replace("[", "");
		//Get answer text
		//Count number of answers under question= number of div - the reason entry div
		int count = 0;
		while(true)
		{
			try{
				count = count+1;
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+count+"]")));
			}catch(org.openqa.selenium.TimeoutException y)
			{
				count = count-1;
				break;
			}
		}
		int start = 2;
		//Look for selected answer
		int divNumber=0;
		for(int i=start;i<=count;i++)
		{
			String getClass = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+i+"]/fieldset/div/div/label"))).getAttribute("class");
			if(getClass.contains("ui-radio-on"))
			{
				divNumber = i;
				break;
			}
		}
		//Get answer
		String answer = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+divNumber+"]/fieldset/div/div/label"))).getText();
		if (lcr.containsHanScript(answer)==true)
		{
			String note = "备注：根据以下答案所选出 "+r+": "+answer;
			System.out.println(note);
			return note;
		}
		else{
		String note = "Note: selected based on answer "+r+": "+answer;
		System.out.println(note);
		return note;
		}
	}
	
	public MultiValuedMap<String,String> joinNoteWithAnswerForSURE(WebDriver driver, String note, List<String> lopOptions) throws Exception {
		
		MultiValuedMap<String,String> hm = new ArrayListValuedHashMap<>();
		//Modify list
		List<String> lopOptions1 = op.modifyListWithNoSemiColonForSUEP_SURE(lopOptions);
		for(int i=0;i<lopOptions1.size();i++)
		{
			hm.put(lopOptions1.get(i).trim(), note);
		}		
		return hm;
	}
	
	public HashMap<String,String> joinNoteWithAnswerWithSemicolon(WebDriver driver, String note, List<String> lopOptions) throws Exception {
		
		HashMap<String,String> hm = new HashMap<String,String>();
		//Modify list
		List<String> lopOptions1 = op3.modifyList(lopOptions);
		for(int i=0;i<lopOptions1.size();i++)
		{
			hm.put(lopOptions1.get(i), note);
		}		
		return hm;
	}
}