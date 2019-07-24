Feature: as truck driver i shoud be able to access vehicle odemeter page
   
   Background:
     Given i am on Vytrack login page
     Then i login as sales manager
   
    @test1
    Scenario: create vehicle odemeter with proper information
    Given i am on Vytrack homepage
    When i hover my mouse to Fleet header
    And i click on Vehicle Odometer
    Then i should see Vehicle Odometer page
    And i click on the create vehicle odometer section
    Then i see create vehicle odometer page
    And i fill all blanks and click on Add
    
    @test2
    Scenario: check vehicle info
    Given i am on Vytrack homepage
    When i hover my mouse to Fleet header
    Then i click on Vehicle
    When i click on any driver
    Then System should diplay General information of Vehicle
    
    
    @test3
    Scenario: truck driver delete vehicle odometer
    Given i am on Vytrack homepage
    When i hover my mouse to Fleet header
    And i click on Vehicle Odometer
    Then i should see the Vehicle Odometer page
    When i delete the any Vehicle Odometer
    Then the Vehicle Odometer should be deleted
    
    
    
    
    
    
    
    
    
    
    
   