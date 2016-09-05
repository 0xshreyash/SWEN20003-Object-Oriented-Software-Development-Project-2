/* 433-294 Object Oriented Software Development

 * RPG Game Engine
 * Author: <Shreyash Patodia> <spatodia>
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */

public class World
{

	private Player player = null; 
	private TiledMap map = null;
	private Camera cam = null;

	
    /** Create a new World object. */
    public World()
    throws SlickException
    {
    	this.player = new Player(RPG.PLAYER_IMG);
    	this.map = new TiledMap(RPG.MAP, RPG.ASSETS); 
    	this.cam = new Camera(player, RPG.screenwidth, RPG.screenheight); 
    }
    
    
    

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(double dir_x, double dir_y, int delta)
    throws SlickException
    {
    	cam.update();
        player.update_position(this, dir_x, dir_y, delta);
        
        return; 
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
    throws SlickException
    {
    	int screen_width = (int)(RPG.screenwidth/map.getTileWidth() + 2);
    	int screen_height = (int)(RPG.screenheight/map.getTileWidth() + 2);
    	int screen_start_at_tile_x = (int)(this.cam.getMinX()/map.getTileWidth()); 
    	int screen_start_at_tile_y = (int)(this.cam.getMinY()/map.getTileHeight()); 
    	int pixel_to_start_at_x = (int)(this.cam.getMinX()%map.getTileWidth());
    	int pixel_to_start_at_y  = (int)(this.cam.getMinY()%map.getTileHeight());
    	map.render(-pixel_to_start_at_x, -pixel_to_start_at_y, screen_start_at_tile_x, screen_start_at_tile_y, screen_width, screen_height);
    	player.render(g, this.cam);
    	
        
    }
    
    public boolean blocks(double player_x, double player_y)
    {
    	int x_tile = (int)(player_x/map.getTileWidth()); 
    	int y_tile = (int)(player_y/map.getTileHeight()); 
    	int tileID = map.getTileId(x_tile, y_tile, 0); 
    	return (map.getTileProperty(tileID, "block", "0").equals("1"))?true:false;
    	
    }
}
