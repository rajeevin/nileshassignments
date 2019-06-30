# nileshassignments
This project contains solution to all assignments given by Nilesh's Team. It is a maven based project and can be build.

There are three assignments in total and the solution to these assignments are provide under below packages
assignment 1 : com.paypal.assignment1 : Class Name : FindSubStringIndexAssigment.java
assignment 2 : com.paypal.assignment2 : Class Name : LRUCache.java 
assignment 3 : com.paypal.assignment3 : Class Name : App.java and others

All the above mentioned class files contains main method and can be executed to test and apply the solutions.



For details on the assignments please refer below.

--------------------------------------------------------------------------------
Instructions:

- We are glad that you are interested in PayPal! Thank You for your interest.
"Its not going to be easy but its going to be fun".
To being with, please complete the following three coding exercises. Exercise 1 and Exercise 2 are common to all.If you can't solve a problem completely, please submit your best partial solution, together with a comment as to what is missing or what shortcomings you see with your solution. You do get partial credit!

- When you submit the assignment,please also submit the amount of time taken to complete each assignment.
- For each assignment, the preferred programming language is specified.
- Please treat this as writing a production code.
- We would look at variable names, comments, unit tests, mock tests (wherever applicable)
- Please run the code locally and document output.
- For each exercise, please provide instructions on how to run the code locally.
- Extra Credits for completing all the four assignments.
- In case of ambiguity, don't stop - use your judgement , make assumptions and continue. Please document assumptions


- Good luck!                                                       


--------------------------------------------------------------------------------
EXERCISE 1 (MANDATORY)
Preferred Language : Java

Implement the strstr from string.h in the C standard library. 
 
The function should take two string parameters, short and long (note that these are just the variable names, not types), and return the first occurrence of short in long as a 0 based index into long. If short does not exist in long, the function should return -1.
 
You should provide a suite of test data along with your implementation.
 
Constraints:
 
You should implement the function in  Java but you MUST NOT use high level language facilities such as regular expressions or multi-character string comparisons. 
  
The solution should be expressed in a single file with no outside dependencies.Code should run on java version "1.8.0_181".It should contain at least one function named strstr that performs the task, and one function named test that returns a true value if the strstr function passes all testcases. You may factor strstr into multiple functions if you like.
The solution should be expressed in a single file with no outside dependencies. 


--------------------------------------------------------------------------------

EXERCISE 2 (MANDATORY)

Implement Least Recently Used Cache algorithm 
Preferred Language: Java

Constraints:
The solution should be expressed in a single file with no outside dependencies. Code should run on java version "1.8.0_181"


--------------------------------------------------------------------------------


EXERCISE 3

Write a Java Class that mimics REST Service  to create and update "User" record. 
User has following attributes: userId,userAsset,loginTime,ipAddress.

Hints:

1. Define appropriate resource and choose the appropriate REST operation for Creating and Updating user record.

2. User Details should be stored in in-memory key-value store (Choose appropriate key value store - a map, hash table or any other data structure) : 
Key=userId, Value = {"asset":userAsset,"loginTime":loginTime,"IpAddress":comma separated list of ipAddress}

3. Please keep persistence layer (Key-Value Store) separate from the service layer.

4. Update Operation: The update operation should not cause in loss of value I.e. if the update request contains a new IpAddress that does not exist in currently stored value, the update operation should append the new IpAddress to the existing json object.

5. Write a function that takes userId and ipAddress as input and returns true of false based on whether the user has logged in from the input ipAddress. The function should look up key value store to get list of ipAddresses that user has logged in previously.
Boolean detectAnomaly(userId,ipAddress){
}

4. Write Unit/Mock test to test create and update operations.

5. In absence of application container to run the service, please provide a main method in the class. This main method should invoke the functions to create,update,detectAnomaly.

6. Since Persistence logic is separated from Java Class that mimics REST Service, you might end up with multiple java files. Please provide a runnable jar file with instructions on how to run the main program. Use "System.out" to print the results.
7. Be creative and help us run unit tests as well.

--------------------------------------------------------------------------------
