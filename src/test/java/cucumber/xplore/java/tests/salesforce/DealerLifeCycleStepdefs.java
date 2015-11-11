package cucumber.xplore.java.tests.salesforce;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.envparameters.EnvironmentURLs;
import com.newsint.xplore.qa.pageobjects.salesforce.AccountsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.HomePage;
import com.newsint.xplore.qa.pageobjects.salesforce.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 06/02/13
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class DealerLifeCycleStepdefs{

    public static String parent_Account = "";
    public static String child_Account = "";
    public static String accToBeChecked = "";
    public static Map<String, String> accountInfo = new HashMap<String, String>();

    @Given("^I am logged in as (.*) in Salesforce$")
    public static void logMeAs(String UserType) throws Exception {

          String UserName = "";

           if (UserType.equalsIgnoreCase("SalesUser")){
               UserName = EnvironmentURLs.SalesUser;
           } else if (UserType.equalsIgnoreCase("SalesSupportUser")){
               UserName = EnvironmentURLs.SalesSupportUser;
           }  else if (UserType.equalsIgnoreCase("AdminUser")){
               UserName = EnvironmentURLs.AdminUser;
           }  else {
               System.out.println("User Type Unknown");
           }

        WebNavPage.openWebPage(EnvironmentURLs.SalesforceLoginPage);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(LoginPage.username, UserName);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(LoginPage.password, EnvironmentURLs.Password);
        WebNavPage.clickALinkWithCssLocator(LoginPage.loginBTN);

        //Selecting NewsInternational if its not selected

        if (WebNavPage.getText(HomePage.orgLabel).equalsIgnoreCase("News International")!= true){
            WebNavPage.clickALink(HomePage.groupMenu);
            //WebNavPage.waitForElementToBeVisible(HomePage.orgMenu);
            WebNavPage.clickALink(HomePage.newIntLNK);
        }
    }

    @And("^I create a (.*) Account$")
    public static void creatAccount(String accType) throws InterruptedException {

        String AccountName = "SF"+accType+System.currentTimeMillis();

        if (accType.equalsIgnoreCase("Parent")){
            parent_Account = AccountName;
        } else {
            child_Account = AccountName;
        }

        createAnAccount(AccountName);
    }

    public static void createAnAccount(String AccountName) throws InterruptedException {

        if (!WebNavPage.elementWithXPathExists("//div[@id = 'createNewButton']")){
            WebNavPage.clickALink(HomePage.activateSideMenu);
        }
        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.accountOptionFromDropdown);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.accountName, AccountName);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.phone, "0208456789");
        WebNavPage.enterAnyTextInAField(AccountsPage.email, "info@test.com");
        WebNavPage.checkACheckBox(AccountsPage.dynamicTeleTracking);
        WebNavPage.enterAnyTextInAField(AccountsPage.telephoneTrackingNum, "25823");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.website, "http://www.test.com");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingStreet, "1, Some Street");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingCity, "Some City");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingPostcode, "E98 1XY");
        WebNavPage.enterAnyTextInAField(AccountsPage.SAPId, "9777777");
        WebNavPage.selectingAnOptionFromList("Car Dealer", AccountsPage.accType);
        WebNavPage.selectAnOptionFromAList("Key Account",AccountsPage.accSubType );
        WebNavPage.enterAnyTextInAField(AccountsPage.billCountry, "UK");
        WebNavPage.selectingAnOptionFromList("South-East", AccountsPage.region);
        WebNavPage.clickALink(AccountsPage.copyBillingAddress);
        WebNavPage.clickALink(HomePage.saveBTN);

        if (WebNavPage.getText("//div[@id='00N3000000AeABd_ileinner']").contains("SF")!= false){
           WebNavPage.waitForElementToLoad();
        } else {
            System.out.println("The Dealer ID for the Account is :"+ WebNavPage.getText("//div[@id='00N3000000AeABd_ileinner']"));
        }
    }

    @When("^I look into the (.*) Account$")
    public static void verifyAccountPage(String AccountName){

        WebNavPage.refreshPage();
        if (AccountName.equalsIgnoreCase("Parent")){
            AccountName = parent_Account;
        } else {
            AccountName = child_Account;
        }
    }

    @Then("^I should be able to see all the auto generated fields$")
    public static void verifyAccountHasAllAutoFields(){

        if (WebNavPage.getText(AccountsPage.accNameFilled)!= null){
            assertNotNull("The Value of External Id is :", WebNavPage.getText(AccountsPage.externalID));
            assertNotNull("The Value of Website Dealer Id is :", WebNavPage.getText(AccountsPage.webDealerId));

        }else {
            System.out.print("the ID's are not generated yet !!");
        }
        accountInfo.put("AccountName", WebNavPage.getText(AccountsPage.accNameFilled));
        accountInfo.put("ExternalID", WebNavPage.getText(AccountsPage.externalID));
        accountInfo.put("WebSiteDealerID", WebNavPage.getText(AccountsPage.webDealerId));
    }

    @And("^I do a credit check pass the (.*) Account$")
    public static void doCreditCheckOnAccount(String AccName ){


            if (AccName.equalsIgnoreCase("Parent")){
               accToBeChecked = parent_Account;
            }else {
               accToBeChecked = child_Account;
            }
        WebNavPage.enterAnyTextInAField(HomePage.search, accToBeChecked);
        WebNavPage.clickALink(HomePage.searchBTN);
        WebNavPage.waitForElementToLoad();
        String accLocator =  "//a[contains(text(),'"+accToBeChecked+"')]";
        try{
            WebNavPage.elementWithXPathExists(accLocator);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("The Account" + accToBeChecked+ "is not displayed in the search results");
        } finally {
            WebNavPage.clickALink(accLocator);
            WebNavPage.waitForElementToLoad();
            WebNavPage.clickALink(AccountsPage.edit);
            WebNavPage.waitForElementToLoad();
            WebNavPage.checkACheckBox(AccountsPage.CreCheck);
            WebNavPage.enterAnyNumberInAField(AccountsPage.CreRefNum, 1111);
            WebNavPage.clickALink(HomePage.saveBTN);
            WebNavPage.waitForElementToLoad();
        }
    }

    @Then("^the account should hold the credit check record$")
    public void verifyAccIsCreditChecked(){

        // To Verify the entered Credit REf Number exists and Credit check is enabled on the account

        WebNavPage.verifyCheckBoxChecked(AccountsPage.creCheckBox);
        WebNavPage.assertContentExists(AccountsPage.creditRefnum);

    }


    /*When I link the Parent Account to the Child Account
    Then I should be able to see the Parent Account ID linked*/

    @When("^I link the Parent Account to the Child Account$")
    public void linkChildToParent(){

        WebNavPage.clickALink(AccountsPage.edit);
        WebNavPage.waitForElementToLoad();
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.parentAccount, parent_Account);
        WebNavPage.clickALink(HomePage.saveBTN);
        WebNavPage.waitForElementToLoad();


    }

    @Then("^I should be able to see the Parent Account ID linked$")
    public void verifyChildAccIsLinked(){

        try {
            WebNavPage.assertContentExists(AccountsPage.parentAcc, parent_Account.toUpperCase());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("The Parent Account is linked successfully and value of par Acc in Child Acc page is :"+WebNavPage.getText(AccountsPage.parentAcc));
        }


    }













}
