#Test Case 1
@automationPage
Feature: Validate text and links on Automation Page under Services

  Scenario: Automation text validation
    Given User is on Home Page
    When User hovers on "Services" menu
    And selects "Automation" submenu
		Then User is navigated to "Automation" Page
		And the text "Automation" is displayed
		And the "Services" menu along with "Automation" submenu are selected
