package kaleTestSoftware;

import org.openqa.selenium.By;

public class SRIPageObj {

	public By SRILink = By.id("pii-a-menu-sri");
	
	//Admin SRI
	public By LoginNameOnTop = By.id("pii-user-loginname");
	public By AdminOption = By.id("pii-user-admin");
	public By AnalysisSideLink = By.xpath(".//*[@id='pii-admin-analysis']/h3/a");
	public By SRISideLink = By.id("pii-admin-sri-manage-button");
	public By SRIAdminSaveButton = By.id("pii-asri-button-save");
	public By SRIAdminPopupConfirmButton = By.id("pii-asri-dialog-confirmed");
	//Components Tab
	public By SRIAdminComponentsTab = By.id("pii-asri-tab-1-a");
	public By SRIAdminComponentsTabMechanicalOption = By.xpath(".//*[@for='pii-asri-component-cat-mech']");
	public By SRIAdminComponentsTabElectricalOption = By.xpath(".//*[@for='pii-asri-component-cat-elec']");
	public By SRIAdminComponentNameFieldEnglish = By.id("pii-asri-component-name-en");
	public By SRIAdminComponentAddButton = By.id("pii-asri-component-add");
	//Measurement Tab
	public By SRIAdminMeasurementTab = By.id("pii-asri-tab-2-a");
	public By SRIAdminMeasurementNameFieldEnglish = By.id("pii-asri-meas-name");
	public By SRIAdminMeasurementTabMechanicalDropdown = By.id("pii-asri-meas-component-mech");
	public By SRIAdminMeasurementTabElectricalDropdown = By.id("pii-asri-meas-component-elec");
	public By SRIAdminMeasurementAddButton = By.id("pii-asri-meas-add");
	//Units Tab
	public By SRIAdminUnitsTab = By.id("pii-asri-tab-3-a");
	public By SRIAdminUnitName = By.id("pii-asri-unit-name");
	public By SRIAdminUnitTabMeasurementDropdown = By.id("pii-asri-unit-meas-select");
	public By SRIAdminUnitAddButton = By.id("pii-asri-unit-add");
	//Baseline Tab
	public By SRIAdminBaselinesTab = By.id("pii-asri-tab-4-a");
	public By SRIAdminBaselineTabMechanicalDropdown = By.id("pii-asri-baseline-component-mech");
	public By SRIAdminBaselineTabElectricalDropdown = By.id("pii-asri-baseline-component-elec");
	public By SRIAdminBaselineTabMeasurementDropdown = By.id("pii-asri-baseline-meas-new");
	public By SRIAdminBaselineTabUnitDropdown = By.id("pii-asri-baseline-unit-new");
	public By SRIAdminFS1Field = By.id("pii-asri-baseline-FS1-new");
	public By SRIAdminFS2Field = By.id("pii-asri-baseline-FS2-new");
	public By SRIAdminFS3Field = By.id("pii-asri-baseline-FS3-new");
	public By SRIAdminBaselineAddButton = By.id("pii-asri-baseline-add");
	//Conclusion Tab
	public By SRIAdminConclusionsTab = By.id("pii-asri-tab-5-a");
	public By SRIAdminConclusionTabMechanicalDropdown = By.id("pii-asri-conclusion-component-mech");
	public By SRIAdminConclusionTabElectricalDropdown = By.id("pii-asri-conclusion-component-elec");
	public By SRIAdminConclusionTabMeasurementDropdown = By.id("pii-asri-conclusion-meas-new");
	public By SRIAdminFS1ConclusionField = By.id("pii-asri-conclusion-fs1conc-new");
	public By SRIAdminFS2ConclusionField = By.id("pii-asri-conclusion-fs2conc-new");
	public By SRIAdminFS3ConclusionField = By.id("pii-asri-conclusion-fs3conc-new");
	public By SRIAdminConclusionAddButton = By.id("pii-asri-conclusion-add");
	
	
	//Step1
	public By SRIStep1NextButton = By.id("pii-sri-tab-1-form-submit");
	public By Step1TitleCharacterCount = By.id("pii-sri-tab-1-title-count");
	public By Step1EventTitle = By.id("pii-sri-tab-1-title");
	public By Step1InspectionStaff = By.id("pii-sri-tab-1-inspection-staff");
	public By Step1Component = By.id("pii-sri-tab-1-component");
	public By Step1EventTitleErrorText = By.id("pii-sri-tab-1-title-error");
	public By Step1InspectionStaffErrorText = By.id("pii-sri-tab-1-inspection-staff-error");
	public By Step1ComponentErrorText = By.id("pii-sri-tab-1-component-error");
	public By Step1ComponentOther = By.id("pii-sri-tab-1-component-other");
	public By Step1ReportCreation = By.id("pii-sri-tab-1-repdatetime");
	//Step 2
	public By Step2Measurement = By.id("pii-sri-newentry-measurement");
	public By Step2CalendarIconAddMeasurement = By.xpath(".//*[@id='pii-sri-tab-2-measurements']/div/div[1]/div[2]/div/div/a");
	public By Step2ClockIconAddMeasurement = By.xpath(".//*[@id='pii-sri-tab-2-measurements']/div/div[2]/div[2]/div/div/a");
	public By Step2Measurment = By.id("pii-sri-newentry-measurement");
	public By Step2Value = By.id("pii-sri-newentry-value");
	public By Step2Notes = By.id("pii-sri-newentry-notes");
	public By Step2AddButton = By.id("pii-sri-newevent-add");
	public By Step2Measurement1CalendarIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[2]/div/div/a");
	public By Step2Measurement1ClockIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[3]/div/div/a");
	public By Step2Measurement2CalendarIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[2]/div/div/a");
	public By Step2Measurement2ClockIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[3]/div/div/a");
	public By Step2Measurement1Date = By.id("pii-sri-tab-1-event-date");
	public By Step2Measurement1DateFirefox = By.id("pii-sri-tab-1-event0-date");
	public By Step2Measurement2Date = By.id("pii-sri-tab-1-event1-date");
	public By Step2Measurement1Time = By.id("pii-sri-tab-1-event-time");
	public By Step2Measurement1TimeFirefox = By.id("pii-sri-tab-1-event0-time");
	public By Step2Measurement2Time = By.id("pii-sri-tab-1-event1-time");
	public By Step2MeasurementDropDown = By.id("pii-sri-newentry-measurement-button");
	public By Step2Measurement1Measurement =  By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[4]/div/div/span");
	public By Step2Measurement2Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[4]/div/div/span");
	public By Step2Measurement1Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[5]/textarea");
	public By Step2Measurement2Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[5]/textarea");
	public By Step2Measurement1Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[6]/textarea");
	public By Step2Measurement2Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[6]/textarea");
			
	public By SRINextButton = By.id("pii-sri-next");
	public By SRISaveButton = By.id("pii-sri-save");
	public By SRISaveConfirmButton = By.id("pii-sri-dialog-confirmed");
	public By SRISavedActivitiesButton = By.id("pii-sri-savedactivities");
	public By SRINewRecord = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a");
	public By SRISidePanel = By.id("pii-user-home-panel-btn-sri");
	public By SRIShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a/span[1]");
	public By SRIShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a/span[2]");
	public By SRIMarkCriticalIndicatorText = By.xpath(".//*[@id='sri-rpt']/div[1]/table/thead/tr/th/strong");
	
	//Report Tab
	public By ReportTabEventTitle = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[1]/td[2]");
	public By ReportTabInspectionStaff = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[3]/td[2]");
	public By ReportTabComponent = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[4]/td[2]");
	public By ReportTabMeasurement1Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[2]");
	public By ReportTabMeasurement1Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[3]");
	public By ReportTabMeasurement1Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[4]");
	public By ReportTabMeasurement1Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[5]");
	public By ReportTabMeasurement1Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[6]");
	public By ReportTabMeasurement2Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[2]");
	public By ReportTabMeasurement2Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[3]");
	public By ReportTabMeasurement2Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[4]");
	public By ReportTabMeasurement2Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[5]");
	public By ReportTabMeasurement2Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[6]");
	//HTML
	public By HTMLEventTitle = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[1]/td[2]");
	public By HTMLInspectionStaff = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[3]/td[2]");
	public By HTMLComponent = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[4]/td[2]");
	public By HTMLMeasurement1Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[2]");
	public By HTMLMeasurement1Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[3]");
	public By HTMLMeasurement1Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[4]");
	public By HTMLMeasurement1Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[5]");
	public By HTMLMeasurement1Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[6]");
	public By HTMLMeasurement2Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[2]");
	public By HTMLMeasurement2Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[3]");
	public By HTMLMeasurement2Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[4]");
	public By HTMLMeasurement2Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[5]");
	public By HTMLMeasurement2Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[6]");

}
