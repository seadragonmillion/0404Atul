Feature: Automated Case Search Sanity

@PreventionDesignDeficienciesChromeTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets prevention of design deficiencies link
	And checks with keyword with percentage for "PDD" in "dev"
	And checks with new keyword with period and slash for "PDD" in "dev"
	And verify all search options for "PDD" in "dev"
	And keyword search for "PDD" in "dev"
	And case id search for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And search for case in equipment non pii by case id for "PDD" in "dev"
	And add new keyword to old case only in dev in "PDD"
	And logout from KALE

@PreventionDesignDeficienciesFirefoxTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets prevention of design deficiencies link
	And checks with keyword with percentage for "PDD" in "dev"
	And checks with new keyword with period and slash for "PDD" in "dev"
	And verify all search options for "PDD" in "dev"
	And keyword search for "PDD" in "dev"
	And case id search for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And search for case in equipment non pii by case id for "PDD" in "dev"
	And add new keyword to old case only in dev in "PDD"
	And logout from KALE

@PreventionDesignDeficienciesIE10Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets prevention of design deficiencies link
	And checks with keyword with percentage for "PDD" in "dev"
	And checks with new keyword with period and slash for "PDD" in "dev"
	And verify all search options for "PDD" in "dev"
	And keyword search for "PDD" in "dev"
	And case id search for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And search for case in equipment non pii by case id for "PDD" in "dev"
	And add new keyword to old case only in dev in "PDD"
	And logout from KALE

@PreventionDesignDeficienciesIE11Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets prevention of design deficiencies link
	And checks with keyword with percentage for "PDD" in "dev"
	And checks with new keyword with period and slash for "PDD" in "dev"
	And verify all search options for "PDD" in "dev"
	And keyword search for "PDD" in "dev"
	And case id search for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And search for case in equipment non pii by case id for "PDD" in "dev"
	And add new keyword to old case only in dev in "PDD"
	And logout from KALE
	
@PreventionDesignDeficienciesAsiaChromeTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesAsiaFirefoxTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesAsiaIE10Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesAsiaIE11Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesUSAChromeTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE

@PreventionDesignDeficienciesUSAFirefoxTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE

@PreventionDesignDeficienciesUSAIE10Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE

@PreventionDesignDeficienciesUSAIE11Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search for "PDD" in "prod"
	And case id search for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And search for case in equipment non pii by case id for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesNonAdminChromeTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "dev"
	And keyword search nonadmin user for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And logout from KALE

@PreventionDesignDeficienciesNonAdminFirefoxTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "dev"
	And keyword search nonadmin user for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And logout from KALE

@PreventionDesignDeficienciesNonAdminIE10Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "dev"
	And keyword search nonadmin user for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And logout from KALE

@PreventionDesignDeficienciesNonAdminIE11Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "dev"
	And keyword search nonadmin user for "PDD" in "dev"
	And search for case in equipment non pii by keyword for "PDD" in "dev"
	And logout from KALE
			
@PreventionDesignDeficienciesNonAdminAsiaChromeTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesNonAdminAsiaFirefoxTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesNonAdminAsiaIE10Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesNonAdminAsiaIE11Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE
	
@PreventionDesignDeficienciesNonAdminUSAChromeTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE

@PreventionDesignDeficienciesNonAdminUSAFirefoxTest
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE

@PreventionDesignDeficienciesNonAdminUSAIE10Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE

@PreventionDesignDeficienciesNonAdminUSAIE11Test
Scenario: Test prevention of design deficiencies case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets prevention of design deficiencies link
	And verify all search options for "PDD" in "prod"
	And keyword search nonadmin user for "PDD" in "prod"
	And search for case in equipment non pii by keyword for "PDD" in "prod"
	And logout from KALE
	