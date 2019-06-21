# Isometric Game World
## Programming Practice: Creating an isometric world. 

## Objective
Create something similar to how Diablo 2 looks. 

## Plan
#### Basics
Create a grid for map, mark each space as a piece of terrain from TERRAIN array. 
Run through grid and draw sprite corresponding to each terrain. 
Have a random variant of sprite be used when drawing.

#### Sprite
Create a sprite pertaining to each terrain piece. (Grass, rock, water, etc.)
Sprite should be two times wider than tall. If height is 16px then width is 32px. 
Create variants for sprites. 

#### Point conversion
Need two scripts for point conversions. One going from screen to map, the other going from map to screen. 
Math reference (http://clintbellanger.net/articles/isometric_math/)

> map.x = (screen.x / TILE_WIDTH_HALF + screen.y / TILE_HEIGHT_HALF) /2;

> map.y = (screen.y / TILE_HEIGHT_HALF -(screen.x / TILE_WIDTH_HALF)) /2;
