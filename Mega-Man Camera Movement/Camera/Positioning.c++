/// @description camera position

if !global.freeze {
	//follow player
	global.viewX = round(oPlayer.x - (global.viewW / 2));
	global.viewY = round(oPlayer.y - (global.viewH / 2));

	//stop at area borders
	global.viewX = clamp(global.viewX, areaLeft, areaRight - global.viewW);
	global.viewY = clamp(global.viewY, areaTop, areaBottom - global.viewH);

	//stop at room borders
	global.viewX = clamp(global.viewX, 0, room_width - global.viewW);
	global.viewY = clamp(global.viewY, 0, room_height - global.viewH);
}
