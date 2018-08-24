import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese2 {


	public void downloadReportChrome (WebDriver driver, SoftAssertions softly, List<String> verifyChinese) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		//pdf check
		pdfCheck(driver,softly,verifyChinese);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	public void downloadReportFirefox(WebDriver driver, SoftAssertions softly, List<String> verifyChinese) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
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
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
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
		}
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
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
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
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
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
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			Thread.sleep(3000);
			//Wait for loading message to disappear
			obj.loadingServer(driver);
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
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
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
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
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
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		System.out.println(lastFilePath.get());
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
		softly.assertThat(tr).as("test data").isEqualTo("3.17.1: 采购和（或）设计规范不充分");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/strong"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("扩展分析");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/label[1]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("扩展分析:");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/label[2]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("运行经验:");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/label[3]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("对核安全或安全文化的影响:");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").contains("纠正行动:");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/label/small"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]/textarea"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").isEqualTo("提高风险管理, 针对高风险技术规范，利用专家委员会, 对重复技术规范实现标准化");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").isEqualTo("3.17.2: 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]/label"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").contains("纠正行动:");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]/label/small"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]/textarea"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").isEqualTo("改善来源QA/QC 项目");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").isEqualTo("3.17.3: 设计确认和（或）使用前试验不充分");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/label"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").contains("纠正行动:");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/label/small"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/textarea"))).getText();
		System.out.println(tr15);
		softly.assertThat(tr15).as("test data").isEqualTo("改善设计确认和鉴定试验项目");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[1]"))).getText();
		System.out.println(tr16);
		softly.assertThat(tr16).as("test data").isEqualTo("3.17.4: 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]/label"))).getText();
		System.out.println(tr17);
		softly.assertThat(tr17).as("test data").contains("纠正行动:");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]/label/small"))).getText();
		System.out.println(tr18);
		softly.assertThat(tr18).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]/textarea"))).getText();
		System.out.println(tr19);
		softly.assertThat(tr19).as("test data").isEqualTo("纠正运行程序中的缺陷, 完善运行程序编写指导文件");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]"))).getText();
		System.out.println(tr20);
		softly.assertThat(tr20).as("test data").isEqualTo("3.17.5: 定期监督试验不到位");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]/label"))).getText();
		System.out.println(tr21);
		softly.assertThat(tr21).as("test data").contains("纠正行动:");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]/label/small"))).getText();
		System.out.println(tr22);
		softly.assertThat(tr22).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]/textarea"))).getText();
		System.out.println(tr23);
		softly.assertThat(tr23).as("test data").isEqualTo("完善监督试验大纲");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]"))).getText();
		System.out.println(tr24);
		softly.assertThat(tr24).as("test data").isEqualTo("3.17.6: 维修不到位");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]/label"))).getText();
		System.out.println(tr25);
		softly.assertThat(tr25).as("test data").contains("纠正行动:");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]/label/small"))).getText();
		System.out.println(tr26);
		softly.assertThat(tr26).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]/textarea"))).getText();
		System.out.println(tr27);
		softly.assertThat(tr27).as("test data").isEqualTo("完善预防性维修大纲, 完善纠正性维修大纲");
		String tr28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[1]"))).getText();
		System.out.println(tr28);
		softly.assertThat(tr28).as("test data").isEqualTo("3.17.7: 设备的标识和识别不到位");
		String tr29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]/label"))).getText();
		System.out.println(tr29);
		softly.assertThat(tr29).as("test data").contains("纠正行动:");
		String tr30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]/label/small"))).getText();
		System.out.println(tr30);
		softly.assertThat(tr30).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]/textarea"))).getText();
		System.out.println(tr31);
		softly.assertThat(tr31).as("test data").isEqualTo("改进设备标识和识别");
		//Click on HML
		//High for 3.17.2
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/fieldset/div/div[1]/label")));
		Point p = l.getLocation();
		int yaxis= p.getY()-250;
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Click H
		l.click();
		//Medium for 3.17.3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/fieldset/div/div[2]/label")));
		p = l.getLocation();
		yaxis= p.getY()-250;
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Click M
		l.click();
		//Low for 3.17.4
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/fieldset/div/div[3]/label")));
		p = l.getLocation();
		yaxis= p.getY()-250;
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Click L
		l.click();
		//Scroll up
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}

	public void chineseLevel3SelectionsSUEP2nd(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").isEqualTo("3.17.1 采购和（或）设计规范不充分");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").isEqualTo("3.17.2 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").isEqualTo("3.17.3 设计确认和（或）使用前试验不充分");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("3.17.4 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("3.17.5 定期监督试验不到位");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").isEqualTo("3.17.6 维修不到位");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").isEqualTo("3.17.7 设备的标识和识别不到位");
		//Select all 4 checkboxes for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]/div/input"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]/div/input"))).click();
	}


	public void chineseReport2ndPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 rows RC
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.17.1 采购和（或）设计规范不充分");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("提高风险管理, 针对高风险技术规范，利用专家委员会, 对重复技术规范实现标准化");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[2]/tbody/tr[1]/th"))).getText();
		softly.assertThat(r3).as("test data").contains("根本原因 (1) - 扩展分析");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[2]/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r4).as("test data").contains("扩展分析:");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[2]/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("运行经验:");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[2]/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r6).as("test data").contains("对核安全或安全文化的影响:");		
		//Table4 rows CF
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.17.2 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r14).as("test data").contains("高");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r15).as("test data").contains("改善来源QA/QC 项目");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r16).as("test data").contains("3.17.3 设计确认和（或）使用前试验不充分");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r17).as("test data").contains("中");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r18).as("test data").contains("改善设计确认和鉴定试验项目");
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r19).as("test data").contains("3.17.4 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r20).as("test data").contains("低");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r21).as("test data").contains("纠正运行程序中的缺陷, 完善运行程序编写指导文件");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.17.5 定期监督试验不到位");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("完善监督试验大纲");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.17.6 维修不到位");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("完善预防性维修大纲, 完善纠正性维修大纲");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.17.7 设备的标识和识别不到位");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("改进设备标识和识别");
		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("设备失效");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//3.17 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.17 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.17.1 采购和（或）设计规范不充分");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r147).as("test data").contains("用于制定技术规范的行业标准？");
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r22).as("test data").contains("供应商资格？");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r148).as("test data").contains("提高风险管理");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r23).as("test data").contains("针对高风险技术规范，利用专家委员会");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r24).as("test data").contains("对重复技术规范实现标准化");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.17.2 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r151).as("test data").contains(" 人员的培训和授权？全范围QA审计？");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r25).as("test data").contains("连续审计/检查或抽查审计/检查？");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r152).as("test data").contains("改善来源QA/QC 项目");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.17.3 设计确认和（或）使用前试验不充分");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r155).as("test data").contains("外推过多而没有执行鉴定试验？");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r26).as("test data").contains("复杂分析或计算的独立验证？");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r27).as("test data").contains("非编码计算的不确定性分析？");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r156).as("test data").contains("改善设计确认和鉴定试验项目");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.17.4 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r159).as("test data").contains("审查运行程序编写指导文件");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r161).as("test data").contains("纠正运行程序中的缺陷");
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r28).as("test data").contains("完善运行程序编写指导文件");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.17.5 定期监督试验不到位");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r164).as("test data").contains("没有执行监督试验？");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r165).as("test data").contains("完善监督试验大纲");
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.17.6 维修不到位");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("没有执行预防性维修？");
		String r169 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r169).as("test data").contains("纠正性维修没有效果？");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r170).as("test data").contains("完善预防性维修大纲");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r29).as("test data").contains("完善纠正性维修大纲");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.17.7 设备的标识和识别不到位");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r173).as("test data").contains("检查所有提及的设备不仅有标识，且标识正确");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r176).as("test data").contains("改进设备标识和识别");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("不适用");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r191).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r192).as("test data").contains("不适用");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r193).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("不适用");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("不适用");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("不适用");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("不适用");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("不适用");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("不适用");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("不适用");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("不适用");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("不适用");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("不适用");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("不适用");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("不适用");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("不适用");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("不适用");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("不适用");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("不适用");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("不适用");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		chineseTable7ReportTab(driver,softly);

		//SUEP
		chineseSUEPFullFormReportTab(driver,softly);
		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.17.1 采购和（或）设计规范不充分");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r30).as("test data").contains("是");
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r31).as("test data").contains("是");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[4]"))).getText();
		softly.assertThat(r32).as("test data").contains("是");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[5]"))).getText();
		softly.assertThat(r33).as("test data").contains("是");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.17.2 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.17.3 设计确认和（或）使用前试验不充分");
		String r639 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r639).as("test data").contains("3.17.4 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.17.5 定期监督试验不到位");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.17.6 维修不到位");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.17.7 设备的标识和识别不到位");

		//HiRCA self checklist chinese, all selected
		chineseHiRCASelfChecklistTitleReportTab(driver,softly);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("调查概述");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("是否访谈了所有相关方，是否收集了所有相关数据？");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("是");
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r34).as("test data").contains("是否检查了以往的类似事件？");
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r35).as("test data").contains("是");
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r36).as("test data").contains("是否识别出始发事件和相关屏障？");
		String r37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r37).as("test data").contains("是");
		String r38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r38).as("test data").contains("始发事件");
		String r39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r39).as("test data").contains("是否确定始发事件的相关错误类型？");
		String r40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r40).as("test data").contains("是");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r41).as("test data").contains("进行始发失误分析的始发事件中是否有相关的设备故障？");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r42).as("test data").contains("是");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r43).as("test data").contains("是否确定促成因子？");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r44).as("test data").contains("是");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r45).as("test data").contains("根本原因");
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r46).as("test data").contains("根本原因是否符合 ");
		softly.assertThat(r46).as("test data").contains(" 标准？");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r47).as("test data").contains("是");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r48).as("test data").contains("根本原因是否经得住 ");
		softly.assertThat(r48).as("test data").contains(" 挑战？");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r49).as("test data").contains("是");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r50).as("test data").contains("是否识别根本原因的重要性？");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r51).as("test data").contains("是");
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r52).as("test data").contains("纠正行动");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r53).as("test data").contains("建议的纠正行动是否涵盖所有直接原因、根本原因和关键促成因素？");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r54).as("test data").contains("是");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r55).as("test data").contains("建议的纠正行动是否具有成本效益？");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r56).as("test data").contains("是");

		//Last Table
		chineseLastTableReportTab(driver,softly);
	}

	public void chineseReport3rdPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 rows RC
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("不适用");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2).as("test data").contains("不适用");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3).as("test data").contains("不适用");

		//Table4 rows CF
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("不适用");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r14).as("test data").contains("不适用");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r15).as("test data").contains("不适用");
		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("天灾");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("不适用");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r191).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r192).as("test data").contains("不适用");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r193).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("不适用");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("不适用");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("不适用");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("不适用");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("不适用");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("不适用");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("不适用");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("不适用");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("不适用");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("不适用");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("不适用");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("不适用");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("不适用");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("不适用");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("不适用");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("不适用");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("不适用");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		chineseTable7ReportTab(driver,softly);

		//SUEP
		chineseSUEPFullFormReportTab(driver,softly);
		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("不适用");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r30).as("test data").contains("不适用");
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r31).as("test data").contains("不适用");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[4]"))).getText();
		softly.assertThat(r32).as("test data").contains("不适用");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[5]"))).getText();
		softly.assertThat(r33).as("test data").contains("不适用");

		//HiRCA self checklist chinese, all selected
		//Title
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[9]"))).getText();
		softly.assertThat(title2).as("test data").contains("略过: 调查员略过");
		//Heading
		String heading50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading50).as("test data").contains("类别");
		String heading51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading51).as("test data").contains("调查内容");
		String heading52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading52).as("test data").contains("完成打勾?");
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		//last table with reviewed by etc rows
		//title
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]"))).getText();
		softly.assertThat(title3).as("test data").contains("签字");
		//Rows
		String r703 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[13]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r703).as("test data").contains("编写");
		String r704 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[13]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r704).as("test data").contains("日期");
		String r705 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[13]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r705).as("test data").contains("审查");
		String r706 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[13]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r706).as("test data").contains("日期");
		String r707 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[13]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r707).as("test data").contains("批准");
		String r708 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[13]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r708).as("test data").contains("日期");
	}

	public void chineseReport1stPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 row
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("不适用");
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2a).as("test data").contains("不适用");
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3a).as("test data").contains("不适用");
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("提升管理技能，完善资源分配体系");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r15).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r16).as("test data").contains("成立培训计划委员会");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r17).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r18).as("test data").contains("完善问责制");
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r19).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r20).as("test data").contains("完善管理优先级确定和计划体系");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r21).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r22).as("test data").contains("开展关于标准设定的管理培训, 开展关于程序和保护屏障设计的培训");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r23).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r24).as("test data").contains("定期开展共因分析, 改善绩效跟踪与趋势分析项目, 完善KPI");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r25).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r26).as("test data").contains("开展组织设计方面的管理培训, 在经理人员之间建立共同目标、共同利益和共同责任");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r27).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r28).as("test data").contains("提高纠正行动计划的落实, 改善根本原因分析方法, 完善突发紧急问题（危机）管理机制");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r29).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r30).as("test data").contains("完善垂直沟通体系");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r41).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r42).as("test data").contains("完善程序设计, 制定共同目标和共同利益");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r43).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r44).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r45).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r46).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r47).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r48).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r49).as("test data").contains("3.4.4 感到疑惑时质疑不充分");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r50).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r51).as("test data").contains("3.4.5 任务准备过程中质疑不充分");
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r52).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r53).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[3]"))).getText();
		softly.assertThat(r54).as("test data").contains("情况警觉培训, 作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r55).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r56).as("test data").contains("情况警觉培训");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r57).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[3]"))).getText();
		softly.assertThat(r58).as("test data").contains("开展人员表现观察技能方面的培训");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r59).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r60).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r61).as("test data").contains("3.6.1 要求有遗漏");
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[3]"))).getText();
		softly.assertThat(r62).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r63).as("test data").contains("3.6.2 运行条件有遗漏");
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r64).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r65).as("test data").contains("3.6.3 假设有遗漏");
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[3]"))).getText();
		softly.assertThat(r66).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("3.6.4 范围有遗漏");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r68).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r69).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[30]/td[3]"))).getText();
		softly.assertThat(r70).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r71).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(r71).as("test data").contains("不准做清单");
		softly.assertThat(r71).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r72).as("test data").contains("开展程序设计编写培训, 改善程序编写导则");
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r73).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[32]/td[3]"))).getText();
		softly.assertThat(r74).as("test data").contains("开展程序审查培训");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[33]/td[1]"))).getText();
		softly.assertThat(r75).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[33]/td[3]"))).getText();
		softly.assertThat(r76).as("test data").contains("开展根本原因培训");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[34]/td[1]"))).getText();
		softly.assertThat(r77).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[34]/td[3]"))).getText();
		softly.assertThat(r78).as("test data").contains("改善纠正措施制度的监督与执行");
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(r79).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[35]/td[3]"))).getText();
		softly.assertThat(r80).as("test data").contains("加强培训资源, 开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[36]/td[1]"))).getText();
		softly.assertThat(r81).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[36]/td[3]"))).getText();
		softly.assertThat(r82).as("test data").contains("增加复训频率，改善复训形式");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[37]/td[1]"))).getText();
		softly.assertThat(r83).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[37]/td[3]"))).getText();
		softly.assertThat(r84).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[38]/td[1]"))).getText();
		softly.assertThat(r85).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[38]/td[3]"))).getText();
		softly.assertThat(r86).as("test data").contains("提高对培训效果的审查");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[39]/td[1]"))).getText();
		softly.assertThat(r87).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[39]/td[3]"))).getText();
		softly.assertThat(r88).as("test data").contains("完善承包商控制方针, 完善培训资源");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[40]/td[1]"))).getText();
		softly.assertThat(r89).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[40]/td[3]"))).getText();
		softly.assertThat(r90).as("test data").contains("完善在岗培训方针, 完善培训资源");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(r91).as("test data").contains("3.10.1 关键岗位员工的作业授权不充分");
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[41]/td[3]"))).getText();
		softly.assertThat(r92).as("test data").contains("完善作业授权");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[42]/td[1]"))).getText();
		softly.assertThat(r93).as("test data").contains("3.10.2 关键岗位主管和（或）经理授权不充分");
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[42]/td[3]"))).getText();
		softly.assertThat(r94).as("test data").contains("完善主管和经理的岗位授权");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[43]/td[1]"))).getText();
		softly.assertThat(r95).as("test data").contains("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[43]/td[3]"))).getText();
		softly.assertThat(r96).as("test data").contains("完善供应商控制制度");
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(r97).as("test data").contains("3.10.4 现场供应商人员授权不充分");
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[44]/td[3]"))).getText();
		softly.assertThat(r98).as("test data").contains("完善供应商控制制度");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[45]/td[1]"))).getText();
		softly.assertThat(r99).as("test data").contains("3.10.5 培训教员授权不充分");
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[45]/td[3]"))).getText();
		softly.assertThat(r100).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[46]/td[1]"))).getText();
		softly.assertThat(r101).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[46]/td[3]"))).getText();
		softly.assertThat(r102).as("test data").contains("完善趋势分析体系, 完善趋势反馈");
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(r103).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[47]/td[3]"))).getText();
		softly.assertThat(r104).as("test data").contains("提高主管人员的问责意识, 改善关于管理技能的培训");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[48]/td[1]"))).getText();
		softly.assertThat(r105).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[48]/td[3]"))).getText();
		softly.assertThat(r106).as("test data").contains("完善奖惩制度");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[49]/td[1]"))).getText();
		softly.assertThat(r107).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[49]/td[3]"))).getText();
		softly.assertThat(r108).as("test data").contains("在问题报告政策中要求包含一切问题和及时性, RCA培训和授权, 改善对RCA结果的反馈");
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(r109).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[50]/td[3]"))).getText();
		softly.assertThat(r110).as("test data").contains("针对现场观察结果，改善给员工的反馈, 改进现场观察员的制度和TQA");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[51]/td[1]"))).getText();
		softly.assertThat(r111).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[51]/td[3]"))).getText();
		softly.assertThat(r112).as("test data").contains("同事互助提醒（好文化）培训");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[52]/td[1]"))).getText();
		softly.assertThat(r113).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[52]/td[3]"))).getText();
		softly.assertThat(r114).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[53]/td[1]"))).getText();
		softly.assertThat(r115).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[53]/td[3]"))).getText();
		softly.assertThat(r116).as("test data").contains("行为规范培训, 采用行为规范提醒物, 采用禁止事项警告清单");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[54]/td[1]"))).getText();
		softly.assertThat(r117).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r117).as("test data").contains("同事指导");
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[54]/td[3]"))).getText();
		softly.assertThat(r118).as("test data").contains("监督管理能力培训, 就监督管理强化，对管理者实施问责");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[55]/td[1]"))).getText();
		softly.assertThat(r119).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度QV&V");
		softly.assertThat(r119).as("test data").contains("不到位");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[55]/td[3]"))).getText();
		softly.assertThat(r120).as("test data").contains("提高质疑的态度QV&V");
		softly.assertThat(r120).as("test data").contains(" 培训");
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[56]/td[1]"))).getText();
		softly.assertThat(r121).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[56]/td[3]"))).getText();
		softly.assertThat(r122).as("test data").contains("行为培训，避免过度自信");
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[57]/td[1]"))).getText();
		softly.assertThat(r123).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[57]/td[3]"))).getText();
		softly.assertThat(r124).as("test data").contains("改善风险控制项目(FUSE");
		softly.assertThat(r124).as("test data").contains("), 完善PM&T体系");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[58]/td[1]"))).getText();
		softly.assertThat(r125).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[58]/td[3]"))).getText();
		softly.assertThat(r126).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[59]/td[1]"))).getText();
		softly.assertThat(r127).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[59]/td[3]"))).getText();
		softly.assertThat(r128).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[60]/td[1]"))).getText();
		softly.assertThat(r129).as("test data").contains("3.22.1 对规则的现场试验不充分");
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[60]/td[3]"))).getText();
		softly.assertThat(r130).as("test data").contains("发布规则/程序前，执行现场试验");
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[61]/td[1]"))).getText();
		softly.assertThat(r131).as("test data").contains("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[61]/td[3]"))).getText();
		softly.assertThat(r132).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序, 制定遇到程序关键错误后要求停止操作的政策");
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[62]/td[1]"))).getText();
		softly.assertThat(r133).as("test data").contains("3.22.3 盲目信任错误规则");
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[62]/td[3]"))).getText();
		softly.assertThat(r134).as("test data").contains(" 培训");
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[63]/td[1]"))).getText();
		softly.assertThat(r135).as("test data").contains("3.22.4 规则审核不到位");
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[63]/td[3]"))).getText();
		softly.assertThat(r136).as("test data").contains("提供有效审核的相关培训");
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[64]/td[1]"))).getText();
		softly.assertThat(r137).as("test data").contains("3.22.5 工前会、班前会、交底会的规则不充分");
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[64]/td[3]"))).getText();
		softly.assertThat(r138).as("test data").contains("完善关于工前会、班前会、交底会的规则");

		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("知识型错误");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//3.4 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.4 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r147).as("test data").contains("访谈犯错者");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r148).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r151).as("test data").contains("访谈犯错者");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r152).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r155).as("test data").contains("访谈犯错者");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r156).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.4.4 感到疑惑时质疑不充分");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("访谈犯错者");
		String r160 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r160).as("test data").contains("访谈主管");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r161).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.4.5 任务准备过程中质疑不充分");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r164).as("test data").contains("访谈犯错者");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r165).as("test data").contains("开展关键思考和关键追问方面的培训");
		//3.18
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度QV&V");
		softly.assertThat(r166).as("test data").contains("不到位");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("审查培训材料？");
		String r169 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r169).as("test data").contains("审查以往类似事件？");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li"))).getText();
		softly.assertThat(r170).as("test data").contains("提高质疑的态度QV&V");
		softly.assertThat(r170).as("test data").contains(" 培训");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r173).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String r174 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r174).as("test data").contains("过去有过超出能力工作的事件?");
		String r175 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r175).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r176).as("test data").contains("行为培训，避免过度自信");
		String r177 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r177).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r178 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r178).as("test data").contains("不适用");
		String r179 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r179).as("test data").contains("因忽略相关风险而未设置屏障");
		String r180 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r180).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r181).as("test data").contains("改善风险控制项目(");
		String r182 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r182).as("test data").contains("完善PM&T体系");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r183).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r184).as("test data").contains("不适用");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r185).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r186).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r187).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r188).as("test data").contains("不适用");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r189).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r190).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//1.3
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r191).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r192).as("test data").contains("不适用");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r193).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("不适用");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("不适用");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("有");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//3.15 table heading
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading7).as("test data").contains("可能促成因素");
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading8).as("test data").contains("支持证据");
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading9).as("test data").contains("进一步调查");
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading10).as("test data").contains("可能的纠正行动");
		//3.15 table rows
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r203).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r204).as("test data").contains("不适用");
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r205).as("test data").contains("审查相关培训？");
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r206).as("test data").contains("同事互助提醒（好文化）培训");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r207).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r208).as("test data").contains("不适用");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r209).as("test data").contains("审查关于同事互助提醒（好文化）的管理期望和标准？");
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r210).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r211).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r212).as("test data").contains("不适用");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r213).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r214).as("test data").contains("行为规范培训");
		String r215 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r215).as("test data").contains("采用行为规范提醒物");
		String r216 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r216).as("test data").contains("采用禁止事项警告清单");
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r217).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r217).as("test data").contains("同事指导");
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r218).as("test data").contains("不适用");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r219).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r220).as("test data").contains("监督管理能力培训");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r221).as("test data").contains("就监督管理强化，对管理者实施问责");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("不能");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("没有");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//3.9 table heading
		String heading11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading11).as("test data").contains("可能促成因素");
		String heading12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading12).as("test data").contains("支持证据");
		String heading13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading13).as("test data").contains("进一步调查");
		String heading14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading14).as("test data").contains("可能的纠正行动");
		//3.9 table rows
		String r228 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r228).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r229 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r229).as("test data").contains("不适用");
		String r230 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r230).as("test data").contains("与类似组织对标？");
		String r231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r231).as("test data").contains("通过现场观察审查培训效果？");
		String r232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r232).as("test data").contains("加强培训资源");
		String r233 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r233).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String r234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r234).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r235 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r235).as("test data").contains("不适用");
		String r236 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r236).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String r237 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r237).as("test data").contains("复训的形式？");
		String r238 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r238).as("test data").contains("增加复训频率，改善复训形式");
		String r239 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r239).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r240 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r240).as("test data").contains("不适用");
		String r241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r241).as("test data").contains("部门经理审查关于培训材料的意见？");
		String r242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r242).as("test data").contains("部门经理监督对上课情况？");
		String r243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r243).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String r244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r244).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r245).as("test data").contains("不适用");
		String r246 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r246).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		String r247 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r247).as("test data").contains("提高对培训效果的审查");
		String r248 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r248).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r249 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r249).as("test data").contains("不适用");
		String r250 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r250).as("test data").contains("培训签到表，%员工接受了培训？");
		String r251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r251).as("test data").contains("现场承包商没有经过培训？");
		String r252 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r252).as("test data").contains("完善承包商控制方针");
		String r253 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r253).as("test data").contains("完善培训资源");
		String r254 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r254).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r255 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r255).as("test data").contains("不适用");
		String r256 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r256).as("test data").contains("在岗培训方针？");
		String r257 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r257).as("test data").contains("经验不足的员工没有经过培训？");
		String r258 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r258).as("test data").contains("完善在岗培训方针");
		String r259 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r259).as("test data").contains("完善培训资源");
		//3.10
		String r260 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r260).as("test data").contains("3.10.1 关键岗位员工的作业授权不充分");
		String r261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r261).as("test data").contains("不适用");
		String r262 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r262).as("test data").contains("授权政策和证书？");
		String r263 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r263).as("test data").contains("完善作业授权");
		String r264 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r264).as("test data").contains("3.10.2 关键岗位主管和（或）经理授权不充分");
		String r265 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r265).as("test data").contains("不适用");
		String r266 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li"))).getText();
		softly.assertThat(r266).as("test data").contains("授权政策和证书？");
		String r267 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li"))).getText();
		softly.assertThat(r267).as("test data").contains("完善主管和经理的岗位授权");
		String r268 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r268).as("test data").contains("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String r269 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r269).as("test data").contains("不适用");
		String r270 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li"))).getText();
		softly.assertThat(r270).as("test data").contains("授权政策和证书？");
		String r271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r271).as("test data").contains("完善供应商控制制度");
		String r272 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r272).as("test data").contains("3.10.4 现场供应商人员授权不充分");
		String r273 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r273).as("test data").contains("不适用");
		String r274 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li"))).getText();
		softly.assertThat(r274).as("test data").contains("授权政策和证书？");
		String r275 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li"))).getText();
		softly.assertThat(r275).as("test data").contains("完善供应商控制制度");
		String r276 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r276).as("test data").contains("3.10.5 培训教员授权不充分");
		String r277 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r277).as("test data").contains("不适用");
		String r278 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li"))).getText();
		softly.assertThat(r278).as("test data").contains("授权政策和证书？");
		String r279 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li"))).getText();
		softly.assertThat(r279).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		//3.11
		String r280 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r280).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r281 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r281).as("test data").contains("不适用");
		String r282 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li"))).getText();
		softly.assertThat(r282).as("test data").contains("向员工反馈绩效趋势结果？");
		String r283 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r283).as("test data").contains("完善趋势分析体系");
		String r284 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r284).as("test data").contains("完善趋势反馈");
		String r285 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r285).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r286 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r286).as("test data").contains("不适用");
		String r287 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r287).as("test data").contains("花在现场观察和监督工作的时间是否足够？");
		String r288 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r288).as("test data").contains("标准的持续强化？");
		String r289 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r289).as("test data").contains("观察到偏差时，是否及时反馈？");
		String r290 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r290).as("test data").contains("正面反馈多余负面反馈？");
		String r291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r291).as("test data").contains("提高主管人员的问责意识");
		String r292 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r292).as("test data").contains("改善关于管理技能的培训");
		String r293 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r293).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r294 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r294).as("test data").contains("不适用");
		String r295 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r295).as("test data").contains("奖惩制度是否及时？");
		String r296 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r296).as("test data").contains("奖惩制度是否公平？");
		String r297 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r297).as("test data").contains("奖惩制度是否坚定？");
		String r298 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li"))).getText();
		softly.assertThat(r298).as("test data").contains("完善奖惩制度");
		String r299 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r299).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r300 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r300).as("test data").contains("不适用");
		String r301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[3]/ul/li"))).getText();
		softly.assertThat(r301).as("test data").contains("核实汇报分析的小事件数量比例以及受伤数量");
		String r302 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r302).as("test data").contains("在问题报告政策中要求包含一切问题和及时性");
		String r303 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r303).as("test data").contains("RCA培训和授权");
		String r304 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r304).as("test data").contains("改善对RCA结果的反馈");
		String r305 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r305).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r306 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r306).as("test data").contains("不适用");
		String r307 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r307).as("test data").contains("各部门均建立了现场观察指导制度？");
		String r308 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r308).as("test data").contains("对过去现场观察指导结果的有效性审查？");
		String r309 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r309).as("test data").contains("花在现场观察指导上的时间？");
		String r310 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r310).as("test data").contains("针对现场观察结果，改善给员工的反馈");
		String r311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r311).as("test data").contains("改进现场观察员的制度和TQA");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("没有");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");
		//3.2 table heading
		String heading15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading15).as("test data").contains("可能促成因素");
		String heading16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading16).as("test data").contains("支持证据");
		String heading17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading17).as("test data").contains("进一步调查");
		String heading18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading18).as("test data").contains("可能的纠正行动");
		//3.2 table rows
		String r315 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r315).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r316 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r316).as("test data").contains("不适用");
		String r317 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r317).as("test data").contains("访谈同事？");
		String r318 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r318).as("test data").contains("监督管理方面的培训");
		String r319 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r319).as("test data").contains("监督行为规范的管理");
		String r320 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r320).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r321).as("test data").contains("不适用");
		String r322 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r322).as("test data").contains("访谈同事？");
		String r323 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r323).as("test data").contains("监督管理方面的培训");
		String r324 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r324).as("test data").contains("监督行为规范的管理");
		String r325 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r325).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r326 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r326).as("test data").contains("不适用");
		String r327 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r327).as("test data").contains("访谈同事？");
		String r328 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r328).as("test data").contains("监督管理方面的培训");
		String r329 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r329).as("test data").contains("监督行为规范的管理");
		String r330 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r330).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r331).as("test data").contains("不适用");
		String r332 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r332).as("test data").contains("访谈同事？");
		String r333 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r333).as("test data").contains("监督管理方面的培训");
		String r334 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r334).as("test data").contains("监督行为规范的管理");
		String r335 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r335).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r336 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r336).as("test data").contains("不适用");
		String r337 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r337).as("test data").contains("访谈同事？");
		String r338 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r338).as("test data").contains("监督管理方面的培训");
		String r339 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r339).as("test data").contains("监督行为规范的管理");
		String r340 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r340).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r341).as("test data").contains("不适用");
		String r342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li"))).getText();
		softly.assertThat(r342).as("test data").contains("访谈下属？");
		String r343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r343).as("test data").contains("监督管理方面的培训");
		String r344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r344).as("test data").contains("监督行为规范的管理");
		//3.11
		String r345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r345).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r346 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r346).as("test data").contains("不适用");
		String r347 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r347).as("test data").contains("向员工反馈绩效趋势结果？");
		String r348 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r348).as("test data").contains("完善趋势分析体系");
		String r349 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r349).as("test data").contains("完善趋势反馈");
		String r350 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r350).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r351).as("test data").contains("不适用");
		String r352 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r352).as("test data").contains("花在现场观察和监督工作的时间是否足够？");
		String r353 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r353).as("test data").contains("标准的持续强化？");
		String r354 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r354).as("test data").contains("观察到偏差时，是否及时反馈？");
		String r355 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r355).as("test data").contains("正面反馈多余负面反馈？");
		String r356 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r356).as("test data").contains("提高主管人员的问责意识");
		String r357 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r357).as("test data").contains("改善关于管理技能的培训");
		String r358 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r358).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r359 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r359).as("test data").contains("不适用");
		String r360 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r360).as("test data").contains("奖惩制度是否及时？");
		String r361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r361).as("test data").contains("奖惩制度是否公平？");
		String r362 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r362).as("test data").contains("奖惩制度是否坚定？");
		String r363 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r363).as("test data").contains("完善奖惩制度");
		String r364 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r364).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r365 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r365).as("test data").contains("不适用");
		String r366 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li"))).getText();
		softly.assertThat(r366).as("test data").contains("核实汇报分析的小事件数量比例以及受伤数量");
		String r367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r367).as("test data").contains("在问题报告政策中要求包含一切问题和及时性");
		String r368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r368).as("test data").contains("RCA培训和授权");
		String r369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r369).as("test data").contains("改善对RCA结果的反馈");
		String r370 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r370).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r371).as("test data").contains("不适用");
		String r372 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r372).as("test data").contains("各部门均建立了现场观察指导制度？");
		String r373 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r373).as("test data").contains("对过去现场观察指导结果的有效性审查？");
		String r374 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r374).as("test data").contains("花在现场观察指导上的时间？");
		String r375 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r375).as("test data").contains("针对现场观察结果，改善给员工的反馈");
		String r376 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r376).as("test data").contains("改进现场观察员的制度和TQA");
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("没有专心参与");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("新程序的使用未有妥当培训");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//3.9 table heading
		String heading19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading19).as("test data").contains("可能促成因素");
		String heading20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading20).as("test data").contains("支持证据");
		String heading21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading21).as("test data").contains("进一步调查");
		String heading22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading22).as("test data").contains("可能的纠正行动");
		//3.9 table rows
		String r383 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r383).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r2291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2291).as("test data").contains("不适用");
		String r2301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2301).as("test data").contains("与类似组织对标？");
		String r2311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2311).as("test data").contains("通过现场观察审查培训效果？");
		String r2321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r2321).as("test data").contains("加强培训资源");
		String r2331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r2331).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String r2341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r2341).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r2351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r2351).as("test data").contains("不适用");
		String r2361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2361).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String r2371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2371).as("test data").contains("复训的形式？");
		String r2381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r2381).as("test data").contains("增加复训频率，改善复训形式");
		String r2391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r2391).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r2401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r2401).as("test data").contains("不适用");
		String r2411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2411).as("test data").contains("部门经理审查关于培训材料的意见？");
		String r2421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2421).as("test data").contains("部门经理监督对上课情况？");
		String r2431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r2431).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String r2441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r2441).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r2451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r2451).as("test data").contains("不适用");
		String r2461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r2461).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		String r2471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r2471).as("test data").contains("提高对培训效果的审查");
		String r2481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r2481).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r2491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r2491).as("test data").contains("不适用");
		String r2501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2501).as("test data").contains("培训签到表，%员工接受了培训？");
		String r2511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2511).as("test data").contains("现场承包商没有经过培训？");
		String r2521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r2521).as("test data").contains("完善承包商控制方针");
		String r2531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r2531).as("test data").contains("完善培训资源");
		String r2541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r2541).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r2551 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r2551).as("test data").contains("不适用");
		String r2561 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2561).as("test data").contains("在岗培训方针？");
		String r2571 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2571).as("test data").contains("经验不足的员工没有经过培训？");
		String r2581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r2581).as("test data").contains("完善在岗培训方针");
		String r2591 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r2591).as("test data").contains("完善培训资源");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("违反程序规定未执行");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("没有，请重新思考您的答案");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("没有，但其他组长有");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//3.2 table heading
		String heading221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading221).as("test data").contains("可能促成因素");
		String heading23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading23).as("test data").contains("支持证据");
		String heading24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading24).as("test data").contains("进一步调查");
		String heading25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading25).as("test data").contains("可能的纠正行动");
		//3.2 table rows
		String r3151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r3151).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r3161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r3161).as("test data").contains("不适用");
		String r3171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r3171).as("test data").contains("访谈同事？");
		String r3181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3181).as("test data").contains("监督管理方面的培训");
		String r3191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3191).as("test data").contains("监督行为规范的管理");
		String r388 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r388).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r389 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r389).as("test data").contains("不适用");
		String r390 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r390).as("test data").contains("访谈同事？");
		String r391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r391).as("test data").contains("监督管理方面的培训");
		String r392 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r392).as("test data").contains("监督行为规范的管理");
		String r393 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r393).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r394 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r394).as("test data").contains("不适用");
		String r395 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r395).as("test data").contains("访谈同事？");
		String r396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r396).as("test data").contains("监督管理方面的培训");
		String r3291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3291).as("test data").contains("监督行为规范的管理");
		String r3301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r3301).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r3311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r3311).as("test data").contains("不适用");
		String r3321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r3321).as("test data").contains("访谈同事？");
		String r3331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3331).as("test data").contains("监督管理方面的培训");
		String r3341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3341).as("test data").contains("监督行为规范的管理");
		String r3351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r3351).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r3361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r3361).as("test data").contains("不适用");
		String r3371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r3371).as("test data").contains("访谈同事？");
		String r3381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3381).as("test data").contains("监督管理方面的培训");
		String r3391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3391).as("test data").contains("监督行为规范的管理");
		String r3401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r3401).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r3411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r3411).as("test data").contains("不适用");
		String r3421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li"))).getText();
		softly.assertThat(r3421).as("test data").contains("访谈下属？");
		String r3431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3431).as("test data").contains("监督管理方面的培训");
		String r3441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3441).as("test data").contains("监督行为规范的管理");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("有，但未提前识别");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//3.6 table heading
		String heading27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading27).as("test data").contains("可能促成因素");
		String heading28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading28).as("test data").contains("支持证据");
		String heading29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading29).as("test data").contains("进一步调查");
		String heading30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading30).as("test data").contains("可能的纠正行动");
		//3.6 table rows
		String r400 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r400).as("test data").contains("3.6.1 要求有遗漏");
		String r401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r401).as("test data").contains("不适用");
		String r402 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r402).as("test data").contains("规范和标准？");
		String r403 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r403).as("test data").contains("规范和标准？");
		String r404 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r404).as("test data").contains("与其他项目之间的接口要求？");
		String r405 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r405).as("test data").contains("完善规则");
		String r406 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r406).as("test data").contains("开展程序设计方面的培训");
		String r407 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r407).as("test data").contains("3.6.2 运行条件有遗漏");
		String r408 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r408).as("test data").contains("不适用");
		String r409 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r409).as("test data").contains("规则适用的运行条件范围？");
		String r410 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r410).as("test data").contains("进入规则的前提条件？");
		String r411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r411).as("test data").contains("退出规则的条件？");
		String r412 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r412).as("test data").contains("完善规则");
		String r413 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r413).as("test data").contains("开展程序设计方面的培训");
		String r414 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r414).as("test data").contains("3.6.3 假设有遗漏");
		String r415 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r415).as("test data").contains("不适用");
		String r416 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r416).as("test data").contains("假设未予以说明？");
		String r417 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r417).as("test data").contains("未要求在任务完成前对假设进行验证？");
		String r418 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r418).as("test data").contains("对未经验证的假设没有制定缓解措施？");
		String r419 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r419).as("test data").contains("完善规则");
		String r420 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r420).as("test data").contains("开展程序设计方面的培训");
		String r421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r421).as("test data").contains("3.6.4 范围有遗漏");
		String r422 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r422).as("test data").contains("不适用");
		String r423 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r423).as("test data").contains("使用通用规则，缺少针对各种特殊情况的具体描述？");
		String r424 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r424).as("test data").contains("步骤遗漏？");
		String r425 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r425).as("test data").contains("遗漏了碰到异常情况时需采取的行动？");
		String r426 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r426).as("test data").contains("完善规则");
		String r427 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r427).as("test data").contains("开展程序设计方面的培训");
		String r428 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r428).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r429 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r429).as("test data").contains("不适用");
		String r430 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r430).as("test data").contains("遗漏了用于验收是否正确执行的相关试验或测量？");
		String r431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r431).as("test data").contains("完善规则");
		String r432 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r432).as("test data").contains("开展程序设计方面的培训");
		String r433 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r433).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(r433).as("test data").contains("不准做清单");
		softly.assertThat(r433).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r434 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r434).as("test data").contains("不适用");
		String r435 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r435).as("test data").contains("调查程序编写者");
		String r436 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r436).as("test data").contains("调查程序设计编写培训");
		String r437 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r437).as("test data").contains("开展程序设计编写培训");
		String r438 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r438).as("test data").contains("改善程序编写导则");
		String r439 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r439).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r440 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r440).as("test data").contains("不适用");
		String r441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r441).as("test data").contains("调查程序审查者");
		String r442 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r442).as("test data").contains("调查程序审查培训");
		String r443 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r443).as("test data").contains("开展程序审查培训");
		String r444 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r444).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r445 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r445).as("test data").contains("不适用");
		String r446 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r446).as("test data").contains("调查事件调查者");
		String r447 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r447).as("test data").contains("调查事件根本原因培训");
		String r448 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li"))).getText();
		softly.assertThat(r448).as("test data").contains("开展根本原因培训");
		String r449 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r449).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r450 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r450).as("test data").contains("不适用");
		String r451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r451).as("test data").contains("调查纠正措施主管");
		String r452 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r452).as("test data").contains("调查纠正措施制度缺陷");
		String r453 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r453).as("test data").contains("改善纠正措施制度的监督与执行");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("是，跟其他组长相比下有缺失");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//3.2 table heading
		String heading31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading31).as("test data").contains("可能促成因素");
		String heading32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading32).as("test data").contains("支持证据");
		String heading33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading33).as("test data").contains("进一步调查");
		String heading34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading34).as("test data").contains("可能的纠正行动");
		//3.2 table rows
		String r457 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r457).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r458 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r458).as("test data").contains("不适用");
		String r459 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r459).as("test data").contains("访谈同事？");
		String r460 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r460).as("test data").contains("监督管理方面的培训");
		String r461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r461).as("test data").contains("监督行为规范的管理");
		String r462 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r462).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r463 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r463).as("test data").contains("不适用");
		String r464 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r464).as("test data").contains("访谈同事？");
		String r465 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r465).as("test data").contains("监督管理方面的培训");
		String r466 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r466).as("test data").contains("监督行为规范的管理");
		String r467 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r467).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r468 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r468).as("test data").contains("不适用");
		String r469 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r469).as("test data").contains("访谈同事？");
		String r470 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r470).as("test data").contains("监督管理方面的培训");
		String r471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r471).as("test data").contains("监督行为规范的管理");
		String r472 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r472).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r473 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r473).as("test data").contains("不适用");
		String r474 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r474).as("test data").contains("访谈同事？");
		String r475 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r475).as("test data").contains("监督管理方面的培训");
		String r476 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r476).as("test data").contains("监督行为规范的管理");
		String r477 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r477).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r478 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r478).as("test data").contains("不适用");
		String r479 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r479).as("test data").contains("访谈同事？");
		String r480 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r480).as("test data").contains("监督管理方面的培训");
		String r481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r481).as("test data").contains("监督行为规范的管理");
		String r482 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r482).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r483 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r483).as("test data").contains("不适用");
		String r484 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li"))).getText();
		softly.assertThat(r484).as("test data").contains("访谈下属？");
		String r485 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r485).as("test data").contains("监督管理方面的培训");
		String r486 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r486).as("test data").contains("监督行为规范的管理");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[25]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("有");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//3.3 table heading
		String heading35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading35).as("test data").contains("可能促成因素");
		String heading36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading36).as("test data").contains("支持证据");
		String heading37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading37).as("test data").contains("进一步调查");
		String heading38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading38).as("test data").contains("可能的纠正行动");
		//3.3 table rows
		String r490 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r490).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r491).as("test data").contains("不适用");
		String r492 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r492).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String r493 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r493).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		String r495 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r495).as("test data").contains("提升管理技能，完善资源分配体系");
		String r497 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r497).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r498 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r498).as("test data").contains("不适用");
		String r499 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r499).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		String r500 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r500).as("test data").contains("成立培训计划委员会");
		String r501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r501).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r502 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r502).as("test data").contains("不适用");
		String r503 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r503).as("test data").contains("PM&T是否充分？");
		String r504 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r504).as("test data").contains("JO是否充分？");
		String r505 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r505).as("test data").contains("RCA是否充分？");
		String r506 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r506).as("test data").contains("ORRA是否充分？");
		String r507 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r507).as("test data").contains("完善问责制");
		String r508 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r508).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r509 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r509).as("test data").contains("不适用");
		String r510 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r510).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String r511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r511).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		String r512 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r512).as("test data").contains("完善管理优先级确定和计划体系？");
		String r513 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r513).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r514 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r514).as("test data").contains("不适用");
		String r515 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r515).as("test data").contains("自我分析（自评）？");
		String r516 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r516).as("test data").contains("与表现优秀者对标？");
		String r517 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r517).as("test data").contains("开展关于标准设定的管理培训");
		String r518 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r518).as("test data").contains("开展关于程序和保护屏障设计的培训");
		String r519 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r519).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r520 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r520).as("test data").contains("不适用");
		String r521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r521).as("test data").contains("KPI不充分？");
		String r522 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r522).as("test data").contains("没有定期开展共因分析？");
		String r523 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r523).as("test data").contains("未对类似事件或失误进行趋势分析？");
		String r524 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r524).as("test data").contains("定期开展共因分析");
		String r525 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r525).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String r526 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r526).as("test data").contains("完善KPI");
		String r527 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r527).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r528 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r528).as("test data").contains("不适用");
		String r529 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r529).as("test data").contains("经理之间的接口问题？");
		String r530 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r530).as("test data").contains("主管或经理之间存在不和？");
		String r531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r531).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		String r532 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r532).as("test data").contains("开展组织设计方面的管理培训");
		String r533 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r533).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		String r534 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r534).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r535 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r535).as("test data").contains("不适用");
		String r536 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r536).as("test data").contains("根本原因分析不足导致事件重发？");
		String r537 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r537).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String r538 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r538).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		String r539 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r539).as("test data").contains("提高纠正行动计划的落实");
		String r540 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r540).as("test data").contains("改善根本原因分析方法");
		String r541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r541).as("test data").contains("完善突发紧急问题（危机）管理机制");
		String r542 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r542).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r543 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r543).as("test data").contains("不适用");
		String r544 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r544).as("test data").contains("方针培训？");
		String r545 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r545).as("test data").contains("对员工的管理指导？");
		String r546 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r546).as("test data").contains("传达给员工的工作指令不充分？");
		String r547 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r547).as("test data").contains("是否定期召开员工会议？");
		String r548 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r548).as("test data").contains("完善垂直沟通体系");
		String r549 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r549).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r550 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r550).as("test data").contains("不适用");
		String r551 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r551).as("test data").contains("共同目标和共同利益不充分？");
		String r552 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r552).as("test data").contains("程序设计不当？");
		String r553 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r553).as("test data").contains("完善程序设计");
		String r554 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r554).as("test data").contains("制定共同目标和共同利益");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[27]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("是");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//3.22 table heading
		String heading39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading39).as("test data").contains("可能促成因素");
		String heading40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading40).as("test data").contains("支持证据");
		String heading41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading41).as("test data").contains("进一步调查");
		String heading42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading42).as("test data").contains("可能的纠正行动");
		//3.22 table rows
		String r558 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r558).as("test data").contains("3.22.1 对规则的现场试验不充分");
		String r559 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r559).as("test data").contains("不适用");
		String r560 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r560).as("test data").contains("有无现场试验？");
		String r561 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r561).as("test data").contains("发布规则/程序前，执行现场试验");
		String r562 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r562).as("test data").contains("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String r563 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r563).as("test data").contains("不适用");
		String r564 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r564).as("test data").contains("有无反馈？");
		String r565 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r565).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序");
		String r566 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r566).as("test data").contains("制定遇到程序关键错误后要求停止操作的政策");
		String r567 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r567).as("test data").contains("3.22.3 盲目信任错误规则");
		String r568 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r568).as("test data").contains("不适用");
		String r569 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r569).as("test data").contains("是否要求澄清？");
		String r570 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r570).as("test data").contains("培训");
		String r571 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r571).as("test data").contains("3.22.4 规则审核不到位");
		String r572 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r572).as("test data").contains("不适用");
		String r573 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r573).as("test data").contains("程序/规则当时是如何审核的？");
		String r574 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r574).as("test data").contains("提供有效审核的相关培训");
		String r575 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r575).as("test data").contains("3.22.5 工前会、班前会、交底会的规则不充分");
		String r576 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r576).as("test data").contains("不适用");
		String r577 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r577).as("test data").contains("工前会、班前会、交底会上是否识别出错误的规则/程序？");
		String r578 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r578).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("是");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//3.3 table heading
		String heading351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading351).as("test data").contains("可能促成因素");
		String heading361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading361).as("test data").contains("支持证据");
		String heading371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading371).as("test data").contains("进一步调查");
		String heading381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading381).as("test data").contains("可能的纠正行动");
		//3.3 table rows
		String r4901 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r4901).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r4911 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r4911).as("test data").contains("不适用");
		String r4921 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r4921).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String r4931 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r4931).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		String r4951 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r4951).as("test data").contains("提升管理技能，完善资源分配体系");
		String r4971 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r4971).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r4981 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r4981).as("test data").contains("不适用");
		String r4991 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r4991).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		String r5001 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r5001).as("test data").contains("成立培训计划委员会");
		String r5011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5011).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r5021 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r5021).as("test data").contains("不适用");
		String r5031 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5031).as("test data").contains("PM&T是否充分？");
		String r5041 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5041).as("test data").contains("JO是否充分？");
		String r5051 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5051).as("test data").contains("RCA是否充分？");
		String r5061 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r5061).as("test data").contains("ORRA是否充分？");
		String r5071 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r5071).as("test data").contains("完善问责制");
		String r5081 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r5081).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r5091 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r5091).as("test data").contains("不适用");
		String r5101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5101).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String r5111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5111).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		String r5121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r5121).as("test data").contains("完善管理优先级确定和计划体系？");
		String r5131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r5131).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r5141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r5141).as("test data").contains("不适用");
		String r5151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5151).as("test data").contains("自我分析（自评）？");
		String r5161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5161).as("test data").contains("与表现优秀者对标？");
		String r5171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5171).as("test data").contains("开展关于标准设定的管理培训");
		String r5181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5181).as("test data").contains("开展关于程序和保护屏障设计的培训");
		String r5191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r5191).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r5201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r5201).as("test data").contains("不适用");
		String r5211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5211).as("test data").contains("KPI不充分？");
		String r5221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5221).as("test data").contains("没有定期开展共因分析？");
		String r5231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5231).as("test data").contains("未对类似事件或失误进行趋势分析？");
		String r5241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5241).as("test data").contains("定期开展共因分析");
		String r5251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5251).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String r5261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r5261).as("test data").contains("完善KPI");
		String r5271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r5271).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r5281 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r5281).as("test data").contains("不适用");
		String r5291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5291).as("test data").contains("经理之间的接口问题？");
		String r5301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5301).as("test data").contains("主管或经理之间存在不和？");
		String r5311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5311).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		String r5321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5321).as("test data").contains("开展组织设计方面的管理培训");
		String r5331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5331).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		String r5341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r5341).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r5351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r5351).as("test data").contains("不适用");
		String r5361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5361).as("test data").contains("根本原因分析不足导致事件重发？");
		String r5371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5371).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String r5381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5381).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		String r5391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5391).as("test data").contains("提高纠正行动计划的落实");
		String r5401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5401).as("test data").contains("改善根本原因分析方法");
		String r5411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r5411).as("test data").contains("完善突发紧急问题（危机）管理机制");
		String r5421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r5421).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r5431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r5431).as("test data").contains("不适用");
		String r5441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5441).as("test data").contains("方针培训？");
		String r5451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5451).as("test data").contains("对员工的管理指导？");
		String r5461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5461).as("test data").contains("传达给员工的工作指令不充分？");
		String r5471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r5471).as("test data").contains("是否定期召开员工会议？");
		String r5481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r5481).as("test data").contains("完善垂直沟通体系");
		String r5491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r5491).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r5501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r5501).as("test data").contains("不适用");
		String r5511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5511).as("test data").contains("共同目标和共同利益不充分？");
		String r5521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5521).as("test data").contains("程序设计不当？");
		String r5531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5531).as("test data").contains("完善程序设计");
		String r5541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5541).as("test data").contains("制定共同目标和共同利益");
		//3.5
		String r582 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r582).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r583 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r583).as("test data").contains("不适用");
		String r584 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r584).as("test data").contains("情况警觉培训？");
		String r585 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r585).as("test data").contains("作业前意识体系的改善？");
		String r586 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r586).as("test data").contains("情况警觉培训");
		String r587 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r587).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r588 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r588).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r589 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r589).as("test data").contains("不适用");
		String r590 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li"))).getText();
		softly.assertThat(r590).as("test data").contains("情况警觉培训？");
		String r591 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li"))).getText();
		softly.assertThat(r591).as("test data").contains("情况警觉培训");
		String r592 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r592).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r593 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r593).as("test data").contains("不适用");
		String r594 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li"))).getText();
		softly.assertThat(r594).as("test data").contains("情况警觉培训？");
		String r595 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li"))).getText();
		softly.assertThat(r595).as("test data").contains("开展人员表现观察技能方面的培训");
		String r596 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r596).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r597 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r597).as("test data").contains("不适用");
		String r598 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li"))).getText();
		softly.assertThat(r598).as("test data").contains("情况警觉培训？");
		String r599 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li"))).getText();
		softly.assertThat(r599).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("是");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");
		//3.5 table heading
		String heading43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading43).as("test data").contains("可能促成因素");
		String heading44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading44).as("test data").contains("支持证据");
		String heading45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading45).as("test data").contains("进一步调查");
		String heading46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading46).as("test data").contains("可能的纠正行动");
		//3.5 rows
		String r603 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r603).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r604 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r604).as("test data").contains("不适用");
		String r605 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r605).as("test data").contains("情况警觉培训？");
		String r606 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r606).as("test data").contains("作业前意识体系的改善？");
		String r607 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r607).as("test data").contains("情况警觉培训");
		String r608 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r608).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r609 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r609).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r610 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r610).as("test data").contains("不适用");
		String r611 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r611).as("test data").contains("情况警觉培训？");
		String r612 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r612).as("test data").contains("情况警觉培训");
		String r613 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r613).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r614 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r614).as("test data").contains("不适用");
		String r615 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r615).as("test data").contains("情况警觉培训？");
		String r616 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r616).as("test data").contains("开展人员表现观察技能方面的培训");
		String r617 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r617).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r618 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r618).as("test data").contains("不适用");
		String r619 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r619).as("test data").contains("情况警觉培训？");
		String r620 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r620).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");

		//Table 7
		chineseTable7ReportTab(driver,softly);

		//SUEP title
		chineseSUEPFullFormReportTab(driver,softly);

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r639 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r639).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r644 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r644).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r645 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r645).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r646 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r646).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r647 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r647).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r648 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r648).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r649 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r649).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r650 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r650).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r651 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r651).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r652 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r652).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String r653 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r653).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");
		String r654 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r654).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String r655 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r655).as("test data").contains("3.4.4 感到疑惑时质疑不充分");
		String r656 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r656).as("test data").contains("3.4.5 任务准备过程中质疑不充分");
		String r657 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r657).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r658 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r658).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r659 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r659).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r660 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r660).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r661 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r661).as("test data").contains("3.6.1 要求有遗漏");
		String r662 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r662).as("test data").contains("3.6.2 运行条件有遗漏");
		String r663 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r663).as("test data").contains("3.6.3 假设有遗漏");
		String r664 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r664).as("test data").contains("3.6.4 范围有遗漏");
		String r665 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r665).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r666 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r666).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(r666).as("test data").contains("不准做清单");
		softly.assertThat(r666).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r667 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r667).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r668 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[33]/td[1]"))).getText();
		softly.assertThat(r668).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r669 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[34]/td[1]"))).getText();
		softly.assertThat(r669).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r670 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(r670).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r671 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[36]/td[1]"))).getText();
		softly.assertThat(r671).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r672 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[37]/td[1]"))).getText();
		softly.assertThat(r672).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r673 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[38]/td[1]"))).getText();
		softly.assertThat(r673).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r674 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[39]/td[1]"))).getText();
		softly.assertThat(r674).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r675 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[40]/td[1]"))).getText();
		softly.assertThat(r675).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r676 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(r676).as("test data").contains("3.10.1 关键岗位员工的作业授权不充分");
		String r677 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[42]/td[1]"))).getText();
		softly.assertThat(r677).as("test data").contains("3.10.2 关键岗位主管和（或）经理授权不充分");
		String r678 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[43]/td[1]"))).getText();
		softly.assertThat(r678).as("test data").contains("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String r679 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(r679).as("test data").contains("3.10.4 现场供应商人员授权不充分");
		String r680 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[45]/td[1]"))).getText();
		softly.assertThat(r680).as("test data").contains("3.10.5 培训教员授权不充分");
		String r681 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[46]/td[1]"))).getText();
		softly.assertThat(r681).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r682 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(r682).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r683 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[48]/td[1]"))).getText();
		softly.assertThat(r683).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r684 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[49]/td[1]"))).getText();
		softly.assertThat(r684).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r685 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(r685).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r686 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[51]/td[1]"))).getText();
		softly.assertThat(r686).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r687 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[52]/td[1]"))).getText();
		softly.assertThat(r687).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r688 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[53]/td[1]"))).getText();
		softly.assertThat(r688).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r689 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[54]/td[1]"))).getText();
		softly.assertThat(r689).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r689).as("test data").contains("同事指导");
		String r690 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[55]/td[1]"))).getText();
		softly.assertThat(r690).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度");
		softly.assertThat(r690).as("test data").contains("不到位");
		String r691 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[56]/td[1]"))).getText();
		softly.assertThat(r691).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r692 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[57]/td[1]"))).getText();
		softly.assertThat(r692).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r693 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[58]/td[1]"))).getText();
		softly.assertThat(r693).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r694 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[59]/td[1]"))).getText();
		softly.assertThat(r694).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r695 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[60]/td[1]"))).getText();
		softly.assertThat(r695).as("test data").contains("3.22.1 对规则的现场试验不充分");
		String r696 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[61]/td[1]"))).getText();
		softly.assertThat(r696).as("test data").contains("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String r697 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[62]/td[1]"))).getText();
		softly.assertThat(r697).as("test data").contains("3.22.3 盲目信任错误规则");
		String r698 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[63]/td[1]"))).getText();
		softly.assertThat(r698).as("test data").contains("3.22.4 规则审核不到位");
		String r699 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[64]/td[1]"))).getText();
		softly.assertThat(r699).as("test data").contains("3.22.5 工前会、班前会、交底会的规则不充分");

		//HiRCA self checklist chinese, none selected
		chineseHiRCASelfChecklistTitleReportTab(driver,softly);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		chineseLastTableReportTab(driver,softly);
	}

	public void chineseReport4thPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 row
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("不适用");
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2a).as("test data").contains("不适用");
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3a).as("test data").contains("不适用");
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.1.1 能力不足");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("重新调到合适岗位, 培训");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.1.2 态度和任务不匹配");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("改善任务分工策略");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.1.3 性格和任务不匹配");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("改善任务分工策略");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.1.4 缺乏专业经验");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("PJB 和MJB上提供即时经验提醒, 辅导, 培训");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.1.5 对自我缺点认识不足，缺乏相应弥补措施");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("辅导, 自我分析培训, 开展自我分析");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.1.6 不适合工作（生病、有心事等）");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("监督性行为跟踪培训");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.12.1 觉得获取工具和设备有负担");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("紧急情况下工具的发放, 简化工具放置流程, 在方便的位置放置工具和设备");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r15).as("test data").contains("3.12.2 觉得获取文件或程序有负担");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r16).as("test data").contains("使用自动化系统获取文件或程序, 将所参考程序的适用章节附在主程序后面");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r17).as("test data").contains("3.12.3 觉得获取和穿戴PPE有负担");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r18).as("test data").contains("将PPE放置在方便的位置, 避免对PPE规定过度");
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r19).as("test data").contains("3.12.4 觉得使用过于复杂或繁琐的程序有负担");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r20).as("test data").contains("使用无纸化程序系统");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r21).as("test data").contains("3.12.5 因觉得负担麻烦未到现场核实");
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r22).as("test data").contains("增加偏出控制手段如拍照现场核实照片");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r23).as("test data").contains("3.13.1 尽早完成工作，以便尽早回家");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r24).as("test data").contains("要求员工在办公室做其他相关工作，从而消除不当动机");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r25).as("test data").contains("3.13.2 尽早完成工作，以便获得奖励或免受惩罚");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r26).as("test data").contains("消除不当动机, 采用质量和生产相平衡的奖励机制");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r27).as("test data").contains("3.13.3 尽早完成工作，以便开始其他工作（尤其是根据完成的工作量计算价钱的承包商）");
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r28).as("test data").contains("使用奖惩机制来杜绝赶时间的态度");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r29).as("test data").contains("3.13.4 尽早完成工作，以便到更为舒适的环境中休息（尤其是在高温、有辐射或潮湿环境下工作）");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r30).as("test data").contains("给予充分的休息时间, 减少工作场所不舒适的工作条件");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r41).as("test data").contains("3.14.1 观察主管向下属提供反馈的频率和质量");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r42).as("test data").contains("监督管理能力培训");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r43).as("test data").contains("3.14.2 违反既定规定的情况不容易被知道（尤其是单独工作时）");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r44).as("test data").contains("提高工作绩效跟踪");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r45).as("test data").contains("3.14.3 由于缺乏明确的问责制，认为违规的后果不严重");
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r46).as("test data").contains("改善问责制");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r47).as("test data").contains("3.14.4 违规造成的受伤风险被认为很低或没有");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r48).as("test data").contains("改善问责制");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r49).as("test data").contains("3.14.5 由于有监护人在场，预期风险更低");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r50).as("test data").contains("提高监督, 改善现场观察, 改善问责制");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r51).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r52).as("test data").contains("同事互助提醒（好文化）培训");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r53).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[3]"))).getText();
		softly.assertThat(r54).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r55).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r56).as("test data").contains("行为规范培训, 采用行为规范提醒物, 采用禁止事项警告清单");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r57).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r57).as("test data").contains("同事指导");
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[3]"))).getText();
		softly.assertThat(r58).as("test data").contains("监督管理能力培训, 就监督管理强化，对管理者实施问责");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r59).as("test data").contains("3.21.1 未能识别和缓解时间相关的高风险情况，例如日常失误陷阱、工作时间、节假日影响等");
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r60).as("test data").contains("高风险情境警觉培训");
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r61).as("test data").contains("3.21.2 未能识别和缓解活动相关的高风险情况，例如伪装的首次执行操作、利益失衡、单项弱点失去管理、专门技能缺陷等等");
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[3]"))).getText();
		softly.assertThat(r62).as("test data").contains("高风险情境警觉培训");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r63).as("test data").contains("3.21.3 未能识别和缓解人员相关的高风险情况，例如能力、态度、性格、与人打交道的经验存在不足");
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r64).as("test data").contains("高风险情境警觉培训");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r65).as("test data").contains("3.21.4 未能识别和缓解环境相关的高风险情况，例如工作条件恶劣（温度、照明、噪音、高辐射水平等等）以及人机接口（标牌、显示屏、控制器等）");
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[3]"))).getText();
		softly.assertThat(r66).as("test data").contains("高风险情境警觉培训");

		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("规则型错误");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r68).as("test data").contains("有意违规");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r69).as("test data").contains("不适用");
		//3.12 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.12 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.12.1 觉得获取工具和设备有负担");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r147).as("test data").contains("观察员工；使用他们自己的工具（如多功能口袋工具，即：瑞士军刀）");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r148).as("test data").contains("紧急情况下工具的发放");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r70).as("test data").contains("简化工具放置流程");
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r71).as("test data").contains("在方便的位置放置工具和设备");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.12.2 觉得获取文件或程序有负担");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r151).as("test data").contains("观察员工现场携带程序");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r72).as("test data").contains("观察员工在开始工作前找到正确的程序");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r152).as("test data").contains("使用自动化系统获取文件或程序");
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r73).as("test data").contains("将所参考程序的适用章节附在主程序后面");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.12.3 觉得获取和穿戴PPE有负担");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r155).as("test data").contains("观察员工到作业现场时忘记携带安全帽、手套或安全鞋；观察员工是否可以轻松更换个人防护用品？");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r156).as("test data").contains("将PPE放置在方便的位置");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r91).as("test data").contains("避免对PPE规定过度");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.12.4 觉得使用过于复杂或繁琐的程序有负担");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("观察员工工作时没有逐步遵守手头程序？");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r161).as("test data").contains("使用无纸化程序系统");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.12.5 因觉得负担麻烦未到现场核实");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r164).as("test data").contains("访谈犯错者和同事");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r165).as("test data").contains("增加偏出控制手段如拍照现场核实照片");
		//3.13
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.13.1 尽早完成工作，以便尽早回家");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("观察到员工早于下班时间回家？");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li"))).getText();
		softly.assertThat(r170).as("test data").contains("要求员工在办公室做其他相关工作，从而消除不当动机");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.13.2 尽早完成工作，以便获得奖励或免受惩罚");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r173).as("test data").contains("访谈员工了解影响他们的问责机制？");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r176).as("test data").contains("消除不当动机");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r74).as("test data").contains("采用质量和生产相平衡的奖励机制");
		String r177 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r177).as("test data").contains("3.13.3 尽早完成工作，以便开始其他工作（尤其是根据完成的工作量计算价钱的承包商）");
		String r178 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r178).as("test data").contains("不适用");
		String r179 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li"))).getText();
		softly.assertThat(r179).as("test data").contains("访谈同事？");
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li"))).getText();
		softly.assertThat(r181).as("test data").contains("使用奖惩机制来杜绝赶时间的态度");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r183).as("test data").contains("3.13.4 尽早完成工作，以便到更为舒适的环境中休息（尤其是在高温、有辐射或潮湿环境下工作）");
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r184).as("test data").contains("不适用");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r185).as("test data").contains("观察工作环境？");
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r186).as("test data").contains("给予充分的休息时间");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r75).as("test data").contains("减少工作场所不舒适的工作条件");
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r187).as("test data").contains("3.14.1 观察主管向下属提供反馈的频率和质量");
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r188).as("test data").contains("不适用");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r189).as("test data").contains("观察主管向下属提供反馈的频率和质量");
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r190).as("test data").contains("监督管理能力培训");
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r76).as("test data").contains("3.14.2 违反既定规定的情况不容易被知道（尤其是单独工作时）");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r77).as("test data").contains("不适用");
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r78).as("test data").contains("访谈主管了解可能的捷径");
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r79).as("test data").contains("提高工作绩效跟踪");
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r80).as("test data").contains("3.14.3 由于缺乏明确的问责制，认为违规的后果不严重");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r81).as("test data").contains("不适用");
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r82).as("test data").contains("访谈员工主管了解他们对问责制的感受");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r83).as("test data").contains("改善问责制");
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r84).as("test data").contains("3.14.4 违规造成的受伤风险被认为很低或没有");
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r85).as("test data").contains("不适用");
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r86).as("test data").contains("观察经验反馈学习会，以便了解是否经常讨论到受伤风险");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r87).as("test data").contains("改善问责制");
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r88).as("test data").contains("3.14.5 由于有监护人在场，预期风险更低");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r89).as("test data").contains("不适用");
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r90).as("test data").contains("调查员工了解他们的惯常做法");
		String r911 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r911).as("test data").contains("提高监督");
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r92).as("test data").contains("改善现场观察");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r93).as("test data").contains("改善问责制");
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r94).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r95).as("test data").contains("不适用");
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[15]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r96).as("test data").contains("审查相关培训？");
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r97).as("test data").contains("同事互助提醒（好文化）培训");
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r98).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r99).as("test data").contains("不适用");
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r100).as("test data").contains("审查关于同事互助提醒（好文化）的管理期望和标准？");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[16]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r101).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r102).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r103).as("test data").contains("不适用");
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[17]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r104).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[17]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r105).as("test data").contains("行为规范培训");
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[17]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r106).as("test data").contains("采用行为规范提醒物");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[17]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r107).as("test data").contains("采用禁止事项警告清单");
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r108).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r108).as("test data").contains("同事指导");
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r109).as("test data").contains("不适用");
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[18]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r110).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[18]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r111).as("test data").contains("监督管理能力培训");
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]/div/table/tbody/tr[18]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r112).as("test data").contains("就监督管理强化，对管理者实施问责");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("不适用");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("不会");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//3.1 table heading
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading7).as("test data").contains("可能促成因素");
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading8).as("test data").contains("支持证据");
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading9).as("test data").contains("进一步调查");
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading10).as("test data").contains("可能的纠正行动");
		//3.1 table rows
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r203).as("test data").contains("3.1.1 能力不足");
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r204).as("test data").contains("不适用");
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r205).as("test data").contains("重复失误？");
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r206).as("test data").contains("重新调到合适岗位");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r113).as("test data").contains("培训");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r207).as("test data").contains("3.1.2 态度和任务不匹配");
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r208).as("test data").contains("不适用");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r209).as("test data").contains("性格-态度分析？");
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r210).as("test data").contains("改善任务分工策略");
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r211).as("test data").contains("3.1.3 性格和任务不匹配");
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r212).as("test data").contains("不适用");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r213).as("test data").contains("性格-态度分析？");
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r214).as("test data").contains("改善任务分工策略");
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r217).as("test data").contains("3.1.4 缺乏专业经验");
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r218).as("test data").contains("不适用");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r219).as("test data").contains("工作历史？");
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r220).as("test data").contains("PJB 和MJB上提供即时经验提醒");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r221).as("test data").contains("辅导");
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r114).as("test data").contains("培训");
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r115).as("test data").contains("3.1.5 对自我缺点认识不足，缺乏相应弥补措施");
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r116).as("test data").contains("不适用");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r117).as("test data").contains("访谈同事？");
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r118).as("test data").contains("辅导");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r119).as("test data").contains("自我分析培训");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r120).as("test data").contains("开展自我分析");
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r121).as("test data").contains("3.1.6 不适合工作（生病、有心事等）");
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r122).as("test data").contains("不适用");
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r123).as("test data").contains("访谈同事？");
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r124).as("test data").contains("访谈主管？");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r125).as("test data").contains("监督性行为跟踪培训");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("略过");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("略过");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("略过");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("略过");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");		
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("因技能不足未讨论这个风险");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//3.21 table heading
		String heading11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading11).as("test data").contains("可能促成因素");
		String heading12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading12).as("test data").contains("支持证据");
		String heading13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading13).as("test data").contains("进一步调查");
		String heading14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading14).as("test data").contains("可能的纠正行动");
		//3.21 table rows
		String r228 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r228).as("test data").contains("3.21.1 未能识别和缓解时间相关的高风险情况，例如日常失误陷阱、工作时间、节假日影响等");
		String r229 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r229).as("test data").contains("不适用");
		String r230 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r230).as("test data").contains("高风险情境警觉培训？");
		String r231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r231).as("test data").contains("作业前意识系统的完善？");
		String r232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r232).as("test data").contains("高风险情境警觉培训");
		String r234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r234).as("test data").contains("3.21.2 未能识别和缓解活动相关的高风险情况，例如伪装的首次执行操作、利益失衡、单项弱点失去管理、专门技能缺陷等等");
		String r235 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r235).as("test data").contains("不适用");
		String r236 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r236).as("test data").contains("高风险情境警觉培训？");
		String r237 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r237).as("test data").contains("作业前意识系统的完善？");
		String r238 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r238).as("test data").contains("高风险情境警觉培训");
		String r239 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r239).as("test data").contains("3.21.3 未能识别和缓解人员相关的高风险情况，例如能力、态度、性格、与人打交道的经验存在不足");
		String r240 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r240).as("test data").contains("不适用");
		String r241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r241).as("test data").contains("高风险情境警觉培训？");
		String r242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r242).as("test data").contains("作业前意识系统的完善？");
		String r243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r243).as("test data").contains("高风险情境警觉培训");
		String r244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r244).as("test data").contains("3.21.4 未能识别和缓解环境相关的高风险情况，例如工作条件恶劣（温度、照明、噪音、高辐射水平等等）以及人机接口（标牌、显示屏、控制器等）");
		String r245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r245).as("test data").contains("不适用");
		String r246 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r246).as("test data").contains("高风险情境警觉培训？");
		String r2461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2461).as("test data").contains("作业前意识系统的完善？");
		String r247 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r247).as("test data").contains("高风险情境警觉培训");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("略过");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("略过");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("略过");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("略过");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("略过");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("略过");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("略过");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("略过");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("略过");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("略过");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		chineseTable7ReportTab(driver,softly);

		//SUEP title
		chineseSUEPFullFormReportTab(driver,softly);

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.1.1 能力不足");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.1.2 态度和任务不匹配");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.1.3 性格和任务不匹配");
		String r639 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r639).as("test data").contains("3.1.4 缺乏专业经验");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.1.5 对自我缺点认识不足，缺乏相应弥补措施");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.1.6 不适合工作（生病、有心事等）");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.12.1 觉得获取工具和设备有负担");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.12.2 觉得获取文件或程序有负担");
		String r644 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r644).as("test data").contains("3.12.3 觉得获取和穿戴PPE有负担");
		String r645 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r645).as("test data").contains("3.12.4 觉得使用过于复杂或繁琐的程序有负担");
		String r646 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r646).as("test data").contains("3.12.5 因觉得负担麻烦未到现场核实");
		String r647 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r647).as("test data").contains("3.13.1 尽早完成工作，以便尽早回家");
		String r648 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r648).as("test data").contains("3.13.2 尽早完成工作，以便获得奖励或免受惩罚");
		String r649 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r649).as("test data").contains("3.13.3 尽早完成工作，以便开始其他工作（尤其是根据完成的工作量计算价钱的承包商）");
		String r650 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r650).as("test data").contains("3.13.4 尽早完成工作，以便到更为舒适的环境中休息（尤其是在高温、有辐射或潮湿环境下工作）");
		String r651 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r651).as("test data").contains("3.14.1 观察主管向下属提供反馈的频率和质量");
		String r652 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r652).as("test data").contains("3.14.2 违反既定规定的情况不容易被知道（尤其是单独工作时）");
		String r653 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r653).as("test data").contains("3.14.3 由于缺乏明确的问责制，认为违规的后果不严重");
		String r654 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r654).as("test data").contains("3.14.4 违规造成的受伤风险被认为很低或没有");
		String r655 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r655).as("test data").contains("3.14.5 由于有监护人在场，预期风险更低");
		String r656 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r656).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r657 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r657).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r658 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r658).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r659 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r659).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r659).as("test data").contains("同事指导");
		String r660 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r660).as("test data").contains("3.21.1 未能识别和缓解时间相关的高风险情况，例如日常失误陷阱、工作时间、节假日影响等");
		String r661 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r661).as("test data").contains("3.21.2 未能识别和缓解活动相关的高风险情况，例如伪装的首次执行操作、利益失衡、单项弱点失去管理、专门技能缺陷等等");
		String r662 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r662).as("test data").contains("3.21.3 未能识别和缓解人员相关的高风险情况，例如能力、态度、性格、与人打交道的经验存在不足");
		String r663 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r663).as("test data").contains("3.21.4 未能识别和缓解环境相关的高风险情况，例如工作条件恶劣（温度、照明、噪音、高辐射水平等等）以及人机接口（标牌、显示屏、控制器等）");

		//HiRCA self checklist chinese, none selected
		chineseHiRCASelfChecklistTitleReportTab(driver,softly);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		chineseLastTableReportTab(driver,softly);
	}

	public void chineseReport6thPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 row
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("不适用");
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2a).as("test data").contains("不适用");
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3a).as("test data").contains("不适用");
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.6.1 要求有遗漏");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.6.2 运行条件有遗漏");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.6.3 假设有遗漏");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.6.4 范围有遗漏");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用\"不准做清单\"体现; (5) 参考资料; (6) 要求使用者反馈");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("开展程序设计编写培训, 改善程序编写导则");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("开展程序审查培训");
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r19).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r20).as("test data").contains("开展根本原因培训");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r21).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r22).as("test data").contains("改善纠正措施制度的监督与执行");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r23).as("test data").contains("3.7.1 进入和退出程序指引不到位");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r24).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r25).as("test data").contains("3.7.2 对于单项弱点步骤未设置自检或是独立检查");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r26).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r27).as("test data").contains("3.7.3 未识别出不可逆点(PNR)的操作步骤（予以审查），从而确保继续操作前先前的失误得到纠正");
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r28).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r29).as("test data").contains("3.7.4 未使用操作标记法来防止跳步或跳页");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r30).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r31).as("test data").contains("3.7.5 未分析并缓解很有可能出现违章的情况（通过迹象核实、复核、禁止操作警告等方式）");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r32).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r33).as("test data").contains("3.7.6 例行作业未有充分的及时提醒标牌预防粗心犯错");
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r34).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r35).as("test data").contains("3.7.7 未使用清单预防遗忘相关错误");
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r36).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r37).as("test data").contains("3.7.8 同事指导的好文化不到位，未能鼓励和强调守规行为标准");
		String r38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r38).as("test data").contains("培训如何做好同事指导守规文化, 改善有缺陷的程序");
		String r39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r39).as("test data").contains("3.7.9 审查不到位");
		String r40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r40).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r41).as("test data").contains("3.7.10 维修不到位: (1) 预见性维修不到位 (2) 预防性维修不到位 3) 纠正性维修不到位 (4) 修后试验不到位 (5) 故障查找和根本原因分析不到位 (6) 维修失误");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r42).as("test data").contains("纠正维修大纲中的缺陷");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r43).as("test data").contains("3.8.1 规则编写人经验不足，使用了模糊的或需自行判断的字词（例如，\"根据情况\"、\"根据需要\"、\"必要时\"等等）");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r44).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r45).as("test data").contains("3.8.2 使用了不可定量的或需自行判断的条件（例如，检查\"足够多的\"样品）来避免内部QA审查");
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r46).as("test data").contains("建立规则编写人规则编写标准或指导文件, 就屏障明确性，对管理人员实施问责");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r47).as("test data").contains("3.8.3 要求判断执行程序步骤");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[3]"))).getText();
		softly.assertThat(r48).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r49).as("test data").contains("3.8.4 没有明确与其他程序之间的接口");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r50).as("test data").contains("建立关于屏障接口设计的规则编写标准或指导文件");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r51).as("test data").contains("3.8.5 可读性不高（即：高于八年级阅读水平）");
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[3]"))).getText();
		softly.assertThat(r52).as("test data").contains("建立关于保护屏障接口设计的规则编写标准或指导文件");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r53).as("test data").contains("3.8.6 程序里和设备上出现不明确和不一致的设备标识与识别");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r54).as("test data").contains("改善设备标识和程序对设备的识别的明确性和一致性");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r55).as("test data").contains("3.8.7 时间敏感步骤未明确写出");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[3]"))).getText();
		softly.assertThat(r56).as("test data").contains("升版程序");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r57).as("test data").contains("3.8.8 程序未明确量化，使用描述如：稳定、异常");
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r58).as("test data").contains("升版程序");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r59).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度");
		softly.assertThat(r59).as("test data").contains("不到位");
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[3]"))).getText();
		softly.assertThat(r60).as("test data").contains("提高质疑的态度");
		softly.assertThat(r60).as("test data").contains(" 培训");
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r61).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r62).as("test data").contains("行为培训，避免过度自信");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r63).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[30]/td[3]"))).getText();
		softly.assertThat(r64).as("test data").contains("改善风险控制项目(");
		softly.assertThat(r64).as("test data").contains("), 完善PM&T体系");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r65).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r66).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[32]/td[3]"))).getText();
		softly.assertThat(r68).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");

		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("规则型错误");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r671 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r671).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r681 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r681).as("test data").contains("无意违规");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r69).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("程序不当");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//3.6 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.6 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.6.1 要求有遗漏");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r147).as("test data").contains("规范和标准？");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r75).as("test data").contains("规范和标准？");
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r76).as("test data").contains("与其他项目之间的接口要求？");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r148).as("test data").contains("完善规则");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r70).as("test data").contains("开展程序设计方面的培训");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.6.2 运行条件有遗漏");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r151).as("test data").contains("规则适用的运行条件范围？");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r72).as("test data").contains("进入规则的前提条件？");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r77).as("test data").contains("退出规则的条件？");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r152).as("test data").contains("完善规则");
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r78).as("test data").contains("开展程序设计方面的培训");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.6.3 假设有遗漏");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r155).as("test data").contains("假设未予以说明？");
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r79).as("test data").contains("未要求在任务完成前对假设进行验证？");
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r80).as("test data").contains("对未经验证的假设没有制定缓解措施？");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r156).as("test data").contains("完善规则");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r91).as("test data").contains("开展程序设计方面的培训");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.6.4 范围有遗漏");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("使用通用规则，缺少针对各种特殊情况的具体描述？");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r15).as("test data").contains("步骤遗漏？");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r81).as("test data").contains("遗漏了碰到异常情况时需采取的行动？");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r161).as("test data").contains("完善规则");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r16).as("test data").contains("开展程序设计方面的培训");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r164).as("test data").contains("遗漏了用于验收是否正确执行的相关试验或测量？");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r165).as("test data").contains("完善规则");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r18).as("test data").contains("开展程序设计方面的培训");
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用\"不准做清单\"体现; (5) 参考资料; (6) 要求使用者反馈");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("调查程序编写者");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r74).as("test data").contains("调查程序设计编写培训");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r170).as("test data").contains("开展程序设计编写培训");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r17).as("test data").contains("改善程序编写导则");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r173).as("test data").contains("调查程序审查者");
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r82).as("test data").contains("调查程序审查培训");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r176).as("test data").contains("开展程序审查培训");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r83).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r84).as("test data").contains("不适用");
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r85).as("test data").contains("调查事件调查者");
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r86).as("test data").contains("调查事件根本原因培训");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r87).as("test data").contains("开展根本原因培训");
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r88).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r89).as("test data").contains("不适用");
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r90).as("test data").contains("调查纠正措施主管");
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r92).as("test data").contains("调查纠正措施制度缺陷");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r93).as("test data").contains("改善纠正措施制度的监督与执行");
		//3.7
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r94).as("test data").contains("3.7.1 进入和退出程序指引不到位");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r95).as("test data").contains("不适用");
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r96).as("test data").contains("访谈规则编写人？");
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r97).as("test data").contains("审查规则编写指导文件？");
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r98).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r99).as("test data").contains("3.7.2 对于单项弱点步骤未设置自检或是独立检查");
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r100).as("test data").contains("不适用");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r101).as("test data").contains("访谈规则编写人？");
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r102).as("test data").contains("审查规则编写指导文件？");
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r103).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r104).as("test data").contains("3.7.3 未识别出不可逆点(PNR)的操作步骤（予以审查），从而确保继续操作前先前的失误得到纠正");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r105).as("test data").contains("不适用");
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r106).as("test data").contains("访谈规则编写人？");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r107).as("test data").contains("审查规则编写指导文件？");
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r108).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r109).as("test data").contains("3.7.4 未使用操作标记法来防止跳步或跳页");
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r110).as("test data").contains("不适用");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r111).as("test data").contains("访谈规则编写人？");
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r112).as("test data").contains("审查规则编写指导文件？");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r113).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r114).as("test data").contains("3.7.5 未分析并缓解很有可能出现违章的情况（通过迹象核实、复核、禁止操作警告等方式）");
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r115).as("test data").contains("不适用");
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r116).as("test data").contains("访谈规则编写人？");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r117).as("test data").contains("审查规则编写指导文件？");
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li"))).getText();
		softly.assertThat(r118).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r119).as("test data").contains("3.7.6 例行作业未有充分的及时提醒标牌预防粗心犯错");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r120).as("test data").contains("不适用");
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[15]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r121).as("test data").contains("访谈规则编写人？");
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[15]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r122).as("test data").contains("审查规则编写指导文件");
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r123).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r124).as("test data").contains("3.7.7 未使用清单预防遗忘相关错误");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r125).as("test data").contains("不适用");
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r126).as("test data").contains("访谈规则编写人？");
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r127).as("test data").contains("审查规则编写指导文件");
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[16]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r128).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r129).as("test data").contains("3.7.8 同事指导的好文化不到位，未能鼓励和强调守规行为标准");
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r130).as("test data").contains("不适用");
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[17]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r131).as("test data").contains("访谈犯错人");
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[17]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r132).as("test data").contains("访谈同事");
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[17]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r133).as("test data").contains("培训如何做好同事指导守规文化");
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[17]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r134).as("test data").contains("改善有缺陷的程序");
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r135).as("test data").contains("3.7.9 审查不到位");
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r136).as("test data").contains("不适用");
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[18]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r137).as("test data").contains("访谈审查者?");
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[18]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r138).as("test data").contains("调查审查标准?");
		String r180 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[18]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r180).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r181).as("test data").contains("3.7.10 维修不到位: (1) 预见性维修不到位 (2) 预防性维修不到位 3) 纠正性维修不到位 (4) 修后试验不到位 (5) 故障查找和根本原因分析不到位 (6) 维修失误");
		String r182 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r182).as("test data").contains("不适用");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[19]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r183).as("test data").contains("与类似组织就维修实践进行对标");
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[19]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r184).as("test data").contains("确定故障查找和根本原因分析报告的质量");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[19]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r185).as("test data").contains("调查重复失效背后的共同原因");
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[19]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r186).as("test data").contains("纠正维修大纲中的缺陷");	
		//3.8
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r187).as("test data").contains("3.8.1 规则编写人经验不足，使用了模糊的或需自行判断的字词（例如，\"根据情况\"、\"根据需要\"、\"必要时\"等等）");
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r188).as("test data").contains("不适用");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[20]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r189).as("test data").contains("访谈规则编写人？");
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[20]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r190).as("test data").contains("审查规则编写指导文件？");
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[20]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r191).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r192).as("test data").contains("3.8.2 使用了不可定量的或需自行判断的条件（例如，检查\"足够多的\"样品）来避免内部QA审查");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r193).as("test data").contains("不适用");
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[21]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r203).as("test data").contains("访谈规则编写人？");
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[21]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r204).as("test data").contains("审查规则编写指导文件？");
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[21]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r205).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[21]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r206).as("test data").contains("就屏障明确性，对管理人员实施问责");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r207).as("test data").contains("3.8.3 要求判断执行程序步骤");
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[22]/td[2]"))).getText();
		softly.assertThat(r208).as("test data").contains("不适用");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[22]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r209).as("test data").contains("访谈规则编写人？");
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[22]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r210).as("test data").contains("审查规则编写指导文件？");
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[22]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r211).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r212).as("test data").contains("3.8.4 没有明确与其他程序之间的接口");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[23]/td[2]"))).getText();
		softly.assertThat(r213).as("test data").contains("不适用");
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[23]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r214).as("test data").contains("访谈规则编写人？");
		String r215 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[23]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r215).as("test data").contains("审查规则编写指导文件？");
		String r216 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[23]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r216).as("test data").contains("建立关于屏障接口设计的规则编写标准或指导文件");
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r217).as("test data").contains("3.8.5 可读性不高（即：高于八年级阅读水平）");
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[24]/td[2]"))).getText();
		softly.assertThat(r218).as("test data").contains("不适用");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[24]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r219).as("test data").contains("访谈规则编写人？");
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[24]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r220).as("test data").contains("审查规则编写指导文件？");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[24]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r221).as("test data").contains("建立关于保护屏障接口设计的规则编写标准或指导文件");
		String r229 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r229).as("test data").contains("3.8.6 程序里和设备上出现不明确和不一致的设备标识与识别");
		String r230 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[25]/td[2]"))).getText();
		softly.assertThat(r230).as("test data").contains("不适用");
		String r231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[25]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r231).as("test data").contains("验证程序和设备的标识确保明确性和一致性");
		String r232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[25]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r232).as("test data").contains("改善设备标识和程序对设备的识别的明确性和一致性");
		String r233 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r233).as("test data").contains("3.8.7 时间敏感步骤未明确写出");
		String r234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[26]/td[2]"))).getText();
		softly.assertThat(r234).as("test data").contains("不适用");
		String r235 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[26]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r235).as("test data").contains("访谈编写者与审查者");
		String r236 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[26]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r236).as("test data").contains("升版程序");
		String r237 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r237).as("test data").contains("3.8.8 程序未明确量化，使用描述如：稳定、异常");
		String r238 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[27]/td[2]"))).getText();
		softly.assertThat(r238).as("test data").contains("不适用");
		String r239 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[27]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r239).as("test data").contains("访谈编写者与审查者");
		String r240 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[27]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r240).as("test data").contains("升版程序");
		//3.18
		String r241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r241).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度");
		softly.assertThat(r241).as("test data").contains("不到位");
		String r242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[28]/td[2]"))).getText();
		softly.assertThat(r242).as("test data").contains("不适用");
		String r243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[28]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r243).as("test data").contains("审查培训材料？");
		String r244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[28]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r244).as("test data").contains("审查以往类似事件？");
		String r245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[28]/td[4]/ul/li"))).getText();
		softly.assertThat(r245).as("test data").contains("提高质疑的态度");
		softly.assertThat(r245).as("test data").contains(" 培训");
		String r246 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r246).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r247 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[29]/td[2]"))).getText();
		softly.assertThat(r247).as("test data").contains("不适用");
		String r248 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[29]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r248).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String r249 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[29]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r249).as("test data").contains("过去有过超出能力工作的事件?");
		String r250 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[29]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r250).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		String r251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[29]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r251).as("test data").contains("行为培训，避免过度自信");
		String r252 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r252).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r253 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[30]/td[2]"))).getText();
		softly.assertThat(r253).as("test data").contains("不适用");
		String r254 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[30]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r254).as("test data").contains("因忽略相关风险而未设置屏障");
		String r255 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[30]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r255).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r256 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[30]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r256).as("test data").contains("改善风险控制项目(");
		String r257 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[30]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r257).as("test data").contains("完善PM&T体系");
		String r258 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r258).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r259 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[31]/td[2]"))).getText();
		softly.assertThat(r259).as("test data").contains("不适用");
		String r260 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[31]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r260).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[31]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r261).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String r262 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r262).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r263 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[32]/td[2]"))).getText();
		softly.assertThat(r263).as("test data").contains("不适用");
		String r264 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[32]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r264).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r265 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[32]/td[4]/ul/li"))).getText();
		softly.assertThat(r265).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("略过");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("略过");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("略过");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("略过");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("略过");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");		
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("略过");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("略过");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("略过");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("略过");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("略过");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("略过");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("略过");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("略过");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("略过");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("略过");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("略过");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		chineseTable7ReportTab(driver,softly);

		//SUEP title
		chineseSUEPFullFormReportTab(driver,softly);

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.6.1 要求有遗漏");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.6.2 运行条件有遗漏");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.6.3 假设有遗漏");
		String r639 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r639).as("test data").contains("3.6.4 范围有遗漏");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用\"不准做清单\"体现; (5) 参考资料; (6) 要求使用者反馈");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r644 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r644).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r645 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r645).as("test data").contains("3.7.1 进入和退出程序指引不到位");
		String r646 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r646).as("test data").contains("3.7.2 对于单项弱点步骤未设置自检或是独立检查");
		String r647 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r647).as("test data").contains("3.7.3 未识别出不可逆点(PNR)的操作步骤（予以审查），从而确保继续操作前先前的失误得到纠正");
		String r648 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r648).as("test data").contains("3.7.4 未使用操作标记法来防止跳步或跳页");
		String r649 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r649).as("test data").contains("3.7.5 未分析并缓解很有可能出现违章的情况（通过迹象核实、复核、禁止操作警告等方式）");
		String r650 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r650).as("test data").contains("3.7.6 例行作业未有充分的及时提醒标牌预防粗心犯错");
		String r651 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r651).as("test data").contains("3.7.7 未使用清单预防遗忘相关错误");
		String r652 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r652).as("test data").contains("3.7.8 同事指导的好文化不到位，未能鼓励和强调守规行为标准");
		String r653 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r653).as("test data").contains("3.7.9 审查不到位");
		String r654 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r654).as("test data").contains("3.7.10 维修不到位: (1) 预见性维修不到位 (2) 预防性维修不到位 3) 纠正性维修不到位 (4) 修后试验不到位 (5) 故障查找和根本原因分析不到位 (6) 维修失误");
		String r655 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r655).as("test data").contains("3.8.1 规则编写人经验不足，使用了模糊的或需自行判断的字词（例如，\"根据情况\"、\"根据需要\"、\"必要时\"等等）");
		String r656 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r656).as("test data").contains("3.8.2 使用了不可定量的或需自行判断的条件（例如，检查\"足够多的\"样品）来避免内部QA审查");
		String r657 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r657).as("test data").contains("3.8.3 要求判断执行程序步骤");
		String r658 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r658).as("test data").contains("3.8.4 没有明确与其他程序之间的接口");
		String r659 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r659).as("test data").contains("3.8.5 可读性不高（即：高于八年级阅读水平）");
		String r660 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r660).as("test data").contains("3.8.6 程序里和设备上出现不明确和不一致的设备标识与识别");
		String r661 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r661).as("test data").contains("3.8.7 时间敏感步骤未明确写出");
		String r662 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r662).as("test data").contains("3.8.8 程序未明确量化，使用描述如：稳定、异常");
		String r663 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r663).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度");
		softly.assertThat(r663).as("test data").contains("不到位");
		String r664 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r664).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r665 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r665).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r666 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r666).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r667 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r667).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");

		//HiRCA self checklist chinese, none selected
		chineseHiRCASelfChecklistTitleReportTab(driver,softly);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		chineseLastTableReportTab(driver,softly);
	}

	public void chineseReport5thPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 row
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("不适用");
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2a).as("test data").contains("不适用");
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3a).as("test data").contains("不适用");
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("休息时间管理,");
		softly.assertThat(r2).as("test data").contains("行为培训 (");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("行为培训");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业,");
		softly.assertThat(r6).as("test data").contains("行为培训");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("行为培训, 改善排程和计划系统");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("中间适当休息, 最大程度减少干扰");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("学习正确所需技能");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("培训技能的选择, 透过强化规定减少选择错误的机会");

		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("规则型错误");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r68).as("test data").contains("无意违规");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r69).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("粗心犯错");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//3.16 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.16 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r147).as("test data").contains("查阅以往事件？");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r148).as("test data").contains("休息时间管理");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r70).as("test data").contains("行为培训 (");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r151).as("test data").contains("访谈犯错者？");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r72).as("test data").contains("访谈同事？");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r152).as("test data").contains("行为培训");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r155).as("test data").contains("访谈犯错者？");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r156).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r91).as("test data").contains("行为培训");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("现场观察？");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r15).as("test data").contains("访谈同事？");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r161).as("test data").contains("行为培训");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r16).as("test data").contains("改善排程和计划系统");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r164).as("test data").contains("现场观察？");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r17).as("test data").contains("访谈同事？");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r165).as("test data").contains("中间适当休息");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r18).as("test data").contains("最大程度减少干扰");
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("审查技能相关规定");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li"))).getText();
		softly.assertThat(r170).as("test data").contains("学习正确所需技能");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r173).as("test data").contains("访谈犯错人");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r176).as("test data").contains("培训技能的选择");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r74).as("test data").contains("透过强化规定减少选择错误的机会");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("略过");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("略过");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("略过");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("略过");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("略过");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");		
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("略过");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("略过");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("略过");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("略过");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("略过");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("略过");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("略过");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("略过");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("略过");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("略过");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("略过");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		chineseTable7ReportTab(driver,softly);

		//SUEP title
		chineseSUEPFullFormReportTab(driver,softly);

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");

		//HiRCA self checklist chinese, none selected
		chineseHiRCASelfChecklistTitleReportTab(driver,softly);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		chineseLastTableReportTab(driver,softly);
	}

	public void chineseHiRCASelfChecklistTitleReportTab (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//HiRCA self checklist chinese, none selected
		//Title
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[9]"))).getText();
		softly.assertThat(title2).as("test data").contains("自检清单");
		//Heading
		String heading50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading50).as("test data").contains("类别");
		String heading51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading51).as("test data").contains("调查内容");
		String heading52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading52).as("test data").contains("完成打勾?");
	}

	public void chineseLastTableReportTab (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//last table with reviewed by etc rows
		//title
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[11]"))).getText();
		softly.assertThat(title3).as("test data").contains("签字");
		//Rows
		String r703 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r703).as("test data").contains("编写");
		String r704 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r704).as("test data").contains("日期");
		String r705 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r705).as("test data").contains("审查");
		String r706 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r706).as("test data").contains("日期");
		String r707 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r707).as("test data").contains("批准");
		String r708 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[12]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r708).as("test data").contains("日期");
	}

	public void chineseSUEPFullFormReportTab (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//SUEP titles
		String r631 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[1]"))).getText();
		softly.assertThat(r631).as("test data").contains("根本原因确认分析（SUEP）");
		String r632 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[2]"))).getText();
		softly.assertThat(r632).as("test data").contains(": 是否存在不合标准的实践?");
		String r633 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[3]"))).getText();
		softly.assertThat(r633).as("test data").contains(": 是否在管理层控制下?");
		String r634 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[4]"))).getText();
		softly.assertThat(r634).as("test data").contains(": 是否在事件时序早期?");
		String r635 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[5]"))).getText();
		softly.assertThat(r635).as("test data").contains(": 是否防止再次发生?");
		//SUEP table heading
		String heading49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading49).as("test data").contains("促成因素");
	}

	public void chineseTable7ReportTab (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table 7 title
		String r621 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/div"))).getText();
		softly.assertThat(r621).as("test data").contains("失效屏障分析过程");

		//Table 7 headings
		String heading461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading461).as("test data").contains("调查问题");
		String heading47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading47).as("test data").contains("答案");
		String heading48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading48).as("test data").contains("选择原因");
		//Table 7 rows
		String r622 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r622).as("test data").contains("屏障是否存在能预防始发事件的发生？");
		String r623 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r623).as("test data").contains("否");
		String r624 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r624).as("test data").contains("不适用");
		String r625 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r625).as("test data").contains("2.21 哪些屏障可以预防此事件？");
		String r626 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r626).as("test data").contains("不适用");
		String r627 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r627).as("test data").contains("不适用");
		String r628 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r628).as("test data").contains("是否完善引导你进行人因事件分析？");
		String r629 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r629).as("test data").contains("不适用");
		String r630 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r630).as("test data").contains("不适用");		
	}

}
