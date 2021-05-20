Feature: Creating quotation
  @Background:
  Given  Given I logged CurrencyCloud api using login_id and api_key
@wip
  Scenario:  Create quote and verify the amount is correct
    When Create a quote for Selling GBP and buying USD using the sell side
    Then Verify the buy amount is correct to the rate