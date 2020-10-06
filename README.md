# Subscription Case Study
Case Study to design, code and deploy Subscription Service

## Mission Statement
With the information given and additional assumptions of yours, you should develop an API for SUBSCRIPTIONs using the Java framework of your choice (ideally use Spring Boot) or NodeJS framework of your choice (preferably ExpressJS).   

To create subscriptions a single endpoint will be created: in the public service.

Subscriptions contain: email, firstName, gender, dateOfBith, flag for consent and the newsletter Id corresponding to the campaign. Only gender and firstName are optional values. 

Rest of services receive the same parameters.

Services must be secure, only public service is accessible from the end user.

TIP: an example of a frontend application making use of this service would be similar to https://www.adidas.co.uk/on/demandware.store/Sites-adidas-GB-Site/en_GB/Newsletter-Subscribe

The subscription service has to persist the subscription and returns the ID of the created subscription to the public service.

To complete the subscription process, once the subscription was persisted by the subscription service, someway, the email service will receive the required  information to send an email to the user (take in account the SLAs to choose the best approach for this communication).

## Solution Overview 

<img src="subscription-service-solution.jpg"/>

## Subscription Service Overview

<img src="subscription-service-sequence.jpg"/>
