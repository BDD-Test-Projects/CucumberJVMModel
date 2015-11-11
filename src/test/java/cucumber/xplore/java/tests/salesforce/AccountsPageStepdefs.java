package cucumber.xplore.java.tests.salesforce;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.salesforce.AccountsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.ContactsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static cucumber.xplore.java.tests.SharedDriver.getDriver;


/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 02/07/12
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
public class AccountsPageStepdefs {

    public static String accountNameToBeCreated = "acc"+System.currentTimeMillis();
    String parentAccountName = "Parent Account" +System.currentTimeMillis();
    public static String contactNameToBeUsedInCreatingAnOpportunity;
    ContactsStepdefs contacts = new ContactsStepdefs();

//    @And("^create an account$")
//    public void createAnAccountFromCreateNewDropdown() throws Exception {
//
//        clickOnAccountsFromTheCreateNewDropdown();
//        verifyAccountHeading();
//        createAnAccountWithMandatoryFields();
//        verifyNewAccountCreated();
//    }

    @And("^I can click on the Accounts option from the CreateNew dropdown list$")
    public void clickOnAccountsFromTheCreateNewDropdown() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.accountOptionFromDropdown);
    }

    @Then("^I am on the NewAccount page$")
    public void verifyAccountHeading() throws Exception {

        WebNavPage.assertContentExists(AccountsPage.accountOwner, "Test User");
    }

    @And("^I create an account$")
    public void createAnAccount() throws Exception {

        createAnAccountWithMandatoryFields();
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @And("^I do not enter any of the mandatory fields to create an account$")
    public void doNotEnterAnyMandatoryFieldsOnAccountsPage() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.accountOptionFromDropdown);
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @Then("^a new account is successfully created$")
    public void verifyNewAccountCreated() throws Exception {

        WebNavPage.assertContentExists(AccountsPage.accountNameCreated, accountNameToBeCreated);
    }

    @Then("^I get errors on the accounts page$")
    public void errorsOnAccountsPage() throws Exception {

        WebNavPage.assertContentExists(AccountsPage.errorMessageEnterAValue, "You must enter a value");
    }

    @And("^I log out$")
    public void logOut() throws Exception {

        WebNavPage.clickALink("//div[@id='userNav-arrow']");
        WebNavPage.clickALink(HomePage.userLogoutBTN);
        WebNavPage.closeBrowser();
    }

    @And("^I create a parent account$")
    public void createParentAccount() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.accountOptionFromDropdown);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.accountName, parentAccountName);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.phone, "01212121212");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.website, "www.parent.com");

        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingStreet, "street");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingCity, "city");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingPostcode, "W6 9HP");

        Select selectType = new Select(getDriver().findElement(By.cssSelector(AccountsPage.type)));
        selectType.selectByVisibleText("Agency");

        Select selectRegion = new Select(getDriver().findElement(By.xpath(AccountsPage.region)));
        selectRegion.selectByVisibleText("Key Account");
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @And("^I go to a contact which was linked to an account$")
    public void goToContactPageLinkedToAnAccount() throws Exception {

        createAnAccountWithMandatoryFields();
        WebNavPage.clickALink(HomePage.saveBTN);
        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.contactsOptionFromDropdown);
//        WebNavPage.assertContentExists(ContactsPage.contactInfoTopOfPage, "Contacts not associated with accounts are private and cannot be viewed by other users or included in reports.");
        contacts.createAContact();
        contactNameToBeUsedInCreatingAnOpportunity = WebNavPage.getText(ContactsPage.contactPageHeading);
//        System.out.println("*********************************"+contactNameToBeUsedInCreatingAnOpportunity+"*************************************");
        WebNavPage.clickALink(ContactsPage.accountNameCreated);
        WebNavPage.clickALink(HomePage.editBTN);
        WebNavPage.checkACheckBoxWithCssLocator(AccountsPage.creditCheckPassed);
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @And("^dealerID is generated$")
    public void verifyDealerIDGenerated() throws Exception{

        WebNavPage.elementWithXPathShouldBePresent(AccountsPage.dealerID);
    }

    @Then("^I create a new account and add the parent account to it$")
    public void createAnAccountWithParentAccountAdded() throws Exception {

        createAnAccountWithMandatoryFields();
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.parentAccount, parentAccountName);
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @When("^I click the View Hierarchy link$")
    public void clickViewHierarchyLink() throws Exception {

         WebNavPage.clickALink(AccountsPage.viewHierarchyLink);
    }

    @Then("^I can see the account hierarchy page$")
    public void viewHierarchy() throws Exception {

        WebNavPage.assertContentExists(AccountsPage.accountHierarchyHeading, "Account Hierarchy");
    }

    public static void createAnAccountWithMandatoryFields() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.accountOptionFromDropdown);
        if (WebNavPage.elementWithXPathExists(AccountsPage.accRecordType)){
            WebNavPage.selectingAnOptionFromList("SundayDriving Account", AccountsPage.accRecordType);
            WebNavPage.clickALink(AccountsPage.continueBTN);
            WebNavPage.waitForElementToAppear(AccountsPage.newAccBTN);
            WebNavPage.enterAnyTextInAField("//input[@id='q']","xxx" );
            WebNavPage.clickALink(AccountsPage.newAccBTN);
            WebNavPage.waitForElementToAppear(AccountsPage.accountName);
        }
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.accountName, accountNameToBeCreated);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.phone, "01234567890");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.website, "www.test.com");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingStreet, "street");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingCity, "city");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(AccountsPage.billingPostcode, "W6 9HP");
        WebNavPage.selectingAnOptionFromList("Agency", AccountsPage.type);
        WebNavPage.selectingAnOptionFromList("West Midlands", AccountsPage.region);



        /*Select selectType = new Select(getDriver().findElement(By.cssSelector(AccountsPage.type)));
        selectType.selectByVisibleText("Agency");*/
       /* Select selectRegion = new Select(getDriver().findElement(By.xpath(AccountsPage.region)));
        selectRegion.selectByVisibleText("West Midlands");*/

    }



}
