Feature: Automated EiRCA version two Test
	
@ChromeTest
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an EiRCA report to test all steps in version two with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And logout from KALE

@FirefoxTest
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an EiRCA report to test all steps in version two with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And logout from KALE

@IE10Test
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an EiRCA report to test all steps in version two with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And logout from KALE

@IE11Test
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an EiRCA report to test all steps in version two with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an EiRCA report to test all steps in version two with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an EiRCA report to test all steps in version two with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an EiRCA report to test all steps in version two with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an EiRCA report to test all steps in version two with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And logout from KALE
	
@USAChromeTest
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an EiRCA report to test all steps in version two with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And logout from KALE

@USAFirefoxTest
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an EiRCA report to test all steps in version two with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And logout from KALE

@USAIE10Test
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an EiRCA report to test all steps in version two with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And logout from KALE

@USAIE11Test
Scenario: Test EiRCA new module
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an EiRCA report to test all steps in version two with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And logout from KALE