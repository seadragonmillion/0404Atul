Feature: Automated RV Chinese

@ChromeTest
Scenario: Verify RV chinese translations
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When she changes language to chinese
	And verify chinese translation for RV report with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 2
	And she changes language to english
	And logout from KALE
	
#@FirefoxTest
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 2
#	And she changes language to english
#	And logout from KALE
#	
#@IE10Test
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 2
#	And she changes language to english
#	And logout from KALE
#	
#@IE11Test
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "jenkins_ie11_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_ie11_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 4
#	And she changes language to english
#	And logout from KALE
#	
#@AsiaChromeTest
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 6
#	And she changes language to english
#	And logout from KALE
#	
#@AsiaFirefoxTest
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 6
#	And she changes language to english
#	And logout from KALE
#	
#@AsiaIE10Test
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 6
#	And she changes language to english
#	And logout from KALE
#	
#@AsiaIE11Test
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "jenkins_ie11_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_ie11_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 8
#	And she changes language to english
#	And logout from KALE
#	
#@USAChromeTest
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 10
#	And she changes language to english
#	And logout from KALE
#
#@USAFirefoxTest
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "firefox"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 10
#	And she changes language to english
#	And logout from KALE
#
#@USAIE10Test
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie10"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 10
#	And she changes language to english
#	And logout from KALE
#
#@USAIE11Test
#Scenario: Verify RV chinese translations
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "jenkins_ie11_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" on browser "ie11"
#	When she changes language to chinese
#	And verify chinese translation for RV report with username as "jenkins_ie11_us_chinese" and password as "S2FsZWplbmtpbnNAMTIz" and verifier indicator equals 12
#	And she changes language to english
#	And logout from KALE
#	