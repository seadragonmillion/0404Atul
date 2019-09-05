Feature: Automated HPI Sanity

@ChromeTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an HPI report with username as "jenkinsvm"
	And share HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete HPI report with admin nonadmin environment indicator equals 0
	And logout from KALE

@FirefoxTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When he creates an HPI report with username as "jenkinsvm"
	And share HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete HPI report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE10Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When he creates an HPI report with username as "jenkinsvm"
	And share HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete HPI report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE11Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When he creates an HPI report with username as "jenkinsvm_ie11"
	And share HPI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical HPI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete HPI report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When he creates an HPI report with username as "ritica"
	And share HPI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical HPI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete HPI report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When he creates an HPI report with username as "ritica"
	And share HPI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical HPI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete HPI report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When he creates an HPI report with username as "ritica"
	And share HPI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical HPI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete HPI report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When he creates an HPI report with username as "ritica_ie11"
	And share HPI report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical HPI report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete HPI report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@USAChromeTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an HPI report with username as "jenkinsvm"
	And share HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete HPI report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAFirefoxTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When he creates an HPI report with username as "jenkinsvm"
	And share HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete HPI report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE10Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When he creates an HPI report with username as "jenkinsvm"
	And share HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical HPI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete HPI report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE11Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When he creates an HPI report with username as "jenkinsvm_ie11"
	And share HPI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical HPI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete HPI report with admin nonadmin environment indicator equals 6
	And logout from KALE
	
@NonAdminChromeTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an HPI report with username as "jenkinsvmnonadmin"
	And share HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete HPI report with admin nonadmin environment indicator equals 1
	And logout from KALE

@NonAdminFirefoxTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When he creates an HPI report with username as "jenkinsvmnonadmin"
	And share HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete HPI report with admin nonadmin environment indicator equals 1
	And logout from KALE

@NonAdminIE10Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When he creates an HPI report with username as "jenkinsvmnonadmin"
	And share HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete HPI report with admin nonadmin environment indicator equals 1
	And logout from KALE

@NonAdminIE11Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When he creates an HPI report with username as "virtualnonadmin_ie11"
	And share HPI report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And mark critical HPI report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And delete HPI report with admin nonadmin environment indicator equals 3
	And logout from KALE
			
@NonAdminAsiaChromeTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When he creates an HPI report with username as "qaacfi"
	And share HPI report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical HPI report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete HPI report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@NonAdminAsiaFirefoxTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When he creates an HPI report with username as "qaacfi"
	And share HPI report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical HPI report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete HPI report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@NonAdminAsiaIE10Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When he creates an HPI report with username as "qaacfi"
	And share HPI report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical HPI report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete HPI report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@NonAdminAsiaIE11Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When he creates an HPI report with username as "qaa_ie11"
	And share HPI report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And mark critical HPI report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And delete HPI report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@NonAdminUSAChromeTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an HPI report with username as "jenkinsvmnonadmin"
	And share HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete HPI report with admin nonadmin environment indicator equals 5
	And logout from KALE

@NonAdminUSAFirefoxTest
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When he creates an HPI report with username as "jenkinsvmnonadmin"
	And share HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete HPI report with admin nonadmin environment indicator equals 5
	And logout from KALE

@NonAdminUSAIE10Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When he creates an HPI report with username as "jenkinsvmnonadmin"
	And share HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical HPI report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete HPI report with admin nonadmin environment indicator equals 5
	And logout from KALE

@NonAdminUSAIE11Test
Scenario: Test HPI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When he creates an HPI report with username as "virtualnonadmin_ie11"
	And share HPI report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And mark critical HPI report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And delete HPI report with admin nonadmin environment indicator equals 7
	And logout from KALE