import java.awt.*;


public class Lion extends Feline{
    // for avoiding using magic number
    private static final String lionRepresentation = "Lion";
    private static final String lionSleep = "noiL";
    private static final String strongLion = "LION";
    
    private static final int movementWest = 1;
    private static final int movementEast = 3;
    private static final int movementNorth = 2;
    private static final int movementSouth = 0;
    private static final int steps = 5;


    // keep track of the number of fights it wins
    // until it goes to sleep
    private int fights;

    // keep track of the Lion's movement
    private int movementNumber;
    // record the times of moving in the same direction
    
    private int timesCount;
    
    // keep track of hunger
    // 1 represents that the lion is not hungry
    // and 0 means it is hungry
    private int hunger = 1;

    
    public Lion(){
        this.displayName = lionRepresentation;
    }

    @Override
    public Color getColor(){
        return Color.YELLOW;
    }
    
    @Override
    public Direction getMove() {
        // if the lion has not moved in one direction 5 times
        // do not change the current direction
        if (timesCount < steps){
            
            if (movementNumber == movementSouth){
                timesCount++;
                return Direction.SOUTH;
            }
            else if (movementNumber == movementWest){
                timesCount++;
                return Direction.WEST;
            }
            else if (movementNumber == movementNorth){
                timesCount++;
                return Direction.NORTH;
            }
            else if (movementNumber == movementEast){
                timesCount++;
                return Direction.EAST;
            }
        }
        else{
            // reset 
            timesCount = 0;           
            // change into next direction
            
            movementNumber++;
            
            // if the lion has finished moving east 5 times
            // reset movementNumber to 0
            if (movementNumber > movementEast){
                movementNumber = 0;
                timesCount++;
                return Direction.SOUTH;
            }
            else{
                if (movementNumber == movementSouth){
                    timesCount++;
                    return Direction.SOUTH;
                }
                else if (movementNumber == movementWest){
                    timesCount++;
                    return Direction.WEST;
                }
                else if (movementNumber == movementNorth){
                    timesCount++;
                    return Direction.NORTH;
                }
                else if (movementNumber == movementEast){
                    timesCount++;
                    return Direction.EAST;    
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean eat() {
        if ((fights > 0) && (hunger == 0)){
            // hunger = 1 means that the lion has eaten
            hunger = 1;
            return true;
        }
        else{
            return false;
        }

  
    }
    @Override
    public void sleep() {
        fights = 0;
        hunger = 1;
        this.displayName = lionSleep;
    }
    
    @Override
	public void wakeup() {
	    this.displayName = lionRepresentation;
    }

    @Override
	public void win() {
	    // the lion becomes hungry
        hunger = 0;
        
        // keep track of the number of fights
        fights++;
    
    }
    
    @Override
   /** change the display name temporarily to capital letter: LION.
    *
    * @param s the status of a lion
    * @return nothing
    */
    public void buffBehavior(CritterState s){
    	this.displayName = strongLion;
    }
    
    @Override
   /**  change the display name back to Lion.    
    * 
    * @param s the status of a lion
    * @return nothing
    */

    public void debuff(CritterState s){
    	this.displayName = lionRepresentation;
    }

}
