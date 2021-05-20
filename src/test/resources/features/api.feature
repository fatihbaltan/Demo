Feature: Creating quotation
@wip
  Scenario:  Authenticate against the API and retrieve a login token
    Given  Given I logged CurrencyCloud api using login_id and api_key
    When Create a quote for Selling GBP and buying USD using the sell side
    Then Verify the buy amount is correct to the rate