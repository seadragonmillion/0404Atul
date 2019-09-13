Feature: Automated create SRI cases functional test

@ChromeTest
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she create cases for SRI in "devAsia"
	And logout from KALE

@FirefoxTest
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she create cases for SRI in "devAsia"
	And logout from KALE

@IE10Test
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she create cases for SRI in "devAsia"
	And logout from KALE

@IE11Test
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she create cases for SRI in "devAsiaIE11"
	And logout from KALE
			
@AsiaChromeTest
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she create cases for SRI in "devAsia"
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she create cases for SRI in "devAsia"
	And logout from KALE
	
@AsiaIE10Test
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she create cases for SRI in "devAsia"
	And logout from KALE
	
@AsiaIE11Test
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she create cases for SRI in "devAsiaIE11"
	And logout from KALE
	
@USAChromeTest
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she create cases for SRI in "US"
	And logout from KALE

@USAFirefoxTest
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she create cases for SRI in "US"
	And logout from KALE

@USAIE10Test
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she create cases for SRI in "US"
	And logout from KALE

@USAIE11Test
Scenario: Create SRI cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she create cases for SRI in "USIE11"
	And logout from KALE
	