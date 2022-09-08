Feature: Test scenario for Amazon

  Scenario: Verify filtering by price

    Given User is on "Gaming chairs page"

    When User selects the range between minimum and maximum price and executes the filter

    Then User observes result of filtered gaming chairs by price range