package com.devapi.currencycloud.step_definitions;

import com.devapi.currencycloud.utilities.ApiUtils;
import com.devapi.currencycloud.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ApiStepDefinitions {
    String authToken;
    Response response;
    double amount=1000.00;
    double money;

    @Given("I logged CurrencyCloud api using login_id and api_key")
    public void I_logged_CurrencyCloud_api_using_login_id_and_api_key() {
       authToken = ApiUtils.generateToken();
    }


    @When("Create a quote for Selling {string} and buying {string} using the {string} side")
    public void create_a_quote_for_Selling_and_buying_using_the_side_and(String buyCurrency, String sellCurrency, String fixedSide) {
        response = given()
                .and().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().header("X-Auth-Token", authToken)
                .and().queryParam("buy_currency", buyCurrency)
                .and().queryParam("sell_currency", sellCurrency)
                .and().queryParam("amount", String.valueOf(money))
                .and().queryParam("fixed_side", fixedSide)
                .when().get(ConfigurationReader.get("uri") + "/v2/rates/detailed");
    }


    @Then("Verify the buy amount is correct to the rate")
    public void verify_the_buy_amount_is_correct_to_the_rate() {
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),ContentType.JSON);
        amount = Double.valueOf(response.path("client_rate")) *money;
        assertEquals(response.path( "client_buy_amount"),String.valueOf(amount));
    }


    @Then("Verify the buy amount is not correct to the rate")
    public void verify_the_buy_amount_is_not_correct_to_the_rate() {
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),ContentType.JSON);
        //instead of correct rate, core rate is used to calculate total amount
        double amount = Double.valueOf(response.path("core_rate")) *money;
        assertNotEquals(response.path( "client_buy_amount"),String.valueOf(amount));
    }

    @Then("End the API Session")
    public void end_the_API_Session() {
        given()
                .header("X-Auth-Token", authToken)
                .when().post(ConfigurationReader.get("uri") + "/v2/authenticate/close_session");

    }


}
