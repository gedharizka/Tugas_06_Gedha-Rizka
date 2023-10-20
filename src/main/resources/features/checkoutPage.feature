Feature: Check out page

  Scenario: User check out from page cart.html
    Given user on page cart.html
    When user click checkout
    Then user redirect to page checkout setp one
