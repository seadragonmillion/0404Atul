package kaleTestSoftware;

import org.openqa.selenium.By;


public class CaseBrowseObj {

	By ErrorFreeBankLinkHomePage = By.id("pii-main-menu-button-e");
	By HumanPerformanceLink = By.linkText("Human Performance");
	By EquipmentPerformanceLink = By.linkText("Equipment Performance");
	By EquipmentDatabankOnlyLink = By.linkText("Equipment Data Bank (Instructor Only)");
	By ElectricalFailureModeLink = By.linkText("Electrical Failure Modes");
	By MechanicalFailureModeLink = By.linkText("Mechanical Failure Modes");
	By FailureModeLink = By.linkText("Failure Modes");
	By EquipmentDatabankOnlyLink1 = By.id("pii-e-menu-equipPII");

	//Error-free Bank Module page
	By HumanPerformancePosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[1]/a");
	By EngineeringFundamentalPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[2]/a");
	By EquipmentPerformancePosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[3]/a");
	By FailureModesPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[4]/a");
	By PreventionOfDesignDeficienciesPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[5]/a");
	By EquipmentDatabankOnlyPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[6]/a");

	//Equipment Case
	By EquipmentAddKeywordField = By.id("pii-admin-efse-keyword-search-input");
	By EquipmentAddKeywordButton = By.id("pii-admin-efse-keyword-new");

	//Equipment Search
	By EquipmentSearchKeywordField = By.id("pii-efse-searchbykw-input");
	By EquipmentSearchClearButton = By.id("pii-efse-clear");
	By EquipmentSearchKeywordFieldSearchButton = By.id("pii-efse-searchbykw-btn");
	By EquipmentDropDownList = By.xpath(".//*[@id='pii-efse-keyword-list']/li");
	By EquipmentDropDownListTitle = By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]");
	By EquipmentSearchCaseIDFieldClearButton = By.xpath(".//*[@id='pii-keyword-block-equip']/div[3]/div/div/a");
	By EquipmentSearchCaseIdField = By.id("pii-efse-searchbyid-input");
	By EquipmentModuleTitle = By.id("pii-efse-search-label");
	By EquipmentSearchDropDown = By.id("pii-efse-keyword-list");
	By EquipmentSearchKeywordFieldClearButton = By.xpath(".//*[@id='pii-keyword-block-equip']/div[4]/div/div/a");
	By EquipmentSearchCaseIDFieldSearchButton = By.id("pii-efse-searchbyid-btn");
	By EquipSearch1stCollapsibleCases = By.xpath(".//*[@id='pii-question-list-equip']/div[1]/h4/a");
	By EquipSearch2ndCollapsibleCases = By.xpath(".//*[@id='pii-question-list-equip']/div[2]/h4/a");
	By CaseSearchDisciplineBoxText = By.xpath(".//*[@id='pii-efse-filter-discipline-button']/span[1]");
	By CaseSearchDisciplineBox = By.id("pii-efse-filter-discipline-button");
	By CaseSearchDisciplineList = By.id("pii-efse-filter-discipline-listbox");
	By CaseSearchDisciplinePopupClose = By.xpath(".//*[@id='pii-efse-filter-discipline-listbox']/div/a");
	By EquipCaseSearchListDisciplineElectrical = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[1]/a");
	By EquipCaseSearchListDisciplineGeneral = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[2]/a");
	By EquipCaseSearchListDisciplineIC = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[3]/a");
	By EquipCaseSearchListDisciplineMechanical = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[4]/a");
	By EquipCaseSearchListDisciplineSoftware = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[5]/a");
	By EquipCaseSearchListDisciplineStructural = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[6]/a");
	By CaseSearchFieldBox = By.id("pii-efse-filter-field-button");
	By CaseSearchFieldList = By.id("pii-efse-filter-field-listbox");
	By CaseSearchFieldPopupClose = By.xpath(".//*[@id='pii-efse-filter-field-listbox']/div/a");
	By EquipCaseSearchListFieldAuto = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[1]/a");
	By EquipCaseSearchListFieldNuclear = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[2]/a");
	By EquipCaseSearchListFieldOther = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[3]/a");
	By EquipCaseSearchListFieldPharmaceutical = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[4]/a");
	By EquipCaseSearchListFieldWelding = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[5]/a");
	By CaseSearchTypeBox = By.id("pii-efse-filter-type-button");
	By CaseSearchTypeList = By.id("pii-efse-filter-type-listbox");
	By CaseSearchTypesPopupClose = By.xpath(".//*[@id='pii-efse-filter-type-listbox']/div/a");
	By EquipCaseSearchListTypesAdvancedLearning = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[1]/a");
	By EquipCaseSearchListTypesCaseStudies = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[2]/a");
	By EquipCaseSearchListTypesDesign = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[3]/a");
	By EquipCaseSearchListTypesFailureMode = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[4]/a");
	By EquipCaseSearchListTypesFundamentals = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[5]/a");
	By EquipCaseSearchListTypesGeneral = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[6]/a");

	//Human Case
	By HumanAddKeywordField = By.id("pii-admin-efsh-keyword-search-input");
	By HumanAddKeywordButton = By.id("pii-admin-efsh-keyword-new");

	//Human Search
	By HumanSearchKeywordField = By.id("pii-efsh-searchbykw-input");
	By HumanSearchClearButton = By.id("pii-efsh-clear");
	By HumanSearchCaseIdField = By.id("pii-efsh-searchbyid-input");
	By HumanSearchCaseIDFieldClearButton = By.xpath(".//*[@id='pii-keyword-block']/div[3]/div/div/a");
	By HumanSearchCaseIDFieldSearchButton = By.id("pii-efsh-searchbyid-btn");
	By HumanSearchDropDown = By.id("pii-efsh-keyword-list");
	By HumanSearchKeywordFieldSearchButton = By.id("pii-efsh-searchbykw-btn");
	By HumanDropDownList = By.xpath(".//*[@id='pii-efsh-keyword-list']/li");
	By HumanDropDownListTitle = By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]");
	By HumanSearchKeywordFieldClearButton = By.xpath(".//*[@id='pii-keyword-block']/div[4]/div/div/a");
	By HumanSearchDropdownListLoaded = By.xpath(".//*[@id='pii-question-list']/div/h4/a/div");
	By HumanSearch1stCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[1]/h4/a");
	By HumanSearch2ndCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[2]/h4/a");
	By HumanSearch3rdCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[3]/h4/a");
	By HumanSearch1stCollapsibleCasesText = By.xpath(".//*[@id='pii-question-list']/div[1]/h4/a/div");
	By HumanSearch2ndCollapsibleCasesText = By.xpath(".//*[@id='pii-question-list']/div[2]/h4/a/div");
	By HumanSearch3rdCollapsibleCasesText = By.xpath(".//*[@id='pii-question-list']/div[3]/h4/a/div");

	//Slides
	By SlideNextButton = By.linkText("Next");
	By SlidePreviousButton = By.linkText("Previous");

}
