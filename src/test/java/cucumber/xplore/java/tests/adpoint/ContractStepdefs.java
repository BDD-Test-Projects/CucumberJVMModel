package cucumber.xplore.java.tests.adpoint;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.pageobjects.adpoint.Clients;
import com.newsint.xplore.qa.pageobjects.adpoint.Contracts;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 18/04/13
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class ContractStepdefs {

    public static String AgencyName;
    public static final String Ref_no = "2013Spring";

    @And("^I make a Contract$")
    public void makeANewContract(){

        createAContract("Client");

    }

    @When("^I look into the Clients profile$")
    public void goToClientsProfile(){

       String ClientLocator = "//a[contains(text(),'"+ClientStepdefs.CustName+"')]";
       WebNavPage.clickALink(ClientLocator);
       WebNavPage.waitForElementToLoad();

    }

    @Then("^I should see the new contract$")
    public void ensureContractCreated(){

        WebNavPage.clickALink(Clients.ContracTab);
        WebNavPage.waitForElementToLoad();
        WebNavPage.clickALink(Clients.Detail);
        WebNavPage.waitForElementToLoad();
        WebNavPage.assertContentExists("//span[@id='ctl00_body_lblRefNo']", Ref_no );

    }






    public static void createAContract(String typeOfBooking){

        WebNavPage.clickALink(Clients.NewContract);
        WebNavPage.waitForElementToLoad();
        WebNavPage.enterAnyTextInAField(Contracts.Ref_No, Ref_no);

        if (typeOfBooking.equalsIgnoreCase("Agency")){
            WebNavPage.enterAnyTextInAField(Contracts.Agency, AgencyName);
            WebNavPage.selectAnOptionFromAList("Agency", Contracts.InvoiceTo);
        }

        WebNavPage.selectAnOptionFromAList("Customer", Contracts.InvoiceTo);
        WebNavPage.waitForShortSpan();
        //WebNavPage.enterAnyTextInAField(Contracts.Period_From, setDate());
        WebNavPage.enterAnyTextInAField(Contracts.TotalNetAmount, "9999");
        WebNavPage.checkACheckBox(Contracts.TotalNetAmt_Unlimited);
        WebNavPage.checkACheckBox(Contracts.Unlimited_AdCount);
        //WebNavPage.selectAnOptionFromAList("Prepared", Contracts.Status);
        WebNavPage.checkACheckBox(Contracts.RateCard_Contract);
        WebNavPage.waitForShortSpan();
        WebNavPage.clickALink(Contracts.Save);
        WebNavPage.waitForElementToLoad();
        if (WebNavPage.elementWithXPathExists(Contracts.Price_Err_Msg)){
            WebNavPage.checkACheckBox(Contracts.TotalNetAmt_Unlimited);
            WebNavPage.enterAnyTextInAField(Contracts.TotalNetAmount, "123");
            WebNavPage.checkACheckBox(Contracts.TotalNetAmt_Unlimited);
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink(Contracts.Save);
            WebNavPage.waitForElementToLoad();
        }else if (WebNavPage.elementWithXPathExists(Contracts.UnLtd_AdCount_Err)){
            WebNavPage.enterAnyTextInAField(Contracts.AdCount, "99999");
            WebNavPage.checkACheckBox(Contracts.Unlimited_AdCount);
            WebNavPage.waitForShortSpan();
            WebNavPage.clickALink(Contracts.Save);
            WebNavPage.waitForElementToLoad();
        }
        Assert.assertTrue("Contract is not created", WebNavPage.elementWithXPathExists("//span[contains(text(), 'Contract detail')]"));

    }


    public String setDate(){

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYY");
        Date date = new Date();
        String CurrentDate = dateFormat.format(date);
        System.out.println(CurrentDate+"is the current date in dd/mm/yyyy format");

    return CurrentDate;



    }


}
