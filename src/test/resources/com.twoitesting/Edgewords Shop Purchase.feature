@RunThis
  Feature: Edgewords e-commerce site purchase

    Scenario: I can apply a discount code
      Given I have added an item to my cart
      When I apply a discount code
      Then The discount should have been applied

    Scenario: My order is visible
      Given I have added an item to my cart
      When I complete the purchase
      Then I can view the order
