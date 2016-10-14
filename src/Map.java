/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Shreyash Patodia> <spatodia>
 * Student Number : 767336.
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains an extension to the
 * already defined TiledMap class in order to
 * make the manipulations of the map easier. 
 */

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/** Extends the functionality of the already
 * available TiledMap class
 */
public class Map extends TiledMap
{
	/** Create a new Map object
	 * @param map_file - the .tmx file we need
	 * to create the map. 
	 * @param assets_file - the path to the 
	 * assets directory of our project.
	 */
	public Map(String map_file, String assets_file)
	throws SlickException
	{
		super(map_file, assets_file);
	}
	
	/** Function checks if the player is venturing onto 
	 * a tile that is blocking or not 
	 * @param player_x - new x-coordinate of the player.
	 * @param player_y - new y-coordinate of the player.
	 * @return true if tile is blocking else false. 
	 */
	public boolean blocks(float x, float y)
    {
 
    	boolean isBlocking = false;
    	
    	/* Check and return if the tile is blocking. */
    	int tileID = this.getTileId((int)x, (int)y, 0); 
    	if(tileID == Constant.OUT_OF_BOUNDS)
    		return true;
    		
    	if(this.getTileProperty(tileID, "block", "0").equals("1"))
    	{
    		isBlocking = true; 
    	}
    	return isBlocking; 
    	
    }
	
	 @Override
	 public int getTileId(int x,int y, int layerIndex) 
	 {
	        try 
	        {
	            return super.getTileId(x / this.getTileWidth(),
	                    y / this.getTileHeight(), layerIndex);
	        } 
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	            return Constant.OUT_OF_BOUNDS;
	        }
	 }
}