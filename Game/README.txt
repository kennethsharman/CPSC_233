Welcome to *** Pied Piper: The Game ***

We set out to create a fantasy style adventure game. Game is based around an old
fairy-tale.

Brief story: The Pied Piper of Hamelin is a story about the strange disappearance
or deaths of almost all the town's children. As the story goes; the piper met with
the mayor to get rid of the town's rat infestation. Upon completing the task, the
mayor refused to pay the piper. Soon after that many of the children in the town 
disappeared. Many believe the timing was no coincidence- it must be the piper.

Use the left and right arrow keys to move the piper in game. Pause the game by
pressing the ESC key. See 'Help' in main menu for more on controls.

To compile in the command prompt:
	Navigate to the Project/Game
	Type: compile
To run the program:
	Type: run

As with any game, it may take a few seconds to figure out what is going on.
The Objectives are displayed in upper left corner of screen. Move the piper
left/ right and things will happen! Make sure you read the text on screen to
know what to do next.

Try out the Save Game feature. Start a new game and play a little. Then press ESC
to bring up the Pause Menu. From there; press Save Game. It automatically writes
a save file to Project\Game named "SaveGame.txt".

To make sure this actually worked; quit the game and return to the main menu. Then,
select load game and navigate to SaveGame.txt. The game will load with the same clock
count, health, position, etc.

We have an end game animation, as well as a game over animation. First try
completing the game. If you successfully get to "The End" restart the game (again
by typing run) and try to die. To have to best chance at losing one of the 2
battles; select "Quick attack" repeatedly. If successful you will see the game
over animation.

We have included the following tests:
	3 JUnit tests located Project\Game\Data_Package
	2 Manual tests located Project\Game\GUI_Package
	12 load file tests located Project\Game\loadFiles

Please refer to TESTS_README file in Project folder that will explain how to go
about these tests.

Note that the entire state of our game relies on only 5 variables (level, health,
clock count, potions, and x position). As such, the JUnit testing could be done 
with relatively few test classes. In fact, the load game feature of our game is
the best way to test the functionality.

Also note that the minimum screen resultion for this game is 1368x768

ENJOY!

