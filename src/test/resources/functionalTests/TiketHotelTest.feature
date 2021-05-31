Feature: Functional test Tiket website

  Scenario Outline: Create transaction with non-instant payment for xx guest and xx room and
  login using Facebook
    Given User is at home page
    And user click login
    When User try to login using facebok with email "<email>" and password "<password>"
    Then user should login successfully
    And user choose "starlet hotel serpong" for hotel
    And User set check-in date "15 Juli 2021"
    And User set check-out date "16 juli 2021"
    And User rent for 3 person and rent 2 room
    When User click find hotel
    Then The url should be find hotel page "https://www.tiket.com/hotel" and rooms are available
    When User select some room
    Then The url should be checkout hotel order page "https://www.tiket.com/hotel/checkout"
    When User fill hotel order detail and click proceed
    Then The url should be find order page "https://payment.tiket.com/"


     #fill proceed payment step
    And User choose payment type "Virtual Account" using "BCA Virtual Account"
    When Click proceed payment
    Then User should successfully create transaction and logout

    Examples:
      |email|password|
      |franz_kenny95@yahoo.com     |Fr@n5_h@53@        |