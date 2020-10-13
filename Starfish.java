import java.awt.*;
import java.util.*;

public class Starfish extends Critter{
    // for not using magic numbers
    private static final String starfishRepresentation = "Patrick";

    public Starfish() {
        super(starfishRepresentation);
    }

    @Override 
    public Color getColor() {
        return Color.PINK;
    }

    @Override
    public void buffBehavior(CritterState s){
    	// A very humble animal, making the manager thinks there's no
    	// starfish at all!!!
    	s.count -= 1;
    	this.displayName = "";
    }

    @Override
    public void debuff(CritterState s){
    	s.count += 1;
    	this.displayName = starfishRepresentation;
    }

    //Student TODO
    //Starfish is able to teleport to another place
    //To do that, reset the position in currentLocation and remove previous location
    //from the arena
    public void teleport(Point currentLocation, Critter[][] arena){

    
    
    }
}
