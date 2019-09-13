Feature: Automated Case Search Sanity

@MechanicalFailureModeChromeTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search for "MFM" in "dev"
	And case id search for "MFM" in "dev"
	And add new keyword to old case only in dev in "MFM"
	And logout from KALE

@MechanicalFailureModeFirefoxTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search for "MFM" in "dev"
	And case id search for "MFM" in "dev"
	And add new keyword to old case only in dev in "MFM"
	And logout from KALE

@MechanicalFailureModeIE10Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search for "MFM" in "dev"
	And case id search for "MFM" in "dev"
	And add new keyword to old case only in dev in "MFM"
	And logout from KALE

@MechanicalFailureModeIE11Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search for "MFM" in "dev"
	And case id search for "MFM" in "dev"
	And add new keyword to old case only in dev in "MFM"
	And logout from KALE
			
@MechanicalFailureModeAsiaChromeTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeAsiaFirefoxTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeAsiaIE10Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeAsiaIE11Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeUSAChromeTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE

@MechanicalFailureModeUSAFirefoxTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE

@MechanicalFailureModeUSAIE10Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE

@MechanicalFailureModeUSAIE11Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets mechanical failure mode link with admin nonadmin as 0
	And verify all search options for "MFM" in "prod"
	And keyword search for "MFM" in "prod"
	And case id search for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeNonAdminChromeTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search nonadmin user for "MFM" in "dev"
	And logout from KALE

@MechanicalFailureModeNonAdminFirefoxTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search nonadmin user for "MFM" in "dev"
	And logout from KALE

@MechanicalFailureModeNonAdminIE10Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search nonadmin user for "MFM" in "dev"
	And logout from KALE

@MechanicalFailureModeNonAdminIE11Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "dev"
	And checks with keyword with percentage for "MFM" in "dev"
	And checks with new keyword with period and slash for "MFM" in "dev"
	And keyword search nonadmin user for "MFM" in "dev"
	And logout from KALE
			
@MechanicalFailureModeNonAdminAsiaChromeTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeNonAdminAsiaFirefoxTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeNonAdminAsiaIE10Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeNonAdminAsiaIE11Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE
	
@MechanicalFailureModeNonAdminUSAChromeTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE

@MechanicalFailureModeNonAdminUSAFirefoxTest
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE

@MechanicalFailureModeNonAdminUSAIE10Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE

@MechanicalFailureModeNonAdminUSAIE11Test
Scenario: Test mechanical failure mode case search
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When user gets mechanical failure mode link with admin nonadmin as 1
	And verify all search options for "MFM" in "prod"
	And keyword search nonadmin user for "MFM" in "prod"
	And logout from KALE
	
