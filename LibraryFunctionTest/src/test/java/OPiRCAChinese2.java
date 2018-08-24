import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCAChinese2 {

	//Step 4
	By OPiRCAStep4TableHeading1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[1]/th[1]");
	By OPiRCAStep4TableHeading2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[1]/th[2]");
	By OPiRCAStep4TableHeading3 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[1]/th[3]");
	By OPiRCAStep4TableRow1Column1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[1]");
	By OPiRCAStep4TableRow2Heading = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td/strong");
	By OPiRCAStep4TableRow2Label1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td/label[1]");
	By OPiRCAStep4TableRow2Label2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td/label[2]");
	By OPiRCAStep4TableRow2Label3 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td/label[3]");
	By OPiRCAStep4TableRow3Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[4]/td/label");
	By OPiRCAStep4TableRow3Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[4]/td/textarea");
	By OPiRCAStep4TableRow4 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[5]/td[1]");
	By OPiRCAStep4TableRow5Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[6]/td/label");
	By OPiRCAStep4TableRow5Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[6]/td/textarea");
	By OPiRCAStep4TableRow6 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[7]/td[1]");
	By OPiRCAStep4TableRow7Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[8]/td/label");
	By OPiRCAStep4TableRow7Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[8]/td/textarea");
	By OPiRCAStep4TableRow8 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[9]/td[1]");
	By OPiRCAStep4TableRow9Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[10]/td/label");
	By OPiRCAStep4TableRow9Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[10]/td/textarea");
	By OPiRCAStep4TableRow10 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[11]/td[1]");
	By OPiRCAStep4TableRow11Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[12]/td/label");
	By OPiRCAStep4TableRow11Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[12]/td/textarea");
	By OPiRCAStep4TableRow12 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[13]/td[1]");
	By OPiRCAStep4TableRow13Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[14]/td/label");
	By OPiRCAStep4TableRow13Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[14]/td/textarea");
	By OPiRCAStep4TableRow14 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[15]/td[1]");
	By OPiRCAStep4TableRow15Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[16]/td/label");
	By OPiRCAStep4TableRow15Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[16]/td/textarea");
	By OPiRCAStep4TableRow16 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[17]/td[1]");
	By OPiRCAStep4TableRow17Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[18]/td/label");
	By OPiRCAStep4TableRow17Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[18]/td/textarea");
	By OPiRCAStep4TableRow18 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[19]/td[1]");
	By OPiRCAStep4TableRow19Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[20]/td/label");
	By OPiRCAStep4TableRow19Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[20]/td/textarea");
	By OPiRCAStep4TableRow20 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[21]/td[1]");
	By OPiRCAStep4TableRow21Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[22]/td/label");
	By OPiRCAStep4TableRow21Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[22]/td/textarea");
	By OPiRCAStep4TableRow22 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[23]/td[1]");
	By OPiRCAStep4TableRow23Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[24]/td/label");
	By OPiRCAStep4TableRow23Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[24]/td/textarea");
	By OPiRCAStep4TableRow24 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[25]/td[1]");
	By OPiRCAStep4TableRow25Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[26]/td/label");
	By OPiRCAStep4TableRow25Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[26]/td/textarea");
	By OPiRCAStep4TableRow26 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[27]/td[1]");
	By OPiRCAStep4TableRow27Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[28]/td/label");
	By OPiRCAStep4TableRow27Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[28]/td/textarea");
	By OPiRCAStep4TableRow28 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[29]/td[1]");
	By OPiRCAStep4TableRow29Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[30]/td/label");
	By OPiRCAStep4TableRow29Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[30]/td/textarea");
	By OPiRCAStep4TableRow30 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[31]/td[1]");
	By OPiRCAStep4TableRow31Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[32]/td/label");
	By OPiRCAStep4TableRow31Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[32]/td/textarea");
	By OPiRCAStep4TableRow32 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[33]/td[1]");
	By OPiRCAStep4TableRow33Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[34]/td/label");
	By OPiRCAStep4TableRow33Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[34]/td/textarea");
	By OPiRCAStep4TableRow34 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[35]/td[1]");
	By OPiRCAStep4TableRow35Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[36]/td/label");
	By OPiRCAStep4TableRow35Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[36]/td/textarea");
	By OPiRCAStep4TableRow36 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[37]/td[1]");
	By OPiRCAStep4TableRow37Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[38]/td/label");
	By OPiRCAStep4TableRow37Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[38]/td/textarea");
	By OPiRCAStep4TableRow38 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[39]/td[1]");
	By OPiRCAStep4TableRow39Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[40]/td/label");
	By OPiRCAStep4TableRow39Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[40]/td/textarea");
	By OPiRCAStep4TableRow40 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[41]/td[1]");
	By OPiRCAStep4TableRow41Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[42]/td/label");
	By OPiRCAStep4TableRow41Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[42]/td/textarea");
	By OPiRCAStep4TableRow42 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[43]/td[1]");
	By OPiRCAStep4TableRow43Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[44]/td/label");
	By OPiRCAStep4TableRow43Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[44]/td/textarea");
	By OPiRCAStep4TableRow44 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[45]/td[1]");
	By OPiRCAStep4TableRow45Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[46]/td/label");
	By OPiRCAStep4TableRow45Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[46]/td/textarea");
	By OPiRCAStep4TableRow46 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[47]/td[1]");
	By OPiRCAStep4TableRow47Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[48]/td/label");
	By OPiRCAStep4TableRow47Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[48]/td/textarea");
	By OPiRCAStep4TableRow48 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[49]/td[1]");
	By OPiRCAStep4TableRow49Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[50]/td/label");
	By OPiRCAStep4TableRow49Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[50]/td/textarea");
	By OPiRCAStep4TableRow50 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[51]/td[1]");
	By OPiRCAStep4TableRow51Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[52]/td/label");
	By OPiRCAStep4TableRow51Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[52]/td/textarea");
	By OPiRCAStep4TableRow52 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[53]/td[1]");
	By OPiRCAStep4TableRow53Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[54]/td/label");
	By OPiRCAStep4TableRow53Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[54]/td/textarea");
	By OPiRCAStep4TableRow54 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[55]/td[1]");
	By OPiRCAStep4TableRow55Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[56]/td/label");
	By OPiRCAStep4TableRow55Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[56]/td/textarea");
	By OPiRCAStep4TableRow56 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[57]/td[1]");
	By OPiRCAStep4TableRow57Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[58]/td/label");
	By OPiRCAStep4TableRow57Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[58]/td/textarea");
	By OPiRCAStep4TableRow58 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[59]/td[1]");
	By OPiRCAStep4TableRow59Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[60]/td/label");
	By OPiRCAStep4TableRow59Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[60]/td/textarea");
	By OPiRCAStep4TableRow60 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[61]/td[1]");
	By OPiRCAStep4TableRow61Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[62]/td/label");
	By OPiRCAStep4TableRow61Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[62]/td/textarea");
	By OPiRCAStep4TableRow62 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[63]/td[1]");
	By OPiRCAStep4TableRow63Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[64]/td/label");
	By OPiRCAStep4TableRow63Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[64]/td/textarea");
	By OPiRCAStep4TableRow64 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[65]/td[1]");
	By OPiRCAStep4TableRow65Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[66]/td/label");
	By OPiRCAStep4TableRow65Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[66]/td/textarea");
	By OPiRCAStep4TableRow66 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[67]/td[1]");
	By OPiRCAStep4TableRow67Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[68]/td/label");
	By OPiRCAStep4TableRow67Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[68]/td/textarea");
	By OPiRCAStep4TableRow68 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[69]/td[1]");
	By OPiRCAStep4TableRow69Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[70]/td/label");
	By OPiRCAStep4TableRow69Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[70]/td/textarea");
	By OPiRCAStep4TableRow70 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[71]/td[1]");
	By OPiRCAStep4TableRow71Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[72]/td/label");
	By OPiRCAStep4TableRow71Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[72]/td/textarea");
	By OPiRCAStep4TableRow72 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[73]/td[1]");
	By OPiRCAStep4TableRow73Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[74]/td/label");
	By OPiRCAStep4TableRow73Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[74]/td/textarea");
	By OPiRCAStep4TableRow74 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[75]/td[1]");
	By OPiRCAStep4TableRow75Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[76]/td/label");
	By OPiRCAStep4TableRow75Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[76]/td/textarea");
	By OPiRCAStep4TableRow76 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[77]/td[1]");
	By OPiRCAStep4TableRow77Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[78]/td/label");
	By OPiRCAStep4TableRow77Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[78]/td/textarea");
	By OPiRCAStep4TableRow78 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[79]/td[1]");
	By OPiRCAStep4TableRow79Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[80]/td/label");
	By OPiRCAStep4TableRow79Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[80]/td/textarea");
	By OPiRCAStep4TableRow80 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[81]/td[1]");
	By OPiRCAStep4TableRow81Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[82]/td/label");
	By OPiRCAStep4TableRow81Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[82]/td/textarea");
	By OPiRCAStep4TableRow82 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[83]/td[1]");
	By OPiRCAStep4TableRow83Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[84]/td/label");
	By OPiRCAStep4TableRow83Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[84]/td/textarea");
	By OPiRCAStep4TableRow84 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[85]/td[1]");
	By OPiRCAStep4TableRow85Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[86]/td/label");
	By OPiRCAStep4TableRow85Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[86]/td/textarea");
	By OPiRCAStep4TableRow86 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[87]/td[1]");
	By OPiRCAStep4TableRow87Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[88]/td/label");
	By OPiRCAStep4TableRow87Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[88]/td/textarea");
	By OPiRCAStep4TableRow88 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[89]/td[1]");
	By OPiRCAStep4TableRow89Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[90]/td/label");
	By OPiRCAStep4TableRow89Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[90]/td/textarea");
	By OPiRCAStep4TableRow90 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[91]/td[1]");
	By OPiRCAStep4TableRow91Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[92]/td/label");
	By OPiRCAStep4TableRow91Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[92]/td/textarea");
	By OPiRCAStep4TableRow92 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[93]/td[1]");
	By OPiRCAStep4TableRow93Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[94]/td/label");
	By OPiRCAStep4TableRow93Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[94]/td/textarea");
	By OPiRCAStep4TableRow94 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[95]/td[1]");
	By OPiRCAStep4TableRow95Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[96]/td/label");
	By OPiRCAStep4TableRow95Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[96]/td/textarea");
	By OPiRCAStep4TableRow96 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[97]/td[1]");
	By OPiRCAStep4TableRow97Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[98]/td/label");
	By OPiRCAStep4TableRow97Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[98]/td/textarea");
	By OPiRCAStep4TableRow98 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[99]/td[1]");
	By OPiRCAStep4TableRow99Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[100]/td/label");
	By OPiRCAStep4TableRow99Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[100]/td/textarea");
	By OPiRCAStep4TableRow100 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[101]/td[1]");
	By OPiRCAStep4TableRow101Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[102]/td/label");
	By OPiRCAStep4TableRow101Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[102]/td/textarea");
	By OPiRCAStep4TableRow102 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[103]/td[1]");
	By OPiRCAStep4TableRow103Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[104]/td/label");
	By OPiRCAStep4TableRow103Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[104]/td/textarea");
	By OPiRCAStep4TableRow104 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[105]/td[1]");
	By OPiRCAStep4TableRow105Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[106]/td/label");
	By OPiRCAStep4TableRow105Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[106]/td/textarea");
	By OPiRCAStep4TableRow106 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[107]/td[1]");
	By OPiRCAStep4TableRow107Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[108]/td/label");
	By OPiRCAStep4TableRow107Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[108]/td/textarea");
	By OPiRCAStep4TableRow108 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[109]/td[1]");
	By OPiRCAStep4TableRow109Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[110]/td/label");
	By OPiRCAStep4TableRow109Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[110]/td/textarea");
	By OPiRCAStep4TableRow110 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[111]/td[1]");
	By OPiRCAStep4TableRow111Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[112]/td/label");
	By OPiRCAStep4TableRow111Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[112]/td/textarea");
	By OPiRCAStep4TableRow112 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[113]/td[1]");
	By OPiRCAStep4TableRow113Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[114]/td/label");
	By OPiRCAStep4TableRow113Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[114]/td/textarea");
	By OPiRCAStep4TableRow114 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[115]/td[1]");
	By OPiRCAStep4TableRow115Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[116]/td/label");
	By OPiRCAStep4TableRow115Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[116]/td/textarea");
	By OPiRCAStep4TableRow116 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[117]/td[1]");
	By OPiRCAStep4TableRow117Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[118]/td/label");
	By OPiRCAStep4TableRow117Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[118]/td/textarea");
	By OPiRCAStep4TableRow118 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[119]/td[1]");
	By OPiRCAStep4TableRow119Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[120]/td/label");
	By OPiRCAStep4TableRow119Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[120]/td/textarea");
	By OPiRCAStep4TableRow120 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[121]/td[1]");
	By OPiRCAStep4TableRow121Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[122]/td/label");
	By OPiRCAStep4TableRow121Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[122]/td/textarea");
	By OPiRCAStep4TableRow122 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[123]/td[1]");
	By OPiRCAStep4TableRow123Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[124]/td/label");
	By OPiRCAStep4TableRow123Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[124]/td/textarea");
	By OPiRCAStep4TableRow124 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[125]/td[1]");
	By OPiRCAStep4TableRow125Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[126]/td/label");
	By OPiRCAStep4TableRow125Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[126]/td/textarea");
	By OPiRCAStep4TableRow126 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[127]/td[1]");
	By OPiRCAStep4TableRow127Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[128]/td/label");
	By OPiRCAStep4TableRow127Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[128]/td/textarea");
	By OPiRCAStep4TableRow128 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[129]/td[1]");
	By OPiRCAStep4TableRow129Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[130]/td/label");
	By OPiRCAStep4TableRow129Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[130]/td/textarea");
	By OPiRCAStep4TableRow130 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[131]/td[1]");
	By OPiRCAStep4TableRow131Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[132]/td/label");
	By OPiRCAStep4TableRow131Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[132]/td/textarea");
	By OPiRCAStep4TableRow132 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[133]/td[1]");
	By OPiRCAStep4TableRow133Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[134]/td/label");
	By OPiRCAStep4TableRow133Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[134]/td/textarea");
	By OPiRCAStep4TableRow134 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[135]/td[1]");
	By OPiRCAStep4TableRow135Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[136]/td/label");
	By OPiRCAStep4TableRow135Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[136]/td/textarea");
	By OPiRCAStep4TableRow136 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[137]/td[1]");
	By OPiRCAStep4TableRow137Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[138]/td/label");
	By OPiRCAStep4TableRow137Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[138]/td/textarea");
	By OPiRCAStep4TableRow138 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[139]/td[1]");
	By OPiRCAStep4TableRow139Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[140]/td/label");
	By OPiRCAStep4TableRow139Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[140]/td/textarea");
	By OPiRCAStep4TableRow140 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[141]/td[1]");
	By OPiRCAStep4TableRow141Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[142]/td/label");
	By OPiRCAStep4TableRow141Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[142]/td/textarea");
	By OPiRCAStep4TableRow142 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[143]/td[1]");
	By OPiRCAStep4TableRow143Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[144]/td/label");
	By OPiRCAStep4TableRow143Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[144]/td/textarea");
	By OPiRCAStep4TableRow144 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[145]/td[1]");
	By OPiRCAStep4TableRow145Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[146]/td/label");
	By OPiRCAStep4TableRow145Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[146]/td/textarea");
	By OPiRCAStep4TableRow146 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[147]/td[1]");
	By OPiRCAStep4TableRow147Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[148]/td/label");
	By OPiRCAStep4TableRow147Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[148]/td/textarea");
	By OPiRCAStep4TableRow148 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[149]/td[1]");
	By OPiRCAStep4TableRow149Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[150]/td/label");
	By OPiRCAStep4TableRow149Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[150]/td/textarea");
	By OPiRCAStep4TableRow150 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[151]/td[1]");
	By OPiRCAStep4TableRow151Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[152]/td/label");
	By OPiRCAStep4TableRow151Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[152]/td/textarea");
	By OPiRCAStep4TableRow152 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[153]/td[1]");
	By OPiRCAStep4TableRow153Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[154]/td/label");
	By OPiRCAStep4TableRow153Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[154]/td/textarea");
	By OPiRCAStep4TableRow154 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[155]/td[1]");
	By OPiRCAStep4TableRow155Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[156]/td/label");
	By OPiRCAStep4TableRow155Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[156]/td/textarea");
	By OPiRCAStep4TableRow156 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[157]/td[1]");
	By OPiRCAStep4TableRow157Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[158]/td/label");
	By OPiRCAStep4TableRow157Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[158]/td/textarea");
	By OPiRCAStep4TableRow158 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[159]/td[1]");
	By OPiRCAStep4TableRow159Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[160]/td/label");
	By OPiRCAStep4TableRow159Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[160]/td/textarea");
	By OPiRCAStep4TableRow160 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[161]/td[1]");
	By OPiRCAStep4TableRow161Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[162]/td/label");
	By OPiRCAStep4TableRow161Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[162]/td/textarea");
	By OPiRCAStep4TableRow162 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[163]/td[1]");
	By OPiRCAStep4TableRow163Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[164]/td/label");
	By OPiRCAStep4TableRow163Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[164]/td/textarea");
	By OPiRCAStep4TableRow164 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[165]/td[1]");
	By OPiRCAStep4TableRow165Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[166]/td/label");
	By OPiRCAStep4TableRow165Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[166]/td/textarea");
	By OPiRCAStep4TableRow166 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[167]/td[1]");
	By OPiRCAStep4TableRow167Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[168]/td/label");
	By OPiRCAStep4TableRow167Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[168]/td/textarea");
	By OPiRCAStep4TableRow168 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[169]/td[1]");
	By OPiRCAStep4TableRow169Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[170]/td/label");
	By OPiRCAStep4TableRow169Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[170]/td/textarea");
	By OPiRCAStep4TableRow170 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[171]/td[1]");
	By OPiRCAStep4TableRow171Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[172]/td/label");
	By OPiRCAStep4TableRow171Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[172]/td/textarea");
	By OPiRCAStep4TableRow172 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[173]/td[1]");
	By OPiRCAStep4TableRow173Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[174]/td/label");
	By OPiRCAStep4TableRow173Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[174]/td/textarea");
	By OPiRCAStep4TableRow174 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[175]/td[1]");
	By OPiRCAStep4TableRow175Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[176]/td/label");
	By OPiRCAStep4TableRow175Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[176]/td/textarea");
	By OPiRCAStep4TableRow176 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[177]/td[1]");
	By OPiRCAStep4TableRow177Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[178]/td/label");
	By OPiRCAStep4TableRow177Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[178]/td/textarea");
	By OPiRCAStep4TableRow178 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[179]/td[1]");
	By OPiRCAStep4TableRow179Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[180]/td/label");
	By OPiRCAStep4TableRow179Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[180]/td/textarea");
	By OPiRCAStep4TableRow180 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[181]/td[1]");
	By OPiRCAStep4TableRow181Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[182]/td/label");
	By OPiRCAStep4TableRow181Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[182]/td/textarea");
	By OPiRCAStep4TableRow182 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[183]/td[1]");
	By OPiRCAStep4TableRow183Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[184]/td/label");
	By OPiRCAStep4TableRow183Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[184]/td/textarea");
	By OPiRCAStep4TableRow184 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[185]/td[1]");
	By OPiRCAStep4TableRow185Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[186]/td/label");
	By OPiRCAStep4TableRow185Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[186]/td/textarea");
	By OPiRCAStep4TableRow186 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[187]/td[1]");
	By OPiRCAStep4TableRow187Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[188]/td/label");
	By OPiRCAStep4TableRow187Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[188]/td/textarea");
	By OPiRCAStep4TableRow188 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[189]/td[1]");
	By OPiRCAStep4TableRow189Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[190]/td/label");
	By OPiRCAStep4TableRow189Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[190]/td/textarea");
	By OPiRCAStep4TableRow190 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[191]/td[1]");
	By OPiRCAStep4TableRow191Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[192]/td/label");
	By OPiRCAStep4TableRow191Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[192]/td/textarea");
	By OPiRCAStep4TableRow192 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[193]/td[1]");
	By OPiRCAStep4TableRow193Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[194]/td/label");
	By OPiRCAStep4TableRow193Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[194]/td/textarea");
	By OPiRCAStep4TableRow194 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[195]/td[1]");
	By OPiRCAStep4TableRow195Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[196]/td/label");
	By OPiRCAStep4TableRow195Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[196]/td/textarea");
	By OPiRCAStep4TableRow196 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[197]/td[1]");
	By OPiRCAStep4TableRow197Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[198]/td/label");
	By OPiRCAStep4TableRow197Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[198]/td/textarea");
	By OPiRCAStep4TableRow198 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[199]/td[1]");
	By OPiRCAStep4TableRow199Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[200]/td/label");
	By OPiRCAStep4TableRow199Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[200]/td/textarea");
	By OPiRCAStep4TableRow200 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[201]/td[1]");
	By OPiRCAStep4TableRow201Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[202]/td/label");
	By OPiRCAStep4TableRow201Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[202]/td/textarea");
	By OPiRCAStep4TableRow202 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[203]/td[1]");
	By OPiRCAStep4TableRow203Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[204]/td/label");
	By OPiRCAStep4TableRow203Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[204]/td/textarea");
	By OPiRCAStep4TableRow204 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[205]/td[1]");
	By OPiRCAStep4TableRow205Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[206]/td/label");
	By OPiRCAStep4TableRow205Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[206]/td/textarea");
	By OPiRCAStep4TableRow206 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[207]/td[1]");
	By OPiRCAStep4TableRow207Label = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[208]/td/label");
	By OPiRCAStep4TableRow207Field = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[208]/td/textarea");
	//HML
	By OPiRCAStep4TableRow1HighBox = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[3]/fieldset/div/div[1]/label");
	By OPiRCAStep4TableRow4MediumBox = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[5]/td[3]/fieldset/div/div[2]/label");
	By OPiRCAStep4TableRow6LowBox = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[7]/td[3]/fieldset/div/div[3]/label");

	//Step 5
	By OPiRCAStep5TableRow1Column2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[2]");
	By OPiRCAStep5TableRow1Column3 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[3]/div/input");
	By OPiRCAStep5TableRow2Column1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td[1]");
	By OPiRCAStep5TableRow2Column2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td[2]");
	By OPiRCAStep5TableRow3Column2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[4]/td[2]");
	By OPiRCAStep5TableRow4Column2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[5]/td[2]");
	By OPiRCAStep5TableRow5Column1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[6]/td[1]");
	By OPiRCAStep5TableRow5Column2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[6]/td[2]");
	By OPiRCAStep5TableRow6Column2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[7]/td[2]");

	//Report Tab
	//Table 1
	By OPiRCAReportTabTable1Heading = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/thead/tr/th");
	By OPiRCAReportTabTable1Row1 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable1Row2 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable1Row3Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable1Row3Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[3]/td[3]");
	By OPiRCAReportTabTable1Row4 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[4]/td[1]");
	By OPiRCAReportTabTable1Row5 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[5]/td[1]");
	By OPiRCAReportTabTable1Row6 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[6]/td[1]");
	By OPiRCAReportTabTable1Row7 = By.xpath(".//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[7]/td[1]");
	//Table 2
	By OPiRCAReportTabTable2Heading = By.xpath(".//*[@id='module-opa-rpt']/div[2]/table/thead/tr/th");
	By OPiRCAReportTabTable2Row1 = By.xpath(".//*[@id='module-opa-rpt']/div[2]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable2Row2 = By.xpath(".//*[@id='module-opa-rpt']/div[2]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable2Row3 = By.xpath(".//*[@id='module-opa-rpt']/div[2]/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable2Row4 = By.xpath(".//*[@id='module-opa-rpt']/div[2]/table/tbody/tr[4]/td[1]");
	//Table 3
	By OPiRCAReportTabTable3Title = By.xpath(".//*[@id='module-opa-rpt']/div[3]");
	By OPiRCAReportTabTable3Heading1 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[1]/thead/tr/th[1]");
	By OPiRCAReportTabTable3Heading2 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[1]/thead/tr/th[2]");
	By OPiRCAReportTabTable3Heading3 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[1]/thead/tr/th[3]");
	By OPiRCAReportTabTable3Row1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[1]/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable3Row1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[1]/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable3Row1Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[1]/tbody/tr[1]/td[3]");
	By OPiRCAReportTabTable3Heading4 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[2]/tbody/tr[1]/th");
	By OPiRCAReportTabTable3Row2 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[2]/tbody/tr[2]/td");
	By OPiRCAReportTabTable3Row3 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[2]/tbody/tr[3]/td");
	By OPiRCAReportTabTable3Row4 = By.xpath(".//*[@id='module-opa-rpt']/div[4]/table[2]/tbody/tr[4]/td");
	//Table 4
	By OPiRCAReportTabTable4Heading1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/thead/tr/th[1]");
	By OPiRCAReportTabTable4Heading2 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/thead/tr/th[2]");
	By OPiRCAReportTabTable4Heading3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/thead/tr/th[3]");
	By OPiRCAReportTabTable4Row1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable4Row1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable4Row1Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[1]/td[3]");
	By OPiRCAReportTabTable4Row2Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable4Row2Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[2]/td[2]");
	By OPiRCAReportTabTable4Row2Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[2]/td[3]");
	By OPiRCAReportTabTable4Row3Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable4Row3Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[3]/td[3]");
	By OPiRCAReportTabTable4Row4Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[4]/td[1]");
	By OPiRCAReportTabTable4Row4Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[4]/td[3]");
	By OPiRCAReportTabTable4Row5Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[5]/td[1]");
	By OPiRCAReportTabTable4Row5Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[5]/td[3]");
	By OPiRCAReportTabTable4Row6Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[6]/td[1]");
	By OPiRCAReportTabTable4Row6Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[6]/td[3]");
	By OPiRCAReportTabTable4Row7Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[7]/td[1]");
	By OPiRCAReportTabTable4Row7Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[7]/td[3]");
	By OPiRCAReportTabTable4Row8Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[8]/td[1]");
	By OPiRCAReportTabTable4Row8Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[8]/td[3]");
	By OPiRCAReportTabTable4Row9Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[9]/td[1]");
	By OPiRCAReportTabTable4Row9Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[9]/td[3]");
	By OPiRCAReportTabTable4Row10Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[10]/td[1]");
	By OPiRCAReportTabTable4Row10Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[10]/td[3]");
	By OPiRCAReportTabTable4Row11Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[11]/td[1]");
	By OPiRCAReportTabTable4Row11Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[11]/td[3]");
	By OPiRCAReportTabTable4Row12Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[12]/td[1]");
	By OPiRCAReportTabTable4Row12Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[12]/td[3]");
	By OPiRCAReportTabTable4Row13Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[13]/td[1]");
	By OPiRCAReportTabTable4Row13Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[13]/td[3]");
	By OPiRCAReportTabTable4Row14Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[14]/td[1]");
	By OPiRCAReportTabTable4Row14Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[14]/td[3]");
	By OPiRCAReportTabTable4Row15Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[15]/td[1]");
	By OPiRCAReportTabTable4Row15Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[15]/td[3]");
	By OPiRCAReportTabTable4Row16Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[16]/td[1]");
	By OPiRCAReportTabTable4Row16Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[16]/td[3]");
	By OPiRCAReportTabTable4Row17Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[17]/td[1]");
	By OPiRCAReportTabTable4Row17Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[17]/td[3]");
	By OPiRCAReportTabTable4Row18Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[18]/td[1]");
	By OPiRCAReportTabTable4Row18Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[18]/td[3]");
	By OPiRCAReportTabTable4Row19Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[19]/td[1]");
	By OPiRCAReportTabTable4Row19Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[19]/td[3]");
	By OPiRCAReportTabTable4Row20Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[20]/td[1]");
	By OPiRCAReportTabTable4Row20Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[20]/td[3]");
	By OPiRCAReportTabTable4Row21Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[21]/td[1]");
	By OPiRCAReportTabTable4Row21Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[21]/td[3]");
	By OPiRCAReportTabTable4Row22Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[22]/td[1]");
	By OPiRCAReportTabTable4Row22Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[22]/td[3]");
	By OPiRCAReportTabTable4Row23Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[23]/td[1]");
	By OPiRCAReportTabTable4Row23Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[23]/td[3]");
	By OPiRCAReportTabTable4Row24Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[24]/td[1]");
	By OPiRCAReportTabTable4Row24Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[24]/td[3]");
	By OPiRCAReportTabTable4Row25Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[25]/td[1]");
	By OPiRCAReportTabTable4Row25Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[25]/td[3]");
	By OPiRCAReportTabTable4Row26Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[26]/td[1]");
	By OPiRCAReportTabTable4Row26Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[26]/td[3]");
	By OPiRCAReportTabTable4Row27Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[27]/td[1]");
	By OPiRCAReportTabTable4Row27Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[27]/td[3]");
	By OPiRCAReportTabTable4Row28Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[28]/td[1]");
	By OPiRCAReportTabTable4Row28Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[28]/td[3]");
	By OPiRCAReportTabTable4Row29Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[29]/td[1]");
	By OPiRCAReportTabTable4Row29Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[29]/td[3]");
	By OPiRCAReportTabTable4Row30Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[30]/td[1]");
	By OPiRCAReportTabTable4Row30Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[30]/td[3]");
	By OPiRCAReportTabTable4Row31Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[31]/td[1]");
	By OPiRCAReportTabTable4Row31Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[31]/td[3]");
	By OPiRCAReportTabTable4Row32Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[32]/td[1]");
	By OPiRCAReportTabTable4Row32Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[32]/td[3]");
	By OPiRCAReportTabTable4Row33Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[33]/td[1]");
	By OPiRCAReportTabTable4Row33Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[33]/td[3]");
	By OPiRCAReportTabTable4Row34Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[34]/td[1]");
	By OPiRCAReportTabTable4Row34Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[34]/td[3]");
	By OPiRCAReportTabTable4Row35Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[35]/td[1]");
	By OPiRCAReportTabTable4Row35Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[35]/td[3]");
	By OPiRCAReportTabTable4Row36Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[36]/td[1]");
	By OPiRCAReportTabTable4Row36Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[36]/td[3]");
	By OPiRCAReportTabTable4Row37Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[37]/td[1]");
	By OPiRCAReportTabTable4Row37Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[37]/td[3]");
	By OPiRCAReportTabTable4Row38Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[38]/td[1]");
	By OPiRCAReportTabTable4Row38Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[38]/td[3]");
	By OPiRCAReportTabTable4Row39Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[39]/td[1]");
	By OPiRCAReportTabTable4Row39Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[39]/td[3]");
	By OPiRCAReportTabTable4Row40Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[40]/td[1]");
	By OPiRCAReportTabTable4Row40Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[40]/td[3]");
	By OPiRCAReportTabTable4Row41Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[41]/td[1]");
	By OPiRCAReportTabTable4Row41Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[41]/td[3]");
	By OPiRCAReportTabTable4Row42Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[42]/td[1]");
	By OPiRCAReportTabTable4Row42Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[42]/td[3]");
	By OPiRCAReportTabTable4Row43Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[43]/td[1]");
	By OPiRCAReportTabTable4Row43Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[43]/td[3]");
	By OPiRCAReportTabTable4Row44Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[44]/td[1]");
	By OPiRCAReportTabTable4Row44Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[44]/td[3]");
	By OPiRCAReportTabTable4Row45Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[45]/td[1]");
	By OPiRCAReportTabTable4Row45Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[45]/td[3]");
	By OPiRCAReportTabTable4Row46Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[46]/td[1]");
	By OPiRCAReportTabTable4Row46Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[46]/td[3]");
	By OPiRCAReportTabTable4Row47Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[47]/td[1]");
	By OPiRCAReportTabTable4Row47Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[47]/td[3]");
	By OPiRCAReportTabTable4Row48Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[48]/td[1]");
	By OPiRCAReportTabTable4Row48Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[48]/td[3]");
	By OPiRCAReportTabTable4Row49Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[49]/td[1]");
	By OPiRCAReportTabTable4Row49Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[49]/td[3]");
	By OPiRCAReportTabTable4Row50Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[50]/td[1]");
	By OPiRCAReportTabTable4Row50Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[50]/td[3]");
	By OPiRCAReportTabTable4Row51Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[51]/td[1]");
	By OPiRCAReportTabTable4Row51Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[51]/td[3]");
	By OPiRCAReportTabTable4Row52Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[52]/td[1]");
	By OPiRCAReportTabTable4Row52Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[52]/td[2]");
	By OPiRCAReportTabTable4Row52Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[52]/td[3]");
	By OPiRCAReportTabTable4Row53Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[53]/td[1]");
	By OPiRCAReportTabTable4Row53Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[53]/td[3]");
	By OPiRCAReportTabTable4Row54Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[54]/td[1]");
	By OPiRCAReportTabTable4Row54Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[54]/td[3]");
	By OPiRCAReportTabTable4Row55Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[55]/td[1]");
	By OPiRCAReportTabTable4Row55Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[55]/td[3]");
	By OPiRCAReportTabTable4Row56Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[56]/td[1]");
	By OPiRCAReportTabTable4Row56Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[56]/td[3]");
	By OPiRCAReportTabTable4Row57Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[57]/td[1]");
	By OPiRCAReportTabTable4Row57Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[57]/td[3]");
	By OPiRCAReportTabTable4Row58Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[58]/td[1]");
	By OPiRCAReportTabTable4Row58Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[58]/td[3]");
	By OPiRCAReportTabTable4Row59Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[59]/td[1]");
	By OPiRCAReportTabTable4Row59Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[59]/td[3]");
	By OPiRCAReportTabTable4Row60Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[60]/td[1]");
	By OPiRCAReportTabTable4Row60Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[60]/td[3]");
	By OPiRCAReportTabTable4Row61Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[61]/td[1]");
	By OPiRCAReportTabTable4Row61Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[61]/td[3]");
	By OPiRCAReportTabTable4Row62Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[62]/td[1]");
	By OPiRCAReportTabTable4Row62Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[62]/td[3]");
	By OPiRCAReportTabTable4Row63Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[63]/td[1]");
	By OPiRCAReportTabTable4Row63Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[63]/td[3]");
	By OPiRCAReportTabTable4Row64Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[64]/td[1]");
	By OPiRCAReportTabTable4Row64Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[64]/td[3]");
	By OPiRCAReportTabTable4Row65Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[65]/td[1]");
	By OPiRCAReportTabTable4Row65Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[65]/td[3]");
	By OPiRCAReportTabTable4Row66Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[66]/td[1]");
	By OPiRCAReportTabTable4Row66Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[66]/td[3]");
	By OPiRCAReportTabTable4Row67Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[67]/td[1]");
	By OPiRCAReportTabTable4Row67Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[67]/td[3]");
	By OPiRCAReportTabTable4Row68Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[68]/td[1]");
	By OPiRCAReportTabTable4Row68Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[68]/td[3]");
	By OPiRCAReportTabTable4Row69Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[69]/td[1]");
	By OPiRCAReportTabTable4Row69Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[69]/td[3]");
	By OPiRCAReportTabTable4Row70Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[70]/td[1]");
	By OPiRCAReportTabTable4Row70Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[70]/td[3]");
	By OPiRCAReportTabTable4Row71Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[71]/td[1]");
	By OPiRCAReportTabTable4Row71Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[71]/td[3]");
	By OPiRCAReportTabTable4Row72Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[72]/td[1]");
	By OPiRCAReportTabTable4Row72Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[72]/td[3]");
	By OPiRCAReportTabTable4Row73Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[73]/td[1]");
	By OPiRCAReportTabTable4Row73Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[73]/td[3]");
	By OPiRCAReportTabTable4Row74Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[74]/td[1]");
	By OPiRCAReportTabTable4Row74Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[74]/td[3]");
	By OPiRCAReportTabTable4Row75Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[75]/td[1]");
	By OPiRCAReportTabTable4Row75Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[75]/td[3]");
	By OPiRCAReportTabTable4Row76Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[76]/td[1]");
	By OPiRCAReportTabTable4Row76Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[76]/td[3]");
	By OPiRCAReportTabTable4Row77Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[77]/td[1]");
	By OPiRCAReportTabTable4Row77Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[77]/td[3]");
	By OPiRCAReportTabTable4Row78Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[78]/td[1]");
	By OPiRCAReportTabTable4Row78Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[78]/td[3]");
	By OPiRCAReportTabTable4Row79Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[79]/td[1]");
	By OPiRCAReportTabTable4Row79Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[79]/td[3]");
	By OPiRCAReportTabTable4Row80Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[80]/td[1]");
	By OPiRCAReportTabTable4Row80Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[80]/td[3]");
	By OPiRCAReportTabTable4Row81Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[81]/td[1]");
	By OPiRCAReportTabTable4Row81Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[81]/td[3]");
	By OPiRCAReportTabTable4Row82Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[82]/td[1]");
	By OPiRCAReportTabTable4Row82Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[82]/td[3]");
	By OPiRCAReportTabTable4Row83Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[83]/td[1]");
	By OPiRCAReportTabTable4Row83Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[83]/td[3]");
	By OPiRCAReportTabTable4Row84Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[84]/td[1]");
	By OPiRCAReportTabTable4Row84Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[84]/td[3]");
	By OPiRCAReportTabTable4Row85Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[85]/td[1]");
	By OPiRCAReportTabTable4Row85Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[85]/td[3]");
	By OPiRCAReportTabTable4Row86Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[86]/td[1]");
	By OPiRCAReportTabTable4Row86Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[86]/td[3]");
	By OPiRCAReportTabTable4Row87Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[87]/td[1]");
	By OPiRCAReportTabTable4Row87Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[87]/td[3]");
	By OPiRCAReportTabTable4Row88Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[88]/td[1]");
	By OPiRCAReportTabTable4Row88Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[88]/td[3]");
	By OPiRCAReportTabTable4Row89Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[89]/td[1]");
	By OPiRCAReportTabTable4Row89Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[89]/td[3]");
	By OPiRCAReportTabTable4Row90Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[90]/td[1]");
	By OPiRCAReportTabTable4Row90Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[90]/td[3]");
	By OPiRCAReportTabTable4Row91Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[91]/td[1]");
	By OPiRCAReportTabTable4Row91Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[91]/td[3]");
	By OPiRCAReportTabTable4Row92Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[92]/td[1]");
	By OPiRCAReportTabTable4Row92Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[92]/td[3]");
	By OPiRCAReportTabTable4Row93Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[93]/td[1]");
	By OPiRCAReportTabTable4Row93Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[93]/td[3]");
	By OPiRCAReportTabTable4Row94Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[94]/td[1]");
	By OPiRCAReportTabTable4Row94Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[94]/td[3]");
	By OPiRCAReportTabTable4Row95Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[95]/td[1]");
	By OPiRCAReportTabTable4Row95Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[95]/td[3]");
	By OPiRCAReportTabTable4Row96Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[96]/td[1]");
	By OPiRCAReportTabTable4Row96Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[96]/td[3]");
	By OPiRCAReportTabTable4Row97Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[97]/td[1]");
	By OPiRCAReportTabTable4Row97Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[97]/td[3]");
	By OPiRCAReportTabTable4Row98Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[98]/td[1]");
	By OPiRCAReportTabTable4Row98Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[98]/td[3]");
	By OPiRCAReportTabTable4Row99Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[99]/td[1]");
	By OPiRCAReportTabTable4Row99Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[99]/td[3]");
	By OPiRCAReportTabTable4Row100Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[100]/td[1]");
	By OPiRCAReportTabTable4Row100Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[100]/td[3]");
	By OPiRCAReportTabTable4Row101Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[101]/td[1]");
	By OPiRCAReportTabTable4Row101Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[101]/td[3]");
	By OPiRCAReportTabTable4Row102Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[102]/td[1]");
	By OPiRCAReportTabTable4Row102Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[102]/td[2]");
	By OPiRCAReportTabTable4Row102Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[5]/table/tbody/tr[102]/td[3]");
	//Table 5
	By OPiRCAReportTabTable5Title = By.xpath(".//*[@id='module-opa-rpt']/div[6]/div");
	By OPiRCAReportTabTable5Heading1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/thead/tr/th[1]");
	By OPiRCAReportTabTable5Heading2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/thead/tr/th[2]");
	By OPiRCAReportTabTable5HiRCA31 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[1]");
	By OPiRCAReportTabTable5HiRCA310 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[2]");
	By OPiRCAReportTabTable5HiRCA311 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[3]");
	By OPiRCAReportTabTable5HiRCA312 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[4]");
	By OPiRCAReportTabTable5HiRCA313 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[5]");
	By OPiRCAReportTabTable5HiRCA314 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[6]");
	By OPiRCAReportTabTable5HiRCA315 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[7]");
	By OPiRCAReportTabTable5HiRCA316 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[8]");
	By OPiRCAReportTabTable5HiRCA317 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[9]");
	By OPiRCAReportTabTable5HiRCA318 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[10]");
	By OPiRCAReportTabTable5HiRCA319 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[11]");
	By OPiRCAReportTabTable5HiRCA32 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[12]");
	By OPiRCAReportTabTable5HiRCA320 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[13]");
	By OPiRCAReportTabTable5HiRCA321 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[14]");
	By OPiRCAReportTabTable5HiRCA322 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[15]");
	By OPiRCAReportTabTable5HiRCA331 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[16]");
	By OPiRCAReportTabTable5HiRCA3310 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[17]");
	By OPiRCAReportTabTable5HiRCA332 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[18]");
	By OPiRCAReportTabTable5HiRCA333 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[19]");
	By OPiRCAReportTabTable5HiRCA334 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[20]");
	By OPiRCAReportTabTable5HiRCA335 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[21]");
	By OPiRCAReportTabTable5HiRCA336 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[22]");
	By OPiRCAReportTabTable5HiRCA337 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[23]");
	By OPiRCAReportTabTable5HiRCA338 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[24]");
	By OPiRCAReportTabTable5HiRCA339 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[25]");
	By OPiRCAReportTabTable5HiRCA34 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[26]");
	By OPiRCAReportTabTable5HiRCA35 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[27]");
	By OPiRCAReportTabTable5HiRCA36 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[28]");
	By OPiRCAReportTabTable5HiRCA37 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[29]");
	By OPiRCAReportTabTable5HiRCA38 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[30]");
	By OPiRCAReportTabTable5HiRCA39 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[1]/ul/li[31]");
	By OPiRCAReportTabTable5ApparentCauseO1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseO3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseO4 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseO5 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[4]");
	By OPiRCAReportTabTable5ApparentCauseOO1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[5]");
	By OPiRCAReportTabTable5ApparentCauseOO2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[6]");
	By OPiRCAReportTabTable5ApparentCauseOO3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[7]");
	By OPiRCAReportTabTable5ApparentCauseOP1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[8]");
	By OPiRCAReportTabTable5ApparentCauseOP2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[9]");
	By OPiRCAReportTabTable5ApparentCauseOP3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[10]");
	By OPiRCAReportTabTable5ApparentCauseOP4 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[11]");
	By OPiRCAReportTabTable5ApparentCauseP1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[12]");
	By OPiRCAReportTabTable5ApparentCauseP2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[13]");
	By OPiRCAReportTabTable5ApparentCauseP3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[14]");
	By OPiRCAReportTabTable5ApparentCauseP4 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[15]");
	By OPiRCAReportTabTable5ApparentCauseP5 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[1]/td[2]/ul/li[16]");
	By OPiRCAReportTabTable5ApparentCauseAnswersHeading1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/thead/tr/th[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersHeading2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/thead/tr/th[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersHeading3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/thead/tr/th[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow1Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow2Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow2Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow2Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow3Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow3Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow3Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow4Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow4Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow4Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow5Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow5Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow5Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow6Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow6Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow6Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow7Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[7]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow7Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[7]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow7Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[7]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow8Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[8]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow8Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[8]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow8Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[8]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow9Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[9]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow9Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[9]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow9Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[9]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow10Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[10]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow10Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[10]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow10Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[10]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow11Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[11]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow11Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[11]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow11Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[11]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow12Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[12]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow12Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[12]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow12Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[12]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow13Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[13]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow13Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[13]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow13Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[13]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow14Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[14]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow14Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[14]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow14Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[14]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow15Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[15]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow15Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[15]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow15Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[15]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow16Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[16]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow16Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[16]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow16Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[16]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow17Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[17]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow17Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[17]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow17Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[17]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow18Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[18]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow18Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[18]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow18Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[18]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow19Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[19]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow19Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[19]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow19Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[19]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow20Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[20]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow20Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[20]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow20Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[20]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow21Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[21]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow21Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[21]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow21Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[21]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow22Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[22]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow22Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[22]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow22Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[22]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow23Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[23]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow23Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[23]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow23Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[23]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow24Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[24]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow24Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[24]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow24Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[24]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow25Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[25]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow25Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[25]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow25Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[25]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow25Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[25]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow26Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[26]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow26Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[26]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow26Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[26]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow26Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[26]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow27Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[27]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow27Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[27]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow27Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[27]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow27Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[27]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow28Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[28]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow28Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[28]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow28Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[28]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow29Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[29]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow29Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[29]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow29Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[29]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow30Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[30]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow30Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[30]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow30Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[30]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow31Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[31]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow31Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[31]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow31Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[31]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow32Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[32]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow32Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[32]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow32Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[32]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow33Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[33]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow33Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[33]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow33Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[33]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow34Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[34]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow34Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[34]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow34Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[34]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow35Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[35]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow35Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[35]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow35Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[35]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow36Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[36]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow36Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[36]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow36Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[36]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow37Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[37]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow37Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[37]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow37Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[37]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow38Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[38]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow38Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[38]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow38Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[38]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow39Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[39]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow39Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[39]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow39Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[39]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow40Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[40]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow40Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[40]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow40Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[40]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow41Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[41]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow41Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[41]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow41Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[41]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow42Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[42]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow42Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[42]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow42Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[42]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow42Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[42]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow43Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[43]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow43Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[43]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow43Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[43]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow43Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[43]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow44Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[44]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow44Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[44]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow44Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[44]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow44Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[44]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow45Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[45]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow45Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[45]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow45Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[45]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow45Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[45]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow46Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[46]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow46Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[46]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow46Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[46]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow46Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[46]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow47Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[47]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow47Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[47]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow47Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[47]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow47Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[47]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow48Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[48]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow48Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[48]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow48Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[48]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow48Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[48]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow49Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[49]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow49Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[49]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow49Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[49]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow50Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[50]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow50Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[50]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow50Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[50]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow50Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[50]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow51Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[51]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow51Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[51]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow51Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[51]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow52Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[52]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow52Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[52]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow52Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[52]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow53Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[53]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow53Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[53]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow53Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[53]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow54Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[54]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow54Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[54]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow54Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[54]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow55Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[55]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow55Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[55]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow55Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[55]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow56Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[56]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow56Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[56]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow56Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[56]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow57Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[57]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow57Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[57]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow57Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[57]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow58Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[58]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow58Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[58]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow58Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[58]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow59Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[59]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow59Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[59]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow59Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[59]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow60Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[60]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow60Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[60]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow60Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[60]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow61Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[61]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow61Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[61]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow61Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[61]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow62Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[62]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow62Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[62]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[62]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[62]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[62]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part4 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[62]/td[3]/ul/li[4]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow63Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[63]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow63Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[63]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[63]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[63]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[63]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part4 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[63]/td[3]/ul/li[4]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow64Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[64]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow64Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[64]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow64Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[64]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow65Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[65]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow65Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[65]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow65Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[65]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow66Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[66]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow66Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[66]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow66Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[66]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow67Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[67]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow67Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[67]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow67Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[67]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow67Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[67]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow68Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[68]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow68Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[68]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow68Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[68]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow68Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[68]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow69Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[69]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow69Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[69]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow69Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[69]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow69Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[69]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow70Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[70]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow70Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[70]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow70Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[70]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow70Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[70]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow71Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[71]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow71Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[71]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow71Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[71]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow71Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[71]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow72Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[72]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow72Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[72]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow72Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[72]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow72Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[72]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow73Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[73]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow73Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[73]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow73Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[73]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow74Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[74]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow74Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[74]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow74Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[74]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow75Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[75]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow75Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[75]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow75Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[75]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow76Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[76]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow76Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[76]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow76Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[76]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow76Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[76]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow77Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[77]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow77Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[77]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow77Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[77]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow77Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[77]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow78Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[78]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow78Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[78]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow78Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[78]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow78Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[78]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow79Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[79]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow79Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[79]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow79Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[79]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow79Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[79]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow80Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[80]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow80Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[80]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow80Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[80]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow80Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[80]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow81Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[81]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow81Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[81]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow81Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[81]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow81Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[81]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow82Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[82]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow82Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[82]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow82Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[82]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow82Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[82]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow83Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[83]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow83Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[83]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow83Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[83]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow83Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[83]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow84Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[84]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow84Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[84]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow84Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[84]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow85Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[85]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow85Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[85]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow85Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[85]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow86Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[86]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow86Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[86]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow86Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[86]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow87Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[87]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow87Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[87]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow87Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[87]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow87Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[87]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow87Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[87]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow88Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[88]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow88Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[88]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow88Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[88]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow88Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[88]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow88Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[88]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow89Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[89]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow89Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[89]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow89Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[89]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow89Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[89]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow89Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[89]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow90Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[90]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow90Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[90]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow90Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[90]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow90Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[90]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow90Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[90]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow91Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[91]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow91Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[91]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow91Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[91]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow91Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[91]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow91Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[91]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow92Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[92]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow92Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[92]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow92Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[92]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow92Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[92]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow92Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[92]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow93Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[93]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow93Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[93]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow93Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[93]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow93Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[93]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow94Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[94]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow94Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[94]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow94Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[94]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow95Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[95]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow95Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[95]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow95Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[95]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow95Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[95]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow96Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[96]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow96Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[96]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow96Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[96]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow96Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[96]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow97Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[97]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow97Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[97]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow97Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[97]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow97Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[97]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow98Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[98]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow98Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[98]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow98Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[98]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow98Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[98]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow98Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[98]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow99Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[99]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow99Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[99]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow99Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[99]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow100Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[100]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow100Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[100]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow100Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[100]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow100Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[100]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow101Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[101]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow101Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[101]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[101]/td[3]/ul/li[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[101]/td[3]/ul/li[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[101]/td[3]/ul/li[3]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part4 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[101]/td[3]/ul/li[4]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow102Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[102]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow102Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[102]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow102Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[102]/td[3]/ul/li");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow103Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[103]/td[1]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow103Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[103]/td[2]");
	By OPiRCAReportTabTable5ApparentCauseAnswersRow103Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[103]/td[3]/ul/li");
	//Table 6
	By OPiRCAReportTabTable6Title = By.xpath(".//*[@id='module-opa-rpt']/div[7]/div");
	By OPiRCAReportTabTable6Heading1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/thead/tr/th[1]");
	By OPiRCAReportTabTable6Heading2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/thead/tr/th[2]");
	By OPiRCAReportTabTable6Heading3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/thead/tr/th[3]");
	By OPiRCAReportTabTable6Row1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable6Row1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable6Row1Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[1]/td[3]");
	By OPiRCAReportTabTable6Row2Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable6Row2Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[2]/td[2]");
	By OPiRCAReportTabTable6Row2Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[2]/td[3]");
	By OPiRCAReportTabTable6Row3Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable6Row3Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[3]/td[2]");
	By OPiRCAReportTabTable6Row3Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[3]/td[3]");
	By OPiRCAReportTabTable6Row4Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[4]/td[1]");
	By OPiRCAReportTabTable6Row4Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[4]/td[2]");
	By OPiRCAReportTabTable6Row4Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[4]/td[3]");
	By OPiRCAReportTabTable6Row5Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[5]/td[1]");
	By OPiRCAReportTabTable6Row5Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[5]/td[2]");
	By OPiRCAReportTabTable6Row5Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[5]/td[3]");
	By OPiRCAReportTabTable6Row6Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[6]/td[1]");
	By OPiRCAReportTabTable6Row6Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[6]/td[2]");
	By OPiRCAReportTabTable6Row6Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[6]/td[3]");
	By OPiRCAReportTabTable6Row7Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[7]/td[1]");
	By OPiRCAReportTabTable6Row7Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[7]/td[2]");
	By OPiRCAReportTabTable6Row7Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[7]/td[3]");
	By OPiRCAReportTabTable6Row8Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[8]/td[1]");
	By OPiRCAReportTabTable6Row8Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[8]/td[2]");
	By OPiRCAReportTabTable6Row8Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[8]/td[3]");
	By OPiRCAReportTabTable6Row9Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[9]/td[1]");
	By OPiRCAReportTabTable6Row9Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[9]/td[2]");
	By OPiRCAReportTabTable6Row9Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[9]/td[3]");
	By OPiRCAReportTabTable6Row10Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[10]/td[1]");
	By OPiRCAReportTabTable6Row10Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[10]/td[2]");
	By OPiRCAReportTabTable6Row10Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[10]/td[3]");
	By OPiRCAReportTabTable6Row11Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[11]/td[1]");
	By OPiRCAReportTabTable6Row11Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[11]/td[2]");
	By OPiRCAReportTabTable6Row11Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[11]/td[3]");
	By OPiRCAReportTabTable6Row12Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[12]/td[1]");
	By OPiRCAReportTabTable6Row12Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[12]/td[2]");
	By OPiRCAReportTabTable6Row12Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[7]/table/tbody/tr[12]/td[3]");
	//Table 7 
	By OPiRCAReportTabTable7Title1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/div[1]");
	By OPiRCAReportTabTable7Title2 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/div[2]");
	By OPiRCAReportTabTable7Title3 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/div[3]");
	By OPiRCAReportTabTable7Title4 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/div[4]");
	By OPiRCAReportTabTable7Title5 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/div[5]");
	By OPiRCAReportTabTable7Heading = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/thead/tr/th[1]");
	By OPiRCAReportTabTable7Row1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable7Row1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable7Row1Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[1]/td[3]");
	By OPiRCAReportTabTable7Row1Column4 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[1]/td[4]");
	By OPiRCAReportTabTable7Row2Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable7Row3Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable7Row4Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[4]/td[1]");
	By OPiRCAReportTabTable7Row5Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[5]/td[1]");
	By OPiRCAReportTabTable7Row6Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[6]/td[1]");
	By OPiRCAReportTabTable7Row7Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[7]/td[1]");
	By OPiRCAReportTabTable7Row8Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[8]/td[1]");
	By OPiRCAReportTabTable7Row9Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[9]/td[1]");
	By OPiRCAReportTabTable7Row10Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[10]/td[1]");
	By OPiRCAReportTabTable7Row11Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[11]/td[1]");
	By OPiRCAReportTabTable7Row12Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[12]/td[1]");
	By OPiRCAReportTabTable7Row13Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[13]/td[1]");
	By OPiRCAReportTabTable7Row14Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[14]/td[1]");
	By OPiRCAReportTabTable7Row15Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[15]/td[1]");
	By OPiRCAReportTabTable7Row16Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[16]/td[1]");
	By OPiRCAReportTabTable7Row17Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[17]/td[1]");
	By OPiRCAReportTabTable7Row18Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[18]/td[1]");
	By OPiRCAReportTabTable7Row19Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[19]/td[1]");
	By OPiRCAReportTabTable7Row20Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[20]/td[1]");
	By OPiRCAReportTabTable7Row21Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[21]/td[1]");
	By OPiRCAReportTabTable7Row22Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[22]/td[1]");
	By OPiRCAReportTabTable7Row23Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[23]/td[1]");
	By OPiRCAReportTabTable7Row24Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[24]/td[1]");
	By OPiRCAReportTabTable7Row25Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[25]/td[1]");
	By OPiRCAReportTabTable7Row26Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[26]/td[1]");
	By OPiRCAReportTabTable7Row27Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[27]/td[1]");
	By OPiRCAReportTabTable7Row28Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[28]/td[1]");
	By OPiRCAReportTabTable7Row29Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[29]/td[1]");
	By OPiRCAReportTabTable7Row30Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[30]/td[1]");
	By OPiRCAReportTabTable7Row31Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[31]/td[1]");
	By OPiRCAReportTabTable7Row32Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[32]/td[1]");
	By OPiRCAReportTabTable7Row33Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[33]/td[1]");
	By OPiRCAReportTabTable7Row34Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[34]/td[1]");
	By OPiRCAReportTabTable7Row35Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[35]/td[1]");
	By OPiRCAReportTabTable7Row36Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[36]/td[1]");
	By OPiRCAReportTabTable7Row37Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[37]/td[1]");
	By OPiRCAReportTabTable7Row38Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[38]/td[1]");
	By OPiRCAReportTabTable7Row39Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[39]/td[1]");
	By OPiRCAReportTabTable7Row40Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[40]/td[1]");
	By OPiRCAReportTabTable7Row41Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[41]/td[1]");
	By OPiRCAReportTabTable7Row42Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[42]/td[1]");
	By OPiRCAReportTabTable7Row43Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[43]/td[1]");
	By OPiRCAReportTabTable7Row44Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[44]/td[1]");
	By OPiRCAReportTabTable7Row45Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[45]/td[1]");
	By OPiRCAReportTabTable7Row46Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[46]/td[1]");
	By OPiRCAReportTabTable7Row47Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[47]/td[1]");
	By OPiRCAReportTabTable7Row48Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[48]/td[1]");
	By OPiRCAReportTabTable7Row49Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[49]/td[1]");
	By OPiRCAReportTabTable7Row50Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[50]/td[1]");
	By OPiRCAReportTabTable7Row51Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[51]/td[1]");
	By OPiRCAReportTabTable7Row52Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[52]/td[1]");
	By OPiRCAReportTabTable7Row53Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[53]/td[1]");
	By OPiRCAReportTabTable7Row54Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[54]/td[1]");
	By OPiRCAReportTabTable7Row55Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[55]/td[1]");
	By OPiRCAReportTabTable7Row56Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[56]/td[1]");
	By OPiRCAReportTabTable7Row57Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[57]/td[1]");
	By OPiRCAReportTabTable7Row58Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[58]/td[1]");
	By OPiRCAReportTabTable7Row59Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[59]/td[1]");
	By OPiRCAReportTabTable7Row60Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[60]/td[1]");
	By OPiRCAReportTabTable7Row61Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[61]/td[1]");
	By OPiRCAReportTabTable7Row62Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[62]/td[1]");
	By OPiRCAReportTabTable7Row63Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[63]/td[1]");
	By OPiRCAReportTabTable7Row64Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[64]/td[1]");
	By OPiRCAReportTabTable7Row65Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[65]/td[1]");
	By OPiRCAReportTabTable7Row66Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[66]/td[1]");
	By OPiRCAReportTabTable7Row67Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[67]/td[1]");
	By OPiRCAReportTabTable7Row68Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[68]/td[1]");
	By OPiRCAReportTabTable7Row69Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[69]/td[1]");
	By OPiRCAReportTabTable7Row70Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[70]/td[1]");
	By OPiRCAReportTabTable7Row71Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[71]/td[1]");
	By OPiRCAReportTabTable7Row72Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[72]/td[1]");
	By OPiRCAReportTabTable7Row73Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[73]/td[1]");
	By OPiRCAReportTabTable7Row74Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[74]/td[1]");
	By OPiRCAReportTabTable7Row75Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[75]/td[1]");
	By OPiRCAReportTabTable7Row76Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[76]/td[1]");
	By OPiRCAReportTabTable7Row77Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[77]/td[1]");
	By OPiRCAReportTabTable7Row78Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[78]/td[1]");
	By OPiRCAReportTabTable7Row79Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[79]/td[1]");
	By OPiRCAReportTabTable7Row80Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[80]/td[1]");
	By OPiRCAReportTabTable7Row81Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[81]/td[1]");
	By OPiRCAReportTabTable7Row82Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[82]/td[1]");
	By OPiRCAReportTabTable7Row83Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[83]/td[1]");
	By OPiRCAReportTabTable7Row84Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[84]/td[1]");
	By OPiRCAReportTabTable7Row85Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[85]/td[1]");
	By OPiRCAReportTabTable7Row86Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[86]/td[1]");
	By OPiRCAReportTabTable7Row87Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[87]/td[1]");
	By OPiRCAReportTabTable7Row88Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[88]/td[1]");
	By OPiRCAReportTabTable7Row89Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[89]/td[1]");
	By OPiRCAReportTabTable7Row90Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[90]/td[1]");
	By OPiRCAReportTabTable7Row91Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[91]/td[1]");
	By OPiRCAReportTabTable7Row92Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[92]/td[1]");
	By OPiRCAReportTabTable7Row93Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[93]/td[1]");
	By OPiRCAReportTabTable7Row94Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[94]/td[1]");
	By OPiRCAReportTabTable7Row95Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[95]/td[1]");
	By OPiRCAReportTabTable7Row96Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[96]/td[1]");
	By OPiRCAReportTabTable7Row97Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[97]/td[1]");
	By OPiRCAReportTabTable7Row98Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[98]/td[1]");
	By OPiRCAReportTabTable7Row99Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[99]/td[1]");
	By OPiRCAReportTabTable7Row100Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[100]/td[1]");
	By OPiRCAReportTabTable7Row101Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[101]/td[1]");
	By OPiRCAReportTabTable7Row102Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[102]/td[1]");
	By OPiRCAReportTabTable7Row103Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[8]/table/tbody/tr[103]/td[1]");
	//Table 8
	By OPiRCAReportTabTable8Title = By.xpath(".//*[@id='module-opa-rpt']/div[9]");
	By OPiRCAReportTabTable8Heading1 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/thead/tr/th[1]");
	By OPiRCAReportTabTable8Heading2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/thead/tr/th[2]");
	By OPiRCAReportTabTable8Heading3 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/thead/tr/th[3]");
	By OPiRCAReportTabTable8Row1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable8Row1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable8Row1Column3 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[1]/td[3]");
	By OPiRCAReportTabTable8Row2Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable8Row2Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[2]/td[2]");
	By OPiRCAReportTabTable8Row3Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[3]/td[2]");
	By OPiRCAReportTabTable8Row4Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[4]/td[2]");
	By OPiRCAReportTabTable8Row5Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[5]/td[1]");
	By OPiRCAReportTabTable8Row5Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[5]/td[2]");
	By OPiRCAReportTabTable8Row6Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[10]/table/tbody/tr[6]/td[2]");
	//Table 9
	By OPiRCAReportTabTable9Title = By.xpath(".//*[@id='module-opa-rpt']/div[11]");
	By OPiRCAReportTabTable9Row1Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[12]/table/tbody/tr[1]/td[1]");
	By OPiRCAReportTabTable9Row1Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[12]/table/tbody/tr[1]/td[2]");
	By OPiRCAReportTabTable9Row2Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[12]/table/tbody/tr[2]/td[1]");
	By OPiRCAReportTabTable9Row2Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[12]/table/tbody/tr[2]/td[2]");
	By OPiRCAReportTabTable9Row3Column1 = By.xpath(".//*[@id='module-opa-rpt']/div[12]/table/tbody/tr[3]/td[1]");
	By OPiRCAReportTabTable9Row3Column2 = By.xpath(".//*[@id='module-opa-rpt']/div[12]/table/tbody/tr[3]/td[2]");

	public void downloadReport(WebDriver driver, List <String> verifyChinese, SoftAssertions softly) throws Exception{

		//Download report and check pdf
		HiRCAChinese2 obj = new HiRCAChinese2();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
	}

	public void chineseReportTab(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Table 1
		//Heading
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Heading)).getText();
		softly.assertThat(h1).as("test data").contains("事件信息");
		//Row 1
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row1)).getText();
		softly.assertThat(r1).as("test data").contains("事件名称");
		//Row 2
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row2)).getText();
		softly.assertThat(r2).as("test data").contains("事件编号");
		//Row 3
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row3Column1)).getText();
		softly.assertThat(r3).as("test data").contains("事件发生日期");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row3Column3)).getText();
		softly.assertThat(r4).as("test data").contains("事件发生时间");
		//Row 4
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row4)).getText();
		softly.assertThat(r5).as("test data").contains("事件发生地点");
		//Row 5
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row5)).getText();
		softly.assertThat(r6).as("test data").contains("事件调查员");
		//Row 6
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row6)).getText();
		softly.assertThat(r7).as("test data").contains("报告编写者");
		//Row 7
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable1Row7)).getText();
		softly.assertThat(r8).as("test data").contains("报告编写时间");
		//Table 2
		//Heading
		String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable2Heading)).getText();
		softly.assertThat(h2).as("test data").contains("事件名称");
		//Row 1
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable2Row1)).getText();
		softly.assertThat(r9).as("test data").contains("报告摘要");
		//Row 2
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable2Row2)).getText();
		softly.assertThat(r10).as("test data").contains("事件描述");
		//Row 3
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable2Row3)).getText();
		softly.assertThat(r11).as("test data").contains("事件详细过程（时序构建）");
		//Row 4
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable2Row4)).getText();
		softly.assertThat(r12).as("test data").contains("相关信息");
		//Table 3
		//Title
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Title)).getText();
		softly.assertThat(title1).as("test data").contains("事件原因");
		//Root cause
		//Headings
		String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Heading1)).getText();
		softly.assertThat(h3).as("test data").contains("根本原因 (1)");
		String h4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Heading2)).getText();
		softly.assertThat(h4).as("test data").contains("重要性分级");
		String h5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Heading3)).getText();
		softly.assertThat(h5).as("test data").contains("纠正行动");
		//Row 1
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Row1Column1)).getText();
		softly.assertThat(r13).as("test data").contains("O1.1 管理职能不足: (1) 职能协调人或经理不足; (2) 管理决策职能不足; (3) 问题解决职能不足; (4) 工作计划职能不足; (5) 资源分配职能不足; (6) 管理和人员培训职能不足; (7) 人力资源职能（或结构）不足");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Row1Column2)).getText();
		softly.assertThat(r14).as("test data").contains("高");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Row1Column3)).getText();
		softly.assertThat(r15).as("test data").contains("改进管理职能");
		//Heading
		String h6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Heading4)).getText();
		softly.assertThat(h6).as("test data").contains("根本原因 (1) - 扩展分析");
		//Row 2
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Row2)).getText();
		softly.assertThat(r16).as("test data").contains("扩展分析:");
		//Row 3
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Row3)).getText();
		softly.assertThat(r17).as("test data").contains("运行经验:");
		//Row 4
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable3Row4)).getText();
		softly.assertThat(r18).as("test data").contains("对核安全或安全文化的影响:");
		//Table 4
		chineseReportTabTable4(driver, softly);
		//Table 5
		chineseReportTabTable5(driver, softly);
		//Table 6
		chineseReportTabTable6(driver, softly);
		//Table 7
		chineseReportTabTable7(driver, softly);
		//Table 8
		chineseReportTabTable8(driver, softly);
		//Table 9
		chineseReportTabTable9(driver, softly);
	}

	public void chineseReportTabTable9(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//title
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Title)).getText();
		softly.assertThat(title3).as("test data").contains("签字");
		//Rows
		String r703 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Row1Column1)).getText();
		softly.assertThat(r703).as("test data").contains("编写");
		String r704 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Row1Column2)).getText();
		softly.assertThat(r704).as("test data").contains("日期");
		String r705 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Row2Column1)).getText();
		softly.assertThat(r705).as("test data").contains("审查");
		String r706 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Row2Column2)).getText();
		softly.assertThat(r706).as("test data").contains("日期");
		String r707 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Row3Column1)).getText();
		softly.assertThat(r707).as("test data").contains("批准");
		String r708 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable9Row3Column2)).getText();
		softly.assertThat(r708).as("test data").contains("日期");
	}

	public void chineseReportTabTable8(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Title
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Title)).getText();
		softly.assertThat(title1).as("test data").contains("自检清单");
		//Headings
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Heading1)).getText();
		softly.assertThat(h1).as("test data").contains("类别");
		String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Heading2)).getText();
		softly.assertThat(h2).as("test data").contains("调查内容");
		String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Heading3)).getText();
		softly.assertThat(h3).as("test data").contains("完成打勾?");
		//Row1
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row1Column1)).getText();
		softly.assertThat(r1).as("test data").contains("调查概述");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row1Column2)).getText();
		softly.assertThat(r2).as("test data").contains("是否访谈了所有相关组织与制度，是否收集了所有相关数据？");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row1Column3)).getText();
		softly.assertThat(r3).as("test data").contains("是");
		//Row2
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row2Column1)).getText();
		softly.assertThat(r4).as("test data").contains("根本原因");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row2Column2)).getText();
		softly.assertThat(r5).as("test data").contains("根本原因是否符合 SURE");
		softly.assertThat(r5).as("test data").contains(" 标准");
		//Row3
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row3Column2)).getText();
		softly.assertThat(r6).as("test data").contains("根本原因是否经得住 CHOP'N");
		softly.assertThat(r6).as("test data").contains(" 挑战？");
		//Row4
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row4Column2)).getText();
		softly.assertThat(r7).as("test data").contains("是否识别根本原因的重要性？");
		//Row5
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row5Column1)).getText();
		softly.assertThat(r8).as("test data").contains("纠正行动");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row5Column2)).getText();
		softly.assertThat(r9).as("test data").contains("建议的纠正行动是否涵盖所有直接原因、根本原因和关键促成因素");
		//Row6
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable8Row6Column2)).getText();
		softly.assertThat(r10).as("test data").contains("建议的纠正行动是否具有成本效益？");
	}

	public void chineseReportTabTable7(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Title
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Title1)).getText();
		softly.assertThat(title1).as("test data").contains("根本原因确认分析（SURE）");
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Title2)).getText();
		softly.assertThat(title2).as("test data").contains(": 是否存在不合标准的实践?");
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Title3)).getText();
		softly.assertThat(title3).as("test data").contains(": 是否在管理层控制下?");
		String title4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Title4)).getText();
		softly.assertThat(title4).as("test data").contains(": 是否可以降低概率?");
		String title5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Title5)).getText();
		softly.assertThat(title5).as("test data").contains(": 不为其他促成因素的影响?");
		//Headings
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Heading)).getText();
		softly.assertThat(h1).as("test data").contains("促成因素");
		//Row 1
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row1Column1)).getText();
		softly.assertThat(r1).as("test data").contains("O1.1 管理职能不足: (1) 职能协调人或经理不足; (2) 管理决策职能不足; (3) 问题解决职能不足; (4) 工作计划职能不足; (5) 资源分配职能不足; (6) 管理和人员培训职能不足; (7) 人力资源职能（或结构）不足");
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row1Column2)).getText();
		softly.assertThat(r1a).as("test data").contains("是");
		String r1b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row1Column3)).getText();
		softly.assertThat(r1b).as("test data").contains("是");
		String r1c = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row1Column4)).getText();
		softly.assertThat(r1c).as("test data").contains("是");
		//Row 2
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row2Column1)).getText();
		softly.assertThat(r2).as("test data").contains("O1.2 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
		//Row 3
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row3Column1)).getText();
		softly.assertThat(r3).as("test data").contains("O1.3 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
		//Row 4
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row4Column1)).getText();
		softly.assertThat(r4).as("test data").contains("O1.4 生产组织结构不足，例如: (1) 执行核心工作流程的结构存在不足; (2) 不同生产线的结构分隔存在不足; (3) 班值存在不足");
		//Row 5
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row5Column1)).getText();
		softly.assertThat(r5).as("test data").contains("O1.5 监督组织结构不足，例如: (1) 生产或管理支持相关管理团队的监督; (2) 生产经理以下管理层级的管理人员监督; (3) 监督结构未基于专业（例如无损试验、QA、QC等）");
		//Row 6
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row6Column1)).getText();
		softly.assertThat(r6).as("test data").contains("O1.6 管理支持组织结构不足，例如: (1) 招聘结构不足; (2) 继任计划不足; (3) 培训或授权不足");
		//Row 7
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row7Column1)).getText();
		softly.assertThat(r7).as("test data").contains("O1.7 区分短期和长期工作的组织结构存在不足，例如: (1) 一组工程人员处理短期和长期设计改造; (2) 一组维修人员处理紧急和非紧急工作");
		//Row 8
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row8Column1)).getText();
		softly.assertThat(r8).as("test data").contains("O1.8 管理层级不足: (1) 规则型和技能型的小组层级过多; (2) 知识型小组层级不足");
		//Row 9
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row9Column1)).getText();
		softly.assertThat(r9).as("test data").contains("O1.9 管理跨度不足 : (1) 向一位主管或经理汇报的人员过多; (2) 向一位主管或经理汇报的人员过少");
		//Row 10
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row10Column1)).getText();
		softly.assertThat(r10).as("test data").contains("O1.10 组织设计和改进方面的领导参与存在不足: (1) 领导层未参与组织问题解决过程中; (2) 领导层未参与组织结构和职能设计中");
		//Row 11
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row11Column1)).getText();
		softly.assertThat(r11).as("test data").contains("O1.11 管理职能方面的领导参与不足");
		//Row 12
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row12Column1)).getText();
		softly.assertThat(r12).as("test data").contains("O3.1 缺少流程和程序设计、缺乏标准改进");
		//Row 13
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row13Column1)).getText();
		softly.assertThat(r13).as("test data").contains("O3.2 缺少负责日常流程绩效的流程负责人");
		//Row 14
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row14Column1)).getText();
		softly.assertThat(r14).as("test data").contains("O3.3 流程程序设计导则存在不足");
		//Row 15
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row15Column1)).getText();
		softly.assertThat(r15).as("test data").contains("O3.4 流程改进存在不足: (1) 定期自评存在不足; (2)绩效跟踪和趋势分析存在不足; (3)流程失效的根本原因分析存在不足");
		//Row 16
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row16Column1)).getText();
		softly.assertThat(r16).as("test data").contains("O3.5 程序编写导则存在不足，未能有效且可靠地执行流程");
		//Row 17
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row17Column1)).getText();
		softly.assertThat(r17).as("test data").contains("O3.6 发展流程设计和改进能力方面存在不足: (1) 流程的失效模式与影响分析; (2) 功能设计; (3) 效率和可靠性优化; (4) 教学准备; (5) 流程试验和验证");
		//Row 18
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row18Column1)).getText();
		softly.assertThat(r18).as("test data").contains("O3.7 通过培训或指导来发展流程设计和改进能力");
		//Row 19
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row19Column1)).getText();
		softly.assertThat(r19).as("test data").contains("O4.1 高层管理的接口会议不足以处理共性问题");
		//Row 20
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row20Column1)).getText();
		softly.assertThat(r20).as("test data").contains("O4.2 中层管理的接口会议不足以处理共性问题");
		//Row 21
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row21Column1)).getText();
		softly.assertThat(r21).as("test data").contains("O4.3 工作层的接口会议不足以处理共性问题");
		//Row 22
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row22Column1)).getText();
		softly.assertThat(r22).as("test data").contains("O4.4 在使用公用跟踪系统记录各个组织之间情况管理或工作流程沟通方面存在不足");
		//Row 23
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row23Column1)).getText();
		softly.assertThat(r23).as("test data").contains("O4.5 组织中的垂直沟通存在不足，未能报告需要高层管理注意的问题");
		//Row 24
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row24Column1)).getText();
		softly.assertThat(r24).as("test data").contains("O4.6 向工作人员传达管理层期望和经验反馈方面存在不足");
		//Row 25
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row25Column1)).getText();
		softly.assertThat(r25).as("test data").contains("O4.7 由于激励和问责制度存在不足而造成移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）的沟通存在不足");
		//Row 26
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row26Column1)).getText();
		softly.assertThat(r26).as("test data").contains("O5.1 技能不足以避免发生粗心大意的失误");
		//Row 27
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row27Column1)).getText();
		softly.assertThat(r27).as("test data").contains("O5.2 技能不足以遵守规则（例如程序、检查清单、工作现场提示信息、行为标准和不准做清单）");
		//Row 28
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row28Column1)).getText();
		softly.assertThat(r28).as("test data").contains("O5.3 主管和经理知识不足以防止自身的知识型错误");
		//Row 29
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row29Column1)).getText();
		softly.assertThat(r29).as("test data").contains("O5.4 流程设计和改进方面的管理知识不足: (1) 程序的逐步设计和改进方面存在不足; (2) 屏障的设计和改进方面存在不足; (3) 行为标准的设计和改进方面存在不足; (4) 不准做清单的设计和改进方面存在不足; (5) 检查清单的设计和改进方面存在不足; (6) 工作现场提示信息的设计和改进方面存在不足");
		//Row 30
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row30Column1)).getText();
		softly.assertThat(r30).as("test data").contains("O5.5 人因绩效管理方面的管理知识不足");
		//Row 31
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row31Column1)).getText();
		softly.assertThat(r31).as("test data").contains("O5.6 设备性能管理方面的管理知识不足");
		//Row 32
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row32Column1)).getText();
		softly.assertThat(r32).as("test data").contains("OO1.1 QA和组织之间的共同目标/利益/问责机制的定义存在不足");
		//Row 33
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row33Column1)).getText();
		softly.assertThat(r33).as("test data").contains("OO1.2 组织间的共同目标/利益/问责机制的定义存在不足");
		//Row 34
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row34Column1)).getText();
		softly.assertThat(r34).as("test data").contains("OO1.3 高管和组织管理人员之间的共同目标/利益/问责机制存在不足: (1) 奖励制度不同且不一致; (2) 高管侧重于一个领域而让管理人员负责另一个领域");
		//Row 35
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row35Column1)).getText();
		softly.assertThat(r35).as("test data").contains("OO1.4 组织管理人员和主管之间的共同目标/利益/问责机制存在不足: (1) 问责体系不同; (2) 管理人员侧重于一个领域而让主管负责另一个领域");
		//Row 36
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row36Column1)).getText();
		softly.assertThat(r36).as("test data").contains("OO1.5 奖励和问责体系不足以建立共同目标/利益");
		//Row 37
		String r37 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row37Column1)).getText();
		softly.assertThat(r37).as("test data").contains("OO2.1 组织管理人员共同规定的接口要求存在不足，例如数据传达、资源共享、解决跨组织问题等");
		//Row 38
		String r38 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row38Column1)).getText();
		softly.assertThat(r38).as("test data").contains("OO2.2 接口流程和方法存在不足，例如会议形式、接口频率和沟通通道存在不足");
		//Row 39
		String r39 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row39Column1)).getText();
		softly.assertThat(r39).as("test data").contains("OO2.3 由于位置过于分散而造成沟通不佳");
		//Row 40
		String r40 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row40Column1)).getText();
		softly.assertThat(r40).as("test data").contains("OO3.1 两个独立的组织执行一个工作职能");
		//Row 41
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row41Column1)).getText();
		softly.assertThat(r41).as("test data").contains("OO3.2 没有要求两个接口部门执行所需的工作职能");
		//Row 42
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row42Column1)).getText();
		softly.assertThat(r42).as("test data").contains("OP1.1 人员配置和预算不足以实施制度或执行程序");
		//Row 43
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row43Column1)).getText();
		softly.assertThat(r43).as("test data").contains("OP1.2 相关人员的培训和授权不足以实施制度");
		//Row 44
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row44Column1)).getText();
		softly.assertThat(r44).as("test data").contains("OP1.3 管理层对制度落实行动的跟进存在不足");
		//Row 45
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row45Column1)).getText();
		softly.assertThat(r45).as("test data").contains("OP1.4 对落实制度的管理支持存在不足");
		//Row 46
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row46Column1)).getText();
		softly.assertThat(r46).as("test data").contains("OP2.1 先行指标存在不足");
		//Row 47
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row47Column1)).getText();
		softly.assertThat(r47).as("test data").contains("OP2.2 实时指标存在不足");
		//Row 48
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row48Column1)).getText();
		softly.assertThat(r48).as("test data").contains("OP2.3 滞后指标存在不足");
		//Row 49
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row49Column1)).getText();
		softly.assertThat(r49).as("test data").contains("OP2.4 管理层在绩效监督跟踪和趋势分析的结果使用方面存在不足");
		//Row 50
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row50Column1)).getText();
		softly.assertThat(r50).as("test data").contains("OP2.5 在将RCA共因分析作为监督工具方面存在不足");
		//Row 51
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row51Column1)).getText();
		softly.assertThat(r51).as("test data").contains("OP2.6 在使用现场观察结果作为监督工具方面存在不足");
		//Row 52
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row52Column1)).getText();
		softly.assertThat(r52).as("test data").contains("OP3.1 个人的自我分析存在不足");
		//Row 53
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row53Column1)).getText();
		softly.assertThat(r53).as("test data").contains("OP3.2 监督小组的自我分析存在不足");
		//Row 54
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row54Column1)).getText();
		softly.assertThat(r54).as("test data").contains("OP3.3 管理组织的自我分析存在不足");
		//Row 55
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row55Column1)).getText();
		softly.assertThat(r55).as("test data").contains("OP3.4 高风险制度或程序的自我评估存在不足");
		//Row 56
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row56Column1)).getText();
		softly.assertThat(r56).as("test data").contains("OP3.5 对组织事件的根本原因分析分析质量差、事件数据收集和启动调查条件存在不足");
		//Row 57
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row57Column1)).getText();
		softly.assertThat(r57).as("test data").contains("OP3.6 对组织事件的共因分析没有定期执行（不够频繁）或是共因分析质量差");
		//Row 58
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row58Column1)).getText();
		softly.assertThat(r58).as("test data").contains("OP4.1 制度或流程负责人规定方面存在不足");
		//Row 59
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row59Column1)).getText();
		softly.assertThat(r59).as("test data").contains("OP4.2 制度或流程相关人员的角色和责任规定方面存在不足");
		//Row 60
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row60Column1)).getText();
		softly.assertThat(r60).as("test data").contains("OP4.3 用于跟踪制度或流程责任经理绩效（时间、质量和成本）的问责机制存在不足");
		//Row 61
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row61Column1)).getText();
		softly.assertThat(r61).as("test data").contains("OP4.4 总经理层问责机制不存在不足: (1) 未能客观评量总经理层绩效; (2) 未考量所有投资方反馈");
		//Row 62
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row62Column1)).getText();
		softly.assertThat(r62).as("test data").contains("P1.1 由于未意识到风险，而造成制度、程序或屏障（LOP）的遗漏，例如: (1) 新兴高风险问题的危机管理制度; (2) O&P决策制定和问题解决的管理授权制度; (3) 技术审查人员的培训和授权制度; (4) 不道德或违法活动的匿名举报制度; (5) 对标、根本原因分析、自我评估");
		//Row 63
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row63Column1)).getText();
		softly.assertThat(r63).as("test data").contains("P1.2 由于未意识到风险，而造成行为标准的遗漏，例如: (1) 预防粗心大意的失误的行为标准; (2) 关键思考、关键追问和情况警觉的行为标准; (3) 程序使用的行为标准");
		//Row 64
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row64Column1)).getText();
		softly.assertThat(r64).as("test data").contains("P1.3 由于优先级不当而造成程序编写组织发布程序的时间推迟");
		//Row 65
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row65Column1)).getText();
		softly.assertThat(r65).as("test data").contains("P1.4 由于培训组织优先级划分不当而造成实施的推迟");
		//Row 66
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row66Column1)).getText();
		softly.assertThat(r66).as("test data").contains("P1.5 由于管理审查体系存在不足而造成制度、程序或屏障的遗漏");
		//Row 67
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row67Column1)).getText();
		softly.assertThat(r67).as("test data").contains("P2.1 由于程序编写导则存在不足，而造成要求不全面，例如条例、规范要求、用户和内部要求等");
		//Row 68
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row68Column1)).getText();
		softly.assertThat(r68).as("test data").contains("P2.2 验证程序的操作条件存在不足，例如: (1) 进入条件; (2) 退出条件; (3) 中止程序的条件");
		//Row 69
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row69Column1)).getText();
		softly.assertThat(r69).as("test data").contains("P2.3 由于程序编写导则存在不足，而造成程序执行期间要求进行验证的假设存在不足或被遗漏");
		//Row 70
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row70Column1)).getText();
		softly.assertThat(r70).as("test data").contains("P2.4 由于程序编写导则存在不足，而造成工作范围不充分，例如: (1) 逐步说明; (2) 逐项说明");
		//Row 71
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row71Column1)).getText();
		softly.assertThat(r71).as("test data").contains("P2.5 由于程序编写导则存在不足，而造成工后试验、测量或正确性验证方面存在不足");
		//Row 72
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row72Column1)).getText();
		softly.assertThat(r72).as("test data").contains("P2.6 缺少以下部分: (1) 目的说明; (2) 先决条件; (3) 术语定义; (4) 不准做清单经验反馈说明; (5) 参考文件; (6) 用户反馈请求");
		//Row 73
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row73Column1)).getText();
		softly.assertThat(r73).as("test data").contains("P2.7 由于审查存在不足而造成要素的遗漏");
		//Row 74
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row74Column1)).getText();
		softly.assertThat(r74).as("test data").contains("P2.8 由于根本原因分析不到位导致要素的遗漏");
		//Row 75
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row75Column1)).getText();
		softly.assertThat(r75).as("test data").contains("P2.9 由于纠正措施执行不到位导致要素的遗漏");
		//Row 76
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row76Column1)).getText();
		softly.assertThat(r76).as("test data").contains("P3.1 对制度外或程序外进行工作的指导存在不足");
		//Row 77
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row77Column1)).getText();
		softly.assertThat(r77).as("test data").contains("P3.2 由于程序编写导则存在不足，造成通过自检或独立检查单项弱点（SPV）步骤方面存在不足");
		//Row 78
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row78Column1)).getText();
		softly.assertThat(r78).as("test data").contains("P3.3 由于程序编写导则存在不足，造成审查先前不可逆点（PNR）行动方面存在不足");
		//Row 79
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row79Column1)).getText();
		softly.assertThat(r79).as("test data").contains("P3.4 由于程序编写导则存在不足，造成步骤、章节或页次的操作标记使用方面存在不足");
		//Row 80
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row80Column1)).getText();
		softly.assertThat(r80).as("test data").contains("P3.5 由于程序编写导则存在不足，造成使用不准做清单防止违章行为方面存在不足");
		//Row 81
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row81Column1)).getText();
		softly.assertThat(r81).as("test data").contains("P3.6 由于程序编写导则存在不足，造成使用工作现场提示信息防止例行工作出现粗心犯错方面存在不足");
		//Row 82
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row82Column1)).getText();
		softly.assertThat(r82).as("test data").contains("P3.7 由于程序编写导则存在不足，造成使用检查清单防止遗忘相关失误的方面存在不足");
		//Row 83
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row83Column1)).getText();
		softly.assertThat(r83).as("test data").contains("P3.8 由于程序编写导则存在不足，造成使用行为标准提供正面的同事压力以促使遵循规定方面存在不足");
		//Row 84
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row84Column1)).getText();
		softly.assertThat(r84).as("test data").contains("P3.9 由于审查不充分，造成存在偏差控制方面的不足");
		//Row 85
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row85Column1)).getText();
		softly.assertThat(r85).as("test data").contains("P3.10 由于根本原因分析不到位，造成存在偏差控制方面的不足");
		//Row 86
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row86Column1)).getText();
		softly.assertThat(r86).as("test data").contains("P3.11 由于纠正措施执行不到位，造成存在偏差控制方面的不足");
		//Row 87
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row87Column1)).getText();
		softly.assertThat(r87).as("test data").contains("P4.1 由于程序编写导则存在不足，使用需要解释或判断的词语，例如:过度、最大、最小、根据需要等");
		//Row 88
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row88Column1)).getText();
		softly.assertThat(r88).as("test data").contains("P4.2 由于程序编写导则存在不足，使用对一般程序用户而言缺少定义或解释的专业技术词汇");
		//Row 89
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row89Column1)).getText();
		softly.assertThat(r89).as("test data").contains("P4.3 由于程序编写导则存在不足，使用一般程序用户难以读懂的复杂和复合句");
		//Row 90
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row90Column1)).getText();
		softly.assertThat(r90).as("test data").contains("P4.4 由于程序编写导则存在不足，在缺少图纸、图片或图形的情况下描述复杂事物");
		//Row 91
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row91Column1)).getText();
		softly.assertThat(r91).as("test data").contains("P4.5 由于程序编写导则存在不足，使用需要解释的非描述性要求，例如:根据要求、根据需要等");
		//Row 92
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row92Column1)).getText();
		softly.assertThat(r92).as("test data").contains("P4.6 导则或说明存在错误: (1) 过时的导则; (2) 错误的导则或说明; (3) 程序中存在错误的步骤");
		//Row 93
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row93Column1)).getText();
		softly.assertThat(r93).as("test data").contains("P4.7 由于程序审查不充分，造成存在模糊或错误的说明");
		//Row 94
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row94Column1)).getText();
		softly.assertThat(r94).as("test data").contains("P4.8 设备的标识和识别不到位");
		//Row 95
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row95Column1)).getText();
		softly.assertThat(r95).as("test data").contains("P5.1 由于不相关要求造成不必要的工作");
		//Row 96
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row96Column1)).getText();
		softly.assertThat(r96).as("test data").contains("P5.2 没有对程序步骤进行优化，以确保效率和方便执行");
		//Row 97
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row97Column1)).getText();
		softly.assertThat(r97).as("test data").contains("P5.3 加重相关人员或小组不必要的差事（相关小组的多重任务）");
		//Row 98
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row98Column1)).getText();
		softly.assertThat(r98).as("test data").contains("P5.4 制定不必要的工作，而未提高质量，例如进行散弹枪式的根本原因分析，对未发生故障的设备制定不必要工作或制定预防性维修工作");
		//Row 99
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row99Column1)).getText();
		softly.assertThat(r99).as("test data").contains("P5.5 一个组织负责的职责若该由其他组织执行会更有效率");
		//Row 100
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row100Column1)).getText();
		softly.assertThat(r100).as("test data").contains("P5.6 为执行要求而开展不必要的工作，例如长途驱车至场外仓库取用常用工具，填写冗长的表格等");
		//Row 101
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row101Column1)).getText();
		softly.assertThat(r101).as("test data").contains("P5.7 审查人员人数过多，并且未规定角色和责任，导致各个审查员跳过审查，依赖其他人查找失误");
		//Row 102
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row102Column1)).getText();
		softly.assertThat(r102).as("test data").contains("P5.8 在使用软件和连通技术方面存在不足，例如进行RCA的智能电话制度、检查清单、工前会、数据搜索等");
		//Row 103
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable7Row103Column1)).getText();
		softly.assertThat(r103).as("test data").contains("P5.9 使用过时且繁重的技术或工具来执行工作");
	}

	public void chineseReportTabTable6(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Title
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Title)).getText();
		softly.assertThat(title1).as("test data").contains("根本原因分析过程");
		//Headings
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Heading1)).getText();
		softly.assertThat(h1).as("test data").contains("调查问题");
		String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Heading2)).getText();
		softly.assertThat(h2).as("test data").contains("答案");
		String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Heading3)).getText();
		softly.assertThat(h3).as("test data").contains("选择原因");
		//Row1
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row1Column1)).getText();
		softly.assertThat(r1).as("test data").contains("D1: 每年的病假缺勤率（＞5%）是否较高？");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row1Column2)).getText();
		softly.assertThat(r2).as("test data").contains("略过");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row1Column3)).getText();
		softly.assertThat(r3).as("test data").contains("不适用");
		//Row2
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row2Column1)).getText();
		softly.assertThat(r4).as("test data").contains("D2: 加班是否过多?");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row2Column2)).getText();
		softly.assertThat(r5).as("test data").contains("略过");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row2Column3)).getText();
		softly.assertThat(r6).as("test data").contains("不适用");
		//Row3
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row3Column1)).getText();
		softly.assertThat(r7).as("test data").contains("D3: 返工率是否较高?");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row3Column2)).getText();
		softly.assertThat(r8).as("test data").contains("略过");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row3Column3)).getText();
		softly.assertThat(r9).as("test data").contains("不适用");
		//Row4
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row4Column1)).getText();
		softly.assertThat(r10).as("test data").contains("D4: 每单位产量的生产成本（不包括返工成本）是否高于其他类似公司?");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row4Column2)).getText();
		softly.assertThat(r11).as("test data").contains("略过");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row4Column3)).getText();
		softly.assertThat(r12).as("test data").contains("不适用");
		//Row5
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row5Column1)).getText();
		softly.assertThat(r13).as("test data").contains("D5: 会议是否占用人员过多的时间?");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row5Column2)).getText();
		softly.assertThat(r14).as("test data").contains("略过");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row5Column3)).getText();
		softly.assertThat(r15).as("test data").contains("不适用");
		//Row6
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row6Column1)).getText();
		softly.assertThat(r16).as("test data").contains("D6: 该问题是否是同一制度或组织中的重复性问题?");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row6Column2)).getText();
		softly.assertThat(r17).as("test data").contains("略过");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row6Column3)).getText();
		softly.assertThat(r18).as("test data").contains("不适用");
		//Row7
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row7Column1)).getText();
		softly.assertThat(r19).as("test data").contains("D7: 是否有大量积压项？");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row7Column2)).getText();
		softly.assertThat(r20).as("test data").contains("略过");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row7Column3)).getText();
		softly.assertThat(r21).as("test data").contains("不适用");
		//Row8
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row8Column1)).getText();
		softly.assertThat(r22).as("test data").contains("D8: 近期（＜1年）是否存在发生事件发生之前就已经知道其先兆但未进行管理的事件？");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row8Column2)).getText();
		softly.assertThat(r23).as("test data").contains("略过");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row8Column3)).getText();
		softly.assertThat(r24).as("test data").contains("不适用");
		//Row9
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row9Column1)).getText();
		softly.assertThat(r25).as("test data").contains("D9: 共同目的是否用于管理人员和工作人员的奖惩体系?");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row9Column2)).getText();
		softly.assertThat(r26).as("test data").contains("略过");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row9Column3)).getText();
		softly.assertThat(r27).as("test data").contains("不适用");
		//Row10
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row10Column1)).getText();
		softly.assertThat(r28).as("test data").contains("D10: 自我识别的事件数与总事件数的比是低还是高？");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row10Column2)).getText();
		softly.assertThat(r29).as("test data").contains("略过");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row10Column3)).getText();
		softly.assertThat(r30).as("test data").contains("不适用");
		//Row11
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row11Column1)).getText();
		softly.assertThat(r31).as("test data").contains("D11: 在现场的监督时间（＜20%）是否不足以与工作人员进行互动?");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row11Column2)).getText();
		softly.assertThat(r32).as("test data").contains("略过");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row11Column3)).getText();
		softly.assertThat(r33).as("test data").contains("不适用");
		//Row12
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row12Column1)).getText();
		softly.assertThat(r34).as("test data").contains("D12: 主管人员是否在工作之前或工作期间识别并缓解单项弱点?");
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row12Column2)).getText();
		softly.assertThat(r35).as("test data").contains("略过");
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable6Row12Column3)).getText();
		softly.assertThat(r36).as("test data").contains("不适用");
	}

	public void chineseReportTabTable5(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Title
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5Title)).getText();
		softly.assertThat(title1).as("test data").contains("分析iRCA结果");
		//Headings
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5Heading1)).getText();
		softly.assertThat(h1).as("test data").contains("所选HiRCA");
		softly.assertThat(h1).as("test data").contains("结果");
		String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5Heading2)).getText();
		softly.assertThat(h2).as("test data").contains("组织与制度直接原因");
		//HiRCA Level 3 options
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA31)).getText();
		softly.assertThat(s1).as("test data").contains("3.1: 个人层面");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA310)).getText();
		softly.assertThat(s2).as("test data").contains("3.10: \"资格授权\"不充分");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA311)).getText();
		softly.assertThat(s3).as("test data").contains("3.11: \"工作问责\"不充分");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA312)).getText();
		softly.assertThat(s4).as("test data").contains("3.12: \"负担\"的促成因素");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA313)).getText();
		softly.assertThat(s5).as("test data").contains("3.13: \"不当动机\"的促成因素");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA314)).getText();
		softly.assertThat(s6).as("test data").contains("3.14: \"预期风险低\"的促成因素");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA315)).getText();
		softly.assertThat(s7).as("test data").contains("3.15: \"同事互助提醒（好文化）\"不充分的促成因素");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA316)).getText();
		softly.assertThat(s8).as("test data").contains("3.16: 粗心犯错的促成因素");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA317)).getText();
		softly.assertThat(s9).as("test data").contains("3.17: 设备的鉴定、试验和维修(QTM)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA318)).getText();
		softly.assertThat(s10).as("test data").contains("3.18: 知识型错误");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA319)).getText();
		softly.assertThat(s11).as("test data").contains("3.19: 工前会、班前会、交底会参与不足");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA32)).getText();
		softly.assertThat(s12).as("test data").contains("3.2: 组长主管层面");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA320)).getText();
		softly.assertThat(s13).as("test data").contains(" 技术");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA321)).getText();
		softly.assertThat(s14).as("test data").contains("3.21: 高风险情况(");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA322)).getText();
		softly.assertThat(s15).as("test data").contains("3.22: 规则不正确");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA331)).getText();
		softly.assertThat(s16).as("test data").contains("3.3.1: 经理团队资源分配不到位");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA3310)).getText();
		softly.assertThat(s17).as("test data").contains("3.3.10: 经理团队横向沟通体系不完善");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA332)).getText();
		softly.assertThat(s18).as("test data").contains("3.3.2: 经理团队所需培训开展不充分");
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA333)).getText();
		softly.assertThat(s19).as("test data").contains("3.3.3: 经理团队问责制不到位");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA334)).getText();
		softly.assertThat(s20).as("test data").contains("3.3.4: 经理团队对确定工作优先级和计划方面不到位");
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA335)).getText();
		softly.assertThat(s21).as("test data").contains("3.3.5: 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA336)).getText();
		softly.assertThat(s22).as("test data").contains("3.3.6: 经理团队绩效跟踪与趋势分析不到位");
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA337)).getText();
		softly.assertThat(s23).as("test data").contains("3.3.7: 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA338)).getText();
		softly.assertThat(s24).as("test data").contains("3.3.8: 经理团队纠正行动不足");
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA339)).getText();
		softly.assertThat(s25).as("test data").contains("3.3.9: 经理团队垂直沟通体系不完善");
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA34)).getText();
		softly.assertThat(s26).as("test data").contains("3.4: 关键思考和关键追问不充分");
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA35)).getText();
		softly.assertThat(s27).as("test data").contains("3.5: 情况警觉不充分");
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA36)).getText();
		softly.assertThat(s28).as("test data").contains("3.6: 全面性不足");
		String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA37)).getText();
		softly.assertThat(s29).as("test data").contains("3.7: \"偏差控制\"不到位");
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA38)).getText();
		softly.assertThat(s30).as("test data").contains("3.8: \"明确性\"欠缺");
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5HiRCA39)).getText();
		softly.assertThat(s31).as("test data").contains("3.9: \"培训\"不充分");
		//Apparent Causes
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseO1)).getText();
		softly.assertThat(a1).as("test data").contains("O1: 组织职能或结构不足");
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseO3)).getText();
		softly.assertThat(a2).as("test data").contains("O3: 流程设计和改进能力不足");
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseO4)).getText();
		softly.assertThat(a3).as("test data").contains("O4: 组织内沟通存在不足");
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseO5)).getText();
		softly.assertThat(a4).as("test data").contains("O5: 个人技能、规则使用或知识方面存在不足");
		String a5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOO1)).getText();
		softly.assertThat(a5).as("test data").contains("OO1: 共同目标/利益/问责机制存在不足");
		String a6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOO2)).getText();
		softly.assertThat(a6).as("test data").contains("OO2: 组织之间的接口存在不足");
		String a7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOO3)).getText();
		softly.assertThat(a7).as("test data").contains("OO3: 两个接口组织之间的工作职能存在重叠或遗漏");
		String a8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOP1)).getText();
		softly.assertThat(a8).as("test data").contains("OP1: 实施投入存在不足");
		String a9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOP2)).getText();
		softly.assertThat(a9).as("test data").contains("OP2: 绩效监督跟踪和趋势分析存在不足");
		String a10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOP3)).getText();
		softly.assertThat(a10).as("test data").contains("OP3: 自我评价或评估存在不足");
		String a11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseOP4)).getText();
		softly.assertThat(a11).as("test data").contains("OP4: 主人翁意识、责任、角色和问责机制存在不足");
		String a12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseP1)).getText();
		softly.assertThat(a12).as("test data").contains("P1: 制度遗漏");
		String a13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseP2)).getText();
		softly.assertThat(a13).as("test data").contains("P2: 全面性不足");
		String a14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseP3)).getText();
		softly.assertThat(a14).as("test data").contains("P3: 偏差控制存在不足");
		String a15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseP4)).getText();
		softly.assertThat(a15).as("test data").contains("P4: 明确性不足或不正确");
		String a16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseP5)).getText();
		softly.assertThat(a16).as("test data").contains("P5: 要求过多");
		//Headings of sub table
		String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersHeading1)).getText();
		softly.assertThat(h3).as("test data").contains("可能促成因素");
		String h4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersHeading2)).getText();
		softly.assertThat(h4).as("test data").contains("支持证据");
		String h5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersHeading3)).getText();
		softly.assertThat(h5).as("test data").contains("可能的纠正行动");
		//Row1
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow1Column1)).getText();
		softly.assertThat(r1).as("test data").contains("O1.1 管理职能不足: (1) 职能协调人或经理不足; (2) 管理决策职能不足; (3) 问题解决职能不足; (4) 工作计划职能不足; (5) 资源分配职能不足; (6) 管理和人员培训职能不足; (7) 人力资源职能（或结构）不足");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow1Column2)).getText();
		softly.assertThat(r2).as("test data").contains("不适用");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow1Column3)).getText();
		softly.assertThat(r3).as("test data").contains("改进管理职能");
		//Row2
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow2Column1)).getText();
		softly.assertThat(r4).as("test data").contains("O1.2 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow2Column2)).getText();
		softly.assertThat(r5).as("test data").contains("不适用");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow2Column3)).getText();
		softly.assertThat(r6).as("test data").contains("改进跨领域职能");
		//Row3
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow3Column1)).getText();
		softly.assertThat(r7).as("test data").contains("O1.3 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow3Column2)).getText();
		softly.assertThat(r8).as("test data").contains("不适用");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow3Column3)).getText();
		softly.assertThat(r9).as("test data").contains("改组");
		//Row4
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow4Column1)).getText();
		softly.assertThat(r10).as("test data").contains("O1.4 生产组织结构不足，例如: (1) 执行核心工作流程的结构存在不足; (2) 不同生产线的结构分隔存在不足; (3) 班值存在不足");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow4Column2)).getText();
		softly.assertThat(r11).as("test data").contains("不适用");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow4Column3)).getText();
		softly.assertThat(r12).as("test data").contains("改进生产组织结构");
		//Row5
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow5Column1)).getText();
		softly.assertThat(r13).as("test data").contains("O1.5 监督组织结构不足，例如: (1) 生产或管理支持相关管理团队的监督; (2) 生产经理以下管理层级的管理人员监督; (3) 监督结构未基于专业（例如无损试验、QA、QC等）");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow5Column2)).getText();
		softly.assertThat(r14).as("test data").contains("不适用");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow5Column3)).getText();
		softly.assertThat(r15).as("test data").contains("改进监督组织结构");
		//Row6
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow6Column1)).getText();
		softly.assertThat(r16).as("test data").contains("O1.6 管理支持组织结构不足，例如: (1) 招聘结构不足; (2) 继任计划不足; (3) 培训或授权不足");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow6Column2)).getText();
		softly.assertThat(r17).as("test data").contains("不适用");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow6Column3)).getText();
		softly.assertThat(r18).as("test data").contains("改进监督组织结构");
		//Row7
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow7Column1)).getText();
		softly.assertThat(r19).as("test data").contains("O1.7 区分短期和长期工作的组织结构存在不足，例如: (1) 一组工程人员处理短期和长期设计改造; (2) 一组维修人员处理紧急和非紧急工作");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow7Column2)).getText();
		softly.assertThat(r20).as("test data").contains("不适用");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow7Column3)).getText();
		softly.assertThat(r21).as("test data").contains("区分处理短期和长期工作的人员");
		//Row8
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow8Column1)).getText();
		softly.assertThat(r22).as("test data").contains("O1.8 管理层级不足: (1) 规则型和技能型的小组层级过多; (2) 知识型小组层级不足");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow8Column2)).getText();
		softly.assertThat(r23).as("test data").contains("不适用");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow8Column3)).getText();
		softly.assertThat(r24).as("test data").contains("根据工作的复杂性优化管理层级");
		//Row9
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow9Column1)).getText();
		softly.assertThat(r25).as("test data").contains("O1.9 管理跨度不足 : (1) 向一位主管或经理汇报的人员过多; (2) 向一位主管或经理汇报的人员过少");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow9Column2)).getText();
		softly.assertThat(r26).as("test data").contains("不适用");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow9Column3)).getText();
		softly.assertThat(r27).as("test data").contains("根据人员经验优化管理跨度");
		//Row10
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow10Column1)).getText();
		softly.assertThat(r28).as("test data").contains("O1.10 组织设计和改进方面的领导参与存在不足: (1) 领导层未参与组织问题解决过程中; (2) 领导层未参与组织结构和职能设计中");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow10Column2)).getText();
		softly.assertThat(r29).as("test data").contains("不适用");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow10Column3)).getText();
		softly.assertThat(r30).as("test data").contains("提高领导层在组织设计和改进方面的参与");
		//Row11
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow11Column1)).getText();
		softly.assertThat(r31).as("test data").contains("O1.11 管理职能方面的领导参与不足");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow11Column2)).getText();
		softly.assertThat(r32).as("test data").contains("不适用");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow11Column3)).getText();
		softly.assertThat(r33).as("test data").contains("提高领导层在管理职能方面的参与");
		//Row12
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow12Column1)).getText();
		softly.assertThat(r34).as("test data").contains("O3.1 缺少流程和程序设计、缺乏标准改进");
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow12Column2)).getText();
		softly.assertThat(r35).as("test data").contains("不适用");
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow12Column3)).getText();
		softly.assertThat(r36).as("test data").contains("确定协调员或职能经理，监督关键流程的设计和改进");
		//Row13
		String r37 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow13Column1)).getText();
		softly.assertThat(r37).as("test data").contains("O3.2 缺少负责日常流程绩效的流程负责人");
		String r38 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow13Column2)).getText();
		softly.assertThat(r38).as("test data").contains("不适用");
		String r39 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow13Column3)).getText();
		softly.assertThat(r39).as("test data").contains("确定各个关键流程的负责人及其角色和责任");
		//Row14
		String r40 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow14Column1)).getText();
		softly.assertThat(r40).as("test data").contains("O3.3 流程程序设计导则存在不足");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow14Column2)).getText();
		softly.assertThat(r41).as("test data").contains("不适用");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow14Column3)).getText();
		softly.assertThat(r42).as("test data").contains("为有效且可靠的流程制定流程设计导则");
		//Row15
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow15Column1)).getText();
		softly.assertThat(r43).as("test data").contains("O3.4 流程改进存在不足: (1) 定期自评存在不足; (2)绩效跟踪和趋势分析存在不足; (3)流程失效的根本原因分析存在不足");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow15Column2)).getText();
		softly.assertThat(r44).as("test data").contains("不适用");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow15Column3)).getText();
		softly.assertThat(r45).as("test data").contains("制定流程改进导则");
		//Row16
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow16Column1)).getText();
		softly.assertThat(r46).as("test data").contains("O3.5 程序编写导则存在不足，未能有效且可靠地执行流程");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow16Column2)).getText();
		softly.assertThat(r47).as("test data").contains("不适用");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow16Column3)).getText();
		softly.assertThat(r48).as("test data").contains("制定程序编写导则");
		//Row17
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow17Column1)).getText();
		softly.assertThat(r49).as("test data").contains("O3.6 发展流程设计和改进能力方面存在不足: (1) 流程的失效模式与影响分析; (2) 功能设计; (3) 效率和可靠性优化; (4) 教学准备; (5) 流程试验和验证");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow17Column2)).getText();
		softly.assertThat(r50).as("test data").contains("不适用");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow17Column3)).getText();
		softly.assertThat(r51).as("test data").contains("通过培训或指导来发展流程设计和改进能力");
		//Row18
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow18Column1)).getText();
		softly.assertThat(r52).as("test data").contains("O3.7 通过培训或指导来发展流程设计和改进能力");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow18Column2)).getText();
		softly.assertThat(r53).as("test data").contains("不适用");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow18Column3)).getText();
		softly.assertThat(r54).as("test data").contains("当需要时，建立专门的工作组进行流程设计和改进");
		//Row19
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow19Column1)).getText();
		softly.assertThat(r55).as("test data").contains("O4.1 高层管理的接口会议不足以处理共性问题");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow19Column2)).getText();
		softly.assertThat(r56).as("test data").contains("不适用");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow19Column3)).getText();
		softly.assertThat(r57).as("test data").contains("改进接口会议的质量和效率");
		//Row20
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow20Column1)).getText();
		softly.assertThat(r58).as("test data").contains("O4.2 中层管理的接口会议不足以处理共性问题");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow20Column2)).getText();
		softly.assertThat(r59).as("test data").contains("不适用");
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow20Column3)).getText();
		softly.assertThat(r60).as("test data").contains("改进接口会议的质量和效率");
		//Row21
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow21Column1)).getText();
		softly.assertThat(r61).as("test data").contains("O4.3 工作层的接口会议不足以处理共性问题");
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow21Column2)).getText();
		softly.assertThat(r62).as("test data").contains("不适用");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow21Column3)).getText();
		softly.assertThat(r63).as("test data").contains("改进接口会议的质量和效率");
		//Row22
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow22Column1)).getText();
		softly.assertThat(r64).as("test data").contains("O4.4 在使用公用跟踪系统记录各个组织之间情况管理或工作流程沟通方面存在不足");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow22Column2)).getText();
		softly.assertThat(r65).as("test data").contains("不适用");
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow22Column3)).getText();
		softly.assertThat(r66).as("test data").contains("使用公用跟踪系统，记录各方之间的沟通");
		//Row23
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow23Column1)).getText();
		softly.assertThat(r67).as("test data").contains("O4.5 组织中的垂直沟通存在不足，未能报告需要高层管理注意的问题");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow23Column2)).getText();
		softly.assertThat(r68).as("test data").contains("不适用");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow23Column3)).getText();
		softly.assertThat(r69).as("test data").contains("改进垂直沟通方式");
		//Row24
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow24Column1)).getText();
		softly.assertThat(r70).as("test data").contains("O4.6 向工作人员传达管理层期望和经验反馈方面存在不足");
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow24Column2)).getText();
		softly.assertThat(r71).as("test data").contains("不适用");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow24Column3)).getText();
		softly.assertThat(r72).as("test data").contains("改进期望和经验反馈传达的质量和效率");
		//Row25
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow25Column1)).getText();
		softly.assertThat(r73).as("test data").contains("O4.7 由于激励和问责制度存在不足而造成移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）的沟通存在不足");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow25Column2)).getText();
		softly.assertThat(r74).as("test data").contains("不适用");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow25Column3Part1)).getText();
		softly.assertThat(r75).as("test data").contains("改进监督技能，激励开放式的沟通");
		String r75a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow25Column3Part2)).getText();
		softly.assertThat(r75a).as("test data").contains("改进问责制，以便在移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）进行有效沟通");
		//Row26
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow26Column1)).getText();
		softly.assertThat(r76).as("test data").contains("O5.1 技能不足以避免发生粗心大意的失误");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow26Column2)).getText();
		softly.assertThat(r77).as("test data").contains("不适用");
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow26Column3Part1)).getText();
		softly.assertThat(r78).as("test data").contains("建立行为标准，避免发生粗心大意的失误");
		String r78a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow26Column3Part2)).getText();
		softly.assertThat(r78a).as("test data").contains("开展预防粗心大意的失误的培训");    	
		//Row27
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow27Column1)).getText();
		softly.assertThat(r79).as("test data").contains("O5.2 技能不足以遵守规则（例如程序、检查清单、工作现场提示信息、行为标准和不准做清单）");
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow27Column2)).getText();
		softly.assertThat(r80).as("test data").contains("不适用");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow27Column3Part1)).getText();
		softly.assertThat(r81).as("test data").contains("建立程序使用的行为标准");
		String r81a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow27Column3Part2)).getText();
		softly.assertThat(r81a).as("test data").contains("开展防止发生程序失误的培训");    	
		//Row28
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow28Column1)).getText();
		softly.assertThat(r82).as("test data").contains("O5.3 主管和经理知识不足以防止自身的知识型错误");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow28Column2)).getText();
		softly.assertThat(r83).as("test data").contains("不适用");
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow28Column3)).getText();
		softly.assertThat(r84).as("test data").contains("为管理人员开展Error-Free");
		softly.assertThat(r84).as("test data").contains(" 预防培训，改进其最薄弱的领域，包括以下主题: (1) 决策制定; (2) 问题解决; (3) 学习; (4) 设计、分析和建模; (5) 审查; (6) 规划; (7) 沟通; (8) 协商; (9) 风险控制; (10) 绩效控制");
		//Row29
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow29Column1)).getText();
		softly.assertThat(r85).as("test data").contains("O5.4 流程设计和改进方面的管理知识不足: (1) 程序的逐步设计和改进方面存在不足; (2) 屏障的设计和改进方面存在不足; (3) 行为标准的设计和改进方面存在不足; (4) 不准做清单的设计和改进方面存在不足; (5) 检查清单的设计和改进方面存在不足; (6) 工作现场提示信息的设计和改进方面存在不足");
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow29Column2)).getText();
		softly.assertThat(r86).as("test data").contains("不适用");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow29Column3)).getText();
		softly.assertThat(r87).as("test data").contains("开展程序设计和改进方面的Error-Free");
		softly.assertThat(r87).as("test data").contains("培训");    	    	
		//Row30
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow30Column1)).getText();
		softly.assertThat(r88).as("test data").contains("O5.5 人因绩效管理方面的管理知识不足");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow30Column2)).getText();
		softly.assertThat(r89).as("test data").contains("不适用");
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow30Column3)).getText();
		softly.assertThat(r90).as("test data").contains("开展人因绩效管理方面的Error-Free");
		softly.assertThat(r90).as("test data").contains("培训");
		//Row31
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow31Column1)).getText();
		softly.assertThat(r91).as("test data").contains("O5.6 设备性能管理方面的管理知识不足");
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow31Column2)).getText();
		softly.assertThat(r92).as("test data").contains("不适用");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow31Column3)).getText();
		softly.assertThat(r93).as("test data").contains("开展设备性能管理方面的Error-Free");
		softly.assertThat(r93).as("test data").contains("培训");
		//Row32
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow32Column1)).getText();
		softly.assertThat(r94).as("test data").contains("OO1.1 QA和组织之间的共同目标/利益/问责机制的定义存在不足");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow32Column2)).getText();
		softly.assertThat(r95).as("test data").contains("不适用");
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow32Column3)).getText();
		softly.assertThat(r96).as("test data").contains("制定QA和组织之间的共同目标/利益/问责机制");
		//Row33
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow33Column1)).getText();
		softly.assertThat(r97).as("test data").contains("OO1.2 组织间的共同目标/利益/问责机制的定义存在不足");
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow33Column2)).getText();
		softly.assertThat(r98).as("test data").contains("不适用");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow33Column3)).getText();
		softly.assertThat(r99).as("test data").contains("制定组织间的共同目标/利益/问责机制，例如利用奖惩体系鼓励组织之间为了实现整体利益而相互支持");
		//Row34
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow34Column1)).getText();
		softly.assertThat(r100).as("test data").contains("OO1.3 高管和组织管理人员之间的共同目标/利益/问责机制存在不足: (1) 奖励制度不同且不一致; (2) 高管侧重于一个领域而让管理人员负责另一个领域");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow34Column2)).getText();
		softly.assertThat(r101).as("test data").contains("不适用");
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow34Column3)).getText();
		softly.assertThat(r102).as("test data").contains("制定高管和组织管理人员之间的共同目标/利益/问责机制");
		//Row35
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow35Column1)).getText();
		softly.assertThat(r103).as("test data").contains("OO1.4 组织管理人员和主管之间的共同目标/利益/问责机制存在不足: (1) 问责体系不同; (2) 管理人员侧重于一个领域而让主管负责另一个领域");
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow35Column2)).getText();
		softly.assertThat(r104).as("test data").contains("不适用");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow35Column3)).getText();
		softly.assertThat(r105).as("test data").contains("制定组织管理人员和主管之间的共同目标/利益/问责机制");
		//Row36
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow36Column1)).getText();
		softly.assertThat(r106).as("test data").contains("OO1.5 奖励和问责体系不足以建立共同目标/利益");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow36Column2)).getText();
		softly.assertThat(r107).as("test data").contains("不适用");
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow36Column3)).getText();
		softly.assertThat(r108).as("test data").contains("改进奖励体系");
		//Row37
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow37Column1)).getText();
		softly.assertThat(r109).as("test data").contains("OO2.1 组织管理人员共同规定的接口要求存在不足，例如数据传达、资源共享、解决跨组织问题等");
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow37Column2)).getText();
		softly.assertThat(r110).as("test data").contains("不适用");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow37Column3)).getText();
		softly.assertThat(r111).as("test data").contains("改进接口要求");
		//Row38
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow38Column1)).getText();
		softly.assertThat(r112).as("test data").contains("OO2.2 接口流程和方法存在不足，例如会议形式、接口频率和沟通通道存在不足");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow38Column2)).getText();
		softly.assertThat(r113).as("test data").contains("不适用");
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow38Column3)).getText();
		softly.assertThat(r114).as("test data").contains("改进接口流程和方法");
		//Row39
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow39Column1)).getText();
		softly.assertThat(r115).as("test data").contains("OO2.3 由于位置过于分散而造成沟通不佳");
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow39Column2)).getText();
		softly.assertThat(r116).as("test data").contains("不适用");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow39Column3)).getText();
		softly.assertThat(r117).as("test data").contains("通过采用先进的沟通技术，提高沟通的频率和简易度");
		//Row40
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow40Column1)).getText();
		softly.assertThat(r118).as("test data").contains("OO3.1 两个独立的组织执行一个工作职能");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow40Column2)).getText();
		softly.assertThat(r119).as("test data").contains("不适用");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow40Column3)).getText();
		softly.assertThat(r120).as("test data").contains("简化重叠的工作职能");
		//Row41
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow41Column1)).getText();
		softly.assertThat(r121).as("test data").contains("OO3.2 没有要求两个接口部门执行所需的工作职能");
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow41Column2)).getText();
		softly.assertThat(r122).as("test data").contains("不适用");
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow41Column3)).getText();
		softly.assertThat(r123).as("test data").contains("重新定义角色和责任，纳入两个接口组织之间被遗漏的工作职能");
		//Row42
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow42Column1)).getText();
		softly.assertThat(r124).as("test data").contains("OP1.1 人员配置和预算不足以实施制度或执行程序");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow42Column2)).getText();
		softly.assertThat(r125).as("test data").contains("不适用");
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow42Column3Part1)).getText();
		softly.assertThat(r126).as("test data").contains("增加人员编制");
		String r126a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow42Column3Part2)).getText();
		softly.assertThat(r126a).as("test data").contains("评估制度管理人员或者负责该制度的组织管理人员的能力");
		//Row43
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow43Column1)).getText();
		softly.assertThat(r127).as("test data").contains("OP1.2 相关人员的培训和授权不足以实施制度");
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow43Column2)).getText();
		softly.assertThat(r128).as("test data").contains("不适用");
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow43Column3Part1)).getText();
		softly.assertThat(r129).as("test data").contains("增加培训预算");
		String r129a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow43Column3Part2)).getText();
		softly.assertThat(r129a).as("test data").contains("针对高风险或者要求知识型绩效的工作开展培训课程");
		//Row44
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow44Column1)).getText();
		softly.assertThat(r130).as("test data").contains("OP1.3 管理层对制度落实行动的跟进存在不足");
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow44Column2)).getText();
		softly.assertThat(r131).as("test data").contains("不适用");
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow44Column3Part1)).getText();
		softly.assertThat(r132).as("test data").contains("改进管理层工作投入和跟踪系统");
		String r132a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow44Column3Part2)).getText();
		softly.assertThat(r132a).as("test data").contains("评估制度管理人员或者负责该制度的组织管理人员的能力");
		//Row45
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow45Column1)).getText();
		softly.assertThat(r133).as("test data").contains("OP1.4 对落实制度的管理支持存在不足");
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow45Column2)).getText();
		softly.assertThat(r134).as("test data").contains("不适用");
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow45Column3Part1)).getText();
		softly.assertThat(r135).as("test data").contains("改进管理支持");
		String r135a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow45Column3Part2)).getText();
		softly.assertThat(r135a).as("test data").contains("评估制度管理人员或者负责该制度的组织管理人员的能力");
		//Row46
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow46Column1)).getText();
		softly.assertThat(r136).as("test data").contains("OP2.1 先行指标存在不足");
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow46Column2)).getText();
		softly.assertThat(r137).as("test data").contains("不适用");
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow46Column3Part1)).getText();
		softly.assertThat(r138).as("test data").contains("改进先行指标");
		String r138a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow46Column3Part2)).getText();
		softly.assertThat(r138a).as("test data").contains("使用过去的绩效对先行指标进行核实");
		//Row47
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow47Column1)).getText();
		softly.assertThat(r139).as("test data").contains("OP2.2 实时指标存在不足");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow47Column2)).getText();
		softly.assertThat(r140).as("test data").contains("不适用");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow47Column3Part1)).getText();
		softly.assertThat(r141).as("test data").contains("改进实时指标");
		String r141a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow47Column3Part2)).getText();
		softly.assertThat(r141a).as("test data").contains("使用过去的绩效对实时指标进行核实");
		//Row48
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow48Column1)).getText();
		softly.assertThat(r142).as("test data").contains("OP2.3 滞后指标存在不足");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow48Column2)).getText();
		softly.assertThat(r143).as("test data").contains("不适用");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow48Column3Part1)).getText();
		softly.assertThat(r144).as("test data").contains("改进滞后标志");
		String r144a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow48Column3Part2)).getText();
		softly.assertThat(r144a).as("test data").contains("使其简单但能够反映所有主要O&P问题");
		//Row49
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow49Column1)).getText();
		softly.assertThat(r145).as("test data").contains("OP2.4 管理层在绩效监督跟踪和趋势分析的结果使用方面存在不足");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow49Column2)).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow49Column3)).getText();
		softly.assertThat(r147).as("test data").contains("改进绩效提升的管理决策流程，纳入绩效监督跟踪和趋势分析中的数据");
		//Row50
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow50Column1)).getText();
		softly.assertThat(r148).as("test data").contains("OP2.5 在将RCA共因分析作为监督工具方面存在不足");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow50Column2)).getText();
		softly.assertThat(r149).as("test data").contains("不适用");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow50Column3Part1)).getText();
		softly.assertThat(r150).as("test data").contains("改进共因分析方法");
		String r150a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow50Column3Part2)).getText();
		softly.assertThat(r150a).as("test data").contains("开展Error-Free");
		softly.assertThat(r150a).as("test data").contains("共因培训");
		//Row51
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow51Column1)).getText();
		softly.assertThat(r151).as("test data").contains("OP2.6 在使用现场观察结果作为监督工具方面存在不足");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow51Column2)).getText();
		softly.assertThat(r152).as("test data").contains("不适用");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow51Column3)).getText();
		softly.assertThat(r153).as("test data").contains("改进绩效提升的管理决策流程，纳入现场观察中的数据");
		//Row52
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow52Column1)).getText();
		softly.assertThat(r154).as("test data").contains("OP3.1 个人的自我分析存在不足");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow52Column2)).getText();
		softly.assertThat(r155).as("test data").contains("不适用");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow52Column3)).getText();
		softly.assertThat(r156).as("test data").contains("开展Error-Free");
		softly.assertThat(r156).as("test data").contains("自我评价培训，使人员认识到他或她容易发生失误的方面");
		//Row53
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow53Column1)).getText();
		softly.assertThat(r157).as("test data").contains("OP3.2 监督小组的自我分析存在不足");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow53Column2)).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow53Column3)).getText();
		softly.assertThat(r159).as("test data").contains("开展Error-Free");
		softly.assertThat(r159).as("test data").contains("自我评价培训，使主管认识到他或她的小组容易发生失误的方面");
		//Row54
		String r160 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow54Column1)).getText();
		softly.assertThat(r160).as("test data").contains("OP3.3 管理组织的自我分析存在不足");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow54Column2)).getText();
		softly.assertThat(r161).as("test data").contains("不适用");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow54Column3)).getText();
		softly.assertThat(r162).as("test data").contains("开展Error-Free");
		softly.assertThat(r162).as("test data").contains("自我评价培训，使经理认识到他或她的组织容易发生失误的方面");
		//Row55
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow55Column1)).getText();
		softly.assertThat(r163).as("test data").contains("OP3.4 高风险制度或程序的自我评估存在不足");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow55Column2)).getText();
		softly.assertThat(r164).as("test data").contains("不适用");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow55Column3)).getText();
		softly.assertThat(r165).as("test data").contains("改进自我评估制度的频率和彻底性");
		//Row56
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow56Column1)).getText();
		softly.assertThat(r166).as("test data").contains("OP3.5 对组织事件的根本原因分析分析质量差、事件数据收集和启动调查条件存在不足");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow56Column2)).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow56Column3)).getText();
		softly.assertThat(r168).as("test data").contains("改进执行组织事件根本原因分析的质量、数据收集和启动调查条件");
		//Row57
		String r169 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow57Column1)).getText();
		softly.assertThat(r169).as("test data").contains("OP3.6 对组织事件的共因分析没有定期执行（不够频繁）或是共因分析质量差");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow57Column2)).getText();
		softly.assertThat(r170).as("test data").contains("不适用");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow57Column3)).getText();
		softly.assertThat(r171).as("test data").contains("改进执行组织事件共因分析的频率和质量。评估可以识别弱点加以改进。");
		//Row58
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow58Column1)).getText();
		softly.assertThat(r172).as("test data").contains("OP4.1 制度或流程负责人规定方面存在不足");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow58Column2)).getText();
		softly.assertThat(r173).as("test data").contains("不适用");
		String r174 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow58Column3)).getText();
		softly.assertThat(r174).as("test data").contains("改进制度管理人员的负责人规定");
		//Row59
		String r175 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow59Column1)).getText();
		softly.assertThat(r175).as("test data").contains("OP4.2 制度或流程相关人员的角色和责任规定方面存在不足");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow59Column2)).getText();
		softly.assertThat(r176).as("test data").contains("不适用");
		String r177 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow59Column3)).getText();
		softly.assertThat(r177).as("test data").contains("改进制度管理人员角色和责任的规定");
		//Row60
		String r178 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow60Column1)).getText();
		softly.assertThat(r178).as("test data").contains("OP4.3 用于跟踪制度或流程责任经理绩效（时间、质量和成本）的问责机制存在不足");
		String r179 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow60Column2)).getText();
		softly.assertThat(r179).as("test data").contains("不适用");
		String r180 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow60Column3)).getText();
		softly.assertThat(r180).as("test data").contains("改进问责机制，使其涵盖三个同样重要的方面（时间、质量和成本）。体系应当有助于实现良好绩效而非侧重于惩罚");
		//Row61
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow61Column1)).getText();
		softly.assertThat(r181).as("test data").contains("OP4.4 总经理层问责机制不存在不足: (1) 未能客观评量总经理层绩效; (2) 未考量所有投资方反馈");
		String r182 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow61Column2)).getText();
		softly.assertThat(r182).as("test data").contains("不适用");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow61Column3)).getText();
		softly.assertThat(r183).as("test data").contains("改进问责机制，使其涵盖总经理层");
		//Row62
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow62Column1)).getText();
		softly.assertThat(r184).as("test data").contains("P1.1 由于未意识到风险，而造成制度、程序或屏障（LOP）的遗漏，例如: (1) 新兴高风险问题的危机管理制度; (2) O&P决策制定和问题解决的管理授权制度; (3) 技术审查人员的培训和授权制度; (4) 不道德或违法活动的匿名举报制度; (5) 对标、根本原因分析、自我评估");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow62Column2)).getText();
		softly.assertThat(r185).as("test data").contains("不适用");
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part1)).getText();
		softly.assertThat(r186).as("test data").contains("编写被遗漏的制度");
		String r186a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part2)).getText();
		softly.assertThat(r186a).as("test data").contains("识别其他被遗漏的类似制度，并实施纠正行动");
		String r186b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part3)).getText();
		softly.assertThat(r186b).as("test data").contains("开展规则和制度设置的管理培训");
		String r186c = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow62Column3Part4)).getText();
		softly.assertThat(r186c).as("test data").contains("改进QA审计流程，识别被遗漏的制度");
		//Row63
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow63Column1)).getText();
		softly.assertThat(r187).as("test data").contains("P1.2 由于未意识到风险，而造成行为标准的遗漏，例如: (1) 预防粗心大意的失误的行为标准; (2) 关键思考、关键追问和情况警觉的行为标准; (3) 程序使用的行为标准");
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow63Column2)).getText();
		softly.assertThat(r188).as("test data").contains("不适用");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part1)).getText();
		softly.assertThat(r189).as("test data").contains("制定被遗漏的标准");
		String r189a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part2)).getText();
		softly.assertThat(r189a).as("test data").contains("识别其他被遗漏的类似标准，并实施纠正行动");
		String r189b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part3)).getText();
		softly.assertThat(r189b).as("test data").contains("开展标准设置方面的管理培训");
		String r189c = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow63Column3Part4)).getText();
		softly.assertThat(r189c).as("test data").contains("改进QA审计流程，识别被遗漏的行为标准");
		//Row64
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow64Column1)).getText();
		softly.assertThat(r190).as("test data").contains("P1.3 由于优先级不当而造成程序编写组织发布程序的时间推迟");
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow64Column2)).getText();
		softly.assertThat(r191).as("test data").contains("不适用");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow64Column3)).getText();
		softly.assertThat(r192).as("test data").contains("改进优先级体系");
		//Row65
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow65Column1)).getText();
		softly.assertThat(r193).as("test data").contains("P1.4 由于培训组织优先级划分不当而造成实施的推迟");
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow65Column2)).getText();
		softly.assertThat(r194).as("test data").contains("不适用");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow65Column3)).getText();
		softly.assertThat(r195).as("test data").contains("改进优先级体系");
		//Row66
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow66Column1)).getText();
		softly.assertThat(r196).as("test data").contains("P1.5 由于管理审查体系存在不足而造成制度、程序或屏障的遗漏");
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow66Column2)).getText();
		softly.assertThat(r197).as("test data").contains("不适用");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow66Column3)).getText();
		softly.assertThat(r198).as("test data").contains("独立管理审查体系存在不足");
		//Row67
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow67Column1)).getText();
		softly.assertThat(r199).as("test data").contains("P2.1 由于程序编写导则存在不足，而造成要求不全面，例如条例、规范要求、用户和内部要求等");
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow67Column2)).getText();
		softly.assertThat(r200).as("test data").contains("不适用");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow67Column3Part1)).getText();
		softly.assertThat(r201).as("test data").contains("开展程序设计的培训");
		String r201a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow67Column3Part2)).getText();
		softly.assertThat(r201a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row68
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow68Column1)).getText();
		softly.assertThat(r202).as("test data").contains("P2.2 验证程序的操作条件存在不足，例如: (1) 进入条件; (2) 退出条件; (3) 中止程序的条件");
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow68Column2)).getText();
		softly.assertThat(r203).as("test data").contains("不适用");
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow68Column3Part1)).getText();
		softly.assertThat(r204).as("test data").contains("开展程序设计的培训");
		String r204a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow68Column3Part2)).getText();
		softly.assertThat(r204a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row69
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow69Column1)).getText();
		softly.assertThat(r205).as("test data").contains("P2.3 由于程序编写导则存在不足，而造成程序执行期间要求进行验证的假设存在不足或被遗漏");
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow69Column2)).getText();
		softly.assertThat(r206).as("test data").contains("不适用");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow69Column3Part1)).getText();
		softly.assertThat(r207).as("test data").contains("开展程序设计的培训");
		String r207a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow69Column3Part2)).getText();
		softly.assertThat(r207a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row70
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow70Column1)).getText();
		softly.assertThat(r208).as("test data").contains("P2.4 由于程序编写导则存在不足，而造成工作范围不充分，例如: (1) 逐步说明; (2) 逐项说明");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow70Column2)).getText();
		softly.assertThat(r209).as("test data").contains("不适用");
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow70Column3Part1)).getText();
		softly.assertThat(r210).as("test data").contains("开展程序设计的培训");
		String r210a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow70Column3Part2)).getText();
		softly.assertThat(r210a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row71
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow71Column1)).getText();
		softly.assertThat(r211).as("test data").contains("P2.5 由于程序编写导则存在不足，而造成工后试验、测量或正确性验证方面存在不足");
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow71Column2)).getText();
		softly.assertThat(r212).as("test data").contains("不适用");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow71Column3Part1)).getText();
		softly.assertThat(r213).as("test data").contains("开展程序设计的培训");
		String r213a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow71Column3Part2)).getText();
		softly.assertThat(r213a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row72
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow72Column1)).getText();
		softly.assertThat(r214).as("test data").contains("P2.6 缺少以下部分: (1) 目的说明; (2) 先决条件; (3) 术语定义; (4) 不准做清单经验反馈说明; (5) 参考文件; (6) 用户反馈请求");
		String r215 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow72Column2)).getText();
		softly.assertThat(r215).as("test data").contains("不适用");
		String r216 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow72Column3Part1)).getText();
		softly.assertThat(r216).as("test data").contains("开展程序设计的培训");
		String r216a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow72Column3Part2)).getText();
		softly.assertThat(r216a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row73
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow73Column1)).getText();
		softly.assertThat(r217).as("test data").contains("P2.7 由于审查存在不足而造成要素的遗漏");
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow73Column2)).getText();
		softly.assertThat(r218).as("test data").contains("不适用");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow73Column3)).getText();
		softly.assertThat(r219).as("test data").contains("开展审查方面的培训");
		//Row74
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow74Column1)).getText();
		softly.assertThat(r220).as("test data").contains("P2.8 由于根本原因分析不到位导致要素的遗漏");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow74Column2)).getText();
		softly.assertThat(r221).as("test data").contains("不适用");
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow74Column3)).getText();
		softly.assertThat(r222).as("test data").contains("开展根本原因分析方面的培训");
		//Row75
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow75Column1)).getText();
		softly.assertThat(r223).as("test data").contains("P2.9 由于纠正措施执行不到位导致要素的遗漏");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow75Column2)).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow75Column3)).getText();
		softly.assertThat(r225).as("test data").contains("开展纠正措施执行进度的监督跟进");
		//Row76
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow76Column1)).getText();
		softly.assertThat(r226).as("test data").contains("P3.1 对制度外或程序外进行工作的指导存在不足");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow76Column2)).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		String r228 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow76Column3Part1)).getText();
		softly.assertThat(r228).as("test data").contains("开展程序设计的培训");
		String r228a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow76Column3Part2)).getText();
		softly.assertThat(r228a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row77
		String r229 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow77Column1)).getText();
		softly.assertThat(r229).as("test data").contains("P3.2 由于程序编写导则存在不足，造成通过自检或独立检查单项弱点（SPV）步骤方面存在不足");
		String r230 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow77Column2)).getText();
		softly.assertThat(r230).as("test data").contains("不适用");
		String r231 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow77Column3Part1)).getText();
		softly.assertThat(r231).as("test data").contains("开展程序设计的培训");
		String r231a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow77Column3Part2)).getText();
		softly.assertThat(r231a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row78
		String r232 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow78Column1)).getText();
		softly.assertThat(r232).as("test data").contains("P3.3 由于程序编写导则存在不足，造成审查先前不可逆点（PNR）行动方面存在不足");
		String r233 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow78Column2)).getText();
		softly.assertThat(r233).as("test data").contains("不适用");
		String r234 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow78Column3Part1)).getText();
		softly.assertThat(r234).as("test data").contains("开展程序设计的培训");
		String r234a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow78Column3Part2)).getText();
		softly.assertThat(r234a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row79
		String r235 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow79Column1)).getText();
		softly.assertThat(r235).as("test data").contains("P3.4 由于程序编写导则存在不足，造成步骤、章节或页次的操作标记使用方面存在不足");
		String r236 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow79Column2)).getText();
		softly.assertThat(r236).as("test data").contains("不适用");
		String r237 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow79Column3Part1)).getText();
		softly.assertThat(r237).as("test data").contains("开展程序设计的培训");
		String r237a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow79Column3Part2)).getText();
		softly.assertThat(r237a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row80
		String r238 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow80Column1)).getText();
		softly.assertThat(r238).as("test data").contains("P3.5 由于程序编写导则存在不足，造成使用不准做清单防止违章行为方面存在不足");
		String r239 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow80Column2)).getText();
		softly.assertThat(r239).as("test data").contains("不适用");
		String r240 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow80Column3Part1)).getText();
		softly.assertThat(r240).as("test data").contains("开展程序设计的培训");
		String r240a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow80Column3Part2)).getText();
		softly.assertThat(r240a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row81
		String r241 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow81Column1)).getText();
		softly.assertThat(r241).as("test data").contains("P3.6 由于程序编写导则存在不足，造成使用工作现场提示信息防止例行工作出现粗心犯错方面存在不足");
		String r242 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow81Column2)).getText();
		softly.assertThat(r242).as("test data").contains("不适用");
		String r243 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow81Column3Part1)).getText();
		softly.assertThat(r243).as("test data").contains("开展程序设计的培训");
		String r243a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow81Column3Part2)).getText();
		softly.assertThat(r243a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row82
		String r244 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow82Column1)).getText();
		softly.assertThat(r244).as("test data").contains("P3.7 由于程序编写导则存在不足，造成使用检查清单防止遗忘相关失误的方面存在不足");
		String r245 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow82Column2)).getText();
		softly.assertThat(r245).as("test data").contains("不适用");
		String r246 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow82Column3Part1)).getText();
		softly.assertThat(r246).as("test data").contains("开展程序设计的培训");
		String r246a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow82Column3Part2)).getText();
		softly.assertThat(r246a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row83
		String r247 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow83Column1)).getText();
		softly.assertThat(r247).as("test data").contains("P3.8 由于程序编写导则存在不足，造成使用行为标准提供正面的同事压力以促使遵循规定方面存在不足");
		String r248 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow83Column2)).getText();
		softly.assertThat(r248).as("test data").contains("不适用");
		String r249 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow83Column3Part1)).getText();
		softly.assertThat(r249).as("test data").contains("开展程序设计的培训");
		String r249a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow83Column3Part2)).getText();
		softly.assertThat(r249a).as("test data").contains("改进存在缺陷的导则或程序");
		//Row84
		String r250 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow84Column1)).getText();
		softly.assertThat(r250).as("test data").contains("P3.9 由于审查不充分，造成存在偏差控制方面的不足");
		String r251 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow84Column2)).getText();
		softly.assertThat(r251).as("test data").contains("不适用");
		String r252 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow84Column3)).getText();
		softly.assertThat(r252).as("test data").contains("开展审查方面的培训");
		//Row85
		String r253 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow85Column1)).getText();
		softly.assertThat(r253).as("test data").contains("P3.10 由于根本原因分析不到位，造成存在偏差控制方面的不足");
		String r254 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow85Column2)).getText();
		softly.assertThat(r254).as("test data").contains("不适用");
		String r255 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow85Column3)).getText();
		softly.assertThat(r255).as("test data").contains("开展根本原因分析方面的培训");
		//Row86
		String r256 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow86Column1)).getText();
		softly.assertThat(r256).as("test data").contains("P3.11 由于纠正措施执行不到位，造成存在偏差控制方面的不足");
		String r257 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow86Column2)).getText();
		softly.assertThat(r257).as("test data").contains("不适用");
		String r258 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow86Column3)).getText();
		softly.assertThat(r258).as("test data").contains("改善纠正措施的监督跟踪");
		//Row87
		String r259 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow87Column1)).getText();
		softly.assertThat(r259).as("test data").contains("P4.1 由于程序编写导则存在不足，使用需要解释或判断的词语，例如:过度、最大、最小、根据需要等");
		String r260 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow87Column2)).getText();
		softly.assertThat(r260).as("test data").contains("不适用");
		String r261 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow87Column3Part1)).getText();
		softly.assertThat(r261).as("test data").contains("开展程序设计的培训");
		String r261a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow87Column3Part2)).getText();
		softly.assertThat(r261a).as("test data").contains("改进存在缺陷的导则或程序");
		String r261b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow87Column3Part3)).getText();
		softly.assertThat(r261b).as("test data").contains("改进程序审查流程");
		//Row88
		String r262 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow88Column1)).getText();
		softly.assertThat(r262).as("test data").contains("P4.2 由于程序编写导则存在不足，使用对一般程序用户而言缺少定义或解释的专业技术词汇");
		String r263 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow88Column2)).getText();
		softly.assertThat(r263).as("test data").contains("不适用");
		String r264 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow88Column3Part1)).getText();
		softly.assertThat(r264).as("test data").contains("开展程序设计的培训");
		String r264a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow88Column3Part2)).getText();
		softly.assertThat(r264a).as("test data").contains("改进存在缺陷的导则或程序");
		String r264b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow88Column3Part3)).getText();
		softly.assertThat(r264b).as("test data").contains("改进程序审查流程");
		//Row89
		String r265 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow89Column1)).getText();
		softly.assertThat(r265).as("test data").contains("P4.3 由于程序编写导则存在不足，使用一般程序用户难以读懂的复杂和复合句");
		String r266 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow89Column2)).getText();
		softly.assertThat(r266).as("test data").contains("不适用");
		String r267 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow89Column3Part1)).getText();
		softly.assertThat(r267).as("test data").contains("开展程序设计的培训");
		String r267a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow89Column3Part2)).getText();
		softly.assertThat(r267a).as("test data").contains("改进存在缺陷的导则或程序");
		String r267b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow89Column3Part3)).getText();
		softly.assertThat(r267b).as("test data").contains("改进程序审查流程");
		//Row90
		String r268 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow90Column1)).getText();
		softly.assertThat(r268).as("test data").contains("P4.4 由于程序编写导则存在不足，在缺少图纸、图片或图形的情况下描述复杂事物");
		String r269 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow90Column2)).getText();
		softly.assertThat(r269).as("test data").contains("不适用");
		String r270 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow90Column3Part1)).getText();
		softly.assertThat(r270).as("test data").contains("开展程序设计的培训");
		String r270a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow90Column3Part2)).getText();
		softly.assertThat(r270a).as("test data").contains("改进存在缺陷的导则或程序");
		String r270b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow90Column3Part3)).getText();
		softly.assertThat(r270b).as("test data").contains("改进程序审查流程");
		//Row91
		String r271 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow91Column1)).getText();
		softly.assertThat(r271).as("test data").contains("P4.5 由于程序编写导则存在不足，使用需要解释的非描述性要求，例如:根据要求、根据需要等");
		String r272 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow91Column2)).getText();
		softly.assertThat(r272).as("test data").contains("不适用");
		String r273 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow91Column3Part1)).getText();
		softly.assertThat(r273).as("test data").contains("开展程序设计的培训");
		String r273a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow91Column3Part2)).getText();
		softly.assertThat(r273a).as("test data").contains("改进存在缺陷的导则或程序");
		String r273b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow91Column3Part3)).getText();
		softly.assertThat(r273b).as("test data").contains("改进程序审查流程");
		//Row92
		String r274 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow92Column1)).getText();
		softly.assertThat(r274).as("test data").contains("P4.6 导则或说明存在错误: (1) 过时的导则; (2) 错误的导则或说明; (3) 程序中存在错误的步骤");
		String r275 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow92Column2)).getText();
		softly.assertThat(r275).as("test data").contains("不适用");
		String r276 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow92Column3Part1)).getText();
		softly.assertThat(r276).as("test data").contains("开展程序设计的培训");
		String r276a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow92Column3Part2)).getText();
		softly.assertThat(r276a).as("test data").contains("改进存在缺陷的导则或程序");
		String r276b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow92Column3Part3)).getText();
		softly.assertThat(r276b).as("test data").contains("改进程序审查流程");
		//Row93
		String r277 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow93Column1)).getText();
		softly.assertThat(r277).as("test data").contains("P4.7 由于程序审查不充分，造成存在模糊或错误的说明");
		String r278 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow93Column2)).getText();
		softly.assertThat(r278).as("test data").contains("不适用");
		String r279 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow93Column3Part1)).getText();
		softly.assertThat(r279).as("test data").contains("开展程序审查的培训");
		String r279a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow93Column3Part2)).getText();
		softly.assertThat(r279a).as("test data").contains("改进程序审查流程");
		//Row94
		String r280 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow94Column1)).getText();
		softly.assertThat(r280).as("test data").contains("P4.8 设备的标识和识别不到位");
		String r281 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow94Column2)).getText();
		softly.assertThat(r281).as("test data").contains("不适用");
		String r282 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow94Column3)).getText();
		softly.assertThat(r282).as("test data").contains("改进设备标识和识别");
		//Row95
		String r283 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow95Column1)).getText();
		softly.assertThat(r283).as("test data").contains("P5.1 由于不相关要求造成不必要的工作");
		String r284 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow95Column2)).getText();
		softly.assertThat(r284).as("test data").contains("不适用");
		String r285 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow95Column3Part1)).getText();
		softly.assertThat(r285).as("test data").contains("减少导则或程序中的负担");
		String r285a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow95Column3Part2)).getText();
		softly.assertThat(r285a).as("test data").contains("开展Error-Free");
		softly.assertThat(r285a).as("test data").contains("工作流程优化的培训");
		//Row96
		String r286 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow96Column1)).getText();
		softly.assertThat(r286).as("test data").contains("P5.2 没有对程序步骤进行优化，以确保效率和方便执行");
		String r287 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow96Column2)).getText();
		softly.assertThat(r287).as("test data").contains("不适用");
		String r288 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow96Column3Part1)).getText();
		softly.assertThat(r288).as("test data").contains("优化程序，以确保效率和方便执行");
		String r288a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow96Column3Part2)).getText();
		softly.assertThat(r288a).as("test data").contains("开展Error-Free");
		softly.assertThat(r288a).as("test data").contains("工作流程优化的培训");
		//Row97
		String r289 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow97Column1)).getText();
		softly.assertThat(r289).as("test data").contains("P5.3 加重相关人员或小组不必要的差事（相关小组的多重任务）");
		String r290 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow97Column2)).getText();
		softly.assertThat(r290).as("test data").contains("不适用");
		String r291 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow97Column3Part1)).getText();
		softly.assertThat(r291).as("test data").contains("避免同时进行多重任务");
		String r291a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow97Column3Part2)).getText();
		softly.assertThat(r291a).as("test data").contains("开展Error-Free");
		softly.assertThat(r291a).as("test data").contains("工作流程优化的培训");
		//Row98
		String r292 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow98Column1)).getText();
		softly.assertThat(r292).as("test data").contains("P5.4 制定不必要的工作，而未提高质量，例如进行散弹枪式的根本原因分析，对未发生故障的设备制定不必要工作或制定预防性维修工作");
		String r293 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow98Column2)).getText();
		softly.assertThat(r293).as("test data").contains("不适用");
		String r294 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow98Column3Part1)).getText();
		softly.assertThat(r294).as("test data").contains("改善根本原因分析流程");
		String r294a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow98Column3Part2)).getText();
		softly.assertThat(r294a).as("test data").contains("改善预防性维修工作流程");
		String r294b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow98Column3Part3)).getText();
		softly.assertThat(r294b).as("test data").contains("开展Error-Free");
		softly.assertThat(r294b).as("test data").contains("工作流程优化的培训");
		//Row99
		String r295 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow99Column1)).getText();
		softly.assertThat(r295).as("test data").contains("P5.5 一个组织负责的职责若该由其他组织执行会更有效率");
		String r296 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow99Column2)).getText();
		softly.assertThat(r296).as("test data").contains("不适用");
		String r297 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow99Column3)).getText();
		softly.assertThat(r297).as("test data").contains("组织改组以提高效率和绩效");
		//Row100
		String r298 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow100Column1)).getText();
		softly.assertThat(r298).as("test data").contains("P5.6 为执行要求而开展不必要的工作，例如长途驱车至场外仓库取用常用工具，填写冗长的表格等");
		String r299 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow100Column2)).getText();
		softly.assertThat(r299).as("test data").contains("不适用");
		String r300 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow100Column3Part1)).getText();
		softly.assertThat(r300).as("test data").contains("减少导则或程序中的负担");
		String r300a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow100Column3Part2)).getText();
		softly.assertThat(r300a).as("test data").contains("开展Error-Free");
		softly.assertThat(r300a).as("test data").contains("工作流程优化的培训");
		//Row101
		String r301 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow101Column1)).getText();
		softly.assertThat(r301).as("test data").contains("P5.7 审查人员人数过多，并且未规定角色和责任，导致各个审查员跳过审查，依赖其他人查找失误");
		String r302 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow101Column2)).getText();
		softly.assertThat(r302).as("test data").contains("不适用");
		String r303 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part1)).getText();
		softly.assertThat(r303).as("test data").contains("开展Error-Free");
		softly.assertThat(r303).as("test data").contains("工作流程优化的培训");
		String r303a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part2)).getText();
		softly.assertThat(r303a).as("test data").contains("开展审查培训");
		String r303b = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part3)).getText();
		softly.assertThat(r303b).as("test data").contains("规定审查人员的角色和责任");
		String r303c = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow101Column3Part4)).getText();
		softly.assertThat(r303c).as("test data").contains("对审查人员实行问责制");
		//Row102
		String r304 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow102Column1)).getText();
		softly.assertThat(r304).as("test data").contains("P5.8 在使用软件和连通技术方面存在不足，例如进行RCA的智能电话制度、检查清单、工前会、数据搜索等");
		String r305 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow102Column2)).getText();
		softly.assertThat(r305).as("test data").contains("不适用");
		String r306 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow102Column3)).getText();
		softly.assertThat(r306).as("test data").contains("使用软件或智能电话技术跟踪沟通情况");
		//Row103
		String r307 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow103Column1)).getText();
		softly.assertThat(r307).as("test data").contains("P5.9 使用过时且繁重的技术或工具来执行工作");
		String r308 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow103Column2)).getText();
		softly.assertThat(r308).as("test data").contains("不适用");
		String r309 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable5ApparentCauseAnswersRow103Column3)).getText();
		softly.assertThat(r309).as("test data").contains("改进工作技术或工具");
	}

	public void chineseReportTabTable4(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Contributing factors
		//Headings
		String h7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Heading1)).getText();
		softly.assertThat(h7).as("test data").contains("促成因素");
		String h8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Heading2)).getText();
		softly.assertThat(h8).as("test data").contains("重要性分级");
		String h9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Heading3)).getText();
		softly.assertThat(h9).as("test data").contains("纠正行动");
		if(browserName.equals("chrome"))
		{
			//Row 1
			String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row1Column1)).getText();
			softly.assertThat(r19).as("test data").contains("P5.9 使用过时且繁重的技术或工具来执行工作");
			String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row1Column2)).getText();
			softly.assertThat(r20).as("test data").contains("中");
			String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row1Column3)).getText();
			softly.assertThat(r21).as("test data").contains("改进工作技术或工具");
			//Row 2
			String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row2Column1)).getText();
			softly.assertThat(r22).as("test data").contains("OP3.1 个人的自我分析存在不足");
			String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row2Column3)).getText();
			softly.assertThat(r23).as("test data").contains("开展Error-Free");
			softly.assertThat(r23).as("test data").contains("自我评价培训，使人员认识到他或她容易发生失误的方面");
		}
		else{
			//Row 51
			String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row1Column1)).getText();
			softly.assertThat(r19).as("test data").contains("O1.2 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
			String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row1Column3)).getText();
			softly.assertThat(r20).as("test data").contains("改进跨领域职能");
			//Row 52
			String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row2Column1)).getText();
			softly.assertThat(r22).as("test data").contains("O1.3 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
			String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row2Column3)).getText();
			softly.assertThat(r23).as("test data").contains("改组");
			String r23a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row2Column2)).getText();
			softly.assertThat(r23a).as("test data").contains("低");
		}
		//Row 3
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row3Column1)).getText();
		softly.assertThat(r24).as("test data").contains("O1.4 生产组织结构不足，例如: (1) 执行核心工作流程的结构存在不足; (2) 不同生产线的结构分隔存在不足; (3) 班值存在不足");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row3Column3)).getText();
		softly.assertThat(r25).as("test data").contains("改进生产组织结构");
		//Row 4
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row4Column1)).getText();
		softly.assertThat(r26).as("test data").contains("O1.5 监督组织结构不足，例如: (1) 生产或管理支持相关管理团队的监督; (2) 生产经理以下管理层级的管理人员监督; (3) 监督结构未基于专业（例如无损试验、QA、QC等）");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row4Column3)).getText();
		softly.assertThat(r27).as("test data").contains("改进监督组织结构");
		//Row 5
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row5Column1)).getText();
		softly.assertThat(r28).as("test data").contains("O1.6 管理支持组织结构不足，例如: (1) 招聘结构不足; (2) 继任计划不足; (3) 培训或授权不足");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row5Column3)).getText();
		softly.assertThat(r29).as("test data").contains("改进监督组织结构");
		//Row 6
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row6Column1)).getText();
		softly.assertThat(r30).as("test data").contains("O1.7 区分短期和长期工作的组织结构存在不足，例如: (1) 一组工程人员处理短期和长期设计改造; (2) 一组维修人员处理紧急和非紧急工作");
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row6Column3)).getText();
		softly.assertThat(r31).as("test data").contains("区分处理短期和长期工作的人员");
		//Row 7
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row7Column1)).getText();
		softly.assertThat(r32).as("test data").contains("O1.8 管理层级不足: (1) 规则型和技能型的小组层级过多; (2) 知识型小组层级不足");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row7Column3)).getText();
		softly.assertThat(r33).as("test data").contains("根据工作的复杂性优化管理层级");
		//Row 8
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row8Column1)).getText();
		softly.assertThat(r34).as("test data").contains("O1.9 管理跨度不足 : (1) 向一位主管或经理汇报的人员过多; (2) 向一位主管或经理汇报的人员过少");
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row8Column3)).getText();
		softly.assertThat(r35).as("test data").contains("根据人员经验优化管理跨度");
		//Row 9
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row9Column1)).getText();
		softly.assertThat(r36).as("test data").contains("O1.10 组织设计和改进方面的领导参与存在不足: (1) 领导层未参与组织问题解决过程中; (2) 领导层未参与组织结构和职能设计中");
		String r37 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row9Column3)).getText();
		softly.assertThat(r37).as("test data").contains("提高领导层在组织设计和改进方面的参与");
		//Row 10
		String r38 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row10Column1)).getText();
		softly.assertThat(r38).as("test data").contains("O1.11 管理职能方面的领导参与不足");
		String r39 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row10Column3)).getText();
		softly.assertThat(r39).as("test data").contains("提高领导层在管理职能方面的参与");
		//Row 11
		String r40 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row11Column1)).getText();
		softly.assertThat(r40).as("test data").contains("O3.1 缺少流程和程序设计、缺乏标准改进");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row11Column3)).getText();
		softly.assertThat(r41).as("test data").contains("确定协调员或职能经理，监督关键流程的设计和改进");
		//Row 12
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row12Column1)).getText();
		softly.assertThat(r42).as("test data").contains("O3.2 缺少负责日常流程绩效的流程负责人");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row12Column3)).getText();
		softly.assertThat(r43).as("test data").contains("确定各个关键流程的负责人及其角色和责任");
		//Row 13
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row13Column1)).getText();
		softly.assertThat(r44).as("test data").contains("O3.3 流程程序设计导则存在不足");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row13Column3)).getText();
		softly.assertThat(r45).as("test data").contains("为有效且可靠的流程制定流程设计导则");
		//Row 14
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row14Column1)).getText();
		softly.assertThat(r46).as("test data").contains("O3.4 流程改进存在不足: (1) 定期自评存在不足; (2)绩效跟踪和趋势分析存在不足; (3)流程失效的根本原因分析存在不足");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row14Column3)).getText();
		softly.assertThat(r47).as("test data").contains("制定流程改进导则");
		//Row 15
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row15Column1)).getText();
		softly.assertThat(r48).as("test data").contains("O3.5 程序编写导则存在不足，未能有效且可靠地执行流程");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row15Column3)).getText();
		softly.assertThat(r49).as("test data").contains("制定程序编写导则");
		//Row 16
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row16Column1)).getText();
		softly.assertThat(r50).as("test data").contains("O3.6 发展流程设计和改进能力方面存在不足: (1) 流程的失效模式与影响分析; (2) 功能设计; (3) 效率和可靠性优化; (4) 教学准备; (5) 流程试验和验证");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row16Column3)).getText();
		softly.assertThat(r51).as("test data").contains("通过培训或指导来发展流程设计和改进能力");
		//Row 17
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row17Column1)).getText();
		softly.assertThat(r52).as("test data").contains("O3.7 通过培训或指导来发展流程设计和改进能力");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row17Column3)).getText();
		softly.assertThat(r53).as("test data").contains("当需要时，建立专门的工作组进行流程设计和改进");
		//Row 18
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row18Column1)).getText();
		softly.assertThat(r54).as("test data").contains("O4.1 高层管理的接口会议不足以处理共性问题");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row18Column3)).getText();
		softly.assertThat(r55).as("test data").contains("改进接口会议的质量和效率");
		//Row 19
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row19Column1)).getText();
		softly.assertThat(r56).as("test data").contains("O4.2 中层管理的接口会议不足以处理共性问题");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row19Column3)).getText();
		softly.assertThat(r57).as("test data").contains("改进接口会议的质量和效率");
		//Row 20
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row20Column1)).getText();
		softly.assertThat(r58).as("test data").contains("O4.3 工作层的接口会议不足以处理共性问题");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row20Column3)).getText();
		softly.assertThat(r59).as("test data").contains("改进接口会议的质量和效率");
		//Row 21
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row21Column1)).getText();
		softly.assertThat(r60).as("test data").contains("O4.4 在使用公用跟踪系统记录各个组织之间情况管理或工作流程沟通方面存在不足");
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row21Column3)).getText();
		softly.assertThat(r61).as("test data").contains("使用公用跟踪系统，记录各方之间的沟通");
		//Row 22
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row22Column1)).getText();
		softly.assertThat(r62).as("test data").contains("O4.5 组织中的垂直沟通存在不足，未能报告需要高层管理注意的问题");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row22Column3)).getText();
		softly.assertThat(r63).as("test data").contains("改进垂直沟通方式");
		//Row 23
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row23Column1)).getText();
		softly.assertThat(r64).as("test data").contains("O4.6 向工作人员传达管理层期望和经验反馈方面存在不足");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row23Column3)).getText();
		softly.assertThat(r65).as("test data").contains("改进期望和经验反馈传达的质量和效率");
		//Row 24
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row24Column1)).getText();
		softly.assertThat(r66).as("test data").contains("O4.7 由于激励和问责制度存在不足而造成移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）的沟通存在不足");
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row24Column3)).getText();
		softly.assertThat(r67).as("test data").contains("改进监督技能，激励开放式的沟通, 改进问责制，以便在移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）进行有效沟通");
		//Row 25
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row25Column1)).getText();
		softly.assertThat(r68).as("test data").contains("O5.1 技能不足以避免发生粗心大意的失误");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row25Column3)).getText();
		softly.assertThat(r69).as("test data").contains("建立行为标准，避免发生粗心大意的失误, 开展预防粗心大意的失误的培训");
		//Row 26
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row26Column1)).getText();
		softly.assertThat(r70).as("test data").contains("O5.2 技能不足以遵守规则（例如程序、检查清单、工作现场提示信息、行为标准和不准做清单）");
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row26Column3)).getText();
		softly.assertThat(r71).as("test data").contains("建立程序使用的行为标准, 开展防止发生程序失误的培训");
		//Row 27
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row27Column1)).getText();
		softly.assertThat(r72).as("test data").contains("O5.3 主管和经理知识不足以防止自身的知识型错误");
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row27Column3)).getText();
		softly.assertThat(r73).as("test data").contains("为管理人员开展Error-Free");
		softly.assertThat(r73).as("test data").contains("预防培训，改进其最薄弱的领域，包括以下主题: (1) 决策制定; (2) 问题解决; (3) 学习; (4) 设计、分析和建模; (5) 审查; (6) 规划; (7) 沟通; (8) 协商; (9) 风险控制; (10) 绩效控制");
		//Row 28
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row28Column1)).getText();
		softly.assertThat(r74).as("test data").contains("O5.4 流程设计和改进方面的管理知识不足: (1) 程序的逐步设计和改进方面存在不足; (2) 屏障的设计和改进方面存在不足; (3) 行为标准的设计和改进方面存在不足; (4) 不准做清单的设计和改进方面存在不足; (5) 检查清单的设计和改进方面存在不足; (6) 工作现场提示信息的设计和改进方面存在不足");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row28Column3)).getText();
		softly.assertThat(r75).as("test data").contains("开展程序设计和改进方面的Error-Free");
		softly.assertThat(r75).as("test data").contains("培训");
		//Row 29
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row29Column1)).getText();
		softly.assertThat(r76).as("test data").contains("O5.5 人因绩效管理方面的管理知识不足");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row29Column3)).getText();
		softly.assertThat(r77).as("test data").contains("开展人因绩效管理方面的Error-Free");
		softly.assertThat(r77).as("test data").contains("培训");
		//Row 30
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row30Column1)).getText();
		softly.assertThat(r78).as("test data").contains("O5.6 设备性能管理方面的管理知识不足");
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row30Column3)).getText();
		softly.assertThat(r79).as("test data").contains("开展设备性能管理方面的Error-Free");
		softly.assertThat(r79).as("test data").contains("培训");
		//Row 31
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row31Column1)).getText();
		softly.assertThat(r80).as("test data").contains("OO1.1 QA和组织之间的共同目标/利益/问责机制的定义存在不足");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row31Column3)).getText();
		softly.assertThat(r81).as("test data").contains("制定QA和组织之间的共同目标/利益/问责机制");
		//Row 32
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row32Column1)).getText();
		softly.assertThat(r82).as("test data").contains("OO1.2 组织间的共同目标/利益/问责机制的定义存在不足");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row32Column3)).getText();
		softly.assertThat(r83).as("test data").contains("制定组织间的共同目标/利益/问责机制，例如利用奖惩体系鼓励组织之间为了实现整体利益而相互支持");
		//Row 33
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row33Column1)).getText();
		softly.assertThat(r84).as("test data").contains("OO1.3 高管和组织管理人员之间的共同目标/利益/问责机制存在不足: (1) 奖励制度不同且不一致; (2) 高管侧重于一个领域而让管理人员负责另一个领域");
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row33Column3)).getText();
		softly.assertThat(r85).as("test data").contains("制定高管和组织管理人员之间的共同目标/利益/问责机制");
		//Row 34
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row34Column1)).getText();
		softly.assertThat(r86).as("test data").contains("OO1.4 组织管理人员和主管之间的共同目标/利益/问责机制存在不足: (1) 问责体系不同; (2) 管理人员侧重于一个领域而让主管负责另一个领域");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row34Column3)).getText();
		softly.assertThat(r87).as("test data").contains("制定组织管理人员和主管之间的共同目标/利益/问责机制");
		//Row 35
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row35Column1)).getText();
		softly.assertThat(r88).as("test data").contains("OO1.5 奖励和问责体系不足以建立共同目标/利益");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row35Column3)).getText();
		softly.assertThat(r89).as("test data").contains("改进奖励体系");
		//Row 36
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row36Column1)).getText();
		softly.assertThat(r90).as("test data").contains("OO2.1 组织管理人员共同规定的接口要求存在不足，例如数据传达、资源共享、解决跨组织问题等");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row36Column3)).getText();
		softly.assertThat(r91).as("test data").contains("改进接口要求");
		//Row 37
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row37Column1)).getText();
		softly.assertThat(r92).as("test data").contains("OO2.2 接口流程和方法存在不足，例如会议形式、接口频率和沟通通道存在不足");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row37Column3)).getText();
		softly.assertThat(r93).as("test data").contains("改进接口流程和方法");
		//Row 38
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row38Column1)).getText();
		softly.assertThat(r94).as("test data").contains("OO2.3 由于位置过于分散而造成沟通不佳");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row38Column3)).getText();
		softly.assertThat(r95).as("test data").contains("通过采用先进的沟通技术，提高沟通的频率和简易度");
		//Row 39
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row39Column1)).getText();
		softly.assertThat(r96).as("test data").contains("OO3.1 两个独立的组织执行一个工作职能");
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row39Column3)).getText();
		softly.assertThat(r97).as("test data").contains("简化重叠的工作职能");
		//Row 40
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row40Column1)).getText();
		softly.assertThat(r98).as("test data").contains("OO3.2 没有要求两个接口部门执行所需的工作职能");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row40Column3)).getText();
		softly.assertThat(r99).as("test data").contains("重新定义角色和责任，纳入两个接口组织之间被遗漏的工作职能");
		//Row 41
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row41Column1)).getText();
		softly.assertThat(r100).as("test data").contains("OP1.1 人员配置和预算不足以实施制度或执行程序");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row41Column3)).getText();
		softly.assertThat(r101).as("test data").contains("增加人员编制, 评估制度管理人员或者负责该制度的组织管理人员的能力");
		//Row 42
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row42Column1)).getText();
		softly.assertThat(r102).as("test data").contains("OP1.2 相关人员的培训和授权不足以实施制度");
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row42Column3)).getText();
		softly.assertThat(r103).as("test data").contains("增加培训预算, 针对高风险或者要求知识型绩效的工作开展培训课程");
		//Row 43
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row43Column1)).getText();
		softly.assertThat(r104).as("test data").contains("OP1.3 管理层对制度落实行动的跟进存在不足");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row43Column3)).getText();
		softly.assertThat(r105).as("test data").contains("改进管理层工作投入和跟踪系统, 评估制度管理人员或者负责该制度的组织管理人员的能力");
		//Row 44
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row44Column1)).getText();
		softly.assertThat(r106).as("test data").contains("OP1.4 对落实制度的管理支持存在不足");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row44Column3)).getText();
		softly.assertThat(r107).as("test data").contains("改进管理支持, 评估制度管理人员或者负责该制度的组织管理人员的能力");
		//Row 45
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row45Column1)).getText();
		softly.assertThat(r108).as("test data").contains("OP2.1 先行指标存在不足");
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row45Column3)).getText();
		softly.assertThat(r109).as("test data").contains("改进先行指标, 使用过去的绩效对先行指标进行核实");
		//Row 46
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row46Column1)).getText();
		softly.assertThat(r110).as("test data").contains("OP2.2 实时指标存在不足");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row46Column3)).getText();
		softly.assertThat(r111).as("test data").contains("改进实时指标, 使用过去的绩效对实时指标进行核实");
		//Row 47
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row47Column1)).getText();
		softly.assertThat(r112).as("test data").contains("OP2.3 滞后指标存在不足");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row47Column3)).getText();
		softly.assertThat(r113).as("test data").contains("改进滞后标志, 使其简单但能够反映所有主要O&P问题");
		//Row 48
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row48Column1)).getText();
		softly.assertThat(r114).as("test data").contains("OP2.4 管理层在绩效监督跟踪和趋势分析的结果使用方面存在不足");
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row48Column3)).getText();
		softly.assertThat(r115).as("test data").contains("改进绩效提升的管理决策流程，纳入绩效监督跟踪和趋势分析中的数据");
		//Row 49
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row49Column1)).getText();
		softly.assertThat(r116).as("test data").contains("OP2.5 在将RCA共因分析作为监督工具方面存在不足");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row49Column3)).getText();
		softly.assertThat(r117).as("test data").contains("改进共因分析方法, 开展Error-Free");
		softly.assertThat(r117).as("test data").contains("共因培训");
		//Row 50
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row50Column1)).getText();
		softly.assertThat(r118).as("test data").contains("OP2.6 在使用现场观察结果作为监督工具方面存在不足");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row50Column3)).getText();
		softly.assertThat(r119).as("test data").contains("改进绩效提升的管理决策流程，纳入现场观察中的数据");
		if(browserName.equals("chrome"))
		{
			//Row 51
			String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row51Column1)).getText();
			softly.assertThat(r120).as("test data").contains("O1.2 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
			String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row51Column3)).getText();
			softly.assertThat(r121).as("test data").contains("改进跨领域职能");
			//Row 52
			String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row52Column1)).getText();
			softly.assertThat(r122).as("test data").contains("O1.3 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
			String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row52Column3)).getText();
			softly.assertThat(r123).as("test data").contains("改组");
			String r123a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row52Column2)).getText();
			softly.assertThat(r123a).as("test data").contains("低");
		}
		else
		{
			//51
			String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row51Column1)).getText();
			softly.assertThat(r120).as("test data").contains("OP3.1 个人的自我分析存在不足");
			String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row51Column3)).getText();
			softly.assertThat(r121).as("test data").contains("开展Error-Free");
			softly.assertThat(r121).as("test data").contains("自我评价培训，使人员认识到他或她容易发生失误的方面");
			//Row 52
			String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row52Column1)).getText();
			softly.assertThat(r122).as("test data").contains("OP3.2 监督小组的自我分析存在不足");
			String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row52Column3)).getText();
			softly.assertThat(r123).as("test data").contains("开展Error-Free");
			softly.assertThat(r123).as("test data").contains("自我评价培训，使主管认识到他或她的小组容易发生失误的方面");
		}
		//Row 53
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row53Column1)).getText();
		softly.assertThat(r124).as("test data").contains("OP3.3 管理组织的自我分析存在不足");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row53Column3)).getText();
		softly.assertThat(r125).as("test data").contains("开展Error-Free");
		softly.assertThat(r125).as("test data").contains("自我评价培训，使经理认识到他或她的组织容易发生失误的方面");
		//Row 54
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row54Column1)).getText();
		softly.assertThat(r126).as("test data").contains("OP3.4 高风险制度或程序的自我评估存在不足");
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row54Column3)).getText();
		softly.assertThat(r127).as("test data").contains("改进自我评估制度的频率和彻底性");
		//Row 55
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row55Column1)).getText();
		softly.assertThat(r128).as("test data").contains("OP3.5 对组织事件的根本原因分析分析质量差、事件数据收集和启动调查条件存在不足");
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row55Column3)).getText();
		softly.assertThat(r129).as("test data").contains("改进执行组织事件根本原因分析的质量、数据收集和启动调查条件");
		//Row 56
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row56Column1)).getText();
		softly.assertThat(r130).as("test data").contains("OP3.6 对组织事件的共因分析没有定期执行（不够频繁）或是共因分析质量差");
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row56Column3)).getText();
		softly.assertThat(r131).as("test data").contains("改进执行组织事件共因分析的频率和质量。评估可以识别弱点加以改进。");
		//Row 57
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row57Column1)).getText();
		softly.assertThat(r132).as("test data").contains("OP4.1 制度或流程负责人规定方面存在不足");
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row57Column3)).getText();
		softly.assertThat(r133).as("test data").contains("改进制度管理人员的负责人规定");
		//Row 58
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row58Column1)).getText();
		softly.assertThat(r134).as("test data").contains("OP4.2 制度或流程相关人员的角色和责任规定方面存在不足");
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row58Column3)).getText();
		softly.assertThat(r135).as("test data").contains("改进制度管理人员角色和责任的规定");
		//Row 59
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row59Column1)).getText();
		softly.assertThat(r136).as("test data").contains("OP4.3 用于跟踪制度或流程责任经理绩效（时间、质量和成本）的问责机制存在不足");
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row59Column3)).getText();
		softly.assertThat(r137).as("test data").contains("改进问责机制，使其涵盖三个同样重要的方面（时间、质量和成本）。体系应当有助于实现良好绩效而非侧重于惩罚");
		//Row 60
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row60Column1)).getText();
		softly.assertThat(r138).as("test data").contains("OP4.4 总经理层问责机制不存在不足: (1) 未能客观评量总经理层绩效; (2) 未考量所有投资方反馈");
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row60Column3)).getText();
		softly.assertThat(r139).as("test data").contains("改进问责机制，使其涵盖总经理层");
		//Row 61
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row61Column1)).getText();
		softly.assertThat(r140).as("test data").contains("P1.1 由于未意识到风险，而造成制度、程序或屏障（LOP）的遗漏，例如: (1) 新兴高风险问题的危机管理制度; (2) O&P决策制定和问题解决的管理授权制度; (3) 技术审查人员的培训和授权制度; (4) 不道德或违法活动的匿名举报制度; (5) 对标、根本原因分析、自我评估");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row61Column3)).getText();
		softly.assertThat(r141).as("test data").contains("编写被遗漏的制度, 识别其他被遗漏的类似制度，并实施纠正行动, 开展规则和制度设置的管理培训, 改进QA审计流程，识别被遗漏的制度");
		//Row 62
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row62Column1)).getText();
		softly.assertThat(r142).as("test data").contains("P1.2 由于未意识到风险，而造成行为标准的遗漏，例如: (1) 预防粗心大意的失误的行为标准; (2) 关键思考、关键追问和情况警觉的行为标准; (3) 程序使用的行为标准");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row62Column3)).getText();
		softly.assertThat(r143).as("test data").contains("制定被遗漏的标准, 识别其他被遗漏的类似标准，并实施纠正行动, 开展标准设置方面的管理培训, 改进QA审计流程，识别被遗漏的行为标准");
		//Row 63
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row63Column1)).getText();
		softly.assertThat(r144).as("test data").contains("P1.3 由于优先级不当而造成程序编写组织发布程序的时间推迟");
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row63Column3)).getText();
		softly.assertThat(r145).as("test data").contains("改进优先级体系");
		//Row 64
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row64Column1)).getText();
		softly.assertThat(r146).as("test data").contains("P1.4 由于培训组织优先级划分不当而造成实施的推迟");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row64Column3)).getText();
		softly.assertThat(r147).as("test data").contains("改进优先级体系");
		//Row 65
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row65Column1)).getText();
		softly.assertThat(r148).as("test data").contains("P1.5 由于管理审查体系存在不足而造成制度、程序或屏障的遗漏");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row65Column3)).getText();
		softly.assertThat(r149).as("test data").contains("独立管理审查体系存在不足");
		//Row 66
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row66Column1)).getText();
		softly.assertThat(r150).as("test data").contains("P2.1 由于程序编写导则存在不足，而造成要求不全面，例如条例、规范要求、用户和内部要求等");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row66Column3)).getText();
		softly.assertThat(r151).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 67
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row67Column1)).getText();
		softly.assertThat(r152).as("test data").contains("P2.2 验证程序的操作条件存在不足，例如: (1) 进入条件; (2) 退出条件; (3) 中止程序的条件");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row67Column3)).getText();
		softly.assertThat(r153).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 68
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row68Column1)).getText();
		softly.assertThat(r154).as("test data").contains("P2.3 由于程序编写导则存在不足，而造成程序执行期间要求进行验证的假设存在不足或被遗漏");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row68Column3)).getText();
		softly.assertThat(r155).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 69
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row69Column1)).getText();
		softly.assertThat(r156).as("test data").contains("P2.4 由于程序编写导则存在不足，而造成工作范围不充分，例如: (1) 逐步说明; (2) 逐项说明");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row69Column3)).getText();
		softly.assertThat(r157).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 70
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row70Column1)).getText();
		softly.assertThat(r158).as("test data").contains("P2.5 由于程序编写导则存在不足，而造成工后试验、测量或正确性验证方面存在不足");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row70Column3)).getText();
		softly.assertThat(r159).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 71
		String r160 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row71Column1)).getText();
		softly.assertThat(r160).as("test data").contains("P2.6 缺少以下部分: (1) 目的说明; (2) 先决条件; (3) 术语定义; (4) 不准做清单经验反馈说明; (5) 参考文件; (6) 用户反馈请求");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row71Column3)).getText();
		softly.assertThat(r161).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 72
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row72Column1)).getText();
		softly.assertThat(r162).as("test data").contains("P2.7 由于审查存在不足而造成要素的遗漏");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row72Column3)).getText();
		softly.assertThat(r163).as("test data").contains("开展审查方面的培训");
		//Row 73
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row73Column1)).getText();
		softly.assertThat(r164).as("test data").contains("P2.8 由于根本原因分析不到位导致要素的遗漏");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row73Column3)).getText();
		softly.assertThat(r165).as("test data").contains("开展根本原因分析方面的培训");
		//Row 74
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row74Column1)).getText();
		softly.assertThat(r166).as("test data").contains("P2.9 由于纠正措施执行不到位导致要素的遗漏");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row74Column3)).getText();
		softly.assertThat(r167).as("test data").contains("开展纠正措施执行进度的监督跟进");
		//Row 75
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row75Column1)).getText();
		softly.assertThat(r168).as("test data").contains("P3.1 对制度外或程序外进行工作的指导存在不足");
		String r169 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row75Column3)).getText();
		softly.assertThat(r169).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 76
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row76Column1)).getText();
		softly.assertThat(r170).as("test data").contains("P3.2 由于程序编写导则存在不足，造成通过自检或独立检查单项弱点（SPV）步骤方面存在不足");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row76Column3)).getText();
		softly.assertThat(r171).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 77
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row77Column1)).getText();
		softly.assertThat(r172).as("test data").contains("P3.3 由于程序编写导则存在不足，造成审查先前不可逆点（PNR）行动方面存在不足");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row77Column3)).getText();
		softly.assertThat(r173).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 78
		String r174 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row78Column1)).getText();
		softly.assertThat(r174).as("test data").contains("P3.4 由于程序编写导则存在不足，造成步骤、章节或页次的操作标记使用方面存在不足");
		String r175 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row78Column3)).getText();
		softly.assertThat(r175).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 79
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row79Column1)).getText();
		softly.assertThat(r176).as("test data").contains("P3.5 由于程序编写导则存在不足，造成使用不准做清单防止违章行为方面存在不足");
		String r177 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row79Column3)).getText();
		softly.assertThat(r177).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 80
		String r178 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row80Column1)).getText();
		softly.assertThat(r178).as("test data").contains("P3.6 由于程序编写导则存在不足，造成使用工作现场提示信息防止例行工作出现粗心犯错方面存在不足");
		String r179 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row80Column3)).getText();
		softly.assertThat(r179).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 81
		String r180 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row81Column1)).getText();
		softly.assertThat(r180).as("test data").contains("P3.7 由于程序编写导则存在不足，造成使用检查清单防止遗忘相关失误的方面存在不足");
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row81Column3)).getText();
		softly.assertThat(r181).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 82
		String r182 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row82Column1)).getText();
		softly.assertThat(r182).as("test data").contains("P3.8 由于程序编写导则存在不足，造成使用行为标准提供正面的同事压力以促使遵循规定方面存在不足");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row82Column3)).getText();
		softly.assertThat(r183).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		//Row 83
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row83Column1)).getText();
		softly.assertThat(r184).as("test data").contains("P3.9 由于审查不充分，造成存在偏差控制方面的不足");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row83Column3)).getText();
		softly.assertThat(r185).as("test data").contains("开展审查方面的培训");
		//Row 84
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row84Column1)).getText();
		softly.assertThat(r186).as("test data").contains("P3.10 由于根本原因分析不到位，造成存在偏差控制方面的不足");
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row84Column3)).getText();
		softly.assertThat(r187).as("test data").contains("开展根本原因分析方面的培训");
		//Row 85
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row85Column1)).getText();
		softly.assertThat(r188).as("test data").contains("P3.11 由于纠正措施执行不到位，造成存在偏差控制方面的不足");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row85Column3)).getText();
		softly.assertThat(r189).as("test data").contains("改善纠正措施的监督跟踪");
		//Row 86
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row86Column1)).getText();
		softly.assertThat(r190).as("test data").contains("P4.1 由于程序编写导则存在不足，使用需要解释或判断的词语，例如:过度、最大、最小、根据需要等");
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row86Column3)).getText();
		softly.assertThat(r191).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		//Row 87
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row87Column1)).getText();
		softly.assertThat(r192).as("test data").contains("P4.2 由于程序编写导则存在不足，使用对一般程序用户而言缺少定义或解释的专业技术词汇");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row87Column3)).getText();
		softly.assertThat(r193).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		//Row 88
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row88Column1)).getText();
		softly.assertThat(r194).as("test data").contains("P4.3 由于程序编写导则存在不足，使用一般程序用户难以读懂的复杂和复合句");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row88Column3)).getText();
		softly.assertThat(r195).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		//Row 89
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row89Column1)).getText();
		softly.assertThat(r196).as("test data").contains("P4.4 由于程序编写导则存在不足，在缺少图纸、图片或图形的情况下描述复杂事物");
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row89Column3)).getText();
		softly.assertThat(r197).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		//Row 90
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row90Column1)).getText();
		softly.assertThat(r198).as("test data").contains("P4.5 由于程序编写导则存在不足，使用需要解释的非描述性要求，例如:根据要求、根据需要等");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row90Column3)).getText();
		softly.assertThat(r199).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		//Row 91
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row91Column1)).getText();
		softly.assertThat(r200).as("test data").contains("P4.6 导则或说明存在错误: (1) 过时的导则; (2) 错误的导则或说明; (3) 程序中存在错误的步骤");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row91Column3)).getText();
		softly.assertThat(r201).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		//Row 92
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row92Column1)).getText();
		softly.assertThat(r202).as("test data").contains("P4.7 由于程序审查不充分，造成存在模糊或错误的说明");
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row92Column3)).getText();
		softly.assertThat(r203).as("test data").contains("开展程序审查的培训, 改进程序审查流程");
		//Row 93
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row93Column1)).getText();
		softly.assertThat(r204).as("test data").contains("P4.8 设备的标识和识别不到位");
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row93Column3)).getText();
		softly.assertThat(r205).as("test data").contains("改进设备标识和识别");
		//Row 94
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row94Column1)).getText();
		softly.assertThat(r206).as("test data").contains("P5.1 由于不相关要求造成不必要的工作");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row94Column3)).getText();
		softly.assertThat(r207).as("test data").contains("减少导则或程序中的负担, 开展Error-Free");
		softly.assertThat(r207).as("test data").contains("工作流程优化的培训");
		//Row 95
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row95Column1)).getText();
		softly.assertThat(r208).as("test data").contains("P5.2 没有对程序步骤进行优化，以确保效率和方便执行");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row95Column3)).getText();
		softly.assertThat(r209).as("test data").contains("优化程序，以确保效率和方便执行, 开展Error-Free");
		softly.assertThat(r209).as("test data").contains("工作流程优化的培训");
		//Row 96
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row96Column1)).getText();
		softly.assertThat(r210).as("test data").contains("P5.3 加重相关人员或小组不必要的差事（相关小组的多重任务）");
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row96Column3)).getText();
		softly.assertThat(r211).as("test data").contains("避免同时进行多重任务, 开展Error-Free");
		softly.assertThat(r211).as("test data").contains("工作流程优化的培训");
		//Row 97
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row97Column1)).getText();
		softly.assertThat(r212).as("test data").contains("P5.4 制定不必要的工作，而未提高质量，例如进行散弹枪式的根本原因分析，对未发生故障的设备制定不必要工作或制定预防性维修工作");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row97Column3)).getText();
		softly.assertThat(r213).as("test data").contains("改善根本原因分析流程, 改善预防性维修工作流程, 开展Error-Free");
		softly.assertThat(r213).as("test data").contains("工作流程优化的培训");
		//Row 98
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row98Column1)).getText();
		softly.assertThat(r214).as("test data").contains("P5.5 一个组织负责的职责若该由其他组织执行会更有效率");
		String r215 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row98Column3)).getText();
		softly.assertThat(r215).as("test data").contains("组织改组以提高效率和绩效");
		//Row 99
		String r216 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row99Column1)).getText();
		softly.assertThat(r216).as("test data").contains("P5.6 为执行要求而开展不必要的工作，例如长途驱车至场外仓库取用常用工具，填写冗长的表格等");
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row99Column3)).getText();
		softly.assertThat(r217).as("test data").contains("减少导则或程序中的负担, 开展Error-Free");
		softly.assertThat(r217).as("test data").contains("工作流程优化的培训");
		//Row 100
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row100Column1)).getText();
		softly.assertThat(r218).as("test data").contains("P5.7 审查人员人数过多，并且未规定角色和责任，导致各个审查员跳过审查，依赖其他人查找失误");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row100Column3)).getText();
		softly.assertThat(r219).as("test data").contains("开展Error-Free");
		softly.assertThat(r219).as("test data").contains("工作流程优化的培训, 开展审查培训, 规定审查人员的角色和责任, 对审查人员实行问责制");
		//Row 101
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row101Column1)).getText();
		softly.assertThat(r220).as("test data").contains("P5.8 在使用软件和连通技术方面存在不足，例如进行RCA的智能电话制度、检查清单、工前会、数据搜索等");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row101Column3)).getText();
		softly.assertThat(r221).as("test data").contains("使用软件或智能电话技术跟踪沟通情况");
		if(browserName.equals("chrome"))
		{
			//Row 102
			String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row102Column1)).getText();
			softly.assertThat(r222).as("test data").contains("OP3.2 监督小组的自我分析存在不足");
			String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row102Column3)).getText();
			softly.assertThat(r223).as("test data").contains("开展Error-Free");
			softly.assertThat(r223).as("test data").contains("自我评价培训，使主管认识到他或她的小组容易发生失误的方面");
		}
		else{
			String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row102Column1)).getText();
			softly.assertThat(r222).as("test data").contains("P5.9 使用过时且繁重的技术或工具来执行工作");
			String r223a = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportTabTable4Row102Column3)).getText();
			softly.assertThat(r223a).as("test data").contains("改进工作技术或工具");
		}
	}

	public void chineseStep5(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		OPiRCAChinese obj = new OPiRCAChinese();
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("第五步 - O&PiRCA");
		softly.assertThat(opirca_desc).as("test data").contains("自检清单");
		//Headings of table
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableHeading1)).getText();
		softly.assertThat(h1).as("test data").contains("类别");
		String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableHeading2)).getText();
		softly.assertThat(h2).as("test data").contains("调查内容");
		String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableHeading3)).getText();
		softly.assertThat(h3).as("test data").contains("完成打勾?");
		//Row 1
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow1Column1)).getText();
		softly.assertThat(r1).as("test data").contains("调查概述");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow1Column2)).getText();
		softly.assertThat(r2).as("test data").contains("是否访谈了所有相关组织与制度，是否收集了所有相关数据？");
		//Row 2
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow2Column1)).getText();
		softly.assertThat(r3).as("test data").contains("根本原因");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow2Column2)).getText();
		softly.assertThat(r4).as("test data").contains("根本原因是否符合 SURE");
		softly.assertThat(r4).as("test data").contains(" 标准");
		//Row 3
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow3Column2)).getText();
		softly.assertThat(r5).as("test data").contains("根本原因是否经得住 CHOP'N");
		softly.assertThat(r5).as("test data").contains("挑战？");
		//Row 4
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow4Column2)).getText();
		softly.assertThat(r6).as("test data").contains("是否识别根本原因的重要性？");
		//Row 5
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow5Column1)).getText();
		softly.assertThat(r7).as("test data").contains("纠正行动");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow5Column2)).getText();
		softly.assertThat(r8).as("test data").contains("建议的纠正行动是否涵盖所有直接原因、根本原因和关键促成因素");
		//Row 6
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep5TableRow6Column2)).getText();
		softly.assertThat(r9).as("test data").contains("建议的纠正行动是否具有成本效益？");
	}

	public void checkStep4HMLBoxes(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		//Scroll down
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow1HighBox));
		obj.scrollToElement(driver,l);
		//H on 1st root cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow1HighBox)).click();   
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow4MediumBox));
		obj.scrollToElement(driver,l);
		//M on 1st contributing factor
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow4MediumBox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow6LowBox));
		obj.scrollToElement(driver,l);
		//L on 2nd contributing factor
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow6LowBox)).click();
		//Scroll to top
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
	}

	public void chineseStep4(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		OPiRCAChinese obj = new OPiRCAChinese();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("第四步 - 判别根本原因和促成因素的重要性");
		//Headings of table
		String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableHeading1)).getText();
		softly.assertThat(h1).as("test data").contains("始发事件的根本原因与促成因素");
		String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableHeading2)).getText();
		softly.assertThat(h2).as("test data").contains("R:根本原因 或 C:促成因素");
		softly.assertThat(h2).as("test data").contains("(R 或 C)");
		String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableHeading3)).getText();
		softly.assertThat(h3).as("test data").contains("重要性分级");
		softly.assertThat(h3).as("test data").contains("(H:高, M:中 或 L:低)");
		//Root cause
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow1Column1)).getText();
		softly.assertThat(r1).as("test data").contains("O1.1: 管理职能不足: (1) 职能协调人或经理不足; (2) 管理决策职能不足; (3) 问题解决职能不足; (4) 工作计划职能不足; (5) 资源分配职能不足; (6) 管理和人员培训职能不足; (7) 人力资源职能（或结构）不足");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow2Heading)).getText();
		softly.assertThat(r2).as("test data").contains("扩展分析");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow2Label1)).getText();
		softly.assertThat(r3).as("test data").contains("扩展分析:");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow2Label2)).getText();
		softly.assertThat(r4).as("test data").contains("运行经验:");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow2Label3)).getText();
		softly.assertThat(r5).as("test data").contains("对核安全或安全文化的影响:");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow3Label)).getText();
		softly.assertThat(r6).as("test data").contains("纠正行动:");
		softly.assertThat(r6).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow3Field)).getText();
		softly.assertThat(r7).as("test data").contains("改进管理职能");
		//Contributing factors
		if(browserName.equals("chrome"))
		{
			String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow4)).getText();
			softly.assertThat(r8).as("test data").contains("P5.9: 使用过时且繁重的技术或工具来执行工作");
			String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow5Label)).getText();
			softly.assertThat(r9).as("test data").contains("纠正行动:");
			softly.assertThat(r9).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
			String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow5Field)).getText();
			softly.assertThat(r10).as("test data").contains("改进工作技术或工具");	    	
		}
		else
		{
			String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow4)).getText();
			softly.assertThat(r8).as("test data").contains("O1.2: 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
			String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow5Label)).getText();
			softly.assertThat(r9).as("test data").contains("纠正行动:");
			softly.assertThat(r9).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
			String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow5Field)).getText();
			softly.assertThat(r10).as("test data").contains("改进跨领域职能");
		}
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow6)).getText();
		softly.assertThat(r11).as("test data").contains("O1.3: 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow7Label)).getText();
		softly.assertThat(r12).as("test data").contains("纠正行动:");
		softly.assertThat(r12).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow7Field)).getText();
		softly.assertThat(r13).as("test data").contains("改组");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow8)).getText();
		softly.assertThat(r14).as("test data").contains("O1.4: 生产组织结构不足，例如: (1) 执行核心工作流程的结构存在不足; (2) 不同生产线的结构分隔存在不足; (3) 班值存在不足");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow9Label)).getText();
		softly.assertThat(r15).as("test data").contains("纠正行动:");
		softly.assertThat(r15).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow9Field)).getText();
		softly.assertThat(r16).as("test data").contains("改进生产组织结构");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow10)).getText();
		softly.assertThat(r17).as("test data").contains("O1.5: 监督组织结构不足，例如: (1) 生产或管理支持相关管理团队的监督; (2) 生产经理以下管理层级的管理人员监督; (3) 监督结构未基于专业（例如无损试验、QA、QC等）");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow11Label)).getText();
		softly.assertThat(r18).as("test data").contains("纠正行动:");
		softly.assertThat(r18).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow11Field)).getText();
		softly.assertThat(r19).as("test data").contains("改进监督组织结构");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow12)).getText();
		softly.assertThat(r20).as("test data").contains("O1.6: 管理支持组织结构不足，例如: (1) 招聘结构不足; (2) 继任计划不足; (3) 培训或授权不足");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow13Label)).getText();
		softly.assertThat(r21).as("test data").contains("纠正行动:");
		softly.assertThat(r21).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow13Field)).getText();
		softly.assertThat(r22).as("test data").contains("改进监督组织结构");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow14)).getText();
		softly.assertThat(r23).as("test data").contains("O1.7: 区分短期和长期工作的组织结构存在不足，例如: (1) 一组工程人员处理短期和长期设计改造; (2) 一组维修人员处理紧急和非紧急工作");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow15Label)).getText();
		softly.assertThat(r24).as("test data").contains("纠正行动:");
		softly.assertThat(r24).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow15Field)).getText();
		softly.assertThat(r25).as("test data").contains("区分处理短期和长期工作的人员");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow16)).getText();
		softly.assertThat(r26).as("test data").contains("O1.8: 管理层级不足: (1) 规则型和技能型的小组层级过多; (2) 知识型小组层级不足");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow17Label)).getText();
		softly.assertThat(r27).as("test data").contains("纠正行动:");
		softly.assertThat(r27).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow17Field)).getText();
		softly.assertThat(r28).as("test data").contains("根据工作的复杂性优化管理层级");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow18)).getText();
		softly.assertThat(r29).as("test data").contains("O1.9: 管理跨度不足 : (1) 向一位主管或经理汇报的人员过多; (2) 向一位主管或经理汇报的人员过少");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow19Label)).getText();
		softly.assertThat(r30).as("test data").contains("纠正行动:");
		softly.assertThat(r30).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow19Field)).getText();
		softly.assertThat(r31).as("test data").contains("根据人员经验优化管理跨度");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow20)).getText();
		softly.assertThat(r32).as("test data").contains("O1.10: 组织设计和改进方面的领导参与存在不足: (1) 领导层未参与组织问题解决过程中; (2) 领导层未参与组织结构和职能设计中");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow21Label)).getText();
		softly.assertThat(r33).as("test data").contains("纠正行动:");
		softly.assertThat(r33).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow21Field)).getText();
		softly.assertThat(r34).as("test data").contains("提高领导层在组织设计和改进方面的参与");
		String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow22)).getText();
		softly.assertThat(r35).as("test data").contains("O1.11: 管理职能方面的领导参与不足");
		String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow23Label)).getText();
		softly.assertThat(r36).as("test data").contains("纠正行动:");
		softly.assertThat(r36).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r37 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow23Field)).getText();
		softly.assertThat(r37).as("test data").contains("提高领导层在管理职能方面的参与");
		String r38 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow24)).getText();
		softly.assertThat(r38).as("test data").contains("O3.1: 缺少流程和程序设计、缺乏标准改进");
		String r39 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow25Label)).getText();
		softly.assertThat(r39).as("test data").contains("纠正行动:");
		softly.assertThat(r39).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r40 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow25Field)).getText();
		softly.assertThat(r40).as("test data").contains("确定协调员或职能经理，监督关键流程的设计和改进");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow26)).getText();
		softly.assertThat(r41).as("test data").contains("O3.2: 缺少负责日常流程绩效的流程负责人");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow27Label)).getText();
		softly.assertThat(r42).as("test data").contains("纠正行动:");
		softly.assertThat(r42).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow27Field)).getText();
		softly.assertThat(r43).as("test data").contains("确定各个关键流程的负责人及其角色和责任");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow28)).getText();
		softly.assertThat(r44).as("test data").contains("O3.3: 流程程序设计导则存在不足");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow29Label)).getText();
		softly.assertThat(r45).as("test data").contains("纠正行动:");
		softly.assertThat(r45).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow29Field)).getText();
		softly.assertThat(r46).as("test data").contains("为有效且可靠的流程制定流程设计导则");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow30)).getText();
		softly.assertThat(r47).as("test data").contains("O3.4: 流程改进存在不足: (1) 定期自评存在不足; (2)绩效跟踪和趋势分析存在不足; (3)流程失效的根本原因分析存在不足");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow31Label)).getText();
		softly.assertThat(r48).as("test data").contains("纠正行动:");
		softly.assertThat(r48).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow31Field)).getText();
		softly.assertThat(r49).as("test data").contains("制定流程改进导则");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow32)).getText();
		softly.assertThat(r50).as("test data").contains("O3.5: 程序编写导则存在不足，未能有效且可靠地执行流程");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow33Label)).getText();
		softly.assertThat(r51).as("test data").contains("纠正行动:");
		softly.assertThat(r51).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow33Field)).getText();
		softly.assertThat(r52).as("test data").contains("制定程序编写导则");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow34)).getText();
		softly.assertThat(r53).as("test data").contains("O3.6: 发展流程设计和改进能力方面存在不足: (1) 流程的失效模式与影响分析; (2) 功能设计; (3) 效率和可靠性优化; (4) 教学准备; (5) 流程试验和验证");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow35Label)).getText();
		softly.assertThat(r54).as("test data").contains("纠正行动:");
		softly.assertThat(r54).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow35Field)).getText();
		softly.assertThat(r55).as("test data").contains("通过培训或指导来发展流程设计和改进能力");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow36)).getText();
		softly.assertThat(r56).as("test data").contains("O3.7: 通过培训或指导来发展流程设计和改进能力");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow37Label)).getText();
		softly.assertThat(r57).as("test data").contains("纠正行动:");
		softly.assertThat(r57).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow37Field)).getText();
		softly.assertThat(r58).as("test data").contains("当需要时，建立专门的工作组进行流程设计和改进");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow38)).getText();
		softly.assertThat(r59).as("test data").contains("O4.1: 高层管理的接口会议不足以处理共性问题");
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow39Label)).getText();
		softly.assertThat(r60).as("test data").contains("纠正行动:");
		softly.assertThat(r60).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow39Field)).getText();
		softly.assertThat(r61).as("test data").contains("改进接口会议的质量和效率");
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow40)).getText();
		softly.assertThat(r62).as("test data").contains("O4.2: 中层管理的接口会议不足以处理共性问题");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow41Label)).getText();
		softly.assertThat(r63).as("test data").contains("纠正行动:");
		softly.assertThat(r63).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow41Field)).getText();
		softly.assertThat(r64).as("test data").contains("改进接口会议的质量和效率");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow42)).getText();
		softly.assertThat(r65).as("test data").contains("O4.3: 工作层的接口会议不足以处理共性问题");
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow43Label)).getText();
		softly.assertThat(r66).as("test data").contains("纠正行动:");
		softly.assertThat(r66).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow43Field)).getText();
		softly.assertThat(r67).as("test data").contains("改进接口会议的质量和效率");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow44)).getText();
		softly.assertThat(r68).as("test data").contains("O4.4: 在使用公用跟踪系统记录各个组织之间情况管理或工作流程沟通方面存在不足");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow45Label)).getText();
		softly.assertThat(r69).as("test data").contains("纠正行动:");
		softly.assertThat(r69).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow45Field)).getText();
		softly.assertThat(r70).as("test data").contains("使用公用跟踪系统，记录各方之间的沟通");
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow46)).getText();
		softly.assertThat(r71).as("test data").contains("O4.5: 组织中的垂直沟通存在不足，未能报告需要高层管理注意的问题");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow47Label)).getText();
		softly.assertThat(r72).as("test data").contains("纠正行动:");
		softly.assertThat(r72).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow47Field)).getText();
		softly.assertThat(r73).as("test data").contains("改进垂直沟通方式");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow48)).getText();
		softly.assertThat(r74).as("test data").contains("O4.6: 向工作人员传达管理层期望和经验反馈方面存在不足");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow49Label)).getText();
		softly.assertThat(r75).as("test data").contains("纠正行动:");
		softly.assertThat(r75).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow49Field)).getText();
		softly.assertThat(r76).as("test data").contains("改进期望和经验反馈传达的质量和效率");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow50)).getText();
		softly.assertThat(r77).as("test data").contains("O4.7: 由于激励和问责制度存在不足而造成移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）的沟通存在不足");
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow51Label)).getText();
		softly.assertThat(r78).as("test data").contains("纠正行动:");
		softly.assertThat(r78).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow51Field)).getText();
		softly.assertThat(r79).as("test data").contains("改进监督技能，激励开放式的沟通, 改进问责制，以便在移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）进行有效沟通");
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow52)).getText();
		softly.assertThat(r80).as("test data").contains("O5.1: 技能不足以避免发生粗心大意的失误");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow53Label)).getText();
		softly.assertThat(r81).as("test data").contains("纠正行动:");
		softly.assertThat(r81).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow53Field)).getText();
		softly.assertThat(r82).as("test data").contains("建立行为标准，避免发生粗心大意的失误, 开展预防粗心大意的失误的培训");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow54)).getText();
		softly.assertThat(r83).as("test data").contains("O5.2: 技能不足以遵守规则（例如程序、检查清单、工作现场提示信息、行为标准和不准做清单）");
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow55Label)).getText();
		softly.assertThat(r84).as("test data").contains("纠正行动:");
		softly.assertThat(r84).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow55Field)).getText();
		softly.assertThat(r85).as("test data").contains("建立程序使用的行为标准, 开展防止发生程序失误的培训");
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow56)).getText();
		softly.assertThat(r86).as("test data").contains("O5.3: 主管和经理知识不足以防止自身的知识型错误");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow57Label)).getText();
		softly.assertThat(r87).as("test data").contains("纠正行动:");
		softly.assertThat(r87).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow57Field)).getText();
		softly.assertThat(r88).as("test data").contains("为管理人员开展Error-Free");
		softly.assertThat(r88).as("test data").contains("预防培训，改进其最薄弱的领域，包括以下主题: (1) 决策制定; (2) 问题解决; (3) 学习; (4) 设计、分析和建模; (5) 审查; (6) 规划; (7) 沟通; (8) 协商; (9) 风险控制; (10) 绩效控制");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow58)).getText();
		softly.assertThat(r89).as("test data").contains("O5.4: 流程设计和改进方面的管理知识不足: (1) 程序的逐步设计和改进方面存在不足; (2) 屏障的设计和改进方面存在不足; (3) 行为标准的设计和改进方面存在不足; (4) 不准做清单的设计和改进方面存在不足; (5) 检查清单的设计和改进方面存在不足; (6) 工作现场提示信息的设计和改进方面存在不足");
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow59Label)).getText();
		softly.assertThat(r90).as("test data").contains("纠正行动:");
		softly.assertThat(r90).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow59Field)).getText();
		softly.assertThat(r91).as("test data").contains("开展程序设计和改进方面的Error-Free");
		softly.assertThat(r91).as("test data").contains("培训");
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow60)).getText();
		softly.assertThat(r92).as("test data").contains("O5.5: 人因绩效管理方面的管理知识不足");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow61Label)).getText();
		softly.assertThat(r93).as("test data").contains("纠正行动:");
		softly.assertThat(r93).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow61Field)).getText();
		softly.assertThat(r94).as("test data").contains("开展人因绩效管理方面的Error-Free");
		softly.assertThat(r94).as("test data").contains("培训");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow62)).getText();
		softly.assertThat(r95).as("test data").contains("O5.6: 设备性能管理方面的管理知识不足");
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow63Label)).getText();
		softly.assertThat(r96).as("test data").contains("纠正行动:");
		softly.assertThat(r96).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow63Field)).getText();
		softly.assertThat(r97).as("test data").contains("开展设备性能管理方面的Error-Free");
		softly.assertThat(r97).as("test data").contains("培训");
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow64)).getText();
		softly.assertThat(r98).as("test data").contains("OO1.1: QA和组织之间的共同目标/利益/问责机制的定义存在不足");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow65Label)).getText();
		softly.assertThat(r99).as("test data").contains("纠正行动:");
		softly.assertThat(r99).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow65Field)).getText();
		softly.assertThat(r100).as("test data").contains("制定QA和组织之间的共同目标/利益/问责机制");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow66)).getText();
		softly.assertThat(r101).as("test data").contains("OO1.2: 组织间的共同目标/利益/问责机制的定义存在不足");
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow67Label)).getText();
		softly.assertThat(r102).as("test data").contains("纠正行动:");
		softly.assertThat(r102).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow67Field)).getText();
		softly.assertThat(r103).as("test data").contains("制定组织间的共同目标/利益/问责机制，例如利用奖惩体系鼓励组织之间为了实现整体利益而相互支持");
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow68)).getText();
		softly.assertThat(r104).as("test data").contains("OO1.3: 高管和组织管理人员之间的共同目标/利益/问责机制存在不足: (1) 奖励制度不同且不一致; (2) 高管侧重于一个领域而让管理人员负责另一个领域");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow69Label)).getText();
		softly.assertThat(r105).as("test data").contains("纠正行动:");
		softly.assertThat(r105).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow69Field)).getText();
		softly.assertThat(r106).as("test data").contains("制定高管和组织管理人员之间的共同目标/利益/问责机制");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow70)).getText();
		softly.assertThat(r107).as("test data").contains("OO1.4: 组织管理人员和主管之间的共同目标/利益/问责机制存在不足: (1) 问责体系不同; (2) 管理人员侧重于一个领域而让主管负责另一个领域");
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow71Label)).getText();
		softly.assertThat(r108).as("test data").contains("纠正行动:");
		softly.assertThat(r108).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow71Field)).getText();
		softly.assertThat(r109).as("test data").contains("制定组织管理人员和主管之间的共同目标/利益/问责机制");
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow72)).getText();
		softly.assertThat(r110).as("test data").contains("OO1.5: 奖励和问责体系不足以建立共同目标/利益");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow73Label)).getText();
		softly.assertThat(r111).as("test data").contains("纠正行动:");
		softly.assertThat(r111).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow73Field)).getText();
		softly.assertThat(r112).as("test data").contains("改进奖励体系");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow74)).getText();
		softly.assertThat(r113).as("test data").contains("OO2.1: 组织管理人员共同规定的接口要求存在不足，例如数据传达、资源共享、解决跨组织问题等");
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow75Label)).getText();
		softly.assertThat(r114).as("test data").contains("纠正行动:");
		softly.assertThat(r114).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow75Field)).getText();
		softly.assertThat(r115).as("test data").contains("改进接口要求");
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow76)).getText();
		softly.assertThat(r116).as("test data").contains("OO2.2: 接口流程和方法存在不足，例如会议形式、接口频率和沟通通道存在不足");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow77Label)).getText();
		softly.assertThat(r117).as("test data").contains("纠正行动:");
		softly.assertThat(r117).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow77Field)).getText();
		softly.assertThat(r118).as("test data").contains("改进接口流程和方法");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow78)).getText();
		softly.assertThat(r119).as("test data").contains("OO2.3: 由于位置过于分散而造成沟通不佳");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow79Label)).getText();
		softly.assertThat(r120).as("test data").contains("纠正行动:");
		softly.assertThat(r120).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow79Field)).getText();
		softly.assertThat(r121).as("test data").contains("通过采用先进的沟通技术，提高沟通的频率和简易度");
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow80)).getText();
		softly.assertThat(r122).as("test data").contains("OO3.1: 两个独立的组织执行一个工作职能");
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow81Label)).getText();
		softly.assertThat(r123).as("test data").contains("纠正行动:");
		softly.assertThat(r123).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow81Field)).getText();
		softly.assertThat(r124).as("test data").contains("简化重叠的工作职能");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow82)).getText();
		softly.assertThat(r125).as("test data").contains("OO3.2: 没有要求两个接口部门执行所需的工作职能");
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow83Label)).getText();
		softly.assertThat(r126).as("test data").contains("纠正行动:");
		softly.assertThat(r126).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow83Field)).getText();
		softly.assertThat(r127).as("test data").contains("重新定义角色和责任，纳入两个接口组织之间被遗漏的工作职能");
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow84)).getText();
		softly.assertThat(r128).as("test data").contains("OP1.1: 人员配置和预算不足以实施制度或执行程序");
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow85Label)).getText();
		softly.assertThat(r129).as("test data").contains("纠正行动:");
		softly.assertThat(r129).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow85Field)).getText();
		softly.assertThat(r130).as("test data").contains("增加人员编制, 评估制度管理人员或者负责该制度的组织管理人员的能力");
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow86)).getText();
		softly.assertThat(r131).as("test data").contains("OP1.2: 相关人员的培训和授权不足以实施制度");
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow87Label)).getText();
		softly.assertThat(r132).as("test data").contains("纠正行动:");
		softly.assertThat(r132).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow87Field)).getText();
		softly.assertThat(r133).as("test data").contains("增加培训预算, 针对高风险或者要求知识型绩效的工作开展培训课程");
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow88)).getText();
		softly.assertThat(r134).as("test data").contains("OP1.3: 管理层对制度落实行动的跟进存在不足");
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow89Label)).getText();
		softly.assertThat(r135).as("test data").contains("纠正行动:");
		softly.assertThat(r135).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow89Field)).getText();
		softly.assertThat(r136).as("test data").contains("改进管理层工作投入和跟踪系统, 评估制度管理人员或者负责该制度的组织管理人员的能力");
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow90)).getText();
		softly.assertThat(r137).as("test data").contains("OP1.4: 对落实制度的管理支持存在不足");
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow91Label)).getText();
		softly.assertThat(r138).as("test data").contains("纠正行动:");
		softly.assertThat(r138).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow91Field)).getText();
		softly.assertThat(r139).as("test data").contains("改进管理支持, 评估制度管理人员或者负责该制度的组织管理人员的能力");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow92)).getText();
		softly.assertThat(r140).as("test data").contains("OP2.1: 先行指标存在不足");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow93Label)).getText();
		softly.assertThat(r141).as("test data").contains("纠正行动:");
		softly.assertThat(r141).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow93Field)).getText();
		softly.assertThat(r142).as("test data").contains("改进先行指标, 使用过去的绩效对先行指标进行核实");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow94)).getText();
		softly.assertThat(r143).as("test data").contains("OP2.2: 实时指标存在不足");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow95Label)).getText();
		softly.assertThat(r144).as("test data").contains("纠正行动:");
		softly.assertThat(r144).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow95Field)).getText();
		softly.assertThat(r145).as("test data").contains("改进实时指标, 使用过去的绩效对实时指标进行核实");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow96)).getText();
		softly.assertThat(r146).as("test data").contains("OP2.3: 滞后指标存在不足");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow97Label)).getText();
		softly.assertThat(r147).as("test data").contains("纠正行动:");
		softly.assertThat(r147).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow97Field)).getText();
		softly.assertThat(r148).as("test data").contains("改进滞后标志, 使其简单但能够反映所有主要O&P问题");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow98)).getText();
		softly.assertThat(r149).as("test data").contains("OP2.4: 管理层在绩效监督跟踪和趋势分析的结果使用方面存在不足");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow99Label)).getText();
		softly.assertThat(r150).as("test data").contains("纠正行动:");
		softly.assertThat(r150).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow99Field)).getText();
		softly.assertThat(r151).as("test data").contains("改进绩效提升的管理决策流程，纳入绩效监督跟踪和趋势分析中的数据");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow100)).getText();
		softly.assertThat(r152).as("test data").contains("OP2.5: 在将RCA共因分析作为监督工具方面存在不足");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow101Label)).getText();
		softly.assertThat(r153).as("test data").contains("纠正行动:");
		softly.assertThat(r153).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow101Field)).getText();
		softly.assertThat(r154).as("test data").contains("改进共因分析方法, 开展Error-Free");
		softly.assertThat(r154).as("test data").contains(" 共因培训");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow102)).getText();
		softly.assertThat(r155).as("test data").contains("OP2.6: 在使用现场观察结果作为监督工具方面存在不足");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow103Label)).getText();
		softly.assertThat(r156).as("test data").contains("纠正行动:");
		softly.assertThat(r156).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow103Field)).getText();
		softly.assertThat(r157).as("test data").contains("改进绩效提升的管理决策流程，纳入现场观察中的数据");
		if(browserName.equals("chrome"))
		{
			String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow104)).getText();
			softly.assertThat(r158).as("test data").contains("O1.2: 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
			String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow105Label)).getText();
			softly.assertThat(r159).as("test data").contains("纠正行动:");
			softly.assertThat(r159).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
			String r160 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow105Field)).getText();
			softly.assertThat(r160).as("test data").contains("改进跨领域职能");
		}
		else
		{
			String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow104)).getText();
			softly.assertThat(r158).as("test data").contains("OP3.1: 个人的自我分析存在不足");
			String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow105Label)).getText();
			softly.assertThat(r159).as("test data").contains("纠正行动:");
			softly.assertThat(r159).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
			String r160 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow105Field)).getText();
			softly.assertThat(r160).as("test data").contains("开展Error-Free");
			softly.assertThat(r160).as("test data").contains("自我评价培训，使人员认识到他或她容易发生失误的方面");
		}
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow106)).getText();
		softly.assertThat(r161).as("test data").contains("OP3.2: 监督小组的自我分析存在不足");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow107Label)).getText();
		softly.assertThat(r162).as("test data").contains("纠正行动:");
		softly.assertThat(r162).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow107Field)).getText();
		softly.assertThat(r163).as("test data").contains("开展Error-Free");
		softly.assertThat(r163).as("test data").contains("自我评价培训，使主管认识到他或她的小组容易发生失误的方面");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow108)).getText();
		softly.assertThat(r164).as("test data").contains("OP3.3: 管理组织的自我分析存在不足");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow109Label)).getText();
		softly.assertThat(r165).as("test data").contains("纠正行动:");
		softly.assertThat(r165).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow109Field)).getText();
		softly.assertThat(r166).as("test data").contains("开展Error-Free");
		softly.assertThat(r166).as("test data").contains("自我评价培训，使经理认识到他或她的组织容易发生失误的方面");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow110)).getText();
		softly.assertThat(r167).as("test data").contains("OP3.4: 高风险制度或程序的自我评估存在不足");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow111Label)).getText();
		softly.assertThat(r168).as("test data").contains("纠正行动:");
		softly.assertThat(r168).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r169 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow111Field)).getText();
		softly.assertThat(r169).as("test data").contains("改进自我评估制度的频率和彻底性");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow112)).getText();
		softly.assertThat(r170).as("test data").contains("OP3.5: 对组织事件的根本原因分析分析质量差、事件数据收集和启动调查条件存在不足");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow113Label)).getText();
		softly.assertThat(r171).as("test data").contains("纠正行动:");
		softly.assertThat(r171).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow113Field)).getText();
		softly.assertThat(r172).as("test data").contains("改进执行组织事件根本原因分析的质量、数据收集和启动调查条件");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow114)).getText();
		softly.assertThat(r173).as("test data").contains("OP3.6: 对组织事件的共因分析没有定期执行（不够频繁）或是共因分析质量差");
		String r174 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow115Label)).getText();
		softly.assertThat(r174).as("test data").contains("纠正行动:");
		softly.assertThat(r174).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r175 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow115Field)).getText();
		softly.assertThat(r175).as("test data").contains("改进执行组织事件共因分析的频率和质量。评估可以识别弱点加以改进。");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow116)).getText();
		softly.assertThat(r176).as("test data").contains("OP4.1: 制度或流程负责人规定方面存在不足");
		String r177 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow117Label)).getText();
		softly.assertThat(r177).as("test data").contains("纠正行动:");
		softly.assertThat(r177).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r178 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow117Field)).getText();
		softly.assertThat(r178).as("test data").contains("改进制度管理人员的负责人规定");
		String r179 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow118)).getText();
		softly.assertThat(r179).as("test data").contains("OP4.2: 制度或流程相关人员的角色和责任规定方面存在不足");
		String r180 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow119Label)).getText();
		softly.assertThat(r180).as("test data").contains("纠正行动:");
		softly.assertThat(r180).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow119Field)).getText();
		softly.assertThat(r181).as("test data").contains("改进制度管理人员角色和责任的规定");
		String r182 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow120)).getText();
		softly.assertThat(r182).as("test data").contains("OP4.3: 用于跟踪制度或流程责任经理绩效（时间、质量和成本）的问责机制存在不足");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow121Label)).getText();
		softly.assertThat(r183).as("test data").contains("纠正行动:");
		softly.assertThat(r183).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow121Field)).getText();
		softly.assertThat(r184).as("test data").contains("改进问责机制，使其涵盖三个同样重要的方面（时间、质量和成本）。体系应当有助于实现良好绩效而非侧重于惩罚");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow122)).getText();
		softly.assertThat(r185).as("test data").contains("OP4.4: 总经理层问责机制不存在不足: (1) 未能客观评量总经理层绩效; (2) 未考量所有投资方反馈");
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow123Label)).getText();
		softly.assertThat(r186).as("test data").contains("纠正行动:");
		softly.assertThat(r186).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow123Field)).getText();
		softly.assertThat(r187).as("test data").contains("改进问责机制，使其涵盖总经理层");
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow124)).getText();
		softly.assertThat(r188).as("test data").contains("P1.1: 由于未意识到风险，而造成制度、程序或屏障（LOP）的遗漏，例如: (1) 新兴高风险问题的危机管理制度; (2) O&P决策制定和问题解决的管理授权制度; (3) 技术审查人员的培训和授权制度; (4) 不道德或违法活动的匿名举报制度; (5) 对标、根本原因分析、自我评估");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow125Label)).getText();
		softly.assertThat(r189).as("test data").contains("纠正行动:");
		softly.assertThat(r189).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow125Field)).getText();
		softly.assertThat(r190).as("test data").contains("编写被遗漏的制度, 识别其他被遗漏的类似制度，并实施纠正行动, 开展规则和制度设置的管理培训, 改进QA审计流程，识别被遗漏的制度");
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow126)).getText();
		softly.assertThat(r191).as("test data").contains("P1.2: 由于未意识到风险，而造成行为标准的遗漏，例如: (1) 预防粗心大意的失误的行为标准; (2) 关键思考、关键追问和情况警觉的行为标准; (3) 程序使用的行为标准");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow127Label)).getText();
		softly.assertThat(r192).as("test data").contains("纠正行动:");
		softly.assertThat(r192).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow127Field)).getText();
		softly.assertThat(r193).as("test data").contains("制定被遗漏的标准, 识别其他被遗漏的类似标准，并实施纠正行动, 开展标准设置方面的管理培训, 改进QA审计流程，识别被遗漏的行为标准");
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow128)).getText();
		softly.assertThat(r194).as("test data").contains("P1.3: 由于优先级不当而造成程序编写组织发布程序的时间推迟");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow129Label)).getText();
		softly.assertThat(r195).as("test data").contains("纠正行动:");
		softly.assertThat(r195).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow129Field)).getText();
		softly.assertThat(r196).as("test data").contains("改进优先级体系");
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow130)).getText();
		softly.assertThat(r197).as("test data").contains("P1.4: 由于培训组织优先级划分不当而造成实施的推迟");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow131Label)).getText();
		softly.assertThat(r198).as("test data").contains("纠正行动:");
		softly.assertThat(r198).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow131Field)).getText();
		softly.assertThat(r199).as("test data").contains("改进优先级体系");
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow132)).getText();
		softly.assertThat(r200).as("test data").contains("P1.5: 由于管理审查体系存在不足而造成制度、程序或屏障的遗漏");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow133Label)).getText();
		softly.assertThat(r201).as("test data").contains("纠正行动:");
		softly.assertThat(r201).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow133Field)).getText();
		softly.assertThat(r202).as("test data").contains("独立管理审查体系存在不足");
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow134)).getText();
		softly.assertThat(r203).as("test data").contains("P2.1: 由于程序编写导则存在不足，而造成要求不全面，例如条例、规范要求、用户和内部要求等");
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow135Label)).getText();
		softly.assertThat(r204).as("test data").contains("纠正行动:");
		softly.assertThat(r204).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow135Field)).getText();
		softly.assertThat(r205).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow136)).getText();
		softly.assertThat(r206).as("test data").contains("P2.2: 验证程序的操作条件存在不足，例如: (1) 进入条件; (2) 退出条件; (3) 中止程序的条件");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow137Label)).getText();
		softly.assertThat(r207).as("test data").contains("纠正行动:");
		softly.assertThat(r207).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow137Field)).getText();
		softly.assertThat(r208).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow138)).getText();
		softly.assertThat(r209).as("test data").contains("P2.3: 由于程序编写导则存在不足，而造成程序执行期间要求进行验证的假设存在不足或被遗漏");
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow139Label)).getText();
		softly.assertThat(r210).as("test data").contains("纠正行动:");
		softly.assertThat(r210).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow139Field)).getText();
		softly.assertThat(r211).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow140)).getText();
		softly.assertThat(r212).as("test data").contains("P2.4: 由于程序编写导则存在不足，而造成工作范围不充分，例如: (1) 逐步说明; (2) 逐项说明");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow141Label)).getText();
		softly.assertThat(r213).as("test data").contains("纠正行动:");
		softly.assertThat(r213).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow141Field)).getText();
		softly.assertThat(r214).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r215 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow142)).getText();
		softly.assertThat(r215).as("test data").contains("P2.5: 由于程序编写导则存在不足，而造成工后试验、测量或正确性验证方面存在不足");
		String r216 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow143Label)).getText();
		softly.assertThat(r216).as("test data").contains("纠正行动:");
		softly.assertThat(r216).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow143Field)).getText();
		softly.assertThat(r217).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow144)).getText();
		softly.assertThat(r218).as("test data").contains("P2.6: 缺少以下部分: (1) 目的说明; (2) 先决条件; (3) 术语定义; (4) 不准做清单经验反馈说明; (5) 参考文件; (6) 用户反馈请求");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow145Label)).getText();
		softly.assertThat(r219).as("test data").contains("纠正行动:");
		softly.assertThat(r219).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow145Field)).getText();
		softly.assertThat(r220).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow146)).getText();
		softly.assertThat(r221).as("test data").contains("P2.7: 由于审查存在不足而造成要素的遗漏");
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow147Label)).getText();
		softly.assertThat(r222).as("test data").contains("纠正行动:");
		softly.assertThat(r222).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow147Field)).getText();
		softly.assertThat(r223).as("test data").contains("开展审查方面的培训");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow148)).getText();
		softly.assertThat(r224).as("test data").contains("P2.8: 由于根本原因分析不到位导致要素的遗漏");
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow149Label)).getText();
		softly.assertThat(r225).as("test data").contains("纠正行动:");
		softly.assertThat(r225).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow149Field)).getText();
		softly.assertThat(r226).as("test data").contains("开展根本原因分析方面的培训");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow150)).getText();
		softly.assertThat(r227).as("test data").contains("P2.9: 由于纠正措施执行不到位导致要素的遗漏");
		String r228 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow151Label)).getText();
		softly.assertThat(r228).as("test data").contains("纠正行动:");
		softly.assertThat(r228).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r229 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow151Field)).getText();
		softly.assertThat(r229).as("test data").contains("开展纠正措施执行进度的监督跟进");
		String r230 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow152)).getText();
		softly.assertThat(r230).as("test data").contains("P3.1: 对制度外或程序外进行工作的指导存在不足");
		String r231 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow153Label)).getText();
		softly.assertThat(r231).as("test data").contains("纠正行动:");
		softly.assertThat(r231).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r232 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow153Field)).getText();
		softly.assertThat(r232).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r233 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow154)).getText();
		softly.assertThat(r233).as("test data").contains("P3.2: 由于程序编写导则存在不足，造成通过自检或独立检查单项弱点（SPV）步骤方面存在不足");
		String r234 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow155Label)).getText();
		softly.assertThat(r234).as("test data").contains("纠正行动:");
		softly.assertThat(r234).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r235 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow155Field)).getText();
		softly.assertThat(r235).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r236 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow156)).getText();
		softly.assertThat(r236).as("test data").contains("P3.3: 由于程序编写导则存在不足，造成审查先前不可逆点（PNR）行动方面存在不足");
		String r237 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow157Label)).getText();
		softly.assertThat(r237).as("test data").contains("纠正行动:");
		softly.assertThat(r237).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r238 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow157Field)).getText();
		softly.assertThat(r238).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r239 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow158)).getText();
		softly.assertThat(r239).as("test data").contains("P3.4: 由于程序编写导则存在不足，造成步骤、章节或页次的操作标记使用方面存在不足");
		String r240 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow159Label)).getText();
		softly.assertThat(r240).as("test data").contains("纠正行动:");
		softly.assertThat(r240).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r241 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow159Field)).getText();
		softly.assertThat(r241).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r242 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow160)).getText();
		softly.assertThat(r242).as("test data").contains("P3.5: 由于程序编写导则存在不足，造成使用不准做清单防止违章行为方面存在不足");
		String r243 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow161Label)).getText();
		softly.assertThat(r243).as("test data").contains("纠正行动:");
		softly.assertThat(r243).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r244 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow161Field)).getText();
		softly.assertThat(r244).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r245 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow162)).getText();
		softly.assertThat(r245).as("test data").contains("P3.6: 由于程序编写导则存在不足，造成使用工作现场提示信息防止例行工作出现粗心犯错方面存在不足");
		String r246 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow163Label)).getText();
		softly.assertThat(r246).as("test data").contains("纠正行动:");
		softly.assertThat(r246).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r247 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow163Field)).getText();
		softly.assertThat(r247).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r248 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow164)).getText();
		softly.assertThat(r248).as("test data").contains("P3.7: 由于程序编写导则存在不足，造成使用检查清单防止遗忘相关失误的方面存在不足");
		String r249 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow165Label)).getText();
		softly.assertThat(r249).as("test data").contains("纠正行动:");
		softly.assertThat(r249).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r250 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow165Field)).getText();
		softly.assertThat(r250).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r251 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow166)).getText();
		softly.assertThat(r251).as("test data").contains("P3.8: 由于程序编写导则存在不足，造成使用行为标准提供正面的同事压力以促使遵循规定方面存在不足");
		String r252 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow167Label)).getText();
		softly.assertThat(r252).as("test data").contains("纠正行动:");
		softly.assertThat(r252).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r253 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow167Field)).getText();
		softly.assertThat(r253).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序");
		String r254 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow168)).getText();
		softly.assertThat(r254).as("test data").contains("P3.9: 由于审查不充分，造成存在偏差控制方面的不足");
		String r255 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow169Label)).getText();
		softly.assertThat(r255).as("test data").contains("纠正行动:");
		softly.assertThat(r255).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r256 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow169Field)).getText();
		softly.assertThat(r256).as("test data").contains("开展审查方面的培训");
		String r257 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow170)).getText();
		softly.assertThat(r257).as("test data").contains("P3.10: 由于根本原因分析不到位，造成存在偏差控制方面的不足");
		String r258 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow171Label)).getText();
		softly.assertThat(r258).as("test data").contains("纠正行动:");
		softly.assertThat(r258).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r259 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow171Field)).getText();
		softly.assertThat(r259).as("test data").contains("开展根本原因分析方面的培训");
		String r260 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow172)).getText();
		softly.assertThat(r260).as("test data").contains("P3.11: 由于纠正措施执行不到位，造成存在偏差控制方面的不足");
		String r261 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow173Label)).getText();
		softly.assertThat(r261).as("test data").contains("纠正行动:");
		softly.assertThat(r261).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r262 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow173Field)).getText();
		softly.assertThat(r262).as("test data").contains("改善纠正措施的监督跟踪");
		String r263 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow174)).getText();
		softly.assertThat(r263).as("test data").contains("P4.1: 由于程序编写导则存在不足，使用需要解释或判断的词语，例如:过度、最大、最小、根据需要等");
		String r264 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow175Label)).getText();
		softly.assertThat(r264).as("test data").contains("纠正行动:");
		softly.assertThat(r264).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r265 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow175Field)).getText();
		softly.assertThat(r265).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		String r266 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow176)).getText();
		softly.assertThat(r266).as("test data").contains("P4.2: 由于程序编写导则存在不足，使用对一般程序用户而言缺少定义或解释的专业技术词汇");
		String r267 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow177Label)).getText();
		softly.assertThat(r267).as("test data").contains("纠正行动:");
		softly.assertThat(r267).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r268 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow177Field)).getText();
		softly.assertThat(r268).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		String r269 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow178)).getText();
		softly.assertThat(r269).as("test data").contains("P4.3: 由于程序编写导则存在不足，使用一般程序用户难以读懂的复杂和复合句");
		String r270 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow179Label)).getText();
		softly.assertThat(r270).as("test data").contains("纠正行动:");
		softly.assertThat(r270).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r271 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow179Field)).getText();
		softly.assertThat(r271).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		String r272 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow180)).getText();
		softly.assertThat(r272).as("test data").contains("P4.4: 由于程序编写导则存在不足，在缺少图纸、图片或图形的情况下描述复杂事物");
		String r273 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow181Label)).getText();
		softly.assertThat(r273).as("test data").contains("纠正行动:");
		softly.assertThat(r273).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r274 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow181Field)).getText();
		softly.assertThat(r274).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		String r275 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow182)).getText();
		softly.assertThat(r275).as("test data").contains("P4.5: 由于程序编写导则存在不足，使用需要解释的非描述性要求，例如:根据要求、根据需要等");
		String r276 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow183Label)).getText();
		softly.assertThat(r276).as("test data").contains("纠正行动:");
		softly.assertThat(r276).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r277 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow183Field)).getText();
		softly.assertThat(r277).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		String r278 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow184)).getText();
		softly.assertThat(r278).as("test data").contains("P4.6: 导则或说明存在错误: (1) 过时的导则; (2) 错误的导则或说明; (3) 程序中存在错误的步骤");
		String r279 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow185Label)).getText();
		softly.assertThat(r279).as("test data").contains("纠正行动:");
		softly.assertThat(r279).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r280 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow185Field)).getText();
		softly.assertThat(r280).as("test data").contains("开展程序设计的培训, 改进存在缺陷的导则或程序, 改进程序审查流程");
		String r281 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow186)).getText();
		softly.assertThat(r281).as("test data").contains("P4.7: 由于程序审查不充分，造成存在模糊或错误的说明");
		String r282 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow187Label)).getText();
		softly.assertThat(r282).as("test data").contains("纠正行动:");
		softly.assertThat(r282).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r283 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow187Field)).getText();
		softly.assertThat(r283).as("test data").contains("开展程序审查的培训, 改进程序审查流程");
		String r284 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow188)).getText();
		softly.assertThat(r284).as("test data").contains("P4.8: 设备的标识和识别不到位");
		String r285 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow189Label)).getText();
		softly.assertThat(r285).as("test data").contains("纠正行动:");
		softly.assertThat(r285).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r286 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow189Field)).getText();
		softly.assertThat(r286).as("test data").contains("改进设备标识和识别");
		String r287 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow190)).getText();
		softly.assertThat(r287).as("test data").contains("P5.1: 由于不相关要求造成不必要的工作");
		String r288 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow191Label)).getText();
		softly.assertThat(r288).as("test data").contains("纠正行动:");
		softly.assertThat(r288).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r289 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow191Field)).getText();
		softly.assertThat(r289).as("test data").contains("减少导则或程序中的负担, 开展Error-Free");
		softly.assertThat(r289).as("test data").contains("工作流程优化的培训");
		String r290 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow192)).getText();
		softly.assertThat(r290).as("test data").contains("P5.2: 没有对程序步骤进行优化，以确保效率和方便执行");
		String r291 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow193Label)).getText();
		softly.assertThat(r291).as("test data").contains("纠正行动:");
		softly.assertThat(r291).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r292 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow193Field)).getText();
		softly.assertThat(r292).as("test data").contains("优化程序，以确保效率和方便执行, 开展Error-Free");
		softly.assertThat(r292).as("test data").contains("工作流程优化的培训");
		String r293 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow194)).getText();
		softly.assertThat(r293).as("test data").contains("P5.3: 加重相关人员或小组不必要的差事（相关小组的多重任务）");
		String r294 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow195Label)).getText();
		softly.assertThat(r294).as("test data").contains("纠正行动:");
		softly.assertThat(r294).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r295 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow195Field)).getText();
		softly.assertThat(r295).as("test data").contains("避免同时进行多重任务, 开展Error-Free");
		softly.assertThat(r295).as("test data").contains("工作流程优化的培训");
		String r296 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow196)).getText();
		softly.assertThat(r296).as("test data").contains("P5.4: 制定不必要的工作，而未提高质量，例如进行散弹枪式的根本原因分析，对未发生故障的设备制定不必要工作或制定预防性维修工作");
		String r297 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow197Label)).getText();
		softly.assertThat(r297).as("test data").contains("纠正行动:");
		softly.assertThat(r297).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r298 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow197Field)).getText();
		softly.assertThat(r298).as("test data").contains("改善根本原因分析流程, 改善预防性维修工作流程, 开展Error-Free");
		softly.assertThat(r298).as("test data").contains("工作流程优化的培训");
		String r299 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow198)).getText();
		softly.assertThat(r299).as("test data").contains("P5.5: 一个组织负责的职责若该由其他组织执行会更有效率");
		String r300 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow199Label)).getText();
		softly.assertThat(r300).as("test data").contains("纠正行动:");
		softly.assertThat(r300).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r301 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow199Field)).getText();
		softly.assertThat(r301).as("test data").contains("组织改组以提高效率和绩效");
		String r302 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow200)).getText();
		softly.assertThat(r302).as("test data").contains("P5.6: 为执行要求而开展不必要的工作，例如长途驱车至场外仓库取用常用工具，填写冗长的表格等");
		String r303 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow201Label)).getText();
		softly.assertThat(r303).as("test data").contains("纠正行动:");
		softly.assertThat(r303).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r304 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow201Field)).getText();
		softly.assertThat(r304).as("test data").contains("减少导则或程序中的负担, 开展Error-Free");
		softly.assertThat(r304).as("test data").contains("工作流程优化的培训");
		String r305 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow202)).getText();
		softly.assertThat(r305).as("test data").contains("P5.7: 审查人员人数过多，并且未规定角色和责任，导致各个审查员跳过审查，依赖其他人查找失误");
		String r306 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow203Label)).getText();
		softly.assertThat(r306).as("test data").contains("纠正行动:");
		softly.assertThat(r306).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r307 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow203Field)).getText();
		softly.assertThat(r307).as("test data").contains("开展Error-Free");
		softly.assertThat(r307).as("test data").contains("工作流程优化的培训, 开展审查培训, 规定审查人员的角色和责任, 对审查人员实行问责制");
		String r308 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow204)).getText();
		softly.assertThat(r308).as("test data").contains("P5.8: 在使用软件和连通技术方面存在不足，例如进行RCA的智能电话制度、检查清单、工前会、数据搜索等");
		String r309 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow205Label)).getText();
		softly.assertThat(r309).as("test data").contains("纠正行动:");
		softly.assertThat(r309).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String r310 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow205Field)).getText();
		softly.assertThat(r310).as("test data").contains("使用软件或智能电话技术跟踪沟通情况");
		if(browserName.equals("chrome"))
		{
			String r311 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow206)).getText();
			softly.assertThat(r311).as("test data").contains("OP3.1: 个人的自我分析存在不足");
			String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow207Label)).getText();
			softly.assertThat(r312).as("test data").contains("纠正行动:");
			softly.assertThat(r312).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
			String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow207Field)).getText();
			softly.assertThat(r313).as("test data").contains("开展Error-Free");
			softly.assertThat(r313).as("test data").contains("自我评价培训，使人员认识到他或她容易发生失误的方面");
		}
		else
		{
			String r311 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow206)).getText();
			softly.assertThat(r311).as("test data").contains("P5.9: 使用过时且繁重的技术或工具来执行工作");
			String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow207Label)).getText();
			softly.assertThat(r312).as("test data").contains("纠正行动:");
			softly.assertThat(r312).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
			String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep4TableRow207Field)).getText();
			softly.assertThat(r313).as("test data").contains("改进工作技术或工具");	 
		}
	}

}
