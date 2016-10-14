/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class Villager extends Unit implements Interactable
{
	/** Setting the class variables
	 */
    private String VillagerDialog[]; 
    private boolean talk;
    
    /** Checking if a villager is talking
     * @return boolean of the talking state
     */
    public boolean isTalking() 
    {
		return talk;
	}

    /** Setting the dialogue of a village
     * @param talk is the dialogue
     */
	public void setTalk(boolean talk) 
	{
		this.talk = talk;
	}

	/** What a villager is saying now
	 */
	private String currentlySaying;
    
	/** Getter for the current dialogue
	 * @return the current dialogue
	 */
    public String getCurrentlySaying() 
    {
		return currentlySaying;
	}
    
    /** Returns the dialogue of the index
     * @param index the position of the required dialog
     * @return the dialog at required position
     */
    public String dialogAtIndex(int index)
    {
    	if (index >= VillagerDialog.length)
    		return null;
    	else return VillagerDialog[index];
    }

    /** Setter for the current dialogue
     * @param currentlySaying what the character is saying now
     */
	public void setCurrentlySaying(String currentlySaying) 
	{
		this.currentlySaying = currentlySaying;
	}

	/** Setting the length of a speech for a villager
	 */
	private double speechDuration;
    
   /** Constructor for this class
    * @param VillagerImagePath directory where the image of the villager is located
    * @param starting_X satring x position
    * @param starting_Y starting y position
    * @param Dialog is the dialogue for the villager
    * @param VillagerName name of the villager
    * @throws SlickException 
    */
    public Villager(String VillagerImagePath, float starting_X, float starting_Y,
			 String []Dialog, String VillagerName) 
    throws SlickException
    {
    	super(VillagerImagePath, starting_X, starting_Y
    			,Constant.VillagerHP, Constant.VillagerSpeed
    			,Constant.VillagerDamage, Constant.VillagerCooldown, VillagerName);
    	VillagerDialog = new String[Constant.MAX_NO_OF_DIALOGS];
    	System.arraycopy(Dialog, 0, VillagerDialog, 0, Dialog.length);
    	talk = false; 
    	speechDuration = 0;
  
    }
   

	@Override
	/** Checking if a unit is within reach of the player
	 */
	public boolean isWithinRange(Interactable other) 
	{
		
		return getDistance(other) <= collideRange;
	}

	@Override
	/** Checks if two interactables are same or not
	 */
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
		{
			return false;
		}
		
		return ((Villager)other).getName().equals(this.getName()) && other == this;
		
	}

	/** Setter of whether a unit is dead or not
	 */
	private void setIfDead()
	{
		if(this.getHP() <= 0)
			this.setDead(true);
	}

	@Override
	/** Updating the map with the units that are dead and whether any dialogue was said
	 */
	public void update(Map map, int delta)
	{
		setIfDead();
		if(this.isDead())
		{
			return;
		}
		if(talk)
		{
			speechDuration = speechDuration + delta;
		}
	}

	@Override
	/** Rendering the screen with the new state of the world
	 * 	Checking for dialogue and life state of the unit  
	 */
	public void render(Graphics g) 
	{
		this.renderHealthBar(g);
		if(isDead())
			return;
		if(talk)
			renderSpeech(g);
		
		this.getImage().drawCentered(this.getxPos(), this.getyPos());
		
	}

	@Override
	/** Checks whether a unit is dead not
	 */
	public boolean isActive() 
	{
		return this.getHP() >= 0;
	}

	@Override
	/** Returns the ID of the interactable
	 */
	public InteractorTag identify() 
	{
		return InteractorTag.Villager;
	}
	
	/** Getting the distance between the player and an interactable
	 * @param other an interactable
	 * @return distance of the player from the interactable
	 */
	private float getDistance(Interactable other)
	{
        return (float)Math.sqrt(getPos().distanceSquared(other.getPos()));
    }
	
	/** This renders the speech of the villager
	 * @param g the slick graphics container
	 */
	private void renderSpeech(Graphics g) 
	{
		//Setting the colours
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.3f);   // Black, transp

        
        //setting the bar dimensions
        float dialogXOffset = g.getFont().getWidth(currentlySaying);
        dialogXOffset =  -dialogXOffset/2;

        float x = getxPos() + dialogXOffset;
   
        float y = getyPos() + Constant.BAR_Y_OFFSET - Constant.BAR_HEIGHT;

        int barWidth = Math.max(g.getFont().getWidth(currentlySaying) + Constant.ADD_TO_FONT_WIDTH, Constant.BAR_Y_OFFSET);
        int barHeight = Constant.BAR_HEIGHT;
        
        
        //filling the bar in with what is currently being said by the character
        g.setColor(BAR_BG);
        g.fillRect(x, y, barWidth, barHeight);

        g.setColor(VALUE);
        g.drawString(currentlySaying, x, y);

        if (speechDuration >= Constant.VILLAGER_SPEECH_TIME) 
        {
            talk = false;
            currentlySaying = null;
            speechDuration = 0;
        }
        
   
    }
	
	/** Updating the map with the new state of the world
	 */
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) 
	{
		
	}
    

}