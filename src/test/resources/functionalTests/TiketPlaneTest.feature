Feature: Functional test Tiket website

  Scenario Outline:User able to Create transaction with Virtual Account for domestic round trip with xx transit and login with email
    Given User is at home page

    #login step
    And user click login
    Then The url should be user login page "https://www.tiket.com/login"
    When User try to login with email "<email>" and password "<password>"
    Then user should login successfully

    #choose plane destination and time step
    And User choose plane service
    And User set from "jakarta"
    And User set destination to "juanda"
    And User set flight departure date "1 Juli 2021"
    And User set flight return date "3 Agustus 2021"
    And User choose done
    When User click Find flight
    Then The url should be find flight page "https://www.tiket.com/pesawat/search"

#    #choose plane step
    And User choose "direct" transit
    And User choose "morning" as departure time
    And User choose "morning" as arrival time
    And User choose departure plane
    When User choose arrival plane
    Then The url should be flight details page "https://www.tiket.com/cart/flight"

#    #fill order detail step
    And User toggle same as contact person for passenger details
    When User do proceed payment and wait proceeding
    Then The url should be find order page "https://payment.tiket.com/"

#     #fill proceed payment step
    And User choose payment type "Virtual Account" using "BCA Virtual Account"
    When Click proceed payment
    Then User should successfully create transaction and logout

    Examples:
      |email|password|
      |    |        |
     #Supplied your email account here

