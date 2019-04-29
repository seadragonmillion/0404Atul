package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SRIAdmin {

	SoftAssertions softly = new SoftAssertions();

	SRIPageObj sri = new SRIPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	Login login = new Login();
	ShareCheck share = new ShareCheck();

	//Mechanical
	public String mechanicalComponent1 = "QAA Mechanical Component 1";
	public String mechanicalMeasurement1 = "QAA Mechanical Measurement 1";
	public String mechanicalUnit1 = "QAA Mechanical Unit 1";
	public String mechanicalFSIBaseline1 = "10";
	public String mechanicalFSIBaseline2 = "20";
	public String mechanicalFSIBaseline3 = "30";
	public String mechanicalFSIConclusion1 = "Mechanical Conclusion 1";
	public String mechanicalFSIConclusion2 = "Mechanical Conclusion 2";
	public String mechanicalFSIConclusion3 = "Mechanical Conclusion 3";

	//Electrical
	public String electricalComponent1 = "QAA Electrical Component 1";
	public String electricalMeasurement1 = "QAA Electrical Measurement 1";
	public String electricalUnit1 = "QAA Electrical Unit 1";
	public String electricalFSIBaseline1 = "10";
	public String electricalFSIBaseline2 = "20";
	public String electricalFSIBaseline3 = "30";
	public String electricalFSIConclusion1 = "Electrical Conclusion 1";
	public String electricalFSIConclusion2 = "Electrical Conclusion 2";
	public String electricalFSIConclusion3 = "Electrical Conclusion 3";

	public void SRIAdminTest(WebDriver driver, String username, String password) throws Exception {

		//Get to SRI Admin part
		getToSRIAdmin(driver);
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		//Delete all previous
		//Delete all mechanical
		//Click on SRI
		int sum = deleteConclusionAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1);
		sum = sum + deleteBaselineAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalUnit1);
		sum = sum + deleteUnitAdded(driver,mechanicalMeasurement1,mechanicalUnit1);
		sum = sum + deleteMeasurementAdded(driver,mechanicalComponent1,mechanicalMeasurement1,0);
		sum = sum + deleteComponentAdded(driver,mechanicalComponent1,0);
		//Save
		if(sum>0)
			saveChangedValues(driver);
		sum = 0;
		//Delete all elecrical
		sum = sum + deleteConclusionAdded(driver,1,electricalComponent1,electricalMeasurement1);
		sum = sum + deleteBaselineAdded(driver,1,electricalComponent1,electricalMeasurement1,electricalUnit1);
		sum = sum + deleteUnitAdded(driver,electricalMeasurement1,electricalUnit1);
		sum = sum + deleteMeasurementAdded(driver,electricalComponent1,electricalMeasurement1,1);
		sum = sum + deleteComponentAdded(driver,electricalComponent1,1);
		//Save
		if(sum>0)
			saveChangedValues(driver);
		//Mechanical
		//Add a component
		addSRIComponentInAdmin(driver,0,mechanicalComponent1);
		//Add a measurement
		addSRIMeasurementInAdmin(driver,0,mechanicalComponent1,mechanicalMeasurement1);
		//Add a unit
		addSRIUnitInAdmin(driver,mechanicalMeasurement1,mechanicalUnit1);
		//Add a baseline
		addSRIBaselineInAdmin(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalUnit1,mechanicalFSIBaseline1,mechanicalFSIBaseline2,mechanicalFSIBaseline3);
		//Add a conclusion
		addSRIConclusionInAdmin(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalFSIConclusion1,mechanicalFSIConclusion2,mechanicalFSIConclusion3);
		//Save
		saveChangedValues(driver);
		//Verify all added values
		verifyComponentAdded(driver,mechanicalComponent1,0);
		verifyMeasurementAdded(driver,mechanicalComponent1,mechanicalMeasurement1,0);
		verifyUnitAdded(driver,mechanicalMeasurement1,mechanicalUnit1);
		verifyBaselineAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalUnit1,mechanicalFSIBaseline1,mechanicalFSIBaseline2,mechanicalFSIBaseline3);
		verifyConclusionAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalFSIConclusion1,mechanicalFSIConclusion2,mechanicalFSIConclusion3);
		//Electrical
		//Add a component
		addSRIComponentInAdmin(driver,1,electricalComponent1);
		//Add a measurement
		addSRIMeasurementInAdmin(driver,1,electricalComponent1,electricalMeasurement1);
		//Add a unit
		addSRIUnitInAdmin(driver,electricalMeasurement1,electricalUnit1);
		//Add a baseline
		addSRIBaselineInAdmin(driver,1,electricalComponent1,electricalMeasurement1,electricalUnit1,electricalFSIBaseline1,electricalFSIBaseline2,electricalFSIBaseline3);
		//Add a conclusion
		addSRIConclusionInAdmin(driver,1,electricalComponent1,electricalMeasurement1,electricalFSIConclusion1,electricalFSIConclusion2,electricalFSIConclusion3);
		//Save
		saveChangedValues(driver);
		//Verify all added values
		verifyComponentAdded(driver,electricalComponent1,1);
		verifyMeasurementAdded(driver,electricalComponent1,electricalMeasurement1,1);
		verifyUnitAdded(driver,electricalMeasurement1,electricalUnit1);
		verifyBaselineAdded(driver,1,electricalComponent1,electricalMeasurement1,electricalUnit1,electricalFSIBaseline1,electricalFSIBaseline2,electricalFSIBaseline3);
		verifyConclusionAdded(driver,1,electricalComponent1,electricalMeasurement1,electricalFSIConclusion1,electricalFSIConclusion2,electricalFSIConclusion3);
		//bug needs to be fixed
		login.logout(driver);
		driver.switchTo().defaultContent();
		login.LoginUser(driver, username, password);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Get to SRI Admin part
		getToSRIAdmin(driver);
		//Delete all mechanical
		deleteConclusionAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1);
		deleteBaselineAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalUnit1);
		deleteUnitAdded(driver,mechanicalMeasurement1,mechanicalUnit1);
		deleteMeasurementAdded(driver,mechanicalComponent1,mechanicalMeasurement1,0);
		deleteComponentAdded(driver,mechanicalComponent1,0);
		//Save
		saveChangedValues(driver);
		//Delete all elecrical
		deleteConclusionAdded(driver,1,electricalComponent1,electricalMeasurement1);
		deleteBaselineAdded(driver,1,electricalComponent1,electricalMeasurement1,electricalUnit1);
		deleteUnitAdded(driver,electricalMeasurement1,electricalUnit1);
		deleteMeasurementAdded(driver,electricalComponent1,electricalMeasurement1,1);
		deleteComponentAdded(driver,electricalComponent1,1);
		//Save
		saveChangedValues(driver);
	}

	public int deleteComponentAdded(WebDriver driver, String component, int mechOrElec) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Click on SRI components tab mechanical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption)).click();
		}
		else
		{
			//Click on SRI components tab electrical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)).click();
		}
		//Count number of components
		int count=1;
		int deleted = 0;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]"));
				String componentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[2]/div/input"))).getAttribute("value");
				if(componentName.equals(component))
				{
					//delete measurement
					share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[4]/a"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[4]/a"))).click();
					//Delete confirm button
					wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
					//share2.loadingServer(driver);
					deleted = 1;
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		if(deleted == 1)
			return 1;
		else return 0;
	}

	public int deleteMeasurementAdded(WebDriver driver, String component, String measurement, int mechOrElec) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminMeasurementTabMechanicalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);		
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		else
		{
			//Select elecrtical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminMeasurementTabElectricalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		Thread.sleep(500);
		//Count number of measurements
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(measurementName.equals(measurement))
				{
					if(driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected())
					{
						//delete measurement
						share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[4]/a"))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[4]/a"))).click();
						//Delete confirm button
						wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
						//share2.loadingServer(driver);
					}
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		return 1;
	}

	public int deleteUnitAdded(WebDriver driver, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI units tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Select measurement
		try{
			WebElement element = driver.findElement(sri.SRIAdminUnitTabMeasurementDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(measurement);	
		}catch(org.openqa.selenium.NoSuchElementException r)
		{
			return 0;
		}
		Thread.sleep(500);
		//Count number of units
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(unitName.equals(unit))
				{
					if(driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected())
					{
						//delete unit
						share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[4]/a"))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[4]/a"))).click();
						//Delete confirm button
						wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
						//share2.loadingServer(driver);
					}
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		return 1;
	}

	public int deleteBaselineAdded(WebDriver driver, int mechOrElec, String component, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);	
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		else
		{
			//Select elecrtical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		Thread.sleep(500);
		//Delete all baselines under the component+measurement+unit combination
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]"));
				//Get unit name
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[3]/div/div/span"))).getText();
				//Get Measurement name
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				if(measurementName.equals(measurement))
				{
					if(unitName.equals(unit))
					{
						//delete baseline
						share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[7]/a"))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[7]/a"))).click();
						//Delete confirm button
						wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
						//share2.loadingServer(driver);
					}
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		return 1;
	}

	public int deleteConclusionAdded(WebDriver driver, int mechOrElec, String component, String measurement) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI conclusion tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		try{
			if(driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown).isDisplayed()==false)
			{
				//Click on SRI side link
				wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISideLink)).click();
				//Click on SRI conclusion tab
				wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
			}
		}catch(org.openqa.selenium.NoSuchElementException r)
		{
			//Click on SRI side link
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISideLink)).click();
			//Click on SRI conclusion tab
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		}
		Thread.sleep(500);
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);	
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		else
		{
			//Select elecrtical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminConclusionTabElectricalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		Thread.sleep(500);
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminConclusionTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		Thread.sleep(500);
		//Delete all conclusions under the component+measurement combination
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				if(measurementName.equals(measurement))
				{
					//delete conclusion
					share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[6]/a"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[6]/a"))).click();
					//Delete confirm button
					wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
					//share2.loadingServer(driver);
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		return 1;
	}

	public void verifyComponentAdded(WebDriver driver, String component, int mechOrElec) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> componentList = new ArrayList<String>();
		//Click on SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Click on SRI components tab mechanical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption)).click();
		}
		else
		{
			//Click on SRI components tab electrical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)).click();
		}
		//Count number of components
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]"));
				String componentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[2]/div/input"))).getAttribute("value");
				componentList.add(componentName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		//Go through all components to check if added component is present
		softly.assertThat(component).as("test data").isIn(componentList);
	}

	public void verifyMeasurementAdded(WebDriver driver, String component, String measurement, int mechOrElec) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> measurementList = new ArrayList<String>();
		//Click on SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select electrical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Count number of measurements
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				measurementList.add(measurementName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		//Go through all measurements to check if added component is present
		softly.assertThat(measurement).as("test data").isIn(measurementList);
		//Verify the checkmark on the measurement
		count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(measurementName.equals(measurement))
				{
					if(driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected()==false)
						softly.fail("Measurement: "+measurement+" not selected for component: "+component);
					else
						break;
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		
	}

	public void verifyUnitAdded(WebDriver driver, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> unitList = new ArrayList<String>();
		//Click on SRI units tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminUnitTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		//Count number of units
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				unitList.add(unitName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		//Go through all units to check if added component is present
		softly.assertThat(unit).as("test data").isIn(unitList);
		//Verify the checkmark on the measurement
		count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(unitName.equals(unit))
				{
					if(driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected()==false)
						softly.fail("Unit: "+unit+" not selected for measurement: "+measurement);
					else
						break;
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}

	}

	public void verifyBaselineAdded(WebDriver driver, int mechOrElec, String component, String measurement, String unit, String fs1, String fs2, String fs3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> unitList = new ArrayList<String>();
		List<String> measurementList = new ArrayList<String>();
		//Click on SRI baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Count number of baselines
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]"));
				//Get unit name
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[3]/div/div/span"))).getText();
				unitList.add(unitName);
				//Get Measurement name
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				measurementList.add(measurementName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		//Go through all measurements and units to check if added component is present
		softly.assertThat(unit).as("test data").isIn(unitList);
		softly.assertThat(measurement).as("test data").isIn(measurementList);
		//Get the index of the baseline which matches both measurement and unit
		int index = 0;
		for (int i=0;i<unitList.size();i++)
		{
			if(unitList.get(i).equals(unit))
				if(measurementList.get(i).equals(measurement))
				{
					index = i+1;
					break;
				}
		}
		String fs1Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+index+"]/td[4]/div/input"))).getAttribute("value");
		String fs2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+index+"]/td[5]/div/input"))).getAttribute("value");
		String fs3Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+index+"]/td[6]/div/input"))).getAttribute("value");
		softly.assertThat(fs1Value).as("test data").isEqualTo(fs1);
		softly.assertThat(fs2Value).as("test data").isEqualTo(fs2);
		softly.assertThat(fs3Value).as("test data").isEqualTo(fs3);
	}

	public void verifyConclusionAdded(WebDriver driver, int mechOrElec, String component, String measurement, String fs1, String fs2, String fs3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> measurementList = new ArrayList<String>();
		//Click on SRI conclusion tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Count number of conclusions
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]"));
				//Get Measurement name
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				measurementList.add(measurementName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
		//Go through all measurements to check if added measurement is present
		softly.assertThat(measurement).as("test data").isIn(measurementList);
		//Get the index of the conclusion which matches measurement
		int index = measurementList.indexOf(measurement)+1;
		//Verify conclusions
		String fs1Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+index+"]/td[3]/textarea"))).getAttribute("value");
		String fs2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+index+"]/td[4]/textarea"))).getAttribute("value");
		String fs3Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+index+"]/td[5]/textarea"))).getAttribute("value");
		softly.assertThat(fs1Value).as("test data").isEqualTo(fs1);
		softly.assertThat(fs2Value).as("test data").isEqualTo(fs2);
		softly.assertThat(fs3Value).as("test data").isEqualTo(fs3);
	}

	public void getToSRIAdmin(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.LoginNameOnTop)).click();
		//Click on Admin
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.AdminOption)).click();
		//Click on Analysis
		if(driver.findElement(sri.SRISideLink).isDisplayed()==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.AnalysisSideLink)).click();
		//Click on SRI
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISideLink)).click();
		share2.loadingServer(driver);
	}

	public void saveChangedValues(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminSaveButton)).click();
		//Click on save button on popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
		share2.loadingServer(driver);
	}

	public void addSRIComponentInAdmin(WebDriver driver, int mechOrElec, String component) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Click on SRI components tab mechanical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption)).click();
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(component);
		}
		else
		{
			//Click on SRI components tab electrical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)).click();
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(component);
		}
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentAddButton)).click();		
	}

	public void addSRIMeasurementInAdmin(WebDriver driver, int mechOrElec, String component, String measurement) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(measurement);
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(measurement);
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementAddButton)).click();	
		//Select added measurement
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(measurementName.equals(measurement))
				{
					share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input"))).click();
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
	}

	public void addSRIUnitInAdmin(WebDriver driver, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI units tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Enter unit
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(unit);
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminUnitTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);				
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitAddButton)).click();		
		//Select added unit
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(unitName.equals(unit))
				{
					share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input"))).click();
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+1;
		}
	}

	public void addSRIBaselineInAdmin(WebDriver driver, int mechOrElec, String component, String measurement, String unit, String fs1, String fs2, String fs3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI baselines tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		//Select unit
		WebElement element1 = driver.findElement(sri.SRIAdminBaselineTabUnitDropdown);
		Select s1 = new Select (element1);
		s1.selectByVisibleText(unit);	
		//Enter FS1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS1Field)).sendKeys(fs1);
		//Enter FS2
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS2Field)).sendKeys(fs2);
		//Enter FS3
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS3Field)).sendKeys(fs3);
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineAddButton)).click();		
	}

	public void addSRIConclusionInAdmin(WebDriver driver, int mechOrElec, String component, String measurement, String fs1Conclusion, String fs2Conclusion, String fs3Conclusion) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on SRI conclusion tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminConclusionTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		//Enter FS1 Conclusion
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS1ConclusionField)).sendKeys(fs1Conclusion);
		//Enter FS2 Conclusion
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS2ConclusionField)).sendKeys(fs2Conclusion);
		//Enter FS3 Conclusion
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS3ConclusionField)).sendKeys(fs3Conclusion);
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionAddButton)).click();		
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}