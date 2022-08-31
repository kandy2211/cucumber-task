@Login
Feature: Verifying Adactin hotel login details

  Scenario Outline: Verifying Adactin hotel login with valid credentials
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"

    Examples: 
      | username      | password |
      | kandasamy2211 | Kanda@22 |

  Scenario Outline: Verifying Adactin hotel login with valid credentials with Enter
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>" with Enter Key
    Then User should verify after login "Hello kandasamy2211!"

    Examples: 
      | username      | password |
      | kandasamy2211 | Kanda@22 |

  Scenario Outline: Verifying Adactin hotel login with Invalid credentials
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login error contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | username      | password |
      | kandasamy2211 | Kanda@2  |
