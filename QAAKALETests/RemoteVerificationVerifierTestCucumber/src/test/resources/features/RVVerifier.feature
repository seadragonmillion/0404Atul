Feature: Automated RV Verifier
#Requester: qaa (jenkins_rv_nonadmin), email: piikaleremote02@gmail.com
#Verifier: rvv (qaarvverifiernonadmin), email: piikaleemailtest01@gmail.com
@ChromeTest
Scenario: Verify RV Verifier notificaions and emails
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 2
	And logout from KALE
	
#@FirefoxTest
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 2
#	And logout from KALE
#	
#@IE10Test
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 2
#	And logout from KALE
#	
#@IE11Test
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_rv_ie11_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_ie11_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 4
#	And logout from KALE
#	
#@AsiaChromeTest
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 6
#	And logout from KALE
#	
#@AsiaFirefoxTest
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 6
#	And logout from KALE
#	
#@AsiaIE10Test
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 6
#	And logout from KALE
#	
#@AsiaIE11Test
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_rv_ie11_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_ie11_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 8
#	And logout from KALE
#	
#@USAChromeTest
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_rv_us_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_us_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 10
#	And logout from KALE
#
#@USAFirefoxTest
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_rv_us_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_us_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 10
#	And logout from KALE
#
#@USAIE10Test
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_rv_us_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_us_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 10
#	And logout from KALE
#
#@USAIE11Test
#Scenario: Verify RV Verifier notificaions and emails
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_rv_us_ie11_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When she creates RV report and verifies notification with verifier and sender with username as "jenkins_rv_us_ie11_nonadmin" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 12
#	And logout from KALE
	