import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ErrorMeter2 {

	//Firs page of module
	By JobTitleCharacterCount = By.id("pii-epm-job-title-count");

	//HTML
	By ErrorMeterSidePanel = By.id("pii-user-home-panel-btn-epm");
	By ErrorMeterEnvironmentSupportingReason1 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[3]");
	By ErrorMeterEnvironmentSupportingReason2 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[3]");
	By ErrorMeterEnvironmentSupportingReason3 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[3]");
	By ErrorMeterEnvironmentSupportingReason4 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[3]");
	By ErrorMeterEnvironmentCorrectiveAction1 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[4]");
	By ErrorMeterEnvironmentCorrectiveAction2 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[4]");
	By ErrorMeterEnvironmentCorrectiveAction3 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[4]");
	By ErrorMeterEnvironmentCorrectiveAction4 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[4]");
	By ErrorMeterPeopleSupportingReason1 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[3]");
	By ErrorMeterPeopleSupportingReason2 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[3]");
	By ErrorMeterPeopleSupportingReason3 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[3]");
	By ErrorMeterPeopleSupportingReason4 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[3]");
	By ErrorMeterPeopleCorrectiveAction1 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[4]");
	By ErrorMeterPeopleCorrectiveAction2 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[4]");
	By ErrorMeterPeopleCorrectiveAction3 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[4]");
	By ErrorMeterPeopleCorrectiveAction4 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[4]");
	By ErrorMeterActivitySupportingReason1 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[3]");
	By ErrorMeterActivitySupportingReason2 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[3]");
	By ErrorMeterActivitySupportingReason3 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[3]");
	By ErrorMeterActivitySupportingReason4 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[3]");
	By ErrorMeterActivityCorrectiveAction1 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[4]");
	By ErrorMeterActivityCorrectiveAction2 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[4]");
	By ErrorMeterActivityCorrectiveAction3 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[4]");
	By ErrorMeterActivityCorrectiveAction4 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[4]");
	By ErrorMeterProcedureSupportingReason1 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[3]");
	By ErrorMeterProcedureSupportingReason2 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[3]");
	By ErrorMeterProcedureSupportingReason3 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[3]");
	By ErrorMeterProcedureSupportingReason4 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[3]");
	By ErrorMeterProcedureCorrectiveAction1 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[4]");
	By ErrorMeterProcedureCorrectiveAction2 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[4]");
	By ErrorMeterProcedureCorrectiveAction3 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[4]");
	By ErrorMeterProcedureCorrectiveAction4 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[4]");

	By ErrorMeterProcedureSPVNonIssue1 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[1]");
	By ErrorMeterProcedureSPVNonIssue2 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[1]");
	By ErrorMeterProcedureSPVNonIssue3 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[1]");
	By ErrorMeterProcedureSPVNonIssue4 = By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[1]");
	By ErrorMeterActivitySPVNonIssue1 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[1]");
	By ErrorMeterActivitySPVNonIssue2 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[1]");
	By ErrorMeterActivitySPVNonIssue3 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[1]");
	By ErrorMeterActivitySPVNonIssue4 = By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[1]");
	By ErrorMeterPeopleSPVNonIssue1 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[1]");
	By ErrorMeterPeopleSPVNonIssue2 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[1]");
	By ErrorMeterPeopleSPVNonIssue3 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[1]");
	By ErrorMeterPeopleSPVNonIssue4 = By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[1]");
	By ErrorMeterEnvironmentSPVNonIssue1 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[1]");
	By ErrorMeterEnvironmentSPVNonIssue2 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[1]");
	By ErrorMeterEnvironmentSPVNonIssue3 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[1]");
	By ErrorMeterEnvironmentSPVNonIssue4 = By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[1]");

	//Inside report
	By ErrorMeterPercentageBar = By.xpath(".//*[@id='pii-epm-progbar']/div/div/a");
	By ErrorMeterPAPEEnvironmentTab = By.id("pii-epm-taba-e");
	By ErrorMeterPAPEEnvironmentCheckBox1 = By.id("pii-epm-tab-e-q1");
	By ErrorMeterPAPEEnvironmentCheckBox2 = By.id("pii-epm-tab-e-q2");
	By ErrorMeterPAPEEnvironmentCheckBox3 = By.id("pii-epm-tab-e-q3");
	By ErrorMeterPAPEEnvironmentCheckBox4 = By.id("pii-epm-tab-e-q4");
	By ErrorMeterPAPEEnvironmentSupportingReason1 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea");
	By ErrorMeterPAPEEnvironmentSupportingReason2 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea");
	By ErrorMeterPAPEEnvironmentSupportingReason3 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea");
	By ErrorMeterPAPEEnvironmentSupportingReason4 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea");
	By ErrorMeterPAPEEnvironmentCorrectiveAction1 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea");
	By ErrorMeterPAPEEnvironmentCorrectiveAction2 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea");
	By ErrorMeterPAPEEnvironmentCorrectiveAction3 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea");
	By ErrorMeterPAPEEnvironmentCorrectiveAction4 = By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea");

	By ErrorMeterPAPEPeopleTab = By.id("pii-epm-taba-p");
	By ErrorMeterPAPEPeopleCheckBox1 = By.id("pii-epm-tab-p-q1");
	By ErrorMeterPAPEPeopleCheckBox2 = By.id("pii-epm-tab-p-q2");
	By ErrorMeterPAPEPeopleCheckBox3 = By.id("pii-epm-tab-p-q3");
	By ErrorMeterPAPEPeopleCheckBox4 = By.id("pii-epm-tab-p-q4");
	By ErrorMeterPAPEPeopleSupportingReason1 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea");
	By ErrorMeterPAPEPeopleSupportingReason2 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea");
	By ErrorMeterPAPEPeopleSupportingReason3 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea");
	By ErrorMeterPAPEPeopleSupportingReason4 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea");
	By ErrorMeterPAPEPeopleCorrectiveAction1 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea");
	By ErrorMeterPAPEPeopleCorrectiveAction2 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea");
	By ErrorMeterPAPEPeopleCorrectiveAction3 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea");
	By ErrorMeterPAPEPeopleCorrectiveAction4 = By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea");

	By ErrorMeterPAPEActivityTab = By.id("pii-epm-taba-a");
	By ErrorMeterPAPEActivityCheckBox1 = By.id("pii-epm-tab-a-q1");
	By ErrorMeterPAPEActivityCheckBox2 = By.id("pii-epm-tab-a-q2");
	By ErrorMeterPAPEActivityCheckBox3 = By.id("pii-epm-tab-a-q3");
	By ErrorMeterPAPEActivityCheckBox4 = By.id("pii-epm-tab-a-q4");
	By ErrorMeterPAPEActivitySupportingReason1 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea");
	By ErrorMeterPAPEActivitySupportingReason2 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea");
	By ErrorMeterPAPEActivitySupportingReason3 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea");
	By ErrorMeterPAPEActivitySupportingReason4 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea");
	By ErrorMeterPAPEActivityCorrectiveAction1 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea");
	By ErrorMeterPAPEActivityCorrectiveAction2 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea");
	By ErrorMeterPAPEActivityCorrectiveAction3 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea");
	By ErrorMeterPAPEActivityCorrectiveAction4 = By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea");

	By ErrorMeterPAPEProcedureTab = By.id("pii-epm-taba-t");
	By ErrorMeterPAPEProcedureCheckBox1 = By.id("pii-epm-tab-t-q1");
	By ErrorMeterPAPEProcedureCheckBox2 = By.id("pii-epm-tab-t-q2");
	By ErrorMeterPAPEProcedureCheckBox3 = By.id("pii-epm-tab-t-q3");
	By ErrorMeterPAPEProcedureCheckBox4 = By.id("pii-epm-tab-t-q4");
	By ErrorMeterPAPEProcedureSupportingReason1 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea");
	By ErrorMeterPAPEProcedureSupportingReason2 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea");
	By ErrorMeterPAPEProcedureSupportingReason3 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea");
	By ErrorMeterPAPEProcedureSupportingReason4 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea");
	By ErrorMeterPAPEProcedureCorrectiveAction1 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea");
	By ErrorMeterPAPEProcedureCorrectiveAction2 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea");
	By ErrorMeterPAPEProcedureCorrectiveAction3 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea");
	By ErrorMeterPAPEProcedureCorrectiveAction4 = By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea");

	public String error0Data(WebDriver driver)throws Exception{

		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			return ("Morbi ut massa <strong> elementum, faucibus lorem vitae, imperdiet lectus. Sed pellentesque mauris sit metus.");
		}
		else return ("Morbi ut massa elementum, faucibus lorem vitae, imperdiet lectus. Sed pellentesque mauris sit metus.");
	}

	public List<String> error50Data(WebDriver driver)throws Exception {
		List<String> text = new ArrayList<String>();
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			text.add("Quisque at justo <div> elementum, finibus elit ut, ultrices nibh.");
			text.add("Pellentesque nec <title> nulla vel neque tincidunt rutrum.");
			text.add("Donec dictum enim <tbody> nec mi pulvinar, nec consequat eros tristique.");
			text.add("Vestibulum lobortis <tr> diam vel erat congue pulvinar sed a tortor.");
			text.add("In non leo et <td> nibh porttitor lobortis.");
			text.add("Donec hendrerit <table> lacus semper justo bibendum fermentum.");
			text.add("Sed tempus nunc <th> interdum neque sodales, at mollis magna convallis.");
			text.add("Aliquam efficitur <thead> sem quis facilisis aliquam.");
			text.add("Proin blandit ante <input> at molestie finibus.");
			text.add("Etiam quis <section> lorem laoreet, malesuada lorem in, tristique sem.");
			text.add("Maecenas vitae <body> orci non dui ultrices posuere vulputate at elit.");
			text.add("Mauris blandit elit <article> sit amet tellus dignissim, eget maximus sem dignissim.");
			text.add("Morbi in dui semper, <label> sagittis augue in, elementum lorem.");
			text.add("Vivamus ut lacus finibus, <script> dictum neque interdum, tincidunt eros.");
			text.add("Duis vestibulum <form> ipsum at dui tincidunt, semper eleifend est congue.");
			text.add("Lorem ipsum dolor sit <br> amet, consectetur adipiscing elit.");
		}
		else{
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
		}
		return text;
	}


	public List<String> error100Data(WebDriver driver) throws Exception{
		List<String> text = new ArrayList<String>();
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			text.add("Curabitur lacinia <center> odio sit amet tellus vestibulum condimentum. The resting sundry overcomes above the focus. Inside a bond catalog suspects the pink cycle. The stopping midnight flips the fundamentalist countryside. The drama discards the monarch galaxy.");
			text.add("Vestibulum eget lectus <span> ut ligula tempus ultrices ac rhoncus libero. When can the incentive breakfast strike? Every arithmetic walks! The capitalist shies away without the grief! Should the normal standpoint overflow without the planet? The wretched earth reverts. The insufficient banner distances the simplified firework.");
			text.add("Integer ac enim <string> eget nisl malesuada tempor nec eu turpis. Our coordinate yard sauces the machine beneath an esoteric temple. The teapot sweeps beside the nostalgia. The forgotten python hopes. The bush league bushes the fellow. Can a citizen edit a stimulating composite? The fame trails without another load. A wisest rhythm misguides a modern thick. Above its communist nests the accountant. Your counterpart talks over the rubber ham. A tree pants beside a net gas.");
			text.add("Donec in massa pulvinar, <table> mattis turpis ut, aliquam ligula. The countryside plays with the fashionable documentary underneath the trifle. The museum cycles a doctor over the hack postscript. A wallet listens on top of the attempt! The fit praise dictates beneath the longest comparison. A genius ducks past an excess. The distress advances with the distress! When can the overlap multiply a break? Should the routine steel skip against a clone? The equipped anarchy budgets an imbalance. The amateur relaxes after the verse! The batch flies behind a pigeon. How can our poison curtain an otherwise child? The reflecting discovery allies the designate wealth. A separator kids past the speaker. The arc overtone rots.");
			text.add("Morbi dictum mi et nisl <div> interdum, vel iaculis lacus suscipit. The stroke pushes the coach beneath any wood outcome. The photocopy prevails below the feat volunteer. The counsel decays beneath the burned disorder. The flute butters a postage after a misrepresented schedule. How can the dreamed baby walk? The speaking misfortune bites an override. A politician rattles against the emerging purple. A sod dries the crush into the packed burden. The warmed eye notices the alphabetical grammar. The smashing scenery chambers the sounding dominant. Why does a rattled height exit? A subsidized physicist rocks an enthusiastic keeper.The outcome noses against the departure. Why won't a temper dish an appalled visit? With a safeguard responds the biggest junk. When will the noisy stress grind against the idiosyncratic blame? How does a desire mend throughout any ripped tooth?");
			text.add("Ut eu quam non orci <div> consectetur vestibulum et scelerisque sapien. The debt destroys every refined boy behind an ethic. Whatever compound sweeps into the concealed noun. The tomato posts a helmet. The gate flowers throughout a satire. The united plague restores this sympathetic likelihood. A simulate commentator perceives a laughter against the tame metaphor. The flood composes in the startled fuse. Can a taxpayer lecture her container? The circular chooses past her typewriter.");
			text.add("Morbi accumsan leo <span> non ex tempor, congue ullamcorper urna viverra. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.");
			text.add("In quis enim a odio venenatis scelerisque dignissim sed mauris. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
			text.add("Maecenas ultrices <div> nulla nec malesuada ullamcorper.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
			text.add("Mauris mattis nisi quis <strong> rhoncus mollis. In addition to generating an entire comedy routine, the software provides additional means to make existing content funnier. One of those ways is through the Article Part menu that can insert a short, funny paragraph into an existing routine or article. Also available is the One-Liner Jokes option on the right-click menu, which presents a list of relevant one-liners in the Phrase Box for later use.First Draft 5.0 costs $149.99 and can be purchased online.");
			text.add("In auctor lorem quis eros <table> fermentum ultricies a at nibh. The tray boils under a deprived alcoholic. How can a beaten populace fork the climbing developer? The rounded imbalance expenses the spy. Your inexperienced scene showers the mystic. The scrap determines a blanket behind the wanted whole. Why does the horrified rat bell a talented swallow? The dragging alphabet noses. Next to the sophisticate tries the fascist cell. A tale catalogs the adventure. A parallel force exercises opposite an exponential soldier. The motto sleeps inside the road. A uninteresting helmet dictates near the glass. The unhappy dealer hopes. A pregnant mailbox grabs the garden next to a precious classic. The creature demands the blob.");
			text.add("Curabitur quis <div> mauris ullamcorper, ultricies orci non, porttitor diam. A chord degenerates into the based fairy. This wretched sin gasps outside the analogy. Each prerequisite waters a conscience. The superfluous hospital surnames every meal. The clique rails behind a gas! Should the highlight proclaim the restaurant? An indent flips! The gospel dresses the penny author. On top of a debate waves an incomplete stake. A screaming rainbow authorizes the farmer over a sweeping devil. The follower cruises on top of the landlord! Should the policeman frown above the guest stereotype? The biochemistry modifies a numeric tube. The unset stair ditches the prominent editorial. A prototype crawls. The alert finances the charged comfort. The guaranteed terrorist senses the hell throughout the owed attitude. The static responds opposite every sunrise. A scroll entitles our scenery beside a lifted decay. The plant wishes a barrier with the adult bomb. The ink pats the egg across your offending volume. The defect gifts the devoid vein.");
			text.add("Fusce aliquet <input> libero vel risus luctus ullamcorper.");
			text.add("Vestibulum non <div> risus sit amet lorem blandit tempus.");
			text.add("Fusce gravida <a> libero a neque cursus gravida.");
			text.add("Proin eget urna <div> tempor, ullamcorper lectus eget, elementum massa. The assumed plotter rushs toward the anatomy. Beneath the physiology despairs the table. A waiting musician leaks above the pole. The chicken patient gins the frustrated container. The ready craft farms the impractical reactionary. Can my flood host the operator? Each charge bumps against the march. The analogy enters?The static mutters? The rabbit conveys the bastard after a correct resemblance. The blade prefers the compelled straw. The specified postscript tries beside the fancy mount. Underneath the reform reigns an organic supernatural. An official buttons the theater. The pleasant toe misses the alternative. The smallish tongue charges the barrister in a confused artist. When will a frowning electron outweigh the dress company? The cheese results with a coke. Why won't the attending throat imprison the paranoid sea? Beneath the lust foams each ecology. How does the commissioned contempt protect the mate?");
			text.add("Quisque at <div> justo elementum, finibus elit ut, ultrices nibh.");
			text.add("Pellentesque <div> nec nulla vel neque tincidunt rutrum.");
			text.add("Donec dictum <title> enim nec mi pulvinar, nec consequat eros tristique. A sky deletes a curtain over the bearded parameter. A handicap escapes near the constant! The vicar dances a threshold opposite a rough limb. The architecture outcries the pat jack after the reflex. An article cruises in the wartime. How will the detailed barrel die without the bench? The heat attends behind the imperative! The steel sleeps over the shame! The smelly exponential hopes a huge anatomy. Against the jack participates a motor. The corporate tour chars an illustrated theology. The confining knowledge ices the desirable bubble. Why can't an invitation volume tailor the irate bandwagon? The brother closet pipes the indent. The fined group trails around a homosexual.");
			text.add("Vestibulum lobortis <article> diam vel erat congue pulvinar sed a tortor.");
			text.add("In non leo <td> et nibh porttitor lobortis. A pan disturbs the barrister. Its password invalidates the gospel. A silver bath rests. When will the tempting fossil escape a shade? The unsafe collective lands a populace. When will our digital threshold moan? The ice grabs this carpet. The network functions as the pro prose. The independence pressures his appointed country. How can the biting trouble hunt? Why can't an asset rail? A number meets the colleague throughout an adventurous biography. The invitation mountain solos throughout a syndicate. The orienting analogue publicizes the implied finger. The parochial alcoholic warms to another sugar. Against each worn hero towers your unsuccessful holy. A wonderful numeral caves the child. A gateway catalogs the comic throughout the akin cycle. The terror fringes an injury. When can the photo scratch the logo? My track tasks the paste. A prisoner colors. The tone elects the monochrome suspicion. The herd jams without the absent developer. Her banana enhances the competing talent next to the warm. An alcoholic pumps outside the artist! The justified poison strays next to the inhibiting ruler. A divine fools the experienced address above the singer. The shutdown swims throughout the bankrupt. The tried poison excites the ace. The pedestrian persists throughout a packed warm. Should the elephant's wealth appear throughout a tactic? Under every storm degenerates the perpetual bankrupt.");
			text.add("Donec hendrerit <th> lacus semper justo bibendum fermentum. The lousy lung stirs across the pedestrian homosexual. A vocal distresses the tile. How does an ineffective disease refresh the imperial rage? The complicate potato edges the derived nostalgia.");
			text.add("Sed tempus nunc <div> interdum neque sodales, at mollis magna convallis.");
			text.add("Aliquam efficitur sem quis facilisis aliquam. <div> Why won't the horizon progress above a crash friendship? How will the fine muck break outside the boy? The page enters the graffito. The coal shortens the bump into a demolished article. A chemical thinks opposite a vegetable! How does a pace withdraw? The pill leaks across the secretary. Whatever ward twins every passionate weapon. An orientated moderate bringings a strict wine. Why won't the toy solo? Your diagonal mistake strains against a diagonal. Can the pan tutorial coast? The delicate physics degenerates against the platform. How does the lane studio document the unchanged hierarchy? When can an illiterate violin supervise a blind resource? The grouped gun walks against our screen. The executive juice scratches outside every wed bean. Why does a some guard prepare a stamped hash? The salesman faints over the rending uncle. A perfect thumb turns an average. The holder aids the spectacular throughout my cancelled weekday. Below the manual sigh stares the plastered deed. Why can't the numerous workshop thirst? The removed norm loves a charter. Why won't the proof file an opera? An overwhelmed limb doses a tailor. How does the foreigner puzzle inside the deciding coal? Will the cozy coach thirst throughout a principal? Next to the darling tooth sleeps the neighbor highway. When can the comparable prince flower? Should a decimal racket change against the cuckoo? The privileged earth punts near the buyer. An appeal holds a stare. The starved burst serves as the scotch. How does the creative blackmail rule near the altogether? Why does his praise revert? The beginner determines the mumble.");
			text.add("Proin <div> blandit ante at molestie finibus.");
			text.add("Etiam quis lorem <tr> laoreet, malesuada lorem in, tristique sem.");
			text.add("Maecenas vitae orci <div> non dui ultrices posuere vulputate at elit. Why can't a south toe the line? A borderline beams beside the scheme. Can the duplicate rebuild the coincidence? The tooth destroys a raw powder into the tribe. How will the uncommon article stretch after the theology? The tolerant blessed slashes an ass.");
			text.add("Mauris blandit <div> elit sit amet tellus dignissim, eget maximus sem dignissim.");
			text.add("Morbi in dui semper, <img> sagittis augue in, elementum lorem.");
			text.add("Vivamus ut lacus <div> finibus, dictum neque interdum, tincidunt eros. Why does the axiom aim a cathedral purpose? An archive opens my orbital below the dangerous misprint. The sixty filter prices her metric lesbian. A world appears in the enemy listener. When will a mailed system interrupt the attendant? The milk detail frightens the improving warehouse.");
			text.add("Duis vestibulum ipsum <div> at dui tincidunt, semper eleifend est congue.");
			text.add("Lorem ipsum dolor sit <div> amet, consectetur adipiscing elit.");
		}
		else{
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
		}
		return text;
	}

}