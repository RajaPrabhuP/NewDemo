Feature: Validating Place API

@Regression
Scenario: Verify if Place is being Successfully added using AddPlaceAPI
Given Add Place Payload
When User calls "AddPlaceAPI" with "post" http request
Then the API call success with status code "200"
And "status" in response body "OK"

@Regression
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
Given Add Place Payload with "<name>", "<phonenumber>","<Address>"
When User calls "AddPlaceAPI" with "post" http request 
Then the API call success with status code "200"
And "status" in response body "OK"
And Verify the "<name>" mapped with correct placeId using "GetPlaceAPI"

Examples:
|name|phonenumber|Address        |
|Raja|7448785668 |ThalaivanKottai|
|Prabhu|9941201750|kundrathur|

#Scenario: verify DeletePlace API working or not
#Given Add Delete Place Payload
#When User calls "DeletePlaceAPI" with "post" http request 
#Then the API call success with status code "200"
#And "status" in response body "OK"
#Raja Prabhu

