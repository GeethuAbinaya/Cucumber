Feature: To post a request and to test status code for different scenarios
  
 # Scenario: Sending service URL and End point URL
    @PositiveTests   
    Scenario Outline: Posting payload request
    Given First im getting service URL and end pint URL to add URI   
    |URL |Service_Url|
    |URL1|service1|
    Then I am getting headers to be added
    |Header1     |Header2             |
    |Content_Type|Aurlis_Authorisation|
    And I want to send "<name>""<industry>""<level>""<description>"<duration><value> 
     Then I am posting an api with end point URI "<URL>","<Service_Url>",header"<Header1>","<Header2>",payload "<name>""<industry>""<level>""<description>"<duration><value> 
     |URL |Service_Url| |Header1     |Header2             |
     |URL1|service1     |Content_Type|Aurlis_Authorisation|
    
    Examples: 
      | name    | industry                 | level                    |description   |duration|value   |response_code|
      | Raj     | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Food Servicing|10      |1000    |201          |
      | Bharath | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Food Servicing|10      |1000.02 |201          |
      | Divisha | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Food Servicing|10      |1000.02 |201          |
      
      
      @NegativeScenario
    Scenario Outline: Posting payload request to check with blank payrequest field
    Given First im getting service URL and end pint URL to add URI   
    |URL |Service_Url|
    |URL1|service1|
    Then I am getting headers to be added
    |Header1     |Header2             |
    |Content_Type|Aurlis_Authorisation|
    And I want to send "<name>""<industry>""<level>""<description>"<duration><value> 
     Then I am posting an api with end point URI "<URL>","<Service_Url>",header"<Header1>","<Header2>",payload "<name>""<industry>""<level>""<description>"<duration><value> 
     |URL |Service_Url| |Header1     |Header2             |
     |URL1|service1     |Content_Type|Aurlis_Authorisation|
    
     Examples: 
      | name    | industry                 | level                    |description   |duration|value   |response_code|
      | Raj     | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Water Supply  |10      |1000    |409|
      |         | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Catering      |10      |1000.02 |400|
      | Prabu   | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |              |10      |452     |400|
      | Pragathi| 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Marriage Decor|        |1000.02 |400|
      | Kamali  | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Receptionist  |10      |        |400|
      
       @NegativeScenario
    Scenario Outline: Posting payload request to check with incorrect decimal value
    Given First im getting service URL and end pint URL to add URI   
    |URL |Service_Url|
    |URL1|service1|
    Then I am getting headers to be added
    |Header1     |Header2             |
    |Content_Type|Aurlis_Authorisation|
    And I want to send "<name>""<industry>""<level>""<description>"<duration><value> 
     Then I am posting an api with end point URI "<URL>","<Service_Url>",header"<Header1>","<Header2>",payload "<name>""<industry>""<level>""<description>"<duration><value><response_code> 
     |URL |Service_Url| |Header1     |Header2             |
     |URL1|service1     |Content_Type|Aurlis_Authorisation|
      
    Examples:  
      | name    | industry                 | level                    |description   |duration|value   |response_code|
      | Vaishhu | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Music Band    |10      |1234.567|400          |      
      | Keerthi | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Seat Arrange  |10      |ab12*&  |400          |
      | Divisha | 5e4d98bb5f7f592524bc73b8 | 5e4d98bb5f7f592554d174fc |Foodwater     |ab12*&  |1234    |400          |

