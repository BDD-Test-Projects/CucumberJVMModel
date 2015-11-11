    package cucumber.xplore.java.tests.adpoint;

    import com.newsint.xplore.qa.functlib.WebNavPage;
    import cucumber.api.java.en.And;
    import cucumber.api.java.en.Then;
    import cucumber.api.java.en.When;
    import junit.framework.Assert;

    import static junit.framework.Assert.assertEquals;

    /**
     * Created with IntelliJ IDEA.
     * User: Vinod Kumar M
     * Date: 12/04/13
     * Time: 15:31
     * To change this template use File | Settings | File Templates.
     */
    public class ReportStepdefs {

        String REPORTNAME = "";



        public static void naviagateToOnlineAds(){

            HomePageStepdefs.clickOnATab("Sales rpts");
            WebNavPage.clickALink("//a[contains(text(), 'Online sold ads')]");
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink("//input[@id='ctl00_body_btnFind']");
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink("//input[@id='btnCustWindow']");
            WebNavPage.waitForShortSpan();
            WebNavPage.assertContentExists("//span[@id='ctl00_body_gvList_custwindow_PWH-1T']", "Columns to view");
            WebNavPage.assertContentDoesNotExistInTable("OSI");

        }

        @And("^I navigate to Online sold Ads report$")
        public void goToOnlineSoldAds(){
            naviagateToOnlineAds();
        }

        @Then("^I should see the OSI column in the sales report$")
        public void ensureOSIColumnExistsInTable(){

            WebNavPage.assertContentExists("//td[@id='ctl00_body_gvList_col46']", "OSI");
        }

        @And("^I navigate to Online ad detail page$")
        public void navigateToOnlineAdDetailPage(){

            OrdersStepdefs.goToOnlineAdList();
        }

        @Then("^I can see the OSI column in the Online ads list table$")
        public void verifyOSIColumnExistInOATable(){

            WebNavPage.assertContentExists("//a[@id='ctl00_body_gvList_ctl01_lbSortOSI']", "OSI");
        }


        @When("^I click on Online ads link in the All ads section$")
        public void showOnlineAdsInAllAdsTable(){
            OrdersStepdefs.showOnlineAdsInAllAdsTable();
        }

        @Then("^I should see the OSI column in the All ads table$")
        public void verifyOSIColumnExistInAllAdsTable(){

            WebNavPage.assertContentExists("//a[@id='ctl00_body_gvListOA_ctl01_lbSortOAOSI']", "OSI");
        }

        @And("^I select (.*) tab$")
        public void clickOnTab(String tabName){

            HomePageStepdefs.clickOnATab(tabName);
        }


        @When("^I choose (.*) link$")
        public void clickOnLink(String linkName){

            String linkLocator = "//a[contains(text(), '"+linkName+"')]";
            WebNavPage.clickALink(linkLocator);
        }

        @When("^I generate a (.*) Report$")
        public void generateReport(String reportName){

            HomePageStepdefs.clickOnATab("Reports");
            WebNavPage.waitForShortSpan();
            HomePageStepdefs.clickOnATab("Sales rpts");
            WebNavPage.waitForShortSpan();
            clickOnLink(reportName);
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink("//input[@id='ctl00_body_btnFind']");
            WebNavPage.waitForShortSpan();


        }

        @And("^I save the report")
        public void saveTheReport(){

            REPORTNAME = "TESTREPORT"+System.currentTimeMillis();

            WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_FilterCtrl_tbNewFilterName']", REPORTNAME);
            WebNavPage.enterAnyTextInAField("//textarea[@id='ctl00_body_FilterCtrl_tbFilterDescription']", "This is a sample report by TEST Automation");
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink("//a[@id='ctl00_body_FilterCtrl_lbAddFilter']");
            WebNavPage.waitForShortSpan();
        }

        @Then("^the report should be saved and displayed under Available Searches$")
        public void verifyReportSaved(){

            WebNavPage.elementWithXPathIsVisible("//a[contains(text(),'" + REPORTNAME + "')]");


        }

        @Then("^I should be able to see the saved report in the Report HomePage$")
        public void verifyReportExistInHomePage(){

            HomePageStepdefs.clickOnATab("Reports");
            WebNavPage.waitForShortSpan();
            HomePageStepdefs.clickOnATab("Sales rpts");
            WebNavPage.waitForShortSpan();
            String actualToolTip = WebNavPage.getHoverText("//a[contains(text(),'"+REPORTNAME+"')]");
            assertEquals("This is a sample report by TEST Automation", actualToolTip);

        }



        @Then("^I can see the expected search fields$")
        public void verifyAllSearchFieldPresent(){

            WebNavPage.assertContentExists("//span[@id='ctl00_body_FilterCtrl_xlblFiltersTitle']", "Saved searches");
            WebNavPage.assertContentExists("//label[@id='ctl00_body_FilterCtrl_xlblSaveSelectionAs']", "Save selection as");
            WebNavPage.elementWithXPathIsVisible("//input[@id='ctl00_body_FilterCtrl_tbNewFilterName']");
            WebNavPage.assertContentExists("//span[@id='ctl00_body_FilterCtrl_lblFilterDescription']", "Description");
            WebNavPage.assertContentExists("//a[@id='ctl00_body_FilterCtrl_lbAddFilter']", "OK");


        }



    }
