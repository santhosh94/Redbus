#objective: Check number of search results in red bus website

Feature: to check redbus details

Scenario: Check user is getting results in red bus website
Given user is in redbus main page
When user enters depart and return cities
When user selects date
And user clicked on searchBuses
Then user should see redbus results

Scenario: new usecase
