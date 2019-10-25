/// @desc Build the map
// This will run through the tile map and draw in place a corresponding terrain block.

layer_set_visible("Map", false);
global.theMap = ds_grid_create(MAP_W, MAP_H);
tile_map_ = layer_tilemap_get_id("Map");
tile_sprite_ = 0;

//run through map
for (var _tx = 0; _tx < MAP_W; _tx++) {
	for (var _ty = 0; _ty < MAP_H; _ty++) {
		tile_map_data_ = tilemap_get(tile_map_, _tx, _ty);
		
		//Format: [Sprite, Z, Index]
		this_tile_ = [-1, 0, 0];
		this_tile_[TILE.SPRITE] = tile_map_data_;
		if this_tile_[TILE.SPRITE] == TERRAIN.WATER {
			this_tile_[TILE.Z] = 16;
			this_tile_[TILE.INDEX] = irandom(2);
		}
		else if this_tile_[TILE.SPRITE] == TERRAIN.DIRT {
			this_tile_[TILE.Z] = -16;
			this_tile_[TILE.INDEX] = irandom(2);
		}
		else if this_tile_[TILE.SPRITE] == TERRAIN.GRASS {
			this_tile_[TILE.Z] = 0;
			this_tile_[TILE.INDEX] = irandom(2);
		}
		else if this_tile_[TILE.SPRITE] == TERRAIN.SOLID {
			this_tile_[TILE.Z] = -32;
			this_tile_[TILE.INDEX] = 0;
		}
		
		global.theMap[# _tx, _ty] = this_tile_; 
	}
}
