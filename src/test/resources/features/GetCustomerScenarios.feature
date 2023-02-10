@GetCustomers
Feature: Get Customer scenarios

  Scenario: Get customers list and verify first name
    Given Send request to Get customer list
    When Verify status code 200
    Then Response body received for "firstname" with "james"

  Scenario: Verify all response values are as expected
    Given Send request to Get customer list
    When Verify status code 200
    Then Response body received for "firstname" with "james"
    And Response body received for "lastname" with "smith"
    And Response body received for "profession" with "tester"

    Scenario: Verify for Invalid Url
      Given Send request to Get customer list with Invalid Url
      When Verify status code 404

