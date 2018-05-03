	*** JUnit Tests ***
3 JUnit Tests are included. Recall that the entire state of our game depends on only 5 variables (level, health,
count, potions, and x position). As such, the Junit testing could be done with relatively few test classes.

We have included a file that will run all three tests. 
TO USE:	Navigate to Project\Game and type 'jtest'.

	*** Manual Tests ***	
	
We have included classes that are used to test various GUI components. Since JUint is relatively difficult to test 
GUI classes with, we have created our own, some-what unorthodox tests. Each test is itself a GUI, and creates objects of the 
type it represents.

**loadFiles**
This folder contains files that can load every level in the game. In each file, the save game variables (health, clock count,
potions, xlocation) are set to random values. This class was used to verify that each level is drawn properly, when the
game isn't played in such a way that it progresses to the level.

TO USE: Navigate to Project\Game and type 'run'. This will launch the game. Select 'load game'. Navigate to loadFile folder
and select anyone of the files. The values in the file can be verified to match the game display.

**StickerTest**
Creates two objects, of type Sticker, and sets the string to indicate if the constructor set the
x and y positions correctly. This is done using a boolean comparison and the results is displayed
using the Sticker itself.

TO USE: Navigate to Project\Game and type 'manual_test1'. App will appear on screen with details of test.

**IllustrationTest**
Creates same Sticker objects as StickerTest class and also an instance of Illustration. The file
is set to the main character, and the picture is displayed on screen. The two Sticker objects indicate
if the x and y positions of the Illustration object were initialized correct, using a boolean comparison.

TO USE: Navigate to Project\Game and type 'manual_test2'. App will appear on screen with details of test. 

