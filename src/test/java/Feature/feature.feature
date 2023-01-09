Feature: Testing Myntra

Scenario: Login Successful
Given User is on login page of Myntra
And User Enters EmailId and Password and click on login button
Then User should see Myntra Home page

Scenario: Adding Items to Cart
Given User is on myntra home page
And search for an item and add it to cart
Then Item is added to cart