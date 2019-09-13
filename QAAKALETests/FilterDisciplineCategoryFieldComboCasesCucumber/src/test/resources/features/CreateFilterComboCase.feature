Feature: Automated create equipment cases with all filter combinations functional test

@ChromeTest
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she deletes previous cases for combo filters discipline field category in "devAsia"
	And create cases for combo filters discipline field category in "devAsia"
	And logout from KALE

@FirefoxTest
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she deletes previous cases for combo filters discipline field category in "devAsia"
	And create cases for combo filters discipline field category in "devAsia"
	And logout from KALE

@IE10Test
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she deletes previous cases for combo filters discipline field category in "devAsia"
	And create cases for combo filters discipline field category in "devAsia"
	And logout from KALE

@IE11Test
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she deletes previous cases for combo filters discipline field category in "devAsiaIE11"
	And create cases for combo filters discipline field category in "devAsiaIE11"
	And logout from KALE
			
@AsiaChromeTest
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she deletes previous cases for combo filters discipline field category in "devAsia"
	And create cases for combo filters discipline field category in "devAsia"
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she deletes previous cases for combo filters discipline field category in "devAsia"
	And create cases for combo filters discipline field category in "devAsia"
	And logout from KALE
	
@AsiaIE10Test
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she deletes previous cases for combo filters discipline field category in "devAsia"
	And create cases for combo filters discipline field category in "devAsia"
	And logout from KALE
	
@AsiaIE11Test
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she deletes previous cases for combo filters discipline field category in "devAsiaIE11"
	And create cases for combo filters discipline field category in "devAsiaIE11"
	And logout from KALE
	
@USAChromeTest
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she deletes previous cases for combo filters discipline field category in "US"
	And create cases for combo filters discipline field category in "US"
	And logout from KALE

@USAFirefoxTest
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she deletes previous cases for combo filters discipline field category in "US"
	And create cases for combo filters discipline field category in "US"
	And logout from KALE

@USAIE10Test
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she deletes previous cases for combo filters discipline field category in "US"
	And create cases for combo filters discipline field category in "US"
	And logout from KALE

@USAIE11Test
Scenario: Create equipment cases with all filter combinations
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she deletes previous cases for combo filters discipline field category in "USIE11"
	And create cases for combo filters discipline field category in "USIE11"
	And logout from KALE
	