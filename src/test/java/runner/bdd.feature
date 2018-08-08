Feature: user looks up for a book in amazon
		As a user
		I want to look for a book with various names 
		so that I can select the first one
		
		Scenario Outline: valid search
			Given a user on amazon homepage
			When he enters "<book name>" in search box
			And he submits the request
			Then ensure search is successfull "<expMsg>"
          
         Examples:
           | book name 	 		|  expMsg			 |
           | BDD Testing 		| "BDD Testing"   	 |   
           | Selenium Cook Book | "selenium cookbook"|