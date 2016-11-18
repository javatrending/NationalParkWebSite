Feature: open parkDetail page

	Scenario: see parkDetail page
		Given I want to see park detail for Cuyahoga Valley National Park
		When I click on park image
		And I request for park code CVNP
		Then see parkDetail page for Cuyahoga Valley National Park