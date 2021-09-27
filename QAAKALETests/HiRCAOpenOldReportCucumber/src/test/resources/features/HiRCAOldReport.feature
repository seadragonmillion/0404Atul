Feature: Automated HiRCA old report

@ChromeTest
Scenario: Verify HiRCA old report opens
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "lili" and password as "SHBAMTIzNDU=" on browser "chrome"
	When she verifies old HiRCA report can be opened and final report contains data inside
	And logout from KALE
	
#@FirefoxTest
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "firefox"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@IE10Test
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "ie10"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@IE11Test
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "ie11"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@AsiaChromeTest
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "chrome"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@AsiaFirefoxTest
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "firefox"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@AsiaIE10Test
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "ie10"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@AsiaIE11Test
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kaleasia.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "ie11"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	
#@USAChromeTest
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "chrome"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#
#@USAFirefoxTest
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "firefox"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#
#@USAIE10Test
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "ie10"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#
#@USAIE11Test
#Scenario: Verify HiRCA old report opens
#	Given user is on KALE Home Page "https://kale.error-free.com/" with username as "lili" and password as "S2FsZTY2NDIzMDAyQA==" on browser "ie11"
#	When she verifies old HiRCA report can be opened and final report contains data inside
#	And logout from KALE
#	