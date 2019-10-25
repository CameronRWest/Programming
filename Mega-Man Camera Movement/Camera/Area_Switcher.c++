/// @description checks if we are switching areas

//----------------------RIGHT
if(x > (areaRight - halfPlayer)
	&& place_meeting(x+hspd-halfPlayer, y, oAreaArrowRight)) {
		activate_borders();
		newAreaXOffset = 64;
		if bbox_top <= global.viewY newAreaYOffset = 96;
		else if bbox_bottom >= global.viewY+global.viewH newAreaYOffset = -96;
		else newAreaYOffset = 0;
		direct = "Right";
		alarm[0] = 1;
}
//----------------------LEFT
else if(x < (areaLeft - halfPlayer)
	&& place_meeting(x-hspd+halfPlayer, y, oAreaArrowLeft)) {
		activate_borders();
		newAreaXOffset = -64;
		if bbox_top <= global.viewY newAreaYOffset = 96;
		else if bbox_bottom >= global.viewY+global.viewH newAreaYOffset = -96;
		else newAreaYOffset = 0;
		direct = "Left";
		alarm[0] = 1;
}
//----------------------UP
else if(y+halfPlayer < (areaTop + halfPlayer)
	&& place_meeting(x, y-vspd-halfPlayer, oAreaArrowUp)){
		activate_borders();
		newAreaXOffset = 0;
		newAreaYOffset = -64;
		direct = "Up";
		alarm[0] = 1;
}
//----------------------DOWN
else if(y+quarterPlayer> (areaBottom - halfPlayer)
	&& place_meeting(x, y-vspd+halfPlayer, oAreaArrowDown)){
		activate_borders();
		newAreaXOffset = 0;
		newAreaYOffset = 64;
		direct = "Down";
		alarm[0] = 1;		
}

