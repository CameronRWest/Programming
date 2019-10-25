/// @description check the area bounds
var tile = global.tileSize;
var tooFar = tile*999;

//-----------------------RIGHT
dist = 0;
while( !place_meeting( ceil(x+newAreaXOffset) + dist, y, oAreaBorderRight) 
		&& dist <= tooFar){
	dist += tile;
}
areaRight = instance_place( ceil(x+newAreaXOffset) + dist, y, oAreaBorderRight).x + tile;

//-----------------------LEFT
dist = 0;
while( !place_meeting( floor(x+newAreaXOffset) - dist, y, oAreaBorderLeft)
		&& dist <= tooFar){
	dist += tile;	
}
areaLeft = instance_place( floor(x+newAreaXOffset) - dist, y, oAreaBorderLeft).x;

//-----------------------TOP
dist = 0;
while( !place_meeting( x, ceil(y+newAreaYOffset) - dist, oAreaBorderTop)
		&& dist <= tooFar){
	dist += tile;			
}
areaTop = instance_place( x, ceil(y+newAreaYOffset) - dist, oAreaBorderTop).y;

//-----------------------BOTTOM
dist = 0;
while( !place_meeting( x, floor(y+newAreaYOffset) + dist, oAreaBorderBottom)
		&& dist <= tooFar){
	dist += tile;			
}
areaBottom = instance_place( x, floor(y+newAreaYOffset) + dist, oAreaBorderBottom).y + tile;

