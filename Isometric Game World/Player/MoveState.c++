//This is an example of one of the states used to control the player. In this you will see the behavior of the move state.
//followed by the transitional triggers into other states.


//-------------------------------BEHAVIOR---------------------------
TODO; //insert a collision check for o_solid

//record position and parent info
var _inst = o_mouse.clicked_instance_;
var _par = o_mouse.clicked_instance_parent_;
var _dist_from_dest = 2;

switch _par {
	case o_ENEMY:		//move to enemy (no attack)
	case o_DESCRUCTIBLE://walk to object and kick/open
	case o_ALLY:		//walk to ally 
	case o_NPC: {		//walk to NPC and open talk dialog
		var _x = _inst.x_ - x_offset_;
		var _y = _inst.y_ - y_offset_;
		} break;	
	case o_ENTITY:
	case -1: {		//move to where mouse is
		var _x = o_mouse.x_ - x_offset_;
		var _y = o_mouse.y_ - y_offset_;
		} break;
	case -100: debug("NO PARENT HAS BEEN ASSIGNED");
}

//execute movement
var _point_dist = point_distance(x, y, _x, _y);
if _point_dist > _dist_from_dest {
	moving_ = true;
	dir_ = point_direction(x, y, _x, _y);
	move_x_ = lengthdir_x(h_spd_, dir_);
	move_y_ = lengthdir_y(v_spd_, dir_);

	//apply movement
	x += move_x_;
	y += move_y_;
	
	
	
	


//--------------------------TRANSITION TRIGGER-----------------------
} else if _point_dist <= _dist_from_dest {
	moving_ = false;
	
	//extra behavior once we arrive at instance
	switch _par {
		case o_DESCRUCTIBLE: {
			//run action script (open door/chest, kick box/barrel)	
			//_inst.state_ = DESTRUCTIBLE.ACTIVATED; //runs the script in the object
			} break;
		case o_ALLY: {
			//open up ALLY dialog
			//_inst.state_ = ALLY.ACTIVE; //runs the script in the object
			} break;
		case o_NPC: {
			//open up NPC dialog
			//_inst.state_ = NPC.ACTIVE; //runs the script in the object
			} break;
	}
}
if (o_input.right_mouse_click_) curr_state_ = STATE.ATTACK;
else if (moving_ == false) curr_state_ = STATE.IDLE;
