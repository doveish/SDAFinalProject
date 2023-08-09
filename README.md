# SDAFinalProject
Final project repository for JavaRemoteEE26 group 3 for a Stock Tracker Application.
# Description
The application was created for an assignment which required for a non trivial application as a solution to a problem.
The requirements for this project were:
* The appliction had to use a database in some way. 
* The process flow and the database structure overview had to be mapped.
* The SQL code had to be uploaded for replication purposes.
<p align="justify"> 
To fulfill the given conditions we chose a stock, transaction, dividend and account tracking application which 
allows the user to save the data to a database for future review. We also decided to add several calculation 
methods to simplify the handling of transactions, profit/loss, total portfolio value etc. Our application allows the user to read and write 
stockmarket related portfolio processes via browser in our test case. So without further delay,
please welcome our Stock Portfolio Tracker!
</p>

# STOCK PORTFOLIO TRACKER

![Front](https://github.com/doveish/SDAFinalProject/blob/6314f2213c1df1c425a3ebebe4833298ce9c871e/Images/Front.png)

# MySQL Database structure
![Database](https://github.com/doveish/SDAFinalProject/blob/e0c51479b3d80d2fc26829bc704f2cd4e42bdd4b/Images/Database%20C.png)

# Project flowchart
![Flowchart](https://github.com/doveish/SDAFinalProject/blob/a99e7c85ce5033cfe7f298769536a3a3dbae100e/Images/Flowchart.png)

# Required software and TO-DO
In order to run the application You need to have the following software installed:
* **Java Development Kit** - during development we used JDK version 19 or higher.
* **IntelliJ Idea** - change the database URL, username and password in the IntelliJ project for Database connection in Resources folder Application Properties.
  Also add a new MyUser for login purpose in the FinalProjectApplication class with the appropriate field values.
* **Database** - Create the database Schema with the appropriate name and the Tables will be generated automatically.
* **Postman** - Create a new User by making a HTTP PUT request to the URL("localhost:8080/signup")
  with the following JSON ({"username":"your username here", "password":"your password here"}) 
* **Angular** - go to the directory folder of the Front-End via VS Code console and run the project with "npm start" or "ng serve" command.
* **Browser** - we used the URL "localhost/4200" for testing

  <p align="center"><b>Please get the project files Front-End in the "frontend" branch Back-End from "master" branch of this repository.</b></p>


# Authors
Developed by @corvert(https://github.com/corvert) @doveish(https://github.com/doveish) @timomer83(https://github.com/timomer83).

# Found a bug or want to add a feature
<p align="justify"> 
Please submit an issue or an improvement idea using the issues tab above. 
If You would like to submit a PR with a fix, reference the issue you created.
</p>
