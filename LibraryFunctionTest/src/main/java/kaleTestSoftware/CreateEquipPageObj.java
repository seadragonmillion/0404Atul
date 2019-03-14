package kaleTestSoftware;


import java.util.Random;

import org.openqa.selenium.By;


public class CreateEquipPageObj {

	By KaleHomePage = By.className("pii-logo-div-element-kale");

	//Equipment databank only search page
	By EquipDropwdownTitle_1st = By.xpath(".//*[@id='pii-question-list-equip']/div[1]/h4/a/div");
	By EquipDropwdownTitle_2nd = By.xpath(".//*[@id='pii-question-list-equip']/div[2]/h4/a/div");
	By EquipDropwdownTitle_3rd = By.xpath(".//*[@id='pii-question-list-equip']/div[3]/h4/a/div");
	By EquipSearchMessage = By.xpath(".//*[@id='pii-efse-search-message']/div");
	By EquipSearchMessageErrorLink = By.xpath(".//*[@id='pii-efse-search-message']/div/a");
	By PreventionOfDesignDeficienciesLink = By.linkText("Prevention of Design Deficiencies");
	By EngineeringFundamentalsLink = By.linkText("Engineering Fundamentals");

	//Create equipment case page
	By EquipCaseNewButton = By.id("pii-admin-efse-button-new");
	By EquipCasePopupTitle = By.id("pii-admin-efse-dialog-title");
	By EquipCasePopupConfirmButton = By.id("pii-admin-efse-dialog-confirmed");
	By EquipCaseIDField = By.id("pii-admin-efse-id");
	By EquipCaseIDFieldError = By.id("pii-admin-efse-id-error");
	By EquipCaseTypes = By.id("pii-admin-efse-type-button");
	By EquipCaseTypeFieldText = By.xpath(".//*[@id='pii-admin-efse-type-button']/span[1]");
	By EquipCaseQuestion = By.id("pii-admin-efse-question");
	By EquipCaseAnswer = By.id("pii-admin-efse-answer");
	By EquipCaseNewKeywordField = By.id("pii-admin-efse-keyword-search-input");
	By EquipCaseNewKeywordAddButton = By.id("pii-admin-efse-keyword-new");
	By EquipCaseKeywordExistingList = By.xpath(".//*[@id='pii-admin-efse-keyword-blocks']/div[2]/ul");
	By EquipImageUploadField = By.id("pii-admin-efse-upload-file-input");
	By EquipImageCollapsible = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a");
	By EquipCaseSaveButton = By.id("pii-admin-efse-button-save");
	By EquipCasesLink = By.id("pii-admin-efse-manage-button");
	By EquipCaseSearchCaseIDAdmin = By.id("pii-admin-efse-list-input");
	By EquipCaseSearchCaseIDDropdownAdmin = By.id("pii-admin-efse-list-ul");
	By EquipCaseDeleteButton = By.id("pii-admin-efse-button-delete");
	By EquipCaseEditButton = By.id("pii-admin-efse-button-edit");
	By EquipCaseExistingKeywordOnlyOne = By.xpath(".//*[@id='pii-admin-efse-keyword-form']/div/ul/li/a");
	By EquipCaseKeywordList = By.id("pii-admin-efse-keyword-list");
	By EquipImageCollapsibleExpanded = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div");
	By EquipCaseFields = By.id("pii-admin-efse-field-button");
	By EquipCaseFieldsFieldText = By.xpath(".//*[@id='pii-admin-efse-field-button']/span[1]");
	By EquipCaseDiscipline = By.id("pii-admin-efse-discipline-button");
	By EquipCaseDisciplineFieldText = By.xpath(".//*[@id='pii-admin-efse-discipline-button']/span[1]");
	By EquipListBoxTypes = By.id("pii-admin-efse-type-listbox");
	By ListCrossSymbol = By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete");
	By EquipListBoxTypesCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-type-listbox']/div/a");
	By EquipListBoxDisciplineCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-discipline-listbox']/div/a");
	By EquipListBoxDiscipline = By.id("pii-admin-efse-discipline-listbox");
	By EquipListBoxFields = By.id("pii-admin-efse-field-listbox");
	By EquipListBoxFieldsCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-field-listbox']/div/a");
	By EquipCasesLink1Title = By.id("pii-admin-efse-linktitle-0");
	By EquipCasesLink1URL = By.id("pii-admin-efse-linkurl-0");
	By EquipCasesLink2Title = By.id("pii-admin-efse-linktitle-1");
	By EquipCasesLink2URL = By.id("pii-admin-efse-linkurl-1");
	By EquipCasesLink3Title = By.id("pii-admin-efse-linktitle-2");
	By EquipCasesLink3URL = By.id("pii-admin-efse-linkurl-2");
	By EquipCasesLink4Title = By.id("pii-admin-efse-linktitle-3");
	By EquipCasesLink4URL = By.id("pii-admin-efse-linkurl-3");
	By EquipCasesLink5Title = By.id("pii-admin-efse-linktitle-4");
	By EquipCasesLink5URL = By.id("pii-admin-efse-linkurl-4");
	By EquipCasesLink6Title = By.id("pii-admin-efse-linktitle-5");
	By EquipCasesLink6URL = By.id("pii-admin-efse-linkurl-5");
	By EquipCasesLink7Title = By.id("pii-admin-efse-linktitle-6");
	By EquipCasesLink7URL = By.id("pii-admin-efse-linkurl-6");
	By EquipCasesLink8Title = By.id("pii-admin-efse-linktitle-7");
	By EquipCasesLink8URL = By.id("pii-admin-efse-linkurl-7");
	By EquipCasesLink9Title = By.id("pii-admin-efse-linktitle-8");
	By EquipCasesLink9URL = By.id("pii-admin-efse-linkurl-8");
	By EquipCasesLink10Title = By.id("pii-admin-efse-linktitle-9");
	By EquipCasesLink10URL = By.id("pii-admin-efse-linkurl-9");
	By EquipCasesLink11Title = By.id("pii-admin-efse-linktitle-10");
	By EquipCasesLink11URL = By.id("pii-admin-efse-linkurl-10");
	By EquipCasesLink12Title = By.id("pii-admin-efse-linktitle-11");
	By EquipCasesLink12URL = By.id("pii-admin-efse-linkurl-11");
	By EquipCasesLink13Title = By.id("pii-admin-efse-linktitle-12");
	By EquipCasesLink13URL = By.id("pii-admin-efse-linkurl-12");
	By EquipCasesLink1VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink2VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink3VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-2']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink4VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-3']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink5VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-4']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink6VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-5']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLinkTitleOnSide = By.id("pii-admin-efse-linklabel-0");
	By EquipCasesLink1TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[1]/div/a");
	By EquipCasesLink1URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[2]/table/tbody/tr[1]/td[2]/div/a");
	By EquipCasesLink2TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[1]/div/a");
	By EquipCasesLink2URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[2]/table/tbody/tr[1]/td[2]/div/a");

	By EquipCasesTypeList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[2]/div/a/span[2]");
	By EquipListTypesAdvancedLearning = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[1]/a");
	By EquipListTypesCaseStudies = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[2]/a");
	By EquipListTypesDesign = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[3]/a");
	By EquipListTypesFailureModes = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[4]/a");
	By EquipListTypesFundamentals = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[5]/a");
	By EquipListTypesGeneral = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[6]/a");

	By EquipCasesDisciplineList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[3]/div/a/span[2]");
	By EquipListDisciplineElectrical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[1]/a");
	By EquipListDisciplineGeneral = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[2]/a");
	By EquipListDisciplineIC = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[3]/a");
	By EquipListDisciplineMechanical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[4]/a");
	By EquipListDisciplineSoftware = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[5]/a");
	By EquipListDisciplineStructural = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[6]/a");

	By EquipCasesFieldList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[4]/div/a/span[2]");
	By EquipListFieldsAuto = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[1]/a");
	By EquipListFieldsNuclear = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[2]/a");
	By EquipListFieldsOther = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[3]/a");
	By EquipListFieldsPharmaceutical = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[4]/a");
	By EquipListFieldsWelding = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[5]/a");

	//Related links slide
	//	By RelatedLinksSlideTitle = By.xpath(".//*[@class='pii-linkslide']/div[1]/div");
	/*	By RelatedLinksSlideLink1Title = By.xpath(".//*[@class='pii-linkslide']/div[2]");
	By RelatedLinksSlideLink2Title = By.xpath(".//*[@class='pii-linkslide']/div[3]");
	By RelatedLinksSlideLink3Title = By.xpath(".//*[@class='pii-linkslide']/div[4]");
	By RelatedLinksSlideLink4Title = By.xpath(".//*[@class='pii-linkslide']/div[5]");
	By RelatedLinksSlideLink5Title = By.xpath(".//*[@class='pii-linkslide']/div[6]");
	By RelatedLinksSlideLink6Title = By.xpath(".//*[@class='pii-linkslide']/div[7]");
	By RelatedLinksSlideLink7Title = By.xpath(".//*[@class='pii-linkslide']/div[8]");
	By RelatedLinksSlideLink8Title = By.xpath(".//*[@class='pii-linkslide']/div[9]");
	By RelatedLinksSlideLink9Title = By.xpath(".//*[@class='pii-linkslide']/div[10]");
	By RelatedLinksSlideLink1URL = By.xpath(".//*[@class='pii-linkslide']/div[2]/a");
	By RelatedLinksSlideLink2URL = By.xpath(".//*[@class='pii-linkslide']/div[3]/a");
	By RelatedLinksSlideLink4URL = By.xpath(".//*[@class='pii-linkslide']/div[5]/a");
	 */
	
	public int selectNumberForType() throws Exception {

		//Choose a number between 
		Random random = new Random ();
		int x;
		//Choose a number between 1 and 6
		while(true)
		{
			x = random.nextInt(7);
			if(x==0)
				continue;
			break;
		}
		return x;
	}
}
