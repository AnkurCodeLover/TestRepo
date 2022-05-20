Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload with "<name>"  "<language>" "<address>"
#	When user calls "AddPlaceAPI" with "POST" http request
#	Then the API call got success with status code 200
	
Examples:
	|name 	 | language |address		   |
	|AAhouse |  English |World cross center|
#	|BBhouse | Spanish  |Sea cross center  |


	
	

	
	
	