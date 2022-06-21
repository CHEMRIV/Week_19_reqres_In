Feature: Testing different request on the reqres application


  Scenario: Check if the reqres application can be accessed by users
    When User sends a GET request to list endpoint
    Then User should get back a valid status code 200

  Scenario: Check if user can create id in reqres application
    When User sends a POST request to create reqres application endpoint
    Then User must get back a validable status code 201

  Scenario: User verify if created id added to reqres application
    When User sends a GET request to get id endpoint
    Then User successfully added id in reqres application and status code is 200

  Scenario: User verify if created id Update to the reqres application
    When User sends a PUT request to update id endpoint
    Then User should update single data in reqres application successfully with status code 200

  Scenario: User verify if created id partial Update to the reqres application
    When User sends a PATCH request to update id endpoint
    Then User should partial update single data in reqres application successfully with status code 201









