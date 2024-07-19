
@tag
Feature: Purchase the order from e-commerse website 

  Background: Given I landed on Ecommerce page
 
 
  @tag2
  Scenario Outline: Positive test of submitting the order
  
    Given Logged in with username<name> and password<password>
    When I add the Product<productname> to cart
    And checkout<productName> and submit the order
    
    Then "THANKYOU FOR THE ORDER."verify the confirmation message is displayed

    Examples: 
      | name            | password     | productName  |
      |  ithal@gmail.com| Iwillget7@+* |ADIDAS ORIGINAL |
      
