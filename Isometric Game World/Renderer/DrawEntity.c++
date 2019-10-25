///@desc draws the entity
// This will draw the entity at the correct angle to make up for the game plane shift.

var _degree_fix, _degree_divisor = 0;

if num_of_dir_ == 16 {
	_degree_fix = 7.5;
	_degree_divisor = 22.5;
} else {
	_degree_fix = 15;
	_degree_divisor = 45;
}

if moving_ && curr_state_ != STATE.DEAD {
	//get direction
	y_frame_ = floor(  (dir_ +_degree_fix) / _degree_divisor) ;
	if y_frame_ == num_of_dir_ y_frame_ = 0;
	
	//increment frame for animation
	x_frame_ += anim_speed_/room_speed;
	if (x_frame_ >= anim_length_) x_frame_ = 0;
} else {
	/*	bit of a lag at beginning of movement, 
		set to 0.9 instead of 0 so that it's
		closer to the next frame.
	*/
	x_frame_ = 0.9;	
}

//draw sprite part
draw_sprite_part(	sprite_array_[sprite_], 0, 
					floor(x_frame_) * x_frame_size_, 
					y_frame_ * y_frame_size_, 
					x_frame_size_, y_frame_size_, x, y);
