package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.adpoint.Clients;
import com.newsint.xplore.qa.pageobjects.adpoint.Orders;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 12/04/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
    public class OrdersStepdefs {


    @And("^I set up a Client with Contract")
    public void setupClientWithContract(){

        HomePageStepdefs.clickOnATab("Clients");
        ClientStepdefs.createACustomer("Client", "");
        ClientStepdefs.verifyCustomerCreated();
        ClientStepdefs.setAddress();
        HomePageStepdefs.clickOnATab("Summary");
        ContactStepdefs.createAContact();
        HomePageStepdefs.clickOnATab("Summary");
        ContractStepdefs.createAContract("Client");
        WebNavPage.clickALink("//a[contains(text(), '"+ClientStepdefs.CustName+"')]");
        WebNavPage.waitForElementToLoad();
    }

    @And("^I set up a Client without Contract$")
    public void setupClientWithoutContract(){

        HomePageStepdefs.clickOnATab("Clients");
        ClientStepdefs.createACustomer("Client", "");
        ClientStepdefs.verifyCustomerCreated();
        ClientStepdefs.setAddress();
        HomePageStepdefs.clickOnATab("Summary");
        ContactStepdefs.createAContact();
        HomePageStepdefs.clickOnATab("Summary");

    }

    @And("^I place an Order$")
    public void placeOrder(){

        HomePageStepdefs.clickOnATab("Summary");
        WebNavPage.clickALink(Clients.NewOrder);
        createAnOrder();

    }

    @And("^I link the agency with a Client with Contract$")
    public void linkWithAnAgencyWithContract(){
        HomePageStepdefs.clickOnATab("Clients");
        ClientStepdefs.createACustomer("Client", "Yes");
        ClientStepdefs.verifyCustomerCreated();
        ClientStepdefs.setAddress();
        HomePageStepdefs.clickOnATab("Summary");
        ContactStepdefs.createAContact();
        HomePageStepdefs.clickOnATab("Summary");
        ContractStepdefs.createAContract("Client");
        WebNavPage.clickALink("//a[contains(text(), '"+ClientStepdefs.CustName+"')]");
        WebNavPage.waitForElementToLoad();

    }

    @And("^I link the agency with a Client without Contract$")
    public void linkWithAnAgencyWithoutContract(){
        HomePageStepdefs.clickOnATab("Clients");
        ClientStepdefs.createACustomer("Client", "Yes");
        ClientStepdefs.verifyCustomerCreated();
        ClientStepdefs.setAddress();
        HomePageStepdefs.clickOnATab("Summary");
        ContactStepdefs.createAContact();
        WebNavPage.waitForElementToLoad();

    }

    @Then("^I should be able to see the Order$")
    public void ensureOrderIsCreated(){

        HomePageStepdefs.clickOnATab("Orders");
        WebNavPage.waitForElementToLoad();
        WebNavPage.clickALink(Clients.Detail);
        WebNavPage.waitForElementToLoad();
        WebNavPage.assertContentExists("//span[@id='ctl00_body_lblName']", "Test Automation-Order" );
    }

    @Then("^I can see the Order Detail Page$")
    public void ensureOrderDetailPageIsDisplayed(){

        WebNavPage.elementWithXPathExists("//div[@id='ctl00_body_updOrders']");

    }


    public static void goToOnlineAdList(){

        WebNavPage.clickALink("//div[@class = 'dropdown-button-arrow']");
        WebNavPage.clickALink("//span[contains(text(), 'Online ads')]");
        WebNavPage.waitForShortSpan();


    }

    public static void showOnlineAdsInAllAdsTable(){
        WebNavPage.clickALink("//div[@id='ctl00_body_pnlViewOA']");
        WebNavPage.waitForShortSpan();
    }


    public static void createAnOrder(){

        WebNavPage.enterAnyTextInAField(Orders.OrderName, "Test Automation-Order");
        WebNavPage.enterAnyTextInAField(Orders.RefNumber, "123789345");
        WebNavPage.enterAnyTextInAField(Orders.RefNumber2, "345987");
        if (WebNavPage.getAttribute("//input[@id='ctl00_body_MediaAgencySelector_tbCustomerName']").contains("Not specified")){
            WebNavPage.selectAnOptionFromAList("Customer", "//select[@id='ctl00_body_cmbInvoiceTo']");
        }
        String ContactName = "Automation Tester - "+ClientStepdefs.CustName;
        WebNavPage.waitForShortSpan();
        try{
            WebNavPage.selectAnOptionFromAList(ContactName, "//select[@id='ctl00_body_cmbContactID']");
            WebNavPage.waitForShortSpan();
        }catch(Exception e){
            e.printStackTrace();
        }

        WebNavPage.clickALink(Orders.Save);
        WebNavPage.waitForElementToLoad();

    }







}
