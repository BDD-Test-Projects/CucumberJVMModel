package cucumber.xplore.java.tests.salesforce;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.salesforce.AccountsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.ContactsPage;
import com.newsint.xplore.qa.pageobjects.salesforce.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 29/06/12
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
public class ContactsStepdefs {

    String contactFirstNameToBeCreated = "First"+System.currentTimeMillis();
    String contactLastNameToBeCreated = "Last"+System.currentTimeMillis();
    String fullNameContact = contactFirstNameToBeCreated + " " + contactLastNameToBeCreated;
    String firstContactName;

    @When("^I select the Contacts option from the CreateNew dropdown list$")
    public void clickOnContactsFromTheCreateNewDropdown() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.contactsOptionFromDropdown);
    }

    @Then("^I am on the NewContact page$")
    public void verifyContactsHeading() throws Exception {

        WebNavPage.assertContentExists(ContactsPage.contactInfoTopOfPage, "Contacts not associated with accounts are private and cannot be viewed by other users or included in reports.");
    }

    @And("^I click on the Account Name$")
    public void clickOnAccountName() throws Exception {

        WebNavPage.clickALink(ContactsPage.accountNameCreated);
    }

    @And("^I enter all mandatory fields to create a contact$")
    public void enterDataToCreateNewContact() throws Exception {

        createAContact();
    }

    @And("^I create a new contact by clicking on the new button in the contacts section$")
    public void createNewContactByClickingNewBTNOnAccountsPage() throws Exception {

        WebNavPage.clickALink(AccountsPage.newContactBTNOnAccountPage);
        createAContact();
    }

    @And("^I do not enter any of the mandatory fields to create a contact$")
    public void doNotEnterAnyMandatoryFieldsOnContactsPage() throws Exception {

        WebNavPage.clickALinkWithCssLocator(HomePage.createNewDropdown);
        WebNavPage.clickALinkWithCssLocator(HomePage.contactsOptionFromDropdown);
        WebNavPage.clickALink(HomePage.saveBTN);
    }

    @When("^I click on the Contacts link on top of the accounts page$")
    public void clickOnContactsLinkWithinAccountPage() throws Exception {

        WebNavPage.clickALink(AccountsPage.contactsLinkWithinAnAccountPage);
        WebNavPage.assertContentExists(AccountsPage.contactsSectionWithinAccountPage, "Contacts");
    }

    @When("^I mark the contact as Primary$")
    public void markContactAsPrimary() throws Exception {

        WebNavPage.clickALink(ContactsPage.editBTN);
        WebNavPage.checkACheckBox(ContactsPage.primaryContactCheckbox);
        WebNavPage.clickALink(HomePage.saveBTN);
    }

//    @Then("^I can see the contact related with this account$")
//    public void verifyRelatedContactsVisible() throws Exception {
//
//        WebNavPage.assertContentExists(AccountsPage.firstContactRow, fullNameContact);
//    }

    @Then("^a new contact is successfully created$")
    public void verifyNewContactCreated() throws Exception {

        WebNavPage.assertContentExists(ContactsPage.contactPageHeading, fullNameContact);
    }

    @Then("^I get an error message stating Primary contact already exists$")
    public void errorMessagePrimaryContactAlreadyExists() throws Exception {

        String errorText = "Error: Invalid Data.\n" +
                "Review all error messages below to correct your data.\n" +
                firstContactName+ " is already the Primary Contact for this Account";
        WebNavPage.assertContentExists(HomePage.errorMessage, errorText);
    }

    @Then("^I get errors on the contacts page$")
    public void errorsOnContactsPage() throws Exception {

        WebNavPage.assertContentExists(ContactsPage.errorMessageEnterAValue, "You must enter a value");
    }

    @And("^I keep track of the first contact name$")
    public void trackTheFirstContactOnTheAccount() throws Exception {

        firstContactName = WebNavPage.getText(AccountsPage.firstContactRow);
    }

    public void createAContact() throws Exception {

//        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.title, "Ms");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.firstName, contactFirstNameToBeCreated);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.lastName, contactLastNameToBeCreated);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.accountNameToBeCreated, "");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.accountTitle, "Ms");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.phone, "");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.email, "test@test.com");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.billingStreet, "");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.billingCity, "");
        WebNavPage.enterAnyTextInAFieldWithCssLocator(ContactsPage.postcode, "");
        WebNavPage.clickALink(HomePage.saveBTN);
    }
}
