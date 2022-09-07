@cancelbooking
Feature: Verifying Adactin cancel booking details

  Scenario Outline: Verifying Adactin cancel booking by generating order id
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
    And User should navigate to Booked Itinerary page and cancel booking using order id
    Then User should verify the cancel booking success message "The booking has been cancelled."

    Examples: 
      | username      | password | Location | Hotels      | RoomType | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | FirstName | LastName | BillingAddress |
      | kandasamy2211 | Kanda@22 | Sydney   | Hotel Creek | Deluxe   | 2 - Two         | 17/08/2022    | 18/08/2022     | 1 - One         | 1 - One           | Kandasamy | K        | cuddalore      |

  Scenario Outline: Verifying Adactin cancel booking by using existing order id
    Given User is on the adactin page
    When User should perform login "<username>" , "<password>"
    Then User should verify after login "Hello kandasamy2211!"
    And User should navigate to Booked Itinerary page and cancel booking using existing order id "<order id>"
    Then User should verify the cancel booking success message "The booking has been cancelled."

    Examples: 
      | username      | password | order id   |
      | kandasamy2211 | Kanda@22 | 4LW9REKM1G |
      
      
      
      
      
      
      
      
      
      
      
      
      
