Feature: Employee city of origin deatils Validate

    Scenario Outline: validate city of origin of the selected employees
    Given I access employees.html
    When I Selected Employee "<empFirstName>" and "<empLastName>"
    Then Validate "<empFirstName>" employee city of origin is "<cityName>"
	
Examples:
    | empFirstName | empLastName | cityName  |
    | Andrew 	     | Fuller      | Tacoma    |
    | Nancy 	     | Davolio     | Seattle   |   
    | Janet 			 | Leverling 	 | Kirkland  |
    | Margaret 	   | Peacock     | Redmond   |
    | Steven 	     | Buchanan    | London    |
    | Michael 		 | Suyama      | London    |
    | Robert 	     | King        | London    |
    | Anne 				 | Dodsworth   | London    |
    | Laura 	     | Callahan    | Seattle   |   


    Scenario Outline: validate city of origin of the employees for mutilple select
    Given I access employees.html
    When I Selected Employee 
    | empFirstName | empLastName | 
    | Andrew 	     | Fuller      | 
    | Nancy 	     | Davolio     | 
    | Janet 			 | Leverling 	 | 
    | Margaret 	   | Peacock     | 
    | Steven 	     | Buchanan    |
    | Michael 		 | Suyama      | 
    | Robert 	     | King        | 
    | Anne 				 | Dodsworth   | 	
    | Laura 	     | Callahan    |  		
   	Then Validate employee city of origin
    | empFirstName |  cityName  |
    | Andrew 	     | Tacoma     |
    | Nancy 	     |  Seattle   |   
    | Janet 			 |  Kirkland  |
    | Margaret 	   |  Redmond   |
    | Steven 	     |  London    |
    | Michael 		 |  London    |
    | Robert 	     |  London    |
    | Anne 				 |  London    |
    | Laura 	     |  Seattle   |   
 