import java.util.Random;
import java.awt.*;


public class Leopard extends Feline{
    // for not using magic numbers
    private static final String leopardRepresentation = "Lpd";
    private static final String leopardBuff = "lalalala~~~~";

    private static final String turtleRepresentation = "Tu";
    private static final String foodRepresentation = ".";
    private static final String starfishRepresentation = "Patrick";
    private static final int directionNumber = 4;
    private static final int directionWest = 2;
    private static final int directionEast = 3;
    private static final int directionNorth = 0;
    private static final int directionSouth = 1;
    private static final int confidenceCheck = 5;
    private static final int attackMethods = 3;
    private static final int confidenceMax = 10;
    private static final int confidenceMin = 0;
    private static final int sampleSpace = 100;
 
    protected static int confidence;  

    public Leopard(){
        this.displayName = leopardRepresentation;
    }
    @Override
    public Color getColor(){
        return Color.RED;
    }
    
    @Override
    /** The Leopard always checks its neighbors before moving. 
     * If one of the four neighbors-NORTH, SOUTH, EAST, WEST- 
     * contains either food or Starfish, then the Leopard will 
     * move towards that direction. Checking order follows the N S E W order. 
     * If more than one direction 
     * has Starfish or food, then the Leopard will move towards 
     * the first found direction. If none of the directions contain 
     * Starfish or food, then the Leopard will randomly choose a direction 
     * to move (excluding CENTER).    
     * 
     * @param none
     * @return the direction of the Leopard
     */

    public Direction getMove() {
        if ((getNeighbor(Direction.NORTH) == foodRepresentation)
            || (getNeighbor(Direction.NORTH) == starfishRepresentation)){
            return Direction.NORTH;
        }
        else if ((getNeighbor(Direction.SOUTH) == foodRepresentation)
            || (getNeighbor(Direction.SOUTH) == starfishRepresentation)){
            return Direction.SOUTH;
        }
        else if ((getNeighbor(Direction.EAST) == foodRepresentation)
            || (getNeighbor(Direction.EAST) == starfishRepresentation)){
            return Direction.EAST;
        }
        else if ((getNeighbor(Direction.WEST) == foodRepresentation)
            || (getNeighbor(Direction.WEST) == starfishRepresentation)){
            return Direction.WEST;
        }
        else{
            int randomDirection = random.nextInt(directionNumber);
            if (randomDirection == directionNorth){
                return Direction.NORTH;

            }
            else if (randomDirection == directionSouth){
                return Direction.SOUTH;
            }
            else if (randomDirection == directionEast){
                return Direction.EAST;
    
            }
            else if (randomDirection == directionWest){
                return Direction.WEST;
            }
        }
        return null;    
    }
    
    @Override
    public boolean eat() {
        Random random = new Random();
        int probability = confidence * confidenceMax;
        boolean Eat = random.nextInt(sampleSpace) < probability;
        if (Eat == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    /** If a Leopard wins a fight, 
     * all Leopards confidence will increment 
     * by one if their confidence is less than 10
     *
     * @param none
     * @return nothing
     */
        
	public void win() {
        if (confidence < confidenceMax){
            confidence++;
        }
    }
    
    @Override
    /** If a Leopard loses, 
     * all Leopards confidence will be reduced
     * by one if confidence is greater than zero
     *
     * @param none
     * @return nothing
     */

    public void lose() {
	    if (confidence > confidenceMin){
            confidence--;
        }
    }

    @Override
    /** the Leopard will ROAR if the opponent is Turtle or 
     * if all Leopards' confidence is greater than 5. 
     * Otherwise, the Leopard will randomly choose an attack method. 
     * A Leopard should also never FORFEIT.     
     *
     * @param opponent The different species met
     * @return an attack method
     */

    public Attack getAttack(String opponent){
        if ((opponent == turtleRepresentation) 
            || (confidence > confidenceCheck)){
            return Attack.ROAR;
        }
        else{
            generateAttack();
        }
        return null;
    }
    protected Attack generateAttack(){
        Random random = new Random();
        int randomAttack = random.nextInt(attackMethods);
        if (randomAttack == 0){
            return Attack.ROAR;
        }
        else if (randomAttack == 1) {
            return Attack.POUNCE;
        }
        else if (randomAttack == attackMethods - 1){
            return Attack.SCRATCH;
        }
        return null;
    }
    
    @Override
   /** changes its' display name to: lalalala~~~~    
    *
    * @param s the status of a leopard
    * @return nothing
    */
    public void buffBehavior(CritterState s){
    	this.displayName = leopardBuff;
    }
    
    @Override
   /**  change the display name back to leopard.    
    * 
    * @param s the status of a leopard
    * @return nothing
    */

    public void debuff(CritterState s){
    	this.displayName = leopardRepresentation;
    }

}
