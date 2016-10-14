/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Tome extends Item implements Interactable
{
	/**
     * Decreasee in coolDown in order to increase
     * attackSpeed
     */
	int coolDownBoost; 

    /**
     * Default constructor
     */
    public Tome() 
    throws SlickException
    {
    	super(Constant.TOME_X, Constant.TOME_Y, Constant.TOME_PATH, Constant.TOME);
    	coolDownBoost = Constant.TOME_BOOST;
    }

    
    /**
     * Decides whether to act on otehr depending
     * on the identity of other
     * 
     */
    public void action(Interactable other) 
    {
        if(other.identify() == InteractorTag.Player)
        {	
        	((Player)other).getInv().addItem(this);
        	((Player)other).setMaxCoolDown(((Player)other).getMaxCoolDown() + coolDownBoost);
       
        		
        }
    }

}