Feature: Automated SRI Sanity

@ChromeTest
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete SRI report with admin nonadmin environment indicator equals 0
	And logout from KALE

@FirefoxTest
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete SRI report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE10Test
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete SRI report with admin nonadmin environment indicator equals 0
	And logout from KALE

@IE11Test
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an SRI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And mark critical SRI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 2
	And delete SRI report with admin nonadmin environment indicator equals 2
	And logout from KALE
			
@AsiaChromeTest
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "chrome"
	When she creates an SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And share SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete SRI report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaFirefoxTest
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "firefox"
	When she creates an SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And share SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete SRI report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE10Test
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie10"
	When she creates an SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA=="
	And share SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And mark critical SRI report with username as "ritica" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 0
	And delete SRI report with admin nonadmin environment indicator equals 0
	And logout from KALE
	
@AsiaIE11Test
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" on browser "ie11"
	When she creates an SRI report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA=="
	And share SRI report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And mark critical SRI report with username as "ritica_ie11" and password as "S2FsZTQ2MTkxODAyQA==" and admin nonadmin environment indicator equals 2
	And delete SRI report with admin nonadmin environment indicator equals 2
	And logout from KALE
	
@USAChromeTest
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates an SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete SRI report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAFirefoxTest
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
	When she creates an SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete SRI report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE10Test
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
	When she creates an SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And mark critical SRI report with username as "jenkinsvm" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 4
	And delete SRI report with admin nonadmin environment indicator equals 4
	And logout from KALE

@USAIE11Test
Scenario: Test SRI sanity feature with notifications
	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
	When she creates an SRI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz"
	And share SRI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And mark critical SRI report with username as "jenkinsvm_ie11" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 6
	And delete SRI report with admin nonadmin environment indicator equals 6
	And logout from KALE
	