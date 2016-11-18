Feature: Take survey for National Park

Scenario: vote for favorite park
	Given I want to vote for Grand Canyon National Park
	And my eamil address is apple@gmail.com
	And my state is Ohio
	And my activity level is Active
	When I submit my vote
	Then I will see result page
	
	