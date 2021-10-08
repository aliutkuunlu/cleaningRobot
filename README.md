# cleaningRobot
Algorithm that find how many cell is cleaned by robot

Given String array such as 
String[] R = {"...X..", "....XX", "..X..."} we create a room for our robot.

	0	1	2	3	4	5
0	.	.	.	x	.	.
1	.	.	.	.	x	x
2	.	.	x	.	.	.

"." means empty area and "X" means obstacle.

Robot stars cleaning at position (0,0) and start with right movement. When it see an obstacle or border of room it rotates 90 degrees with clockwise direction.

when robot move a cell we consider as the cell is cleaned.

when robot starts looping in the room robot shuts itself. 

Movements

At 0,0 --> look 0,1 no border or obstacle move to 0,1 ---- 0,0 cleaned Clean Cell count is 1.
At 0,1 --> look 0,2 no border or obstacle move to 0,2 ---- 0,1 cleaned Clean Cell count is 2.
At 0,2 --> look 0,3 there is an obstacle rotate and look 1,2 no border or obstacle move to 1,2 ---- 0,2 cleaned Clean Cell count is 3.
At 1,2 --> look 2,2 there is an obstacle rotate and look 1,1 no border or obstacle move to 1,1 ---- 1,2 cleaned Clean Cell count is 4.
At 1,1 --> look 1,0 no border or obstacle move to 1,0 ---- 1,1 cleaned Clean Cell count is 5.
At 1,0 --> there is a border in the direction of movement so rotate and look 0,0 no border or obstacle move to 0,0  ---1,0 cleaned Clean Cell count is 6.
At 0,0 --> there is a border in the direction of movement and this cell cleaned so rotate and look 0,1 no border or obstacle move to 0,1 
At 0,1 --> this cell is also cleaned. Robot is in a loop now. Terminate.

Total Clean Cell count is 6 and room look like this. "O" means the cell is clean.

	0	1	2	3	4	5
0	O	O	O	x	.	.
1	O	O	O	.	x	x
2	.	.	x	.	.	.
