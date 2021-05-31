# tiketcom_sample
TIKET.COM automation sample

## Introduction

This is tiket.com WEB APPLICATION automation test made with selenium JAVA
* P.S. im sorry if there's a bug, a good application takes time to be polished

## Project Assumptions 
Here's the project assumption and the explanation that needed to read before running the test, for the task, i choose 2 task from the test which is task number 1 and 2
* Task number 1: Product Hotel
 1. Since this is need the user to loggin using facebook, the test need a facebook account that already registered to TIKET.com website (not asking OTP when facebook login)
 2. Change the payment using virual account because i dont have any credit card (Yes im sad too :( )
 3. You need to supplied your own facebook account at scenario outline examples (see project structure images, at resources/functionalTests folder, modified the TiketHotelTest.feature file) 
 4. Choosing first room from the room list
 
* Task number 2 : Product FLight
 1. At this case the user need to be loggin using email which is asking OTP everytime the user loggin, because my test is for WEB APPLICATION so i modified the case scenario to be waiting for user to input some OTP to alert dialog
 For Example:
 ![image](https://user-images.githubusercontent.com/12995106/120131546-d84b6c00-c1f2-11eb-9d4e-deb453838f7c.png)

 2. You need to supplied your own email account at scenario outline examples (see project structure images, at resources/functionalTests folder, modified the TiketFlightTest.feature file) 
 3. Choosing first plane from the plane list

## Pre-requisite

* Assuming you're using windows/linux/mac machine
* Installing java JDK at least v1.8 JDK
* Installing maven, currently im using maven for this project
* Having IDE like intellij or Eclipse 
* Because this is selenium and it needs a driver to run, the solution comes with chrome driver at least need chrome v90

## Setup

1. Clone this git
2. Open using any IDE
3. Since this is maven project, its better to do maven install first
```
mvn clean install
```


## Project Structure
![image](https://user-images.githubusercontent.com/12995106/120130799-455e0200-c1f1-11eb-9b7f-5186009441e0.png)

The collapsed folder is the essential folder that user need to see

## Running the test
There's 2 way to run the test
* Right lick at the test runner at runner folder for single feature test and click run
* Run a command line to run all test such as
 ```
mvn test 
```
