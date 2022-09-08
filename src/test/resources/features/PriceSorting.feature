Feature: Test scenario for Amazon

  Scenario: Verify filtering by price

    Given User is on "Gaming chairs page"

    When User clicks dropdown menu and selects price from low to high

    Then User observes result of sorted gaming chairs