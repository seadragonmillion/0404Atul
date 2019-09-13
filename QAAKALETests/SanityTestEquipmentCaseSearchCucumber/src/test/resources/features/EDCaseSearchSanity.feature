Feature: Automated Case Search Sanity

@EquipmentDatabankChromeTest
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And case search with filter
	And logout from KALE

@EquipmentDatabankFirefoxTest
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And case search with filter
	And logout from KALE

@EquipmentDatabankIE10Test
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And case search with filter
	And logout from KALE

@EquipmentDatabankIE11Test
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "dev"
	And checks with keyword with percentage for "EQ" in "dev"
	And checks with new keyword with period and slash for "EQ" in "dev"
	And keyword search for "EQ" in "dev"
	And case id search for "EQ" in "dev"
	And case search with filter
	And logout from KALE
			
@EquipmentDatabankAsiaChromeTest
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And case search with filter
	And logout from KALE
	
@EquipmentDatabankAsiaFirefoxTest
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And logout from KALE
	
@EquipmentDatabankAsiaIE10Test
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And logout from KALE
	
@EquipmentDatabankAsiaIE11Test
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And logout from KALE
	
@EquipmentDatabankUSAChromeTest
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And logout from KALE

@EquipmentDatabankUSAFirefoxTest
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And case search with filter
	And logout from KALE

@EquipmentDatabankUSAIE10Test
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And case search with filter
	And logout from KALE

@EquipmentDatabankUSAIE11Test
Scenario: Test equipment databank case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets equipment databank link with admin nonadmin as 0
	And verify all search options for "EQ" in "prod"
	And keyword search for "EQ" in "prod"
	And case id search for "EQ" in "prod"
	And case search with filter
	And logout from KALE
	