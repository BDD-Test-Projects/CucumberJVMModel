Xplore-Automation
=================

Steps to Execute Test Suites

Preset the Browser:

1. Go to SharedDriver.Java

     Change the value of the key = <desired browser> eg: firefox or chrome or IE

1. Go To RunCukesTest.Java

2. Enter the desired tag name  eg:. @TEST  [ refer the list of available tags in the system]

3. Right click and select "RunCukesTest.JAVA


To Run from Command Prompt :

  mvn clean test -Dcucumber.options="--tags @xplore"
  -Dmaven.test.failure.ignore=true exec:java
  -Dbrowser=firefox
  -Dexec.mainClass="com.newsint.xplore.qa.ReportManager"


#####Available Tags for Test Execution ##################################################################
#                                                                                                       #
# 1. @xplore - Regression Test Suite[ Run all the test in the repositories ]                            #
# 2. @HomePage - Runs only Home Page tests                                                              #
# 3. @Clients - Runs all Client Page tests [ Creating Client, Agency, with contract/                    #
#                                              without contract, contact for client]                    #
# 4. @Contract - Runs all Contract Tests [ Contract for Client, Agency, ]                               #
# 5. @Contact - Runs all Contact Tests[ Creating a Contact for Client, Agency ]                         #
# 6. @Orders - Runs all Order related tests[ Creating an Order for client. agency with/                 #
#                                                                      without contract]                #
# 7. @Ads - Run all Placing Ads test[ digital, classified , ads by client or agency ]                   #
# 8. @Release1 - Runs all Release 1 stories automated                                                   #
# 9. @OSI - Runs all OSI related stories                                                                #
# 10.@OP173 - Runs all the tests related to the Story- OP173                                            #
############################################################### #########################################
