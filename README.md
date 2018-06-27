Assuming you are in the directory containing this README:

## To clean:
ant -buildfile fourWayStreetLights/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile fourWayStreetLights/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile fourWayStreetLights/src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 06/27/18]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Queue<vehicle> : adding all vehicle type object in queue

Big O Time complexity:O(n)
-----------------------------------------------------------------------
Program running instructions:
input.txt format:
1) <vehicle>-<car_name>-<direction>-<iteration> // for adding vehicle
   vehicle-car-west-5							// example
2) <signal>-<direction>-<green/red>-<iterations> // for stating signal state
   signal-north-green-1						// example
------------------------------------------------------------------------