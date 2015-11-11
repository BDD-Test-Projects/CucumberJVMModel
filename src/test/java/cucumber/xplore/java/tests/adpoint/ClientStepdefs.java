package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.adpoint.Clients;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 12/04/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class ClientStepdefs {

    public static String CustName = "";
    public static String AgencyName = "";

    @And("^I create (.*)")
    public void createAClient(String type){

        createACustomer(type, "");
        verifyCustomerCreated();
        setAddress();
    }

    @And("^I link a Client with the Agency$")
    public void createClientForAgency(){

        //CustName = "Client-"+System.currentTimeMillis();
        createACustomer("Client", "Yes");
        verifyCustomerCreated();
    }

    @And("^I register a new Client$")
    public void createANewClient(){
        createACustomer("Client", "");
    }

    @Then("^the client should be displayed in the Clients List$")
    public void verifyClientCreatedExistInTheList(){

        WebNavPage.enterAnyTextInAField(Clients.ClientSearchByName, CustName);
        WebNavPage.pressEnterKey(Clients.ClientSearchByName);
        WebNavPage.waitForElementToLoad();
        /*String Xyx = WebNavPage.getText("//table[@id='ctl00_body_gvList']");
        WebNavPage.retryingFindClick("//table/tbody/tr[2]/td[4]", CustName);*/
        WebNavPage.assertContentExists("//table[@id='ctl00_body_gvList']/tbody/tr[2]/td[4]", CustName);
    }

    @When("^I navigate to (.*) tab in the Customer Page$")
    public void navigateToTab(String tabName){

        HomePageStepdefs.clickOnATab(tabName);

    }

    @Then("^I can see the OSI column in the Online ads grid$")
    public void verifyOSIColumnExists(){

        if (WebNavPage.assertContentExists("//span[@id='ctl00_body_Label15']", "Online ads")!= Boolean.FALSE){
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink("//div/a[contains(text(), 'Customize')]");
            WebNavPage.waitForShortSpan();
            WebNavPage.assertContentExists("//h4/span[contains(text(), 'Customize columns')]", "Customize columns");
            WebNavPage.assertContentExists("//span/label[contains(text(), 'OSI')]", "OSI");
            WebNavPage.waitForShortSpan();
            if (WebNavPage.verifyCheckBoxChecked("//input[@id='ctl00_body_FastGridControlPanelCtl_reorderColumns__rli2_cbVisible']")==false){
                WebNavPage.checkACheckBox("//span/label[contains(text(), 'OSI')]");
                WebNavPage.waitForShortSpan();
                WebNavPage.clickALink("//input[@id='ctl00_body_FastGridControlPanelCtl_btnEndCustomize']");
                WebNavPage.waitForShortSpan();
            } else {
                WebNavPage.clickALink("//input[@id='ctl00_body_FastGridControlPanelCtl_btnEndCustomize']");
            }

            WebNavPage.assertContentExists("//a[@id='ctl00_body_gvList_ctl01_lbSortOSI']", "OSI");
        }

    }



    public static void createACustomer(String type, String linkitAgency){

        WebNavPage.clickALink(Clients.NewCustomer);
        WebNavPage.waitForElementToLoad();
        CustName = "ClientNo:"+System.currentTimeMillis();
        WebNavPage.clickALink(Clients.MainInfo_tab);
        WebNavPage.waitForElementToLoad();

        /*A Sections Entries ######################################*/
        if (type.equalsIgnoreCase("Agency")){
            CustName = "Agency-"+System.currentTimeMillis();
            AgencyName = CustName;
        }
        WebNavPage.enterAnyTextInAField(Clients.Custname, CustName );
        //WebNavPage.enterAnyTextInAField(Clients.EngName, "Xplore Automation Inc");
        WebNavPage.enterAnyTextInAField(Clients.Regno, "1325476");

        /*B Sections Entries #####################################*/

        WebNavPage.enterAnyTextInAField(Clients.Phone_num, "0208 180 3456");
        WebNavPage.enterAnyTextInAField(Clients.Fax_num, "0208 180 3000");
        WebNavPage.enterAnyTextInAField(Clients.Email, "info@XploreAutomationInc.Co.UK");
        WebNavPage.enterAnyTextInAField(Clients.Web, "bbc.co.uk/iplayer");


        //WebNavPage.enterAnyTextInAField(Clients.CreativeAgency, "Xplore Creative UK Ltd");
        //WebNavPage.enterAnyTextInAField(Clients.Agent, "Agent SnakeEye");
        WebNavPage.selectingAnOptionFromList("Media", Clients.SegmentList);
        WebNavPage.selectingAnOptionFromList("Yes", Clients.ActiveList);
        WebNavPage.clickALink(Clients.Other_tab);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectAnOptionFromAList("NWI database", Clients.Source);
        WebNavPage.clickALink(Clients.MainInfo_tab);
        WebNavPage.waitForShortSpan();

        /*D Sections Entries ######################################*/

        if (type.equalsIgnoreCase("Agency")){
          WebNavPage.selectingAnOptionFromList("Yes", Clients.IsAgencyList);
        }
        //WebNavPage.selectingAnOptionFromList("LocalHolding 1", Clients.LocalHoldList);
        WebNavPage.enterAnyTextInAField(Clients.DefVouchersCopies, "250");
        WebNavPage.selectingAnOptionFromList("Normal (default)", Clients.DefAdType);
        WebNavPage.waitForShortSpan();

        /*C Section Entries ######################################*/
        if (linkitAgency.equalsIgnoreCase("Yes")){
            WebNavPage.clearAnyField(Clients.MediaAgency);

            WebNavPage.enterAnyTextInAField(Clients.MediaAgency, AgencyName);
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink("//td[contains(text(), '"+AgencyName+"')]");
            WebNavPage.clickALink(Clients.CreativeAgency);
        }

        WebNavPage.clickALink(Clients.SaveBTN);
        WebNavPage.waitForElementToLoad();
    }

    public static void verifyCustomerCreated(){

      WebNavPage.assertContentExists(Clients.ClientHeader, CustName);

    }

    public static void setAddress(){

        HomePageStepdefs.clickOnATab("Addresses");
        WebNavPage.waitForElementToLoad();
        WebNavPage.clickALink("//a[@id='ctl00_body_hlOtherAddress']");
        WebNavPage.waitForElementToLoad();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbStreet']", "2, Thomas More Square");
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbZIP']", "E98 1XY");
        WebNavPage.waitForElementToLoad();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbCity']", "London");
        WebNavPage.waitForShortSpan();
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbMail']", "info@XploreAutomationInc.com");
        WebNavPage.checkACheckBox("//input[@id='ctl00_body_cbSetAsInvoicing']");
        WebNavPage.checkACheckBox("//input[@id='ctl00_body_cbSetAsMailing']");
        WebNavPage.checkACheckBox("//input[@id='ctl00_body_cbSetAsVisiting']");
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink("//input[@id='ctl00_body_btnSave']");
        WebNavPage.waitForElementToLoad();
        HomePageStepdefs.clickOnATab("Summary");

    }



}
