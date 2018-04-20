import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorMeter {

	SoftAssertions softly = new SoftAssertions();
	
	public String error0Data()throws Exception{
		
		return ("Morbi ut massa elementum, faucibus lorem vitae, imperdiet lectus. Sed pellentesque mauris sit metus.");
	}
	
	public List<String> error50Data()throws Exception {
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
    

	public List<String> error100Data() throws Exception{
		List<String> text = new ArrayList<String>();
		text.add("Curabitur lacinia odio sit amet tellus vestibulum condimentum. The resting sundry overcomes above the focus. Inside a bond catalog suspects the pink cycle. The stopping midnight flips the fundamentalist countryside. The drama discards the monarch galaxy.");
		text.add("Vestibulum eget lectus ut ligula tempus ultrices ac rhoncus libero. When can the incentive breakfast strike? Every arithmetic walks! The capitalist shies away without the grief! Should the normal standpoint overflow without the planet? The wretched earth reverts. The insufficient banner distances the simplified firework.");
		text.add("Integer ac enim eget nisl malesuada tempor nec eu turpis. Our coordinate yard sauces the machine beneath an esoteric temple. The teapot sweeps beside the nostalgia. The forgotten python hopes. The bush league bushes the fellow. Can a citizen edit a stimulating composite? The fame trails without another load. A wisest rhythm misguides a modern thick. Above its communist nests the accountant. Your counterpart talks over the rubber ham. A tree pants beside a net gas.");
		text.add("Donec in massa pulvinar, mattis turpis ut, aliquam ligula. The countryside plays with the fashionable documentary underneath the trifle. The museum cycles a doctor over the hack postscript. A wallet listens on top of the attempt! The fit praise dictates beneath the longest comparison. A genius ducks past an excess. The distress advances with the distress! When can the overlap multiply a break? Should the routine steel skip against a clone? The equipped anarchy budgets an imbalance. The amateur relaxes after the verse! The batch flies behind a pigeon. How can our poison curtain an otherwise child? The reflecting discovery allies the designate wealth. A separator kids past the speaker. The arc overtone rots.");
		text.add("Morbi dictum mi et nisl interdum, vel iaculis lacus suscipit. The stroke pushes the coach beneath any wood outcome. The photocopy prevails below the feat volunteer. The counsel decays beneath the burned disorder. The flute butters a postage after a misrepresented schedule. How can the dreamed baby walk? The speaking misfortune bites an override. A politician rattles against the emerging purple. A sod dries the crush into the packed burden. The warmed eye notices the alphabetical grammar. The smashing scenery chambers the sounding dominant. Why does a rattled height exit? A subsidized physicist rocks an enthusiastic keeper.The outcome noses against the departure. Why won't a temper dish an appalled visit? With a safeguard responds the biggest junk. When will the noisy stress grind against the idiosyncratic blame? How does a desire mend throughout any ripped tooth?");
		text.add("Ut eu quam non orci consectetur vestibulum et scelerisque sapien. The debt destroys every refined boy behind an ethic. Whatever compound sweeps into the concealed noun. The tomato posts a helmet. The gate flowers throughout a satire. The united plague restores this sympathetic likelihood. A simulate commentator perceives a laughter against the tame metaphor. The flood composes in the startled fuse. Can a taxpayer lecture her container? The circular chooses past her typewriter.");
		text.add("Morbi accumsan leo non ex tempor, congue ullamcorper urna viverra. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.");
		text.add("In quis enim a odio venenatis scelerisque dignissim sed mauris. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
		text.add("Maecenas ultrices nulla nec malesuada ullamcorper.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		text.add("Mauris mattis nisi quis rhoncus mollis. In addition to generating an entire comedy routine, the software provides additional means to make existing content funnier. One of those ways is through the Article Part menu that can insert a short, funny paragraph into an existing routine or article. Also available is the One-Liner Jokes option on the right-click menu, which presents a list of relevant one-liners in the Phrase Box for later use.First Draft 5.0 costs $149.99 and can be purchased online from http://www.justoutsourcing.com/.");
		text.add("In auctor lorem quis eros fermentum ultricies a at nibh. The tray boils under a deprived alcoholic. How can a beaten populace fork the climbing developer? The rounded imbalance expenses the spy. Your inexperienced scene showers the mystic. The scrap determines a blanket behind the wanted whole. Why does the horrified rat bell a talented swallow? The dragging alphabet noses. Next to the sophisticate tries the fascist cell. A tale catalogs the adventure. A parallel force exercises opposite an exponential soldier. The motto sleeps inside the road. A uninteresting helmet dictates near the glass. The unhappy dealer hopes. A pregnant mailbox grabs the garden next to a precious classic. The creature demands the blob.");
		text.add("Curabitur quis mauris ullamcorper, ultricies orci non, porttitor diam. A chord degenerates into the based fairy. This wretched sin gasps outside the analogy. Each prerequisite waters a conscience. The superfluous hospital surnames every meal. The clique rails behind a gas! Should the highlight proclaim the restaurant? An indent flips! The gospel dresses the penny author. On top of a debate waves an incomplete stake. A screaming rainbow authorizes the farmer over a sweeping devil. The follower cruises on top of the landlord! Should the policeman frown above the guest stereotype? The biochemistry modifies a numeric tube. The unset stair ditches the prominent editorial. A prototype crawls. The alert finances the charged comfort. The guaranteed terrorist senses the hell throughout the owed attitude. The static responds opposite every sunrise. A scroll entitles our scenery beside a lifted decay. The plant wishes a barrier with the adult bomb. The ink pats the egg across your offending volume. The defect gifts the devoid vein.");
		text.add("Fusce aliquet libero vel risus luctus ullamcorper.");
		text.add("Vestibulum non risus sit amet lorem blandit tempus.");
		text.add("Fusce gravida libero a neque cursus gravida.");
		text.add("Proin eget urna tempor, ullamcorper lectus eget, elementum massa. The assumed plotter rushs toward the anatomy. Beneath the physiology despairs the table. A waiting musician leaks above the pole. The chicken patient gins the frustrated container. The ready craft farms the impractical reactionary. Can my flood host the operator? Each charge bumps against the march. The analogy enters?The static mutters? The rabbit conveys the bastard after a correct resemblance. The blade prefers the compelled straw. The specified postscript tries beside the fancy mount. Underneath the reform reigns an organic supernatural. An official buttons the theater. The pleasant toe misses the alternative. The smallish tongue charges the barrister in a confused artist. When will a frowning electron outweigh the dress company? The cheese results with a coke. Why won't the attending throat imprison the paranoid sea? Beneath the lust foams each ecology. How does the commissioned contempt protect the mate?");
		text.add("Quisque at justo elementum, finibus elit ut, ultrices nibh.");
		text.add("Pellentesque nec nulla vel neque tincidunt rutrum.");
		text.add("Donec dictum enim nec mi pulvinar, nec consequat eros tristique. A sky deletes a curtain over the bearded parameter. A handicap escapes near the constant! The vicar dances a threshold opposite a rough limb. The architecture outcries the pat jack after the reflex. An article cruises in the wartime. How will the detailed barrel die without the bench? The heat attends behind the imperative! The steel sleeps over the shame! The smelly exponential hopes a huge anatomy. Against the jack participates a motor. The corporate tour chars an illustrated theology. The confining knowledge ices the desirable bubble. Why can't an invitation volume tailor the irate bandwagon? The brother closet pipes the indent. The fined group trails around a homosexual.");
		text.add("Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.");
		text.add("In non leo et nibh porttitor lobortis. A pan disturbs the barrister. Its password invalidates the gospel. A silver bath rests. When will the tempting fossil escape a shade? The unsafe collective lands a populace. When will our digital threshold moan? The ice grabs this carpet. The network functions as the pro prose. The independence pressures his appointed country. How can the biting trouble hunt? Why can't an asset rail? A number meets the colleague throughout an adventurous biography. The invitation mountain solos throughout a syndicate. The orienting analogue publicizes the implied finger. The parochial alcoholic warms to another sugar. Against each worn hero towers your unsuccessful holy. A wonderful numeral caves the child. A gateway catalogs the comic throughout the akin cycle. The terror fringes an injury. When can the photo scratch the logo? My track tasks the paste. A prisoner colors. The tone elects the monochrome suspicion. The herd jams without the absent developer. Her banana enhances the competing talent next to the warm. An alcoholic pumps outside the artist! The justified poison strays next to the inhibiting ruler. A divine fools the experienced address above the singer. The shutdown swims throughout the bankrupt. The tried poison excites the ace. The pedestrian persists throughout a packed warm. Should the elephant's wealth appear throughout a tactic? Under every storm degenerates the perpetual bankrupt.");
		text.add("Donec hendrerit lacus semper justo bibendum fermentum. The lousy lung stirs across the pedestrian homosexual. A vocal distresses the tile. How does an ineffective disease refresh the imperial rage? The complicate potato edges the derived nostalgia.");
		text.add("Sed tempus nunc interdum neque sodales, at mollis magna convallis.");
		text.add("Aliquam efficitur sem quis facilisis aliquam. Why won't the horizon progress above a crash friendship? How will the fine muck break outside the boy? The page enters the graffito. The coal shortens the bump into a demolished article. A chemical thinks opposite a vegetable! How does a pace withdraw? The pill leaks across the secretary. Whatever ward twins every passionate weapon. An orientated moderate bringings a strict wine. Why won't the toy solo? Your diagonal mistake strains against a diagonal. Can the pan tutorial coast? The delicate physics degenerates against the platform. How does the lane studio document the unchanged hierarchy? When can an illiterate violin supervise a blind resource? The grouped gun walks against our screen. The executive juice scratches outside every wed bean. Why does a some guard prepare a stamped hash? The salesman faints over the rending uncle. A perfect thumb turns an average. The holder aids the spectacular throughout my cancelled weekday. Below the manual sigh stares the plastered deed. Why can't the numerous workshop thirst? The removed norm loves a charter. Why won't the proof file an opera? An overwhelmed limb doses a tailor. How does the foreigner puzzle inside the deciding coal? Will the cozy coach thirst throughout a principal? Next to the darling tooth sleeps the neighbor highway. When can the comparable prince flower? Should a decimal racket change against the cuckoo? The privileged earth punts near the buyer. An appeal holds a stare. The starved burst serves as the scotch. How does the creative blackmail rule near the altogether? Why does his praise revert? The beginner determines the mumble.");
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
	
	public void papeError100(WebDriver driver) throws Exception{
		
		List<String> text=error100Data();
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		int i;
		int j=text.size()-1;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Closes any warning from server
	    try{
		  
		  //CLoses server warning
		  String s=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
		  System.out.println(s);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();			  
		 }catch (org.openqa.selenium.TimeoutException e)
		  {
			  
		  }
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
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		//Fill in texts in Corrective Actions
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
		

		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));	
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
		

		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		//Checks error meter as 0%
		WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		String meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("0%").as("test data").isEqualTo(meterText);



		//Click on People of PAPE
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-p"))).click();
		//Clicks on checkboxes in People Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q1"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("13%").as("test data").isEqualTo(meterText);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("25%").as("test data").isEqualTo(meterText);
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("38%").as("test data").isEqualTo(meterText);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q4"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("50%").as("test data").isEqualTo(meterText);
		
		//Fill in texts in Supporting reasons 
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		//Fill in texts in Corrective Actions
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
		
					
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
		
		


		//Click on Activity of PAPE
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-a"))).click();
		//Clicks on checkboxes in Activity Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q1"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("58%").as("test data").isEqualTo(meterText);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("67%").as("test data").isEqualTo(meterText);
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q3"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("75%").as("test data").isEqualTo(meterText);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("83%").as("test data").isEqualTo(meterText);
		
		//Fill in texts in Supporting reasons 
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		//Fill in texts in Corrective Actions
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
		

		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
		
		

		//Clicks on Procedure Tab
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-t"))).click();
		//Clicks on checkboxes in Procedure Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("88%").as("test data").isEqualTo(meterText);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q2"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("92%").as("test data").isEqualTo(meterText);
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("96%").as("test data").isEqualTo(meterText);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q4"))).click();
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
		meterText = meter.getText();
		System.out.println(meterText);
		softly.assertThat("100%").as("test data").isEqualTo(meterText);
		
		//Fill in texts in Supporting reasons 
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
		
		
		//Fill in texts in Corrective Actions
		jse.executeScript("scroll(0, 0)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		jse.executeScript("scroll(0, 800)");
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
		
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
		jse.executeScript("scroll(0, 0)");
		jse.executeScript("scroll(0, 0)");
	}

	public void papeError50(WebDriver driver) throws Exception{
			
		    List<String> text = error50Data();
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			int i;
			int j=text.size()-1;
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Closes any warning from server
		    try{
			  
			  //CLoses server warning
			  String s=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			  System.out.println(s);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();			  
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
			//Click on Environment of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-e"))).click();
			//Clicks on checkboxes in Environment Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
						
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
			//Leave in text in empty boxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
			

			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
			//Leave text in corrective actions
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
			

			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			//Checks error meter as 0%
			WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			String meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);



			//Click on People of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-p"))).click();
			//Clicks on checkboxes in People Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			Thread.sleep(1000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("13%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			Thread.sleep(1000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("25%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
			

			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
			

			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
			

			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
			
			
			//Click on Activity of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-a"))).click();
			//Clicks on checkboxes in Activity Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			Thread.sleep(1000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("33%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			Thread.sleep(1000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("42%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
			

			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
			

			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
			

			//Clicks on Procedure Tab
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-t"))).click();
			//Clicks on checkboxes in Procedure Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			Thread.sleep(1000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("46%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			Thread.sleep(1000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("50%").as("test data").isEqualTo(meterText);
				
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text.get(j));
			

			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text.get(j));
			

			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text.get(j));
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j--));
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text.get(j));
			//leave in text
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text.get(j));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text.get(j));
			
			
		}
	
	
		public void papeError0(WebDriver driver) throws Exception{
			
			String text = error0Data();
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			//Closes any warning from server
		    try{
			  
			  //CLoses server warning
			  String s=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			  System.out.println(s);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();			  
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
			//Clicks on checkboxes in Procedure Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q2"))).click();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			int i;
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			//Checks error meter as 0%
			WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			String meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);

			//Click on Activity of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-a"))).click();
			//Clicks on checkboxes in Activity Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			//Checks error meter as 0%
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);
			
			//Click on People of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-p"))).click();
			//Clicks on checkboxes in People Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).clear();
						
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			//Checks error meter as 0%
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);
			
			//Click on Environment of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-e"))).click();
			//Clicks on checkboxes in Environment Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).clear();
						
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			//Checks error meter as 0%
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);

		}

	public void downloadReportIE(WebDriver driver, int y) throws Exception {
    	
    	//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,30);
    	Thread.sleep(2000);
		//Clicks on download button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		Thread.sleep(3000);
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
    	try {
			  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			  q.waitFor();
			  }catch (UnhandledAlertException f){	
				  System.out.println("Unexpected alert for picture 2");
				  driver.switchTo().alert().accept();
				  
		  	  }catch (NoAlertPresentException f){
		  		  System.out.println ("No unexpected alert for picture 2");
		  		  }
    	Thread.sleep(15000);
    	//pdf verification
    	if (y==0)
    		pdfCheckError0();
    	if(y==50)
    		pdfCheckError50();
    	if(y==100)
    		pdfCheckError100();
    	Thread.sleep(4000);
    	//Switch to window    	
    	driver.switchTo().window(window);
    	//Switches to the iframe
        wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
			    		    	
    }
	
	public void downloadReportIE11(WebDriver driver, int y) throws Exception {
    	
    	//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,30);
    	Thread.sleep(2000);
		//Clicks on download button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		Thread.sleep(3000);
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
    	try {
			  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			  q.waitFor();
			  }catch (UnhandledAlertException f){	
				  System.out.println("Unexpected alert for picture 2");
				  driver.switchTo().alert().accept();
				  
		  	  }catch (NoAlertPresentException f){
		  		  System.out.println ("No unexpected alert for picture 2");
		  		  }
    	Thread.sleep(15000);
    	//pdf verification
    	if (y==0)
    		pdfCheckError0();
    	if(y==50)
    		pdfCheckError50();
    	if(y==100)
    		pdfCheckError100();
    	Thread.sleep(4000);
    	//Switch to window    	
    	driver.switchTo().window(window);
    	//Switches to the iframe
        wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
			    		    	
    }
	
	 public void downloadReportFirefox (WebDriver driver, int y) throws Exception {
	    	
	    	//deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on download button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(8000);
	    	for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
	    	Thread.sleep(4000);
	    	Robot robot = new Robot();
	    	// press Ctrl+S the Robot's way
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_S);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_S);
	    	Thread.sleep(4000);
	    	Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
	    	p.waitFor();
	    	Thread.sleep(4000);
	    	if (y==0)
	    		pdfCheckError0();
	    	if(y==50)
	    		pdfCheckError50();
	    	if(y==100)
	    		pdfCheckError100();
	    	Thread.sleep(4000);
	    	driver.close();
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    	//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	       	    		    	
	    }
	
	public void downloadReportChrome (WebDriver driver, int y) throws Exception {
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports");
    	deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	String window = driver.getWindowHandle();
		//Clicks on download button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
    	Thread.sleep(3000);
    	if (y==0)
    		pdfCheckError0();
    	if(y==50)
    		pdfCheckError50();
    	if(y==100)
    		pdfCheckError100();
    	for(String winHandle : driver.getWindowHandles())
    	{
	        driver.switchTo().window(winHandle);
	    }
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
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
	public void checkEditButon(WebDriver driver)throws Exception{
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
	}

	public void pdfCheckError0() throws Exception{
		
		String text = error0Data();
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
	        		newData1 = newData1+" "+ans.get(i);	        	
	        }
       newData1=newData1.replace("  ", " ");
       System.out.println(newData1);
       //Verifies 0.00%
       softly.assertThat("0.00%").as("test data").isSubstringOf(newData1);
       //Verifies risk level as Low
       softly.assertThat("risk level: low").as("test data").isSubstringOf(newData1);
       //Verify Non-Issue
       softly.assertThat("Non- Issue").as("test data").isSubstringOf(newData1);
       int countx = countMatches(newData1, "Non- Issue");
       System.out.println("Non- Issue: "+countx);
       softly.assertThat(countx).as("test data").isEqualTo(16);
       //Verify that text left in was not part of pdf
       if (newData1.contains(text)==true)
    	   softly.fail("text present in pdf: "+text);
  }
	
	public void pdfCheckError50() throws Exception{
    	
		List<String> text = error50Data();
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
	        		newData1 = newData1+" "+ans.get(i);	        	
	        }
       newData1=newData1.replace("  ", " ");
       System.out.println(newData1);
       //Verifies 50.00%
       softly.assertThat("50.00%").as("test data").isSubstringOf(newData1);
       //Verifies risk level as Low
       softly.assertThat("risk level: medium").as("test data").isSubstringOf(newData1);
       //Verify Non-Issue
       softly.assertThat("Non- Issue").as("test data").isSubstringOf(newData1);
       int count1 = countMatches(newData1, "Non- Issue");
       System.out.println("Non- Issue: "+count1);
       softly.assertThat(count1).as("test data").isEqualTo(8);
       //Verify SPV
       softly.assertThat("SPV").as("test data").isSubstringOf(newData1);
       int countx = countMatches(newData1, "SPV");
       System.out.println("SPV: "+countx);
       softly.assertThat(countx).as("test data").isEqualTo(9);
       //Verify all data entered
       for (int i=0;i<text.size();i++)
    	   softly.assertThat(text.get(i)).as("test data").isSubstringOf(newData1);
       
       pddoc.close();
  }
	
	public void pdfCheckError100() throws Exception{
    
	   List<String> text = error100Data();
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
       int countx = countMatches(newData1, "SPV");
       softly.assertThat(countx).as("test data").isEqualTo(17);
       System.out.println("SPV: "+countx);
       //Verify all data entered
       for (int i=0;i<text.size();i++)
    	   softly.assertThat(text.get(i)).as("test data").isSubstringOf(newData1);
       
       pddoc.close();
  }
	
	public int countMatches(String str, String sub) {
	      
	      int count = 0;
	      int idx = 0;
	      while ((idx = str.indexOf(sub, idx)) != -1) {
	          count++;
	          idx += sub.length();
	      }
	      return count;
	  }
	
	public void reportCheck0(WebDriver driver) throws Exception{
    	
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
    	//Wait for black loading message to disappear
    	try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }		
		//Compare Environment data
    	//Supporting reasons
    	String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text1E).as("test data").isEqualTo("");
    	String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text2E).as("test data").isEqualTo("");
    	String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text3E).as("test data").isEqualTo("");
    	String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text4E).as("test data").isEqualTo("");
    	//Corrective actions
    	String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text5E).as("test data").isEqualTo("");    	
    	String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text6E).as("test data").isEqualTo("");    	
    	String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text7E).as("test data").isEqualTo("");    	
    	String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text8E).as("test data").isEqualTo("");
    	
    	
    	//Compare People data
    	//Supporting reasons
    	String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text9E).as("test data").isEqualTo("");    	
    	String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text10E).as("test data").isEqualTo("");    	
    	String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text11E).as("test data").isEqualTo("");    	
    	String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text12E).as("test data").isEqualTo("");    	
    	//Corrective actions
    	String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text13E).as("test data").isEqualTo("");    	
    	String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text14E).as("test data").isEqualTo("");    	
    	String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text15E).as("test data").isEqualTo("");    	
    	String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text16E).as("test data").isEqualTo("");
    	
    	
    	//Compare Activity data
    	//Supporting reasons
    	String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text17E).as("test data").isEqualTo("");    	
    	String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text18E).as("test data").isEqualTo("");    	
    	String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text19E).as("test data").isEqualTo("");    	
    	String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text20E).as("test data").isEqualTo("");    	
    	//Corrective actions
    	String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text21E).as("test data").isEqualTo("");    	
    	String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text22E).as("test data").isEqualTo("");    	
    	String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text23E).as("test data").isEqualTo("");    	
    	String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text24E).as("test data").isEqualTo("");    	
    	
    	//Compare Procedure data
    	//Supporting reasons
    	String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text25E).as("test data").isEqualTo("");    	
    	String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text26E).as("test data").isEqualTo("");    	
    	String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text27E).as("test data").isEqualTo("");    	
    	String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text28E).as("test data").isEqualTo("");    	
    	//Corrective actions
    	String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text29E).as("test data").isEqualTo("");    	
    	String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text30E).as("test data").isEqualTo("");    	
    	String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text31E).as("test data").isEqualTo("");    	
    	String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text32E).as("test data").isEqualTo("");
    	
    	//Checks for Non issue
    	//Procedure
    	String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textsp1).as("test data").isEqualTo("Non-Issue");
    	String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textnon1).as("test data").isEqualTo("Non-Issue");
    	String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textsp2).as("test data").isEqualTo("Non-Issue");
    	String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textnon2).as("test data").isEqualTo("Non-Issue");
    	
    	//Activity
    	String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textnon3).as("test data").isEqualTo("Non-Issue");
    	String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textsp3).as("test data").isEqualTo("Non-Issue");
    	String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textnon4).as("test data").isEqualTo("Non-Issue");
    	String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textsp4).as("test data").isEqualTo("Non-Issue");
    	
    	//People
    	String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textnon5).as("test data").isEqualTo("Non-Issue");
    	String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textsp5).as("test data").isEqualTo("Non-Issue");
    	String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textsp6).as("test data").isEqualTo("Non-Issue");
    	String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textnon6).as("test data").isEqualTo("Non-Issue");
    	
    	//Environment
    	String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textsp7).as("test data").isEqualTo("Non-Issue");
    	String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textnon7).as("test data").isEqualTo("Non-Issue");
    	String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textnon8).as("test data").isEqualTo("Non-Issue");
    	String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textsp8).as("test data").isEqualTo("Non-Issue");
    	
    	//Error probability
    	WebElement probability=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/strong")));
		String probabilityText = probability.getText();
		System.out.println(probabilityText);
		softly.assertThat("0.00%").as("test data").isEqualTo(probabilityText);
    }
	
	public void reportCheck50(WebDriver driver) throws Exception{
    	
		List<String> text = error50Data();
		WebDriverWait wait = new WebDriverWait(driver,30);
		int j=text.size()-1;
    	//Clicks on first newly created record
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
    	//Wait for black loading message to disappear
    	try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }		
    	//Compare Environment data
    	//Supporting reasons
    	String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text1E).as("test data").isEqualTo(text.get(j--));
    	String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text2E).as("test data").isEqualTo("");
    	String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text3E).as("test data").isEqualTo("");
    	String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text4E).as("test data").isEqualTo(text.get(j--));
    	//Corrective actions
    	String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text5E).as("test data").isEqualTo(text.get(j--));
    	String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text6E).as("test data").isEqualTo("");
    	String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text7E).as("test data").isEqualTo("");
    	String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text8E).as("test data").isEqualTo(text.get(j--));
    	
    	//Compare People data
    	//Supporting reasons
    	String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text9E).as("test data").isEqualTo("");
    	String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text10E).as("test data").isEqualTo(text.get(j--));
    	String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text11E).as("test data").isEqualTo(text.get(j--));
    	String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text12E).as("test data").isEqualTo("");
    	//Corrective actions
    	String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text13E).as("test data").isEqualTo("");
    	String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text14E).as("test data").isEqualTo(text.get(j--));
    	String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text15E).as("test data").isEqualTo(text.get(j--));
    	String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text16E).as("test data").isEqualTo("");
    	
    	//Compare Activity data
    	//Supporting reasons
    	String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text17E).as("test data").isEqualTo("");
    	String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text18E).as("test data").isEqualTo(text.get(j--));
    	String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text19E).as("test data").isEqualTo("");
    	String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text20E).as("test data").isEqualTo(text.get(j--));
    	//Corrective actions
    	String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text21E).as("test data").isEqualTo("");
    	String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text22E).as("test data").isEqualTo(text.get(j--));
    	String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text23E).as("test data").isEqualTo("");
    	String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text24E).as("test data").isEqualTo(text.get(j--));
    	
    	//Compare Procedure data
    	//Supporting reasons
    	String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text25E).as("test data").isEqualTo(text.get(j--));
    	String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text26E).as("test data").isEqualTo("");
    	String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text27E).as("test data").isEqualTo(text.get(j--));
    	String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text28E).as("test data").isEqualTo("");
    	//Corrective actions
    	String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text29E).as("test data").isEqualTo(text.get(j--));
    	String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text30E).as("test data").isEqualTo("");
    	String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text31E).as("test data").isEqualTo(text.get(j--));
    	String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text32E).as("test data").isEqualTo("");
    	
    	//Checks for SPV and non issue
    	//Procedure
    	String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textsp1).as("test data").isEqualTo("SPV");
    	String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textnon1).as("test data").isEqualTo("Non-Issue");
    	String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textsp2).as("test data").isEqualTo("SPV");
    	String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textnon2).as("test data").isEqualTo("Non-Issue");
    	
    	//Activity
    	String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textnon3).as("test data").isEqualTo("Non-Issue");
    	String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textsp3).as("test data").isEqualTo("SPV");
    	String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textnon4).as("test data").isEqualTo("Non-Issue");
    	String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textsp4).as("test data").isEqualTo("SPV");
    	
    	//People
    	String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textnon5).as("test data").isEqualTo("Non-Issue");
    	String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textsp5).as("test data").isEqualTo("SPV");
    	String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textsp6).as("test data").isEqualTo("SPV");
    	String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textnon6).as("test data").isEqualTo("Non-Issue");
    	
    	//Environment
    	String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textsp7).as("test data").isEqualTo("SPV");
    	String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textnon7).as("test data").isEqualTo("Non-Issue");
    	String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textnon8).as("test data").isEqualTo("Non-Issue");
    	String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textsp8).as("test data").isEqualTo("SPV");
    }
	
	public void reportCheck100(WebDriver driver) throws Exception{
    	
		List<String> text = error100Data();
		WebDriverWait wait = new WebDriverWait(driver,30);
		int j=text.size()-1;
		//Clicks on first newly created record
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
    	//Wait for black loading message to disappear
    	try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }		
		//Compare Environment data
    	//Supporting reasons
    	String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text1E).as("test data").isEqualTo(text.get(j--));
    	String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text2E).as("test data").isEqualTo(text.get(j--));
    	String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text3E).as("test data").isEqualTo(text.get(j--));
    	String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text4E).as("test data").isEqualTo(text.get(j--));
    	//Corrective actions
    	String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text5E).as("test data").isEqualTo(text.get(j--));    	
    	String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text6E).as("test data").isEqualTo(text.get(j--));    	
    	String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text7E).as("test data").isEqualTo(text.get(j--));    	
    	String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text8E).as("test data").isEqualTo(text.get(j--));
    	
    	
    	//Compare People data
    	//Supporting reasons
    	String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text9E).as("test data").isEqualTo(text.get(j--));    	
    	String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text10E).as("test data").isEqualTo(text.get(j--));    	
    	String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text11E).as("test data").isEqualTo(text.get(j--));    	
    	String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text12E).as("test data").isEqualTo(text.get(j--));    	
    	//Corrective actions
    	String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text13E).as("test data").isEqualTo(text.get(j--));    	
    	String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text14E).as("test data").isEqualTo(text.get(j--));    	
    	String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text15E).as("test data").isEqualTo(text.get(j--));    	
    	String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text16E).as("test data").isEqualTo(text.get(j--));
    	
    	
    	//Compare Activity data
    	//Supporting reasons
    	String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text17E).as("test data").isEqualTo(text.get(j--));    	
    	String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text18E).as("test data").isEqualTo(text.get(j--));    	
    	String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text19E).as("test data").isEqualTo(text.get(j--));    	
    	String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text20E).as("test data").isEqualTo(text.get(j--));    	
    	//Corrective actions
    	String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text21E).as("test data").isEqualTo(text.get(j--));    	
    	String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text22E).as("test data").isEqualTo(text.get(j--));    	
    	String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text23E).as("test data").isEqualTo(text.get(j--));    	
    	String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text24E).as("test data").isEqualTo(text.get(j--));
    	
    	
    	//Compare Procedure data
    	//Supporting reasons
    	String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[3]"))).getText();
    	softly.assertThat(text25E).as("test data").isEqualTo(text.get(j--));    	
    	String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[3]"))).getText();
    	softly.assertThat(text26E).as("test data").isEqualTo(text.get(j--));    	
    	String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[3]"))).getText();
    	softly.assertThat(text27E).as("test data").isEqualTo(text.get(j--));    	
    	String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[3]"))).getText();
    	softly.assertThat(text28E).as("test data").isEqualTo(text.get(j--));    	
    	//Corrective actions
    	String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[4]"))).getText();
    	softly.assertThat(text29E).as("test data").isEqualTo(text.get(j--));    	
    	String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[4]"))).getText();
    	softly.assertThat(text30E).as("test data").isEqualTo(text.get(j--));    	
    	String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[4]"))).getText();
    	softly.assertThat(text31E).as("test data").isEqualTo(text.get(j--));    	
    	String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[4]"))).getText();
    	softly.assertThat(text32E).as("test data").isEqualTo(text.get(j--));
    	
    	//Checks for SPV
    	//Procedure
    	String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textsp1).as("test data").isEqualTo("SPV");
    	String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textnon1).as("test data").isEqualTo("SPV");
    	String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textsp2).as("test data").isEqualTo("SPV");
    	String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textnon2).as("test data").isEqualTo("SPV");
    	
    	//Activity
    	String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textnon3).as("test data").isEqualTo("SPV");
    	String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textsp3).as("test data").isEqualTo("SPV");
    	String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textnon4).as("test data").isEqualTo("SPV");
    	String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textsp4).as("test data").isEqualTo("SPV");
    	
    	//People
    	String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textnon5).as("test data").isEqualTo("SPV");
    	String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textsp5).as("test data").isEqualTo("SPV");
    	String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textsp6).as("test data").isEqualTo("SPV");
    	String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textnon6).as("test data").isEqualTo("SPV");
    	
    	//Environment
    	String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
    	softly.assertThat(textsp7).as("test data").isEqualTo("SPV");
    	String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
    	softly.assertThat(textnon7).as("test data").isEqualTo("SPV");
    	String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
    	softly.assertThat(textnon8).as("test data").isEqualTo("SPV");
    	String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
    	softly.assertThat(textsp8).as("test data").isEqualTo("SPV");
    }
	
	public String decideSharer (int y) throws Exception{
		
		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		if(y==0)
    	{
    		String sharer ="qaasharer";
    		return sharer;
       	}
    	if(y==1)
    	{
    		String sharer ="qaasharernonadmin";
    		return sharer;
       	}
    	if(y==2)
    	{
    		String sharer ="qaasharerie11";
    		return sharer;
       	}
    	if(y==3)
    	{
    		String sharer ="qaasharernonadminie11";
    		return sharer;
       	}
    	if(y==4)
    	{
    		String sharer ="qaasharerus";
    		return sharer;
       	}
    	if(y==5)
    	{
    		String sharer ="qaasharernonadminus";
    		return sharer;
       	}
    	if(y==6)
    	{
    		String sharer ="qaasharerusie11";
    		return sharer;
       	}
    	else
    	{
    		String sharer ="qaasharernonadminusie11";
    		return sharer;
       	}
		
	}
	
	public String decideSharerAdded (int y) throws Exception{
		
		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		if(y==0)
    	{
    		String sharer ="QAA (qaasharer)";
    		return sharer;
       	}
    	if(y==1)
    	{
    		String sharer ="QAA (qaasharernonadmin)";
    		return sharer;
       	}
    	if(y==2)
    	{
    		String sharer ="QAA (qaasharerie11)";
    		return sharer;
       	}
    	if(y==3)
    	{
    		String sharer ="QAA (qaasharernonadminie11)";
    		return sharer;
       	}
    	if(y==4)
    	{
    		String sharer ="QAA (qaasharerus)";
    		return sharer;
       	}
    	if(y==5)
    	{
    		String sharer ="QAA (qaasharernonadminus)";
    		return sharer;
       	}
    	if(y==6)
    	{
    		String sharer ="QAA (qaasharerusie11)";
    		return sharer;
       	}
    	else
    	{
    		String sharer ="QAA (qaasharernonadminusie11)";
    		return sharer;
       	}
		
	}
	
	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{
    	
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	String sharer = decideSharer (y);
    	String sharerAdded = decideSharerAdded (y);
		//Clicks on share button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
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
		Thread.sleep(3000);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
		//Waits for black loading message to disappear
		  try{
			  Thread.sleep(1000);
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
		 softly.assertThat(sharer).as("test data").isEqualTo(sharedToUsername);
		 WebElement shared=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/strong")));
		 String sharedText = shared.getText();
		 System.out.println(sharedText);
		 softly.assertThat("Shared with:").as("test data").isEqualTo(sharedText);
		//Calls the Share check function
		ShareCheck obj1 = new ShareCheck();
		obj1.receiptReport(driver, sharer, username, password1);
		//Clicks on Error Meter side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		 //Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();;
    }
    
    public void markCritical(WebDriver driver) throws Exception{
    	
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
    
    public void deleteNewRecord(String recordName, WebDriver driver) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //CLicks on first newly created record
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
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
    public void softAssert() throws Exception {
		softly.assertAll();
	}
		
}
