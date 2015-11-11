package cucumber.xplore.java.tests.salesforce;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.salesforce.AccountsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.ContactsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.HomePage;
import com.newsint.xplore.qa.pageobjects.salesforce.OpportunityPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static cucumber.xplore.java.tests.SharedDriver.getDriver;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 06/07/12
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public class OpportunityPageStepdefs {

    String opportunityNameToBeCreated = "opp"+System.currentTimeMillis();
    AccountsPageStepdefs account = new AccountsPageStepdefs();

    @And("^I can click on the Opportunity option from the CreateNew dropdown list$")
    public void clickOnOpportunityFromTheCreateNewDropdown() throws Exception {

//        accountToBeUsedInCreatingOpportunity = WebNavPage.getText(AccountsPage.accountNameCreated);
        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.opportunityFromDropdown);
    }

    @Then("^I am on the NewOpportunity page$")
    public void verifyOpportunityHeading() throws Exception {

        WebNavPage.assertContentExists(OpportunityPage.opportunityPageHeading, "New Opportunity");
    }

    @And("^I create an opportunity with an account which has not passed credit check$")
     public void createAnOpportunityWithAccountCreditCheckNotPassed() throws Exception {

         createAnOpportunity();
    }

    @And("^I create an opportunity with an account which has passed credit check$")
    public void createAnOpportunityWithAccountCreditCheckPassed() throws Exception {

        createAnOpportunityWithCreditCheckPassed();
    }

    @And("^I create an opportunity successfully$")
    public void createAnOpportunityFromScratch() throws Exception {

        WebNavPage.clickALink(ContactsPage.accountNameCreated);
        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.opportunityFromDropdown);
        WebNavPage.assertContentExists(OpportunityPage.opportunityPageHeading, "New Opportunity");

        createAnOpportunityWithCreditCheckPassed();
    }

    @And("^I do not enter any of the mandatory fields to create an opportunity$")
    public void doNotEnterAnyMandatoryFieldsOnOpportunityPage() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.opportunityFromDropdown);
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @Then("^I get an error stating credit check not passed$")
    public void errorMessageCreditCheckNotPassed() throws Exception {

        String errorText = "Error: Invalid Data. \n"+
                            "Review all error messages below to correct your data.\n"+
                            "An opportunity can be created only if the account has passed credit check";
        WebNavPage.assertContentExists(HomePage.errorMessage, errorText);
    }

    @Then("^I add products to this opportunity$")
    public void addProducts() throws Exception {

        WebNavPage.clickALink(OpportunityPage.addProductBTN);
        WebNavPage.checkACheckBox(OpportunityPage.standardProduct);
        WebNavPage.clickALink("//input[@name='edit']");
        WebNavPage.enterAnyTextInAField("//input[@id='00NS00000013vCg01uS0000003IraE']", "2");
        WebNavPage.enterAnyTextInAField("//input[@id='00NS00000013vCa01uS0000003IraE']", "1000.00");
        WebNavPage.enterAnyTextInAField("//input[@id='00NS00000013vCe01uS0000003IraE']", "10");

        WebNavPage.clickALink(HomePage.saveBTN);

    }

    @Then("^I get errors on the opportunity page$")
    public void errorsOnOpportunityPage() throws Exception {

        WebNavPage.assertContentExists(OpportunityPage.errorMessageEnterAValue, "You must enter a value");
    }

    @Then("^a new opportunity is successfully created$")
    public void verifyNewOpportunityCreated() throws Exception {

        WebNavPage.assertContentExists(OpportunityPage.opportunityPageHeading, opportunityNameToBeCreated);
    }

    @And("^get the opportunity approved$")
    public void approveOpportunity() throws Exception {

        WebNavPage.clickALink(OpportunityPage.submitForApprovalBTN);
        WebNavPage.handleDialogPopUp();

        WebNavPage.clickALink(HomePage.headOfDealerSalesLink);
        WebNavPage.elementWithXPathShouldBePresent(HomePage.loginBTNForDifferentUsers);
        WebNavPage.clickALink(HomePage.loginBTNForDifferentUsers);
        WebNavPage.elementWithXPathShouldBePresent("//span[@id='userNavLabel'][contains(text(), Head of Dealer S...)]");

        WebNavPage.clickALink("//a[@class='actionLink'][contains(text(), 'Approve / Reject')]");
        WebNavPage.clickALink("//input[@value='Approve']");

        WebNavPage.clickALink("//div[@id='userNav-arrow']");
        WebNavPage.clickALink(HomePage.userLogoutBTN);
        WebNavPage.elementWithXPathShouldBePresent("//span[@id='userNavLabel'][contains(text(), 'Test User')]");

        WebNavPage.clickALink("//li[@id='home_Tab'][contains(text(), 'Home')]");
        WebNavPage.clickALink(HomePage.salesSupportUserLink);
        WebNavPage.elementWithXPathShouldBePresent(HomePage.loginBTNForDifferentUsers);
        WebNavPage.clickALink(HomePage.loginBTNForDifferentUsers);
        WebNavPage.elementWithXPathShouldBePresent("//span[@id='userNavLabel'][contains(text(), Sales Support User)]");
    }

    @Then("^assets are successfully created and account status is Active$")
    public void verifyAssetsCreatedAndAccountStatusActive() throws Exception {

        WebNavPage.clickALink("//tr[@class='dataRow even first']");
        WebNavPage.assertContentExists("//div[@id='00NS0000000z02Y_ileinner']", "Active");

    }


    public void createAnOpportunity() throws Exception {
//        System.out.println("**************************************"+ account.contactNameToBeUsedInCreatingAnOpportunity +"***********************************");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(OpportunityPage.opportunityName, opportunityNameToBeCreated);
        WebNavPage.clickALink(OpportunityPage.closeDate);
        WebNavPage.enterAnyTextInAField(OpportunityPage.contactName, account.contactNameToBeUsedInCreatingAnOpportunity);
        Select stage = new Select(getDriver().findElement(By.cssSelector(OpportunityPage.stage)));
        stage.selectByVisibleText("Meeting/Verbal Quote");
        WebNavPage.clickALink(HomePage.saveBTN);
    }


    public void createAnOpportunityWithCreditCheckPassed() throws Exception {

        createAnOpportunity();
        WebNavPage.clickALink(OpportunityPage.accountName);
        WebNavPage.clickALink(HomePage.editBTN);
        WebNavPage.checkACheckBoxWithCssLocator(AccountsPage.creditCheckPassed);
        WebNavPage.clickALink(HomePage.saveBTN);
    }
}
