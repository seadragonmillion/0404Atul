Feature: Automated Case Search Sanity

@EquipmentPerformanceChromeTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And search with keyword color oil
	And add new keyword to old case only in dev in "EQ"
	And logout from KALE

@EquipmentPerformanceFirefoxTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And search with keyword color oil
	And add new keyword to old case only in dev in "EQ"
	And logout from KALE

@EquipmentPerformanceIE10Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And search with keyword color oil
	And add new keyword to old case only in dev in "EQ"
	And logout from KALE

@EquipmentPerformanceIE11Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And search with keyword color oil
	And add new keyword to old case only in dev in "EQ"
	And logout from KALE
			
@EquipmentPerformanceAsiaChromeTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceAsiaFirefoxTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceAsiaIE10Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceAsiaIE11Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceUSAChromeTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceUSAFirefoxTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceUSAIE10Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceUSAIE11Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets equipment performance link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceNonAdminChromeTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search nonadmin user for "EQ" in "dev"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceNonAdminFirefoxTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search nonadmin user for "EQ" in "dev"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceNonAdminIE10Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search nonadmin user for "EQ" in "dev"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceNonAdminIE11Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search nonadmin user for "EQ" in "dev"
	And search with keyword color oil
	And logout from KALE
			
@EquipmentPerformanceNonAdminAsiaChromeTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceNonAdminAsiaFirefoxTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceNonAdminAsiaIE10Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceNonAdminAsiaIE11Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
@EquipmentPerformanceNonAdminUSAChromeTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceNonAdminUSAFirefoxTest
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceNonAdminUSAIE10Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE

@EquipmentPerformanceNonAdminUSAIE11Test
Scenario: Test equipment performance case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets equipment performance link with admin nonadmin as 1
	And verify all search options for "EQ" in "prod"
	And keyword search nonadmin user for "EQ" in "prod"
	And search with keyword color oil
	And logout from KALE
	
