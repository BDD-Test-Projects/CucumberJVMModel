package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.functlib.XmlReader;
import com.newsint.xplore.qa.pageobjects.adpoint.AdPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 16/05/13
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
public class PlaceAdStepdefs {


    @When("^I place an (.*) Ad$")
    public void creatAd(String Adtype){

        if (Adtype.equalsIgnoreCase("digital")){
            createADisplayAd();
        }else if (Adtype.equalsIgnoreCase("online")){
            createAnOnlineAd();
        }

    }

    @Then("^I should be able to see the (.*) ads$")
    public void verifyAdCreated(String Adtype){

        if (Adtype.equalsIgnoreCase("digital")){
            verifyDigitalAdCreated();
        }else if (Adtype.equalsIgnoreCase("online")){
            verifyOnlineAdCreated();
        }
    }


    public static void createADisplayAd(){

        WebNavPage.clickALink(AdPage.AddDisplayAd);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectingAnOptionFromList(XmlReader.readXMLFile("Display_Ads", "Edition"), AdPage.Ad_Edition);
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField(AdPage.Ad_Ref, XmlReader.readXMLFile("Display_Ads", "Ad_Ref"));
        WebNavPage.waitForShortSpan();
        WebNavPage.selectingAnOptionFromList("Test - CoverPage", AdPage.SectionGroup);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectingAnOptionFromList(XmlReader.readXMLFile("Display_Ads", "Section"), AdPage.Section);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectingAnOptionFromList(XmlReader.readXMLFile("Display_Ads", "Ad_Size"), AdPage.Ad_Size);
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink(AdPage.Create_New_Material);
        WebNavPage.waitForElementToLoad();
        WebNavPage.selectAnOptionFromAList("Email", AdPage.RecievedBy);
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink(AdPage.Save_NewMaterial);
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink(AdPage.Save);
        WebNavPage.waitForElementToLoad();

    }

    public static void createAnOnlineAd(){

        WebNavPage.clickALink(AdPage.AddOnlineAd);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectAnOptionFromAList("XploreAutomationNetwork",AdPage.Network);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectAnOptionFromAList("Xplore SubNet", AdPage.SubNetwork);
        WebNavPage.waitForShortSpan();
        WebNavPage.clearAnyField("//input[@id='ctl00_body_dtFromTo_tbStartDate']");
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_dtFromTo_tbStartDate']", WebNavPage.returnFutureDate(1));
        WebNavPage.waitForShortSpan();
        WebNavPage.selectAnOptionFromAList("Test - CoverPage", AdPage.SalesPackageGroup);
        WebNavPage.waitForShortSpan();
        /*//WebNavPage.waitForShortSpan();
        //WebNavPage.selectAnOptionFromAList("XA SalesPackage 1", AdPage.SalesPackage);
        //WebNavPage.waitForShortSpan();
        //WebNavPage.selectAnOptionFromAList("XA AdSize 1", AdPage.AdSize_OA);
        //WebNavPage.waitForShortSpan();*/
        WebNavPage.selectAnOptionFromAList("XA Online Type 1", AdPage.OnineAdType);
        WebNavPage.waitForShortSpan();
        WebNavPage.selectAnOptionFromAList("autouser", AdPage.PrimaryTrafficker);
        WebNavPage.waitForShortSpan();
        WebNavPage.waitForShortSpan();
        WebNavPage.selectAnOptionFromAList("autouser", AdPage.SecTrafficker);
        WebNavPage.waitForShortSpan();
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField(AdPage.Ad_Quantity, "1000");
        WebNavPage.clickALink(AdPage.OnlineAdRef);
        WebNavPage.waitForShortSpan();
        WebNavPage.waitForShortSpan();

        //Addin Invoice Options to Online Ads///
        WebNavPage.selectAnOptionFromAList("Monthly", "//select[@id='ctl00_body_InvoiceDateSchedulerCtrl_cmbPreset']");
        WebNavPage.waitForShortSpan();
        //Adding New Materials //
        try {
            WebNavPage.clickALink(AdPage.AddNewMaterial_OA);
            WebNavPage.waitForShortSpan();
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        WebNavPage.clickALink(AdPage.CreatNewMaterial_OA);
        WebNavPage.waitForElementToLoad();
        WebNavPage.selectAnOptionFromAList("Email", AdPage.RecievedByOnline);
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink(AdPage.Save_NewMaterial_OA);
        WebNavPage.waitForElementToLoad();
        WebNavPage.clickALink(AdPage.Apply_CreatedMaterial_OA);
        WebNavPage.waitForElementToLoad();
        // End of Add Materials //
        WebNavPage.checkACheckBox(AdPage.Windows7_Os);
        WebNavPage.checkACheckBox(AdPage.Windows8_Os);
        WebNavPage.checkACheckBox(AdPage.Apple_Os);
        WebNavPage.checkACheckBox(AdPage.Android_Os);
        WebNavPage.checkACheckBox(AdPage.FireFox_Browser);
        WebNavPage.checkACheckBox(AdPage.Chrome_Browser);
        WebNavPage.checkACheckBox(AdPage.Monday_DOW);
        WebNavPage.checkACheckBox(AdPage.TimeofDay1);
        WebNavPage.checkACheckBox(AdPage.Save_OnlineAd);
        WebNavPage.waitForElementToLoad();
    }

    public static void verifyDigitalAdCreated(){

        WebNavPage.assertContentExists("//span[@id='ctl00_body_lblDACount']", "1");

    }

    public static void verifyOnlineAdCreated(){
        WebNavPage.assertContentExists("//span[@id='ctl00_body_lblOACount']", "1");

    }

}
