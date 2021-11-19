Feature: Automated Case Search Sanity

@ChromeTest
Scenario: Test human performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets human performance link with admin nonadmin as 0
	And verify all search options in "dev"
	And checks with keyword with percentage in "dev"
	And checks with new keyword with period and slash  in "dev"
	And keyword search in "dev"
	And case id search in "dev"
	And search with keyword color oil
	And logout from KALE

#@FirefoxTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And case id search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#
#@IE10Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And case id search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#
#@IE11Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And case id search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#			
#@AsiaChromeTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@AsiaFirefoxTest
#Scenario: Test human performance case search
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@AsiaIE10Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@AsiaIE11Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@USAChromeTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#
#@USAFirefoxTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#
#@USAIE10Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#
#@USAIE11Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When user gets human performance link with admin nonadmin as 0
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And case id search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@NonAdminChromeTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#
#@NonAdminFirefoxTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#
#@NonAdminIE10Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#
#@NonAdminIE11Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "dev"
#	And checks with keyword with percentage in "dev"
#	And checks with new keyword with period and slash  in "dev"
#	And keyword search in "dev"
#	And search with keyword color oil
#	And logout from KALE
#			
#@NonAdminAsiaChromeTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@NonAdminAsiaFirefoxTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@NonAdminAsiaIE10Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@NonAdminAsiaIE11Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
#@NonAdminUSAChromeTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#
#@NonAdminUSAFirefoxTest
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#
#@NonAdminUSAIE10Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#
#@NonAdminUSAIE11Test
#Scenario: Test human performance case search
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When user gets human performance link with admin nonadmin as 1
#	And verify all search options in "prod"
#	And checks with keyword with percentage in "prod"
#	And keyword search in "prod"
#	And search with keyword color oil
#	And logout from KALE
#	
