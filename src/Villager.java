


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


/**
 * 
 */
public abstract class Villager extends Unit implements Interactable
{

    private String VillagerDialog[]; 
    private boolean talk;
    
    public boolean isTalking() 
    {
		return talk;
	}

	public void setTalk(boolean talk) 
	{
		this.talk = talk;
	}

	private String currentlySaying;
    
    public String getCurrentlySaying() 
    {
		return currentlySaying;
	}
    
    public String dialogAtIndex(int index)
    {
    	if (index >= VillagerDialog.length)
    		return null;
    	else return VillagerDialog[index];
    }

	public void setCurrentlySaying(String currentlySaying) 
	{
		this.currentlySaying = currentlySaying;
	}

	private double speechDuration;
    
   
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
	public boolean isWithinRange(Interactable other) 
	{
		
		return getDistance(other) <= collideRange;
	}

	@Override
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
		{
			return false;
		}
		
		return ((Villager)other).getName().equals(this.getName()) && other == this;
		
	}

	private void setIfDead()
	{
		if(this.getHP() <= 0)
			this.setDead(true);
	}

	@Override
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
	public boolean isActive() 
	{
		return this.getHP() >= 0;
	}

	@Override
	public InteractorTag identify() 
	{
		return InteractorTag.Villager;
	}
	
	private float getDistance(Interactable other)
	{
        return (float)Math.sqrt(getPos().distanceSquared(other.getPos()));
    }
	
	private void renderSpeech(Graphics g) 
	{
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.3f);   // Black, transp

        float dialogXOffset = g.getFont().getWidth(currentlySaying);
        dialogXOffset =  -dialogXOffset/2;

        float x = getxPos() + dialogXOffset;
   
        float y = getyPos() + Constant.BAR_Y_OFFSET - Constant.BAR_HEIGHT;

        int barWidth = Math.max(g.getFont().getWidth(currentlySaying) + Constant.ADD_TO_FONT_WIDTH, Constant.BAR_Y_OFFSET);
        int barHeight = Constant.BAR_HEIGHT;

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
	
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) 
	{
		
	}
    

}