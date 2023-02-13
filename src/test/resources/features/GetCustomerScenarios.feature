@GetCustomers
Feature: Get Customer scenarios

  Scenario: Get customers list and verify first name
    Given Send request to Get customer list
    When Verify status code 200
    Then Response body received for "name" with "Samsung Galaxy Z Fold2"

  Scenario: Verify all response values are as expected
    Given Send request to Get customer list
    When Verify status code 200
    Then Response body received for "data.price" with "689.99"
    And Response body received for "data.color" with "Brown"

    Scenario: Verify for Invalid Url
      Given Send request to Get customer list with Invalid Url
      When Verify status code 404

