Feature: Automated HiRCA Level 1 Test

@ChromeTest
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report answering Level one questions with username as "jenkinsvmnonadmin"
	And delete report
	And logout from KALE
	
@FirefoxTest
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report answering Level one questions with username as "jenkinsvmnonadmin"
	And delete report
	And logout from KALE
	
@IE10Test
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report answering Level one questions with username as "jenkinsvmnonadmin"
	And delete report
	And logout from KALE
	
@IE11Test
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates HiRCA report answering Level one questions with username as "virtualnonadmin_ie11"
	And delete report
	And logout from KALE
	
@AsiaChromeTest
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report answering Level one questions with username as "jenkins_2_nonadmin"
	And delete report
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report answering Level one questions with username as "jenkins_2_nonadmin"
	And delete report
	And logout from KALE
	
@AsiaIE10Test
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report answering Level one questions with username as "jenkins_2_nonadmin"
	And delete report
	And logout from KALE
	
@AsiaIE11Test
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates HiRCA report answering Level one questions with username as "qaa_ie11"
	And delete report
	And logout from KALE
	
@USAChromeTest
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report answering Level one questions with username as "jenkinsvmnonadmin"
	And delete report
	And logout from KALE

@USAFirefoxTest
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report answering Level one questions with username as "jenkinsvmnonadmin"
	And delete report
	And logout from KALE

@USAIE10Test
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report answering Level one questions with username as "jenkinsvmnonadmin"
	And delete report
	And logout from KALE

@USAIE11Test
Scenario: Verify HiRCA Level 1 path
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates HiRCA report answering Level one questions with username as "virtualnonadmin_ie11"
	And delete report
	And logout from KALE
	