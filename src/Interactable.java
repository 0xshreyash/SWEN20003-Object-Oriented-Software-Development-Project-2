
public interface Interactable 
{	
	public abstract boolean withinRange(Interactable other);
	
	public abstract void action(Interactable other);
	
	public abstract Enum<?>[] getInteractors();		
}
