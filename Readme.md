
# Contacts Application - Assignment
   
Contact Application developed using Java, spring boot, AngularJS, H2 inMemory-DB. 

>Auther Name:- Manoj Sonje.
>


## Technologies Used

Java 8+,
Apache Maven 3+,
Spring Core,
Spring Boot 2+,
AngularJS 1.x,
h2 DB,
Mockito,
Junit,
hibernet

## Installation 
Production Environment :-  java 8 should be installed before running executable file.

Development Environment :- The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
No need to configure any db as we are using h2 in-memory db.


## Usage 
Production Environment :-  Run the executable jar using command `java -jar contactapp-0.0.1-SNAPSHOT.jar` and head out to [http://localhost:9091/contacts.html](http://localhost:9091/contacts.html)

Development Environment :-

Run the project through the IDE and head out to [http://localhost:9091/contacts.html](http://localhost:9091/contacts.html)

or 

run this command in the command line:
```
mvn spring-boot:run

```
List Contacts api: (GET) - http://localhost:9091/contacts => table will be populated containing list of contacts on  [http://localhost:9091/contacts.html](http://localhost:9091/contacts.html)

Add Contacts api: (POST) - http://localhost:9091/contacts => fill the form to add contact details present on [http://localhost:9091/contacts.html](http://localhost:9091/contacts.html)

Edit Contacts api: (PUT) - http://localhost:9091/contacts/{id} => click on edit button and update the form to submit contact details present on [http://localhost:9091/contacts.html](http://localhost:9091/contacts.html)

Delete  Contacts api: (DELETE) - http://localhost:9091/contacts/deletecontact/{id} => click on delete button present on [http://localhost:9091/contacts.html](http://localhost:9091/contacts.html)

## Assumptions :
10 sample records will be populated for reference. 


