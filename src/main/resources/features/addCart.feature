Feature: Add to cart

  Scenario: User add item to cart
    Given user is loggedin on inventory page
    When user click add to cart
    Then cart item increment
