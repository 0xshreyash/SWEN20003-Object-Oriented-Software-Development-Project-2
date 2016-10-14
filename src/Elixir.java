/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */


import org.newdawn.slick.SlickException;


public class Elixir extends Item implements Interactable
{

    /**
     * Default constructor
     */
    public Elixir() 
    throws SlickException
    {
    	super(Constant.ELIXIR_X, Constant.ELIXIR_Y, Constant.ELIXIR_PATH, Constant.ELIXIR);
    	
    }

    /** Decides how to add depending on the ID of other
     * @param other the object's ID that needs to be checked
     * @return void 
     */
    public void action(Interactable other) 
    {
        if(other.identify() == InteractorTag.Player)
        {
        	((Player)other).getInv().addItem(this);
        	
        }
    }

}