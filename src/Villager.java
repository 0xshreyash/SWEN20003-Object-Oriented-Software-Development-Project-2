
import java.util.*;
import org.newdawn.slick.SlickException;

/**
 * 
 */
public abstract class Villager extends Unit
{

    private String VillagerDialog[]; 
    
    private String VillagerName; 
    
    public Villager(String VillagerImagePath, float starting_X, float starting_Y,
			 String []Dialog, String name) 
    throws SlickException
    {
    	super(VillagerImagePath, starting_X, starting_Y
    			,Constant.VillagerHP, Constant.VillagerSpeed
    			,Constant.VillagerDamage, Constant.VillagerCooldown);
    	
    	System.arraycopy( Dialog, 0, VillagerDialog, 0, Dialog.length );
    	VillagerName = name; 
  
    }

    public String getName() 
    {
        return VillagerName; 
    }
    
    public String[] getDialog()
    {
    	return VillagerDialog;
    }
    
    public boolean isInteractor(Interactable other)
    {
    	return other instanceof Player;
    }
    

}