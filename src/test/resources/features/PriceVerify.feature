Feature: Test scenario for Git

  Scenario: Login to GitHub

    Given User is on "Login page"

    When User enters username as "Iggelds" and password on "Login page"

    Then User is successfully navigated to the "https://github.com/"

    And User info "Iggelds" on "Home Page" is present on navigation panel
