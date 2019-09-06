Feature: Automated Job Observation Sanity

@ChromeTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Job Observation report with admin nonadmin environment indicator equals 0
	And logout from KALE

@FirefoxTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Job Observation report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE10Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete Job Observation report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE11Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical Job Observation report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete Job Observation report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she creates an Job Observation report
	And share Job Observation report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Job Observation report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Job Observation report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she creates an Job Observation report
	And share Job Observation report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Job Observation report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Job Observation report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she creates an Job Observation report
	And share Job Observation report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical Job Observation report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete Job Observation report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she creates an Job Observation report
	And share Job Observation report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical Job Observation report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete Job Observation report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@USAChromeTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Job Observation report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAFirefoxTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Job Observation report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE10Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical Job Observation report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete Job Observation report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE11Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Job Observation report
	And share Job Observation report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical Job Observation report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete Job Observation report with admin nonadmin environment indicator equals 6
	And logout from KALE
	
@NonAdminChromeTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Job Observation report
	And share Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Job Observation report with admin nonadmin environment indicator equals 1
	And logout from KALE

@NonAdminFirefoxTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Job Observation report
	And share Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Job Observation report with admin nonadmin environment indicator equals 1
	And logout from KALE

@NonAdminIE10Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Job Observation report
	And share Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And mark critical Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 1
	And delete Job Observation report with admin nonadmin environment indicator equals 1
	And logout from KALE

@NonAdminIE11Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Job Observation report
	And share Job Observation report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And mark critical Job Observation report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 3
	And delete Job Observation report with admin nonadmin environment indicator equals 3
	And logout from KALE
			
@NonAdminAsiaChromeTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "chrome"
	When she creates an Job Observation report
	And share Job Observation report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Job Observation report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Job Observation report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@NonAdminAsiaFirefoxTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "firefox"
	When she creates an Job Observation report
	And share Job Observation report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Job Observation report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Job Observation report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@NonAdminAsiaIE10Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie10"
	When she creates an Job Observation report
	And share Job Observation report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And mark critical Job Observation report with username as "qaacfi" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 1
	And delete Job Observation report with admin nonadmin environment indicator equals 1
	And logout from KALE
	
@NonAdminAsiaIE11Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" on browser "ie11"
	When she creates an Job Observation report
	And share Job Observation report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And mark critical Job Observation report with username as "qaa_ie11" and password as "S2FsZTk0OTM1ODMwQA==" and admin nonadmin environment indicator equals 3
	And delete Job Observation report with admin nonadmin environment indicator equals 3
	And logout from KALE
	
@NonAdminUSAChromeTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an Job Observation report
	And share Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Job Observation report with admin nonadmin environment indicator equals 5
	And logout from KALE

@NonAdminUSAFirefoxTest
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an Job Observation report
	And share Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Job Observation report with admin nonadmin environment indicator equals 5
	And logout from KALE

@NonAdminUSAIE10Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an Job Observation report
	And share Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And mark critical Job Observation report and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 5
	And delete Job Observation report with admin nonadmin environment indicator equals 5
	And logout from KALE

@NonAdminUSAIE11Test
Scenario: Test Job Observation sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an Job Observation report
	And share Job Observation report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And mark critical Job Observation report with username as "virtualnonadmin_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 7
	And delete Job Observation report with admin nonadmin environment indicator equals 7
	And logout from KALE