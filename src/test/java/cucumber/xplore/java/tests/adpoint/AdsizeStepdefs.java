package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.functlib.XmlReader;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 26/06/13
 * Time: 16:21
 * To change this template use File | Settings | File Templates.
 */
public class AdsizeStepdefs {

       public static String ADSIZENAME = "XA-AdSize";
       public static int Width = 243;
       public static int Column = 7;
       public static int Height = 340;
       public static String AD_Section = XmlReader.readXMLFile("Display_Ads", "Section");
       public static String AD_Media = XmlReader.readXMLFile("Display_Ads", "Edition");


    public static void createANewAdsize(String BleedsCondition){

        ADSIZENAME = ADSIZENAME + System.currentTimeMillis();


        DataSettingStepdefs.navigateToSettings();
        WebNavPage.navigateThruHREF("//a[@id='ctl00_body_hlAdSizes']");
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink("//input[@id='ctl00_body_btnNew']");
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tabs_tabProperties_tbName']", ADSIZENAME);
        if (BleedsCondition.equalsIgnoreCase("enabled")){
            if (WebNavPage.verifyCheckBoxChecked("//input[@id='ctl00_body_tabs_tabProperties_cbBleed']")!= true){
                WebNavPage.checkACheckBox("//input[@id='ctl00_body_tabs_tabProperties_cbBleed']");
            }
        }
        WebNavPage.selectAnOptionFromAList("Milimeters","//select[@id='ctl00_body_tabs_tabProperties_cmbLengthUnit']");
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbWidthMM']", Width);
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbWidthCol']", Column);
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbHeightMM']", Height);
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbProdWidthMM']", Width);
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbProdWidthCol']", Column);
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbProdHeightMM']", Height);
        if ((WebNavPage.getText("//input[@id='ctl00_body_tabs_tabProperties_tbDispOrder']")).equalsIgnoreCase("1")){

        }
        WebNavPage.clearAnyField("//input[@id='ctl00_body_tabs_tabProperties_tbDispOrder']");
        WebNavPage.enterAnyNumberInAField("//input[@id='ctl00_body_tabs_tabProperties_tbDispOrder']", 1);
        WebNavPage.clickALink("//td/label[contains(text(),'"+AD_Section+"')]");
        WebNavPage.clickALink("//span[contains(text(), 'Available for Media')]");
        WebNavPage.clickALink("//td/label[contains(text(),'"+AD_Media+"')]");
        WebNavPage.clickALink("//span[contains(text(), 'Properties')]");
        WebNavPage.clickALink("//input[@id='ctl00_body_btnSave']");
        WebNavPage.waitForShortSpan();

    }



}
