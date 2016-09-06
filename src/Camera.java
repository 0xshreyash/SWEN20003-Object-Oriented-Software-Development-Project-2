/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Shreyash Patodia> <spatodia>
 * Student Number : 767336
 * 
 * This file contains the camera class which manages the movement of
 * the camera on the screen.
 */

import org.newdawn.slick.SlickException;

/** Represents the camera that controls our viewpoint.
 */
public class Camera
{
	/**************** Attributes *********************/
	
    /** The unit this camera is following. */
    private Player unitFollow;
    
    /** The width and height of the screen. */
    /** Screen width, in pixels. */
    public final int screenwidth;
    /** Screen height, in pixels. */
    public final int screenheight;
    
 
    /** The camera's position in the world, in x and y coordinates. */
    /** x-coordinate of the camera. in pixels. */
    private double xPos;
    /** y-coordinate of the camera, in pixels. */
    private double yPos;
    
    /***************** Methods ***********************/
    
    /** Create a new Camera object.
     *  @param player - object of type Player that the camera 
     *  should follow.
     *  @param screenwidth - the width of the screen that we should 
     *  display.
     *  @param screenheight - the height of the screen that we should 
     *  display.
     */
    public Camera(Player player, int screenwidth, int screenheight)
    throws SlickException
    {   
    	followUnit(player);
    	this.screenwidth = screenwidth; 
    	this.screenheight = screenheight; 
    }
    
    /** Getter method to get the xPos of the camera.
     * @param No parameters.
     * @return x-coordinate of the camera.
     */
    public double getxPos() 
    {
    	return this.xPos;
    }

    /** Getter method to get the yPos of the camera.
     * @param No parameters.
     * @return y-coordinate of the camera.
     */
    public double getyPos() 
    {
        return this.yPos;
    }

    /** Update the game camera to re-center it's viewpoint
     * around the player.
     * @param No parameters.
     * @return void.
     */
    public void update()
    throws SlickException
    {
	    	/* Change coordinates of the camera. */
	    	
	    	/* Do not move the camera if we are approaching the end of the
	    	 * game map as there is no more map to render and display. 
	    	 */
        if((int)Math.ceil(unitFollow.getxPos() + RPG.screenwidth/2) < RPG.gamewidth
        && (int)Math.floor(unitFollow.getxPos() - RPG.screenwidth/2) > RPG.min_X)
        {
        		this.xPos = unitFollow.getxPos(); 
        }
        
        if((int)Math.ceil(unitFollow.getyPos() + RPG.screenheight/2) < RPG.gameheight
        && (int)Math.floor(unitFollow.getyPos() - RPG.screenheight/2) > RPG.min_Y)
        {
        		this.yPos = unitFollow.getyPos();
        }
        return; 
    }
    
    /** Returns the minimum x value on screen.
     * @param No parameters.
     * @return minimum x-coordinate in pixels that should be displayed
     * on the screen.
     */
    public double getMinX()
    {
        return (this.xPos - (this.screenwidth)/2); 
        
    }
    
    /** Returns the maximum x value on screen.
     * @param No parameters.
     * @return maximum x-coordinate in pixels that should be displayed.
     * on the screen.
     */
    public double getMaxX()
    {
        return (this.xPos + (this.screenwidth)/2); 
        
    }
    
    /** Returns the minimum y value on screen.
     * @param No parameters.
     * @return minimum y-coordinate in pixels that should be displayed.
     * on the screen.
     */
    public double getMinY()
    {	
    	return (this.yPos - (this.screenheight)/2);
       
    }
    
    /** Returns the maximum y value on screen.
     * @param No parameters.
     * @return maximum y-coordinate in pixels that should be displayed
     * on the screen.
     */
    public double getMaxY()
    {
    	return (this.yPos + (this.screenheight)/2); 

    }

    /** Tells the camera to follow a given unit. 
     * @param unit - The player that the camera is meant to follow.
     * @return void.
     */
    public void followUnit(Object unit)
    throws SlickException
    {
        unitFollow = (Player)unit;
        return; 
    }
    
}