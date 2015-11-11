package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.functlib.XmlReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 24/04/13
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class DataSettingStepdefs {


    /*
    This is mainly for the function methods that will be used for Data Setting
    */


    public static void dataSetUpForDisplayAd(){


        /*
        * */

        Map<String, String> DisplayAd = new HashMap<String, String>();
        DisplayAd.put("Edition", XmlReader.readXMLFile("Display_Ads", "Edition"));
        System.out.println("the Value of Edition is :"+ DisplayAd.get("Edition"));
        createAnEdition(XmlReader.readXMLFile("Display_Ads", "Edition"));


    }


    public static void dataSetupForOnlineAd(){



    }


    public static void createAnEdition(String edition){

        navigateToSettings();
        WebNavPage.clickALink("//a[@id='ctl00_body_hlEditions']");
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink("//input[@id='ctl00_body_btnNewLocal']");
        WebNavPage.waitForShortSpan();
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbName']",edition);
        WebNavPage.selectAnOptionFromAList("NI", "//select[@id='ctl00_body_cmbOffice']");
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbPageSize']", "9000");
        WebNavPage.enterAnyTextInAField("//input[@id='ctl00_body_tbDispOrder']", "1");
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink("//input[@id='ctl00_body_btnSave']");

    }

    public static void navigateToSettings(){

        WebNavPage.clickALink("//span[contains(text(), 'Tools')]");
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink("//a[contains(text(), 'Settings')]");
        WebNavPage.waitForShortSpan();
    }



}
