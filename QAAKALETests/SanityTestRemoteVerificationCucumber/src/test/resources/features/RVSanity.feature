Feature: Automated RV Sanity

Scenario: Test RV sanity feature with notifications
	Given user is on KALE Home Page "https://kaleqa.error-free.com/" with username as "ritica_only_admin" and password as "S2FsZWplbmtpbnNAMTIz" on browser "chrome"
	When he creates an RV report with username as "ritica_only_admin" and admin nonadmin environment indicator equals 1
	And downloads RV report with username as "ritica_only_admin" on browser "chrome"
	And share RV report with username as "ritica_only_admin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And mark critical RV report with username as "ritica_only_admin" and password as "S2FsZWplbmtpbnNAMTIz" and admin nonadmin environment indicator equals 0
	And delete RV report with admin nonadmin environment indicator equals 0
	And logout from KALE