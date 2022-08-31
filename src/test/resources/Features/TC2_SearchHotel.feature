@searchhotel
Feature: Verifying Adactin search hotel details

  Scenario Outline: Verifying Adactin search hotel by selecting all fields
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter search hotel details "<Location>","<Hotels>","<RoomType>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should navigate to select hotel page and verify "Select Hotel" message

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         | 1 - One           |

  Scenario Outline: Verifying Adactin search hotel by selecting mandatory fields
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter mandatory fields of search hotel "<Location>","<Number of Rooms>","<Check In Date>","<Check Out Date>" and "<Adults per Room>"
    Then User should navigate to select hotel page and verify "Select Hotel" message

    Examples: 
      | username      | password | Location | Number of Rooms | Check In Date | Check Out Date | Adults per Room |
      | kandasamy2211 | Kanda@22 | Sydney   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         |

  Scenario Outline: Verifying Adactin search hotel by Date checking
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter search hotel details "<Location>","<Hotels>","<RoomType>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify date error message  "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2024    | 18/08/2022     | 1 - One         | 1 - One           |

  Scenario Outline: Verifying Adactin search hotel without selecting all fields
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should click search button without selecting all fields
    Then User should verify error message  "Please Select a Location"

    Examples: 
      | username      | password |
      | kandasamy2211 | Kanda@22 |
