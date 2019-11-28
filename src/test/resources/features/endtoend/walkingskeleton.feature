Feature: Walking Skeleton

  I need to start from something, so I determine basic features

  Scenario Outline: Main page contains basic functionality
    When The client opens the main page
    Then The client sees "<submenu>" submenu on a page

    Examples:
      | submenu       |
      | createorder   |
      | findorder     |
      | about         |

  Scenario Outline: Client creates an order
    When The client opens the create order page
    And The client fills fields: name "<order_name>". Then sends the form
    Then The client sees order page with fields: name "<order_name>"

    Examples:
      | order_name  |
      | Great order |

  Scenario Outline: Client finds an existing order
    Given There is an existing order with fields: name "<order_name>"
    When The client opens the search order page
    And The client fills search box and clicks Find
    Then The client sees order page with fields: name "<order_name>"

    Examples:
      | order_name  |
      | Try to find |


