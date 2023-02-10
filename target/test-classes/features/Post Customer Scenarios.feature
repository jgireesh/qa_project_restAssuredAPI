@PostCustomer
Feature: Post Customer Scenarios

  Scenario: Post new customer
    Given Generate post map for the new customer
    When Post a customer
    Then Verify status code 201


