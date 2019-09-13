Feature: Automated Case Search Sanity

@EngineeringFundamentalsChromeTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets engineering fundamentals link
	And checks with keyword with percentage for "EF" in "dev"
	And checks with new keyword with period and slash for "EF" in "dev"
	And verify all search options for "EF" in "dev"
	And keyword search for "EF" in "dev"
	And case id search for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And search for case in equipment non pii by case id for "EF" in "dev"
	And add new keyword to old case only in dev in "EF"
	And logout from KALE

@EngineeringFundamentalsFirefoxTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets engineering fundamentals link
	And checks with keyword with percentage for "EF" in "dev"
	And checks with new keyword with period and slash for "EF" in "dev"
	And verify all search options for "EF" in "dev"
	And keyword search for "EF" in "dev"
	And case id search for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And search for case in equipment non pii by case id for "EF" in "dev"
	And add new keyword to old case only in dev in "EF"
	And logout from KALE

@EngineeringFundamentalsIE10Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets engineering fundamentals link
	And checks with keyword with percentage for "EF" in "dev"
	And checks with new keyword with period and slash for "EF" in "dev"
	And verify all search options for "EF" in "dev"
	And keyword search for "EF" in "dev"
	And case id search for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And search for case in equipment non pii by case id for "EF" in "dev"
	And add new keyword to old case only in dev in "EF"
	And logout from KALE

@EngineeringFundamentalsIE11Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets engineering fundamentals link
	And checks with keyword with percentage for "EF" in "dev"
	And checks with new keyword with period and slash for "EF" in "dev"
	And verify all search options for "EF" in "dev"
	And keyword search for "EF" in "dev"
	And case id search for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And search for case in equipment non pii by case id for "EF" in "dev"
	And add new keyword to old case only in dev in "EF"
	And logout from KALE
	
@EngineeringFundamentalsAsiaChromeTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsAsiaFirefoxTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsAsiaIE10Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsAsiaIE11Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsUSAChromeTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE

@EngineeringFundamentalsUSAFirefoxTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE

@EngineeringFundamentalsUSAIE10Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE

@EngineeringFundamentalsUSAIE11Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search for "EF" in "prod"
	And case id search for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And search for case in equipment non pii by case id for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsNonAdminChromeTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "dev"
	And keyword search nonadmin user for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And logout from KALE

@EngineeringFundamentalsNonAdminFirefoxTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "dev"
	And keyword search nonadmin user for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And logout from KALE

@EngineeringFundamentalsNonAdminIE10Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "dev"
	And keyword search nonadmin user for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And logout from KALE

@EngineeringFundamentalsNonAdminIE11Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "dev"
	And keyword search nonadmin user for "EF" in "dev"
	And search for case in equipment non pii by keyword for "EF" in "dev"
	And logout from KALE
			
@EngineeringFundamentalsNonAdminAsiaChromeTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsNonAdminAsiaFirefoxTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsNonAdminAsiaIE10Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsNonAdminAsiaIE11Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE
	
@EngineeringFundamentalsNonAdminUSAChromeTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE

@EngineeringFundamentalsNonAdminUSAFirefoxTest
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE

@EngineeringFundamentalsNonAdminUSAIE10Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE

@EngineeringFundamentalsNonAdminUSAIE11Test
Scenario: Test engineering fundamentals case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets engineering fundamentals link
	And verify all search options for "EF" in "prod"
	And keyword search nonadmin user for "EF" in "prod"
	And search for case in equipment non pii by keyword for "EF" in "prod"
	And logout from KALE
	