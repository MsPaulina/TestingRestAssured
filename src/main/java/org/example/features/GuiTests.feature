Feature: Testing GUI for Language School App

  Background:
    Given I open browser and navigate to Language School website

  Scenario: Admin Login and add new course
    And I login as admin with the password lakhan123
    And I see welcome message as admin
    And I navigate to Courses tab
    And I verify I can see Add New Course Button
    And I add a Testowanie course with the Opis Testowania as description
    And I am able to logout
    Then I close the browser

  Scenario: Admin Login and delete one student
    And I login as admin with the password lakhan123
    And I see welcome message as admin
    And I navigate to Students tab
    And I delete the first student and verify it is not present in the table
    And I am able to logout
    Then I close the browser

  Scenario: Student Login to check visibility of the buttons
    And I login as studenciak with the password bharat123
    And I see welcome message as studenciak
    And I navigate to Courses tab
    And I cannot see Add New Course button
    And I navigate to Students tab
    And I cannot see button to delete a student
    And I am able to logout
    Then I close the browser

  Scenario: Incorrect login details
    And I login as wrongUsername with the password wrongPassword
    And I do not see welcome message
    Then I close the browser