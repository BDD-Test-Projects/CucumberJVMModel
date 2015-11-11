package cucumber.xplore.java.tests.salesforce;

import com.newsint.xplore.qa.functlib.WebNavPage;
import com.newsint.xplore.qa.envparameters.EnvironmentURLs;
import com.newsint.xplore.qa.pageobjects.salesforce.HomePage;
import com.newsint.xplore.qa.pageobjects.salesforce.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 28/06/12
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
public class LoginPageStepdefs {

    WebElement element;

    @Given("^I am on Salesforce login page$")
    public void goToSalesforceLoginPage() throws Exception {

        WebNavPage.openWebPage(EnvironmentURLs.SalesforceLoginPage);
    }

    @Given("^I log in$")
    public void loginForCreatingOtherData() throws Exception {

        WebNavPage.openWebPage(EnvironmentURLs.SalesforceLoginPage);
        login();
        verifyLoggedIn();
    }

    @Given("^I log in as Sales Support User$")
    public void loginAsSalesSupportUser() throws Exception {

        loggingInAsAParticularUser(HomePage.salesSupportUserLink, "Sales Support User");

//        WebNavPage.openWebPage(EnvironmentURLs.SalesforceLoginPage);
//        login();
//        verifyLoggedIn();
//
//        WebNavPage.clickALink(HomePage.salesSupportUserLink);
//        verifyLoginButtonPresent();
//        WebNavPage.clickALink(HomePage.loginBTNForDifferentUsers);
//        verifyLoggedInAsAParticularUser("Sales Support User");
    }

    @Given("^I log in as North East Sales User$")
    public void loginAsNorthEastSalesUser() throws Exception {

        loggingInAsAParticularUser(HomePage.northEastSalesUserLink, "NorthEast Sales ...");

    }

    @And("^I enter valid user credentials$")
    public void logMeIn() throws Exception {

        login();
    }

    @When("^I click on the Customer Services User link$")
    public void clickOnCustomerServicesUserLink() throws Exception {

        WebNavPage.clickALink(HomePage.customerServicesUserLink);
    }

    @When("^I click on the Sales Support User link$")
    public void clickOnSalesSupportUserLink() throws Exception {

        WebNavPage.clickALink(HomePage.salesSupportUserLink);
    }

    @When("^I click on the North East Sales User link$")
    public void clickOnNorthEastSalesUserLink() throws Exception{

        WebNavPage.clickALink(HomePage.northEastSalesUserLink);
    }

    @When("^I click on the Head of Dealer Sales link$")
    public void clickOnHeadOfDealerSalesUserLink() throws Exception {

        WebNavPage.clickALink(HomePage.headOfDealerSalesLink);
    }

    @Then("^I am successfully logged in$")
    public void successfullyLoggedIn() throws Exception {

        verifyLoggedIn();
    }

    @Then("^am taken to the customer Services User Logon page$")
    public void verifyLoginButtonPresentOnCustomerServiceLogonPage() throws Exception {

        verifyLoginButtonPresent();
    }

    @Then("^am taken to the Sales Support User Logon page$")
    public void verifyLoginButtonPresentOnSupportUserLogonPage() throws Exception {

        verifyLoginButtonPresent();
    }

    @Then("^am taken to the North East Sales Logon page$")
    public void verifyLoginButtonPresentOnNorthEastSalesUserLogonPage() throws Exception {

        verifyLoginButtonPresent();
    }

    @Then("^am taken to the Head of Dealer Sales Logon page$")
    public void verifyLoginButtonPresentOnHeadOfDealerSalesLogonPage() throws Exception {

        verifyLoginButtonPresent();
    }

    @Then("^I am successfully logged in as Customer Services User$")
    public void verifyLoggedInAsCustomerServicesUser() throws Exception {

        verifyLoggedInAsAParticularUser("Customer Service...");
    }

    @Then("^I am successfully logged in as Sales Support User$")
    public void verifyLoggedInAsSalesSupportUser() throws Exception{

        verifyLoggedInAsAParticularUser("Sales Support User");
    }

    @Then("^I am successfully logged in as North East Sales User$")
    public void verifyLoggedInAsNorthEastSalesUser() throws Exception {

        verifyLoggedInAsAParticularUser("NorthEast Sales ...");
    }

    @Then("^I am successfully logged in as Head of Dealer Sales$")
    public void verifyLoggedInAsHeadOfDealerSales() throws Exception {

        verifyLoggedInAsAParticularUser("Head of Dealer S...");
    }

    @When("^I click on the Login Button$")
    public void clickLoginButton() throws Exception {

          WebNavPage.clickALink(HomePage.loginBTNForDifferentUsers);
    }

    @And("^I can successfully logout as Customer Services User$")
    public void logoutCustomerServicesUser() throws Exception {

        logoutAsAParticularUser();
    }

    @And("^I can successfully logout as Sales Support User$")
    public void logoutSalesSupportUser() throws Exception {

        logoutAsAParticularUser();
    }

    @And("^I can successfully logout as North East Sales User$")
    public void logoutNorthEastSalesUser() throws Exception{

        logoutAsAParticularUser();
    }

    @And("^I can successfully logout as Head of Dealer Sales$")
    public void logoutHeadOfDealerSales() throws Exception {

        logoutAsAParticularUser();
    }

    public void login() throws Exception {

        WebNavPage.enterAnyTextInAFieldWithCssLocator(LoginPage.username, EnvironmentURLs.User_valid_salesforce);
        WebNavPage.enterAnyTextInAFieldWithCssLocator(LoginPage.password, EnvironmentURLs.Password_valid_salesforce);
        WebNavPage.checkACheckBoxWithCssLocator(LoginPage.rememberMeCheckbox);
        WebNavPage.clickALinkWithCssLocator(LoginPage.loginBTN);
    }

    public void verifyLoggedIn() throws Exception {

        String xpathTestUserLink = "//span[@id='userNavLabel'][contains(text(), 'Admin User')]";
        WebNavPage.elementWithXPathShouldBePresent(xpathTestUserLink);
    }

    public void logoutAsAParticularUser() throws Exception{

        WebNavPage.clickALink("//div[@id='userNav-arrow']");
        WebNavPage.clickALink(HomePage.userLogoutBTN);
        WebNavPage.elementWithXPathShouldBePresent("//span[@id='userNavLabel'][contains(text(), 'Test User')]");
    }

    public void verifyLoginButtonPresent() throws Exception {

        WebNavPage.elementWithXPathShouldBePresent(HomePage.loginBTNForDifferentUsers);
    }

    public void verifyLoggedInAsAParticularUser(String usernameOfLoggedInUser) throws Exception {

        WebNavPage.elementWithXPathShouldBePresent("//span[@id='userNavLabel'][contains(text(), usernameOfLoggedInUser)]");
    }

    public void loggingInAsAParticularUser(String userLinkOnHomePageOnLHS, String usernameToVerifyLoggedInSuccessfully) throws Exception {

        WebNavPage.openWebPage(EnvironmentURLs.SalesforceLoginPage);
        login();
        verifyLoggedIn();
        WebNavPage.clickALink(userLinkOnHomePageOnLHS);
        verifyLoginButtonPresent();
        WebNavPage.clickALink(HomePage.loginBTNForDifferentUsers);
        verifyLoggedInAsAParticularUser(usernameToVerifyLoggedInSuccessfully);

    }
}

