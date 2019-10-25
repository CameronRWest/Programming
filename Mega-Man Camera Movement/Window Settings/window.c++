//check for odd number monitors
idealWidth = 400;
idealHeight = 224;
if(idealWidth & 1) idealWidth++;
if(idealHeight & 1) idealHeight++;

//resize all properties
surface_resize(application_surface, idealWidth, idealHeight);
display_set_gui_size(idealWidth, idealHeight);
window_set_size(idealWidth*2, idealHeight*2);
alarm[0] = 1; //center's window

//create a camera
camera = camera_create();

//position variables
global.viewX = 0;
global.viewY = 0;
global.viewW = idealWidth;
global.viewH = 224;
