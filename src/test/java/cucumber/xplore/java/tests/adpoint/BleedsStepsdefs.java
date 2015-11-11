package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.functlib.XmlReader;
import com.newsint.xplore.qa.pageobjects.adpoint.AdPage;
import com.newsint.xplore.qa.pageobjects.adpoint.Clients;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.xplore.java.tests.SharedDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 24/06/13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class BleedsStepsdefs {

    public static String BLEEDNAME = "";

    @When("^I make a new Bleed type$")
    public void createANewBleed(){

        DataSettingStepdefs.navigateToSettings();
        SharedDriver.getDriver().get(SharedDriver.getDriver().findElement(By.xpath("//a[@id='ctl00_body_hlBleeds']")).getAttribute("href"));
        WebNavPage.waitForShortSpan();
        createBleed();
    }

    @Then("^I should be able to see the Bleed created$")

    public void verifyBleedCreated(){

        WebNavPage.assertContentExists("//td[contains(text(), '"+BLEEDNAME+"')]", BLEEDNAME);

    }

    @When("^I set a new Bleed and Adsize with Bleeds (.*)$")
    public void createBleedandAdSize(String type){

        DataSettingStepdefs.navigateToSettings();
        WebNavPage.navigateThruHREF("//a[@id='ctl00_body_hlBleeds']");
        WebNavPage.waitForShortSpan();
        createBleed();
        AdsizeStepdefs.createANewAdsize(type);
    }

    @When("^I am in Display Ad page to place$")
    public void navigateToAdBookingForDisplayAds(){

        HomePageStepdefs.clickOnATab("Summary");
        WebNavPage.clickALink(Clients.NewOrder);
        OrdersStepdefs.createAnOrder();
        WebNavPage.clickALink(AdPage.AddDisplayAd);
        WebNavPage.waitForShortSpan();
    }

    @And("^I select the Adsize created$")
    public void fillInAdFormAndSelectAdSize(){

        WebNavPage.selectingAnOptionFromList(XmlReader.readXMLFile("Display_Ads", "Edition"), AdPage.Ad_Edition);
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField(AdPage.Ad_Ref, XmlReader.readXMLFile("Display_Ads", "Ad_Ref"));
        WebNavPage.waitForShortSpan();
        if (WebNavPage.getSelectedOptionFromList(AdPage.Section).contains(XmlReader.readXMLFile("Display_Ads", "Section"))){
            //do nothing !!!
        }else{
            WebNavPage.selectingAnOptionFromList(XmlReader.readXMLFile("Display_Ads", "Section"), AdPage.Section);
        }

        WebNavPage.selectingAnOptionFromList(AdsizeStepdefs.ADSIZENAME, AdPage.Ad_Size);
    }

    @Then("^I should see a new dropdownlist for Bleed types$")
    public void verifyBleedsDropdownListShows(){

        WebNavPage.assertContentExists("//label[@id='ctl00_body_lblBleedType']", "Bleed type");
        WebNavPage.waitForShortSpan();
        WebNavPage.elementWithXPathExists("//select[@id='ctl00_body_ddBleedType']");
    }

    @Then("^Bleed types drop down list should not be displayed$")
    public void verifyBleedsDropDownDoesNotExists(){

       WebNavPage.assertContentDoesNotExist("//span[@id='ctl00_body_lblBleedType']");
       WebNavPage.assertContentDoesNotExist("//select[@id='ctl00_body_ddBleedType']");
    }

    public static void createBleed(){

        BLEEDNAME = "Bleed"+System.currentTimeMillis();
        WebNavPage.clickALink("//input[@id='ctl00_body_btnNew']");
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbName']",BLEEDNAME );
        WebNavPage.clearAnyField("//input[@id='ctl00_body_tbDispOrder']");
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbDispOrder']", "1");
        WebNavPage.clickALink("//input[@id='ctl00_body_btnSave']");
        WebNavPage.waitForShortSpan();

    }





}

