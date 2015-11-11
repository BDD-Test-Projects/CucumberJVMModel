package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.adpoint.Clients;
import com.newsint.xplore.qa.pageobjects.adpoint.Contacts;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 23/04/13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class ContactStepdefs {


    @When("^a Contact is created$")
    public void contactForClient(){
        createAContact();
    }

    @And("^I navigate to (.*) Tab$")
    public void navigateToTab(String tabName){
        String tabLocator = "//span[contains(text(), '"+tabName+"')]";
        WebNavPage.clickALink(tabLocator);
        WebNavPage.waitForElementToLoad();
    }


    @Then("^I should see the new contact$")
    public void ensureContactExists(){

        verifyContactCreated();
    }



    public static void createAContact(){

        WebNavPage.clickALink(Clients.NewContact);
        WebNavPage.waitForElementToLoad();
        WebNavPage.selectAnOptionFromAList("Mr.", Contacts.Title);
        WebNavPage.enterAnyTextInAField(Contacts.FirstName, "Automation");
        WebNavPage.enterAnyTextInAField(Contacts.LastName, "Tester");
        WebNavPage.enterAnyTextInAField(Contacts.Position, "Senior Consultant");
        WebNavPage.enterAnyTextInAField(Contacts.Mobile, "07799123789");
        WebNavPage.enterAnyTextInAField(Contacts.Email, "info@xploreautomationinc.com");
        WebNavPage.selectAnOptionFromAList("General manager", Contacts.Category);
        WebNavPage.clickALink(Contacts.Save);
        WebNavPage.waitForElementToLoad();

    }

    public void verifyContactCreated(){

        //WebNavPage.clickALink(Clients.ContactTab);
        WebNavPage.waitForElementToLoad();
        WebNavPage.assertContentExists("//div[@class='contact-name']", "Mr. Automation Tester");






    }



}
