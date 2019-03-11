Feature: Facebook login application
  
  @smokeTest
  Scenario: Vefify Login succesfully 
  
  Given Launch  browser "https://www.facebook.com/"
  When user have a valid credentials "abc@123" "Pass@123"
  And click on the  login button
  Then check login is sucessfully