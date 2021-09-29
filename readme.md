# AWS RDS Spring boot crud operation
## _by - Vikram Singh_

##
##

 ✨ Technologies Used ✨

- [Java 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
- Spring Boot
- Hibernate
- [Lombok](https://projectlombok.org/setup/intellij) 
- Idea IDE 
- [AWS rds (oracle)](https://console.aws.amazon.com/rds)

## Features
> Crud operation with the cloud database


## Plugins
This project is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Lombok | [Lombok plugin for intellij idea][Pllombok]|

## Development

1- If aws is not responding then check your ppk file and Publicly accessible should be Yes.
2- SID is nothing but DB Name.
3- oraclerds.cmcwfv3cvytl.us-east-1.rds.amazonaws.com where oraclerds is DB instance ID.
4- inbound and outbound should be for all traffic.
5- check all the configuration in the rds configuration tab.
6- APIs :-
delete - http://localhost:5000/api/emp/3
Post - http://localhost:5000/api/emp/createEmp
        post api body:- 
    
    
        {
            "ename": "b",
            "email": "b@abc",
            "comments": "b emp",
            "DOJ": "2020-12-21"
        }
        
        
put - http://localhost:5000/api/emp/1
      put api body:-   
      
    {
    "eid" :1,
    "ename": "a1",
    "email": "a1@abc",
    "comments": "a emp",
    "doj": "2020-02-02"
      }
     
 get - http://localhost:5000/api/emp/all
 



**Want to contribute? Great!**
Make a change in your file and instantaneously see your updates!

_Happy Coding_ :)

[Pllombok]: <https://plugins.jetbrains.com/plugin/6317-lombok>
