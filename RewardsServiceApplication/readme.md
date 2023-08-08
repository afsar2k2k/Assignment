A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar
spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
Given a record of every transaction during a three month period, calculate the reward points earned for each
customer per month and total.

Application is developed using Springboot micro service with Rest API encapsualted in RewardsServiceController, 
the business logic is done in service layer using RewardsServiceImpl and the database CRUD operations are done using
repo using JPA. Java properties to backend database column mapping is done using JPA annotations.

RewardsServiceController which has a REST Endpoint which takes person Identifier as request param
REST API returns success or error response based on input person Id

RewardsServiceImpl is a implementation class of service layer interface RewardsServiceIF. 


How to call the service 
Service can be called using Postman or soapui using the URL 
http://localhost:9900/rewards-service/v1/get-reward-info?custId=1