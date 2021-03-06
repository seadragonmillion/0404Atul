Feature: Automated HiRCA report for verifying bugs

@ChromeTest
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report with username as "jenkinsvmnonadmin"
	And share HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And rename and save HiRCA report three times with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@FirefoxTest
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report with username as "jenkinsvmnonadmin"
	And share HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And rename and save HiRCA report three times with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 1
	And delete HiRCA report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@IE10Test
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report with username as "jenkinsvmnonadmin"
	And share HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And rename and save HiRCA report three times with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@IE11Test
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates HiRCA report with username as "virtualnonadmin_ie11"
	And share HiRCA report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And mark HiRCA report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And rename and save HiRCA report three times with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@AsiaChromeTest
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report with username as "jenkins_2_nonadmin"
	And share HiRCA report with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark HiRCA report with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And rename and save HiRCA report three times with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report with username as "jenkins_2_nonadmin"
	And share HiRCA report with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark HiRCA report with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And rename and save HiRCA report three times with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 1
	And delete HiRCA report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@AsiaIE10Test
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report with username as "jenkins_2_nonadmin"
	And share HiRCA report with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark HiRCA report with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And rename and save HiRCA report three times with username as "jenkins_2_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@AsiaIE11Test
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates HiRCA report with username as "qaa_ie11"
	And share HiRCA report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And mark HiRCA report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And rename and save HiRCA report three times with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@USAChromeTest
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates HiRCA report with username as "jenkinsvmnonadmin"
	And share HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And rename and save HiRCA report three times with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 5
	And logout from KALE

@USAFirefoxTest
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates HiRCA report with username as "jenkinsvmnonadmin"
	And share HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And rename and save HiRCA report three times with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 1
	And delete HiRCA report with admin nonadmin environment indicator equals 5
	And logout from KALE

@USAIE10Test
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates HiRCA report with username as "jenkinsvmnonadmin"
	And share HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark HiRCA report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And rename and save HiRCA report three times with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 5
	And logout from KALE

@USAIE11Test
Scenario: Verify HiRCA report for verifying bugs 
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates HiRCA report with username as "virtualnonadmin_ie11"
	And share HiRCA report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And mark HiRCA report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And rename and save HiRCA report three times with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and firefox indicator as 0
	And delete HiRCA report with admin nonadmin environment indicator equals 7
	And logout from KALE
	