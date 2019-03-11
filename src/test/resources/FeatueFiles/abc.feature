#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#
#
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #Scenario: Test FB login successfull
    #Given Launch the browser ""
    #And Enter "UserName1" and "password1"
    #Then click on the login button and check success
    #And close the browser
    #
    #@tag("Regression")
    #Scenario: Test FB login successzfull
    #Given Launch the browser ""
    #And Enter "UserName1" and "password1"
    #Then click on the login button and check success
    #And close the browser
    #
      #Scenario: Test FB login successfull
    #Given Launch the browser ""
    #And Enter "UserName1" and "password1"
    #Then click on the login button and check success
    #And close the browser
#
#
#// Above lines of code works for one user what if you have 10 users, go with scenario outline 
  #Scenario Outline: Test FB login successfull1
    #Given Launch the browser ""
    #And Enter "<UserName>" and "<password>"
    #Then click on the login button and check success
#		And close the browser
#		
#		Examples: 
      #| UserName  | password |
      #| name1 |     pwd1 | 
      #| name2 |     pwd2 |
#		
#		
#
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
