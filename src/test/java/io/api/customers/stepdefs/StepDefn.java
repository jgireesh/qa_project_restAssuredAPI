package io.api.customers.stepdefs;
import io.api.customers.services.PostRequests;
import io.api.customers.services.GetRequests;
import io.api.customers.utils.ConfigUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefn extends GetRequests {
    ConfigUtils configUtils = new ConfigUtils();
    public String endPoint = configUtils.getASpecificProperty("CUSTOMER_GET_URL");

    PostRequests postRequests = new PostRequests();
    @Given("^Send request to Get customer list$")
    public void sendRequest() {
        getRequest(endPoint);
    }

    @When("Verify status code {int}")
    public void verify_status_code(Integer statusCode) {
        verifyStatusCode(statusCode);
    }
    @Then("Response body received for {string} with {string}")
    public void response_body_received_with_first_name(String fieldname, String value) {
        verifyResponseBodyHas(fieldname, value);
    }

    @Given("Send request to Get customer list with Invalid Url")
    public void sendRequestToGetCustomerListWithInvalidUrl() {
        getRequest(endPoint.replace("customers","customer"));
    }

    @Given("Generate post map for the new customer")
    public void generatePostMap() {
        postRequests.generateBodyMap();
    }

    @When("Post a customer")
    public void postACustomer() {
        postRequests.postCustomerRequest(endPoint);
    }
}
