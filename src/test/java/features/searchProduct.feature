Feature: Search and place the order for the products

@OffersPage
Scenario Outline: Search experience for product search in both Home page and Offers page

Given User is on GreenCart landing page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page
And validate productname in offers page matches with landing page

Examples:
| Name  |
| Tom 	|
| Beet  |
