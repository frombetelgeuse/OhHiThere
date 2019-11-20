Feature: Walking Skeleton

  I need to start from something, so I determine basic features

  Scenario Outline: Main page contains basic functionality
    When The client opens the main page
    Then The client sees "<submenu>" submenu on a page

    Examples:
      | submenu       |
      | Create order  |
      | Find order    |
      | About         |

  Scenario: Client creates an order
    When The client opens the create order page
    And The client fills fields and sends the form
    Then The client sees order page

  Scenario: Client finds an existing order
    Given There is an existing order
    When The client opens the main page
    And The client fills search box and clicks (Find order)
    Then The client sees order page


