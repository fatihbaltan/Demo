package com.devapi.currencycloud.step_definitions;

import com.devapi.currencycloud.utilities.ApiUtils;
import com.devapi.currencycloud.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepDefinitions {
    String authToken;
    Response response;

    @Given("Given I logged CurrencyCloud api using login_id and api_key")
    public void given_I_logged_CurrencyCloud_api_using_login_id_and_api_key() {
       authToken = ApiUtils.generateToken();
    }

    @When("Create a quote for Selling GBP and buying USD using the sell side")
    public void create_a_quote_for_Selling_GBP_and_buying_USD_using_the_sell_side() {
        double money = 1000;
        response = given()
                .and().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().header("X-Auth-Token", authToken)
                .and().queryParam("buy_currency", "USD")
                .and().queryParam("sell_currency", "GBP")
                .and().queryParam("amount", String.valueOf(money))
                .and().queryParam("fixed_side", "sell")
                .when().get(ConfigurationReader.get("uri") + "/v2/rates/detailed");

    }

    @Then("Verify the buy amount is correct to the rate")
    public void verify_the_buy_amount_is_correct_to_the_rate() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
