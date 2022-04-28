Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "QAClickAcademy" site
And Click on login link in home page to land on Secure sign in the Page
When User enters <username> and <password> and logs in 
Then Verify that user is successfully logged in 
And close browser

Examples:
|username  	           |password  |
|test99@gmail.com      |123456    |
|test98@gmail.com      |123455    |