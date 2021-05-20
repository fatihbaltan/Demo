package com.devapi.currencycloud.step_definitions;

import com.devapi.currencycloud.utilities.ApiUtils;
import io.cucumber.java.en.*;

public class ApiStepDefinitions {

    @Given("Given I logged CurrencyCloud api using login_id and api_key")
    public void given_I_logged_CurrencyCloud_api_using_login_id_and_api_key() {
        String authToken = ApiUtils.generateToken();
    }

    @When("Create a quote for Selling {string} and buying {string} using the {string} side")
    public void create_a_quote_for_Selling_and_buying_using_the_side(String buyCurrency, String sellCurrency, String fixedCurrency) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Verify the buy amount is correct to the rate")
    public void verify_the_buy_amount_is_correct_to_the_rate() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
