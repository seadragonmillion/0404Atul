Feature: Automated Error Meter Sanity

@E0ChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 0 on browser "chrome"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E0FirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 0 on browser "firefox"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E0IE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 0 on browser "ie10"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E0IE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm_ie11"
	And downloads Error Meter report with error probability as 0 on browser "ie11"
	And share Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete Error Meter report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@E0AsiaChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she creates an Error Meter report with error probability as 0 and username as "ritica"
	And downloads Error Meter report with error probability as 0 on browser "chrome"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E0AsiaFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she creates an Error Meter report with error probability as 0 and username as "ritica"
	And downloads Error Meter report with error probability as 0 on browser "firefox"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E0AsiaIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she creates an Error Meter report with error probability as 0 and username as "ritica"
	And downloads Error Meter report with error probability as 0 on browser "ie10"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E0AsiaIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she creates an Error Meter report with error probability as 0 and username as "ritica_ie11"
	And downloads Error Meter report with error probability as 0 on browser "ie11"
	And share Error Meter report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical Error Meter report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete Error Meter report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@E0USAChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 0 on browser "chrome"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E0USAFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 0 on browser "firefox"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E0USAIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 0 on browser "ie10"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E0USAIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvm_ie11"
	And downloads Error Meter report with error probability as 0 on browser "ie11"
	And share Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete Error Meter report with admin nonadmin environment indicator equals 6
	And logout from KALE
	
@E0NonAdminChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 0 on browser "chrome"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E0NonAdminFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 0 on browser "firefox"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E0NonAdminIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 0 on browser "ie10"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E0NonAdminIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 0 and username as "virtualnonadmin_ie11"
	And downloads Error Meter report with error probability as 0 on browser "ie11"
	And share Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And mark critical Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And delete Error Meter report with admin nonadmin environment indicator equals 3
	And logout from KALE
			
@E0NonAdminAsiaChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an Error Meter report with error probability as 0 and username as "qaacfi"
	And downloads Error Meter report with error probability as 0 on browser "chrome"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E0NonAdminAsiaFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an Error Meter report with error probability as 0 and username as "qaacfi"
	And downloads Error Meter report with error probability as 0 on browser "firefox"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E0NonAdminAsiaIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an Error Meter report with error probability as 0 and username as "qaacfi"
	And downloads Error Meter report with error probability as 0 on browser "ie10"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E0NonAdminAsiaIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an Error Meter report with error probability as 0 and username as "qaa_ie11"
	And downloads Error Meter report with error probability as 0 on browser "ie11"
	And share Error Meter report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And mark critical Error Meter report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And delete Error Meter report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@E0NonAdminUSAChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 0 on browser "chrome"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E0NonAdminUSAFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 0 on browser "firefox"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E0NonAdminUSAIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 0 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 0 on browser "ie10"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E0NonAdminUSAIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 0 and username as "virtualnonadmin_ie11"
	And downloads Error Meter report with error probability as 0 on browser "ie11"
	And share Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And mark critical Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And delete Error Meter report with admin nonadmin environment indicator equals 7
	And logout from KALE
	
@E50ChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 50 on browser "chrome"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E50FirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 50 on browser "firefox"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E50IE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 50 on browser "ie10"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E50IE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm_ie11"
	And downloads Error Meter report with error probability as 50 on browser "ie11"
	And share Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete Error Meter report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@E50AsiaChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she creates an Error Meter report with error probability as 50 and username as "ritica"
	And downloads Error Meter report with error probability as 50 on browser "chrome"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E50AsiaFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she creates an Error Meter report with error probability as 50 and username as "ritica"
	And downloads Error Meter report with error probability as 50 on browser "firefox"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E50AsiaIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she creates an Error Meter report with error probability as 50 and username as "ritica"
	And downloads Error Meter report with error probability as 50 on browser "ie10"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E50AsiaIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she creates an Error Meter report with error probability as 50 and username as "ritica_ie11"
	And downloads Error Meter report with error probability as 50 on browser "ie11"
	And share Error Meter report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical Error Meter report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete Error Meter report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@E50USAChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 50 on browser "chrome"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E50USAFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 50 on browser "firefox"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E50USAIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 50 on browser "ie10"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E50USAIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvm_ie11"
	And downloads Error Meter report with error probability as 50 on browser "ie11"
	And share Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete Error Meter report with admin nonadmin environment indicator equals 6
	And logout from KALE
	
@E50NonAdminChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 50 on browser "chrome"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E50NonAdminFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 50 on browser "firefox"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E50NonAdminIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 50 on browser "ie10"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E50NonAdminIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 50 and username as "virtualnonadmin_ie11"
	And downloads Error Meter report with error probability as 50 on browser "ie11"
	And share Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And mark critical Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And delete Error Meter report with admin nonadmin environment indicator equals 3
	And logout from KALE
			
@E50NonAdminAsiaChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an Error Meter report with error probability as 50 and username as "qaacfi"
	And downloads Error Meter report with error probability as 50 on browser "chrome"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E50NonAdminAsiaFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an Error Meter report with error probability as 50 and username as "qaacfi"
	And downloads Error Meter report with error probability as 50 on browser "firefox"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E50NonAdminAsiaIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an Error Meter report with error probability as 50 and username as "qaacfi"
	And downloads Error Meter report with error probability as 50 on browser "ie10"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E50NonAdminAsiaIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an Error Meter report with error probability as 50 and username as "qaa_ie11"
	And downloads Error Meter report with error probability as 50 on browser "ie11"
	And share Error Meter report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And mark critical Error Meter report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And delete Error Meter report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@E50NonAdminUSAChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 50 on browser "chrome"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E50NonAdminUSAFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 50 on browser "firefox"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E50NonAdminUSAIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 50 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 50 on browser "ie10"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E50NonAdminUSAIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 50 and username as "virtualnonadmin_ie11"
	And downloads Error Meter report with error probability as 50 on browser "ie11"
	And share Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And mark critical Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And delete Error Meter report with admin nonadmin environment indicator equals 7
	And logout from KALE

@E100ChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 100 on browser "chrome"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E100FirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 100 on browser "firefox"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E100IE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 100 on browser "ie10"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE

@E100IE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm_ie11"
	And downloads Error Meter report with error probability as 100 on browser "ie11"
	And share Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete Error Meter report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@E100AsiaChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she creates an Error Meter report with error probability as 100 and username as "ritica"
	And downloads Error Meter report with error probability as 100 on browser "chrome"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E100AsiaFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she creates an Error Meter report with error probability as 100 and username as "ritica"
	And downloads Error Meter report with error probability as 100 on browser "firefox"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E100AsiaIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she creates an Error Meter report with error probability as 100 and username as "ritica"
	And downloads Error Meter report with error probability as 100 on browser "ie10"
	And share Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Error Meter report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Error Meter report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@E100AsiaIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she creates an Error Meter report with error probability as 100 and username as "ritica_ie11"
	And downloads Error Meter report with error probability as 100 on browser "ie11"
	And share Error Meter report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical Error Meter report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete Error Meter report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@E100USAChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 100 on browser "chrome"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E100USAFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 100 on browser "firefox"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E100USAIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm"
	And downloads Error Meter report with error probability as 100 on browser "ie10"
	And share Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Error Meter report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Error Meter report with admin nonadmin environment indicator equals 4
	And logout from KALE

@E100USAIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvm_ie11"
	And downloads Error Meter report with error probability as 100 on browser "ie11"
	And share Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical Error Meter report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete Error Meter report with admin nonadmin environment indicator equals 6
	And logout from KALE
	
@E100NonAdminChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 100 on browser "chrome"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E100NonAdminFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 100 on browser "firefox"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E100NonAdminIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 100 on browser "ie10"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE

@E100NonAdminIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 100 and username as "virtualnonadmin_ie11"
	And downloads Error Meter report with error probability as 100 on browser "ie11"
	And share Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And mark critical Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And delete Error Meter report with admin nonadmin environment indicator equals 3
	And logout from KALE
			
@E100NonAdminAsiaChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an Error Meter report with error probability as 100 and username as "qaacfi"
	And downloads Error Meter report with error probability as 100 on browser "chrome"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E100NonAdminAsiaFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an Error Meter report with error probability as 100 and username as "qaacfi"
	And downloads Error Meter report with error probability as 100 on browser "firefox"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E100NonAdminAsiaIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an Error Meter report with error probability as 100 and username as "qaacfi"
	And downloads Error Meter report with error probability as 100 on browser "ie10"
	And share Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Error Meter report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Error Meter report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@E100NonAdminAsiaIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an Error Meter report with error probability as 100 and username as "qaa_ie11"
	And downloads Error Meter report with error probability as 100 on browser "ie11"
	And share Error Meter report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And mark critical Error Meter report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And delete Error Meter report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@E100NonAdminUSAChromeTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 100 on browser "chrome"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E100NonAdminUSAFirefoxTest
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 100 on browser "firefox"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E100NonAdminUSAIE10Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Error Meter report with error probability as 100 and username as "jenkinsvmnonadmin"
	And downloads Error Meter report with error probability as 100 on browser "ie10"
	And share Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Error Meter report with username as "jenkinsvmnonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Error Meter report with admin nonadmin environment indicator equals 5
	And logout from KALE

@E100NonAdminUSAIE11Test
Scenario: Test Error Meter sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Error Meter report with error probability as 100 and username as "virtualnonadmin_ie11"
	And downloads Error Meter report with error probability as 100 on browser "ie11"
	And share Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And mark critical Error Meter report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And delete Error Meter report with admin nonadmin environment indicator equals 7
	And logout from KALE