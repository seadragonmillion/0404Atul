Feature: Automated Case Search Sanity

@FailureModeChromeTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search for "FM" in "dev"
	And case id search for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeFirefoxTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search for "FM" in "dev"
	And case id search for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeIE10Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search for "FM" in "dev"
	And case id search for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeIE11Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search for "FM" in "dev"
	And case id search for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
			
@FailureModeAsiaChromeTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeAsiaFirefoxTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeAsiaIE10Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeAsiaIE11Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeUSAChromeTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeUSAFirefoxTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeUSAIE10Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeUSAIE11Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets failure mode link with admin nonadmin as 0
	And verify all search options for "FM" in "prod"
	And keyword search for "FM" in "prod"
	And case id search for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeNonAdminChromeTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search nonadmin user for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeNonAdminFirefoxTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search nonadmin user for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeNonAdminIE10Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search nonadmin user for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeNonAdminIE11Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "dev"
	And checks with keyword with percentage for "FM" in "dev"
	And checks with new keyword with period and slash for "FM" in "dev"
	And keyword search nonadmin user for "FM" in "dev"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
			
@FailureModeNonAdminAsiaChromeTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeNonAdminAsiaFirefoxTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeNonAdminAsiaIE10Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeNonAdminAsiaIE11Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
@FailureModeNonAdminUSAChromeTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeNonAdminUSAFirefoxTest
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeNonAdminUSAIE10Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE

@FailureModeNonAdminUSAIE11Test
Scenario: Test failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets failure mode link with admin nonadmin as 1
	And verify all search options for "FM" in "prod"
	And keyword search nonadmin user for "FM" in "prod"
	And select discipline and verify change in number of cases displayed
	And logout from KALE
	
