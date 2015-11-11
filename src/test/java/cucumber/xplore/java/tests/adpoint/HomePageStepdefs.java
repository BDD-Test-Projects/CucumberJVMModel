package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.envparameters.AdPoint;
import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.functlib.XmlReader;
import com.newsint.xplore.qa.pageobjects.adpoint.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 08/04/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class HomePageStepdefs {


    /*Given I am on HomePage
    And I am logged in
    When I scroll to the top of the Page
    Then I should be able to see the all the expected elements*/


    @Given("^I am on Adpoint HomePage$")
    public void launchApp(){

        try {
            WebNavPage.openWebPage(AdPoint.getAdPoint_HomePage());
            //DataSettingStepdefs.dataSetUpForDisplayAd();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @And("^I am logged in to the site$")
    public void verifyUserLoggedIn(){

        WebNavPage.elementWithXPathExists(HomePage.Logout);

    }

    @When("^I scroll to the top of the Page$")
    public void scrollToTop(){
        WebNavPage.refreshPage();
    }

    @Then("^I should be able to see the all the expected elements$")
    public void verifyAllElementsExists(){

        //WebNavPage.assertContentExists("//span[@id = 'ctl00_lblUserInfo']", "Demo User");
        WebNavPage.assertContentExists("//span[@id =" +
                " 'ctl00_Label3']", "Help & Tutorial");
        WebNavPage.assertContentExists("//span[@id = 'ctl00_Label20']", "Tools");
        WebNavPage.assertContentExists("//a[@id = 'ctl00_hlPref']", "My profile");
        WebNavPage.assertContentExists("//a[contains(text(), 'Support')]", "Support");
        WebNavPage.assertContentExists("//a[contains(text(), 'Logout')]", "Logout");

    }


    @When("^I click on (.*) tab$")
    public void clickOnTab(String TabName){

        clickOnATab(TabName);
    }

    @When("^I click on (.*) link$")
    public void clickOnFooter(String LinkName){

        clickOnFooterLink(LinkName);

    }

    @When("^I click Orders tab$")
    public void clickOnOrderstab(){
        WebNavPage.clickALink(HomePage.Orders);
    }

    @When("^I click Orders link$")
    public void clickOnOrderLink(){

        WebNavPage.clickALink(HomePage.Orders_FooterLink);
    }

    @Then("^I should be directed to the (.*) page$")
    public void checkMyPage(String pageName){

        String pageTitle = pageName;
        WebNavPage.assertPageTitle(pageTitle);
    }


    public static void clickOnATab(String TabName){

        String tabToClick = "//span[contains(text(), '"+TabName+"')]";
        WebNavPage.clickALink(tabToClick);
        WebNavPage.waitForElementToLoad();
    }

    public static void clickOnFooterLink(String linkName){

        String footerLink = "//ul/li/a/span[contains(text(),'"+linkName+"')]";
        WebNavPage.clickALink(footerLink);
        WebNavPage.waitForShortSpan();
    }


}
