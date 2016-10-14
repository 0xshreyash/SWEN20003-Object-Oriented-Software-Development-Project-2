/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Shreyash Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
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
  

    
    
    /***************** Methods ***********************/
    
    /** Create a new Camera object.
     *  @param player - object of type Player that the camera 
     *  should follow.
     *  @param screenwidth - the width of the screen that we should 
     *  display.
     *  @param screenheight - the height of the screen that we should 
     *  display.
     */
    public Camera( int screenwidth, int screenheight)
    throws SlickException
    {   
    	this.screenwidth = screenwidth; 
    	this.screenheight = screenheight; 
    }
    
    /** Getter method to get the xPos of the camera.
     * @param No parameters.
     * @return x-coordinate of the camera.
     */
    /*public double getxPos() 
    {
    	return this.xPos;
    }*/

    /** Getter method to get the yPos of the camera.
     * @param No parameters.
     * @return y-coordinate of the camera.
     */
    /*public double getyPos() 
    {
        return this.yPos;
    }*/

    /** Update the game camera to re-center it's viewpoint
     * around the player (design extended to make sure that
     * the camera doesn't re-center around the edges of the 
     * map making sure we don't have black regions appearing)
     * @param No parameters.
     * @return void.
     */
    public void update()
    throws SlickException
    {
	     
		/* gamewidth is the maximum width of the game and the 
		 * min_X is the minimum x-coordinate of the game i.e. 
		 * 0.
		 */
        //if((int)Math.ceil(unitFollow.getxPos() + screenwidth/2) < Constant.gamewidth
        //&& (int)Math.floor(unitFollow.getxPos() - screenwidth/2) > Constant.min_X)
        //{
    		/* re-center only if the game map has enough tiles
    		 * to be displayed in either side of the x-direction. 
    		 */
        	//this.xPos = unitFollow.getxPos(); 
        //}
        
        /* gameheight is the maximum height of the game and the 
		 * min_Y is the minimum y-coordinate of the game i.e. 
		 * 0.
		 */
        //if((int)Math.ceil(unitFollow.getyPos() + screenheight/2) < Constant.gameheight
        //&& (int)Math.floor(unitFollow.getyPos() - screenheight/2) > Constant.min_Y)
        //{
        	/* re-center only if the game map has enough tiles
    		 * to be displayed in either side of the y-direction. 
    		 */
    		//this.yPos = unitFollow.getyPos();
        //}
        
        return; 
    }
    
    /** Returns the minimum x value on screen.
     * @param No parameters.
     * @return minimum x-coordinate in pixels that should be displayed
     * on the screen.
     */
    public float getMinX()
    {
        return (unitFollow.getxPos() - (this.screenwidth)/2);    
    }
    
    /** Returns the maximum x value on screen.
     * @param No parameters.
     * @return maximum x-coordinate in pixels that should be displayed
     * on the screen.
     */
    public float getMaxX()
    {
        return (unitFollow.getxPos() + (this.screenwidth)/2);    
    }
    
    /** Returns the minimum y value on screen.
     * @param No parameters.
     * @return minimum y-coordinate in pixels that should be displayed.
     * on the screen.
     */
    public float getMinY()
    {	
    	return (unitFollow.getyPos() - (this.screenheight)/2);   
    }
    
    /** Returns the maximum y value on screen.
     * @param No parameters.
     * @return maximum y-coordinate in pixels that should be displayed
     * on the screen.
     */
    public float getMaxY()
    {
    	return (unitFollow.getyPos() + (this.screenheight)/2); 
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