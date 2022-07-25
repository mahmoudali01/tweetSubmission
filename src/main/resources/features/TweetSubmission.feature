Feature: Tweet
  Background:
    Given user open browser and navigates to twitter then sign in with "01111052392" & "test123456789"

  Scenario: user shares the same tweet twice in a row
    When user enter "test!" on what's happening container
    And click Tweet
    Then tweet is shared successfully
    When user enter "test!" on what's happening container
    And click Tweet
    Then error message "Whoops! You already said that."


  Scenario: user tweets with four images
    When user input an image at what's happening container
    Then photo is displayed on the container
    When user input an image at what's happening container
    Then 2 photo is displayed on the container
    When user input an image at what's happening container
    Then 3 photo is displayed on the container
    When user input an image at what's happening container
    Then 4 photo is displayed on the container and the image icon is disabled
    And click Tweet
    Then quit



  Scenario: user tweets with URL and Image
    When user enters URL "https://www.youtube.com/watch?v=XPPWZlViqS4"
    Then thumbnail to the URL is displayed
    When user input an image at what's happening container
    Then photo is displayed on the container
    And click Tweet
    Then quit

