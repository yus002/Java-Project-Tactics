import java.util.Random;

public class Feline extends Critter implements Movable {
    // for avoiding using magic numbers in getMove()
    private static final int directionNumber = 4;
    private static final int directionWest = 2;
    private static final int directionEast = 3;
    private static final int directionNorth = 0;
    private static final int directionSouth = 1;
    private static final int steps = 5;
    private static final String felineRepresentation = "Fe";

    //counter for the getMove method before random direction
    private int moveCount;
    private int eatCount; //counter for eating
    private Direction currDir; //current direction


    public Feline() { 
        super(felineRepresentation);
        // initialize the current Direction
        int randomDirection = random.nextInt(directionNumber);
        if (randomDirection == directionNorth){
            currDir = Direction.NORTH;

        }
        else if (randomDirection == directionSouth){
            currDir = Direction.SOUTH;
        }
        else if (randomDirection == directionEast){
            currDir = Direction.EAST;
    
        }

        else if (randomDirection == directionWest){
            currDir = Direction.WEST;
        }
    }

    @Override
   /** make feline asleep
    * 
    * @param s the status of a feline
    * @return nothing
    */

    public void buffBehavior(CritterState s){
        s.setAsleep(true);
    }

    @Override
   /** make feline awake
    * 
    * @param s the status of a feline
    * @return nothing
    */

    public void debuff(CritterState s){
        s.setAsleep(false);
    }

    @Override
    public Direction getMove() {
        // if feline has not moved 5 times
        // don't generate new random direction
        if (moveCount == 0){
            moveCount++;
            return currDir;
        }
        else if ((moveCount % steps) != 0){
            moveCount++;
            return currDir;
        }
        // generate a new random direction after
        // the feline has moved 5 steps
        else if ((moveCount % steps) == 0){
            int randomDirection = random.nextInt(directionNumber);
            if (randomDirection == directionNorth){
                moveCount++;
                currDir = Direction.NORTH;
            }
            else if (randomDirection == directionSouth){
                moveCount++;
                currDir = Direction.SOUTH;
            }
            else if (randomDirection == directionEast){
                moveCount++;
                currDir = Direction.EAST;
            }
            else if (randomDirection == directionWest){
                moveCount++;
                currDir = Direction.WEST;
            }      
            return currDir;        
        }
        return null;  
    }
    
    @Override
    public boolean eat() {
        eatCount = eatCount + 1;
        
        // the Critter should be full in the beginning
        if ((eatCount % steps != 0) ||(eatCount == 0)){
            return false;
        }
        else{
            return true;
        }
      
    }
    
    @Override
    public Attack getAttack(String opponent){
        return Attack.POUNCE;
    }

 
}
