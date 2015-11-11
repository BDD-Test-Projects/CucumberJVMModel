package cucumber.xplore.java.tests.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 21/06/12
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public class SampleStepDefs {

    /* Given I am on some page
And I login with "appropriate" credentials
Then I set "something" on the page
When I perform an "action"
Then I should get the relevant results*/

    @Given("^I am on some page$")
    public void goToSomePage(){
        System.out.println("A Browser will be open and some page will be launched");
        System.out.println("The Env Tag supplied was :"+System.getProperty("env"));
    }

    @And("^I log in with \"([^\"]*)\" credentials$")
    public void loginWithGivenCredentials(String CrendentialsType){

        String Credentials = CrendentialsType; // This might be a  key or url or value to be used in the function

        System.out.println("USer will be logged with the"+Credentials+"Credentials");

    }

    @Then("^I set \"([^\"]*)\" on the page$")
    public void setSomeThingOnThePage(String Something){

        System.out.println("USer would need to set "+Something+"on the page");

    }

    @When("^I perform an \"([^\"]*)\"$")
    public void performTheSpecifiedAction(String ActionType){

        String type = ActionType;

        System.out.println("User will perform the specified"+type);

    }

    @Then("^I should get the relevant results$")
    public void verifyProperResultsIsShown(){

        System.out.println("User will displayed with the specified or respective results for the action performed in the prev steps");
    }


}
