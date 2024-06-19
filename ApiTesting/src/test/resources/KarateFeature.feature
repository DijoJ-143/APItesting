Feature: FreeFakeApi-Comment

  Background: 
    * url 'https://freefakeapi.io/api'
    * configure ssl = true

  Scenario: Retrive all comments
    Given path '/comments'
    When method GET
    Then status 200
    And match response[0].id == '1'

  Scenario: create a new comment
    Given path '/comments'
    And request
      """
      {
        "content": "This is the comment content",
        "user": 1,
        "post": 5
      }
      """
    When method POST
    Then status 201
    And match response.content == 'This is the comment content'

  Scenario Outline: post multiple comments
    Given path '/comments'
    And request{'content':"<content>",'user':<user>,'post':<post>}
    When method POST
    Then status 201
    And match response.content == "<content>"
    And match response.user == <user>
    And match response.post == <post>

    Examples: 
      | content                     | user | post |
      | This is the comment content |    1 |    5 |
      | This is the comment content |    2 |    6 |

  Scenario: Delete a comment
    Given path '/comments/1'
    When method DELETE
    Then status 204
