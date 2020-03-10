Feature: Automated EiRCA Bugs test
	
@ChromeTest
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE

@FirefoxTest
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE

@IE10Test
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE

@IE11Test
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE
	
@USAChromeTest
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE

@USAFirefoxTest
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE

@USAIE10Test
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE

@USAIE11Test
Scenario: Test EiRCA Bugs in new version
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an EiRCA report to test all bugs in new version
	And logout from KALE