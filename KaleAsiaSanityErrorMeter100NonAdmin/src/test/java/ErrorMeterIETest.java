import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoAlertPresentException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import java.util.Base64;

public class ErrorMeterIETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	private int login =0;
	private String title = "Sanity Test";
	SoftAssertions softly = new SoftAssertions();
	private String text32="Curabitur lacinia odio sit amet tellus vestibulum condimentum. The resting sundry overcomes above the focus. Inside a bond catalog suspects the pink cycle. The stopping midnight flips the fundamentalist countryside. The drama discards the monarch galaxy.";
	private String text31="Vestibulum eget lectus ut ligula tempus ultrices ac rhoncus libero. When can the incentive breakfast strike? Every arithmetic walks! The capitalist shies away without the grief! Should the normal standpoint overflow without the planet? The wretched earth reverts. The insufficient banner distances the simplified firework.";
	private String text30="Integer ac enim eget nisl malesuada tempor nec eu turpis. Our coordinate yard sauces the machine beneath an esoteric temple. The teapot sweeps beside the nostalgia. The forgotten python hopes. The bush league bushes the fellow. Can a citizen edit a stimulating composite? The fame trails without another load. A wisest rhythm misguides a modern thick. Above its communist nests the accountant. Your counterpart talks over the rubber ham. A tree pants beside a net gas.";
	private String text29="Donec in massa pulvinar, mattis turpis ut, aliquam ligula. The countryside plays with the fashionable documentary underneath the trifle. The museum cycles a doctor over the hack postscript. A wallet listens on top of the attempt! The fit praise dictates beneath the longest comparison. A genius ducks past an excess. The distress advances with the distress! When can the overlap multiply a break? Should the routine steel skip against a clone? The equipped anarchy budgets an imbalance. The amateur relaxes after the verse! The batch flies behind a pigeon. How can our poison curtain an otherwise child? The reflecting discovery allies the designate wealth. A separator kids past the speaker. The arc overtone rots.";
	private String text28="Morbi dictum mi et nisl interdum, vel iaculis lacus suscipit. The stroke pushes the coach beneath any wood outcome. The photocopy prevails below the feat volunteer. The counsel decays beneath the burned disorder. The flute butters a postage after a misrepresented schedule. How can the dreamed baby walk? The speaking misfortune bites an override. A politician rattles against the emerging purple. A sod dries the crush into the packed burden. The warmed eye notices the alphabetical grammar. The smashing scenery chambers the sounding dominant. Why does a rattled height exit? A subsidized physicist rocks an enthusiastic keeper.The outcome noses against the departure. Why won't a temper dish an appalled visit? With a safeguard responds the biggest junk. When will the noisy stress grind against the idiosyncratic blame? How does a desire mend throughout any ripped tooth?";
	private String text27="Ut eu quam non orci consectetur vestibulum et scelerisque sapien. The debt destroys every refined boy behind an ethic. Whatever compound sweeps into the concealed noun. The tomato posts a helmet. The gate flowers throughout a satire. The united plague restores this sympathetic likelihood. A simulate commentator perceives a laughter against the tame metaphor. The flood composes in the startled fuse. Can a taxpayer lecture her container? The circular chooses past her typewriter.";
	private String text26="Morbi accumsan leo non ex tempor, congue ullamcorper urna viverra. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.";
	private String text25="In quis enim a odio venenatis scelerisque dignissim sed mauris. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
	private String text24="Maecenas ultrices nulla nec malesuada ullamcorper.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
	private String text23="Mauris mattis nisi quis rhoncus mollis. In addition to generating an entire comedy routine, the software provides additional means to make existing content funnier. One of those ways is through the Article Part menu that can insert a short, funny paragraph into an existing routine or article. Also available is the One-Liner Jokes option on the right-click menu, which presents a list of relevant one-liners in the Phrase Box for later use.First Draft 5.0 costs $149.99 and can be purchased online from http://www.justoutsourcing.com/.";
	private String text22="In auctor lorem quis eros fermentum ultricies a at nibh. The tray boils under a deprived alcoholic. How can a beaten populace fork the climbing developer? The rounded imbalance expenses the spy. Your inexperienced scene showers the mystic. The scrap determines a blanket behind the wanted whole. Why does the horrified rat bell a talented swallow? The dragging alphabet noses. Next to the sophisticate tries the fascist cell. A tale catalogs the adventure. A parallel force exercises opposite an exponential soldier. The motto sleeps inside the road. A uninteresting helmet dictates near the glass. The unhappy dealer hopes. A pregnant mailbox grabs the garden next to a precious classic. The creature demands the blob.";
	private String text21="Curabitur quis mauris ullamcorper, ultricies orci non, porttitor diam. A chord degenerates into the based fairy. This wretched sin gasps outside the analogy. Each prerequisite waters a conscience. The superfluous hospital surnames every meal. The clique rails behind a gas! Should the highlight proclaim the restaurant? An indent flips! The gospel dresses the penny author. On top of a debate waves an incomplete stake. A screaming rainbow authorizes the farmer over a sweeping devil. The follower cruises on top of the landlord! Should the policeman frown above the guest stereotype? The biochemistry modifies a numeric tube. The unset stair ditches the prominent editorial. A prototype crawls. The alert finances the charged comfort. The guaranteed terrorist senses the hell throughout the owed attitude. The static responds opposite every sunrise. A scroll entitles our scenery beside a lifted decay. The plant wishes a barrier with the adult bomb. The ink pats the egg across your offending volume. The defect gifts the devoid vein.";
	private String text20="Fusce aliquet libero vel risus luctus ullamcorper.";
	private String text19="Vestibulum non risus sit amet lorem blandit tempus.";
	private String text18="Fusce gravida libero a neque cursus gravida.";
	private String text17="Proin eget urna tempor, ullamcorper lectus eget, elementum massa. The assumed plotter rushs toward the anatomy. Beneath the physiology despairs the table. A waiting musician leaks above the pole. The chicken patient gins the frustrated container. The ready craft farms the impractical reactionary. Can my flood host the operator? Each charge bumps against the march. The analogy enters?The static mutters? The rabbit conveys the bastard after a correct resemblance. The blade prefers the compelled straw. The specified postscript tries beside the fancy mount. Underneath the reform reigns an organic supernatural. An official buttons the theater. The pleasant toe misses the alternative. The smallish tongue charges the barrister in a confused artist. When will a frowning electron outweigh the dress company? The cheese results with a coke. Why won't the attending throat imprison the paranoid sea? Beneath the lust foams each ecology. How does the commissioned contempt protect the mate?";
	private String text16="Quisque at justo elementum, finibus elit ut, ultrices nibh.";
	private String text15="Pellentesque nec nulla vel neque tincidunt rutrum.";
	private String text14="Donec dictum enim nec mi pulvinar, nec consequat eros tristique. A sky deletes a curtain over the bearded parameter. A handicap escapes near the constant! The vicar dances a threshold opposite a rough limb. The architecture outcries the pat jack after the reflex. An article cruises in the wartime. How will the detailed barrel die without the bench? The heat attends behind the imperative! The steel sleeps over the shame! The smelly exponential hopes a huge anatomy. Against the jack participates a motor. The corporate tour chars an illustrated theology. The confining knowledge ices the desirable bubble. Why can't an invitation volume tailor the irate bandwagon? The brother closet pipes the indent. The fined group trails around a homosexual.";
	private String text13="Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.";
	private String text12="In non leo et nibh porttitor lobortis. A pan disturbs the barrister. Its password invalidates the gospel. A silver bath rests. When will the tempting fossil escape a shade? The unsafe collective lands a populace. When will our digital threshold moan? The ice grabs this carpet. The network functions as the pro prose. The independence pressures his appointed country. How can the biting trouble hunt? Why can't an asset rail? A number meets the colleague throughout an adventurous biography. The invitation mountain solos throughout a syndicate. The orienting analogue publicizes the implied finger. The parochial alcoholic warms to another sugar. Against each worn hero towers your unsuccessful holy. A wonderful numeral caves the child. A gateway catalogs the comic throughout the akin cycle. The terror fringes an injury. When can the photo scratch the logo? My track tasks the paste. A prisoner colors. The tone elects the monochrome suspicion. The herd jams without the absent developer. Her banana enhances the competing talent next to the warm. An alcoholic pumps outside the artist! The justified poison strays next to the inhibiting ruler. A divine fools the experienced address above the singer. The shutdown swims throughout the bankrupt. The tried poison excites the ace. The pedestrian persists throughout a packed warm. Should the elephant's wealth appear throughout a tactic? Under every storm degenerates the perpetual bankrupt.";
	private String text11="Donec hendrerit lacus semper justo bibendum fermentum. The lousy lung stirs across the pedestrian homosexual. A vocal distresses the tile. How does an ineffective disease refresh the imperial rage? The complicate potato edges the derived nostalgia.";
	private String text10="Sed tempus nunc interdum neque sodales, at mollis magna convallis.";
	private String text9="Aliquam efficitur sem quis facilisis aliquam. Why won't the horizon progress above a crash friendship? How will the fine muck break outside the boy? The page enters the graffito. The coal shortens the bump into a demolished article. A chemical thinks opposite a vegetable! How does a pace withdraw? The pill leaks across the secretary. Whatever ward twins every passionate weapon. An orientated moderate bringings a strict wine. Why won't the toy solo? Your diagonal mistake strains against a diagonal. Can the pan tutorial coast? The delicate physics degenerates against the platform. How does the lane studio document the unchanged hierarchy? When can an illiterate violin supervise a blind resource? The grouped gun walks against our screen. The executive juice scratches outside every wed bean. Why does a some guard prepare a stamped hash? The salesman faints over the rending uncle. A perfect thumb turns an average. The holder aids the spectacular throughout my cancelled weekday. Below the manual sigh stares the plastered deed. Why can't the numerous workshop thirst? The removed norm loves a charter. Why won't the proof file an opera? An overwhelmed limb doses a tailor. How does the foreigner puzzle inside the deciding coal? Will the cozy coach thirst throughout a principal? Next to the darling tooth sleeps the neighbor highway. When can the comparable prince flower? Should a decimal racket change against the cuckoo? The privileged earth punts near the buyer. An appeal holds a stare. The starved burst serves as the scotch. How does the creative blackmail rule near the altogether? Why does his praise revert? The beginner determines the mumble.";
	private String text8="Proin blandit ante at molestie finibus.";
	private String text7="Etiam quis lorem laoreet, malesuada lorem in, tristique sem.";
	private String text6="Maecenas vitae orci non dui ultrices posuere vulputate at elit. Why can't a south toe the line? A borderline beams beside the scheme. Can the duplicate rebuild the coincidence? The tooth destroys a raw powder into the tribe. How will the uncommon article stretch after the theology? The tolerant blessed slashes an ass.";
	private String text5="Mauris blandit elit sit amet tellus dignissim, eget maximus sem dignissim.";
	private String text4="Morbi in dui semper, sagittis augue in, elementum lorem.";
	private String text3 ="Vivamus ut lacus finibus, dictum neque interdum, tincidunt eros. Why does the axiom aim a cathedral purpose? An archive opens my orbital below the dangerous misprint. The sixty filter prices her metric lesbian. A world appears in the enemy listener. When will a mailed system interrupt the attendant? The milk detail frightens the improving warehouse.";
	private String text2="Duis vestibulum ipsum at dui tincidunt, semper eleifend est congue.";
	private String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(1100000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on SPV Error Meter in Internet Explorer non admin");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }
	
	public String decode(String pw){
		
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
	}

	public void Login() throws Exception{
		  
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  driver.findElement(By.id("pii-login-button")).click();
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(decode(password))==true)
			  {
				  //Sign in button is located and clicked
				  driver.findElement(By.id("pii-signin-button")).click();  
				  while(c>0)
				  {
				  Thread.sleep(2000);
				  WebElement element = driver.findElement(By.id("pii-signin-message"));
				  String text = element.getText();
				  if (element.isDisplayed())
				  {
					  if(text.isEmpty())
					  {
						  System.out.println("Logged in");
						  break;
						  }
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(decode(password))==false))
		    {
				  while(c>0)
				  {
					  Thread.sleep(1000);
					  driver.findElement(By.id("pii-un")).clear();
					  driver.findElement(By.id("pii-pw")).clear();
					  //Username text field is located and the username is entered
					  driver.findElement(By.id("pii-un")).sendKeys(username);
					  //Password field is located and the password is entered
					  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
					  if (user.equals(username)==true)
					  {
						  if(pw.equals(decode(password))==true)
						  {
							  //Sign in button is located and clicked
							  driver.findElement(By.id("pii-signin-button")).click();
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
			  
		}
	
	public void deleteNewRecord(String recordName) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		  //Verify record deleted
		  //Click on 1st record
		  Thread.sleep(2000);
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  
		  			  
	  }

	   public void downloadRecord() throws Exception {
	    	
	    	//deletes files in reports folder before starting to download
	        File file = new File("C://Users//IEUser//Downloads//reports//");
	        deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
	    	reportCheck();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			
			String window = driver.getWindowHandle();
			//Clicks on save pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(4000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }
	    	Thread.sleep(12000);
	    	List<String> results = new ArrayList<String>();
		    	File[] files = new File("C://Users//IEUser//Downloads//reports//").listFiles();
		    	//If this pathname does not denote a directory, then listFiles() returns null. 
		    	for (File file1 : files) {
		    	    if (file1.isFile()) {
		    	        results.add(file.getName());
		    	    }
		    	}
		    	System.out.println(results.get(0));
		    	if(results.get(0).endsWith(".pdf")==false)
		    	{
		    		deleteFiles(file);
		    		//Clicks on download button
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
					try{
						  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
						  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
						 }catch (org.openqa.selenium.TimeoutException e)
						  {
							  
						  }
					//Clicks on save pdf report
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			    	Thread.sleep(4000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }
			    	Thread.sleep(12000);
		    	}
	    	//pdf verification
	    	pdfCheck();
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    		    	
	    }

	    public void pdfCheck() throws Exception{
	    	
	    	 List<String> results = new ArrayList<String>();
	    	//Gets the file name which has been downloaded
	    	File[] files = new File("C://Users//IEUser//Downloads//reports//").listFiles();
	    	//If this pathname does not denote a directory, then listFiles() returns null. 
	    	for (File file : files) {
	    	    if (file.isFile()) {
	    	        results.add(file.getName());
	    	    }
	    	}
	    	System.out.println(results.get(0));
	    	//Loads the file to check if correct data is present
	    	String fileName="C://Users//IEUser//Downloads//reports//"+results.get(0);
	    	File file = new File(fileName);
	    	FileInputStream fis = new FileInputStream(file);
	    	PDFParser parser = new PDFParser(fis);
	        parser.parse();
	        COSDocument cosDoc= parser.getDocument();       
	        PDDocument pddoc= new PDDocument(cosDoc);
	        PDFTextStripper pdfStripper= new PDFTextStripper();
	        pdfStripper.setStartPage( 1 );
	        pdfStripper.setEndPage( Integer.MAX_VALUE );
	        String data = pdfStripper.getText(pddoc);
	        List<String> ans= Arrays.asList(data.split("\r\n"));
	        String newData1="";
	        for (int i = 0; i < ans.size(); i++)
	        {
	        	
	        	//System.out.println(ans.get(i));
	        	int n=ans.get(i).length()-1;
	        	if (ans.get(i).charAt(n)==' ')
	        		newData1 = newData1+ans.get(i);
	        	if (ans.get(i).charAt(n)!=' ')
	        		newData1 = newData1+" "+ans.get(i);
	        	
	        }
	        newData1=newData1.replace("  ", " ");
	        System.out.println(newData1);
	        //Verifies 100.00%
	        softly.assertThat("100.00%").as("test data").isSubstringOf(newData1);
	        //Verifies risk level as Low
	        softly.assertThat("risk level: high").as("test data").isSubstringOf(newData1);
	        //Verify SPV
	        softly.assertThat("SPV").as("test data").isSubstringOf(newData1);
	        //Verify all data entered
	        softly.assertThat(text1).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text2).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text3).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text4).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text5).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text6).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text7).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text8).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text9).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text10).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text11).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text12).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text13).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text14).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text15).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text16).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text17).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text18).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text19).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text20).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text21).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text22).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text23).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text24).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text25).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text26).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text27).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text28).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text29).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text30).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text31).as("test data").isSubstringOf(newData1);
	        softly.assertThat(text32).as("test data").isSubstringOf(newData1);
	        cosDoc.close();
	        pddoc.close();
	   }
	   
	   public void deleteFiles(File folder) throws IOException {
	        File[] files = folder.listFiles();
	         for(File file: files){
	                if(file.isFile()){
	                    String fileName = file.getName();
	                    boolean del= file.delete();
	                    System.out.println(fileName + " : got deleted ? " + del);
	                }else if(file.isDirectory()) {
	                    deleteFiles(file);
	                }
	            }
	        }
	    
	    public void shareReport() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("qaacfiverifier");
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo("qaacfiverifier");
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
			//Waits for black loading message to disappear
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }	
			 //Checks the username of creator and shared with
			 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td")));
			 String creatorUsername= creator.getText();
			 System.out.println(creatorUsername);
			 softly.assertThat(username).as("test data").isSubstringOf(creatorUsername);
			 WebElement sharedTo=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/span")));
			 String sharedToUsername = sharedTo.getText();
			 System.out.println(sharedToUsername);
			 softly.assertThat("qaacfiverifier").as("test data").isEqualTo(sharedToUsername);
			 WebElement shared=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/strong")));
			 String sharedText = shared.getText();
			 System.out.println(sharedText);
			 softly.assertThat("Shared with:").as("test data").isEqualTo(sharedText);
			 WebElement probability=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/strong")));
			 String probabilityText = probability.getText();
			 System.out.println(probabilityText);
			 softly.assertThat("100.00%").as("test data").isEqualTo(probabilityText);
	    }
	    
	    public void markCritical() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }
	    public void pape() throws Exception{
			
			WebDriverWait wait1 = new WebDriverWait(driver,60);
			int i;
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Check if enter data and edit data buttons are not visible for non admin user
			WebElement create=driver.findElement(By.id("pii-epm-admin-create"));
			if (create.isDisplayed()==true)
				softly.fail("Enter data button displayed");
			else
				System.out.println("Enter data button not displayed for non admin user");
			WebElement edit=driver.findElement(By.id("pii-epm-admin-edit"));
			if (edit.isDisplayed()==true)
				softly.fail("Edit data button displayed");
			else
				System.out.println("Edit data button not displayed for non admin user");
			//Click on Environment of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-e"))).click();
			//Clicks on checkboxes in Environment Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q3"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text1);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text1);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text2);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text2);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text3);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text3);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text4);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text4);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text5);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text5);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text6);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text6);

			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text7);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text7);		
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text8);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text8);

			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			//Checks error meter as 0%
			WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			String meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("25%").as("test data").isEqualTo(meterText);



			//Click on People of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-p"))).click();
			//Clicks on checkboxes in People Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q1"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("31%").as("test data").isEqualTo(meterText);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("38%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("44%").as("test data").isEqualTo(meterText);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q4"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("50%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text9);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text9);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text10);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text10);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text11);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text11);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text12);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text12);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text13);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text13);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text14);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text14);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text15);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text15);
						
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text16);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text16);
			


			//Click on Activity of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-a"))).click();
			//Clicks on checkboxes in Activity Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q1"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("56%").as("test data").isEqualTo(meterText);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("63%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q3"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("69%").as("test data").isEqualTo(meterText);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("75%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text17);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text17);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text18);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text18);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text19);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text19);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text20);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text20);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text21);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text21);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text22);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text22);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text23);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text23);

			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text24);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text24);



			//Clicks on Procedure Tab
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-t"))).click();
			//Clicks on checkboxes in Procedure Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("81%").as("test data").isEqualTo(meterText);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q2"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("88%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("94%").as("test data").isEqualTo(meterText);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q4"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("100%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text25);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text25);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text26);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text26);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text27);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text27);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text28);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text28);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text29);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text29);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text30);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text30);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text31);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text31);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text32);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text32);
		}
	    
	    public void reportCheck() throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,30);
	    	//Compare Environment data
	    	//Supporting reasons
	    	String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text1E).as("test data").isEqualTo(text1);
	    	String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text2E).as("test data").isEqualTo(text2);
	    	String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text3E).as("test data").isEqualTo(text3);
	    	String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text4E).as("test data").isEqualTo(text4);
	    	//Corrective actions
	    	String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text5E).as("test data").isEqualTo(text5);
	    	String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text6E).as("test data").isEqualTo(text6);
	    	String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text7E).as("test data").isEqualTo(text7);
	    	String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text8E).as("test data").isEqualTo(text8);
	    	
	    	//Compare People data
	    	//Supporting reasons
	    	String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text9E).as("test data").isEqualTo(text9);
	    	String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text10E).as("test data").isEqualTo(text10);
	    	String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text11E).as("test data").isEqualTo(text11);
	    	String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text12E).as("test data").isEqualTo(text12);
	    	//Corrective actions
	    	String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text13E).as("test data").isEqualTo(text13);
	    	String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text14E).as("test data").isEqualTo(text14);
	    	String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text15E).as("test data").isEqualTo(text15);
	    	String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text16E).as("test data").isEqualTo(text16);
	    	
	    	//Compare Activity data
	    	//Supporting reasons
	    	String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text17E).as("test data").isEqualTo(text17);
	    	String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text18E).as("test data").isEqualTo(text18);
	    	String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text19E).as("test data").isEqualTo(text19);
	    	String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text20E).as("test data").isEqualTo(text20);
	    	//Corrective actions
	    	String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text21E).as("test data").isEqualTo(text21);
	    	String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text22E).as("test data").isEqualTo(text22);
	    	String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text23E).as("test data").isEqualTo(text23);
	    	String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text24E).as("test data").isEqualTo(text24);
	    	
	    	//Compare Procedure data
	    	//Supporting reasons
	    	String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text25E).as("test data").isEqualTo(text25);
	    	String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text26E).as("test data").isEqualTo(text26);
	    	String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text27E).as("test data").isEqualTo(text27);
	    	String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text28E).as("test data").isEqualTo(text28);
	    	//Corrective actions
	    	String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text29E).as("test data").isEqualTo(text29);
	    	String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text30E).as("test data").isEqualTo(text30);
	    	String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text31E).as("test data").isEqualTo(text31);
	    	String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text32E).as("test data").isEqualTo(text32);
	    }

	  @Test
	  public void SanityTest() throws Exception{
		  try{ 
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(2000);
	      //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  
		  Thread.sleep(5000);
		  if (login==1)
          {
                
                while(true)
    		  {
               	 Thread.sleep(1000);
    			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
    			  {
    				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
    				  ele.findElement(By.className("sticky-close")).click();
    				  break;
    			  }
    			  else break;
    		  }
          }	
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Analysis 
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  
		//Clicks on SPV Error meter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		  Thread.sleep(4000);
		  //Select Purpose from dropdown
		  WebElement element = driver.findElement(By.id("pii-epm-select-purpose"));
		  Select s = new Select (element);
		  s.selectByVisibleText("PJB");
		  Thread.sleep(3000);
		  //Select Job type
		  element = driver.findElement(By.id("pii-epm-select-condition"));
		  Select s1 = new Select (element);
		  s1.selectByVisibleText("Construction");
		  Thread.sleep(3000);
		  //Fills Job title
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  String ev1= driver.findElement(By.id("pii-epm-job-title")).getAttribute("value");
		  if(ev1.equals(title)==false)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  Thread.sleep(3000);
		  //Click on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))).click();
		  Thread.sleep(3000);
		  pape();
		  Thread.sleep(2000);
		  JavascriptExecutor jse= (JavascriptExecutor)driver; 
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Click on finalize
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-done"))).click();
		  Thread.sleep(3000);
		  //Click on finalize and save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-confirmed"))).click(); 
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Creates expected record name
		  String date= driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td[2]")).getText();
		  date = date.substring(14);
		  String time = driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td[2]")).getText();
		  time = time.substring(14);
		  String time2 = time.substring(0, 8);
		  String time1=time.substring(9);
		  String purpose = driver.findElement(By.xpath(".//*[@id='epm-rpt']/div/div/span/abbr")).getText();
		  String name = date + "_" + time2+"_"+time1 + "_" + username +"_" + purpose + "_" + title;
		  System.out.println ("Expected name of record: " +name);
		  //Clicks on side panel
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  	
		  //Checks if the record name is correct
		  assertEquals(name,recordName);
		  Thread.sleep(2000);
		  //Downloads record
		  downloadRecord();
		  Thread.sleep(2000);
		  //Shares report
		  shareReport();
		  Thread.sleep(2000);
		  //Mark critical
		  markCritical();
		  Thread.sleep(2000);
		  //Deletes the record
		  deleteNewRecord(recordName);
		  Thread.sleep(2000);
		  
		   //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		   }catch(TimeoutException e)
		   {
			   System.out.println(e);
			  /* driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
			   driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
			   
			   driver.quit();
		   }
		 
		  
	}
	
	
	public void afterTest(){
		
		/*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		//Browser closes
		driver.quit();
		softly.assertAll();
	}
}
