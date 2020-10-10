# README

## How to use the config file.
This config file is a simple Json archive.
Different fields are intuitively named, and take string values that will be interpreted by the app upon launch.

### heroSize
A string specifying the size of the hero. Options are normal, large, tiny. Defaults to normal on invalid input.

### mapHeight
Specifies the pixelHeight of the stage - note that this is not the window height (which is fixed)

### floorHeight
Specifies the height of the floor from the bottom of the window (Not from the top, where y=0)

### heroPos
An array containing the starting coordinates of the hero, x and y, of the heros bottom left corner. Y value is from the 
bottom of the stage, not the top.

### cloudVelocity
Unimplemented.

### platformsPos
An array of Json objects, each containing:
- xPos: X coordinate of the left side of the platform
- yPos: Y Coordinate of the platform
- length: How far to the right of the xPos the platform extends.

### mushroomsPos
An array of single values, each value indicates the x-Coord of a mushroom. These are placed along the floorheight.

### enemies
An array of Json objects, each containing:
- type: blue or red - blue jumps right to left until blocked, red slowly drifts right.
- xPos: the starting position of the enemy - it will be distributed along the stages floor.


### flagPos
A set of coordinates for the flag - xcoordinate, and yCoordinate from the bottom of the stage. Bottom of the flag at that value.


## Config file names:
- configExample.json
- chaos1.json
- tall1.json
- basic1.json
- tiny1.json
- big1.json


## How to change levels:
In the app class, simply change the file string passed to the stickmanEngine constructor to 
whatever json file you would like listed above - path relative to the project dir.
You can also adjust however you would like in any of those files according to the description above.

## Keys
Left/Right to move
Up to jump
Space to shoot


## Other points
The way I interpreted the specification, the user will be reset upon death for 3 lives - but the stage persists.
If they die, they lose the ability to shoot. This means that a player can run out of mushrooms if they keep dying.
Bullets despawn if they leave the screen or hit a platform, but most things do not collide rigidly - only platforms and
invisible barriers. 