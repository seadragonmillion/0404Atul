Feature: Automated RV Sanity

@ChromeTest
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an RV report with username as "jenkinsvm" and admin nonadmin environment indicator equals 1
	And downloads RV report with username as "jenkinsvm" on browser "chrome"
	And share RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE

@FirefoxTest
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When he creates an RV report with username as "jenkinsvm" and admin nonadmin environment indicator equals 1
	And downloads RV report with username as "jenkinsvm" on browser "firefox"
	And share RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE10Test
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When he creates an RV report with username as "jenkinsvm" and admin nonadmin environment indicator equals 1
	And downloads RV report with username as "jenkinsvm" on browser "ie10"
	And share RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE11Test
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When he creates an RV report with username as "jenkinsvm_ie11" and admin nonadmin environment indicator equals 3
	And downloads RV report with username as "jenkinsvm_ie11" on browser "ie11"
	And share RV report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical RV report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete RV report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When he creates an RV report with username as "ritica" and admin nonadmin environment indicator equals 5
	And downloads RV report with username as "ritica" on browser "chrome"
	And share RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When he creates an RV report with username as "ritica" and admin nonadmin environment indicator equals 5
	And downloads RV report with username as "ritica" on browser "firefox"
	And share RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When he creates an RV report with username as "ritica" and admin nonadmin environment indicator equals 5
	And downloads RV report with username as "ritica" on browser "ie10"
	And share RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When he creates an RV report with username as "ritica" and admin nonadmin environment indicator equals 7
	And downloads RV report with username as "ritica" on browser "ie11"
	And share RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical RV report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete RV report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@USAChromeTest
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an RV report with username as "jenkinsvm" and admin nonadmin environment indicator equals 9
	And downloads RV report with username as "jenkinsvm" on browser "chrome"
	And share RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete RV report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAFirefoxTest
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When he creates an RV report with username as "jenkinsvm" and admin nonadmin environment indicator equals 9
	And downloads RV report with username as "jenkinsvm" on browser "firefox"
	And share RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete RV report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE10Test
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When he creates an RV report with username as "jenkinsvm" and admin nonadmin environment indicator equals 9
	And downloads RV report with username as "jenkinsvm" on browser "ie10"
	And share RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical RV report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete RV report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE11Test
Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When he creates an RV report with username as "jenkinsvm_ie11" and admin nonadmin environment indicator equals 11
	And downloads RV report with username as "jenkinsvm_ie11" on browser "ie11"
	And share RV report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical RV report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete RV report with admin nonadmin environment indicator equals 6
	And logout from KALE