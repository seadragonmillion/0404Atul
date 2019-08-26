Feature: Automated HiRCA LOP Bugs

@ChromeTest
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@FirefoxTest
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@IE10Test
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@IE11Test
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@AsiaChromeTest
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@AsiaIE10Test
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@AsiaIE11Test
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	
@USAChromeTest
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE

@USAFirefoxTest
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE

@USAIE10Test
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE

@USAIE11Test
Scenario: Verify HiRCA LOP Bugs
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates HiRCA report to verify all LOP bugs
	And logout from KALE
	