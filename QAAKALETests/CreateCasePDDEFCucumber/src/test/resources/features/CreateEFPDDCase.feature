Feature: Automated create PDD  and EF cases functional test

@ChromeTest
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she deletes previous cases for "PDD" in "devAsia"
	When she deletes previous cases for "EF" in "devAsia"
	And create cases for "PDD" in "devAsia"
	And create cases for "EF" in "devAsia"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsia"
	And go to equipment databank link
	And browse for case for "EF" in "devAsia"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsia"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsia"
	And search for case in equipment performance by keyword for "PDD" in "devAsia"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsia"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsia"
	And search for PDD and EF case in each other in "devAsia"
	And check the keyword search for "PDD" in "devAsia" for pii indicator 2
	And check the keyword search for "EF" in "devAsia" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE

@FirefoxTest
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she deletes previous cases for "PDD" in "devAsia"
	When she deletes previous cases for "EF" in "devAsia"
	And create cases for "PDD" in "devAsia"
	And create cases for "EF" in "devAsia"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsia"
	And go to equipment databank link
	And browse for case for "EF" in "devAsia"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsia"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsia"
	And search for case in equipment performance by keyword for "PDD" in "devAsia"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsia"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsia"
	And search for PDD and EF case in each other in "devAsia"
	And check the keyword search for "PDD" in "devAsia" for pii indicator 2
	And check the keyword search for "EF" in "devAsia" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE

@IE10Test
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she deletes previous cases for "PDD" in "devAsia"
	When she deletes previous cases for "EF" in "devAsia"
	And create cases for "PDD" in "devAsia"
	And create cases for "EF" in "devAsia"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsia"
	And go to equipment databank link
	And browse for case for "EF" in "devAsia"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsia"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsia"
	And search for case in equipment performance by keyword for "PDD" in "devAsia"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsia"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsia"
	And search for PDD and EF case in each other in "devAsia"
	And check the keyword search for "PDD" in "devAsia" for pii indicator 2
	And check the keyword search for "EF" in "devAsia" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE

@IE11Test
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she deletes previous cases for "PDD" in "devAsiaIE11"
	When she deletes previous cases for "EF" in "devAsiaIE11"
	And create cases for "PDD" in "devAsiaIE11"
	And create cases for "EF" in "devAsiaIE11"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsiaIE11"
	And go to equipment databank link
	And browse for case for "EF" in "devAsiaIE11"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsiaIE11"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsiaIE11"
	And search for case in equipment performance by keyword for "PDD" in "devAsiaIE11"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsiaIE11"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsiaIE11"
	And search for PDD and EF case in each other in "devAsiaIE11"
	And check the keyword search for "PDD" in "devAsiaIE11" for pii indicator 2
	And check the keyword search for "EF" in "devAsiaIE11" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE
			
@AsiaChromeTest
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
    When she deletes previous cases for "PDD" in "devAsia"
	When she deletes previous cases for "EF" in "devAsia"
	And create cases for "PDD" in "devAsia"
	And create cases for "EF" in "devAsia"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsia"
	And go to equipment databank link
	And browse for case for "EF" in "devAsia"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsia"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsia"
	And search for case in equipment performance by keyword for "PDD" in "devAsia"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsia"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsia"
	And search for PDD and EF case in each other in "devAsia"
	And check the keyword search for "PDD" in "devAsia" for pii indicator 2
	And check the keyword search for "EF" in "devAsia" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
    When she deletes previous cases for "PDD" in "devAsia"
	When she deletes previous cases for "EF" in "devAsia"
	And create cases for "PDD" in "devAsia"
	And create cases for "EF" in "devAsia"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsia"
	And go to equipment databank link
	And browse for case for "EF" in "devAsia"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsia"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsia"
	And search for case in equipment performance by keyword for "PDD" in "devAsia"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsia"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsia"
	And search for PDD and EF case in each other in "devAsia"
	And check the keyword search for "PDD" in "devAsia" for pii indicator 2
	And check the keyword search for "EF" in "devAsia" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE
	
@AsiaIE10Test
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
    When she deletes previous cases for "PDD" in "devAsia"
	When she deletes previous cases for "EF" in "devAsia"
	And create cases for "PDD" in "devAsia"
	And create cases for "EF" in "devAsia"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsia"
	And go to equipment databank link
	And browse for case for "EF" in "devAsia"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsia"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsia"
	And search for case in equipment performance by keyword for "PDD" in "devAsia"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsia"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsia"
	And search for PDD and EF case in each other in "devAsia"
	And check the keyword search for "PDD" in "devAsia" for pii indicator 2
	And check the keyword search for "EF" in "devAsia" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE
	
@AsiaIE11Test
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
    When she deletes previous cases for "PDD" in "devAsiaIE11"
	When she deletes previous cases for "EF" in "devAsiaIE11"
	And create cases for "PDD" in "devAsiaIE11"
	And create cases for "EF" in "devAsiaIE11"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "devAsiaIE11"
	And go to equipment databank link
	And browse for case for "EF" in "devAsiaIE11"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "devAsiaIE11"
	And go to engineering fundamentals link
	And browse for case for "EF" in "devAsiaIE11"
	And search for case in equipment performance by keyword for "PDD" in "devAsiaIE11"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "devAsiaIE11"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "devAsiaIE11"
	And search for PDD and EF case in each other in "devAsiaIE11"
	And check the keyword search for "PDD" in "devAsiaIE11" for pii indicator 2
	And check the keyword search for "EF" in "devAsiaIE11" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE
	
@USAChromeTest
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she deletes previous cases for "PDD" in "US"
	When she deletes previous cases for "EF" in "US"
	And create cases for "PDD" in "US"
	And create cases for "EF" in "US"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "US"
	And go to equipment databank link
	And browse for case for "EF" in "US"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "US"
	And go to engineering fundamentals link
	And browse for case for "EF" in "US"
	And search for case in equipment performance by keyword for "PDD" in "US"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "US"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "US"
	And search for PDD and EF case in each other in "US"
	And check the keyword search for "PDD" in "US" for pii indicator 2
	And check the keyword search for "EF" in "US" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE

@USAFirefoxTest
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she deletes previous cases for "PDD" in "US"
	When she deletes previous cases for "EF" in "US"
	And create cases for "PDD" in "US"
	And create cases for "EF" in "US"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "US"
	And go to equipment databank link
	And browse for case for "EF" in "US"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "US"
	And go to engineering fundamentals link
	And browse for case for "EF" in "US"
	And search for case in equipment performance by keyword for "PDD" in "US"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "US"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "US"
	And search for PDD and EF case in each other in "US"
	And check the keyword search for "PDD" in "US" for pii indicator 2
	And check the keyword search for "EF" in "US" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE

@USAIE10Test
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she deletes previous cases for "PDD" in "US"
	When she deletes previous cases for "EF" in "US"
	And create cases for "PDD" in "US"
	And create cases for "EF" in "US"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "US"
	And go to equipment databank link
	And browse for case for "EF" in "US"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "US"
	And go to engineering fundamentals link
	And browse for case for "EF" in "US"
	And search for case in equipment performance by keyword for "PDD" in "US"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "US"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "US"
	And search for PDD and EF case in each other in "US"
	And check the keyword search for "PDD" in "US" for pii indicator 2
	And check the keyword search for "EF" in "US" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE

@USAIE11Test
Scenario: Create PDD  and EF cases 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she deletes previoUSIE11 cases for "PDD" in "USIE11"
	When she deletes previoUSIE11 cases for "EF" in "USIE11"
	And create cases for "PDD" in "USIE11"
	And create cases for "EF" in "USIE11"	
	And verify if names of case modules correct
	And go to equipment databank link
	And browse for case for "PDD" in "USIE11"
	And go to equipment databank link
	And browse for case for "EF" in "USIE11"
	And go to prevention of design deficiencies link
	And browse for case for "PDD" in "USIE11"
	And go to engineering fundamentals link
	And browse for case for "EF" in "USIE11"
	And search for case in equipment performance by keyword for "PDD" in "USIE11"
	And search for case in equipment performance by case id for "PDD"
	And search for case in equipment performance by keyword for "EF" in "USIE11"
	And search for case in equipment performance by case id for "EF"
	And search for PDD and EF case in failure modes in "USIE11"
	And search for PDD and EF case in each other in "USIE11"
	And check the keyword search for "PDD" in "USIE11" for pii indicator 2
	And check the keyword search for "EF" in "USIE11" for pii indicator 2
	And delete cases for "PDD"
	And delete cases for "EF"
	And logout from KALE
	