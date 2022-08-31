@bookhotel
Feature: Verifying Adactin Book Hotel details

  Scenario Outline: Verifying Adactin book hotel by selecting all fields
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter search hotel details "<Location>","<Hotels>","<RoomType>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should navigate to select hotel page and verify "Select Hotel" message
    And User should select hotel name and click continue
    Then User should navigate to book hotel page and verify "Book A Hotel" message
    And User should enter book hotel credentials "<FirstName>","<LastName>" and "<BillingAddress>"
      | Credit Card No   | Credit Card Type | ExpiryMonth | ExpiryYear | CVV |
      | 4000400040004000 | VISA             | November    |       2020 | 545 |
      | 5000500050005000 | American Express | March       |       2021 | 540 |
      | 4000400040004000 | Master Card      | December    |       2019 | 300 |
      | 4000400040004000 | Other            | August      |       2018 | 350 |
    Then User should navigate to booking confirmation page and verify "Booking Confirmation" message

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | FirstName | LastName | BillingAddress |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         | 1 - One           | Kandasamy | K        | cuddalore      |

  Scenario Outline: Verifying Adactin book hotel without selecting any fields
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    When User should enter search hotel details "<Location>","<Hotels>","<RoomType>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should navigate to select hotel page and verify "Select Hotel" message
    And User should select hotel name and click continue
    Then User should navigate to book hotel page and verify "Book A Hotel" message
    And User should click book now without entering any fields
    Then User should verify error messages "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         | 1 - One           |

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      