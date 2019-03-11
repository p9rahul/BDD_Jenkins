Feature: Facebook login application
  
  @smokeTest
  Scenario: Vefify Login succesfully 
  
  Given Launch the browser "https://www.facebook.com/"
  When user have valid credentials "abc@123" "Pass@123"
  And click on login button
  Then check login sucessfully
  
  
  #Scenario: Vefify Login succesfully 
  #
  #Given Launch the browser "https://www.facebook.com/"
  #When user have valid credentials "abc@123" "Pass@123"
  #And click on login button
  #Then check login sucessfully
  #
  #Scenario Outline: Title of your scenario outline
  #Given Launch the browser "https://www.facebook.com/"
   #When user have valid credentials "<Uid>" "<password>"
   #And click on login button
   #Then check login sucessfully
#
    #Examples: 
      #| Uid  | password |
      #| abc@123 |     Pass@123 |
      #| abc@1234 |     Pass@1234 | 
       #| abc@123 |     Pass@123 |
      #| abc@1234 |     Pass@1234 |