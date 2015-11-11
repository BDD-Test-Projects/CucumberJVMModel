package cucumber.xplore.java.tests.api;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static com.newsint.xplore.qa.api.RestClient.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 18/06/12
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class RestClientStepDefs {

    @Before
    public void setUp() throws Exception {
        // Reset rest client before each test
        clearDown();
    }

    @Before("@queryNoEncoding")
    public static void urlEncodingFalse() {
        setUrlEncoding(false);
    }

    @And("^I want the response format to be json$")
    public static void requestAJSONResponse() {
        setAcceptJSON();
    }

    @And("^I want the response format to be xml$")
    public static void requestAnXMLResponse() {
        setAcceptXML();
    }

    @And("^I want the response format to be mpod$")
    public static void requestAnMPODXMLResponse() {
        setAcceptMPODXML();
    }

    @And("^I want the response format to be unknown$")
    public static void requestAnUnknownResponse() {
        setAcceptUnknown();
    }

    @And("^I request a text response$")
    public static void iRequestATextResponse() {
        setAcceptText();
    }

    @And("^the offset is (\\d+) and the limit is (\\d+)$")
    public static void iRequestAnMPODXMLResponse(int offset, int limit) {
        appendURL("&limit=" + limit + "&offset=" + offset);
    }

    @When("^I perform the request and expect the response code to be (\\d+) and the content-type to match the request$")
    public static void iPerformTheGetRequest(int responseCode) {
        setStatusCode(responseCode);
        performGetRequest();
    }

    @When("^I perform the post request and expect the response code to be (\\d+) and the content-type to match the request$")
    public static void iPerformThePostRequest(int responseCode) {
        setStatusCode(responseCode);
        performPostRequest();
    }

    @When("^I perform the put request and expect the response code to be (\\d+) and the content-type to match the request$")
    public static void iPerformThePittRequest(int responseCode) {
        setStatusCode(responseCode);
        performPutRequest();
    }

    @Then("^I expect the error code (\\d+) with the message '(.*)'$")
    public static void verifyError(int errorCode, String message) {
        setRootPath("Error");
        assertThat(getInt("error.errorCode"), equalTo(errorCode));
        assertThat(getString("error.message"), equalTo(message));
    }

    @And("^I send an invalid body$")
    public static void invalidBody() {
        setRequestBody("invalidBody");
    }


}
