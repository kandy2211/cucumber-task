@selecthotel
Feature: Verifying Adactin select hotel details

  Scenario Outline: Verifying Adactin select hotel by selecting hotel name
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter search hotel details "<Location>","<Hotels>","<RoomType>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should navigate to select hotel page and verify "Select Hotel" message
    And User should select hotel name and click continue
    Then User should navigate to book hotel page and verify "Book A Hotel" message

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         | 1 - One           |

  Scenario Outline: Verifying Adactin select hotel without selecting hotel name
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter search hotel details "<Location>","<Hotels>","<RoomType>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should navigate to select hotel page and verify "Select Hotel" message
    And User should click continue without selecting hotel name
    Then User should verify "Please Select a Hotel" error message

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         | 1 - One           |
